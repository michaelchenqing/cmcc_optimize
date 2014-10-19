/**  
 * HdfsUploadFile.java
 * com.cmcc.optimize.dataaccess.hdfs
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:05:55
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.hdfs;

import java.io.InputStream;

/**
 * 在hdfs上新建文件
 * 
 * @author zhou
 */
public interface HdfsUploadFile {

    /**
     * 上传byte[]文件，使用指定文件路径
     * 
     * @param filePath hdfs文件路径
     * @param data 文件内容，byte[]
     * @return
     */
    public String createFile(String filePath, byte[] data);

    /**
     * 上传字符串文件，使用指定文件路径
     * 
     * @param filePath hdfs文件路径
     * @param data 文件内容
     * @return
     */
    public String createFile(String filePath, String data);

    /**
     * 上传流文件，使用指定文件路径
     * 
     * @param filePath hdfs文件路径
     * @param in 输入流
     * @return
     */
    public String createFile(String filePath, InputStream in);

    /**
     * 上传字符串文件，使用随机文件路径
     * 
     * @param data 文件内容，字符串
     * @return
     */
    public String createFile(String data);

    /**
     * 上传byte[]文件，使用随机文件路径
     * 
     * @param data 文件内容，byte[]
     * @return
     */
    public String createFile(byte[] data);

    /**
     * 上传流文件，使用随机文件路径
     * 
     * @param in
     * @return
     */
    public String createFile(InputStream in);
    
    /** 
     * 设置默认的上传目录
     *
     * @param folder
     */
    public void setDefaultUploadFolderPath(String folder);

}
