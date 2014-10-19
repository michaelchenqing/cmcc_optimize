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
 * A data object class directly models database table <tt>MB_SYS_GIS_PERMISSION</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysGisPermissionDO {
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
	 * This property corresponds to db column <tt>ENODEB_GLB_ID</tt>.
	 */
	private String enodebGlbId;

	/**
	 * This property corresponds to db column <tt>ENODEB_ID</tt>.
	 */
	private String enodebId;

	/**
	 * This property corresponds to db column <tt>ENODEB_NAME</tt>.
	 */
	private String enodebName;

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
	 * This property corresponds to db column <tt>ADDRESS</tt>.
	 */
	private String address;

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
     * Getter method for property <tt>enodebGlbId</tt>.
     *
     * @return property value of enodebGlbId
     */
	public String getEnodebGlbId() {
		return enodebGlbId;
	}
	
	/**
	 * Setter method for property <tt>enodebGlbId</tt>.
	 * 
	 * @param enodebGlbId value to be assigned to property enodebGlbId
     */
	public void setEnodebGlbId(String enodebGlbId) {
		this.enodebGlbId = enodebGlbId;
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
     * Getter method for property <tt>enodebName</tt>.
     *
     * @return property value of enodebName
     */
	public String getEnodebName() {
		return enodebName;
	}
	
	/**
	 * Setter method for property <tt>enodebName</tt>.
	 * 
	 * @param enodebName value to be assigned to property enodebName
     */
	public void setEnodebName(String enodebName) {
		this.enodebName = enodebName;
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
     * Getter method for property <tt>address</tt>.
     *
     * @return property value of address
     */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Setter method for property <tt>address</tt>.
	 * 
	 * @param address value to be assigned to property address
     */
	public void setAddress(String address) {
		this.address = address;
	}
}
