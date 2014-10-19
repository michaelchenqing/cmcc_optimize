/**  
 * RedisConf.java
 * com.cmcc.optimize.dataaccess.redis
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午4:08:01
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.redis;

import java.io.IOException;
import java.util.Properties;

import redis.clients.jedis.Protocol;
import cn.cas.common.io.FileUtils;

/**
 * redis配置文件加载
 * 
 * @author gaoqs
 * @date 2014年6月23日 上午10:55:48
 */
public class RedisConf {

    private static RedisConfReader reader = new RedisConfReader();// 读取redis.properties

    private String host;// 服务器host

    private int port;// 服务器端口

    private int db;// redis中的db，分隔不同的应用存储

    private int timeout = Protocol.DEFAULT_TIMEOUT;// 连接超时

    /**
     * 构造一个redis连接配置
     * 
     * @param host 服务器host
     * @param port 服务器端口
     * @param db redis中的db
     */
    public RedisConf(String host, int port, int db) {
        this.host = host;
        this.port = port;
        this.db = db;
    }

    /**
     * 构造一个redis连接配置，指定超时
     * 
     * @param host 服务器host
     * @param port 服务器端口
     * @param db redis中的db
     * @param timeout 连接超时，单位ms
     */
    public RedisConf(String host, int port, int db, int timeout) {
        super();
        this.host = host;
        this.port = port;
        this.db = db;
        this.timeout = timeout;
    }

    /**
     * 按业务key加载缓存配置
     * 
     * @param key 业务key，参见:redis.properties
     * @return 返回业务key所使用的缓存配置
     */
    public static synchronized RedisConf getRedisConf(String key) {
        int db = reader.getDB(key);
        String host = reader.getHost(key);
        int port = reader.getPort(key);
        int timeout = reader.getTimeOut(key);
        return new RedisConf(host, port, db, timeout);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "RedisConf [host=" + host + ", port=" + port + ", db=" + db + ", timeout=" + timeout + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + db;
        result = prime * result + ((host == null) ? 0 : host.hashCode());
        result = prime * result + port;
        result = prime * result + timeout;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RedisConf other = (RedisConf) obj;
        if (db != other.db)
            return false;
        if (host == null) {
            if (other.host != null)
                return false;
        } else if (!host.equals(other.host))
            return false;
        if (port != other.port)
            return false;
        if (timeout != other.timeout)
            return false;
        return true;
    }

}

/**
 * 读取redis配置文件类
 * 
 * @author gaoqs
 * @date 2014年6月23日 上午11:01:28
 */
class RedisConfReader {
    Properties properties;// redis.properties文件

    /**
     * 构造函数中加载redis.properties
     */
    RedisConfReader() {
        this.properties = new Properties();
        try {
            properties.load(FileUtils.getRealInputStream("redis.properties"));
        } catch (IOException e) {
            throw new RuntimeException("load " + "/redis.properties" + " fail", e);
        }
    }

    String getHost(String key) {
        return properties.getProperty(key + ".host");
    }

    int getPort(String key) {
        return Integer.parseInt(properties.getProperty(key + ".port"));
    }

    int getDB(String key) {
        return Integer.parseInt(properties.getProperty(key + ".db"));
    }

    int getTimeOut(String key) {
        String v = properties.getProperty(key + ".timeout");
        return v == null ? Protocol.DEFAULT_TIMEOUT : Integer.parseInt(v);
    }
}