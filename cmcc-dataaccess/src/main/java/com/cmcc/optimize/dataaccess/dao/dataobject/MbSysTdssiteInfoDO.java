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
 * A data object class directly models database table <tt>MB_SYS_TDSSITE_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysTdssiteInfoDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>RNC_ID</tt>.
	 */
	private String rncId;

	/**
	 * This property corresponds to db column <tt>SITE_OID</tt>.
	 */
	private String siteOid;

	/**
	 * This property corresponds to db column <tt>SITE_NAME</tt>.
	 */
	private String siteName;

	/**
	 * This property corresponds to db column <tt>LAC</tt>.
	 */
	private int lac;

	/**
	 * This property corresponds to db column <tt>VENDOR</tt>.
	 */
	private String vendor;

	/**
	 * This property corresponds to db column <tt>LONGITUDE</tt>.
	 */
	private long longitude;

	/**
	 * This property corresponds to db column <tt>LATITUDE</tt>.
	 */
	private long latitude;

	/**
	 * This property corresponds to db column <tt>NETGRID</tt>.
	 */
	private int netgrid;

	/**
	 * This property corresponds to db column <tt>ENVIRON</tt>.
	 */
	private String environ;

	/**
	 * This property corresponds to db column <tt>FREQ_BAND</tt>.
	 */
	private String freqBand;

	/**
	 * This property corresponds to db column <tt>COVER_TYPE</tt>.
	 */
	private int coverType;

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

	/**
	 * This property corresponds to db column <tt>UPDATE_TIME</tt>.
	 */
	private Date updateTime;

	/**
	 * This property corresponds to db column <tt>UPDATE_USER</tt>.
	 */
	private String updateUser;

	/**
	 * This property corresponds to db column <tt>SITE_GLB_ID</tt>.
	 */
	private int siteGlbId;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>rncId</tt>.
     *
     * @return property value of rncId
     */
	public String getRncId() {
		return rncId;
	}
	
	/**
	 * Setter method for property <tt>rncId</tt>.
	 * 
	 * @param rncId value to be assigned to property rncId
     */
	public void setRncId(String rncId) {
		this.rncId = rncId;
	}

    /**
     * Getter method for property <tt>siteOid</tt>.
     *
     * @return property value of siteOid
     */
	public String getSiteOid() {
		return siteOid;
	}
	
	/**
	 * Setter method for property <tt>siteOid</tt>.
	 * 
	 * @param siteOid value to be assigned to property siteOid
     */
	public void setSiteOid(String siteOid) {
		this.siteOid = siteOid;
	}

    /**
     * Getter method for property <tt>siteName</tt>.
     *
     * @return property value of siteName
     */
	public String getSiteName() {
		return siteName;
	}
	
	/**
	 * Setter method for property <tt>siteName</tt>.
	 * 
	 * @param siteName value to be assigned to property siteName
     */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

    /**
     * Getter method for property <tt>lac</tt>.
     *
     * @return property value of lac
     */
	public int getLac() {
		return lac;
	}
	
	/**
	 * Setter method for property <tt>lac</tt>.
	 * 
	 * @param lac value to be assigned to property lac
     */
	public void setLac(int lac) {
		this.lac = lac;
	}

    /**
     * Getter method for property <tt>vendor</tt>.
     *
     * @return property value of vendor
     */
	public String getVendor() {
		return vendor;
	}
	
	/**
	 * Setter method for property <tt>vendor</tt>.
	 * 
	 * @param vendor value to be assigned to property vendor
     */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

    /**
     * Getter method for property <tt>longitude</tt>.
     *
     * @return property value of longitude
     */
	public long getLongitude() {
		return longitude;
	}
	
	/**
	 * Setter method for property <tt>longitude</tt>.
	 * 
	 * @param longitude value to be assigned to property longitude
     */
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

    /**
     * Getter method for property <tt>latitude</tt>.
     *
     * @return property value of latitude
     */
	public long getLatitude() {
		return latitude;
	}
	
	/**
	 * Setter method for property <tt>latitude</tt>.
	 * 
	 * @param latitude value to be assigned to property latitude
     */
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

    /**
     * Getter method for property <tt>netgrid</tt>.
     *
     * @return property value of netgrid
     */
	public int getNetgrid() {
		return netgrid;
	}
	
	/**
	 * Setter method for property <tt>netgrid</tt>.
	 * 
	 * @param netgrid value to be assigned to property netgrid
     */
	public void setNetgrid(int netgrid) {
		this.netgrid = netgrid;
	}

    /**
     * Getter method for property <tt>environ</tt>.
     *
     * @return property value of environ
     */
	public String getEnviron() {
		return environ;
	}
	
	/**
	 * Setter method for property <tt>environ</tt>.
	 * 
	 * @param environ value to be assigned to property environ
     */
	public void setEnviron(String environ) {
		this.environ = environ;
	}

    /**
     * Getter method for property <tt>freqBand</tt>.
     *
     * @return property value of freqBand
     */
	public String getFreqBand() {
		return freqBand;
	}
	
	/**
	 * Setter method for property <tt>freqBand</tt>.
	 * 
	 * @param freqBand value to be assigned to property freqBand
     */
	public void setFreqBand(String freqBand) {
		this.freqBand = freqBand;
	}

    /**
     * Getter method for property <tt>coverType</tt>.
     *
     * @return property value of coverType
     */
	public int getCoverType() {
		return coverType;
	}
	
	/**
	 * Setter method for property <tt>coverType</tt>.
	 * 
	 * @param coverType value to be assigned to property coverType
     */
	public void setCoverType(int coverType) {
		this.coverType = coverType;
	}

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
     * Getter method for property <tt>updateTime</tt>.
     *
     * @return property value of updateTime
     */
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * Setter method for property <tt>updateTime</tt>.
	 * 
	 * @param updateTime value to be assigned to property updateTime
     */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

    /**
     * Getter method for property <tt>updateUser</tt>.
     *
     * @return property value of updateUser
     */
	public String getUpdateUser() {
		return updateUser;
	}
	
	/**
	 * Setter method for property <tt>updateUser</tt>.
	 * 
	 * @param updateUser value to be assigned to property updateUser
     */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

    /**
     * Getter method for property <tt>siteGlbId</tt>.
     *
     * @return property value of siteGlbId
     */
	public int getSiteGlbId() {
		return siteGlbId;
	}
	
	/**
	 * Setter method for property <tt>siteGlbId</tt>.
	 * 
	 * @param siteGlbId value to be assigned to property siteGlbId
     */
	public void setSiteGlbId(int siteGlbId) {
		this.siteGlbId = siteGlbId;
	}
}
