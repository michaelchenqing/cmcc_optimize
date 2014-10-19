/**  
 * FtpDownLoadSchedulerJob.java
 * com.cmcc.optimize.datasyc.runtime
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午4:08:01
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
import com.cmcc.optimize.dataaccess.util.LocalFileHelper;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datamodel.sync.FtpFileMappingModel;
import com.cmcc.optimize.datamodel.sync.FtpFileTemplateModel;
import com.cmcc.optimize.datamodel.sync.mapping.ColumnMappingModel;
import com.cmcc.optimize.datamodel.sync.mapping.OraTableMappingModel;
import com.cmcc.optimize.datasyc.config.ConfigUtils;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;

/**
 * ftp下载定时调度
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午4:08:01
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class FtpDownLoadSchedulerJob implements Job {

    private FtpDownConfModel config;// ftp下载配置

    private static Marker marker;// redis标记

    private static final CmccLogger logger = CmccLogger.getLogger(FtpDownLoadSchedulerJob.class);// 日志

    private FtpDownloadClient ftpClient;// ftp客户端

    private String appointDay = null;// 当前日期

    private int originalFileNum = 1; // 原始数据文件数(TODO：文件数量暂时设置为1)

    ExtCommonProcessDAO extCommonProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCommonProcessDAO.class, "extCommonProcessDAO"); // ibatisDao

    ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCustomProcessDAO.class, "extCustomProcessDAO");

    private static final DecimalFormat df = new DecimalFormat("#.000");// 格式化double输出为3位小数

    private static final SimpleDateFormat importDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 导入日期格式化

    private static final SimpleDateFormat importAppointDateFormat = new SimpleDateFormat("yyyyMMdd");// 默认日期格式化

    public boolean justCount;// true时，只进行统计，真实数据不进行入库，用于手工回导

    public String[] justImportFiles;// 指定只导入符合文件名的文件，用于手工回导

    /**
     * 提供给quartz调用的默认无参构造函数，参数通过jobdetailmap传入context
     */
    public FtpDownLoadSchedulerJob() {
    }

    /**
     * 获取ftp的redis marker标记
     * 
     * @return
     */
    public static Marker getFtpFileProcessMarker() {
        RedisConf conf = RedisConf.getRedisConf("countermarker");
        if (marker == null) {
            marker = new GlobalCounterMarker(conf, FtpFileProcessConfig.FTP_FILE_PROCESS_COUNTER);
        }
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
        if (StringUtils.isNotBlank(hasProcessed) && StringUtils.isBlank(hasBackuped)) {
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
        FtpDownConfModel ftpConfig = (FtpDownConfModel) jobDataMap.get("config");
        try {
            doJob(ftpConfig);
        } catch (Exception e) {
            logger.error("process ftp job error:" + ftpConfig, e);
        }
    }

    /**
     * 工作任务入口
     * 
     * @param config
     */
    public void doJob(FtpDownConfModel config) {
        if (this.config == null) {
            this.config = config;
        }

        if (logger.isInfoEnabled()) {
            logger.info("execute ftp down monitor:" + config);
        }

        if (marker == null) {
            marker = getFtpFileProcessMarker();
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

        // 如果不是特定日期数据入库，替换时间变量
        if (null == appointDay || appointDay.length() == 0) {
            // 替换变量名中的时间变量
            ftpFolder = ConfigUtils.parseFolderDate(ftpFolder);
        } else {
            ftpFolder = ConfigUtils.parseFolderDate(ftpFolder, appointDay);
        }

        // 替换匹配规则中的时间
        if (null == appointDay || appointDay.length() == 0) {
            // 替换变量名中的时间变量
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

            String redisCheckDownLoadKey = "";
            try {
                redisCheckDownLoadKey = FtpFileProcessConfig.getRedisMarkerDownLoadSucc(localFolder + fileName);
            } catch (Exception e) {
                logger.error(e);
                files.remove(i);// 移除不需要下载的文件名
                continue;
            }
            String localFilePath = FtpFileProcessConfig.getDefaultFtpLocalCacheFolder() + localFolder + fileName;

            // 验证文件名是否已经下载过
            if (StringUtils.isBlank(marker.getMark(redisCheckDownLoadKey))) {
                if (logger.isInfoEnabled()) {
                    logger.info("RedisKey[" + redisCheckDownLoadKey + "]is null ，need to download file [" + fileName + "]");
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
                files.remove(i);// 移除不需要下载的文件名
                if (logger.isInfoEnabled()) {
                    logger.info("RedisKey[" + redisCheckDownLoadKey + "] is not null，file [" + fileName + "] has been downloaded before");
                }
            }
        }

        // 登出ftp
        ftpClient.loginOut();

        if (files == null || files.size() <= 0) {
            if (logger.isInfoEnabled()) {
                logger.info("no files to process：" + config.getFileNameRule());
            }
            return;
        }

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

            String isExist = marker.getMark(redisCheckProcessKey);

            // 验证文件是否已经处理过
            if (StringUtils.isBlank(isExist)) {// || isExist.equals("false")) {
                if (logger.isInfoEnabled()) {
                    logger.info("RedisKey:" + redisCheckProcessKey + ", is null ，need to parse file:" + fileName);
                }
                // 文件解析处理, 设置标记
                if (processFile(localFilePath)) {
                    marker.set(redisCheckProcessKey, "true");
                } else {
                    marker.set(redisCheckProcessKey, "false");
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("RedisKey:" + redisCheckProcessKey + ", is not null ，file :" + fileName + ", has been handled");
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
                            String time = cells[mappingModel.getTimceCountIndex()].substring(0, mappingModel.getTimeCountFormat().length()).trim();// 指定取时间的前几位进行统计，按小时，分钟等

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
                    if (!justCount) {
                        insert(tableMapping.getTableName(), tableMapping.getColumnNames(), tableMapping.getInsertValues(), batchCommitNums);
                        tableMapping.getInsertValues().clear();
                        tableMapping.setInsertValues(null);
                    }
                }

                lines.clear();
                lines = null;
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
                if (!justCount) {
                    cleanMultiData(tableMapping.getTableName(), cleanDay);
                }
            }

            // 存入统计表
            if (mappingModel.isNeedCount()) {// 需要进行统计 ，按时间地域统计
                for (Entry<String, Integer> entry : countMap.entrySet()) {
                    String keyInfos[] = StringUtils.splitPreserveAllTokens(entry.getKey(), ",");
                    String time = keyInfos[0];
                    // TODO 出现过数组越界异常 java.lang.ArrayIndexOutOfBoundsException: 1
                    String area = keyInfos[1];
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
            if (!justCount) {
                if (mappingModel.isTimeCountFlag()) {
                    // 调用数据统计存储过程：proc_data_num_hour('20140519 22','20140719 23'，'1')
                    Map<String, Object> params = new HashMap<String, Object>();
                    try {
                        // 按小时调用统计，当前日期到下天日期
                        String endDay = importDateFormat.format(DateUtils.addDays((importDateFormat.parse(cleanDay)), 1));

                        params.put("startHour", importAppointDateFormat.format(importDateFormat.parse(cleanDay)) + " 00");
                        params.put("endHour", importAppointDateFormat.format(importDateFormat.parse(endDay)) + " 00");// 开始结束设置一样，由存储过程处理

                        /*
                         * params.put("startHour", importAppointDateFormat.format(cleanDay + " 00"));
                         * params.put("endHour", importAppointDateFormat.format(endDay + " 00"));// 开始结束设置一样，由存储过程处理
                         */
                        /*
                         * params.put("startHour",datetimeFormat(cleanDay + " 00")); params.put("endHour",
                         * datetimeFormat(endDay));// 开始结束设置一样，由存储过程处理
                         */params.put("typeStr", mappingModel.getProduceTypeIndex());
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
            }

            // 手机测速文件，单独调用统计存储过程
            boolean needEexectMobileSpeed = false;
            int type = 0;// 计算的文件类型
            // sichuan_lte_st_(ftp|http|ping|video)_ty_
            if (StringUtils.contains(path, "sichuan_lte_st_ftp_ty_")) {
                needEexectMobileSpeed = true;
                type = 1;
            } else if (StringUtils.contains(path, "sichuan_lte_st_http_ty_")) {
                needEexectMobileSpeed = true;
                type = 2;
            } else if (StringUtils.contains(path, "sichuan_lte_st_ping_ty_")) {
                needEexectMobileSpeed = true;
                type = 3;
            } else if (StringUtils.contains(path, "sichuan_lte_st_video_ty_")) {
                needEexectMobileSpeed = true;
                type = 4;
            }

            if (needEexectMobileSpeed) {
                if (logger.isInfoEnabled()) {
                    logger.info("execute mobile speed produce:" + path + "@" + appointDay);
                }
                // call proc_st_data_statistics('20140827','4') ，手机测速入库完成后调用， 参数第一个是日期，第二个是类别（ftp,http,ping,video） 分别对应
                // 1,2,3,4

                Map<String, Object> params = new HashMap<String, Object>();
                params.put("today", appointDay);
                params.put("fileType", String.valueOf(type));

                extCustomProcessDAO.queryForObject("CALL_PROC_ST_DATA_STATISTICS_PROCEDURE", params);
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
                        // 判断特殊情况,例子：",37900"，分割开只有 一个"
                        if (val.equals("\"")) {
                            tmp = val;
                        } else {
                            result.add(val.substring(1, val.length() - 1));
                        }
                    }
                } else {
                    // String ri =contents[idx].trim();
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
}
