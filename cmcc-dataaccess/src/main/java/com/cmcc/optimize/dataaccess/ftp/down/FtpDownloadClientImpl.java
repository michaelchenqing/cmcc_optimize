/**  
 * FtpDownloadClient.java
 * com.cmcc.optimize.dataaccess.ftp
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:05:55
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.ftp.down;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;

import com.cmcc.optimize.dataaccess.ftp.AbstractFtpClient;

/**
 * ftp下载实现
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:05:55
 */

public class FtpDownloadClientImpl extends AbstractFtpClient implements FtpDownloadClient {

    /**
     * 默认不保持连接
     */
    public FtpDownloadClientImpl() {
    }

    /**
     * 是否保持连接
     * 
     * @param isKeepAlive
     */
    public FtpDownloadClientImpl(boolean isKeepAlive) {
        this.isKeepAlive = isKeepAlive;
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient#downLoadFile(java.lang.String, java.lang.String)
     */
    @Override
    public boolean downLoadFile(String remotePath, String localPath) {

        OutputStream outputStream = null;

        // 拆分目录和文件名，用于获取ftp文件
        String[] paths = splitFolderAndNmae(remotePath);
        if (paths == null || paths.length != 2) {
            logger.warn("remote path is not a valid file path:" + remotePath);
            return false;
        }

        try {
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // 设置下载文件方式为binary
            ftpClient.setBufferSize(200000); // 单次缓存大小
            // 进行编码转换以适应中文
            ftpClient.changeWorkingDirectory(new String(paths[0].getBytes(defaultEncoding), "iso-8859-1"));// 转移到FTP服务器目录

            // 检测本地缓存目录是否已经创建
            checkFolderExists(localPath, false);
            // 创建本地文件
            File localFile = new File(localPath);
            outputStream = new FileOutputStream(localFile);
            // 将文件保存到输出流outputStream中
            boolean flag = ftpClient.retrieveFile(new String(paths[1].getBytes(defaultEncoding), "ISO-8859-1"), outputStream);
            outputStream.flush();
            return flag;

            // FTPFile[] fs = ftpClient.listFiles(); // 得到目录的相应文件列表
            // for (FTPFile ff : fs) {
            // if (ff.getName().equals(paths[1])) {
            // // 检测本地缓存目录是否已经创建
            // checkFolderExists(localPath, false);
            // // 创建本地文件
            // File localFile = new File(localPath);
            // outputStream = new FileOutputStream(localFile);
            //
            // // 将文件保存到输出流outputStream中
            // ftpClient.retrieveFile(new String(ff.getName().getBytes(defaultEncoding), "ISO-8859-1"), outputStream);
            // outputStream.flush();
            //
            // return true;
            // }
            // }

        } catch (Exception e) {
            logger.error("down ftp file error:" + remotePath + "@" + localPath, e);
            logger.notice("down ftp file error:" + remotePath + "@" + localPath + ",exception:" + e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    logger.error("close down outputstream error:" + remotePath + "@" + localPath, e);
                }
            }
        }

        return false;

    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient#getFilesInFolder(java.lang.String)
     */
    @Override
    public List<String> getFilesInFolder(String folder) {
        return getSubFileOrFolderInFtp(folder, true);
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient#getFoldersInFolder(java.lang.String)
     */
    @Override
    public List<String> getFoldersInFolder(String folder) {
        return getSubFileOrFolderInFtp(folder, false);
    }

    /**
     * 获Ftp目录下文件（夹）列表
     * 
     * @param folder 根目录
     * @param isFile true:显示文件
     * @return
     */
    private List<String> getSubFileOrFolderInFtp(String folder, boolean isFile) {
        List<String> result = new ArrayList<String>();
        if (StringUtils.isBlank(folder)) {
            return result;
        }

        // 设置FTP连接模式为PASV模式
        ftpClient.enterLocalPassiveMode();

        try {
            ftpClient.changeWorkingDirectory(folder);
        } catch (IOException e) {
            // 判定ftpClient是否已经失效, 失效则重连，多文件目录失败重连
            if (!ftpClient.isConnected() || !ftpClient.isAvailable()) {
                if (logger.isInfoEnabled()) {
                    logger.info("when change folder,Ftpclient has reset, now try to relogin:" + host + "@" + port + "@" + username);
                }
                try {
                    boolean isSucc = reLogin();
                    if (!isSucc) {
                        logger.warn("change folder fail & login fail:" + host + "@" + port + "@" + username);
                        return result;
                    }
                    ftpClient.changeWorkingDirectory(folder);
                } catch (Exception e1) {
                    logger.error("chang to ftp folder error:" + folder, e1);
                    return result;
                }
            } else {
                logger.error("chang to ftp folder error,ftp has connected:" + folder, e);
                return result;
            }
        }

        FTPFile[] files = null;
        try {
            // 判定ftpClient是否已经失效, 失效则重连
            if (!ftpClient.isConnected() || !ftpClient.isAvailable()) {
                if (logger.isInfoEnabled()) {
                    logger.info("Ftpclient has reset, now try to relogin:" + host + "@" + port + "@" + username);
                }
                boolean isSucc = reLogin();
                if (logger.isInfoEnabled()) {
                    logger.info("Relogin result: " + isSucc + ":" + host + "@" + port + "@" + username);
                }
            }

            files = ftpClient.listFiles(folder);
            for (FTPFile file : files) {
                if (!isFile && file.isDirectory()) {
                    result.add(file.getName());
                }
                if (isFile && file.isFile()) {
                    result.add(file.getName());
                }
            }
        } catch (IOException e) {
            logger.error("list folder file error:" + folder + "@" + isFile, e);
        }

        return result;
    }

    /**
     * 检查本地文件目录是否存在
     * 
     * @param localPath
     * @return
     */
    private boolean checkFolderExists(String localPath, boolean isDir) {
        localPath = localPath.replace("\\", "/");
        File dir = new File(localPath);
        // 文件存在, 返回
        if (dir.exists()) {
            return true;
        } else {
            String parentPath = localPath.substring(0, localPath.lastIndexOf("/"));
            if (checkFolderExists(parentPath, true)) {
                // 如果是文件夹创建文件
                if (isDir)
                    return dir.mkdir();
                return true;
            } else {
                logger.error("Check ParentFolder Failed:" + parentPath);
                return false;
            }

        }
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient#getFilesInFolderWithSub(java.lang.String)
     */
    @Override
    public List<String> getFilesInFolderWithSub(String folder) {
        return getFilesInFolderWithSub(folder, folder, folder);
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient#getFilesInFolderWithSub(java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<String> getFilesInFolderWithSub(String folder, String needReplacePath) {
        return getFilesInFolderWithSub(folder, folder, needReplacePath);
    }

    /**
     * 循环获取ftp目录下的文件 ，不包含传入的根目录
     * 
     * @param folder 当前目录
     * @param basicFolder 替换的根目录
     * @param needReplacePath 需要被替换的根目录路径
     * @return
     */
    private List<String> getFilesInFolderWithSub(String folder, String basicFolder, String needReplacePath) {
        List<String> result = new ArrayList<String>();
        if (StringUtils.isBlank(folder)) {
            return result;
        }
        // 设置FTP连接模式为PASV模式
        ftpClient.enterLocalPassiveMode();

        String tempFolder = folder;
        try {
            // 如果是中文目录则需要进行转换
            tempFolder = new String(folder.getBytes("GBK"), "iso-8859-1");
            ftpClient.changeWorkingDirectory(tempFolder);
        } catch (IOException e) {
            logger.error("chang to ftp folder error:" + folder, e);
            return result;
        }

        FTPFile[] files = null;
        try {

            // 判定ftpClient是否已经失效, 失效则重连
            if (!ftpClient.isConnected() || !ftpClient.isAvailable()) {
                if (logger.isInfoEnabled()) {
                    logger.info("Ftpclient has reset, now try to relogin");

                    logger.info("Relogin result: " + reLogin());
                }
            }
            files = ftpClient.listFiles(tempFolder);
            for (FTPFile file : files) {
                if (StringUtils.isBlank(file.getName())) {
                    continue;
                }
                if (file.isDirectory()) {
                    String subFolder = folder + "/" + file.getName();
                    result.addAll(getFilesInFolderWithSub(subFolder, subFolder, needReplacePath));
                } else if (file.isFile()) {
                    String fileName = (folder + "/" + file.getName());
                    if (StringUtils.isNotBlank(needReplacePath)) {// 需要替换路径
                        fileName = fileName.replace(needReplacePath + "/", "");
                    }
                    result.add(fileName);
                }
            }
        } catch (IOException e) {
            logger.error("list folder file with sub error:" + folder, e);
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient#deleteFtpFile(java.lang.String)
     */
    public boolean deleteFtpFile(String remotePath) {

        try {
            if (StringUtils.isBlank(remotePath)) {
                return false;
            }
            if (logger.isInfoEnabled()) {
                logger.info("start delete ftp file:" + remotePath);
            }
            boolean isSucc = ftpClient.deleteFile(remotePath);

            if (!isSucc && logger.isInfoEnabled()) {
                logger.info("delete ftp file failed:" + remotePath);
            }

            return isSucc;
        } catch (Exception e) {
            logger.error("delete ftp file error:" + remotePath, e);
            logger.notice("delete ftp file error:" + remotePath + ",exception:" + e);
        }

        return false;

    }

}
