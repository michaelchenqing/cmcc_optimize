/**  
 * NetCellinfoEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author yuminglang
 * @date 2014年7月10日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * 现网工参小区信息响应实体
 * 
 * @author yuminglang
 * @date 2014年7月10日 下午1:07:39
 */
public class NetCellinfoEntity {
    private String gid;// 小区唯一标识（自定义）

    private String genbid;// 归属基站唯一标识（自定义）

    private String enbid;// 归属基站enbid

    private String ci;// 小区标识

    private String cname;// 小区名称

    private String pci;// 物理小区标识

    private String cgi;// 全球小区识别码

    private Float earfcn;// 下行频点

    private Float rspower;// 参考信号功率

    private Float sfassign;// 上下行子帧配比

    private Float specsfr;// 特殊子帧配比

    private String pa;// PDSCH偏置

    private Float alti;// 海拔高度

    private Integer azimuth;// 天线方向角

    private Integer tilt;// 总下倾角

    private Integer etilt;// 天线电子下倾角

    private Integer mtilt;// 机械下倾角

    private Float height;// 天线挂高

    private String anttype;// 天线型号

    private String fake;// 是否美化天线

    private String share;// 是否共天馈

    private String anttypeold;// 天面方式

    private String ts;// 时间
    
    private String remote;//是否拉远


    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGenbid() {
        return genbid;
    }

    public void setGenbid(String genbid) {
        this.genbid = genbid;
    }

    public String getEnbid() {
        return enbid;
    }

    public void setEnbid(String enbid) {
        this.enbid = enbid;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPci() {
        return pci;
    }

    public void setPci(String pci) {
        this.pci = pci;
    }

    public String getCgi() {
        return cgi;
    }

    public void setCgi(String cgi) {
        this.cgi = cgi;
    }

    public Float getEarfcn() {
        return earfcn;
    }

    public void setEarfcn(Float earfcn) {
        this.earfcn = earfcn;
    }

    public Float getRspower() {
        return rspower;
    }

    public void setRspower(Float rspower) {
        this.rspower = rspower;
    }

    public Float getSfassign() {
        return sfassign;
    }

    public void setSfassign(Float sfassign) {
        this.sfassign = sfassign;
    }

    public Float getSpecsfr() {
        return specsfr;
    }

    public void setSpecsfr(Float specsfr) {
        this.specsfr = specsfr;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public Float getAlti() {
        return alti;
    }

    public void setAlti(Float alti) {
        this.alti = alti;
    }

    public Integer getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(Integer azimuth) {
        this.azimuth = azimuth;
    }

    public Integer getTilt() {
        return tilt;
    }

    public void setTilt(Integer tilt) {
        this.tilt = tilt;
    }

    public Integer getEtilt() {
        return etilt;
    }

    public void setEtilt(Integer etilt) {
        this.etilt = etilt;
    }

    public Integer getMtilt() {
        return mtilt;
    }

    public void setMtilt(Integer mtilt) {
        this.mtilt = mtilt;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getAnttype() {
        return anttype;
    }

    public void setAnttype(String anttype) {
        this.anttype = anttype;
    }

    public String getFake() {
        return fake;
    }

    public void setFake(String fake) {
        this.fake = fake;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getAnttypeold() {
        return anttypeold;
    }

    public void setAnttypeold(String anttypeold) {
        this.anttypeold = anttypeold;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}
