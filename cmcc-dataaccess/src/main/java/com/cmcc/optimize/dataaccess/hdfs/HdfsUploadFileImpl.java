/**  
 * HdfsUploadFileImpl.java
 * com.cmcc.optimize.dataaccess.hdfs
 * 
 * @author gaoqs
 * @date 2014年6月21日 上午11:05:55
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.hdfs;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.Path;

import com.cmcc.log4j.CmccLogger;

/**
 * hdfs文件上传 win本地测试，设置haddop服务器目录权限：./hadoop fs -chmod 777 /
 * 
 * @author zhou
 */
public class HdfsUploadFileImpl extends AbstractHdfsClient implements HdfsUploadFile {

    private static final CmccLogger logger = CmccLogger.getLogger(HdfsUploadFileImpl.class);// 日志

    /**
     * 获取一个随机的存储目录路径
     * 
     * @return
     */
    private String getUuidFilePath() {
        return HOME_PATH + DEFAULT_FILE_PATH + System.currentTimeMillis() / 1000 + "_" + UUID.randomUUID().toString();
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFile#createFile(java.lang.String, byte[])
     */
    public String createFile(String filePath, byte[] data) {
        if (!initConf()) {
            return null;
        }

        FSDataOutputStream out = null;
        try {
            out = hdfs.create(new Path(HOME_PATH +DEFAULT_FILE_PATH+ filePath));
            out.write(data);
            return filePath;
        } catch (IOException ioe) {
            logger.warn("create hdfs file fail："+filePath, ioe);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("close output error:", e);
                }
            }
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFile#createFile(java.lang.String, java.lang.String)
     */
    public String createFile(String filePath, String data) {
        if (!initConf()) {
            return null;
        }

        FSDataOutputStream out = null;

        try {
            out = hdfs.create(new Path(HOME_PATH + DEFAULT_FILE_PATH+filePath));
            out.writeUTF(data);
            return filePath;
        } catch (IOException ioe) {
            logger.warn("create hdfs file fail："+filePath, ioe);
            return null;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("close output error:", e);
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFile#createFile(java.lang.String, java.io.InputStream)
     */
    public String createFile(String filePath, InputStream in) {
        if (!initConf())
            return null;

        FSDataOutputStream out = null;
        try {
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            out = hdfs.create(new Path(HOME_PATH +DEFAULT_FILE_PATH+ filePath));
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            return filePath;
        } catch (IOException ioe) {
            logger.warn("create hdfs file fail："+filePath, ioe);
            return null;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("close output error:", e);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("close input error:", e);
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFile#createFile(java.lang.String)
     */
    public String createFile(String data) {
        return createFile(getUuidFilePath(), data);
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFile#createFile(byte[])
     */
    public String createFile(byte[] data) {
        return createFile(getUuidFilePath(), data);
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFile#createFile(java.io.InputStream)
     */
    public String createFile(InputStream in) {
        return createFile(getUuidFilePath(), in);
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFile#setDefaultUploadFolderPath(java.lang.String)
     */
    @Override
    public void setDefaultUploadFolderPath(String folder) {
        if (StringUtils.isNotBlank(folder)) {
            DEFAULT_FILE_PATH = folder;
        }

    }

}
