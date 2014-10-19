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
 * 信令SIG记录
 * 
 * @author huangc
 * @date 2014年8月15日 上午9:42:50
 */

public class SignalSigModel {

	@HRowField(adapter = Long128BA.class)
	private Long id; // id，全局生成的uid

	@HField(q = "gen_time")
	private Long time;

	@HField(q = "imsi")
	private String imsi;

	@HField(q = "sig_session")
	private String sigSession;

	@HField(q = "event")
	private int event;

	@HField(q = "lac")
	private int lac;

	@HField(q = "cell")
	private int cell;

	@HField(q = "sub_session")
	private int subSession;

	@HField(q = "pcu")
	private int pcu;// 分组控制单元

	@HField(q = "rac")
	private int rac;

	@HField(q = "result")
	private int result;

	@HField(q = "fail_r")
	private int failReason;// 失败原因

	@HField(q = "sig_d")
	private int sigDuration;// 信令持续时长

	@HField(q = "chan_type")
	private int channelType;// 渠道类型

	@HField(q = "b_type")
	private int busiType;// 业务类型

	@HField(q = "apn")
	private String apn;// apn地址

	@HField(q = "apv_4")
	private String apnIpv4;// apnIPV4地址

	@HField(q = "imei")
	private String imei;// 终端号

	@HField(q = "e_type")
	private int eventType;// 事件类型

	@HField(q = "n_type")
	private int netType;// 网络类型 234G
	@HField(q = "hour")
	private String hour;

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getApn() {
		return apn;
	}

	public String getApnIpv4() {
		return apnIpv4;
	}

	public int getBusiType() {
		return busiType;
	}

	public int getCell() {
		return cell;
	}

	public int getChannelType() {
		return channelType;
	}

	public int getEvent() {
		return event;
	}

	public int getEventType() {
		return eventType;
	}

	public int getFailReason() {
		return failReason;
	}

	public String getImei() {
		return imei;
	}

	public String getImsi() {
		return imsi;
	}

	public int getLac() {
		return lac;
	}

	public int getNetType() {
		return netType;
	}

	public int getPcu() {
		return pcu;
	}

	public int getRac() {
		return rac;
	}

	public int getResult() {
		return result;
	}

	public int getSigDuration() {
		return sigDuration;
	}

	public String getSigSession() {
		return sigSession;
	}

	public int getSubSession() {
		return subSession;
	}

	public void setApn(String apn) {
		this.apn = apn;
	}

	public void setApnIpv4(String apnIpv4) {
		this.apnIpv4 = apnIpv4;
	}

	public void setBusiType(int busiType) {
		this.busiType = busiType;
	}

	public void setCell(int cell) {
		this.cell = cell;
	}

	public void setChannelType(int channelType) {
		this.channelType = channelType;
	}

	public void setEvent(int event) {
		this.event = event;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public void setFailReason(int failReason) {
		this.failReason = failReason;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public void setLac(int lac) {
		this.lac = lac;
	}

	public void setNetType(int netType) {
		this.netType = netType;
	}

	public void setPcu(int pcu) {
		this.pcu = pcu;
	}

	public void setRac(int rac) {
		this.rac = rac;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public void setSigDuration(int sigDuration) {
		this.sigDuration = sigDuration;
	}

	public void setSigSession(String sigSession) {
		this.sigSession = sigSession;
	}

	public void setSubSession(int subSession) {
		this.subSession = subSession;
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

	public static SignalSigModel toBean(String signalSigModel) {
		return JSON.parseObject(signalSigModel, SignalSigModel.class);
	}

	public String toJsonString() {
		return JSON.toJSONString(this, SerializerFeature.BrowserCompatible);
	}

}
