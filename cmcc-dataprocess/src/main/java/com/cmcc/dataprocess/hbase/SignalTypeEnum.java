/**  
 * SignalTypeEnum.java
 * com.cmcc.dataprocess.hbase
 * 
 * @author gaoqs
 * @date 2014年8月19日 下午3:11:04
 * 版权所有
 */
package com.cmcc.dataprocess.hbase;

import org.apache.commons.lang.StringUtils;

/**
 * 信令文件类型枚举
 * 
 * @author gaoqs
 * @date 2014年8月19日 下午3:11:04
 */

public enum SignalTypeEnum {

    SIGNAL_HTTP_MODEL("SignalHttpModel", "http信令", "com.cmcc.dataprocess.hbase.dao.SignalHttpModelDao"),

    SIGNAL_MMS_MODEL("SignalMMSModel", "彩信信令", "com.cmcc.dataprocess.hbase.dao.SignalMMSModelDao"),

    SIGNAL_SIG_MODEL("SignalSigModel", "路由牵移信令", "com.cmcc.dataprocess.hbase.dao.SignalSigModelDao"),

    SIGNAL_TCP_MODEL("SignalTcpModel", "tcp信令", "com.cmcc.dataprocess.hbase.dao.SignalTcpModelDao"),

    SIGNAL_UDP_MODEL("SignalUdpModel", "udp信令", "com.cmcc.dataprocess.hbase.dao.SignalUdpModelDao"),

    SIGNAL_WSP_MODEL("SignalWSPModel", "wap信令", "com.cmcc.dataprocess.hbase.dao.SignalWSPModelDao");

    private String code;// 枚举值

    private String message;// 描述

    private String daoClass;// 执行的dao入口类

    /**
     * 构造函数
     * 
     * @param code key
     * @param message 描述
     * @param daoClass hbase dao接口类
     */
    SignalTypeEnum(String code, String message, String daoClass) {
        this.code = code;
        this.message = message;
        this.daoClass = daoClass;
    }

    /**
     * 取枚举
     * 
     * @param value
     * @return
     */
    public static SignalTypeEnum getEnumByCode(String value) {
        for (SignalTypeEnum item : values()) {
            if (StringUtils.equals(item.getCode(), value)) {
                return item;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDaoClass() {
        return daoClass;
    }

    public void setDaoClass(String daoClass) {
        this.daoClass = daoClass;
    }

}
