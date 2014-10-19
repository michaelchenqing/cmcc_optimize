/**  
 * TestSchudlerSample.java
 * com.cmcc.optimize.examples.quartz
 * 
 * @author gaoqs
 * @date 2014年8月27日 下午5:29:21
 * 版权所有
 */
package com.cmcc.optimize.examples.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;

/**
 * 测试调起测试的job
 * 
 * @author gaoqs
 * @date 2014年8月27日 下午5:29:21
 */

public class TestSchudlerSample {

    private static final String DEFAULT_GROUP = "GROUP-1";// 分组调度，这里暂不使用分布式调度

    /**
     * main
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scheduler scheduler = null;
        // 启动quartz调度
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        String corn = "5/5 * * * * ?";

        JobDetail jobCheck = JobBuilder.newJob(TestSampleJobs.class).withIdentity("_check", DEFAULT_GROUP).build();
        FtpDownConfModel m = new FtpDownConfModel();
        m.setAppointDay("20140820");
        jobCheck.getJobDataMap().put("config", m);

        // 创建cron表达式tirgger
        CronTrigger triggerCheck = TriggerBuilder.newTrigger().withIdentity("_check", DEFAULT_GROUP).withSchedule(CronScheduleBuilder.cronSchedule(corn)).build();

        try {
            scheduler.scheduleJob(jobCheck, triggerCheck);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
