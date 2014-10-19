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
 * 信令tcp记录
 * 
 * @author huangc
 * @date 2014年8月15日 上午9:42:50
 */

public class SignalTcpModel {

	@HRowField(adapter = Long128BA.class)
	private Long id; // id，全局生成的uid

	@HField(q = "gen_time")
	private Long time;// 日期

	@HField(q = "imsi")
	private String imsi;

	@HField(q = "tcp_session")
	private String tcpSession;

	@HField(q = "event")
	private int event;

	@HField(q = "lac")
	private int lac;

	@HField(q = "cell")
	private int cell;// 小区

	@HField(q = "s_session")
	private int subSession;

	@HField(q = "u_byte")
	private int upByte;// 上传字节

	@HField(q = "u_resp_time")
	private int upResponseTime;// 上传回应时长

	@HField(q = "d_byte")
	private int downByte;// 下载字节

	@HField(q = "d_resp_time")
	private int downResponseTime;// 下载回应时长

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

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getTcpSession() {
		return tcpSession;
	}

	public void setTcpSession(String tcpSession) {
		this.tcpSession = tcpSession;
	}

	public int getEvent() {
		return event;
	}

	public void setEvent(int event) {
		this.event = event;
	}

	public int getLac() {
		return lac;
	}

	public void setLac(int lac) {
		this.lac = lac;
	}

	public int getCell() {
		return cell;
	}

	public void setCell(int cell) {
		this.cell = cell;
	}

	public int getSubSession() {
		return subSession;
	}

	public void setSubSession(int subSession) {
		this.subSession = subSession;
	}

	public int getUpByte() {
		return upByte;
	}

	public void setUpByte(int upByte) {
		this.upByte = upByte;
	}

	public int getUpResponseTime() {
		return upResponseTime;
	}

	public void setUpResponseTime(int upResponseTime) {
		this.upResponseTime = upResponseTime;
	}

	public int getDownByte() {
		return downByte;
	}

	public void setDownByte(int downByte) {
		this.downByte = downByte;
	}

	public int getDownResponseTime() {
		return downResponseTime;
	}

	public void setDownResponseTime(int downResponseTime) {
		this.downResponseTime = downResponseTime;
	}

	public int getNetType() {
		return netType;
	}

	public void setNetType(int netType) {
		this.netType = netType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static SignalTcpModel toBean(String signalTcpModel) {
		return JSON.parseObject(signalTcpModel, SignalTcpModel.class);
	}

	public String toJsonString() {
		return JSON.toJSONString(this, SerializerFeature.BrowserCompatible);
	}

}
