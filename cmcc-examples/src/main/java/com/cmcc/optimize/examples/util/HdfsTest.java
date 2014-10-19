/**  
 * HdfsTest.java
 * com.cmcc.optimize.examples.util
 * 
 * @author peng
 * @date 2014-8-15 上午9:42:14
 * 版权所有
 */
package com.cmcc.optimize.examples.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.IOUtils;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.datamodel.signal.SignalHttpModel;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;

/**
 * TODO(这里用一句话描述这个类的作用)
 * 
 * @author peng
 * @date 2014-8-15 上午9:42:14
 */

public class HdfsTest {

    public static void main(String[] args) throws Exception {

        // List<File> files = new ArrayList<File>();
        // files.add(new File("G:\\test\\test\\HTTP20140817113600.csv"));
        // // files.add(new File("G:\\test\\test\\TCP20140817025200.csv"));
        //
        // pack(files, new File("G:\\test\\test\\test.tar.gz"));
        //
        // MRODownLoadSchedulerJob job = new MRODownLoadSchedulerJob();
        // System.out.println(job.getFileInTarGzWithType(new File("G:\\testdata\\NSN-LTE-MRO-2014-08-24.tar.gz"), ""));
        SignalHttpModel s = new SignalHttpModel();
        s.setId(System.nanoTime());
        System.out.println(s.getId());
    }

    private static final CmccLogger logger = CmccLogger.getLogger(FtpFileProcessConfig.class);// 日志

    /**
     * 将一组文件打成tar包
     * 
     * @param files 要打包的原文件
     * @param target 打包后的文件
     * @return 返回打包是否成功
     * @throws Exception
     */
    public static boolean pack(List<File> files, File target) throws Exception {
        TarArchiveOutputStream taos = null;
        try {
            // 建立tar.gz压缩输出流
            taos = new TarArchiveOutputStream(new FileOutputStream(target));
        } catch (FileNotFoundException e) {
            logger.error("Create a file failed", e);
            return false;
        }

        for (File file : files) {
            FileInputStream temp = null;
            try {
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
