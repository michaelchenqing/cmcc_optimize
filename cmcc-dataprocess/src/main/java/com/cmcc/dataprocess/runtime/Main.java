/**  
 * Main.java
 * com.cmcc.dataprocess.runtime
 * 
 * @author gaoqs
 * @date 2014年8月15日 上午9:24:10
 * 版权所有
 */
package com.cmcc.dataprocess.runtime;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;

import com.cmcc.dataprocess.storm.bolt.Ftp2LocalBolt;
import com.cmcc.dataprocess.storm.spout.RedisSpout;

/**
 * 数据处理启动main类
 * 
 * @author peng
 * @date 2014-8-18 上午10:37:49
 */
public class Main {

    public static void main(String[] args) {

        int spoutNum = 1;
        int executors = 4;
        int tasks = 4;
        int boltWorks = 4;
        if (args.length == 4) {
            spoutNum = Integer.parseInt(args[0]);
            executors = Integer.parseInt(args[1]);
            tasks = Integer.parseInt(args[2]);
            boltWorks = Integer.parseInt(args[3]);
        }

        try {

            /**
             * 从redis获得文件名称并下载到本地目录
             */
            // 实例化TopologyBuilder类。
            TopologyBuilder topologyBuilder = new TopologyBuilder();
            // 设置喷发节点并分配并发数，该并发数将会控制该对象在集群中的线程数。
            topologyBuilder.setSpout("redis-spout", new RedisSpout(), spoutNum);
            // 设置数据处理节点并分配并发数。指定该节点接收喷发节点的策略为随机方式。
            topologyBuilder.setBolt("Ftp2LocalBolt", new Ftp2LocalBolt(), executors).shuffleGrouping("redis-spout").setMaxSpoutPending(20).setNumTasks(tasks);

            Config config = new Config();
            config.setNumWorkers(boltWorks);
            config.setMessageTimeoutSecs(60);
            config.setDebug(true);
            StormSubmitter.submitTopology("ftp2Hdfs", config, topologyBuilder.createTopology());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
