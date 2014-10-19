/**  
 * FtpFileToReids.java
 * com.cmcc.optimize.datasyc.ds
 * 
 * @author peng
 * @date 2014-8-15 下午1:57:17
 * 版权所有
 */
package com.cmcc.optimize.datasyc.scheduler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import cn.cas.common.collect.Marker;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClientImpl;
import com.cmcc.optimize.dataaccess.redis.GlobalCounterMarker;
import com.cmcc.optimize.dataaccess.redis.RedisConf;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;

/**
 * 将ftp中需要备份的文件存入到redis队列中
 * 
 * @author peng
 * @date 2014-8-15 下午1:57:17
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class FtpFileToReidsSchedulerJob implements Job {

    private FtpDownConfModel config;// ftp下载配置

    private static Marker marker;// redis标记

    private static final CmccLogger logger = CmccLogger.getLogger(FtpFileToReidsSchedulerJob.class);// 日志

    private FtpDownloadClient ftpClient;// ftp客户端

    /**
     * 提供给quartz调用的默认无参构造函数，参数通过jobdetailmap传入context
     */
    public FtpFileToReidsSchedulerJob() {
    }

    /**
     * 获取ftp的redis marker标记
     * 
     * @return
     */
    public static Marker getFtpFileProcessMarker() {
        RedisConf conf = RedisConf.getRedisConf("ftpbackups");
        marker = new GlobalCounterMarker(conf, FtpFileProcessConfig.FTP_FILE_BACKUP_COUNTER);
        return marker;
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

        if (marker == null) {
            marker = getFtpFileProcessMarker();
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
        boolean needListSubFolder = config.isNeedListSubFtpFiles();

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

        // 登出ftp
        ftpClient.loginOut();

        // 一次性将所有文件导入到redis
        for (int i = files.size() - 1; i >= 0; i--) {
            String fileName = files.get(i);

            if (fileName.contains("//")) {
                logger.info(fileName);
            }
            String redisMarkerSyc;
            try {
                redisMarkerSyc = FtpFileProcessConfig.getRedisMarkerSycSucc(localFolder + fileName);
            } catch (Exception e) {
                logger.error(e);
                files.remove(i);// 移除不需要下载的文件名
                continue;
            }
            // 验证文件名是否已经同步到了redis中
            if (StringUtils.isBlank(marker.getMark(redisMarkerSyc))) {
                if (logger.isInfoEnabled()) {
                    logger.info("RedisKey:" + redisMarkerSyc + ",is null ，need to download file :" + fileName);
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
                logger.info("the file into redis:" + localFolder + "," + ftpFolder + "," + fileName);
                boolean isSucc = ((GlobalCounterMarker) marker).queuePush(localFolder + "," + ftpFolder + "/" + fileName);

                if (!isSucc) {
                    logger.error("download ftp file error:" + config + "-->" + fileName);
                    logger.notice("download ftp file error:" + config + "-->" + fileName);
                } else {
                    // 标记文件名称已经同步到redis中
                    marker.set(redisMarkerSyc, "true");
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("RedisKey:" + redisMarkerSyc + ", is not null，file  :" + fileName + ", has been downloaded before");
                }
            }
        }
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
}
