/**  
 * HdfsBackupJobs.java
 * com.cmcc.optimize.datasyc.backup
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:49:19
 * 版权所有
 */
package com.cmcc.optimize.datasyc.backup;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import com.cmcc.log4j.CmccLogger;

/**
 * hdfs备份调度job
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:49:19
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class HdfsBackupJobs implements Job {

    private static final CmccLogger logger = CmccLogger.getLogger(HdfsBackupJobs.class);// 日志

    /**
     * 提供给quartz调用的默认无参构造函数，参数通过jobdetailmap传入context
     */
    public HdfsBackupJobs() {
    }

    /*
     * (non-Javadoc)
     * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 获取需要执行的HdfsBackupInterface，调用其方法
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        HdfsBackupModel config = (HdfsBackupModel) jobDataMap.get("config");
        if (config == null) {
            logger.error("job config is null...");
            return;
        }
        doJob(config);
    }

    /**
     * 执行job
     * 
     * @param config
     */
    public void doJob(HdfsBackupModel config) {

        if (logger.isDebugEnabled()) {
            logger.debug("execute hdfs backup：" + config);
        }

        String executeClaz = config.getBackupClass();
        try {
            Object obj = Class.forName(executeClaz).newInstance();
            HdfsBackupInterface face = (HdfsBackupInterface) obj;
            face.backup(config);
        } catch (Exception e) {
            logger.error("execute hdfs backup error:" + config, e);
        }
    }
}
