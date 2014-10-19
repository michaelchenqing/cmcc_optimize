/**  
 * EnbParameterEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * 现网工参响应实体
 * 
 * @author yuminglang
 * @date 2014年6月26日 下午1:53:28
 */
public class EnbParameterEntity {
    
    private String city;// 归属地市

    private String uid;// 小区级唯一标识

    private Float mindis;// 最小站间距

    private String grid;// 网格信息

    private String cgi;// 全球小区识别码

    private String phase;// 工程期别

    private Integer tilt;// 总下倾角

    private Integer azimuth;// 天线方向角

    private Integer etilt;// 天线电子下倾角

    private Float height;// 天线挂高

    private Float lon;// 基站经度

    private Float lat;// 基站纬度

    private String workfreq;// 工作频段

    private String ts;// 时间
    
    private String covertype;
    
    public String getCovertype() {
		return covertype;
	}

	public void setCovertype(String covertype) {
		this.covertype = covertype;
	}

	public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Float getMindis() {
        return mindis;
    }

    public void setMindis(Float mindis) {
        this.mindis = mindis;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getCgi() {
        return cgi;
    }

    public void setCgi(String cgi) {
        this.cgi = cgi;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Integer getTilt() {
        return tilt;
    }

    public void setTilt(Integer tilt) {
        this.tilt = tilt;
    }

    public Integer getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(Integer azimuth) {
        this.azimuth = azimuth;
    }

    public Integer getEtilt() {
        return etilt;
    }

    public void setEtilt(Integer etilt) {
        this.etilt = etilt;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
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

    public String getWorkfreq() {
        return workfreq;
    }

    public void setWorkfreq(String workfreq) {
        this.workfreq = workfreq;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}
