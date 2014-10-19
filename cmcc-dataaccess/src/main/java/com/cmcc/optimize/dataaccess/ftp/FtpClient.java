/**  
 * FtpClient.java
 * com.cmcc.optimize.dataaccess.ftp
 * 
 * @author gaoqs
 * 
 * @date 2014年6月21日 上午11:11:10
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.ftp;

/**
 * ftp要地接口
 * 
 * @author goaqs
 * @date 2014年6月21日 上午11:11:10
 */

public interface FtpClient {

    /**
     * 用户登陆连接，匿名登陆
     * 
     * @param host 主机地址
     * @return
     */
    public boolean login(String host);

    /**
     * 用户登陆连接，默认端口21登陆
     * 
     * @param host 主机地址
     * @param userName　用户名
     * @param password　密码
     * @return
     */
    public boolean login(String host, String userName, String password);

    /**
     * 用户登陆连接，指定所有登陆信息登陆
     * 
     * @param host 主机地址
     * @param port　端口
     * @param userName　用户名
     * @param password　密码
     * @return
     */
    public boolean login(String host, int port, String userName, String password);
    
    /** 
     * 关闭ftp连接
     *
     * @return
     */
    public boolean loginOut();
    
    /** 
     * 设置连接和文件名的默认编码
     *
     * @param encoding 默认为GBK
     */
    public void setDefaultEncoding(String encoding);

}
