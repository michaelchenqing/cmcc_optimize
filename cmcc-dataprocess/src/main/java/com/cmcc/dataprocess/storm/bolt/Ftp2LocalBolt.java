/**  
 * SimpleBolt.java
 * com.cmcc.dataprocess.spout
 * 
 * @author peng
 * @date 2014-8-18 上午10:03:50
 * 版权所有
 */
package com.cmcc.dataprocess.storm.bolt;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import cn.cas.common.collect.Marker;

import com.cmcc.dataprocess.hbase.SignalHbaseImport;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClient;
import com.cmcc.optimize.dataaccess.ftp.down.FtpDownloadClientImpl;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;
import com.cmcc.optimize.datasyc.scheduler.FtpFileToReidsSchedulerJob;

/**
 * 将本地文件打包上传到hdfs
 * 
 * @author peng
 * @param <T>
 * @date 2014-8-18 上午10:03:50
 */

public class Ftp2LocalBolt extends BaseRichBolt {

    public static Logger logger = LoggerFactory.getLogger(Ftp2LocalBolt.class);

    private static final long serialVersionUID = 1L;

    private Marker marker;// redis标记

    // 处理文件录入
    private SignalHbaseImport dataImport = null;

    private FtpDownloadClient ftpClient;// ftp客户端

    private FtpFileProcessConfig ftpProcessConfig = null;

    private OutputCollector collector;

    /*
     * (non-Javadoc)
     * @see backtype.storm.task.IBolt#prepare(java.util.Map, backtype.storm.task.TopologyContext,
     * backtype.storm.task.OutputCollector)
     */
    @Override
    public void prepare(@SuppressWarnings("rawtypes") Map stormConf, TopologyContext context, OutputCollector collector) {
        this.marker = FtpFileToReidsSchedulerJob.getFtpFileProcessMarker();
        this.dataImport = new SignalHbaseImport();
        this.ftpProcessConfig = new FtpFileProcessConfig();
        this.collector = collector;
    }

    /*
     * (non-Javadoc)
     * @see backtype.storm.task.IBolt#execute(backtype.storm.tuple.Tuple)
     */
    @Override
    public void execute(Tuple input) {

        long starthandle = System.currentTimeMillis();
        try {
            String msg = (String) input.getValueByField("source");

            if (StringUtils.isBlank(msg)) {
                return;
            }

            String args[] = msg.split(",");
            String filePath = args[1];

            // 获得ftp下载配置
            FtpDownConfModel config = ftpProcessConfig.getFtpDownConfModel(args[0]);

            ftpClient = new FtpDownloadClientImpl(true);// ftp客户端
            // 获取ftp参数配置
            String host = config.getHost();
            String password = config.getPassword();
            String port = config.getPort();
            String user = config.getUserName();

            // 登陆ftp服务器
            boolean isLoginSucc = ftpClient.login(host, Integer.parseInt(port), user, password);
            if (!isLoginSucc) {
                logger.error("ftp connection failed:" + config);
                ftpClient.loginOut();
                return;
            }

            String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
            String localFilePath = FtpFileProcessConfig.getDefaultFtpLocalCacheFolder() + config.getLocalFolder() + fileName;

            boolean isSucc = ftpClient.downLoadFile(filePath, localFilePath);

            // 登出ftp
            ftpClient.loginOut();

            if (isSucc) {

                // 标记文件已经下载完成
                marker.set(FtpFileProcessConfig.getRedisMarkerDownLoadSucc(localFilePath), "true");
                isSucc = dataImport.signalFileImport(localFilePath);
                // 设置文件处理成功状态
                if (isSucc) {
                    logger.info("handle data succ : " + localFilePath);
                    marker.set(FtpFileProcessConfig.getRedisMarkerProcessSucc(filePath), "true");
                } else {
                    logger.info("handle data fail : " + localFilePath);
                }
                // TODO 删除ftp上已经成功下载的文件
                // ftpClient.deleteFtpFile(filePath);

            } else {
                logger.info("down ftp fail : " + filePath + ",localFilePath : " + localFilePath);
            }

            collector.ack(input);
        } catch (Exception e) {
            logger.error("storm 数据处理失败", e);
            collector.fail(input);
        }
        long endthandle = System.currentTimeMillis();
        logger.info("====================handle data and input to hbase：" + (endthandle - starthandle) + "ms=======================");

    }

    /**
     * 定义字段id，该id在简单模式下没有用处，但在按照字段分组的模式下有很大的用处。
     * 该declarer变量有很大作用，我们还可以调用declarer.declareStream();来定义stramId，该id可以用来定义更加复杂的流拓扑结构
     */
    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("info"));
    }

}