/**  
 * SacnFreqDownLoadSchedulerJob.java
 * com.cmcc.optimize.datasyc.runtime
 * 
 * @author gaoqs
 * @date 2014-8-24 下午3:41:40
 * 版权所有
 */
package com.cmcc.optimize.datasyc.scheduler;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import cn.cas.common.collect.Marker;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCommonProcessDAO;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO;
import com.cmcc.optimize.dataaccess.dao.ibatis.ExtIbatisCommonProcessDAO;
import com.cmcc.optimize.dataaccess.dao.ibatis.ExtIbatisCustomProcessDAO;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClientImpl;
import com.cmcc.optimize.dataaccess.redis.GlobalCounterMarker;
import com.cmcc.optimize.dataaccess.redis.RedisConf;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;
import com.cmcc.optimize.dataaccess.util.DateUtil;
import com.cmcc.optimize.dataaccess.util.LocalFileHelper;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datamodel.sync.FtpFileMappingModel;
import com.cmcc.optimize.datamodel.sync.FtpFileTemplateModel;
import com.cmcc.optimize.datamodel.sync.mapping.ColumnMappingModel;
import com.cmcc.optimize.datamodel.sync.mapping.OraTableMappingModel;
import com.cmcc.optimize.datasyc.config.ConfigUtils;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;
import com.cmcc.optimize.datasyc.csv.CsvFileGenerateScanfreq;

/**
 * 扫频数据下载处理job
 * 
 * @author gaoqs
 * @date 2014-8-24 下午3:41:40
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SacnFreqDownLoadSchedulerJob implements Job {

    private FtpDownConfModel config;// ftp下载配置

    private static Marker marker;// redis标记

    private static final CmccLogger logger = CmccLogger.getLogger(SacnFreqDownLoadSchedulerJob.class);// 日志

    private FtpDownloadClient ftpClient;// ftp客户端

    private String appointDay = null;// 当前日期

    ExtCommonProcessDAO extCommonProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCommonProcessDAO.class, "extCommonProcessDAO"); // ibatisDao

    ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCustomProcessDAO.class, "extCustomProcessDAO");// 扩展dao

    private static final DecimalFormat df = new DecimalFormat("#.000");// 格式化double输出为3位小数

    public String[] justImportFiles;// 指定只导入符合文件名的文件，用于手工回导

    private static final SimpleDateFormat importDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 导入日期格式化

    private int originalFileNum = 1; // 原始数据文件数(TODO：文件数量暂时设置为1)

    private static final SimpleDateFormat importAppointDateFormat = new SimpleDateFormat("yyyyMMdd");// 默认日期格式化

    private static final String[] headerName = new String[] { "h1", "h2", "h3" };// 调用csv生成时的指定参数，分别对应不同的厂商

    private static final String[] genFacs = new String[] { "AIRCOM", "ACP", "ASPS" };// 生成指定厂商的名称

    /**
     * 提供给quartz调用的默认无参构造函数，参数通过jobdetailmap传入context
     */
    public SacnFreqDownLoadSchedulerJob() {
    }

    /**
     * 获取ftp的redis marker标记
     * 
     * @return
     */
    public static Marker getFtpFileProcessMarker() {
        RedisConf conf = RedisConf.getRedisConf("countermarker");
        marker = new GlobalCounterMarker(conf, FtpFileProcessConfig.FTP_FILE_PROCESS_COUNTER);
        return marker;
    }

    /**
     * 验证并删除文件，文件处理完成，并且备份完成后，删除本地文件
     * 
     * @param marker redis标记
     * @param path 本地文件路径
     * @param localTempPath 本地ftp缓存目录
     * @return 是否需要删除本地文件 true:不需要进行后续处理
     */
    public static boolean checkNeedDelete(Marker marker, String path, String localTempPath) {
        String hasProcessed = "";
        String hasBackuped = "";
        try {
            hasProcessed = marker.getMark(FtpFileProcessConfig.getRedisMarkerProcessSucc(path));
            hasBackuped = marker.getMark(FtpFileProcessConfig.getRedisMarkerBackupSucc(path));
        } catch (Exception e) {
            logger.error(e);
        }

        // 检测是否需要删除
        if (StringUtils.isBlank(hasBackuped) && StringUtils.isNotBlank(hasProcessed)) {
            return true;
        }

        if (StringUtils.isNotBlank(hasBackuped)) {
            try {
                File delFile = new File(localTempPath + path);
                if (delFile.exists() && delFile.isFile()) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("need delete local ftp　file :" + path);
                    }
                    FileUtils.forceDelete(delFile);
                }
            } catch (IOException e) {
                logger.warn("delete local file error:" + path, e);
            }
        }

        return false;
    }

    /*
     * (non-Javadoc)
     * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 从quartz job上下文中传入的参数
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        // 从cmcc2的ftp下载对应的文件，下载扫频文件，bin,opt,csv，转换csv，并入库，入库完成后，调用生成对应的结果csv文件
        doJob((FtpDownConfModel) jobDataMap.get("config"));
    }

    /**
     * 工作入口
     * 
     * @param justCount 是否生成文件(手动导入数据时用到)
     */
    public void doJob(FtpDownConfModel config) {
        if (this.config == null) {
            this.config = config;
        }

        if (marker == null) {
            marker = FtpDownLoadSchedulerJob.getFtpFileProcessMarker();
        }

        if (logger.isInfoEnabled()) {
            logger.info("execute scanfreq ftp down monitor:" + config);
        }

        ftpClient = new FtpDownloadClientImpl(true);// ftp客户端
        // 获取ftp参数配置
        String fileNameRule = config.getFileNameRule();
        String host = config.getHost();
        String password = config.getPassword();
        String port = config.getPort();
        String user = config.getUserName();
        String ftpFolder = config.getFtpFolder();
        String localFolder = config.getLocalFolder();
        appointDay = config.getAppointDay();
        boolean needListSubFolder = config.isNeedListSubFtpFiles();

        // 替换路径中的时间
        if (null == appointDay || appointDay.length() == 0) {
            ftpFolder = ConfigUtils.parseFolderDate(ftpFolder);
        } else {
            ftpFolder = ConfigUtils.parseFolderDate(ftpFolder, appointDay);
        }

        // 替换匹配规则中的时间
        if (null == appointDay || appointDay.length() == 0) {
            fileNameRule = ConfigUtils.parseFolderDate(fileNameRule).replaceAll("/", "");
        } else {
            fileNameRule = ConfigUtils.parseFolderDate(fileNameRule, appointDay).replaceAll("/", "");
        }

        // 登陆ftp服务器
        boolean isLoginSucc = ftpClient.login(host, Integer.parseInt(port), user, password);
        if (!isLoginSucc) {
            logger.error("ftp connection failed:" + config);
            ftpClient.loginOut();
            return;
        }

        // 获取目录文件列表
        List<String> files = null;
        if (needListSubFolder) {
            files = ftpClient.getFilesInFolderWithSub(ftpFolder);
        } else {
            files = ftpClient.getFilesInFolder(ftpFolder);
        }

        if (files == null || files.size() <= 0) {
            if (logger.isInfoEnabled()) {
                logger.info("not file to process:" + "@" + ftpFolder + "@" + config.getHost() + "@");
            }
            return;
        }

        // 手工回导时，删除不需要回导的文件
        ConfigUtils.deleteFile(files, justImportFiles);

        for (int i = files.size() - 1; i >= 0; i--) {// 一次性下载完所有需要下载的文件
            String fileName = files.get(i);
            String redisCheckDownLoadKey = "";
            try {
                redisCheckDownLoadKey = FtpFileProcessConfig.getRedisMarkerDownLoadSucc(localFolder + fileName);
            } catch (Exception e) {
                logger.error(e);
                files.remove(i);// 移除不需要下载的文件名
                continue;
            }
            String localFilePath = FtpFileProcessConfig.getDefaultFtpLocalCacheFolder() + localFolder + fileName;

            localFilePath = localFilePath.replace("bin/", "");

            // 验证文件名是否已经下载过
            if (StringUtils.isBlank(marker.getMark(redisCheckDownLoadKey))) {

                // 验证文件名规则是否需要下载
                String tempCheckName = fileName;
                if (tempCheckName.replace("\\", "/").contains("/")) {// 多层级文件名只校验文件名
                    tempCheckName = tempCheckName.substring(tempCheckName.lastIndexOf("/") + 1);
                }
                boolean isFileNameEnableDown = Pattern.compile(fileNameRule).matcher(tempCheckName).matches();

                if (!isFileNameEnableDown) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("file name can't be download,rule:" + fileNameRule + ",fileName:" + fileName);
                    }
                    files.remove(i);// 移除不需要下载的文件名
                    continue;
                }

                if (logger.isInfoEnabled()) {
                    logger.info("RedisKey:" + redisCheckDownLoadKey + " ,is null ，need to download file :" + fileName);
                }

                boolean isSucc = ftpClient.downLoadFile(ftpFolder + fileName, localFilePath);
                if (!isSucc) {
                    logger.error("download ftp file error:" + config + "-->" + fileName);
                    logger.notice("download ftp file error:" + config + "-->" + fileName);
                } else {
                    // 标记文件已经下载完成
                    marker.set(redisCheckDownLoadKey, "true");
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("RedisKey:" + redisCheckDownLoadKey + ", is not null，file:" + fileName + ", has been downloaded before");
                }
            }
        }

        // 登出ftp
        ftpClient.loginOut();

        // 处理本地文件
        for (String fileName : files) {
            String redisCheckProcessKey = "";
            try {
                redisCheckProcessKey = FtpFileProcessConfig.getRedisMarkerProcessSucc(localFolder + fileName);
            } catch (Exception e) {
                logger.error(e);
                continue;
            }

            String localFilePath = FtpFileProcessConfig.getDefaultFtpLocalCacheFolder() + localFolder + fileName;
            localFilePath = localFilePath.replace("bin/", "");
            // 验证文件是否已经处理过
            String key = marker.getMark(redisCheckProcessKey);
            if (StringUtils.isBlank(key)) {// || key.equals("false")) {
                if (logger.isInfoEnabled()) {
                    logger.info("RedisKey:" + redisCheckProcessKey + ",is null ，need to parse file:" + fileName);
                }

                try {
                    // 处理扫频文件
                    processFile(localFilePath);
                    // 处理完成标记
                    marker.set(redisCheckProcessKey, "true");
                } catch (Exception e) {
                    logger.error("process scanfreq file error:" + fileName, e);
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("RedisKey:" + redisCheckProcessKey + ",is not null ，file :" + fileName + ", has been handled");
                }
            }
        }
    }

    /**
     * 根据路径，解析，使用默认的传入日期
     * 
     * @param path
     * @return
     */
    public boolean processFile(String path) {
        return processFile(path, null, 10000);
    }

    /**
     * 计算补全扫频需要的数据
     * 
     * @param date 日期
     * @return
     */
    public boolean executeFullCompute(String date) {
        if (StringUtils.isBlank(date)) {
            return false;
        }

        if (logger.isDebugEnabled()) {
            logger.debug("executeFullCompute start:" + date);
        }

        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("today", date);

            extCustomProcessDAO.queryForObject("CALL_PROC_SCANFREQ_CELL_PROCEDURE", params);

        } catch (Exception e) {
            logger.error("executeFullCompute error:" + date, e);
        }

        return true;
    }

    /**
     * 生成csv结果文件
     * 
     * @param date
     * @return
     */
    public boolean genResultFile(String date, String city, String grid) {
        if (StringUtils.isBlank(date)) {
            return false;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("genResultFile start:" + date);
        }

        try {
            // 按地市，网格分组，查询指定日期的数据
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("startTime", DateUtil.dtFormat(importAppointDateFormat.parse(date), DateUtil.simple));
            params.put("endTime", DateUtil.dtFormat(DateUtil.addHours(importAppointDateFormat.parse(date), 24), DateUtil.simple));
            params.put("city", city);
            params.put("grid", grid);

            // 查询出record_time范围内的test_time，按 test_time生成指定日期的文件
            List<Map<String, Object>> testTimeList = extCustomProcessDAO.getMapList("MULTI-QUERY-SCANFREQ-TIME-CITY-GRID-SYSDATE-SQL-LIST-WITH-MAPPING-PAGING", params);
            if (testTimeList == null) {
                return true;
            }

            for (Map<String, Object> tMap : testTimeList) {
                String testTime = tMap.get("TEST_TIME").toString();// 扫频时间，按指定回导日期重新生成各个扫频日期的文件 yyyyMMdd

                params.put("testStartTime", DateUtil.dtFormat(importAppointDateFormat.parse(testTime), DateUtil.simple));
                params.put("testEndTime", DateUtil.dtFormat(DateUtil.addHours(importAppointDateFormat.parse(testTime), 24), DateUtil.simple));
                params.put("city", city);
                params.put("grid", grid);

                List<Map<String, Object>> groupDcs = extCustomProcessDAO.getMapList("MULTI-QUERY-SCANFREQ-CITY-GRID-SYSDATE-SQL-LIST-WITH-MAPPING-PAGING", params);
                if (groupDcs == null) {
                    return true;
                }

                /*
                 * for (Map<String, Object> map : groupDcs) { String city = map.get("CITY") == null ? "" :
                 * map.get("CITY").toString(); String grid = map.get("GRID") == null ? "" : map.get("GRID").toString();
                 * int count = map.get("COUNT") == null ? 0 : Integer.parseInt(map.get("COUNT").toString()); try { for
                 * (int i = 0; i < 3; i++) { String header = headerName[i]; String fac = genFacs[i];// 厂商 // 按地市，网格生成文件
                 * CsvFileGenerateScanfreq csvGen = new CsvFileGenerateScanfreq(); String filePath =
                 * CsvFileGenerateScanfreq.DEFAULT_FTP_FOLDER + testTime + "/export/Scan_" + fac + "_" + city + "_" +
                 * grid + "_" + testTime + ".csv"; if (logger.isInfoEnabled()) {
                 * logger.info("start gen result csv file:" + filePath); } csvGen.generateCsv(filePath, city, grid,
                 * header, count, null, null, params.get("testStartTime").toString(),
                 * params.get("testEndTime").toString()); } } catch (Exception e) {
                 * logger.error("gen result csv file error:" + map.get("startTime") + "@" + city + "@" + grid + "@" +
                 * count + "@" + testTime, e); } }
                 */
                for (Map<String, Object> map : groupDcs) {
                    int count = map.get("COUNT") == null ? 0 : Integer.parseInt(map.get("COUNT").toString());
                    try {
                        for (int i = 0; i < 3; i++) {
                            String header = headerName[i];
                            String fac = genFacs[i];// 厂商
                            // 按地市，网格生成文件
                            CsvFileGenerateScanfreq csvGen = new CsvFileGenerateScanfreq();
                            String filePath = CsvFileGenerateScanfreq.DEFAULT_FTP_FOLDER + testTime + "/export/Scan_" + fac + "_" + city + "_" + grid + "_" + testTime + ".csv";
                            if (logger.isInfoEnabled()) {
                                logger.info("start gen result csv file:" + filePath);
                            }
                            csvGen.generateCsv(filePath, city, grid, header, count, null, null, params.get("testStartTime").toString(), params.get("testEndTime").toString());
                        }
                    } catch (Exception e) {
                        // logger.error("gen result csv file error:" + map.get("startTime") + "@" + city + "@" + grid +
                        // "@" + count + "@" + testTime, e);
                        logger.error("gen result csv file error:" + params.get("testStartTime") + "@" + city + "@" + grid + "@" + count + "@" + testTime, e);
                    }
                }

            }

        } catch (Exception e) {
            logger.error("genResultFile error:" + date, e);
        }

        return true;
    }

    /**
     * 根据路径，解析
     * 
     * @param path
     * @param day 指定日期
     * @param batchCommitNums 单次提交到数据库的批次数
     * @return
     */
    public boolean processFile(String path, String day, int batchCommitNums) {
        // 存储该批次的行集合
        List<String> lines;
        Map<String, Integer> countMap = null;// 按时间，地域统计的map
        FtpFileTemplateModel templateModel = null;// 处理的映射模板
        String cleanDay = null;// 清理数据时间
        LocalFileHelper fileHelper = new LocalFileHelper();// 本地文件读取

        try {
            // 处理指定日期，用于分区删除文件，eclipse中调用导入数据保证删除指定的分区正确
            if (StringUtils.isNotBlank(day) && StringUtils.isBlank(appointDay)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("use day for appointDay:" + day);
                }
                appointDay = day;
            }

            // 获得模板处理文件映射关系对象
            FtpFileMappingModel mappingModel = FtpFileProcessConfig.getFileMappingTypeByPath(path);

            // 获取解析模板
            templateModel = FtpFileProcessConfig.getFileTemplateMapByPath(path);
            if (templateModel == null) {
                logger.warn("Can't Find Template For File: " + path);
                return false;
            }

            File file = new File(path);// 文件不存在则不处理
            if (file == null || !file.exists() || file.isDirectory()) {
                logger.warn("Can't Find file or file is a folder in path: " + path);
                return false;
            }

            // 记录rownum
            int rowNum = templateModel.getIgnoreRows();

            boolean processFileHasError = false;// 处理文件是否有错误

            if (mappingModel.isNeedCount()) {// 按时间，地域统计，初始化map对象
                countMap = new HashMap<String, Integer>();
            }

            int ignoreRows = FtpFileProcessConfig.getFileTemplateMapByPath(path).getIgnoreRows();// 忽略的文件头行数
            fileHelper.setBatchSize(batchCommitNums);// 设置一次读取行数
            fileHelper.setCsvEncoding(mappingModel.getEncoding());// 设置文件编码

            // 定义是否需要重新生成csv
            boolean isNeedCreateCsv = false;
            String date = "";
            // 按批次从file中读取数据
            while ((lines = fileHelper.getNextBatchLines(path, ignoreRows)) != null && lines.size() > 0) {
                // 初始化
                for (OraTableMappingModel tableMapping : templateModel.getTableMapping()) {
                    tableMapping.setInsertValues(new ArrayList<List<Object>>());
                }

                // 遍历当前行集合
                for (String line : lines) {
                    String[] cells = null;

                    // 行号++
                    rowNum++;

                    // 拆解列
                    try {
                        cells = getCsvColumnValues(line, templateModel.getSplitString());
                    } catch (Exception e) {
                        // 出现错误的时候丢弃该行
                        logger.error("解析行文件时出错，请检查源文件：" + path + "，行记录：" + line, e);
                        processFileHasError = true;
                        continue;
                    }

                    // 按时间统计,时间+地域做为key，统计按时间，地域的个数
                    if (mappingModel.isNeedCount()) {
                        try {
                            String time = "";
                            if (StringUtils.isNotBlank(cells[mappingModel.getTimceCountIndex()])) {
                                date = cells[mappingModel.getTimceCountIndex()];
                                time = date.substring(0, mappingModel.getTimeCountFormat().length()).trim();// 指定取时间的前几位进行统计，按小时，分钟等
                            } else {
                                time = date.substring(0, mappingModel.getTimeCountFormat().length()).trim();;
                                cells[mappingModel.getTimceCountIndex()] = date;
                            }
                            String area = "";
                            if (mappingModel.getAreaCountIndex() >= 0) {
                                area = cells[mappingModel.getAreaCountIndex()].trim();
                            }

                            if (area == null) {
                                area = "";
                            }

                            if (StringUtils.isBlank(time)) {
                                logger.warn("time count ,time string is blank:" + line + "@" + rowNum);
                            } else {
                                String key = time + "," + area;
                                if (countMap.get(key) == null) {
                                    countMap.put(key, 1);
                                } else {
                                    countMap.put(key, countMap.get(key) + 1);
                                }
                            }
                        } catch (Exception e) {
                            logger.error("time count error:" + line + "@rowCount:" + rowNum, e);
                        }
                    }

                    // 构造多表入库数据
                    for (OraTableMappingModel tableMapping : templateModel.getTableMapping()) {
                        // 验证列是否匹配
                        if (templateModel.getColumnNums() > 0 && cells.length != templateModel.getColumnNums()) {
                            logger.warn("column nums not equals，row:" + rowNum + ",need:" + templateModel.getColumnNums() + ",actal:" + cells.length + ",filepath:" + path);
                            processFileHasError = true;
                            continue;
                        }

                        // 存储一行的数据
                        List<Object> oneRowValues = new ArrayList<Object>(tableMapping.getColumns().size());
                        // 构造values
                        boolean flag = true;
                        // Set timeSet = new HashSet();
                        for (ColumnMappingModel colMapModel : tableMapping.getColumns()) {
                            // 检查数据有效性
                            Object insertObj = null;
                            try {
                                insertObj = colMapModel.getInsertValue(path, cells);
                                if (colMapModel.checkValue(cells)) {
                                    oneRowValues.add(insertObj);
                                } else {
                                    logger.warn("Illegal column data checked by rule,tableName:" + tableMapping.getTableName() + ",csv linenumber：" + rowNum + ",dbColumnNmae:" + colMapModel.getDbColumn() + ",csvIndex:" + colMapModel.getColIndex() + ",rule:【" + colMapModel.getRuleValid() + "】,check value:【" + insertObj
                                            + "】,line string:【" + line + "】");
                                    processFileHasError = true;
                                    flag = false;
                                    break;
                                }
                            } catch (Exception e) {
                                logger.warn("add insert date error,tableName:" + tableMapping.getTableName() + ",csv linenumber：" + rowNum + ",dbColumnNmae:" + colMapModel.getDbColumn() + ",csvIndex:" + colMapModel.getColIndex() + ",rule:【" + colMapModel.getRuleValid() + "】,check value:【" + insertObj
                                        + "】,line string:【" + line + "】");
                                processFileHasError = true;
                                flag = false;
                                break;
                            }
                        }

                        if (!flag) {
                            continue;
                        }

                        // 填入每一行
                        tableMapping.getInsertValues().add(oneRowValues);
                    }
                }

                // 入库
                for (OraTableMappingModel tableMapping : templateModel.getTableMapping()) {
                    boolean insertResult = insert(tableMapping.getTableName(), tableMapping.getColumnNames(), tableMapping.getInsertValues(), batchCommitNums);

                    // 有数据入库，需要新生成文件和计算
                    // 只要有一次插入成功就需要重新生成文件
                    if (insertResult && tableMapping.getInsertValues().size() > 0) {
                        isNeedCreateCsv = true;
                    }
                    tableMapping.getInsertValues().clear();
                    tableMapping.setInsertValues(null);
                }

                lines.clear();
                lines = null;
            }

            // 生成csv
            // 获取城市和网格
            if (isNeedCreateCsv) { // 需要重新生成csv文件
                String needProcessDate = importAppointDateFormat.format(new Date());
                if (logger.isInfoEnabled()) {
                    logger.info("needReCreateFileAndCompute：" + needProcessDate);
                }

                // 调用计算小区信息的存储过程
                boolean isSucc = executeFullCompute(needProcessDate);
                if (!isSucc) {
                    logger.warn("executeFullCompute fail:" + needProcessDate);
                }

                String filename = file.getName();
                HashMap<String, String> hashMap = getCityGridByName(filename);
                String city = hashMap.get("city");
                String grid = hashMap.get("grid");

                isSucc = genResultFile(needProcessDate, city, grid);
                if (!isSucc) {
                    logger.warn("genResultFile fail:" + needProcessDate);
                }
            }

            if (processFileHasError) {// 处理文件出错预警
                logger.warn("process ftp file has errors，please check logs:" + path);
                logger.notice("process ftp file has errors，please check logs:" + path);
            }

            // 清理数据
            if (null == appointDay || appointDay.length() == 0) {
                // 如果没有指定入库日期，取当前日期的前一天
                cleanDay = importDateFormat.format(DateUtils.addDays(new Date(), -1));
            } else {
                try {
                    cleanDay = importDateFormat.format(DateUtils.addDays((importAppointDateFormat.parse(appointDay)), -1));
                } catch (Exception e) {
                    logger.error("parse data failed,", e);
                }
            }

            if (logger.isDebugEnabled()) {
                logger.debug("clean multi datas in databses with day:" + cleanDay);
            }

            // 清理多个表的重复数据
            for (OraTableMappingModel tableMapping : templateModel.getTableMapping()) {
                cleanMultiData(tableMapping.getTableName(), cleanDay);
            }

            // 存入统计表
            if (mappingModel.isNeedCount()) {// 需要进行统计 ，按时间地域统计
                for (Entry<String, Integer> entry : countMap.entrySet()) {
                    String keyInfos[] = StringUtils.splitPreserveAllTokens(entry.getKey(), ",");
                    String time = keyInfos[0];
                    String area = keyInfos[1];
                    if (StringUtils.isBlank(area)) {
                        area = file.getName().split("_")[2];

                    }
                    int counts = entry.getValue();// 合并后，同一个时间点，同一个地域上的数据量

                    List<Object> valueList = new ArrayList<Object>();
                    try {
                        valueList.add(mappingModel.getTimeDateFormat(time));
                    } catch (ParseException e) {
                        valueList.add(new Date());
                        logger.error("date time parser error:" + time + "@" + mappingModel.getTemplateParserFile(), e);
                    }
                    valueList.add(mappingModel.getType());
                    valueList.add(mappingModel.getProvince());
                    valueList.add(area);
                    valueList.add(mappingModel.getDataGeneration());
                    valueList.add(String.valueOf(counts));
                    valueList.add(String.valueOf(originalFileNum));
                    String fileSize = String.valueOf(df.format(file.length() * 1.0 / 1024.0 / 1024.0));
                    valueList.add(fileSize.indexOf(".") == 0 ? "0" + fileSize : fileSize);// 暂写全文件大小，单位mb
                    valueList.add(mappingModel.getProvider() + ":" + file.getName());

                    if (logger.isDebugEnabled()) {
                        logger.debug("save count info with time&area to table:MB_BIN_PROCESS_INFO," + file.getName() + ",recordTime:" + time + ",area:" + area);
                    }

                    boolean isSucc = extCommonProcessDAO.insert(FtpFileMappingModel.countTableName, FtpFileMappingModel.countTableColumNames, valueList);
                    if (!isSucc) {
                        logger.warn("insert count table with time&area  fail:" + file.getName());
                    }
                }
            }

            // 按小时，城市 统计话统数据和路测数据
            if (mappingModel.isTimeCountFlag()) {
                // 调用数据统计存储过程：proc_data_num_hour('20140519 22','20140719 23'，'1')
                Map<String, Object> params = new HashMap<String, Object>();
                try {
                    // 按小时调用统计，当前日期到下天日期
                    String endDay = importDateFormat.format(DateUtils.addDays((importDateFormat.parse(cleanDay)), 1)) + " 00";
                    params.put("startHour", mappingModel.getProduceTimeFormat(cleanDay + " 00"));
                    params.put("endHour", mappingModel.getProduceTimeFormat(endDay));// 开始结束设置一样，由存储过程处理
                    params.put("typeStr", mappingModel.getProduceTypeIndex());
                    extCustomProcessDAO.queryForObject("CALL_PROC_DATA_NUM_HOUR_PROCEDURE", params);
                } catch (ParseException e) {
                    logger.error("date time parser error:" + cleanDay, e);
                }

            }

            if (mappingModel.isNeedCount() && !mappingModel.isTimeCountFlag()) {// 按天统计存储过程
                try {
                    // 调用数据统计存储过程:proc_data_num();
                    extCustomProcessDAO.queryForObject("CALL_PROC_DATA_NUM_PROCEDURE", null);
                    // }
                } catch (Exception e) {
                    logger.error("execute date count produce with time&area error:", e);
                }
            }
        } catch (Exception e) {
            logger.error("process file error:" + path + "@" + day + "@" + batchCommitNums, e);
        } finally {

            // 重置reader
            fileHelper.br = null;

            templateModel = null;
            // 清空统计对象
            if (countMap != null) {
                countMap.clear();
                countMap = null;
            }

            // 关闭文件流
            fileHelper.closeStreams();
            fileHelper = null;
        }
        return true;
    }

    /**
     * DB入库操作
     * 
     * @param tableName 表名
     * @param columnList　列队列
     * @param valueList　值队列
     * @param batchCommitNums　批量提交的记录量
     * @return
     */
    private boolean insert(String tableName, List<String> columnList, List<List<Object>> valueList, int batchCommitNums) {
        if (logger.isDebugEnabled()) {
            logger.debug("insert batchNum:" + valueList.size());
        }
        boolean insertResult = false;

        // 调用批量入库操作
        try {
            insertResult = extCommonProcessDAO.batchCommonInsertSingle(tableName, columnList, valueList, batchCommitNums);
        } catch (Exception e) {
            logger.debug("Insert Failed : ", e);
            return false;
        }

        if (logger.isDebugEnabled() && !insertResult) {
            // 记录插入失败行
            logger.debug("Insert Failed : " + insertResult);
        }
        return insertResult;

    }

    /**
     * 解析csv行中每列的值
     * 
     * @param line
     * @return
     */
    private String[] getCsvColumnValues(String line, String split) {
        String[] contents = StringUtils.splitPreserveAllTokens(line, split);
        List<String> result = new ArrayList<String>();
        int idx = 0;
        String tmp = null;
        while (idx < contents.length) {
            if (null != tmp) {
                // 进入列中含有逗号的处理流程
                tmp = tmp + split + contents[idx];
                if (tmp.trim().endsWith("\"")) {
                    tmp = tmp.trim();
                    result.add(tmp.substring(1, tmp.length() - 1));
                    tmp = null;
                }
            } else {
                // 判定是否为"开始
                if (contents[idx].startsWith("\"")) {
                    // 判定是否双侧引号中没有,分隔符 , 如"aaaaa"
                    if (!contents[idx].trim().endsWith("\"")) {
                        tmp = contents[idx];
                    } else {
                        // 去除双侧引号
                        String val = contents[idx].trim();
                        result.add(val.substring(1, val.length() - 1));
                    }
                } else {
                    result.add(contents[idx].trim());
                }
            }
            idx++;
        }
        return result.toArray(new String[result.size()]);
    }

    /**
     * 清理重复数据
     * 
     * @param tableName
     * @param day
     */
    private void cleanMultiData(String tableName, String day) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("table", tableName);
        params.put("day", day);

        extCustomProcessDAO.queryForObject("DAY-DATA-MULTI-CLEAN-PROCEDURE", params);
    }

    /**
     * 
     */
    private HashMap<String, String> getCityGridByName(String filename) {

        // filename 例子格式：Scan_BIN_巴中_网格2_20140916-1.csv
        HashMap<String, String> hashMap = new HashMap<String, String>();
        //
        if (filename.indexOf(".") != -1) {
            String[] name = filename.split("/.");
            String nameString = name[0]; // 格式Scan_BIN_巴中_网格2_20140916-1
            try {
                String[] value = nameString.split("_");
                hashMap.put("city", value[2]);
                hashMap.put("grid", value[3]);
            } catch (Exception e) {
                logger.warn("process ftp fileName has errors，please check filenamevalue logs:" + e);
            }

        } else {
            logger.warn("process ftp fileName has errors，please check filename logs:" + filename);
        }

        return hashMap;

    }

}
