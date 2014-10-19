/**  
 * HdfsBackupLteFiles.java
 * com.cmcc.optimize.datasyc.backup.impl
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:45:32
 * 版权所有
 */
package com.cmcc.optimize.datasyc.backup.impl;

import java.io.FileInputStream;
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
import com.cmcc.optimize.datasyc.scheduler.MRODownLoadSchedulerJob;

/**
 * 备份mro数据
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:45:32
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class HdfsBackupMroFiles extends AbstractHdfsBackup {

    private static final CmccLogger logger = CmccLogger.getLogger(HdfsBackupMroFiles.class);// 日志

    private static Marker marker = MRODownLoadSchedulerJob.getFtpFileProcessMarker();// 文件处理标识

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
                backupFolder(model.getLocalTempFolder(), path, model);
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
    private void backupFolder(String folder, String folderPath, HdfsBackupModel model) {
        List<String> files = LocalFileHelper.getAllFilesInFolder(folder + folderPath);

        // 获取是否处理标识，过滤未达到备份状态的文件
        for (int i = files.size() - 1; i >= 0; i--) {
            if (!files.contains(folderPath)) {
                continue;
            }
            boolean needDelete = MRODownLoadSchedulerJob.checkNeedDelete(marker, files.get(i).replace(model.getLocalTempFolder(), ""), model.getLocalTempFolder());
            if (!needDelete) {
                continue;
            } else {
                // mro的数据，只判断后，直接备份，不进行打包，单个文件大小比较大，直接按文件备份到hdfs
                String filePath = files.get(i).replace("\\", "/");
                String path = filePath.replace(model.getLocalTempFolder(), "");

                try {
                    // 备份单个文件
                    String resultPath = hdfsUpload.createFile(path, new FileInputStream(filePath));

                    if (!StringUtils.equals(path, resultPath)) {
                        logger.warn("backup hdfs file fail:" + path);
                        continue;
                    }

                    if (logger.isDebugEnabled()) {
                        logger.debug("backup hdfs file succ:" + path);
                    }

                    // 设置redis备份成功状态
                    String redisCheckKey;
                    try {
                        redisCheckKey = FtpFileProcessConfig.getRedisMarkerBackupSucc(filePath.replace("\\", "/").replace(model.getLocalTempFolder(), ""));
                        marker.set(redisCheckKey, "true");

                        if (logger.isInfoEnabled()) {
                            logger.info("backup hdfs succ,to delete file:" + filePath);
                        }

                        LocalFileHelper.deleteFiles(filePath);
                    } catch (Exception e) {
                        logger.error("delete backup success file error:" + filePath);
                    }
                } catch (Exception e) {
                    logger.error("backup hdfs file error:" + filePath);
                }

            }
        }

    }

}
