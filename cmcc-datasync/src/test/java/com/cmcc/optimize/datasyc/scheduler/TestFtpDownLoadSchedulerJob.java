/**  
 * FtpDownLoadSchedulerJob.java
 * com.cmcc.optimize.datasyc.scheduler
 * 
 * @author bzhou
 * @date 2014年6月26日 下午3:25:58
 * 版权所有
 */
package com.cmcc.optimize.datasyc.scheduler;

import java.util.regex.Pattern;

import junit.framework.TestCase;

/**
 * TODO(这里用一句话描述这个类的作用)
 * 
 * @author bzhou
 * @date 2014年6月26日 下午3:25:58
 */

public class TestFtpDownLoadSchedulerJob extends TestCase {

    public void testParseFile() {
//        FtpDownLoadSchedulerJob job = new FtpDownLoadSchedulerJob();
//        List<String> lines = job.getLinesByFilePath("D:\\testdata\\mianyang\\test\\sichuan_Lte_LtePlan_YY_20140624.tar.gz");
//        assertNotNull(lines);
//        assertTrue(lines.size() > 0);
//        
//        
//        List<String> lines2 = job.getLinesByFilePath("D:\\testdata\\mianyang\\test\\sichuan_Lte_LtePlan_YY_20140624.csv");
//        assertNotNull(lines2);
//        assertTrue(lines2.size() > 0);
    }

    public void testPattern(){
        Pattern pattern = Pattern.compile("sichuan_Lte_.*_YY_[0-9]{1,8}\\.csv\\.gz");
        assertTrue(pattern.matcher("sichuan_Lte_LtePlan_YY_20140627.csv.gz").find());
        assertTrue(pattern.matcher("sichuan_Lte_LteProject_YY_20140627.csv.gz").find());
    }
    
}
