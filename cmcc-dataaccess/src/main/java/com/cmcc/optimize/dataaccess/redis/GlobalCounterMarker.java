/**  
 * GlobalCounterMarker.java
 * com.cmcc.optimize.dataaccess.redis
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午4:08:01
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import cn.cas.common.collect.Counter;
import cn.cas.common.collect.Marker;
import cn.cas.common.exception.RuntimeDaoException;

/**
 * 缓存中对集群的counter统计与 marker标记
 * 
 * @author zhou
 */
public class GlobalCounterMarker implements Counter, Marker {

    public static final String REDIS_KEY = "countermarker";// redis缓存key

    private static final String PREFIX_COUNTER = "COUNTER_PRE_";// 缓存二级属性中的统计key前辍

    private static final String PREFIX_MARKER = "MARKER_PRE_";// 缓存二级属性中标记的key前辍

    private static final String PREFIX_QUEUE = "QUEUE_PRE_";// 缓存二级属性中队列的key前辍

    private JedisPool pool;// 缓存连接池

    private int db;// 缓存业务db

    private final String redisKeyCounter;// 定义完整的缓存统计key

    private final String redisKeyMarker;// 定义完整的缓存标记key

    private final String redisKeyQueue;// 定义完整的缓存队列key

    /**
     * 使用默认的redis.properties中的countermarker.host生成标记统计类
     * 
     * @param redisKey 缓存key后辍
     */
    public GlobalCounterMarker(String redisKey) {
        RedisConf conf = RedisConf.getRedisConf(REDIS_KEY);
        db = conf.getDb();
        this.redisKeyCounter = PREFIX_COUNTER + redisKey;
        this.redisKeyMarker = PREFIX_MARKER + redisKey;
        this.redisKeyQueue = PREFIX_QUEUE + redisKey;
        pool = new JedisPool(conf.getHost(), conf.getPort());
    }

    /**
     * 指定缓存配置生成标记统计类
     * 
     * @param conf 缓存连接配置
     * @param redisKey 缓存key后辍
     */
    public GlobalCounterMarker(RedisConf conf, String redisKey) {
        db = conf.getDb();
        this.redisKeyCounter = PREFIX_COUNTER + redisKey;
        this.redisKeyMarker = PREFIX_MARKER + redisKey;
        this.redisKeyQueue = PREFIX_QUEUE + redisKey;
        pool = new JedisPool(conf.getHost(), conf.getPort());
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Counter#incr(java.lang.Object)
     */
    @Override
    public long incr(Object key) {
        Jedis jedis = null;
        long ret = 0L;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            ret = jedis.hincrBy(redisKeyCounter, key.toString(), 1);
        } catch (Exception e) {
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Counter#incr(java.lang.Object, long)
     */
    @Override
    public long incr(Object key, long delta) {
        Jedis jedis = null;
        long ret = 0L;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            ret = jedis.hincrBy(redisKeyCounter, key.toString(), delta);
        } catch (Exception e) {
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Counter#decr(java.lang.Object)
     */
    @Override
    public long decr(Object key) {
        return incr(key, -1);
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Counter#decr(java.lang.Object, long)
     */
    @Override
    public long decr(Object key, long delta) {
        return incr(key, -delta);
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Counter#reset()
     */
    @Override
    public void reset() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            jedis.del(redisKeyCounter);
            jedis.del(redisKeyMarker);
        } catch (Exception e) {
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Counter#getValue(java.lang.Object)
     */
    @Override
    public long getValue(Object key) {
        Jedis jedis = null;
        long ret = 0L;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            String res = jedis.hget(redisKeyCounter, key.toString());
            ret = res == null ? 0 : Long.parseLong(res);
        } catch (Exception e) {
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Counter#counters()
     */
    @Override
    public Set<Entry<Object, Long>> counters() {
        Map<Object, Long> map = new HashMap<Object, Long>();
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            Map<String, String> res = jedis.hgetAll(redisKeyCounter);
            if (res == null)
                return null;
            for (Entry<String, String> entry : res.entrySet()) {
                map.put(entry.getKey(), Long.parseLong(entry.getValue()));
            }
            return map.entrySet();
        } catch (Exception e) {
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Counter#toPrint()
     */
    @Override
    public String toPrint() {
        StringBuilder sb = new StringBuilder();
        for (Entry<Object, Long> entry : counters()) {
            sb.append("\tc_");
            sb.append(entry.getKey());
            sb.append(" : ");
            sb.append(entry.getValue());
            sb.append("\n");
        }

        for (Entry<Object, String> entry : markers()) {
            sb.append("\tm_");
            sb.append(entry.getKey());
            sb.append(" : ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return toPrint();
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Marker#getMark(java.lang.Object)
     */
    @Override
    public String getMark(Object key) {
        Jedis jedis = null;
        String ret = NULL;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            ret = jedis.hget(redisKeyMarker, key.toString());
        } catch (Exception e) {
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Marker#set(java.lang.Object, java.lang.String)
     */
    @Override
    public String set(Object key, String mark) {
        Jedis jedis = null;
        String ret = NULL;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            String keys = key.toString();
            ret = jedis.hget(redisKeyMarker, keys);
            jedis.hset(redisKeyMarker, keys, mark);
        } catch (Exception e) {
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     * @see cn.cas.common.collect.Marker#markers()
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Set<Entry<Object, String>> markers() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            Map res = jedis.hgetAll(redisKeyMarker);
            return res.entrySet();
        } catch (Exception e) {
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
    }

    /**
     * 删除包含指定字符的key
     * 
     * @param mustContainStr 必须包含的字符
     */
    public void deleteKeysWithContainsString(String mustContainStr) {
        deleteKeysWithContainsString(mustContainStr, null);
    }

    /**
     * 通过scan方式遍历redis中的key并删除
     * 
     * @param mustContainStr
     * @param includesStrs
     */
    @SuppressWarnings("deprecation")
    public void deleteKeysWithKey(String mustContainStr, String includesStrs) {
        if (mustContainStr == null) {
            return;
        }

        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            int cursor = 0;
            ScanParams scanParams = new ScanParams();
            scanParams.count(100000);
            if (StringUtils.equals(includesStrs, "all")) {
                scanParams.match("*" + mustContainStr + "*");
            } else {
                scanParams.match("*" + includesStrs + "*" + mustContainStr + "*");
            }

            while (true) {
                ScanResult<Map.Entry<String, String>> result = jedis.hscan(redisKeyMarker, cursor, scanParams);
                for (Entry<String, String> entry : result.getResult()) {
                    jedis.hdel(redisKeyMarker, entry.getKey());
                }
                if ((cursor = result.getCursor()) == 0) {
                    break;
                }
            }

        } catch (Exception e) {
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
    }

    /**
     * 删除包含指定字符的key，删除key中包含多个指定字符
     * 
     * @param mustContainStr 必须包含的字符
     * @param includesStrs 文件中包含多个，只匹配一个即可
     */
    public void deleteKeysWithContainsString(String mustContainStr, String includesStrs) {
        if (mustContainStr == null || StringUtils.isBlank(includesStrs)) {
            return;
        }

        if (includesStrs.indexOf(",") != -1) {
            for (String includesStr : includesStrs.split(",")) {
                deleteKeysWithKey(mustContainStr, includesStr);
            }
        } else {
            deleteKeysWithKey(mustContainStr, includesStrs);
        }

        // Jedis jedis = null;
        // try {
        // jedis = pool.getResource();
        // if (jedis.getDB() != db) {
        // jedis.select(db);
        // }
        //
        // Set<Entry<Object, String>> s = markers();
        // for (Entry<Object, String> entry : s) {
        // String key = entry.getKey() + "";
        //
        // if (StringUtils.contains(key, mustContainStr)) {
        // if (StringUtils.isNotBlank(includesStrs)) {
        // String[] splits = includesStrs.split(",");
        // boolean isIncludeBol = false;
        // for (String string : splits) {
        //
        // // isIncludeBol |= StringUtils.contains(key, string);
        //
        // if (string.contains("*")) {
        // isIncludeBol = true;
        // String[] args = string.split("\\*");
        // for (String arg : args) {
        // isIncludeBol &= StringUtils.contains(key, arg);
        // if (!isIncludeBol) {
        // break;
        // }
        // }
        // } else {
        // isIncludeBol |= StringUtils.contains(key, string);
        // }
        // }
        // if (isIncludeBol) {
        // jedis.hdel(redisKeyMarker, key);
        // }
        // } else {
        // jedis.hdel(redisKeyMarker, key);
        // }
        // }
        //
        // }
        //
        // } catch (Exception e) {
        // throw new RuntimeDaoException(e);
        // } finally {
        // if (jedis != null)
        // pool.returnResource(jedis);
        // }
    }

    /**
     * redis队列操作---存数据
     * 
     * @param message
     */
    public boolean queuePush(String message) {
        boolean flag = true;
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            jedis.lpush(redisKeyQueue, message);
        } catch (Exception e) {
            flag = false;
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
        return flag;
    }

    /**
     * redis队列操作---取数据
     * 
     * @return
     */
    public String queuePull() {
        Jedis jedis = null;
        String message = null;
        try {
            jedis = pool.getResource();
            if (jedis.getDB() != db) {
                jedis.select(db);
            }
            message = jedis.lpop(redisKeyQueue);
        } catch (Exception e) {
            throw new RuntimeDaoException(e);
        } finally {
            if (jedis != null)
                pool.returnResource(jedis);
        }
        return message;
    }
}
