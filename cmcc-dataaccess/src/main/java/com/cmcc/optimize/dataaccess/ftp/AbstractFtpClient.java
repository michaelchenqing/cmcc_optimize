/**  
 * AbstractFtpClient.java
 * com.cmcc.optimize.dataaccess.ftp
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:10:39
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.ftp;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.cmcc.log4j.CmccLogger;

/**
 * ftp抽象类
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:10:40
 */

public abstract class AbstractFtpClient implements FtpClient {

    protected final CmccLogger logger = CmccLogger.getLogger(this.getClass());// 日志

    protected FTPClient ftpClient = new FTPClient();// commons-net的ftp客户端

    protected String defaultEncoding = "GBK";// 默认的链接和文件名编码

    protected String host; // 主机

    protected int port; // 端口

    protected String username; // 用户名

    private String password; // 密码

    protected boolean isKeepAlive;// 保持 连接

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.FtpClient#login(java.lang.String)
     */
    @Override
    public boolean login(String host) {
        return login(host, "anonymous", "");
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.FtpClient#login(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean login(String host, String userName, String password) {
        return login(host, 21, userName, password);
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.FtpClient#login(java.lang.String, int, java.lang.String, java.lang.String)
     */
    @Override
    public boolean login(String host, int port, String userName, String password) {
        this.host = host;
        this.port = port;
        this.username = userName;
        this.password = password;
        return doLogin();
    }

    /**
     * 重新登陆
     * 
     * @return
     */
    public boolean reLogin() {
        return doLogin();
    }

    /**
     * 登陆操作
     * 
     * @return
     */
    private boolean doLogin() {
        try {
            // 检测ftp是否处于可用状态
            if (ftpClient.isConnected() && ftpClient.isAvailable()) {
                return true;
            }

            // 连接ftp服务器
            ftpClient.connect(host, port);
            if (logger.isDebugEnabled()) {
                logger.debug("connect to server:" + host + ":" + port);
            }

            // 获取响应字符串（FTP服务器上可设置）
            String replyString = ftpClient.getReplyString();
            if (logger.isDebugEnabled()) {
                logger.debug("ftp server:" + host + ":" + port + " replyString: " + replyString);
            }

            // 获取响应码用于验证是否连接成功
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                logger.warn("ftp response code not succ:" + reply);
                ftpClient.disconnect();
                return false;
            }

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setControlEncoding(defaultEncoding);

            // 登录服务器
            boolean loginStatus = ftpClient.login(username, password);

            // ftp保持连接
            if (loginStatus && isKeepAlive) {
                try {
                    if (logger.isDebugEnabled()) {
                        logger.debug("set keep alive:" + host + "@" + port);
                    }
                    ftpClient.setKeepAlive(isKeepAlive);
                } catch (Exception e) {
                    if (logger.isInfoEnabled()) {
                        logger.info("set keep alive fail:" + host + "@" + port, e);
                    }
                }
            }

            return loginStatus;
        } catch (Exception e) {
            logger.error("connect to ftp error,host:" + host + ",port:" + port + ",userName:" + username + ",password:" + password, e);
            logger.notice("connect to ftp error,host:" + host + ",port:" + port + ",userName:" + username + ",exception:" + e);
        }

        if (logger.isDebugEnabled()) {
            logger.error("ftp is not enable:" + host + ",port:" + port + ",userName:" + username + ",password:" + password);
        }

        return false;
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.FtpClient#loginOut()
     */
    @Override
    public boolean loginOut() {
        boolean loginOut = false;

        try {
            if (!ftpClient.isConnected() || !ftpClient.isAvailable() ||StringUtils.isBlank(ftpClient.getPassiveHost())) {
                if (logger.isDebugEnabled()) {
                    logger.debug("ftp has login out:" + host + "@" + port + "@" + username);
                }
                return true;
            }

            loginOut = ftpClient.logout();
        } catch (IOException e) {
            logger.error("ftp　login out error:" + ftpClient.getPassiveHost(), e);
        } finally {
            // 关闭链接
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    logger.error("ftp　close connection error:" + ftpClient.getPassiveHost(), e);
                }
            }

        }

        return loginOut;
    }

    /**
     * 获取文件目录和文件名
     * 
     * @param path 文件路径
     * @return 0:目录，１:文件名
     */
    protected String[] splitFolderAndNmae(String path) {
        if (StringUtils.isBlank(path)) {
            return null;
        }

        String[] result = new String[2];
        path = path.replace("\\", "/");

        if (!path.contains("/")) {
            path = "/" + path;
        }

        result[0] = path.substring(0, path.lastIndexOf("/"));
        result[1] = path.substring(path.lastIndexOf("/") + 1);

        return result;
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.ftp.FtpClient#setDefaultEncoding(java.lang.String)
     */
    @Override
    public void setDefaultEncoding(String encoding) {
        defaultEncoding = encoding;
    }

}
