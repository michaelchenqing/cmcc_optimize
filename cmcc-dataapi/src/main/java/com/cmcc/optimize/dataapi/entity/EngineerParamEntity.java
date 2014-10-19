/**  
 * EngineerParamEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * 工参实体
 * 
 * @author huangc
 * @date 2014年6月26日
 */
public class EngineerParamEntity {
    private String city;// 城市名字

    private String planedenbname;// 规划站名

    private String planedenbid;// 规划基站标识

    private String cgi;// 全球小区识别码

    private Float planlongitude;// 规划经度

    private Float planlatitude;// 规划纬度

    private Float enblongitued;// 基站经度

    private Float enblatitude;// 基站纬度

    private Integer cell1azimuth;// 现场勘查方向角CELL1

    private Integer cell2azimuth;// 现场勘查方向角CELL2

    private Integer cell3azimuth;// 现场勘查方向角CELL3

    private Integer rfazimuth;// 天线方向角

    private Float cell1height;// 现场勘挂高CELL1

    private Float cell2height;// 现场勘挂高CELL2

    private Float cell3height;// 现场勘挂高CELL3

    private Float rfheight;// 天线挂高

    private Integer cell1electilt;// 现场查勘电下倾角CELL1

    private Integer cell2electilt;// 现场查勘电下倾角CELL2

    private Integer cell3electilt;// 现场查勘电下倾角CELL3

    private Integer rfelectilt;// 天线电子下倾角

    private String frequency;// 使用频段

    private String workfrequency;// 工作频段

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

    public String getCgi() {
        return cgi;
    }

    public void setCgi(String cgi) {
        this.cgi = cgi;
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

    public Float getEnblongitued() {
        return enblongitued;
    }

    public void setEnblongitued(Float enblongitued) {
        this.enblongitued = enblongitued;
    }

    public Float getEnblatitude() {
        return enblatitude;
    }

    public void setEnblatitude(Float enblatitude) {
        this.enblatitude = enblatitude;
    }

    public Integer getCell1azimuth() {
        return cell1azimuth;
    }

    public void setCell1azimuth(Integer cell1azimuth) {
        this.cell1azimuth = cell1azimuth;
    }

    public Integer getCell2azimuth() {
        return cell2azimuth;
    }

    public void setCell2azimuth(Integer cell2azimuth) {
        this.cell2azimuth = cell2azimuth;
    }

    public Integer getCell3azimuth() {
        return cell3azimuth;
    }

    public void setCell3azimuth(Integer cell3azimuth) {
        this.cell3azimuth = cell3azimuth;
    }

    public Integer getRfazimuth() {
        return rfazimuth;
    }

    public void setRfazimuth(Integer rfazimuth) {
        this.rfazimuth = rfazimuth;
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

    public Float getRfheight() {
        return rfheight;
    }

    public void setRfheight(Float rfheight) {
        this.rfheight = rfheight;
    }

    public Integer getCell1electilt() {
        return cell1electilt;
    }

    public void setCell1electilt(Integer cell1electilt) {
        this.cell1electilt = cell1electilt;
    }

    public Integer getCell2electilt() {
        return cell2electilt;
    }

    public void setCell2electilt(Integer cell2electilt) {
        this.cell2electilt = cell2electilt;
    }

    public Integer getCell3electilt() {
        return cell3electilt;
    }

    public void setCell3electilt(Integer cell3electilt) {
        this.cell3electilt = cell3electilt;
    }

    public Integer getRfelectilt() {
        return rfelectilt;
    }

    public void setRfelectilt(Integer rfelectilt) {
        this.rfelectilt = rfelectilt;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getWorkfrequency() {
        return workfrequency;
    }

    public void setWorkfrequency(String workfrequency) {
        this.workfrequency = workfrequency;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
