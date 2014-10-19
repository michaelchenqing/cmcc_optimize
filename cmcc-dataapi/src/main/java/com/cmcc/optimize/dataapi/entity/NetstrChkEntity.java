/**  
 * NetstrChkEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * 网络结构对标响应实体
 * 
 * @author yuminglang
 * @date 2014年6月26日 下午1:53:28
 */
public class NetstrChkEntity {
    private String city;// 地市

    private String planedenbname;// 规划站名

    private String planedenbid;// 规划基站标识

    private String enbtype;// 基站类别

    private Float planlongitude;// 规划经度

    private Float planlatitude;// 规划纬度

    private Float rfheight;// 天线挂高

    private Float minenbdistance;// 最小站间距

    private Float cell1height;// 现场勘挂高CELL1

    private Float cell2height;// 现场勘挂高CELL2

    private Float cell3height;// 现场勘挂高CELL3

    private Float planedminenbdistance;// 规划最小站间距

    private Float gridid;// 网格id

    private String timestamp;// 时间

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlanedenbname() {
        return planedenbname;
    }

    public void setPlanedenbname(String planedenbname) {
        this.planedenbname = planedenbname;
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

    public Float getPlanlongitude() {
        return planlongitude;
    }

    public void setPlanlongitude(Float planlongitude) {
        this.planlongitude = planlongitude;
    }

    public Float getPlanlatitude() {
        return planlatitude;
    }

    public void setPlanlatitude(Float planlatitude) {
        this.planlatitude = planlatitude;
    }

    public Float getRfheight() {
        return rfheight;
    }

    public void setRfheight(Float rfheight) {
        this.rfheight = rfheight;
    }

    public Float getMinenbdistance() {
        return minenbdistance;
    }

    public void setMinenbdistance(Float minenbdistance) {
        this.minenbdistance = minenbdistance;
    }

    public Float getCell1height() {
        return cell1height;
    }

    public void setCell1height(Float cell1height) {
        this.cell1height = cell1height;
    }

    public Float getCell2height() {
        return cell2height;
    }

    public void setCell2height(Float cell2height) {
        this.cell2height = cell2height;
    }

    public Float getCell3height() {
        return cell3height;
    }

    public void setCell3height(Float cell3height) {
        this.cell3height = cell3height;
    }

    public Float getPlanedminenbdistance() {
        return planedminenbdistance;
    }

    public void setPlanedminenbdistance(Float planedminenbdistance) {
        this.planedminenbdistance = planedminenbdistance;
    }

    public Float getGridid() {
        return gridid;
    }

    public void setGridid(Float gridid) {
        this.gridid = gridid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
