/**  
 * FtpUploadClient.java
 * com.cmcc.optimize.dataaccess.ftp.up
 * 
 * @author peng
 * @date 2014-9-1 上午10:07:37
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.ftp.up;

import com.cmcc.optimize.dataaccess.ftp.FtpClient;

/**
 * ftp上传接口
 * 
 * @author peng
 * @date 2014-9-1 上午10:07:37
 */

public interface FtpUploadClient extends FtpClient {

    /**
     * 上传远程文件
     * 
     * @param remotePath 远程文件
     * @param localPath 本地文件
     * @return
     */
    public boolean putFtpFile(String remotePath, String localPath);

}
