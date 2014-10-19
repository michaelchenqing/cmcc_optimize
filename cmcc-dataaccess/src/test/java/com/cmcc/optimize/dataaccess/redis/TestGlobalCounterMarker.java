/**  
 * TestGlobalCounterMarker.java
 * com.cmcc.optimize.dataaccess.redis
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午4:08:01
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.redis;

import junit.framework.Assert;
import junit.framework.TestCase;
import cn.cas.common.collect.Counter;
import cn.cas.common.collect.Marker;

/**
 * 缓存统计与标记测试类
 * 
 * @author gaoqs
 * @date 2014年6月23日 上午11:26:38
 */
public class TestGlobalCounterMarker extends TestCase {

    /**
     * 测试统计
     */
    public void testCounter() {
        String redisKey = "test-counter";
        Counter counter = new GlobalCounterMarker(redisKey);

        long cacheValue = 0;// 缓存中的值
        long expectValue = 0;// 预期值

        cacheValue = counter.getValue("jintian");
        expectValue = cacheValue;

        // 加3
        expectValue += 3;
        counter.incr("jintian", 3);
        Assert.assertEquals(expectValue, counter.getValue("jintian"));

        // 减1
        counter.decr("jintian");
        expectValue -= 1;
        Assert.assertEquals(expectValue, counter.getValue("jintian"));

        counter.decr("jintian", 3);
        expectValue -= 3;
        Assert.assertEquals(expectValue, counter.getValue("jintian"));

        // 不存在的key
        Assert.assertEquals(0, counter.getValue("jintian123"));

        // 重新设置所有的内容
        counter.reset();
        Assert.assertEquals(0, counter.getValue("jintian"));
    }

    /**
     * 测试标记
     */
    public void testMasker() {
        String redisKey = "test-maker";
        Counter counter = new GlobalCounterMarker(redisKey);

        Marker marker = (Marker) counter;

        // 标记jiantian属性为chifan
        marker.set("jintian", "chifan");
        Assert.assertEquals("chifan", marker.getMark("jintian"));

        // 重置标记
        marker.reset();

        Assert.assertEquals(null, marker.getMark("jintian"));
    }

}
