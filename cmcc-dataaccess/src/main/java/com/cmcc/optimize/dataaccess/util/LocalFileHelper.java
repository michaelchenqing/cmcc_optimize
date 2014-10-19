/**  
 * LocalFileUtil.java
 * com.cmcc.optimize.dataaccess.util
 * 
 * @author gaoqs
 * @date 2014年8月19日 下午4:31:01
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.cmcc.log4j.CmccLogger;

/**
 * 本地文件处理辅助类
 * 
 * @author gaoqs
 * @date 2014年8月19日 下午4:31:01
 */

public class LocalFileHelper {

    private static final CmccLogger logger = CmccLogger.getLogger(LocalFileHelper.class);// 日志

    private String csvEncoding = "GB18030"; // CSV默认字符集

    private int batchSize = 10000; // 批量插入批次大小

    public BufferedReader br = null; // 数据读取器

    private InputStream in = null; // 输入流

    private TarArchiveInputStream tin = null; // Tar文件输入流

    private FileInputStream fin = null; // 文件流

    /**
     * 获取下一批次行列
     * 
     * @param path
     * @return
     */
    public List<String> getNextBatchLines(String path, int ignoreRows) {
        int idx = 0;
        if (br == null) {
            br = getFileBufferedReaderByPath(path);
            idx = 0 - ignoreRows;// FtpFileProcessConfig.getFileTemplateMapByPath(path).getIgnoreRows();
        }

        String line = null;
        List<String> lines = new ArrayList<String>();
        try {
            // read ignore lines;
            while (idx < 0) {
                line = br.readLine();
                idx++;
            }

            while (idx < batchSize && (line = br.readLine()) != null) {
                lines.add(line);
                idx++;
            }
            return lines;
        } catch (IOException ioe) {
            logger.error(ioe);
        }
        return null;
    }

    /**
     * 获取文件解析后的输入流
     * 
     * @param path
     * @return
     */
    public BufferedReader getFileBufferedReaderByPath(String path) {
        String csvFilePath = "";
        try {
            String tmpPath = path;
            fin = new FileInputStream(path);
            in = Channels.newInputStream(fin.getChannel());

            if (tmpPath.endsWith(".gz")) {
                // 解压文件
                in = new GzipCompressorInputStream(in, true);
                tmpPath = tmpPath.substring(0, tmpPath.length() - 3);
            }

            if (tmpPath.endsWith(".tar")) {
                tin = new TarArchiveInputStream(in);
                TarArchiveEntry entry = tin.getNextTarEntry();
                // 规范为一个tar文件对应一个csv文件
                while (entry != null) {
                    if (entry.isDirectory()) {
                        entry = tin.getNextTarEntry();
                        continue;
                    }
                    // 记录csv文件名
                    csvFilePath = entry.getName();
                    break;
                }
                in = tin;
            }

            if (tmpPath.endsWith(".csv")) {
                csvFilePath = tmpPath;
            }

            // 记录文件名
            if (logger.isDebugEnabled()) {
                logger.debug("Csv FileName：" + csvFilePath);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(in, csvEncoding));
            return reader;
        } catch (IOException ioe) {
            logger.error("Parse File Error : " + path, ioe);
            return null;
        }
    }

    /**
     * 关闭文件流
     */
    public void closeStreams() {
        if (in != null) {
            try {
                in.close();
            } catch (Exception e) {
                logger.error("Close Input Stream Failed ", e);
            }
        }

        if (tin != null) {
            try {
                tin.close();
            } catch (Exception e) {
                logger.error("Close TarArchiveInputStream Stream Failed ", e);
            }
        }

        if (fin != null) {
            try {
                fin.close();
            } catch (Exception e) {
                logger.error("Close TarArchiveInputStream Stream Failed ", e);
            }
        }
    }

    public String getCsvEncoding() {
        return csvEncoding;
    }

    public void setCsvEncoding(String csvEncoding) {
        this.csvEncoding = csvEncoding;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public BufferedReader getBr() {
        return br;
    }

    /**
     * 获取目录下的所有文件
     * 
     * @param folder 目录
     * @return 目录下，含子目录的文件路径
     */
    public static List<String> getAllFilesInFolder(String folder) {
        List<String> result = new ArrayList<String>();

        File folderFile = new File(folder);
        if (!folderFile.exists() || folderFile.isFile()) {
            return result;
        }

        File files[] = new File(folder).listFiles();

        for (File file : files) {
            getFilesInFolder(file, result);
        }

        return result;
    }

    /**
     * 获取目录下的文件
     * 
     * @param file 当前文件
     * @param result 返回结果
     */
    public static void getFilesInFolder(File file, List<String> result) {
        if (file.isDirectory()) {
            File files[] = file.listFiles();
            for (File file2 : files) {
                getFilesInFolder(file2, result);
            }
        } else {
            String path = file.getAbsolutePath().replace("\\", "/");
            if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") == -1) {
                // linux补全路径
                if (!StringUtils.startsWith(path, "/")) {
                    path = "/" + path;
                }
            }

            result.add(path);
        }
    }

    /**
     * 删除多个文件
     * 
     * @param list 文件列表
     */
    public static void deleteFiles(List<String> list) {
        for (String path : list) {
            deleteFiles(path);
        }
    }

    /**
     * 删除单个文件
     * 
     * @param path 文件路径
     */
    public static void deleteFiles(String path) {
        try {
            FileUtils.forceDelete(new File(path));
        } catch (IOException e) {
            logger.error("file has backed,but delte file fail:" + path, e);
        }
    }
}
