/**  
 * TestSampleJobs.java
 * com.cmcc.optimize.examples.quartz
 * 
 * @author gaoqs
 * @date 2014年8月27日 下午5:28:57
 * 版权所有
 */
package com.cmcc.optimize.examples.quartz;

import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import com.cmcc.optimize.dataaccess.util.DateUtil;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;

/**
 * 测试job
 * 
 * @author gaoqs
 * @date 2014年8月27日 下午5:28:57
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class TestSampleJobs implements Job {

    /*
     * (non-Javadoc)
     * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(DateUtil.dtFormat(new Date(), "yyyy-MM-dd hh:mm:ss"));
        try {
            int i=1;
            JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
            FtpDownConfModel ftpConfig = (FtpDownConfModel) jobDataMap.get("config");
            //System.out.println(ftpConfig.getAppointDay()+"=====");
            while(true){
                Thread.sleep(10 * 1000);
                System.out.println("wait succ.."+(i++));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
