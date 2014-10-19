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
 * 信令MMS记录
 * 
 * @author huangc
 * @date 2014年8月15日 上午9:42:50
 */

public class SignalMMSModel {

	@HRowField(adapter = Long128BA.class)
	private Long id; // id，全局生成的uid

	@HField(q = "gen_time")
	private Long time;// 日期

	@HField(q = "imsi")
	private String imsi;//用户IMSI号码（用户ID）

	@HField(q = "m_session")
	private String mmsSession;//MMS业务会话session的ID

	@HField(q = "event")
	private int event;

	@HField(q = "lac")//一个范围，可以理解为几个小区的集合
	private int lac;

	@HField(q = "cell")
	private int cell;//小区号

	@HField(q = "s_session")//关联用的session,理论上和TCP,UDP的SESSION是相等的
	private int subSession;

	@HField(q = "a_session")//应用会话
	private int appSession;

	@HField(q = "m_byte")
	private int mmsByte;// 彩信字节长度

	@HField(q = "err_type")
	private int errorType;// 错误类型

	@HField(q = "w_http_resp")
	private int wspHttpResponse;// wsp回应

	@HField(q = "m_resp")
	private int mmsResponse;// mms回应

	@HField(q = "m_status")
	private int mmsStatus;// mms状态

	@HField(q = "resp_time")
	private int respondTime;// 响应时长

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
	@HField(q = "busi_type")
	private String busiType;// 业务类型，由入库程序计算;
							// 通过URL那5个字段，其中任何一个和配置表mb_sys_url_usrattr的URL_HEAD1字段模糊相等，即确定出业务类别（mb_sys_url_usrattr的USER_LIKE_NAME字段）

	public String getHour() {
		return hour;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
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

	public int getErrorType() {
		return errorType;
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

	public int getMmsByte() {
		return mmsByte;
	}

	public int getMmsResponse() {
		return mmsResponse;
	}

	public String getMmsSession() {
		return mmsSession;
	}

	public int getMmsStatus() {
		return mmsStatus;
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

	public int getWspHttpResponse() {
		return wspHttpResponse;
	}

	public void setAppSession(int appSession) {
		this.appSession = appSession;
	}

	public void setCell(int cell) {
		this.cell = cell;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
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

	public void setMmsByte(int mmsByte) {
		this.mmsByte = mmsByte;
	}

	public void setMmsResponse(int mmsResponse) {
		this.mmsResponse = mmsResponse;
	}

	public void setMmsSession(String mmsSession) {
		this.mmsSession = mmsSession;
	}

	public void setMmsStatus(int mmsStatus) {
		this.mmsStatus = mmsStatus;
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

	public void setWspHttpResponse(int wspHttpResponse) {
		this.wspHttpResponse = wspHttpResponse;
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

	public static SignalMMSModel toBean(String signalMMSModel) {
		return JSON.parseObject(signalMMSModel, SignalMMSModel.class);
	}

	public String toJsonString() {
		return JSON.toJSONString(this, SerializerFeature.BrowserCompatible);
	}

}
