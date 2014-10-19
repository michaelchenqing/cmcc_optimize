/**  
 * Main.java
 * com.cmcc.optimize.datasyc.runtime
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:05:55
 * 版权所有
 */
package com.cmcc.optimize.datasyc.runtime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.cas.common.collect.Marker;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.redis.GlobalCounterMarker;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datasyc.config.ConfigUtils;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;
import com.cmcc.optimize.datasyc.scheduler.FtpDownLoadScheduler;
import com.cmcc.optimize.datasyc.scheduler.FtpDownLoadSchedulerJob;
import com.cmcc.optimize.datasyc.scheduler.FtpFileToReidsSchedulerJob;
import com.cmcc.optimize.datasyc.scheduler.MRODownLoadSchedulerJob;
import com.cmcc.optimize.datasyc.scheduler.SacnFreqDownLoadSchedulerJob;

/**
 * 数据同步主起动类
 * 
 * @author gaoqs
 */
public class Main {

    private static final CmccLogger logger = CmccLogger.getLogger(Main.class);// 日志

    private static FtpFileProcessConfig ftpProcessConfig;// ftp下载配置

    // private static final HdfsUploadFile hdfsUpload = new HdfsUploadFileImpl();// hdfs上传

    private static Marker marker;// redis标记

    /**
     * 数据同步main函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 20140925 sp false Scan_BIN,Scan_OPTS
//        args = new String[] { "-d", "20140925", "sp", "false", "Scan_BIN,Scan_OPTS" };

        // 指定日期同步数据
        if (args.length != 0) {
            if (args[0].equals("-d")) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                try {
                    if (args.length < 2 || (sdf.parse(args[1]) == null)) {
                        usage();
                        return;
                    }
                } catch (ParseException pse) {
                    usage();
                    return;
                }
                boolean justCount = false;// 是否只是统计
                if (args.length > 3 && args[3] != null) {
                    justCount = StringUtils.equals("true", args[3].trim());
                }
                String fileImport = null;// 只导入指定的文件
                if (args.length > 4 && args[4] != null) {
                    fileImport = args[4].trim();
                }

                // 手工回导指定日期的文件
                importDataForAppointDay(args[1], args[2], justCount, fileImport);
            } else if (args[0].equals("rmkey")) {
                // 清空指定的rediskey
                String mustContains = null;
                String includeStrs = null;

                if (args.length > 1 && args[1] != null) {
                    mustContains = args[1].trim();
                }
                if (args.length > 2 && args[2] != null) {
                    includeStrs = args[2].trim();
                }
                if (logger.isDebugEnabled()) {
                    logger.debug("remove redis key:" + mustContains + "@" + includeStrs);
                }
                ((GlobalCounterMarker) FtpDownLoadSchedulerJob.getFtpFileProcessMarker()).deleteKeysWithContainsString(mustContains, includeStrs);
            }

        } else {
            // 启动调度程序
            doSchedule();
        }
    }

    /**
     * usage 提示
     */
    private static void usage() {
        System.out.println("Cmcc Ftp File DataSync V0.0.1");
        System.out.println();
        System.out.println("Arguments:");
        System.out.println(" -d  yyyyMMdd          Import data for the appoint day");
        System.out.println(" -d  yyyyMMdd  true[false]        Import data for the appoint day,just count when true/");
        System.out.println(" -d  yyyyMMdd  true[false]  filterFileNames        Import data for the appoint day/just count when true/just import files with filter split ,");
    }

    /**
     * 开始调度任务
     */
    private static void doSchedule() {
        // 1、初始化redis
        marker = FtpDownLoadSchedulerJob.getFtpFileProcessMarker();

        // 2、加载ftp文件同步地址配置
        ftpProcessConfig = new FtpFileProcessConfig();

        // 获取ftp本地下载地址
        // String localTempPath = FtpFileProcessConfig.getDefaultFtpLocalCacheFolder();

        // 获取ftp待下载监控列表
        List<FtpDownConfModel> configList = ftpProcessConfig.getFtpConfigList();

        // 3、起定时任务同步下载文件
        FtpDownLoadScheduler.startAllScheduler(configList);

        // 4.起线程备份文件到hdfs
        // startHdfsBackup(localTempPath);//备份已经移到通用hdfs备份中，参照：StartHdfsBackupMain.java

    }

    /**
     * 下载指定日期的数据
     * 
     * @param day 指定回导日期
     * @param type 指定回导的文件类型
     * @param justCout 是否只执行count操作
     * @param fileImport 导入指定的文件，以,分隔，模糊匹配
     */
    private static void importDataForAppointDay(String day, String type, boolean justCount, String fileImport) {

        if (logger.isDebugEnabled())
            logger.debug("Import data for appoint day : " + day + "，type：" + type + "，justCount：" + justCount + "，fileImport：" + fileImport);

        marker = FtpDownLoadSchedulerJob.getFtpFileProcessMarker();

        // 清空对应日期的redis的key，按指定日期导入时，先清空redis
        ((GlobalCounterMarker) marker).deleteKeysWithContainsString(day, fileImport);

        // 获取配置文件
        ftpProcessConfig = new FtpFileProcessConfig();

        // 获取ftp待下载监控列表
        List<FtpDownConfModel> configList = ftpProcessConfig.getFtpConfigList();

        for (FtpDownConfModel ftpDownConfModel : configList) {

            String customJobClass = ftpDownConfModel.getCustomJobClass();

            if (type.equals("ftp") && customJobClass.contains("FtpDownLoadSchedulerJob")) {
                // 替换config为制定目录
                ftpDownConfModel.setFtpFolder(ConfigUtils.parseFolderDate(ftpDownConfModel.getFtpFolder(), day));
                ftpDownConfModel.setAppointDay(day);

                FtpDownLoadSchedulerJob appointDayJob = new FtpDownLoadSchedulerJob();
                appointDayJob.justCount = justCount;
                if (fileImport != null) {
                    String filterFiles[] = fileImport.split(",");
                    appointDayJob.justImportFiles = filterFiles;
                }
                appointDayJob.doJob(ftpDownConfModel);
            } else if (type.equals("mro") && customJobClass.contains("MRODownLoadSchedulerJob")) {
                // 替换config为制定目录
                ftpDownConfModel.setFtpFolder(ConfigUtils.parseFolderDate(ftpDownConfModel.getFtpFolder(), day));
                ftpDownConfModel.setAppointDay(day);

                MRODownLoadSchedulerJob appointDayJob = new MRODownLoadSchedulerJob();

                if (fileImport != null) {
                    String filterFiles[] = fileImport.split(",");
                    appointDayJob.justImportFiles = filterFiles;
                }

                appointDayJob.doJob(ftpDownConfModel);
            } else if (type.equals("xl") && customJobClass.contains("FtpFileToReidsSchedulerJob")) {// 信令数据
                FtpFileToReidsSchedulerJob job = new FtpFileToReidsSchedulerJob();
                job.doJob(ftpDownConfModel);
            } else if (type.equals("sp") && customJobClass.contains("SacnFreqDownLoadSchedulerJob")) {// 扫频数据
                // 替换config为制定目录
                ftpDownConfModel.setFtpFolder(ConfigUtils.parseFolderDate(ftpDownConfModel.getFtpFolder(), day));
                ftpDownConfModel.setAppointDay(day);

                SacnFreqDownLoadSchedulerJob appointDayJob = new SacnFreqDownLoadSchedulerJob();
                if (fileImport != null) {
                    String filterFiles[] = fileImport.split(",");
                    appointDayJob.justImportFiles = filterFiles;
                }
                appointDayJob.doJob(ftpDownConfModel);
            }
        }

        if (logger.isInfoEnabled()) {
            logger.info("import data success:" + day + "@" + type + "@" + justCount);
        }
        // startHdfsBackup(FtpFileProcessConfig.getDefaultFtpLocalCacheFolder());

    }

    // /**
    // * 将目录下的所有的文件备份到hdfs
    // *
    // * @param localTempPath
    // */
    // private static void startHdfsBackup(final String localTempPath) {
    // Thread thread = new Thread(new Runnable() {
    // @Override
    // public void run() {
    // while (true) {
    // try {
    // // 遍历目录，将目录下已经处理过的文件备份到hdfs，处理完成，将设置文件的最后修改时间，按统一的时后修改时间进行备份，处理完成，并备份完成后，删除文件
    // File files[] = new File(localTempPath).listFiles();
    // for (File file : files) {
    // storeFileToHdfs(file, localTempPath);
    // }
    //
    // // 每隔2分钟检测一次是否需要备份
    // CommonUtil.sleepSecond(2 * 60 * 1000);
    // } catch (Exception e) {
    // logger.error("hdfs backup error", e);
    // }
    // }
    // }
    // }, "hdfs_backup");
    //
    // thread.start();
    // }
    //
    // /**
    // * 备份单个文件到hdfs
    // *
    // * @param file
    // */
    // private static void storeFileToHdfs(File file, String localTempPath) {
    // try {
    // if (file.isDirectory()) {
    // // 迭代目录缓存
    // File files[] = file.listFiles();
    // for (File subFile : files) {
    // storeFileToHdfs(subFile, localTempPath);
    // }
    // } else {
    // // 缓存单个文件，按目录结构，从localTempPath开始按目录结构缓存
    // String path = file.getAbsolutePath().replace("\\", "/").replace(localTempPath, "");
    //
    // // 检测是否处理完成，放redis，检测是否已备份，放redis，都完成时，删除本地文件
    // boolean needDelete = FtpDownLoadSchedulerJob.checkNeedDelete(marker, path, localTempPath);// 文件已经处理和备份完成是否需要进行删除
    //
    // if (needDelete) {// 已经处理和备份完成，不进行备份
    // if (new File(localTempPath + path).exists()) {
    // logger.warn("processed over file delete error:" + localTempPath + path);
    // }
    // return;
    // }
    //
    // String isBacked = marker.getMark(FtpFileProcessConfig.getRedisMarkerBackupSucc(path));
    // if (StringUtils.equals(isBacked, "true")) {
    // if (logger.isDebugEnabled()) {
    // logger.debug("backup flag true,no need back to hdfs:" + path);
    // }
    // return;
    // }
    //
    // if (logger.isDebugEnabled()) {
    // logger.debug("backup ftp file to hdsf:" + path);
    // }
    //
    // // 将本地文件存储备份到hdfs
    // String resultPath = hdfsUpload.createFile(path, new FileInputStream(file));
    // if (StringUtils.equals(path, resultPath)) {
    // if (logger.isDebugEnabled()) {
    // logger.debug("backup ftp file succ:" + path);
    // }
    //
    // // 备份完成，设置标记
    // String redisCheckKey = FtpFileProcessConfig.getRedisMarkerBackupSucc(path);
    // marker.set(redisCheckKey, "true");
    //
    // }
    // }
    // } catch (Exception e) {
    // logger.error("hdfs backup single file error", e);
    // }
    // }

}
