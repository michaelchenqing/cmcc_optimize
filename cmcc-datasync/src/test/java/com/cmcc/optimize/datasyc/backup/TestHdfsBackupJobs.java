/**  
 * TestHdfsBackupJobs.java
 * com.cmcc.optimize.datasyc.backup
 * 
 * @author gaoqs
 * @date 2014年8月21日 下午4:20:23
 * 版权所有
 */
package com.cmcc.optimize.datasyc.backup;

import junit.framework.TestCase;

/**
 * hdfs job备份单元测试
 * 
 * @author gaoqs
 * @date 2014年8月21日 下午4:20:23
 */

public class TestHdfsBackupJobs extends TestCase {

    /**
     * 备份lte测试
     */
    public void testBackupLte() {
        HdfsBackupJobs job = new HdfsBackupJobs();
        HdfsBackupModel config = new HdfsBackupModel();
        config.setBackupClass("com.cmcc.optimize.datasyc.backup.impl.HdfsBackupLteFiles");
        config.setFolder("TCP/,HTTP/");
        config.setLocalTempFolder("d:/data/ftp/");
        job.doJob(config);
    }

    /**
     * 备份mro测试
     */
    public void testBackupMro() {
        HdfsBackupJobs job = new HdfsBackupJobs();
        HdfsBackupModel config = new HdfsBackupModel();
        config.setBackupClass("com.cmcc.optimize.datasyc.backup.impl.HdfsBackupMroFiles");
        config.setFolder("TCP/,HTTP/");
        config.setLocalTempFolder("d:/data/ftp/");
        job.doJob(config);
    }

    /**
     * 备份信令测试
     */
    public void testBackupSignal() {
        HdfsBackupJobs job = new HdfsBackupJobs();
        HdfsBackupModel config = new HdfsBackupModel();
        config.setBackupClass("com.cmcc.optimize.datasyc.backup.impl.HdfsBackupSignalFiles");
        config.setFolder("xinling/");
        config.setLocalTempFolder("d:/data/ftp/");
        job.doJob(config);
    }
}
