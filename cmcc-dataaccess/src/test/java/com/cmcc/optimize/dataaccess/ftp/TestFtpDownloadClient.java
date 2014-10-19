/**  
 * TestFtpDownloadClient.java
 * com.cmcc.optimize.dataaccess.ftp
 * 
 * @author gaoqs
 * @date 2014年6月26日 下午12:29:52
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.ftp;

import java.util.List;

import junit.framework.TestCase;

import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClientImpl;

/**
 * 测试文件下载
 * 
 * @author gaoqs
 * @date 2014年6月26日 下午12:29:52
 */

public class TestFtpDownloadClient extends TestCase {

    /**
     * 测试下载ftp文件
     */
    public void testDownFile() {
        FtpDownloadClient client = new FtpDownloadClientImpl();
        boolean isSucc = client.login("10.101.16.10", 21, "ftp-wy1", "gAaC%^Aq");
        assertTrue(isSucc);
        List<String> list = client.getFilesInFolderWithSub("/backupnew/data_center/20140802");
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    /**
     * 测试删除ftp文件
     */
    public void testDeleteFile() {
        FtpDownloadClient client = new FtpDownloadClientImpl();
        boolean isSucc = client.login("localhost", 21, "test", "123");
        assertTrue(isSucc);
        isSucc = client.deleteFtpFile("/test/123.csv");
        assertTrue(isSucc);
    }
}
