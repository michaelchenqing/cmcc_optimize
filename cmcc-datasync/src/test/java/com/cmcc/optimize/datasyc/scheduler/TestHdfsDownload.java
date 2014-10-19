/**  
 * TestHdfsUpload.java
 * com.cmcc.optimize.datasyc.scheduler
 * 
 * @author gaoqs
 * @date 2014年7月8日 上午10:09:48
 * 版权所有
 */
package com.cmcc.optimize.datasyc.scheduler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import com.cmcc.optimize.dataaccess.hdfs.HdfsDownloadFile;
import com.cmcc.optimize.dataaccess.hdfs.HdfsDownloadFileImpl;
import com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFileImpl;

/**
 * hdfs文件下载单元测试 注意：win环境下，需要在hadoop环境/bin下执行：./hadoop fs -chmod 777 /,设置访问权限
 * 
 * @author gaoqs
 * @date 2014年7月8日 上午10:09:48
 */

public class TestHdfsDownload extends TestCase {

    /**
     * @param args
     * @throws IOException
     */
    public void testHdfsDownload() throws IOException {
        HdfsUploadFileImpl m = new HdfsUploadFileImpl();
        m.createFile("test/test3.txt", "1234567890");

        HdfsDownloadFile d = new HdfsDownloadFileImpl();

        String folder = "/data/cmcc/test/";
        String path = folder + "test3.txt";

        boolean isSucc = d.exists(path);
        assertTrue(isSucc);

        long size = d.getFileSize(path);
        assertTrue(size > 0);

        BufferedReader r = d.open(path);
        if (r != null) {
            r.close();
        }
        assertNotNull(r);

        List<String> list = d.getFolderFiles(folder, true, true);
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

}
