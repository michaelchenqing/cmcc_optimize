/**  
 * FtpUploadClientImpl.java
 * com.cmcc.optimize.dataaccess.ftp.up
 * 
 * @author peng
 * @date 2014-9-1 上午10:08:53
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.ftp.up;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;

import com.cmcc.optimize.dataaccess.ftp.AbstractFtpClient;

/**
 * ftp上传实现
 * 
 * @author peng
 * @date 2014-9-1 上午10:08:53
 */

public class FtpUploadClientImpl extends AbstractFtpClient implements FtpUploadClient {

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient#putFtpFile(java.lang.String)
     */
    @Override
    public boolean putFtpFile(String remotePath, String localPath) {

        InputStream inputStream = null;

        // 拆分目录和文件名，用于获取ftp文件
        String[] paths = splitFolderAndNmae(remotePath);
        if (paths == null || paths.length != 2) {
            logger.warn("remote path is not a valid file path:" + remotePath);
            return false;
        }

        try {

            // 设置FTP连接模式为PASV模式
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // 设置上传文件方式为binary
            ftpClient.setBufferSize(100000); // 单次缓存大小
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File localFile = new File(localPath);
            inputStream = new FileInputStream(localFile);
            ftpClient.makeDirectory(paths[0]);
            ftpClient.changeWorkingDirectory(paths[0]);

            return ftpClient.storeFile(remotePath, inputStream);
        } catch (Exception e) {
            logger.error("down ftp file error:" + remotePath + "@" + localPath, e);
            logger.notice("down ftp file error:" + remotePath + "@" + localPath + ",exception:" + e);
            return false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("close down outputstream error:" + remotePath + "@" + localPath, e);
                }
            }
        }
    }
}
