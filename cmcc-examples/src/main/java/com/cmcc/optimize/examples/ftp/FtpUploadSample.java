/**  
 * FtpUploadSample.java
 * com.cmcc.optimize.examples.ftp
 * 
 * @author peng
 * @date 2014-8-27 下午5:01:11
 * 版权所有
 */
package com.cmcc.optimize.examples.ftp;

import java.io.UnsupportedEncodingException;

import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClientImpl;
import com.cmcc.optimize.dataaccess.ftp.up.FtpUploadClient;
import com.cmcc.optimize.dataaccess.ftp.up.FtpUploadClientImpl;

/**
 * ftp上传测试
 * 
 * @author peng
 * @date 2014-8-27 下午5:01:11
 */

public class FtpUploadSample {

    public static void main(String[] args) throws UnsupportedEncodingException {

        login("10.101.159.66", "Administrator", "111111");
    }

    public static void login(String host, String user, String password) throws UnsupportedEncodingException {
         FtpUploadClient f = new FtpUploadClientImpl();
         System.out.println(f.login(host, user, password));
         System.out.println(f.putFtpFile("/data/dataservice/mro/nuoxi/HTTP20140824220600.csv",
         "C:\\Users\\peng\\Desktop\\四川移动数据\\HTTP20140824220600.csv"));

//        FtpDownloadClient f = new FtpDownloadClientImpl();
//        f.login(host, user, password);
////        System.out.println(f.getFoldersInFolder("/OPTS/optsoutput/ASPS/Scan_OPTS_成都_网格1_20140909"));
//        for (String folder : f.getFilesInFolderWithSub("/OPTS/optsoutput/ASPS")) {
//            System.out.println(folder);
//            f.downLoadFile("/OPTS/optsoutput/ASPS/"+folder, "C:\\Users\\peng\\Desktop\\"+folder);
//        }
        // System.out.println(f.downLoadFile("/data/dataservice/mro/nuoxi/NSN-TDD-LTE-MRO-2014-08-20.tar.gz",
        // "C:\\Users\\peng\\Desktop\\四川移动数据\\111111111111.csv"));
    }
}
