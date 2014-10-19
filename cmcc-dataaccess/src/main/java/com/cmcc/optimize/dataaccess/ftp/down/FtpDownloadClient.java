/**  
 * FtpDownloadClient.java
 * com.cmcc.optimize.dataaccess.ftp
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:06:15
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.ftp.down;

import java.util.List;

import com.cmcc.optimize.dataaccess.ftp.FtpClient;

/**
 * ftp下载接口
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:06:15
 */

public interface FtpDownloadClient extends FtpClient {

    /**
     * 下载指定的ftp文件
     * 
     * @param remotePath 远程文件
     * @param localPath 本地文件
     * @return 是否下载成功
     */
    public boolean downLoadFile(String remotePath, String localPath);

    /**
     * 获取ftp指定目录下的文件名
     * 
     * @param folder ftp目录
     * @return 文件名列表
     */
    public List<String> getFilesInFolder(String folder);

    /**
     * 获取ftp指定目录下的文件名
     * 
     * @param folder ftp目录
     * @return 子文件夹列表
     */
    public List<String> getFoldersInFolder(String folder);

    /**
     * 获取ftp指定目录下的文件名，循环所有的子目录
     * 
     * @param folder ftp目录
     * @return 文件名列表 返回基于folder的相对路径，不包含folder
     */
    public List<String> getFilesInFolderWithSub(String folder);

    /**
     * 用于返回相对于指定目录的文件路径
     * 
     * @param folder 目录
     * @param needReplacePath 需要替换目录中的路径，null时，返回全路径
     * @return
     */
    public List<String> getFilesInFolderWithSub(String folder, String needReplacePath);

    /**
     * 删除远程文件
     * 
     * @param remotePath 远程文件
     * @return true：成功
     */
    public boolean deleteFtpFile(String remotePath);

}
