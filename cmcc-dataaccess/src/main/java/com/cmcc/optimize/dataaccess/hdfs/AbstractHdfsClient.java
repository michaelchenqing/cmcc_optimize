/**  
 * AbstractHdfsClient.java
 * com.cmcc.optimize.dataaccess.hdfs
 * 
 * @author gaoqs
 * @date 2014年7月24日 上午10:02:27
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.hdfs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import cn.cas.common.io.FileUtils;

import com.cmcc.log4j.CmccLogger;

/**
 * 抽象的hdfs处理客户端类
 * 
 * @author gaoqs
 * @date 2014年7月24日 上午10:02:27
 */
public abstract class AbstractHdfsClient {

    private CmccLogger logger = CmccLogger.getLogger(this.getClass());// 日志

    protected FileSystem hdfs;// hdfs操作接口对象

    protected static final String PROPERTIES_FILE_PATH = "hdfs-uploadfile.properties";// 加载文件上传的默认的配置属性文件

    protected static String DEFAULT_FILE_PATH = "/data/default/";// 默认的数据存储目录

    protected static String HOME_PATH = "hdfs://hadoop-hdfs.com:9000";// 默认的hdfs访问地址

    protected Configuration conf;// hdfs配置管理类

    private static boolean hasLoadedPros = false;// 是否已经初始化配置

    /**
     * 加载hdfs的配置
     */
    protected synchronized void loadHdfsDefaultPros() {
        try {
            // 加载上传属性文件
            InputStream in = FileUtils.getRealInputStream(PROPERTIES_FILE_PATH);
            if (in != null) {
                if (logger.isDebugEnabled()) {
                    logger.debug("load hdfs-uploadfile.properties from src/");
                }
                loadProperties(in);
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("can not find properties for Hdfs upload file path, use default value def in src file");
                }
            }

            if (logger.isInfoEnabled()) {
                logger.info("hdfs upload_filepath = " + DEFAULT_FILE_PATH);
            }
        } catch (Exception e) {
            logger.error("load ",e);
        }
    }

    /**
     * 加载流中的属性文件，实始化对象属性，上传文件根目录
     * 
     * @param in
     * @return
     */
    protected boolean loadProperties(InputStream in) {
        Properties p = new Properties();
        try {
            p.load(in);
            DEFAULT_FILE_PATH = p.getProperty("upload_filepath");
        } catch (IOException ioe) {
            logger.warn("load hdfs properties file fail", ioe);
            return false;
        }
        return true;
    }

    /**
     * 加载配置core-site.xml配置文件，获取hdfs服务器地址
     * 
     * @return
     */
    protected boolean initConf() {

        if (!hasLoadedPros) {
            loadHdfsDefaultPros();
        }

        try {
            if (conf == null) {
                conf = new Configuration(false);// 默认不加载core-default.xml
                conf.addResource(FileUtils.getRealInputStream("hdfs-core-site.xml"));
                if (null != conf.get("fs.defaultFS") && conf.get("fs.defaultFS").length() > 0) {
                    HOME_PATH = conf.get("fs.defaultFS");
                    if (logger.isDebugEnabled()) {
                        logger.debug("hdfs HOME_PATH=" + HOME_PATH);
                    }
                }
            }
            if (hdfs == null) {
                hdfs = FileSystem.get(conf);
            }
            return true;
        } catch (IOException e) {
            logger.warn("init hdfs error:", e);
            return false;
        }
    }

}
