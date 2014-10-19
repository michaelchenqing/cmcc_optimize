/**  
 * CellInfoEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * 小区信息响应实体
 * 
 * @author yuminglang
 * @date 2014年6月26日 下午1:53:28
 */
public class CellInfoEntity {
    
    private String enbid;// 归属基站唯一编码(亿阳专有)

    private String cgi;// 全球小区识别码

    private String enname;// 小区英文名

    private String chname;// 小区中文名

    private String ts;// 时间
    
    private String city;//归属城市
    
    private String cid;//小区唯一编码 (亿阳专有)
    private Integer opestate;//激活状态
    private String vid;

    public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

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

    public String getCgi() {
        return cgi;
    }

    public void setCgi(String cgi) {
        this.cgi = cgi;
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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Integer getOpestate() {
		return opestate;
	}

	public void setOpestate(Integer opestate) {
		this.opestate = opestate;
	}
}
