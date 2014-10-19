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
 * A data object class directly models database table <tt>MB_SYS_LTESITE_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysLtesiteInfoDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>ENODEB_GLB_ID</tt>.
	 */
	private int enodebGlbId;

	/**
	 * This property corresponds to db column <tt>ENODEB_ID</tt>.
	 */
	private String enodebId;

	/**
	 * This property corresponds to db column <tt>ENODEB_NAME</tt>.
	 */
	private String enodebName;

	/**
	 * This property corresponds to db column <tt>TAC</tt>.
	 */
	private int tac;

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
	 * This property corresponds to db column <tt>PROJECT_PERIOD</tt>.
	 */
	private String projectPeriod;

	/**
	 * This property corresponds to db column <tt>SINGLE_PASS</tt>.
	 */
	private int singlePass;

	/**
	 * This property corresponds to db column <tt>INIT_TIME</tt>.
	 */
	private Date initTime;

	/**
	 * This property corresponds to db column <tt>RUN_TIME</tt>.
	 */
	private Date runTime;

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

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>enodebGlbId</tt>.
     *
     * @return property value of enodebGlbId
     */
	public int getEnodebGlbId() {
		return enodebGlbId;
	}
	
	/**
	 * Setter method for property <tt>enodebGlbId</tt>.
	 * 
	 * @param enodebGlbId value to be assigned to property enodebGlbId
     */
	public void setEnodebGlbId(int enodebGlbId) {
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
     * Getter method for property <tt>tac</tt>.
     *
     * @return property value of tac
     */
	public int getTac() {
		return tac;
	}
	
	/**
	 * Setter method for property <tt>tac</tt>.
	 * 
	 * @param tac value to be assigned to property tac
     */
	public void setTac(int tac) {
		this.tac = tac;
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
     * Getter method for property <tt>projectPeriod</tt>.
     *
     * @return property value of projectPeriod
     */
	public String getProjectPeriod() {
		return projectPeriod;
	}
	
	/**
	 * Setter method for property <tt>projectPeriod</tt>.
	 * 
	 * @param projectPeriod value to be assigned to property projectPeriod
     */
	public void setProjectPeriod(String projectPeriod) {
		this.projectPeriod = projectPeriod;
	}

    /**
     * Getter method for property <tt>singlePass</tt>.
     *
     * @return property value of singlePass
     */
	public int getSinglePass() {
		return singlePass;
	}
	
	/**
	 * Setter method for property <tt>singlePass</tt>.
	 * 
	 * @param singlePass value to be assigned to property singlePass
     */
	public void setSinglePass(int singlePass) {
		this.singlePass = singlePass;
	}

    /**
     * Getter method for property <tt>initTime</tt>.
     *
     * @return property value of initTime
     */
	public Date getInitTime() {
		return initTime;
	}
	
	/**
	 * Setter method for property <tt>initTime</tt>.
	 * 
	 * @param initTime value to be assigned to property initTime
     */
	public void setInitTime(Date initTime) {
		this.initTime = initTime;
	}

    /**
     * Getter method for property <tt>runTime</tt>.
     *
     * @return property value of runTime
     */
	public Date getRunTime() {
		return runTime;
	}
	
	/**
	 * Setter method for property <tt>runTime</tt>.
	 * 
	 * @param runTime value to be assigned to property runTime
     */
	public void setRunTime(Date runTime) {
		this.runTime = runTime;
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
}
