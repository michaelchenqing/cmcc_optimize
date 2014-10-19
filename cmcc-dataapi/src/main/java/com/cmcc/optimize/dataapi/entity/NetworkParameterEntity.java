/**  
 * NetworkParameterEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author yuminglang
 * @date 2014年7月10日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * 现网工参基站信息响应实体
 * 
 * @author yuminglang
 * @date 2014年7月10日 下午1:07:39
 */
public class NetworkParameterEntity {

    private String gid;// 基站全局唯一标识（自定义）

    private String enbid;// 基站标识

    private String name;// 基站名

    private String tac;// 区域跟踪码

    private String vendor;// 厂商

    private String prov;// 省份

    private String city;// 归属地市

    private String town;// 区县

    private String grid;// 网格信息

    private String phase;// 工程期别

    private String address;// 地址

    private Float lon;// 基站经度

    private Float lat;// 基站纬度

    private Float mindis;// 最小站间距

    private String singlepass;// 单验通过

    private String covertype;// 覆盖类型

    private String env;// 场景

    private String workfreq;// 工作频段

    private String ts;// 时间
    
    private String regiontype;//区域类型
    

    public String getRegiontype() {
        return regiontype;
    }

    public void setRegiontype(String regiontype) {
        this.regiontype = regiontype;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getEnbid() {
        return enbid;
    }

    public void setEnbid(String enbid) {
        this.enbid = enbid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
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

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getSinglepass() {
        return singlepass;
    }

    public void setSinglepass(String singlepass) {
        this.singlepass = singlepass;
    }

    public String getCovertype() {
        return covertype;
    }

    public void setCovertype(String covertype) {
        this.covertype = covertype;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
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
