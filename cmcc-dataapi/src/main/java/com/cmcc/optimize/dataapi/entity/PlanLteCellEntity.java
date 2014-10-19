/**  
 * PlanLteCellEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author yuminglang
 * @date 2014年7月4日 下午17:38:28
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * 规划小区信息响应实体
 * 
 * @author yuminglang
 * @date 2014年7月4日 下午17:38:28
 */
public class PlanLteCellEntity {
    private String city;// 地市

    private String town;// 区县

    private String pcellid;// 规划小区级唯一标识

    private String ctype;// 覆盖区域

    private Float lo;// 基站经度

    private Float la;// 基站纬度

    private Float mindis;// 最小站间距

    private String period;// 工程期别

    private Float height;// 天线挂高

    private String ts;// 时间

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPcellid() {
        return pcellid;
    }

    public void setPcellid(String pcellid) {
        this.pcellid = pcellid;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
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

    public Float getMindis() {
        return mindis;
    }

    public void setMindis(Float mindis) {
        this.mindis = mindis;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}
