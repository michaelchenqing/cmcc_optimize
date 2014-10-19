/**  
 * AbstractHdfsBackup.java
 * com.cmcc.optimize.datasyc.backup
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:44:26
 * 版权所有
 */
package com.cmcc.optimize.datasyc.backup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFile;
import com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFileImpl;
import com.cmcc.optimize.datasyc.config.ConfigUtils;

/**
 * hdfs备份抽象类
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:44:26
 */

public abstract class AbstractHdfsBackup implements HdfsBackupInterface {

    private static final CmccLogger logger = CmccLogger.getLogger(AbstractHdfsBackup.class);// 日志

    protected static final int perPackageFileNums = 50;// 默认每50个文件打一个包

    protected static final HdfsUploadFile hdfsUpload = new HdfsUploadFileImpl();// hdfs上传

    private static final SimpleDateFormat importDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");// 导入日期格式化

//    private final String hostName = System.getProperty("user.name");// 系统名称
    private final String hostName = ConfigUtils.getHostName();// 系统名称

    /**
     * 压缩文件，并且备份到hdfs
     * 
     * @param path hdfs目录
     * @param localFiles 本地文件
     * @return
     */
    public boolean zipFileAndBackup(String path, List<String> localFiles, String localTempFolder) {

        // 获得当前时间
        String time = importDateFormat.format(new Date());

        String fileName = hostName + "_" + time + ".tar.gz";

        path += fileName;

        String ouputFilePath = localTempFolder + fileName;

        try {
            // 压缩
            File targetFile = new File(ouputFilePath);
            long startpack = System.currentTimeMillis();
            if (pack(localFiles, targetFile)) {
                long endtpack = System.currentTimeMillis();
                logger.info("====================打包耗时：" + (endtpack - startpack) + "ms=======================");

                long starthdfs = System.currentTimeMillis();
                String resultPath = hdfsUpload.createFile(path, new FileInputStream(ouputFilePath));
                long endthdfs = System.currentTimeMillis();
                logger.info("====================上传到hdfs耗时：" + (endthdfs - starthdfs) + "ms=======================");

                if (!StringUtils.equals(path, resultPath)) {
                    logger.warn("backup hdfs file fail:" + path);
                    return false;
                }

                if (logger.isDebugEnabled()) {
                    logger.debug("backup hdfs file succ:" + path);
                }

                // 删除压缩包
                FileUtils.forceDelete(targetFile);
            }
        } catch (Exception e) {
            logger.error("zip and store error", e);
        }

        return true;
    }

    /**
     * 将一组文件打成tar包
     * 
     * @param files 要打包的原文件
     * @param target 打包后的文件
     * @return 返回打包是否成功
     * @throws Exception
     */
    public boolean pack(List<String> files, File target) throws Exception {
        TarArchiveOutputStream taos = null;
        try {
            // 建立tar.gz压缩输出流
            taos = new TarArchiveOutputStream(new FileOutputStream(target));
        } catch (FileNotFoundException e) {
            logger.error("Create a file failed", e);
            return false;
        }

        for (String path : files) {
            File file = new File(path);
            FileInputStream temp = null;
            try {// TODO 设置编码，中文文件名乱码
                TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(file);// 此处必须使用new TarArchiveEntry(File file);
                tarArchiveEntry.setName(file.getName());// 此处需重置名称，默认是带全路径的，否则打包后会带全路径

                taos.putArchiveEntry(tarArchiveEntry);
                taos.setAddPaxHeadersForNonAsciiNames(true);
                temp = new FileInputStream(file);
                IOUtils.copy(temp, taos);// 将文件复制到创建的压缩包
                taos.closeArchiveEntry();

            } catch (Exception e) {
                logger.error("file not found", e);
                return false;
            } finally {
                if (temp != null) {
                    temp.close();
                }

            }
        }

        if (taos != null) {
            try {
                taos.flush();
                taos.close();
            } catch (IOException e) {
                logger.error("zip flush or close error", e);
                return false;
            }
        }

        return true;
    }
}
