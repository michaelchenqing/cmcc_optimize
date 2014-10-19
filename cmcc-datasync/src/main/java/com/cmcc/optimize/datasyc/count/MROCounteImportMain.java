/**  
 * MROCounteImportMain.java
 * com.cmcc.optimize.datasyc.count
 * 
 * @date 2014年7月22日 上午10:57:57
 * 版权所有
 */
package com.cmcc.optimize.datasyc.count;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import cn.cas.common.collect.Marker;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCommonProcessDAO;
import com.cmcc.optimize.dataaccess.dao.ibatis.ExtIbatisCommonProcessDAO;
import com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFile;
import com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFileImpl;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;
import com.cmcc.optimize.datamodel.sync.FtpFileMappingModel;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;
import com.cmcc.optimize.datasyc.scheduler.FtpDownLoadSchedulerJob;

/**
 * 　备份mro数据到hdfs，并统计mro数据入oracle
 * 
 * @author gaoqs
 * @date 2014年7月22日 上午10:57:57
 */

public class MROCounteImportMain {

    private static final CmccLogger logger = CmccLogger.getLogger(MROCounteImportMain.class);// 日志

    private static final Pattern pattern = Pattern.compile("[0-9]{4}(\\-)[0-9]{2}(\\-)[0-9]{2}"); // 年月日，取mro文件中的日期

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 年月日，格式化

    private static final ExtCommonProcessDAO extCommonProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCommonProcessDAO.class, "extCommonProcessDAO"); // ibatisDao

    private static final String MRO_LOCAL_FILE_FOLDER = "G:/四川移动数据/";// mro文件数据目录
    

    private static final HdfsUploadFile hdfsUpload = new HdfsUploadFileImpl();// hdfs上传

    private static Marker marker;// redis标记
    
    private static final DecimalFormat df=new DecimalFormat("#.000");//格式化double输出为3位小数 

    /**
     * main函数 mro文件格式：SICHUAN_TDLTE_MRO_ZTE_20140721.tar.gz
     * 
     * @param args
     */
    public static void main(String[] args) {
        MROCounteImportMain main = new MROCounteImportMain();
        marker = FtpDownLoadSchedulerJob.getFtpFileProcessMarker();

        // 检测mro目录下是否有mro未备份统计的文件
        File files[] = new File(MRO_LOCAL_FILE_FOLDER).listFiles();
        for (File file : files) {
            String fileName = file.getName();
            //|| !fileName.toLowerCase().startsWith("zte-mro-")
            if (file.isDirectory() || !fileName.toLowerCase().endsWith(".tar.gz") ) {
                continue;
            }
            try {
                // 处理mro文件
                main.processMroFile(file);
            } catch (Exception e) {
                logger.error("process mro file error:" + file.getName(), e);
            }
        }

    }

    /**
     * 处理单个mro文件
     * 
     * @param file　mro文件
     */
    private void processMroFile(File file) {
        String fileName = file.getName();

        // 1.读取mro的文件，解析出日期
        Matcher m=pattern.matcher(fileName);
        String date =null;
        if(m.find()){
        	 date = m.group();// 文件日期
        }
        // 2.统计内部的xml个数及文件大小，入库
        int xmlNnums = getFileInTarGzWithType(file, null);

        List<Object> valueList = new ArrayList<Object>();
        try {
            valueList.add(format.parse(date));
        } catch (ParseException e) {
            valueList.add(new Date());// 出错，使用当前日期
            logger.error("parse mro file date time error:" + date);
        }

        valueList.add("MRO");// 数据类型
        valueList.add(null);// 省为空
        valueList.add(null);// 市为空
        valueList.add("MRO");// data_generation
        valueList.add(null);// original_record_num
        valueList.add(xmlNnums);// original_file_num
        valueList.add(df.format(file.length()*1.0/1024.0/1024.0));// original_file_size
        valueList.add(null);// data_origin

        boolean isSucc = extCommonProcessDAO.insert(FtpFileMappingModel.countTableName, FtpFileMappingModel.countTableColumNames, valueList);
        if (!isSucc) {
            logger.warn("save mro count data error:" + fileName);
        }

        // 3.检测缓存中是否存在
        String redisCheckKey = null;
        
        try {
            redisCheckKey = FtpFileProcessConfig.getRedisMarkerBackupSucc(file.getName());
        } catch (Exception e) {
            logger.error("get redis key error:" + file.getName(), e);
        }

        Object cacheValue = marker.getMark(redisCheckKey);
        if (cacheValue != null && StringUtils.equals("true", cacheValue.toString())) {
            if (logger.isInfoEnabled()) {
                logger.info("mro file has back up success:" + file.getName());
            }
            return;
        }

        // 4.备份到hdfs中
        String hdfsPath = "mro/" + date.substring(0, 4) + "/" + date + "/" + file.getName();// mro/2014/20140801/sichuan_tdlte_mro_zte_20140801.tar.gz

        String resultPath = null;
        try {
            resultPath = hdfsUpload.createFile(hdfsPath, new FileInputStream(file));
        } catch (FileNotFoundException e) {
            logger.error("mro file not found :" + file.getName(), e);
        }

        if (StringUtils.equals(hdfsPath, resultPath)) {
            if (logger.isDebugEnabled()) {
                logger.debug("backup mro file succ:" + hdfsPath);
            }

            // 备份完成，设置标记，删除本地文件
            marker.set(redisCheckKey, "true");

            try {
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                logger.error("delete mro file error:" + file.getName(), e);
            }
        }
    }

    /**
     * 获取.tar.gz文件中指定文件后辍的文件个数
     * 
     * @param file 文件
     * @param endFlag 后辍
     * @return 符合条件的文件个数
     */
    public int getFileInTarGzWithType(File file, String endFlag) {
        if (file == null || file.isDirectory()) {
            return 0;
        }

        int totalFiles = 0;// 符合条件的文件数

        FileInputStream fin = null;// 文件流
        InputStream in = null;
        TarArchiveInputStream tin = null;

        try {
            fin = new FileInputStream(file);
            in = new GzipCompressorInputStream(fin, true);
            tin = new TarArchiveInputStream(in);

            TarArchiveEntry entry = tin.getNextTarEntry();
            while (entry != null) {// 统计所有符合后辍的节点
            	if(entry.isDirectory()){
            		entry = tin.getNextTarEntry();
            		continue;
            	}
                if (StringUtils.isNotBlank(endFlag)) {
                    if (entry.getName().toLowerCase().endsWith(endFlag.toLowerCase())) {
                        totalFiles++;
                    }
                } else {
                    totalFiles++;
                }
                entry = tin.getNextTarEntry();
            }
        } catch (Exception e) {
            totalFiles = 0;
            logger.error("count file end with:" + endFlag + " in  tar.gz file:" + file.getAbsolutePath() + " error", e);
        } finally {
            try {// 关闭输入流
                if (tin != null) {
                    tin.close();
                }
                if (in != null) {
                    in.close();
                }
                if (fin != null) {
                    fin.close();
                }
            } catch (Exception e) {
                logger.error("close file input stream error:" + file.getAbsolutePath() + ",endFlag:" + endFlag, e);
            }
        }

        return totalFiles;
    }

}
