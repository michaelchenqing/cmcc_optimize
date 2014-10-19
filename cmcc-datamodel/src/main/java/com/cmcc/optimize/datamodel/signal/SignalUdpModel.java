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
 * 信令UDP记录
 * 
 * @author huangc
 * @date 2014年8月15日 上午9:42:50
 */

public class SignalUdpModel {

	@HRowField(adapter = Long128BA.class)
	private Long id; // id，全局生成的uid

	@HField(q = "gen_time")
	private Long time;// 日期

	@HField(q = "imsi")
	private String imsi;

	@HField(q = "udp_session")
	private String udpSession;

	@HField(q = "event")
	private int event;// 事件

	@HField(q = "lac")
	private int lac;

	@HField(q = "cell")
	private int cell;// 小区

	@HField(q = "u_byte")
	private int upByte;// 上传字节

	@HField(q = "d_byte")
	private int downByte;// 下载字节

	@HField(q = "m_ip")
	private String mobileIp;// 终端IP

	@HField(q = "m_port")
	private int mobilePort;// 终端端口

	@HField(q = "opp_ip")
	private String oppsiteIp;// 对应的IP

	@HField(q = "opp_port")
	private int oppsitePort;// 对应的端口

	@HField(q = "resp_time")
	private int responseTime;// 响应时长

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

	public String getMobileIp() {
		return mobileIp;
	}

	public int getMobilePort() {
		return mobilePort;
	}

	public int getNetType() {
		return netType;
	}

	public String getOppsiteIp() {
		return oppsiteIp;
	}

	public int getOppsitePort() {
		return oppsitePort;
	}

	public int getResponseTime() {
		return responseTime;
	}

	public String getUdpSession() {
		return udpSession;
	}

	public int getUpByte() {
		return upByte;
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

	public void setMobileIp(String mobileIp) {
		this.mobileIp = mobileIp;
	}

	public void setMobilePort(int mobilePort) {
		this.mobilePort = mobilePort;
	}

	public void setNetType(int netType) {
		this.netType = netType;
	}

	public void setOppsiteIp(String oppsiteIp) {
		this.oppsiteIp = oppsiteIp;
	}

	public void setOppsitePort(int oppsitePort) {
		this.oppsitePort = oppsitePort;
	}

	public void setResponseTime(int responseTime) {
		this.responseTime = responseTime;
	}

	public void setUdpSession(String udpSession) {
		this.udpSession = udpSession;
	}

	public void setUpByte(int upByte) {
		this.upByte = upByte;
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

	public static SignalUdpModel toBean(String signalUdpModel) {
		return JSON.parseObject(signalUdpModel, SignalUdpModel.class);
	}

	public String toJsonString() {
		return JSON.toJSONString(this, SerializerFeature.BrowserCompatible);
	}

}
