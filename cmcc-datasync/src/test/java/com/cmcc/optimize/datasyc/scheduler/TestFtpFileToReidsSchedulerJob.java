/**  
 * TestFtpFileToReidsSchedulerJob.java
 * com.cmcc.optimize.datasyc.scheduler
 * 
 * @author gaoqs
 * @date 2014年8月27日 下午2:31:47
 * 版权所有
 */
package com.cmcc.optimize.datasyc.scheduler;

import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;

import junit.framework.TestCase;

/**
 * 测试ftp目录到redis
 * 
 * @author gaoqs
 * @date 2014年8月27日 下午2:31:47
 */

public class TestFtpFileToReidsSchedulerJob extends TestCase {

    protected FtpFileToReidsSchedulerJob job;// job

    protected FtpDownConfModel config;// ftp配置

    @Override
    protected void setUp() throws Exception {
        job = new FtpFileToReidsSchedulerJob();
        config = new FtpDownConfModel();
        config.setCustomJobClass("com.cmcc.optimize.datasyc.scheduler.FtpFileToReidsSchedulerJob");
        config.setFtpFolder("/oracle/Data/mianyang/GB2DB/GB/src");
        config.setPassword("asionsys2012");
        config.setPort("21");
        config.setUserName("Asion");
        config.setHost("10.101.159.11");
        config.setLocalFolder("xinling/");
        config.setFileNameRule(".*[0-9]{8,14}\\.csv");
        config.setNeedListSubFtpFiles(true);

        new FtpFileProcessConfig();// 加载配置文件
    }

    /**
     * 测试ftp目录数据quartz导入redis
     */
    public void testJobImport() {
        job.doJob(config);
    }

}
