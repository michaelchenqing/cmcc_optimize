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
 * A data object class directly models database table <tt>MB_SYS_GIS_GSMPERMISSION</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysGisGsmpermissionDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>PROVINCE</tt>.
	 */
	private String province;

	/**
	 * This property corresponds to db column <tt>CITY</tt>.
	 */
	private String city;

	/**
	 * This property corresponds to db column <tt>COUNTY</tt>.
	 */
	private String county;

	/**
	 * This property corresponds to db column <tt>BSC_NAME</tt>.
	 */
	private String bscName;

	/**
	 * This property corresponds to db column <tt>SITE_NAME</tt>.
	 */
	private String siteName;

	/**
	 * This property corresponds to db column <tt>NETGRID</tt>.
	 */
	private String netgrid;

	/**
	 * This property corresponds to db column <tt>ENVIRON</tt>.
	 */
	private String environ;

	/**
	 * This property corresponds to db column <tt>VENDOR</tt>.
	 */
	private String vendor;

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
     * Getter method for property <tt>province</tt>.
     *
     * @return property value of province
     */
	public String getProvince() {
		return province;
	}
	
	/**
	 * Setter method for property <tt>province</tt>.
	 * 
	 * @param province value to be assigned to property province
     */
	public void setProvince(String province) {
		this.province = province;
	}

    /**
     * Getter method for property <tt>city</tt>.
     *
     * @return property value of city
     */
	public String getCity() {
		return city;
	}
	
	/**
	 * Setter method for property <tt>city</tt>.
	 * 
	 * @param city value to be assigned to property city
     */
	public void setCity(String city) {
		this.city = city;
	}

    /**
     * Getter method for property <tt>county</tt>.
     *
     * @return property value of county
     */
	public String getCounty() {
		return county;
	}
	
	/**
	 * Setter method for property <tt>county</tt>.
	 * 
	 * @param county value to be assigned to property county
     */
	public void setCounty(String county) {
		this.county = county;
	}

    /**
     * Getter method for property <tt>bscName</tt>.
     *
     * @return property value of bscName
     */
	public String getBscName() {
		return bscName;
	}
	
	/**
	 * Setter method for property <tt>bscName</tt>.
	 * 
	 * @param bscName value to be assigned to property bscName
     */
	public void setBscName(String bscName) {
		this.bscName = bscName;
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
     * Getter method for property <tt>netgrid</tt>.
     *
     * @return property value of netgrid
     */
	public String getNetgrid() {
		return netgrid;
	}
	
	/**
	 * Setter method for property <tt>netgrid</tt>.
	 * 
	 * @param netgrid value to be assigned to property netgrid
     */
	public void setNetgrid(String netgrid) {
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
