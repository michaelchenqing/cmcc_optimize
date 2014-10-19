/**  
 * HdfsBackupLteFiles.java
 * com.cmcc.optimize.datasyc.backup.impl
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:45:32
 * 版权所有
 */
package com.cmcc.optimize.datasyc.backup.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.PersistJobDataAfterExecution;

import cn.cas.common.collect.Marker;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.util.LocalFileHelper;
import com.cmcc.optimize.datasyc.backup.AbstractHdfsBackup;
import com.cmcc.optimize.datasyc.backup.HdfsBackupModel;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;
import com.cmcc.optimize.datasyc.scheduler.FtpDownLoadSchedulerJob;

/**
 * 备份lte工参数据
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:45:32
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class HdfsBackupLteFiles extends AbstractHdfsBackup {

    private static final CmccLogger logger = CmccLogger.getLogger(HdfsBackupLteFiles.class);// 日志

    private static Marker marker = FtpDownLoadSchedulerJob.getFtpFileProcessMarker();// 文件处理标识

    /*
     * (non-Javadoc)
     * @see
     * com.cmcc.optimize.datasyc.backup.HdfsBackupInterface#backup(com.cmcc.optimize.datasyc.backup.HdfsBackupModel)
     */
    @Override
    public void backup(HdfsBackupModel model) {

        String folder = model.getFolder();
        if (StringUtils.isBlank(folder)) {
            logger.warn("folder is null:" + model);
            return;
        }

        // 循环多个目录，分目录打包，获取上层目录名称，作为文件名
        String[] folders = folder.split(",");

        for (String path : folders) {
            try {
                backupFolder(model.getLocalTempFolder() + path, model);
            } catch (Exception e) {
                logger.error("backup folder error:" + path, e);
            }
        }

    }

    /**
     * 备份单个目录
     * 
     * @param folder 目录
     * @param model 配置
     */
    private void backupFolder(String folder, HdfsBackupModel model) {
        List<String> files = LocalFileHelper.getAllFilesInFolder(folder);

        // 获取是否处理标识，过滤未达到备份状态的文件
        for (int i = files.size() - 1; i >= 0; i--) {
            boolean needDelete = FtpDownLoadSchedulerJob.checkNeedDelete(marker, files.get(i).replace(model.getLocalTempFolder(), ""), model.getLocalTempFolder());
            if (!needDelete) {
                files.remove(i);
            }
        }

        if (files.size() <= 0) {
            return;
        }

        List<String> deletes = new ArrayList<String>();// 待删除文件

        // 添加需要打包的文件，指定多少个文件打一个包
        for (int i = 0; i < files.size(); i++) {
            if (i > 0 && (i % perPackageFileNums == 0)) {
                backupFilesUpload(folder, deletes, model.getLocalTempFolder());
                deletes = new ArrayList<String>();
            }
            deletes.add(files.get(i));
        }

        if (deletes.size() == perPackageFileNums) {// 严格按照约定数量打包
            backupFilesUpload(folder, deletes, model.getLocalTempFolder());
        }

    }

    /**
     * 备份文件，设置标置位，删除原文件
     * 
     * @param folder 文件所在目录
     * @param deletes 待删除文件
     * @param localTempFolder ftp临时目录
     */
    private void backupFilesUpload(String folder, List<String> deletes, String localTempFolder) {
        String hdfsFolder = folder.replace("\\", "/").replace(localTempFolder, "");
        zipFileAndBackup(hdfsFolder, deletes, localTempFolder);

        // 删除指定的本地文件
        for (String string : deletes) {
            String redisCheckKey;
            try {
                redisCheckKey = FtpFileProcessConfig.getRedisMarkerBackupSucc(string.replace("\\", "/").replace(localTempFolder, ""));
                marker.set(redisCheckKey, "true");
                if (logger.isInfoEnabled()) {
                    logger.info("backup hdfs succ,to delete file:" + string);
                }
                LocalFileHelper.deleteFiles(string);
            } catch (Exception e) {
                logger.error("delete backup success file error:" + string);
            }

        }
    }

}
