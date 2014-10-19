/**  
 * FtpDownConfModel.java
 * com.cmcc.optimize.datamodel.sync
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午3:38:41
 * 版权所有
 */
package com.cmcc.optimize.datamodel.sync;

import java.util.List;

import com.cmcc.optimize.datamodel.BaseModel;

/**
 * ftp下载配置数据模型
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午3:38:41
 */

public class FtpDownConfModel extends BaseModel {

    /**
     * 随机的序列化id
     */
    private static final long serialVersionUID = 6409656570772928410L;

    private String host;// ftp ip地址

    private String port;// ftp端口

    private String userName;// ftp用户名，匿名为：anonymous

    private String password;// ftp密码

    private String cornString;// 定时调度表达式

    private String customJobClass;// 指定

    private String fileNameRule;// 下载ftp目录下的文件类型

    private String ftpFolder;// ftp文件监视目录

    private String localFolder;// 本地缓存目录下的二级目录

    private String appointDay; // 指定的日期

    private List<String> checkFileList;// 文件验证列表

    private String checkCornString;// 文件验证corn表达式

    private boolean needListSubFtpFiles;// 是否需要列出子目录中的文件

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the cornString
     */
    public String getCornString() {
        return cornString;
    }

    /**
     * @param cornString the cornString to set
     */
    public void setCornString(String cornString) {
        this.cornString = cornString;
    }

    /**
     * @return the fileNameRule
     */
    public String getFileNameRule() {
        return fileNameRule;
    }

    /**
     * @param fileNameRule the fileNameRule to set
     */
    public void setFileNameRule(String fileNameRule) {
        this.fileNameRule = fileNameRule;
    }

    /**
     * @return the ftpFolder
     */
    public String getFtpFolder() {
        return ftpFolder;
    }

    /**
     * @param ftpFolder the ftpFolder to set
     */
    public void setFtpFolder(String ftpFolder) {
        this.ftpFolder = ftpFolder;
    }

    /**
     * @return the localFolder
     */
    public String getLocalFolder() {
        return localFolder;
    }

    /**
     * @param localFolder the localFolder to set
     */
    public void setLocalFolder(String localFolder) {
        this.localFolder = localFolder;
    }

    /**
     * @return the appointDay
     */
    public String getAppointDay() {
        return appointDay;
    }

    /**
     * @param appointDay the appointDay to set
     */
    public void setAppointDay(String appointDay) {
        this.appointDay = appointDay;
    }

    public List<String> getCheckFileList() {
        return checkFileList;
    }

    public void setCheckFileList(List<String> checkFileList) {
        this.checkFileList = checkFileList;
    }

    public String getCheckCornString() {
        return checkCornString;
    }

    public void setCheckCornString(String checkCornString) {
        this.checkCornString = checkCornString;
    }

    public String getCustomJobClass() {
        return customJobClass;
    }

    public void setCustomJobClass(String customJobClass) {
        this.customJobClass = customJobClass;
    }

    public boolean isNeedListSubFtpFiles() {
        return needListSubFtpFiles;
    }

    public void setNeedListSubFtpFiles(boolean needListSubFtpFiles) {
        this.needListSubFtpFiles = needListSubFtpFiles;
    }

}
