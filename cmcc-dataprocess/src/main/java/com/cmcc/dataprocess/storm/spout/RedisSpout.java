/**  
 * RedisSpout.java
 * com.cmcc.dataprocess.spout
 * 
 * @author peng
 * @date 2014-8-18 上午9:53:48
 * 版权所有
 */
package com.cmcc.dataprocess.storm.spout;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;
import cn.cas.common.collect.Marker;

import com.cmcc.optimize.dataaccess.redis.GlobalCounterMarker;
import com.cmcc.optimize.datasyc.scheduler.FtpFileToReidsSchedulerJob;

/**
 * 数据来源(将redis中的数据传入storm中)
 * 
 * @author peng
 * @date 2014-8-18 上午9:53:48
 */

public class RedisSpout extends BaseRichSpout {

    private static final long serialVersionUID = 1L;

    // 用来发射数据的工具类
    private SpoutOutputCollector collector;

    public static Logger LOG = LoggerFactory.getLogger(RedisSpout.class);

    private Marker marker;// redis标记

    /**
     * 初始化collector
     */
    @SuppressWarnings("rawtypes")
    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;
        this.marker = FtpFileToReidsSchedulerJob.getFtpFileProcessMarker();

    }

    /**
     * 在SpoutTracker类中被调用，每调用一次就可以向storm集群中发射一条数据（一个tuple元组），该方法会被不停的调用
     */
    @Override
    public void nextTuple() {

        String msg = ((GlobalCounterMarker) marker).queuePull();

        if (StringUtils.isNotBlank(msg)) {
            LOG.info("RedisSpout:" + msg);
            // 调用发射方法
            collector.emit(new Values(msg));
            Utils.sleep(100);
        } else {
            LOG.info("RedisSpout not data.");
            Utils.sleep(10000);
        }
    }

    /**
     * 定义字段id，该id在简单模式下没有用处，但在按照字段分组的模式下有很大的用处。
     * 该declarer变量有很大作用，我们还可以调用declarer.declareStream();来定义stramId，该id可以用来定义更加复杂的流拓扑结构
     */
    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("source"));

    }

}
