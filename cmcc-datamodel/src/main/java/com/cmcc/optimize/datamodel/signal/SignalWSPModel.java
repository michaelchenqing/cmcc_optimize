/**  
 * SignalTcpModel.java
 * com.cmcc.dataprocess.model.signal
 * 
 * @author gaoqs
 * @date 2014年8月15日 上午9:42:50
 * 版权所有
 */
package com.cmcc.optimize.datamodel.signal;

import cn.cas.dps.hbase.HField;
import cn.cas.dps.hbase.HRowField;
import cn.cas.dps.hbase.bytes.Long128BA;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 信令wsp记录
 * 
 * @author huangc
 * @date 2014年8月15日 上午9:42:50
 */

public class SignalWSPModel {

	@HRowField(adapter = Long128BA.class)
	private Long id; // id，全局生成的uid

	@HField(q = "gen_time")
	private Long time;// 日期

	@HField(q = "imsi")
	private String imsi;

	@HField(q = "w_session")
	private String wspSession;

	@HField(q = "event")
	private int event;// 事件

	@HField(q = "lac")
	private int lac;

	@HField(q = "cell")
	private int cell;

	@HField(q = "s_session")
	private int subSession;

	@HField(q = "a_session")
	private int appSession;

	@HField(q = "u_type")
	private int upByte;// 上传字节

	@HField(q = "d_byte")
	private int downByte;// 下载字节

	@HField(q = "resp_time")
	private int respondTime;// 响应时长

	@HField(q = "method")
	private int method;// 方法 post/get ?

	@HField(q = "wtp_abort")
	private int wtpAbortReason;// wsp终止原因

	@HField(q = "wsp_resp_status")
	private int wspResponseStatus;// wsp响应状态

	@HField(q = "m_type")
	private String mobileType;// 终端类型

	@HField(q = "m_mms_flag")
	private int mobileMMSFlag;// 终端mms标识

	@HField(q = "url")
	private String url;

	@HField(q = "url1")
	private String url1;

	@HField(q = "url2")
	private String url2;

	@HField(q = "url3")
	private String url3;

	@HField(q = "url4")
	private String url4;

	@HField(q = "n_type")
	private int netType;// 网络类型 234G
	@HField(q = "hour")
	private String hour;
	 @HField(q="busi_type")
	    private String busiType;//业务类型，由入库程序计算;
								//通过URL那5个字段，其中任何一个和配置表mb_sys_url_usrattr的URL_HEAD1字段模糊相等，即确定出业务类别（mb_sys_url_usrattr的USER_LIKE_NAME字段）
	 
	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public int getAppSession() {
		return appSession;
	}

	public int getCell() {
		return cell;
	}

	public int getDownByte() {
		return downByte;
	}

	public int getEvent() {
		return event;
	}

	public String getImsi() {
		return imsi;
	}

	public int getLac() {
		return lac;
	}

	public int getMethod() {
		return method;
	}

	public int getMobileMMSFlag() {
		return mobileMMSFlag;
	}

	public String getMobileType() {
		return mobileType;
	}

	public int getNetType() {
		return netType;
	}

	public int getRespondTime() {
		return respondTime;
	}

	public int getSubSession() {
		return subSession;
	}

	public int getUpByte() {
		return upByte;
	}

	public String getUrl() {
		return url;
	}

	public String getUrl1() {
		return url1;
	}

	public String getUrl2() {
		return url2;
	}

	public String getUrl3() {
		return url3;
	}

	public String getUrl4() {
		return url4;
	}

	public int getWspResponseStatus() {
		return wspResponseStatus;
	}

	public String getWspSession() {
		return wspSession;
	}

	public int getWtpAbortReason() {
		return wtpAbortReason;
	}

	public void setAppSession(int appSession) {
		this.appSession = appSession;
	}

	public void setCell(int cell) {
		this.cell = cell;
	}

	public void setDownByte(int downByte) {
		this.downByte = downByte;
	}

	public void setEvent(int event) {
		this.event = event;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public void setLac(int lac) {
		this.lac = lac;
	}

	public void setMethod(int method) {
		this.method = method;
	}

	public void setMobileMMSFlag(int mobileMMSFlag) {
		this.mobileMMSFlag = mobileMMSFlag;
	}

	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}

	public void setNetType(int netType) {
		this.netType = netType;
	}

	public void setRespondTime(int respondTime) {
		this.respondTime = respondTime;
	}

	public void setSubSession(int subSession) {
		this.subSession = subSession;
	}

	public void setUpByte(int upByte) {
		this.upByte = upByte;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public void setUrl3(String url3) {
		this.url3 = url3;
	}

	public void setUrl4(String url4) {
		this.url4 = url4;
	}

	public void setWspResponseStatus(int wspResponseStatus) {
		this.wspResponseStatus = wspResponseStatus;
	}

	public void setWspSession(String wspSession) {
		this.wspSession = wspSession;
	}

	public void setWtpAbortReason(int wtpAbortReason) {
		this.wtpAbortReason = wtpAbortReason;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public static SignalWSPModel toBean(String signalWSPModel) {
		return JSON.parseObject(signalWSPModel, SignalWSPModel.class);
	}

	public String toJsonString() {
		return JSON.toJSONString(this, SerializerFeature.BrowserCompatible);
	}

}
