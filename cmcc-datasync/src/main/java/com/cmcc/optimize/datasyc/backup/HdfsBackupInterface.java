/**  
 * HdfsBackupInterface.java
 * com.cmcc.optimize.datasyc.backup
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:43:05
 * 版权所有
 */
package com.cmcc.optimize.datasyc.backup;

/**
 * 备份接口方法
 * 
 * @author gaoqs
 * @date 2014年8月21日 上午9:43:05
 */

public interface HdfsBackupInterface {

    /**
     * 备份文件
     * 
     * @param model 配置参数
     */
    public void backup(HdfsBackupModel model);
}
