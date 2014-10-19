/**  
 * HdfsBackupModel.java
 * com.cmcc.optimize.datasyc.backup
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:54:50
 * 版权所有
 */
package com.cmcc.optimize.datasyc.backup;

import com.cmcc.optimize.datamodel.BaseModel;

/**
 * hdfs备份通用配置
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:54:50
 */

public class HdfsBackupModel extends BaseModel {

    /**
     * 序列号
     */
    private static final long serialVersionUID = -7798127326090788635L;

    public static final String HDFS_BACKUP_CONFIG_FILE = "hdfs-backup-config.xml";// 备份配置文件名称

    private String cornStr;// 调度corn表达式

    private String args;// 参数

    private String backupClass;// 执行类

    private String folder;// 需要备份的目录

    private String localTempFolder;// 根目录

    public String getCornStr() {
        return cornStr;
    }

    public void setCornStr(String cornStr) {
        this.cornStr = cornStr;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getBackupClass() {
        return backupClass;
    }

    public void setBackupClass(String backupClass) {
        this.backupClass = backupClass;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getLocalTempFolder() {
        return localTempFolder;
    }

    public void setLocalTempFolder(String localTempFolder) {
        this.localTempFolder = localTempFolder;
    }

}
