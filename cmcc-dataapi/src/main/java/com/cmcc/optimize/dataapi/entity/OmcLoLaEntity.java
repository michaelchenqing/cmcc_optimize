/**  
 * CellInfoEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * OMC小区经纬度响应实体
 * 
 * @author yuminglang
 * @date 2014年6月26日 下午1:53:28
 */
public class OmcLoLaEntity {
    private String city;// 地市

    private String enbid;// omc enbid

    private String enbname;// omc enb name

    private Float lo;// omc基站经度

    private Float la;// omc基站纬度

    private String ts;// 更新时间（暂为空）

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEnbid() {
        return enbid;
    }

    public void setEnbid(String enbid) {
        this.enbid = enbid;
    }

    public String getEnbname() {
        return enbname;
    }

    public void setEnbname(String enbname) {
        this.enbname = enbname;
    }

    public Float getLo() {
        return lo;
    }

    public void setLo(Float lo) {
        this.lo = lo;
    }

    public Float getLa() {
        return la;
    }

    public void setLa(Float la) {
        this.la = la;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}
