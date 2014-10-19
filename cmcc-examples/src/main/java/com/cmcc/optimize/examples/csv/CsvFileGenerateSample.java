/**  
 * CsvFileGenerateSample.java
 * com.cmcc.optimize.examples.csv
 * 
 * @author gaoqs
 * @date 2014年7月1日 上午10:58:42
 * 版权所有
 */
package com.cmcc.optimize.examples.csv;

import java.io.BufferedWriter;

import junit.framework.Assert;

import com.cmcc.optimize.dataaccess.csv.AbstractCsvFileGenerate;

/**
 * 生成csv文件示例
 * 
 * @author gaoqs
 * @date 2014年7月1日 上午10:58:42
 */

public class CsvFileGenerateSample extends AbstractCsvFileGenerate {

    /**
     * main函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        CsvFileGenerateSample main = new CsvFileGenerateSample();

        // csv抽象类的相关属性，以下为默认值，可不设置
        main.DEFAULT_ENCODING = "UTF-8";
        main.SPLIT_FLAG = ",";
        main.FILE_FLUSH_SIZE = 1024;

        //生成csv文件
        boolean isSucc = main.generateCsvFile("/data/ftp/csv/test.csv");

        Assert.assertTrue(isSucc);

    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.csv.AbstractCsvFileGenerate#generateHeader(java.io.BufferedWriter)
     */
    @Override
    public void generateHeader(BufferedWriter csvFileOutputStream) throws Exception {
        csvFileOutputStream.write("编号,名称,年龄");// 写入标题
        csvFileOutputStream.newLine();// 写入换行
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.csv.AbstractCsvFileGenerate#generateBody(java.io.BufferedWriter)
     */
    @Override
    public void generateBody(BufferedWriter csvFileOutputStream) throws Exception {

        for (int i = 0; i < 10000000; i++) {
            if (i > 0) {
                csvFileOutputStream.newLine();// 写入换行
            }
            csvFileOutputStream.write("id" + i);
            csvFileOutputStream.write(",");
            csvFileOutputStream.write("name" + i);
            csvFileOutputStream.write(",");
            csvFileOutputStream.write("age" + i);
        }

    }

}
