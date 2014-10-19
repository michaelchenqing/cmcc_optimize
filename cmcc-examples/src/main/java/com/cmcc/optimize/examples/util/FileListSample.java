/**  
 * FileListSample.java
 * com.cmcc.optimize.examples.util
 * 
 * @author gaoqs
 * @date 2014年7月10日 下午3:17:21
 * 版权所有
 */
package com.cmcc.optimize.examples.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.cmcc.optimize.dataaccess.util.DateUtil;
import com.cmcc.optimize.datamodel.signal.SignalHttpModel;
import com.cmcc.optimize.datasyc.config.ConfigUtils;

/**
 * 列出目录下的文件
 * 
 * @author gaoqs
 * @date 2014年7月10日 下午3:17:21
 */

public class FileListSample {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // File files[] = new File("D:\\data\\ftp").listFiles();
        // for (File file : files) {
        // if (file.isDirectory()) {
        // continue;
        // }
        // if (file.getName().toLowerCase().endsWith(".csv")) {
        // System.out.println("job.processFile(\"" + file.getAbsolutePath().replace("\\", "/") + "\", \"" +
        // file.getName().substring(file.getName().indexOf("_YY_") + "_YY_".length(), file.getName().length() -
        // ".csv".length()) + "\",10000);");
        // }
        // }
        // String tableName = "MB_TER_CNT_CELL";
        // StringBuffer buffer = new StringBuffer();
        // for (String word : tableName.toLowerCase().split("_")) {
        // buffer.append(word.substring(0, 1).toUpperCase() + word.replaceFirst("\\w", ""));
        // }
        // System.out.println(buffer.toString());

        // System.out.println(Arrays.asList("1,1,232,423,2".split(",")).contains("232"));
        //
        // SignalHbaseImport s = new SignalHbaseImport();
        // s.signalFileImport("C:\\Users\\peng\\Desktop\\四川移动数据\\HTTP20140824220600.csv");
        // List<Object> ob = new ArrayList<Object>();
        // List<SignalHttpModel> list = ob;
        // si.setCell(0);
        // System.out.println(si.toJsonString());

        // System.out.println(10000000);
        // FtpFileProcessConfig ftp = new FtpFileProcessConfig();
        // 手工回导时，删除不需要回导的文件

        System.out.println(getFilePath("547719/TD-LTE_MRS_HUAWEI_010098148132_547719_20140815000000.xml.gz"));
        // System.out.println(getFilePath("TD-LTE_MRS_NSN_OMC_958104_20140909230000.xml.tar.gz"));
        // System.out.println(getFilePath("TD-LTE_MRE_ZTE_OMCR1_528863_20140909070000.zip"));
        // System.out.println(getFilePath("TD-LTE_MRS_ERICSSON_OMC1_960352_20140916031500.xml.zip"));
    }

    /**
     * 传入文件名获得相应的标准化文件名 例如：传入： NSN-LTE-MRO-2014-08-20.tar.gz，输出：MRS/NSN/20140909/23/
     * 
     * @param fileName
     * @return
     */
    public static String getFilePath(String fileName) {
        String tempFileName = fileName.toLowerCase();

        StringBuffer buff = new StringBuffer();
        String[] args = tempFileName.split("_");
        buff.append("lte/");
        // 类型
        buff.append(args[1]).append("/");
        // 厂商
        buff.append(args[2]).append("/");
        // 年月日
        buff.append(args[5].substring(0, 8)).append("/");
        // 小时
        buff.append(args[5].substring(8, 10)).append("/");
        // 文件

        buff.append(fileName.substring(fileName.lastIndexOf("/") + 1));
        return buff.toString();
    }

}
