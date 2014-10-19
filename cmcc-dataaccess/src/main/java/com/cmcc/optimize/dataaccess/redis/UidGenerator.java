package com.cmcc.optimize.dataaccess.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import cn.cas.common.exception.DaoException;

/**
 * 使用redis生成递增的用户id
 * 
 * @author sw
 */
public class UidGenerator {

    // 与uid相关的业务服务器配置及key信息
    private static RedisConf redisConf = RedisConf.getRedisConf("uidgenerator");

    private static String uidKey = "generator_uid";

    // 缓存服务器连接配置
    private static String host = redisConf.getHost();

    private static int port = redisConf.getPort();

    private static int db = redisConf.getDb();

    /**
     * @Fields pool : 定义连接池
     */
    private static JedisPool pool = new JedisPool(host, port);

    /**
     * 将key对应的值自增1
     * 
     * @param key 缓存key
     * @return 缓存值自增后的结果值
     * @throws Exception
     */
    private static long incrByStr(String key) throws Exception {
        if (key == null) {
            return 0L;
        }
        Jedis jedis = null;
        long ret = 0L;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            ret = jedis.incr(key);
        } catch (Exception e) {
            throw e;
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
        return ret;
    }

    /**
     * 将当前key(generator_uid)对应的值自增1
     * 
     * @return
     * @throws DaoException
     */
    public static long generate() throws DaoException {
        int retry = 3;
        while (retry-- > 0) {// 3次尝试创建
            try {
                return incrByStr(uidKey);
            } catch (Exception e) {
                if (retry <= 0) {
                    throw new DaoException("redis generate sequence id failed: " + redisConf, e);
                }
            }
        }
        return -1;
    }

    /**
     * 指定自增的步长
     * 
     * @param numsStep 步长
     * @return
     * @throws Exception
     */
    public static long generateByStep(long numsStep) throws Exception {
        return generateByStep(uidKey, numsStep);
    }

    /**
     * 指定自增的步长
     * 
     * @param key 标识
     * @param numsStep 步长
     * @return
     * @throws Exception
     */
    public static long generateByStep(String key, long numsStep) throws Exception {
        if (key == null) {
            return 0L;
        }
        Jedis jedis = null;
        long ret = 0L;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            ret = jedis.incrBy(key, numsStep);
        } catch (Exception e) {
            throw e;
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
        return ret;
    }

    /**
     * 获取缓存中当前id的最大值
     * 
     * @return
     * @throws Exception
     */
    public static long cur() throws Exception {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            return jedis.incrBy(uidKey, 0);
        } catch (Exception e) {
            throw new DaoException("query current max uid in redis fail: " + redisConf, e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
    }

}
