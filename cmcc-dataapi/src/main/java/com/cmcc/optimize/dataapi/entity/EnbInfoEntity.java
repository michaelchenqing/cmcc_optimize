/**  
 * EnbInfoEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * 基站信息响应实体
 * 
 * @author yuminglang
 * @date 2014年6月26日 下午1:53:28
 */
public class EnbInfoEntity {
    
    private String enbid;// 基站唯一编码

    private String enname;// 基站英文名

    private String chname;// 基站中文名

    private String ts;// 更新时间
    
    private String city;//归属城市
    
    

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

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}
