/**  
 * FtpFileCheckSchedulerJob.java
 * com.cmcc.optimize.datasyc.scheduler
 * 
 * @author gaoqs
 * @date 2014年7月7日 下午4:08:01
 * 版权所有
 */
package com.cmcc.optimize.datasyc.scheduler;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import cn.cas.common.collect.Marker;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datasyc.config.ConfigUtils;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;

/**
 * ftp文件检测定时调度
 * 
 * @author gaoqs
 * @date 2014年7月7日 下午4:08:01
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class FtpFileCheckSchedulerJob implements Job {

    private FtpDownConfModel config;// ftp下载配置

    private static Marker marker;// redis标记

    private static final CmccLogger logger = CmccLogger.getLogger(FtpFileCheckSchedulerJob.class);// 日志

    private String appointDay = null;// 当前日期

    /**
     * 提供给quartz调用的默认无参构造函数，参数通过jobdetailmap传入context
     */
    public FtpFileCheckSchedulerJob() {
    }

    /*
     * (non-Javadoc)
     * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 从quartz job上下文中传入的参数
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        doJob((FtpDownConfModel) jobDataMap.get("config"));
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
            logger.debug("execute ftp file exist check monitor,cornString:" + config.getCheckCornString() + ",check file Nums:" + config.getCheckFileList().size());
        }

        // 获取检测配置
        List<String> fileList = config.getCheckFileList();

        appointDay = config.getAppointDay();

        // 如果不是特定日期数据入库，替换时间变量
        if (null == appointDay || appointDay.length() == 0) {
            for (int i = 0; i < fileList.size(); i++) {
                fileList.set(i, ConfigUtils.parseStringDate(fileList.get(i)));
            }
        }

        StringBuffer sb = new StringBuffer();// 缺失的文件列表

        // 检测ftp文件在redis中是否存在
        for (String file : fileList) {
            String redisCheckDownLoadKey = "";
            try {
                redisCheckDownLoadKey = FtpFileProcessConfig.getRedisMarkerDownLoadSucc(config.getLocalFolder() + file);
            } catch (Exception e) {
                logger.error("get down succ key in redis error:" + config.getLocalFolder() + "/" + file, e);
            }

            String isDown = marker.getMark(redisCheckDownLoadKey);
            if (StringUtils.isBlank(isDown)) {// 文件未下载，超过预计时间，报错
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(file);
                logger.warn("file:" + file + ", not exit in coreString:" + config.getCheckCornString());
            }
        }

        if (sb != null && sb.length() > 0) {// 超过12点，ftp文件仍不存在，则预警
            logger.notice("file not exit in corn time：" + config.getCheckCornString() + ",files:" + sb.toString());
        }

    }

}
