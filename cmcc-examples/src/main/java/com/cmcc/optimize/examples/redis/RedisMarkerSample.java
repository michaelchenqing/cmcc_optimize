/**  
 * RedisMarkerSample.java
 * com.cmcc.optimize.examples.redis
 * 
 * @author gaoqs
 * @date 2014年7月11日 上午10:58:18
 * 版权所有
 */
package com.cmcc.optimize.examples.redis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import junit.framework.Assert;

import cn.cas.common.collect.Marker;
import cn.cas.common.exception.RuntimeDaoException;

import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCommonProcessDAO;
import com.cmcc.optimize.dataaccess.dao.ibatis.ExtIbatisCommonProcessDAO;
import com.cmcc.optimize.dataaccess.redis.GlobalCounterMarker;
import com.cmcc.optimize.dataaccess.redis.RedisConf;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;
import com.cmcc.optimize.datasyc.scheduler.FtpDownLoadSchedulerJob;

/**
 * redis sample测试marker标记
 * 
 * @author gaoqs
 * @date 2014年7月11日 上午10:58:18
 */

public class RedisMarkerSample {

    private static ExtCommonProcessDAO extCommonProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCommonProcessDAO.class, "extCommonProcessDAO"); // ibatisDao

    /**
     * @param args
     */
    public static void main(String[] args) {
        // String time = "2014-08-03 12:00:00".substring(0,"yyyy-MM-dd hh".length()).trim();
        // SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh");
        // try {
        // Date d=format.parse(time);
        // System.out.println(d.getTime()+"@"+format.format(d));
        // List<String> c=new ArrayList();
        // c.add("cell_id");
        // c.add("test1");
        // List<Object> v=new ArrayList();
        // v.add("222");
        // v.add(d);
        //
        // extCommonProcessDAO.insert("T1", c, v);
        // } catch (ParseException e) {
        // e.printStackTrace();
        // }

        // deleteKeysTest();
        // testMarkEnable();

        // RedisMarkerSample.push();
        RedisMarkerSample.pull();
//         RedisMarkerSample.deleteKeysTest();
        // RedisMarkerSample.getHandleIsFalse();
    }

    /**
     * 获得处理失败的文件
     */
    private static void getHandleIsFalse() {
        RedisConf conf = RedisConf.getRedisConf("countermarker");
        marker = new GlobalCounterMarker(conf, FtpFileProcessConfig.FTP_FILE_PROCESS_COUNTER);
        for (Entry<Object, String> entry : marker.markers()) {
            String key = entry.getKey().toString();
            if (entry.getValue().equals("false") && key.contains("process_succ") && key.contains("20140826")) {
                System.out.println(key.substring(13));
            }
        }
    }

    private static void push(String msg, Marker m) {
        // Marker m = getFtpFileProcessMarker();
        ((GlobalCounterMarker) m).queuePush(msg);
    }

    private static void pull() {
        GlobalCounterMarker m = (GlobalCounterMarker) getFtpFileProcessMarker();
        int i = 0;
        while (true) {
            System.out.println(i++);
            String temp = m.queuePull();
            System.out.println(temp);
            if (!temp.contains("//")) {
                push(temp, m);
            }
        }

    }

    private static Marker marker;// redis标记

    /**
     * 获取ftp的redis marker标记
     * 
     * @return
     */
    public static Marker getFtpFileProcessMarker() {
        RedisConf conf = RedisConf.getRedisConf("ftpbackups");
        // RedisConf conf = RedisConf.getRedisConf("countermarker");

        marker = new GlobalCounterMarker(conf, FtpFileProcessConfig.FTP_FILE_BACKUP_COUNTER);
        return marker;
    }

    private static void testMarkEnable() {
        // 测试marker是否有效
        boolean isSucc = FtpDownLoadSchedulerJob.checkNeedDelete(marker, "mianyang/sichuan_Lte_LteEnodeb_YY_20140710.csv.gz", "/data/ftpcache/ftp/");
        Assert.assertTrue(isSucc);
    }

    private static void deleteKeysTest() {
        GlobalCounterMarker m = (GlobalCounterMarker) RedisMarkerSample.getFtpFileProcessMarker();
        m.deleteKeysWithContainsString("syc");
    }

}
