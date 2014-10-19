/**  
 * HdfsUploadFileImpl.java
 * com.cmcc.optimize.dataaccess.hdfs
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:05:55
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.hdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.compress.GzipCodec;

import com.cmcc.log4j.CmccLogger;

/**
 * hdfs文件下载，设置haddop服务器目录权限：./hadoop fs -chmod 777 /
 * 
 * @author gaoqs
 */
public class HdfsDownloadFileImpl extends AbstractHdfsClient implements HdfsDownloadFile {

    private static final CmccLogger logger = CmccLogger.getLogger(HdfsDownloadFileImpl.class);// 日志

    private final GzipCodec gzipcodec = new GzipCodec();// 处理gzip流

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsDownloadFile#open(org.apache.hadoop.fs.Path)
     */
    public FSDataInputStream open(Path path) throws IOException {
        return hdfs.open(path);
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsDownloadFile#listStatus(org.apache.hadoop.fs.Path)
     */
    public FileStatus[] listStatus(Path path) throws IOException {
        return hdfs.listStatus(path);
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsDownloadFile#exists(java.lang.String)
     */
    @Override
    public boolean exists(String path) {
        Path pathObj = new Path(HOME_PATH + path);
        return exists(pathObj);
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsDownloadFile#exists(org.apache.hadoop.fs.Path)
     */
    public boolean exists(Path path) {
        try {
            if (!initConf()) {
                return false;
            }
            return hdfs.exists(path);
        } catch (IOException e) {
            logger.error("check hdfs exist path error:" + path.getName(), e);
            return false;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsDownloadFile#getFolderFiles(java.lang.String, boolean, boolean)
     */
    @Override
    public List<String> getFolderFiles(String folder, boolean isContainSubFoler, boolean isContainFolder) {
        List<String> list = new ArrayList<String>();
        Path pathObj = new Path(folder);
        try {
            if (!exists(pathObj)) {
                return list;
            }
            FileStatus fs = hdfs.getFileStatus(pathObj);
            if (fs.isFile()) {
                list.add(getFileStatusPath(fs));
            } else if (isContainSubFoler) {// 包含子目录
                FileStatus[] listStatus = listStatus(pathObj);
                for (FileStatus fileStatus : listStatus) {
                    String subFolder = getFileStatusPath(fileStatus);
                    if (isContainFolder) {// 包含目录路径
                        list.add(subFolder);
                    }
                    list.addAll(getFolderFiles(subFolder, isContainSubFoler, isContainFolder));
                }
            }
        } catch (IOException e) {
            logger.error("list folder error:" + folder, e);
        }
        return list;
    }

    /**
     * 获取filestatus 的相对路径
     * 
     * @param fileStatus　hdfs的文件　对象
     * @return　去除http地址后的相对路径
     */
    private String getFileStatusPath(FileStatus fileStatus) {
        return fileStatus.getPath().toUri().getPath().replace(HOME_PATH, "");
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsDownloadFile#getFileSize(java.lang.String)
     */
    @Override
    public long getFileSize(String path) {
        Path pathObj = new Path(HOME_PATH + path);
        if (!exists(pathObj)) {
            return -2;
        }
        try {
            FileStatus fs = hdfs.getFileStatus(pathObj);
            if (!fs.isFile()) {
                return -1;
            }
            return fs.getLen();
        } catch (IOException e) {
            logger.error("get hdfs path error:" + path, e);
            return -3;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsDownloadFile#open(java.lang.String)
     */
    @Override
    public BufferedReader open(String path) throws IOException {
        Path pathObj = new Path(HOME_PATH + path);
        InputStream is = open(pathObj);

        boolean gzip = path.toLowerCase().endsWith(".gz");
        if (gzip) {
            return new BufferedReader(new InputStreamReader(gzipcodec.createInputStream(is)));
        } else {
            return new BufferedReader(new InputStreamReader(is));
        }
    }

}
