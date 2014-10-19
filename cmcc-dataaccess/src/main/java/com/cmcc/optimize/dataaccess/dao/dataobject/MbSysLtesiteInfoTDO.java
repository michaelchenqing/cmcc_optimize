/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.dataobject;

// auto generated imports
import java.util.Date;

/**
 * A data object class directly models database table <tt>MB_SYS_LTESITE_INFO_T</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysLtesiteInfoTDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

	/**
	 * This property corresponds to db column <tt>INT_ID</tt>.
	 */
	private String intId;

	/**
	 * This property corresponds to db column <tt>OBJECT_RDN</tt>.
	 */
	private String objectRdn;

	/**
	 * This property corresponds to db column <tt>NAME</tt>.
	 */
	private String name;

	/**
	 * This property corresponds to db column <tt>ZH_NAME</tt>.
	 */
	private String zhName;

	/**
	 * This property corresponds to db column <tt>OMC_ID</tt>.
	 */
	private Integer omcId;

	/**
	 * This property corresponds to db column <tt>VENDOR_ID</tt>.
	 */
	private String vendorId;

	/**
	 * This property corresponds to db column <tt>CITY_ID</tt>.
	 */
	private String cityId;

	/**
	 * This property corresponds to db column <tt>TIME_STAMP</tt>.
	 */
	private Date timeStamp;

	/**
	 * This property corresponds to db column <tt>UPDATE_STAMP</tt>.
	 */
	private Date updateStamp;

	/**
	 * This property corresponds to db column <tt>CONFIRMED</tt>.
	 */
	private String confirmed;

	/**
	 * This property corresponds to db column <tt>STATE</tt>.
	 */
	private String state;

	/**
	 * This property corresponds to db column <tt>ENODEB_ID</tt>.
	 */
	private String enodebId;

	/**
	 * This property corresponds to db column <tt>ENBID</tt>.
	 */
	private String enbid;

	/**
	 * This property corresponds to db column <tt>X2BLACKLIST</tt>.
	 */
	private String x2blacklist;

	/**
	 * This property corresponds to db column <tt>X2WHITELIST</tt>.
	 */
	private String x2whitelist;

	/**
	 * This property corresponds to db column <tt>X2HOBLACKLIST</tt>.
	 */
	private String x2hoblacklist;

	/**
	 * This property corresponds to db column <tt>COVER_AREA_INFO</tt>.
	 */
	private String coverAreaInfo;

	/**
	 * This property corresponds to db column <tt>X2IPADDRESSLIST</tt>.
	 */
	private String x2ipaddresslist;

	/**
	 * This property corresponds to db column <tt>MAX_THROUGHPUT_RATE</tt>.
	 */
	private Float maxThroughputRate;

	/**
	 * This property corresponds to db column <tt>ADMINISTRATIVESTATE</tt>.
	 */
	private String administrativestate;

	/**
	 * This property corresponds to db column <tt>OPERATIONALSTATE</tt>.
	 */
	private String operationalstate;

	/**
	 * This property corresponds to db column <tt>X2_NUM</tt>.
	 */
	private Integer x2Num;

	/**
	 * This property corresponds to db column <tt>INTEGRITYPROTALGORITHM</tt>.
	 */
	private String integrityprotalgorithm;

	/**
	 * This property corresponds to db column <tt>CIPHERINGALGORITHM</tt>.
	 */
	private String cipheringalgorithm;

	/**
	 * This property corresponds to db column <tt>RELATED_ME</tt>.
	 */
	private String relatedMe;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>recordTime</tt>.
     *
     * @return property value of recordTime
     */
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * Setter method for property <tt>recordTime</tt>.
	 * 
	 * @param recordTime value to be assigned to property recordTime
     */
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

    /**
     * Getter method for property <tt>intId</tt>.
     *
     * @return property value of intId
     */
	public String getIntId() {
		return intId;
	}
	
	/**
	 * Setter method for property <tt>intId</tt>.
	 * 
	 * @param intId value to be assigned to property intId
     */
	public void setIntId(String intId) {
		this.intId = intId;
	}

    /**
     * Getter method for property <tt>objectRdn</tt>.
     *
     * @return property value of objectRdn
     */
	public String getObjectRdn() {
		return objectRdn;
	}
	
	/**
	 * Setter method for property <tt>objectRdn</tt>.
	 * 
	 * @param objectRdn value to be assigned to property objectRdn
     */
	public void setObjectRdn(String objectRdn) {
		this.objectRdn = objectRdn;
	}

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter method for property <tt>name</tt>.
	 * 
	 * @param name value to be assigned to property name
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * Getter method for property <tt>zhName</tt>.
     *
     * @return property value of zhName
     */
	public String getZhName() {
		return zhName;
	}
	
	/**
	 * Setter method for property <tt>zhName</tt>.
	 * 
	 * @param zhName value to be assigned to property zhName
     */
	public void setZhName(String zhName) {
		this.zhName = zhName;
	}

    /**
     * Getter method for property <tt>omcId</tt>.
     *
     * @return property value of omcId
     */
	public Integer getOmcId() {
		return omcId;
	}
	
	/**
	 * Setter method for property <tt>omcId</tt>.
	 * 
	 * @param omcId value to be assigned to property omcId
     */
	public void setOmcId(Integer omcId) {
		this.omcId = omcId;
	}

    /**
     * Getter method for property <tt>vendorId</tt>.
     *
     * @return property value of vendorId
     */
	public String getVendorId() {
		return vendorId;
	}
	
	/**
	 * Setter method for property <tt>vendorId</tt>.
	 * 
	 * @param vendorId value to be assigned to property vendorId
     */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

    /**
     * Getter method for property <tt>cityId</tt>.
     *
     * @return property value of cityId
     */
	public String getCityId() {
		return cityId;
	}
	
	/**
	 * Setter method for property <tt>cityId</tt>.
	 * 
	 * @param cityId value to be assigned to property cityId
     */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

    /**
     * Getter method for property <tt>timeStamp</tt>.
     *
     * @return property value of timeStamp
     */
	public Date getTimeStamp() {
		return timeStamp;
	}
	
	/**
	 * Setter method for property <tt>timeStamp</tt>.
	 * 
	 * @param timeStamp value to be assigned to property timeStamp
     */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

    /**
     * Getter method for property <tt>updateStamp</tt>.
     *
     * @return property value of updateStamp
     */
	public Date getUpdateStamp() {
		return updateStamp;
	}
	
	/**
	 * Setter method for property <tt>updateStamp</tt>.
	 * 
	 * @param updateStamp value to be assigned to property updateStamp
     */
	public void setUpdateStamp(Date updateStamp) {
		this.updateStamp = updateStamp;
	}

    /**
     * Getter method for property <tt>confirmed</tt>.
     *
     * @return property value of confirmed
     */
	public String getConfirmed() {
		return confirmed;
	}
	
	/**
	 * Setter method for property <tt>confirmed</tt>.
	 * 
	 * @param confirmed value to be assigned to property confirmed
     */
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

    /**
     * Getter method for property <tt>state</tt>.
     *
     * @return property value of state
     */
	public String getState() {
		return state;
	}
	
	/**
	 * Setter method for property <tt>state</tt>.
	 * 
	 * @param state value to be assigned to property state
     */
	public void setState(String state) {
		this.state = state;
	}

    /**
     * Getter method for property <tt>enodebId</tt>.
     *
     * @return property value of enodebId
     */
	public String getEnodebId() {
		return enodebId;
	}
	
	/**
	 * Setter method for property <tt>enodebId</tt>.
	 * 
	 * @param enodebId value to be assigned to property enodebId
     */
	public void setEnodebId(String enodebId) {
		this.enodebId = enodebId;
	}

    /**
     * Getter method for property <tt>enbid</tt>.
     *
     * @return property value of enbid
     */
	public String getEnbid() {
		return enbid;
	}
	
	/**
	 * Setter method for property <tt>enbid</tt>.
	 * 
	 * @param enbid value to be assigned to property enbid
     */
	public void setEnbid(String enbid) {
		this.enbid = enbid;
	}

    /**
     * Getter method for property <tt>x2blacklist</tt>.
     *
     * @return property value of x2blacklist
     */
	public String getX2blacklist() {
		return x2blacklist;
	}
	
	/**
	 * Setter method for property <tt>x2blacklist</tt>.
	 * 
	 * @param x2blacklist value to be assigned to property x2blacklist
     */
	public void setX2blacklist(String x2blacklist) {
		this.x2blacklist = x2blacklist;
	}

    /**
     * Getter method for property <tt>x2whitelist</tt>.
     *
     * @return property value of x2whitelist
     */
	public String getX2whitelist() {
		return x2whitelist;
	}
	
	/**
	 * Setter method for property <tt>x2whitelist</tt>.
	 * 
	 * @param x2whitelist value to be assigned to property x2whitelist
     */
	public void setX2whitelist(String x2whitelist) {
		this.x2whitelist = x2whitelist;
	}

    /**
     * Getter method for property <tt>x2hoblacklist</tt>.
     *
     * @return property value of x2hoblacklist
     */
	public String getX2hoblacklist() {
		return x2hoblacklist;
	}
	
	/**
	 * Setter method for property <tt>x2hoblacklist</tt>.
	 * 
	 * @param x2hoblacklist value to be assigned to property x2hoblacklist
     */
	public void setX2hoblacklist(String x2hoblacklist) {
		this.x2hoblacklist = x2hoblacklist;
	}

    /**
     * Getter method for property <tt>coverAreaInfo</tt>.
     *
     * @return property value of coverAreaInfo
     */
	public String getCoverAreaInfo() {
		return coverAreaInfo;
	}
	
	/**
	 * Setter method for property <tt>coverAreaInfo</tt>.
	 * 
	 * @param coverAreaInfo value to be assigned to property coverAreaInfo
     */
	public void setCoverAreaInfo(String coverAreaInfo) {
		this.coverAreaInfo = coverAreaInfo;
	}

    /**
     * Getter method for property <tt>x2ipaddresslist</tt>.
     *
     * @return property value of x2ipaddresslist
     */
	public String getX2ipaddresslist() {
		return x2ipaddresslist;
	}
	
	/**
	 * Setter method for property <tt>x2ipaddresslist</tt>.
	 * 
	 * @param x2ipaddresslist value to be assigned to property x2ipaddresslist
     */
	public void setX2ipaddresslist(String x2ipaddresslist) {
		this.x2ipaddresslist = x2ipaddresslist;
	}

    /**
     * Getter method for property <tt>maxThroughputRate</tt>.
     *
     * @return property value of maxThroughputRate
     */
	public Float getMaxThroughputRate() {
		return maxThroughputRate;
	}
	
	/**
	 * Setter method for property <tt>maxThroughputRate</tt>.
	 * 
	 * @param maxThroughputRate value to be assigned to property maxThroughputRate
     */
	public void setMaxThroughputRate(Float maxThroughputRate) {
		this.maxThroughputRate = maxThroughputRate;
	}

    /**
     * Getter method for property <tt>administrativestate</tt>.
     *
     * @return property value of administrativestate
     */
	public String getAdministrativestate() {
		return administrativestate;
	}
	
	/**
	 * Setter method for property <tt>administrativestate</tt>.
	 * 
	 * @param administrativestate value to be assigned to property administrativestate
     */
	public void setAdministrativestate(String administrativestate) {
		this.administrativestate = administrativestate;
	}

    /**
     * Getter method for property <tt>operationalstate</tt>.
     *
     * @return property value of operationalstate
     */
	public String getOperationalstate() {
		return operationalstate;
	}
	
	/**
	 * Setter method for property <tt>operationalstate</tt>.
	 * 
	 * @param operationalstate value to be assigned to property operationalstate
     */
	public void setOperationalstate(String operationalstate) {
		this.operationalstate = operationalstate;
	}

    /**
     * Getter method for property <tt>x2Num</tt>.
     *
     * @return property value of x2Num
     */
	public Integer getX2Num() {
		return x2Num;
	}
	
	/**
	 * Setter method for property <tt>x2Num</tt>.
	 * 
	 * @param x2Num value to be assigned to property x2Num
     */
	public void setX2Num(Integer x2Num) {
		this.x2Num = x2Num;
	}

    /**
     * Getter method for property <tt>integrityprotalgorithm</tt>.
     *
     * @return property value of integrityprotalgorithm
     */
	public String getIntegrityprotalgorithm() {
		return integrityprotalgorithm;
	}
	
	/**
	 * Setter method for property <tt>integrityprotalgorithm</tt>.
	 * 
	 * @param integrityprotalgorithm value to be assigned to property integrityprotalgorithm
     */
	public void setIntegrityprotalgorithm(String integrityprotalgorithm) {
		this.integrityprotalgorithm = integrityprotalgorithm;
	}

    /**
     * Getter method for property <tt>cipheringalgorithm</tt>.
     *
     * @return property value of cipheringalgorithm
     */
	public String getCipheringalgorithm() {
		return cipheringalgorithm;
	}
	
	/**
	 * Setter method for property <tt>cipheringalgorithm</tt>.
	 * 
	 * @param cipheringalgorithm value to be assigned to property cipheringalgorithm
     */
	public void setCipheringalgorithm(String cipheringalgorithm) {
		this.cipheringalgorithm = cipheringalgorithm;
	}

    /**
     * Getter method for property <tt>relatedMe</tt>.
     *
     * @return property value of relatedMe
     */
	public String getRelatedMe() {
		return relatedMe;
	}
	
	/**
	 * Setter method for property <tt>relatedMe</tt>.
	 * 
	 * @param relatedMe value to be assigned to property relatedMe
     */
	public void setRelatedMe(String relatedMe) {
		this.relatedMe = relatedMe;
	}
}
