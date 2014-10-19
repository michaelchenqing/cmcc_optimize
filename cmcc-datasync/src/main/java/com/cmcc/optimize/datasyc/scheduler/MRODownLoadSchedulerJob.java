/**  
 * MRODownLoadSchedulerJob.java
 * com.cmcc.optimize.datasyc.runtime
 * 
 * @author peng
 * @date 2014-7-28 下午8:41:40
 * 版权所有
 */
package com.cmcc.optimize.datasyc.scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.lang.StringUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import cn.cas.common.collect.Marker;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCommonProcessDAO;
import com.cmcc.optimize.dataaccess.dao.ibatis.ExtIbatisCommonProcessDAO;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClientImpl;
import com.cmcc.optimize.dataaccess.redis.GlobalCounterMarker;
import com.cmcc.optimize.dataaccess.redis.RedisConf;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datamodel.sync.FtpFileMappingModel;
import com.cmcc.optimize.datasyc.config.ConfigUtils;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;

/**
 * MRO下载定时调度
 * 
 * @author peng
 * @date 2014-7-28 下午8:41:40
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class MRODownLoadSchedulerJob implements Job {

    private FtpDownConfModel config;// ftp下载配置

    private static Marker marker;// redis标记

    private static final CmccLogger logger = CmccLogger.getLogger(MRODownLoadSchedulerJob.class);// 日志

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // 年月日，格式化

    private FtpDownloadClient ftpClient;// ftp客户端

    private String appointDay = null;// 当前日期

    ExtCommonProcessDAO extCommonProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCommonProcessDAO.class, "extCommonProcessDAO"); // ibatisDao

    // private static final HdfsUploadFile hdfsUpload = new HdfsUploadFileImpl();// hdfs上传

    private static final DecimalFormat df = new DecimalFormat("#.000");// 格式化double输出为3位小数

    public String[] justImportFiles;// 指定只导入符合文件名的文件，用于手工回导

    /**
     * 提供给quartz调用的默认无参构造函数，参数通过jobdetailmap传入context
     */
    public MRODownLoadSchedulerJob() {
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
        FtpDownConfModel config = (FtpDownConfModel) jobDataMap.get("config");

        if (marker == null) {
            marker = FtpDownLoadSchedulerJob.getFtpFileProcessMarker();
        }

        String markerDate = format.format(new Date());

        String redisCheckReplenishKey = null;
        try {
            // redis标记 比如今天是2014-09-24 则为mroReplenish20140924z
            redisCheckReplenishKey = FtpFileProcessConfig.getRedisMarkerReplenishSucc(config.getFtpFolder() + markerDate);
        } catch (Exception e) {
            logger.warn("get RedisMarkerReplenishSucc error", e);
        }
        if (StringUtils.isBlank(marker.getMark(redisCheckReplenishKey))) {
            // 开始补采
            Date yesterday = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
            String bcdate = format.format(yesterday); // 补采时间20140923

            config.setAppointDay(bcdate); // 设置补采日期
            doJob(config);
            // 标记文件已经下载完成
            marker.set(redisCheckReplenishKey, "true");
        }
        config.setAppointDay(null);
        // 正常采集
        doJob(config);
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
        
        if (marker == null) {
            marker = FtpDownLoadSchedulerJob.getFtpFileProcessMarker();
        }

        if (logger.isInfoEnabled()) {
            logger.info("execute ftp down monitor:" + config);
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
            fileNameRule = ConfigUtils.parseFolderDate(fileNameRule, 15);
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

            // 验证文件名是否已经下载过
            if (StringUtils.isBlank(marker.getMark(redisCheckDownLoadKey))) {

                if (logger.isInfoEnabled() && i % 100 == 0) {
                    logger.info("RedisKey:" + redisCheckDownLoadKey + ", is null ，need to download file:" + fileName + ", the remaining files:" + i);
                }

                String localFilePath = localFolder + getFilePath(fileName);
                boolean isSucc = ftpClient.downLoadFile(ftpFolder + "/" + fileName, localFilePath);
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

        // 统计文件大小
        // int fileSize = 0;
        Map<String, Integer> countFileNum = new HashMap<String, Integer>();
        Map<String, Long> countFileSize = new HashMap<String, Long>();

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

            // 验证文件是否已经处理过
            String key = marker.getMark(redisCheckProcessKey);
            if (StringUtils.isBlank(key)) {// || key.equals("false")) {
                if (logger.isDebugEnabled()) {
                    logger.debug("RedisKey:" + redisCheckProcessKey + " , is null ，need to parse file:" + fileName);
                }

                try {
                    // 1.读取mro的文件，解析出日期
                    String date = fileName.split("_")[5].substring(0, 8);

                    String localFilePath = localFolder + getFilePath(fileName);

                    File file = new File(localFilePath);// 文件不存在则不处理
                    if (file == null || !file.exists() || file.isDirectory()) {
                        logger.warn("Can't Find file or file is a folder in path: " + localFilePath);
                        continue;
                    }

                    Object number = countFileNum.get(date);
                    if (number == null) {
                        countFileNum.put(date, 1);
                    } else {
                        countFileNum.put(date, 1 + (Integer) number);
                    }

                    Object fileSize = countFileSize.get(date);
                    if (number == null) {
                        countFileSize.put(date, file.length());
                    } else {
                        countFileSize.put(date, file.length() + (Long) fileSize);
                    }

                    marker.set(redisCheckProcessKey, "true");
                } catch (Exception e) {
                    logger.error("process mro file error:" + fileName, e);
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("RedisKey:" + redisCheckProcessKey + ", is not null ，file :" + fileName + ",has been handled");
                }
            }
        }

        for (Entry<String, Long> entry : countFileSize.entrySet()) {
            boolean blag = processFile(entry.getKey(), countFileNum.get(entry.getKey()), entry.getValue(), fileNameRule);
            if (!blag) {
                logger.error("handle mro file error:" + config + "-->" + entry.getKey());
                logger.notice("handle mro file error:" + config + "-->" + entry.getKey());
            } else {
                logger.info("mro data handle succ,file num is:" + countFileNum.get(entry.getKey()));
            }
        }

    }

    /**
     * 处理单个mro文件
     * 
     * @param file　mro文件
     */
    private boolean processFile(String date, int fileNum, long fileSize, String fileName) {

        List<Object> valueList = new ArrayList<Object>();
        try {
            valueList.add(format.parse(date));
        } catch (ParseException e) {
            valueList.add(new Date());// 出错，使用当前日期
            logger.error("parse mro file date time error:" + date);
        }

        valueList.add("MRO");// 数据类型
        valueList.add(null);// 省为空
        valueList.add(null);// 市为空
        valueList.add("MRO");// data_generation
        valueList.add(null);// original_record_num
        valueList.add(fileNum);// original_file_num
        String temp = df.format(fileSize * 1.0 / 1024.0 / 1024.0);
        valueList.add(temp.indexOf(".") == 0 ? "0" + temp : temp);// 暂写全文件大小，单位mb
        valueList.add(date + "-" + fileName.split("_")[2]);// data_origin

        boolean isSucc = extCommonProcessDAO.insert(FtpFileMappingModel.countTableName, FtpFileMappingModel.countTableColumNames, valueList);
        if (!isSucc) {
            logger.warn("save mro count data error:" + fileName);
        }

        // 3.检测缓存中是否存在
        // String redisCheckKey = null;
        //
        // try {
        // redisCheckKey = FtpFileProcessConfig.getRedisMarkerBackupSucc(file.getName());
        // } catch (Exception e) {
        // logger.error("get redis key error:" + file.getName(), e);
        // }
        //
        // String cacheValue = marker.getMark(redisCheckKey);
        // if (StringUtils.isNotBlank(cacheValue) && StringUtils.equals("true", cacheValue)) {
        // if (logger.isDebugEnabled()) {
        // logger.debug("mro file has back up success:" + file.getName());
        // }
        // return false;
        // }
        //
        // 4.备份到hdfs中，使用统一的备份
        // String hdfsPath = "mro/" + date.substring(0, 4) + "/" + date + "/" + file.getName();//
        // mro/2014/20140801/sichuan_tdlte_mro_zte_20140801.tar.gz
        //
        // String resultPath = null;
        // try {
        // resultPath = hdfsUpload.createFile(hdfsPath, new FileInputStream(file));
        // } catch (FileNotFoundException e) {
        // logger.error("mro file not found :" + file.getName(), e);
        // }
        //
        // if (StringUtils.equals(hdfsPath, resultPath)) {
        // if (logger.isDebugEnabled()) {
        // logger.debug("backup mro file succ:" + hdfsPath);
        // }
        //
        // // 备份完成，设置标记，删除本地文件
        // marker.set(redisCheckKey, "true");
        //
        // try {
        // FileUtils.forceDelete(file);
        // } catch (IOException e) {
        // logger.error("delete mro file error:" + file.getName(), e);
        // }
        // }

        return isSucc;
    }

    /**
     * 传入文件名获得相应的标准化文件名 例如：传入： NSN-LTE-MRO-2014-08-20.tar.gz，输出：MRS/NSN/20140909/23/NSN-LTE-MRO-2014-08-20.tar.gz
     * 
     * @param fileName
     * @return
     */
    public static String getFilePath(String fileName) {
        String tempFileName = fileName.toLowerCase();

        StringBuffer buff = new StringBuffer();
        String[] args = tempFileName.split("_");
        // TODO 前缀暂时写死
        buff.append("lte_");
        // 类型
        buff.append(args[1]).append("/");
        // 厂商
        buff.append(args[2]).append("/");
        // 年月日
        buff.append(args[5].substring(0, 8)).append("/");
        // 小时
        buff.append(args[5].substring(8, 10)).append("/");
        // 文件
        buff.append(fileName.substring(fileName.lastIndexOf("/") + 1));
        return buff.toString();
    }

    /**
     * 获取.tar.gz文件中指定文件后辍的文件个数
     * 
     * @param file 文件
     * @param endFlag 后辍
     * @return 符合条件的文件个数
     */
    public int getFileInTarGzWithType(File file, String endFlag) {
        if (file == null || file.isDirectory()) {
            return 0;
        }

        int totalFiles = 0;// 符合条件的文件数

        FileInputStream fin = null;// 文件流
        InputStream in = null;
        TarArchiveInputStream tin = null;

        try {
            fin = new FileInputStream(file);
            in = new GzipCompressorInputStream(fin, true);
            tin = new TarArchiveInputStream(in);

            TarArchiveEntry entry = tin.getNextTarEntry();
            while (entry != null) {// 统计所有符合后辍的节点
                if (entry.isDirectory()) {
                    entry = tin.getNextTarEntry();
                    continue;
                }
                if (StringUtils.isNotBlank(endFlag)) {
                    if (entry.getName().toLowerCase().endsWith(endFlag.toLowerCase())) {
                        totalFiles++;
                    }
                } else {
                    totalFiles++;
                }
                entry = tin.getNextTarEntry();
            }
        } catch (Exception e) {
            totalFiles = 0;
            logger.error("count file end with:" + endFlag + " in  tar.gz file:" + file.getAbsolutePath() + " error", e);
        } finally {
            try {// 关闭输入流
                if (tin != null) {
                    tin.close();
                }
                if (in != null) {
                    in.close();
                }
                if (fin != null) {
                    fin.close();
                }
            } catch (Exception e) {
                logger.error("close file input stream error:" + file.getAbsolutePath() + ",endFlag:" + endFlag, e);
            }
        }

        return totalFiles;
    }
}
