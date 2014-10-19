/**  
 * FtpDownLoadScheduler.java
 * com.cmcc.optimize.datasyc.scheduler
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午4:24:06
 * 版权所有
 */
package com.cmcc.optimize.datasyc.scheduler;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;

/**
 * 调起所有的ftp下载监控
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午4:24:06
 */

public class FtpDownLoadScheduler {

    private static final CmccLogger logger = CmccLogger.getLogger(FtpDownLoadScheduler.class);// 日志

    private static final String DEFAULT_GROUP = "GROUP-1";// 分组调度，这里暂不使用分布式调度

    /**
     * 调起所有的ftp下载
     * 
     * @param configList
     */
    @SuppressWarnings("unchecked")
    public static void startAllScheduler(List<FtpDownConfModel> configList) {
        // 未配置ftp下载监控
        if (configList == null || configList.size() <= 0) {
            logger.warn("no need to down ftp files, cofnigList is null");
            return;
        }

        int index = 0;
        Scheduler scheduler = null;
        // 启动quartz调度
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
        } catch (Exception e) {
            logger.error("start quartz ftp download scheduler error:" + configList.size(), e);
            logger.notice("start quartz ftp download scheduler error:" + configList.size() + ",exception:" + e);
            return;
        }

        for (FtpDownConfModel ftpDownConfModel : configList) {
            index++;
            try {
                // 创建job
                Class<Job> customJobClass = (Class<Job>) Class.forName(ftpDownConfModel.getCustomJobClass().trim());
                JobDetail job = JobBuilder.newJob(customJobClass).withIdentity(index + "、" + ftpDownConfModel.getFileNameRule(), DEFAULT_GROUP).build();
                job.getJobDataMap().put("config", ftpDownConfModel);

                // 创建cron表达式tirgger
                CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(index + "、" + ftpDownConfModel.getCornString(), DEFAULT_GROUP).withSchedule(CronScheduleBuilder.cronSchedule(ftpDownConfModel.getCornString())).build();

                if (logger.isInfoEnabled()) {
                    logger.info("scheduler ftp download monitor:" + ftpDownConfModel);
                }

                scheduler.scheduleJob(job, trigger);

                // 是否需要检测文件存在,超过指定时间，当天的文件仍不存在，用于预警
                if (ftpDownConfModel.getCheckFileList() != null && ftpDownConfModel.getCheckFileList().size() > 0 && StringUtils.isNotBlank(ftpDownConfModel.getCheckCornString())) {

                    JobDetail jobCheck = JobBuilder.newJob(FtpFileCheckSchedulerJob.class).withIdentity(index + "、" + ftpDownConfModel.getFileNameRule() + "_check", DEFAULT_GROUP).build();
                    jobCheck.getJobDataMap().put("config", ftpDownConfModel);

                    // 创建cron表达式tirgger
                    CronTrigger triggerCheck = TriggerBuilder.newTrigger().withIdentity(index + "、" + ftpDownConfModel.getCheckCornString() + "_check", DEFAULT_GROUP).withSchedule(CronScheduleBuilder.cronSchedule(ftpDownConfModel.getCheckCornString())).build();

                    if (logger.isInfoEnabled()) {
                        logger.info("scheduler ftp file exist monitor:" + ftpDownConfModel);
                    }

                    scheduler.scheduleJob(jobCheck, triggerCheck);
                }

            } catch (Exception e) {
                logger.error("scheduler ftp download monitor error:" + ftpDownConfModel, e);
                logger.notice("scheduler ftp download monitor error:" + ftpDownConfModel + ",exception:" + e);
            }
        }

    }
}
