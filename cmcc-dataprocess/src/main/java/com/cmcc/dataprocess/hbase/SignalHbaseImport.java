/**  
 * SignalHbaseImport.java
 * com.cmcc.dataprocess.hbase.dao
 * 
 * @author gaoqs
 * @date 2014年8月19日 下午3:09:10
 * 版权所有
 */
package com.cmcc.dataprocess.hbase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.cas.common.utils.IDUtils;
import cn.cas.dps.hbase.dao.HbaseDao;

import com.cmcc.dataprocess.parser.csv.SignalCsvParser;
import com.cmcc.optimize.dataaccess.redis.UidGenerator;
import com.cmcc.optimize.dataaccess.util.DateUtil;
import com.cmcc.optimize.dataaccess.util.LocalFileHelper;

/**
 * 信令数据hbase导入，调用入口
 * 
 * @author gaoqs
 * @param <T>
 * @date 2014年8月19日 下午3:09:10
 */

public class SignalHbaseImport {

    private static final Map<SignalTypeEnum, HbaseDao<?, ?>> daoMaps = new HashMap<SignalTypeEnum, HbaseDao<?, ?>>();// 信令dao对象

    public static Logger logger = LoggerFactory.getLogger(SignalHbaseImport.class);

    public String CSV_CHARSET = "GB18030"; // CSV默认字符集

    public int batchSize = 40000; // 批量插入批次大小

    public int ignoreRows = 0;// 忽略行数，信令没有csv文件头

    private static final SignalCsvParser parser = new SignalCsvParser();// csv转换处理

    private static Long startId = -1L;// 本地缓存的reids id开始

    private static Long endId = -1L;// 本地缓存的redis id结束

    private static final int CACHED_UID_NUMS = 30000;// 从redis缓存的uid数

    // /**
    // * 获取缓存的uid
    // *
    // * @return
    // */
    // public static synchronized Long getCachedUuId() {
    // if (startId < 0 || endId < 0 || startId >= endId) {
    // // 需要重新取值redis的范围值
    // try {
    // endId = UidGenerator.generateByStep(CACHED_UID_NUMS);
    // } catch (Exception e) {
    // logger.error("get uid error,last ids:" + startId + "@" + endId, e);
    // }
    // startId = endId - CACHED_UID_NUMS;
    // }
    // startId += 1;
    // return startId;
    // }

    /**
     * 获取缓存的uid
     * 
     * @return
     */
    public static synchronized Long getCachedUuId() {
        if (startId >= CACHED_UID_NUMS) {
            // 需要重新取值redis的范围值
            try {
                endId = UidGenerator.generateByStep(CACHED_UID_NUMS);
            } catch (Exception e) {
                logger.error("get uid error,last ids:" + startId + "@" + endId, e);
            } finally {
                startId = -1l;
            }
        }
        startId += 1;
        return IDUtils.nextId();
    }

    static {
        // 初始化信令dao接口类
        for (SignalTypeEnum type : SignalTypeEnum.values()) {
            try {
                daoMaps.put(type, (HbaseDao<?, ?>) Class.forName(type.getDaoClass()).newInstance());
            } catch (Exception e) {
                logger.error("init hbase dao fail:" + type.getCode(), e);
            }
        }
    }

    /**
     * 导入信令文件，按文件名规则，判断是何种类型
     * 
     * @param localFilePath 本地文件路径
     */
    public boolean signalFileImport(String localFilePath) {
        SignalTypeEnum type = null;

        if (StringUtils.contains(localFilePath, "HTTP")) {
            type = SignalTypeEnum.SIGNAL_HTTP_MODEL;
        } else if (StringUtils.contains(localFilePath, "MMS")) {
            type = SignalTypeEnum.SIGNAL_MMS_MODEL;
        } else if (StringUtils.contains(localFilePath, "SIG")) {
            type = SignalTypeEnum.SIGNAL_SIG_MODEL;
        } else if (StringUtils.contains(localFilePath, "TCP")) {
            type = SignalTypeEnum.SIGNAL_TCP_MODEL;
        } else if (StringUtils.contains(localFilePath, "UDP")) {
            type = SignalTypeEnum.SIGNAL_UDP_MODEL;
        } else if (StringUtils.contains(localFilePath, "WSP")) {
            type = SignalTypeEnum.SIGNAL_WSP_MODEL;
        }

        if (type == null) {
            logger.warn("not dao to process file :" + localFilePath);
            return false;
        }

        return signalFileImport(localFilePath, type);
    }

    /**
     * 信令文件导入
     * 
     * @param localFilePath 信令文件本地路径
     * @param type 信令文件类型
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public boolean signalFileImport(String localFilePath, SignalTypeEnum type) {

        if (logger.isDebugEnabled()) {
            logger.debug("signalFileImport " + localFilePath + "，type:" + (type == null ? type : type.getCode()));
        }

        LocalFileHelper fileHelper = new LocalFileHelper();
        fileHelper.setBatchSize(batchSize);// 设置一次读取行数
        fileHelper.setCsvEncoding(CSV_CHARSET);// 设置文件编码
        List<String> lines;// 行记录

        try {
            // 1、循环目录中的节点流
            while ((lines = fileHelper.getNextBatchLines(localFilePath, ignoreRows)) != null && lines.size() > 0) {
                // 存储解析后的结果
                List objs = new ArrayList();

                // 2、解析所有的行数据
                long startHandle = System.currentTimeMillis();
                for (String line : lines) {
                    try {
                        Object obj = parser.parser(line, type);
                        if (obj != null) {
                            objs.add(obj);
//                            Kafka.producer(type, obj);
                        }
                    } catch (Exception e) {
                        logger.error("process signal line error:" + line + ",filePath=" + localFilePath + "，type=" + type.getCode(), e);
                    }
                }

                long endHandle = System.currentTimeMillis();

                long startHbase = System.currentTimeMillis();
                try {
                    // 3、入hdbase
                    daoMaps.get(type).put(objs);
                } catch (Exception e) {
                    logger.error("10000 import hbase signal error:" + localFilePath, e);
                }
                long endHbase = System.currentTimeMillis();

                logger.info("parser file:" + (endHandle - startHandle) + "ms,input hbase:" + (endHbase - startHbase) + "ms,lines size:" + lines.size());

            }
        } catch (Exception e) {
            logger.error("import hbase signal error:" + localFilePath, e);
        } finally {
            // 清空 reader
            fileHelper.br = null;
            // 关闭文件流
            fileHelper.closeStreams();
            fileHelper = null;
        }

        // 这里如果处理单行出错时，输出日志，不考虑返回false情况，默认都处理成功，不因为单条数据失败重新录入回滚
        return true;

    }

    /**
     * 删除指定日期前的数据
     * 
     * @param beforeDays 保留当前日期前的指定天数数据
     */
    public void deleteHistoryDate(int beforeDays) {
        Date nowDate = new Date();
        for (int i = 0; i < beforeDays; i++) {
            Date tempDate = DateUtil.addHours(nowDate, -24 * i);// 向前推指定的日期
            String date = DateUtil.dtFormat(tempDate, DateUtil.dtSimple);

            if (logger.isDebugEnabled()) {
                logger.debug("delte hbase signal history data：" + date);
            }

            deleteHistoryDate(date);
        }

    }

    /**
     * 删除指定日期的信令数据
     * 
     * @param date 日期 yyyy-MM-dd
     */
    private void deleteHistoryDate(String date) {
        try {
            // TODO 从日期索引表中删除对应的 rowkey，后续所有查询时，需要判断rowkey是否存在

        } catch (Exception e) {
            logger.error("delete hbase signal history data error：" + date, e);
        }
    }

}
