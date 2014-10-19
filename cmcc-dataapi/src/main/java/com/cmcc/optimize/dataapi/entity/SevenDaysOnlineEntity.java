/**  
 * SevenDaysOnlineEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * 7天对标响应
 * 
 * @author yuminglang
 * @date 2014年6月26日 下午1:54:02
 */
public class SevenDaysOnlineEntity {

    private String city;// 地市

    private String planenbname;// 规划站名

    private String planedenbid;// 规划基站标识

    private String enbtype;// 基站类别

    private Float planedlongitude;// 规划经度

    private Float planedlatitude;// 规划纬度

    private String uniqueenbid;// 归属基站编号(亿阳专有)

    private String cgi;// 全球小区识别码

    private String timestamp;// 更新时间

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlanenbname() {
        return planenbname;
    }

    public void setPlanenbname(String planenbname) {
        this.planenbname = planenbname;
    }

    public String getPlanedenbid() {
        return planedenbid;
    }

    public void setPlanedenbid(String planedenbid) {
        this.planedenbid = planedenbid;
    }

    public String getEnbtype() {
        return enbtype;
    }

    public void setEnbtype(String enbtype) {
        this.enbtype = enbtype;
    }

    public float getPlanedlongitude() {
        return planedlongitude;
    }

    public void setPlanedlongitude(float planedlongitude) {
        this.planedlongitude = planedlongitude;
    }

    public float getPlanedlatitude() {
        return planedlatitude;
    }

    public void setPlanedlatitude(float planedlatitude) {
        this.planedlatitude = planedlatitude;
    }

    public String getUniqueenbid() {
        return uniqueenbid;
    }

    public void setUniqueenbid(String uniqueenbid) {
        this.uniqueenbid = uniqueenbid;
    }

    public String getCgi() {
        return cgi;
    }

    public void setCgi(String cgi) {
        this.cgi = cgi;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
