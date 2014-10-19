/**  
 * Kafka.java
 * com.cmcc.dataprocess.storm.kafka
 * 
 * @author peng
 * @date 2014-9-1 上午11:50:31
 * 版权所有
 */
package com.cmcc.dataprocess.storm.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.cas.kafka.producer.IProducer;
import cn.cas.kafka.producer.LongLinkProducer;

import com.cmcc.dataprocess.hbase.SignalTypeEnum;
import com.cmcc.optimize.datamodel.signal.SignalHttpModel;
import com.cmcc.optimize.datamodel.signal.SignalMMSModel;
import com.cmcc.optimize.datamodel.signal.SignalSigModel;
import com.cmcc.optimize.datamodel.signal.SignalTcpModel;
import com.cmcc.optimize.datamodel.signal.SignalUdpModel;
import com.cmcc.optimize.datamodel.signal.SignalWSPModel;

/**
 * 塞入kafka操作
 * 
 * @author peng
 * @date 2014-9-1 上午11:50:31
 */

public class Kafka {

    // 信令http对象
    private static IProducer producerSignalHttp;

    // mms彩信对象
    private static IProducer producerSignalMM;

    // 信令路由签名对象
    private static IProducer producerSignalSig;

    // 信令tcp对象
    private static IProducer producerSignalTcp;

    // 信令udp对象
    private static IProducer producerSignalUdp;

    // 信令wap请求对象
    private static IProducer producerSignalWSP;

    // log
    public static Logger logger = LoggerFactory.getLogger(Kafka.class);

    // 缓存大小
    private static int bufferSize = 10000;

    static {
        try {
            producerSignalHttp = new LongLinkProducer("signal_http", bufferSize);
            producerSignalMM = new LongLinkProducer("signal_mm", bufferSize);
            producerSignalSig = new LongLinkProducer("signal_sig", bufferSize);
            producerSignalTcp = new LongLinkProducer("signal_tcp", bufferSize);
            producerSignalUdp = new LongLinkProducer("signal_udp", bufferSize);
            producerSignalWSP = new LongLinkProducer("signal_wsp", bufferSize);

        } catch (Exception e) {
            logger.error("加载kafka配置出错：", e);
        }
    }

    /**
     * 将信令数据插入kafka管道中
     * 
     * @param type 信令数据类型
     * @param strs 数据
     */
    public static void producer(SignalTypeEnum type, Object obj) {
        if (type == null || obj == null) {
            return;
        }

        if (type == SignalTypeEnum.SIGNAL_HTTP_MODEL) {

            producerSignalHttp((SignalHttpModel) obj);

        } else if (type == SignalTypeEnum.SIGNAL_MMS_MODEL) {
            producerSignalMM((SignalMMSModel) obj);

        } else if (type == SignalTypeEnum.SIGNAL_SIG_MODEL) {
            producerSignalSig((SignalSigModel) obj);

        } else if (type == SignalTypeEnum.SIGNAL_TCP_MODEL) {
            producerSignalTcp((SignalTcpModel) obj);

        } else if (type == SignalTypeEnum.SIGNAL_UDP_MODEL) {

            producerSignalUdp((SignalUdpModel) obj);
        } else if (type == SignalTypeEnum.SIGNAL_WSP_MODEL) {

            producerSignalWSP((SignalWSPModel) obj);
        } else {
            return;
        }
    }

    /**
     * 信令http对象
     * 
     * @param strs
     */
    private static void producerSignalHttp(SignalHttpModel signalHttpModel) {
        producerSignalHttp.put(signalHttpModel.toJsonString());
    }

    /**
     * mms彩信对象
     * 
     * @param strs
     */
    private static void producerSignalMM(SignalMMSModel signalMMSModel) {
        producerSignalMM.put(signalMMSModel.toJsonString());
    }

    /**
     * 信令路由签名对象
     * 
     * @param strs
     */
    private static void producerSignalSig(SignalSigModel signalSigModel) {

        producerSignalSig.put(signalSigModel.toJsonString());
    }

    /**
     * 信令tcp对象
     * 
     * @param strs
     */
    private static void producerSignalTcp(SignalTcpModel signalTcpModel) {
        producerSignalTcp.put(signalTcpModel.toJsonString());
    }

    /**
     * 信令udp对象
     * 
     * @param strs
     */
    private static void producerSignalUdp(SignalUdpModel signalUdpModel) {
        producerSignalUdp.put(signalUdpModel.toJsonString());
    }

    /**
     * 信令wap请求对象
     * 
     * @param strs
     */
    private static void producerSignalWSP(SignalWSPModel signalWSPModel) {
        producerSignalWSP.put(signalWSPModel.toJsonString());
    }
}
