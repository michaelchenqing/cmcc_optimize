/**  
 * RestHbaseTableSystem.java
 * com.cmcc.dataprocess.hbase
 * 
 * @author gaoqs
 * @date 2014年8月18日 下午3:19:26
 * 版权所有
 */
package com.cmcc.optimize.examples.hbase;

import redis.clients.jedis.Jedis;

import com.cmcc.dataprocess.hbase.dao.SignalHttpModelDao;
import com.cmcc.dataprocess.hbase.dao.SignalMMSModelDao;
import com.cmcc.dataprocess.hbase.dao.SignalSigModelDao;
import com.cmcc.dataprocess.hbase.dao.SignalTcpModelDao;
import com.cmcc.dataprocess.hbase.dao.SignalUdpModelDao;
import com.cmcc.dataprocess.hbase.dao.SignalWSPModelDao;
import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.hbase.HTableCreator;
import com.cmcc.optimize.dataaccess.redis.RedisConf;

/**
 * 清空所有的hbase表，慎操作
 * 
 * @author gaoqs
 * @date 2014年8月18日 下午3:19:26
 */

public class RestHbaseTableSystem {

    private static boolean forceDeleteIfExist = false;// 如果表存在，则不创建，清空时请修改该值为true

    private static final CmccLogger logger = CmccLogger.getLogger(RestHbaseTableSystem.class);// 日志

    /**
     * main函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        new RestHbaseTableSystem().reCreateSignalTables();
    }

    /**
     * 重新创建所有hbase表
     */
    private void reCreateAllTables() {
        reCreateSignalTables();// 重建信令hbase表

        if (forceDeleteIfExist) {
            if (logger.isInfoEnabled()) {
                logger.info("need clean redis uuid...");
            }
            resetUUidWithHbase();// 清空uuid
        } else {
            if (logger.isInfoEnabled()) {
                logger.info("no need clean redis uuid...");
            }
        }
    }

    /**
     * 重新创建信令所有的hbase表
     */
    private void reCreateSignalTables() {
        // 待重建的hbase表
        HTableCreator[] htablecreators = new HTableCreator[] { new SignalMMSModelDao(), new SignalSigModelDao(), new SignalWSPModelDao(), new SignalTcpModelDao(), new SignalUdpModelDao(), new SignalHttpModelDao() };

        for (HTableCreator hTableCreator : htablecreators) {

            if (logger.isInfoEnabled()) {
                logger.info("reCreate hbase table：" + hTableCreator.getClass().getName() + "@" + forceDeleteIfExist);
            }

            hTableCreator.create(forceDeleteIfExist);
        }
    }

    /**
     * 清空redis中的uuid
     */
    private void resetUUidWithHbase() {
        RedisConf conf = RedisConf.getRedisConf("uidgenerator");
        int db = conf.getDb();
        Jedis jedis = new Jedis(conf.getHost(), conf.getPort());
        jedis.select(db);
        jedis.del("generator_uid");
        jedis.close();
    }
}
