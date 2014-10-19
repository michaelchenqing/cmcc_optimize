/**  
 * TestMain.java
 * com.cmcc.optimize.datasyc.runtime
 * 
 * @author gaoqs
 * @date 2014年8月27日 下午12:06:05
 * 版权所有
 */
package com.cmcc.optimize.datasyc.runtime;

import java.util.List;

import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClientImpl;

/**
 * 测试main
 * 
 * @author gaoqs
 * @date 2014年8月27日 下午12:06:05
 */

public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        FtpDownloadClient client = new FtpDownloadClientImpl(true);
        boolean isSucc = client.login("10.101.159.11", 21, "Asion", "asionsys2012");
        System.out.println("login:" + isSucc);
        for (int i = 0; i < 10; i++) {
            try {
                List<String> list = client.getFilesInFolderWithSub("/oracle/Data/mianyang/GB2DB/GB/src/IUPS_3/SIG");
                if (list != null && list.size()>0) {
                    for (String string : list) {
                        System.out.println("file:" + string);
                    }
                } else {
                    System.out.println("=" + i);
                }

                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("+++" + e);
                e.printStackTrace();
            }
        }

    }

}
