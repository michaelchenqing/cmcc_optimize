/**  
 * CsvFtpFileDownProcessSample.java
 * com.cmcc.optimize.examples.csv
 * 
 * @author gaoqs
 * @date 2014年7月1日 下午4:44:03
 * 版权所有
 */
package com.cmcc.optimize.examples.csv;

import java.util.ArrayList;
import java.util.List;

import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;
import com.cmcc.optimize.datasyc.scheduler.FtpDownLoadSchedulerJob;
import com.cmcc.optimize.datasyc.scheduler.SacnFreqDownLoadSchedulerJob;

/**
 * 转换处理本地的ftp文件
 * 
 * @author gaoqs
 * @date 2014年7月1日 下午4:44:03
 */

public class CsvFtpFileDownProcessSample {

    public static void main(String[] args) {
        // 2、加载ftp文件下载配置
        new FtpFileProcessConfig();

        import0709();

    }

    /**
     * @param job
     */
    private static void import0709() {
//        SacnFreqDownLoadSchedulerJob job = new SacnFreqDownLoadSchedulerJob();
        FtpDownLoadSchedulerJob job = new FtpDownLoadSchedulerJob();
        String basePath = "G:\\";
        int batchNums = 1000;
        // job.justCount=true;

        List<String> file = new ArrayList<String>();
        job.justCount = true;
        String date = "20140925";
        // file.add("sichuan_Lte_LteProject_YY_"+date+".csv.gz");
        // file.add("sichuan_Lte_LtePlan_YY_"+date+".csv.gz");
        // file.add("sichuan_Lte_GSMTraffic_YY_" + date + ".csv.gz");
        // file.add("sichuan_Lte_LteTraffic_YY_" + date + ".csv.gz");
        // file.add("sichuan_Lte_TDSTraffic_YY_" + date + ".csv.gz");
        // for (int i = 13; i < 14; i++) {
        file.add("LTE_ty_data_20140925.csv");
        // }

        // file.add("sichuan_mianyang_Lte_DT_TY_02_20140814233649.csv");
        for (String string : file) {
            System.out.println("处理文件：" + string);
            String cleanDate = "20140911";// string.substring(string.indexOf("YY_") + 3, string.indexOf(".csv"));
            job.processFile(basePath + string, cleanDate, batchNums);
        }

    }

}
