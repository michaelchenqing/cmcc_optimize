/**  
 * FtpDownLoadSchedulerJob.java
 * com.cmcc.optimize.examples.csv
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午4:08:01
 * 版权所有
 */
package com.cmcc.optimize.examples.csv;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;
import com.cmcc.optimize.datasyc.scheduler.FtpDownLoadSchedulerJob;

/**
 * ftp下载定时调度，测试
 * 
 * @author gaoqs
 * @date 2014年6月21日 下午4:08:01
 */
public class LoadSchedulerJobTest {

    public static void main(String[] args) {
        FtpDownLoadSchedulerJob load = new FtpDownLoadSchedulerJob();
        FtpDownLoadSchedulerJob.getFtpFileProcessMarker();

        FtpFileProcessConfig ftpProcessConfig = new FtpFileProcessConfig();
        List<FtpDownConfModel> configList = ftpProcessConfig.getFtpConfigList();

        FtpDownConfModel config = null;

        String rule = "(sichuan_.*_YY_[0-9]{8}/sichuan_.*_YY_[0-9]{8,10}\\.csv\\.gz)|(sichuan_(TD|GSM)_.*_YY_[0-9]{1,8}.csv.gz)";
        for (FtpDownConfModel f : configList) {
            if (StringUtils.equals(f.getFileNameRule(), rule)) {
                config = f;
                break;
            }
        }

        // 设置job的相关的导入属性

        load.justImportFiles = new String[] { "sichuan_GSM_", "sichuan_TD_" };// 只导入扩减容数据
        config.setAppointDay("20140814");
        
        if (config != null) {
            System.out.println("use config:" + config);
            load.doJob(config);
        } else {
            System.out.println("no config...");
        }
    }

}
