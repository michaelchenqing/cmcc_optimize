/**  
 * SevenDaysOnlineEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 规划工参响应
 * 
 * @author yuminglang
 * @date 2014年6月26日 下午1:54:02
 */
public class PlanEnbParameterEntity {
    private String name;// 规划站名(*必填)

    private String city;// 地市(*必填)

    private String town;// 区县（*必填）

    private String penbid;// 规划基站标识

    private Float lon;// 规划经度

    private Float lat;// 规划纬度

    private Float mindis;// 规划最小站间距

    private String enbtype;// 基站类别(宏站、室分)

    private String regiontype;// 区域类型

    private String phase;// 工程期别

    private String frequency;// 使用频段

    private String cname;// 查勘站名

    private Integer h1;// 现查勘挂高CELL1

    private Integer h2;// 现查勘挂高CELL2

    private Integer h3;// 现查勘挂高CELL3

    private Integer etilt1;// 现场查勘电下倾角CELL1

    private Integer etilt2;// 现场查勘电下倾角CELL2

    private Integer etilt3;// 现场查勘电下倾角CELL3

    private Integer azimuth1;// 现场查勘方向角CELL1

    private Integer azimuth2;// 现场查勘方向角CELL2

    private Integer azimuth3;// 现场查勘方向角CELL3

    private Integer dtilt1;// 现场查勘总下倾角CELL1

    private Integer dtilt2;// 现场查勘总下倾角CELL2

    private Integer dtilt3;// 现场查勘总下倾角CELL3

    private String ts;// 时间

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getPenbid() {
        return penbid;
    }

    public void setPenbid(String penbid) {
        this.penbid = penbid;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getMindis() {
        return mindis;
    }

    public void setMindis(Float mindis) {
        this.mindis = mindis;
    }

    public String getEnbtype() {
        return enbtype;
    }

    public void setEnbtype(String enbtype) {
        this.enbtype = enbtype;
    }

    public String getRegiontype() {
        return regiontype;
    }

    public void setRegiontype(String regiontype) {
        this.regiontype = regiontype;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getH1() {
        return h1;
    }

    public void setH1(Integer h1) {
        this.h1 = h1;
    }

    public Integer getH2() {
        return h2;
    }

    public void setH2(Integer h2) {
        this.h2 = h2;
    }

    public Integer getH3() {
        return h3;
    }

    public void setH3(Integer h3) {
        this.h3 = h3;
    }

    public Integer getEtilt1() {
        return etilt1;
    }

    public void setEtilt1(Integer etilt1) {
        this.etilt1 = etilt1;
    }

    public Integer getEtilt2() {
        return etilt2;
    }

    public void setEtilt2(Integer etilt2) {
        this.etilt2 = etilt2;
    }

    public Integer getEtilt3() {
        return etilt3;
    }

    public void setEtilt3(Integer etilt3) {
        this.etilt3 = etilt3;
    }

    public Integer getAzimuth1() {
        return azimuth1;
    }

    public void setAzimuth1(Integer azimuth1) {
        this.azimuth1 = azimuth1;
    }

    public Integer getAzimuth2() {
        return azimuth2;
    }

    public void setAzimuth2(Integer azimuth2) {
        this.azimuth2 = azimuth2;
    }

    public Integer getAzimuth3() {
        return azimuth3;
    }

    public void setAzimuth3(Integer azimuth3) {
        this.azimuth3 = azimuth3;
    }

    public Integer getDtilt1() {
        return dtilt1;
    }

    public void setDtilt1(Integer dtilt1) {
        this.dtilt1 = dtilt1;
    }

    public Integer getDtilt2() {
        return dtilt2;
    }

    public void setDtilt2(Integer dtilt2) {
        this.dtilt2 = dtilt2;
    }

    public Integer getDtilt3() {
        return dtilt3;
    }

    public void setDtilt3(Integer dtilt3) {
        this.dtilt3 = dtilt3;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
