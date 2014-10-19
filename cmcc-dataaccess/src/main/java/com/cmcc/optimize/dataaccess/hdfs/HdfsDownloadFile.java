/**  
 * HdfsUploadFile.java
 * com.cmcc.optimize.dataaccess.hdfs
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:05:55
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.hdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;

/**
 * 下载处理hdfs文件
 * 
 * @author gaoqs
 */
public interface HdfsDownloadFile {

    /**
     * 列出指定hdfs目录下的文件
     * 
     * @param folder 目录
     * @param isContainSubFoler　包含子目录 true:列出所有目录含子目录下的文件
     * @param isContainFolder　包含目录　false:只列出文件
     * @return 路径列表
     */
    public List<String> getFolderFiles(String folder, boolean isContainSubFoler, boolean isContainFolder);

    /**
     * 指定路径文件的大小
     * 
     * @param path 文件路径
     * @return 目录大小为-1，不存在为-2，其他为文件的字节数，取文件出错-3
     */
    public long getFileSize(String path);

    /**
     * 打开文件的输入流
     * 
     * @param path　hdfs文件路径
     * @return 文件输入流
     * @throws IOException
     */
    public FSDataInputStream open(Path path) throws IOException;

    /**
     * 打开文件的输入流
     * 
     * @param path　文件路径
     * @return 文件输入流
     * @throws IOException
     */
    public BufferedReader open(String path) throws IOException;

    /**
     * 列出当前目录下一层的文件，含目录的hdfs文件类封装
     * 
     * @param path 文件夹目录
     * @return　文件列表
     * @throws IOException
     */
    public FileStatus[] listStatus(Path path) throws IOException;

    /**
     * hdfs的path是否存在
     * 
     * @param path hdfs path
     * @return true:存在
     */
    public boolean exists(Path path);

    /**
     * 　目录格式的文件是否存在
     * 
     * @param path 目录
     * @return true:存在
     */
    public boolean exists(String path);

}
