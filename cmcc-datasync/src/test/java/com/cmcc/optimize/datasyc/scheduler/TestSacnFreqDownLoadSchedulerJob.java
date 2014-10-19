/**  
 * TestSacnFreqDownLoadSchedulerJob.java
 * com.cmcc.optimize.datasyc.scheduler
 * 
 * @author gaoqs
 * @date 2014年8月25日 上午9:41:58
 * 版权所有
 */
package com.cmcc.optimize.datasyc.scheduler;

import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;

import junit.framework.TestCase;

/**
 * 单元测试扫频数据导入
 * 
 * @author gaoqs
 * @date 2014年8月25日 上午9:41:58
 */

public class TestSacnFreqDownLoadSchedulerJob extends TestCase {

    protected SacnFreqDownLoadSchedulerJob job;// job

    protected FtpDownConfModel config;// ftp配置

    @Override
    protected void setUp() throws Exception {
        job = new SacnFreqDownLoadSchedulerJob();
        config = new FtpDownConfModel();
        config.setCustomJobClass("com.cmcc.optimize.datasyc.scheduler.SacnFreqDownLoadSchedulerJob");
        config.setFtpFolder("/data/dataservice/scanfreq/${data:yyyyMMdd}");
        config.setPassword("aas_%123");
        config.setPort("21");
        config.setUserName("ftp_yjy");
        config.setHost("10.101.159.13");
        config.setLocalFolder("scanfreq/");
        config.setFileNameRule("Scan_(BIN|OPTS)_.*\\.csv");
        config.setNeedListSubFtpFiles(true);
        config.setAppointDay("20140727");

        new FtpFileProcessConfig();// 加载配置文件
    }

    /**
     * 测试扫频数据quartz导入
     */
    public void testJobImport() {
        job.doJob(config);
        // job.executeFullCompute("20140825");
        // job.genResultFile("20140825");
    }

    /**
     * 测试文件生成
     */
    public void testGenResultFile() {
        //job.genResultFile("20140825");
    }

    /**
     * 测试计算补全数据
     */
    public void testExecuteFullCompute() {
        job.executeFullCompute("20140727");
    }
}
