/**  
 * RedisMarkerRemoveKeySample.java
 * com.cmcc.optimize.examples.redis
 * 
 * @author gaoqs
 * @date 2014年8月20日 下午6:15:26
 * 版权所有
 */
package com.cmcc.optimize.examples.redis;

import com.cmcc.optimize.dataaccess.redis.GlobalCounterMarker;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;
import com.cmcc.optimize.datasyc.scheduler.FtpDownLoadSchedulerJob;

/**
 * 删除择时定的key
 * 
 * @author gaoqs
 * @date 2014年8月20日 下午6:15:26
 */

public class RedisMarkerRemoveKeySample {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
         String mustContains = "20140925";
        String includeStrs = "Scan_OPTS_雅安_网格1_20140925-1.csv";// all，则删除所有包含mustContains的内容
        GlobalCounterMarker counterMark = (GlobalCounterMarker) FtpDownLoadSchedulerJob.getFtpFileProcessMarker();
        counterMark.deleteKeysWithContainsString(mustContains,includeStrs);
//        counterMark.deleteKeysWithKey(FtpFileProcessConfig.getRedisMarkerBackupSucc(includeStrs));
//        counterMark.deleteKeysWithKey(FtpFileProcessConfig.getRedisMarkerProcessSucc(includeStrs));
//         counterMark.deleteKeysWithContainsString(mustContains, includeStrs);
    }
}
