/**  
 * Plan7DaysOnlineEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author yuminglang
 * @date 2014年7月9日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * App 7 天在线 响应实体
 * 
 * @author yuminglang
 * @date 2014年7月9日 下午1:07:39
 */
public class Plan7DaysOnlineEntity {
    
    private String ts;// 时间，数据本身的时间属性
    private String city;// 归属地市
    private String phase;//工程期别
    private Integer planenbscnt;//规划站点数
    private Integer online7cnt;//连续7天在线基站数
    private Float ratio;//开通比例（online7cnt/ planenbscnt）
    public String getTs() {
        return ts;
    }
    public void setTs(String ts) {
        this.ts = ts;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPhase() {
        return phase;
    }
    public void setPhase(String phase) {
        this.phase = phase;
    }
    public Integer getPlanenbscnt() {
        return planenbscnt;
    }
    public void setPlanenbscnt(Integer planenbscnt) {
        this.planenbscnt = planenbscnt;
    }
    public Integer getOnline7cnt() {
        return online7cnt;
    }
    public void setOnline7cnt(Integer online7cnt) {
        this.online7cnt = online7cnt;
    }
    public Float getRatio() {
        return ratio;
    }
    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }
}
