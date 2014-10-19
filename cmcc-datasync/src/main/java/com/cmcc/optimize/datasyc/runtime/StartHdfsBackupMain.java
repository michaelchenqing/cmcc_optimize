/**  
 * StartHdfsBackupMain.java
 * com.cmcc.optimize.datasyc.runtime
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:39:21
 * 版权所有
 */
package com.cmcc.optimize.datasyc.runtime;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.xml.XmlFileLoader;
import com.cmcc.optimize.datasyc.backup.HdfsBackupJobs;
import com.cmcc.optimize.datasyc.backup.HdfsBackupModel;

/**
 * hdfs通用备份程序
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:39:21
 */

public class StartHdfsBackupMain {

    private static List<HdfsBackupModel> configs;// 备份配置

    private static final CmccLogger logger = CmccLogger.getLogger(StartHdfsBackupMain.class);// 日志

    private static final String DEFAULT_GROUP = "HDFS-GROUP-1";// 分组调度，这里暂不使用分布式调度

    /**
     * main函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        StartHdfsBackupMain main = new StartHdfsBackupMain();

        // 加载需要备份的配置文件
        main.loadAllBackupConfig();

        // 定时调度，执行的backup类，传入的参数 // 启动quartz调度
        
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
        } catch (Exception e) {
            logger.error("start quartz hdfs backup scheduler error", e);
            logger.notice("start quartz hdfs backup scheduler error" + ",exception:" + e);
            return;
        }

        if (configs != null) {
            int index = 0;
            for (HdfsBackupModel model : configs) {
                try {
                    index++;
                    // 启动hdfs备份
                    JobDetail jobCheck = JobBuilder.newJob(HdfsBackupJobs.class).withIdentity(index + "、" + model.getCornStr() + "_backup", DEFAULT_GROUP).build();
                    jobCheck.getJobDataMap().put("config", model);

                    // 创建cron表达式tirgger
                    CronTrigger triggerCheck = TriggerBuilder.newTrigger().withIdentity(index + "、" + model.getCornStr() + "_backup", DEFAULT_GROUP).withSchedule(CronScheduleBuilder.cronSchedule(model.getCornStr())).build();

                    if (logger.isInfoEnabled()) {
                        logger.info("execute hdfs backup job:" + model);
                    }

                    scheduler.scheduleJob(jobCheck, triggerCheck);
                } catch (Exception e) {
                    logger.error("execute hdfs backup job error:" + model, e);
                }

            }
        }

    }

    /**
     * 加载所有的备份配置文件
     */
    private void loadAllBackupConfig() {
        configs = new ArrayList<HdfsBackupModel>();
        try {
            Document document = XmlFileLoader.getXmlFileDocument(HdfsBackupModel.HDFS_BACKUP_CONFIG_FILE);
            Element root = document.getRootElement();

            List<Element> ftpElements = root.getChildren("hdfs_backup");
            if (ftpElements == null || ftpElements.size() <= 0) {
                logger.warn("no hdfs backup config,please add <hdfs_backup>");
                return;
            }

            // 解析节点配置
            for (Element e : ftpElements) {
                HdfsBackupModel model = new HdfsBackupModel();

                model.setArgs(e.getChild("args").getValue());
                model.setBackupClass(e.getChild("backupClass").getValue());
                model.setCornStr(e.getChild("cornStr").getValue());
                model.setFolder(e.getChild("folder").getValue());
                model.setLocalTempFolder(e.getChild("localTempFolder").getValue());
                

                configs.add(model);
            }
        } catch (Exception e) {
            logger.error("load hdfs backup config error", e);
        }

    }

    // 调度

}
