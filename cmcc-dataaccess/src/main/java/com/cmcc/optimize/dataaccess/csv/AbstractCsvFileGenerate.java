/**  
 * AbstractCsvFileGenerate.java
 * com.cmcc.optimize.dataaccess.csv
 * 
 * @author gaoqs
 * @date 2014年7月1日 上午10:42:00
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.cmcc.log4j.CmccLogger;

import cn.cas.common.utils.StringUtils;

/**
 * csv文件按文件流方式输出
 * 
 * @author gaoqs
 * @date 2014年7月1日 上午10:42:00
 */

public abstract class AbstractCsvFileGenerate {

    public String SPLIT_FLAG = ",";// csv文件字段分隔字符串

    protected final CmccLogger logger = CmccLogger.getLogger(this.getClass());// 日志

    public int FILE_FLUSH_SIZE = 100000;// 单次文件写入缓冲大小

    public String DEFAULT_ENCODING = "UTF-8";// 默认文件编码

    /**
     * 生成csv文件 默认文件编码utf-8
     * 
     * @param filePath 本地文件路径
     * @return 是否生成
     */
    public boolean generateCsvFile(String filePath) {
        return generateCsvFile(filePath, DEFAULT_ENCODING);
    }

    /**
     * 生成csv文件 指定文件编码
     * 
     * @param filePath 本地文件路径
     * @param encoding 文件编码
     * @return 是否生成
     */
    public boolean generateCsvFile(String filePath, String encoding) {
        if (StringUtils.isBlank(filePath)) {
            return false;
        }

        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            csvFile = new File(new String(filePath.getBytes(), encoding));
            File parent = csvFile.getParentFile();

            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), encoding), FILE_FLUSH_SIZE);

            // 生成标头
            generateHeader(csvFileOutputStream);

            // 生成内容
            generateBody(csvFileOutputStream);

        } catch (Exception e) {
            logger.error("generate csv file error:" + filePath + "@" + encoding, e);
            return false;
        } finally {
            if (csvFileOutputStream != null) {
                try {
                    csvFileOutputStream.close();
                } catch (IOException e) {
                    logger.error("close file output stream error:" + filePath + "@" + encoding, e);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 生成文件标头
     * 
     * @param csvFileOutputStream
     * @exception 生成异常
     */
    public abstract void generateHeader(BufferedWriter csvFileOutputStream) throws Exception;

    /**
     * 生成文件实体
     * 
     * @param csvFileOutputStream
     * @exception 生成异常
     */
    public abstract void generateBody(BufferedWriter csvFileOutputStream) throws Exception;

}
