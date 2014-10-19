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
 * A data object class directly models database table <tt>MB_SYS_GSMCELL_RF</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysGsmcellRfDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>CELL_ID</tt>.
	 */
	private int cellId;

	/**
	 * This property corresponds to db column <tt>CELL_NAME</tt>.
	 */
	private String cellName;

	/**
	 * This property corresponds to db column <tt>AZIMUTH</tt>.
	 */
	private int azimuth;

	/**
	 * This property corresponds to db column <tt>HEIGHT</tt>.
	 */
	private int height;

	/**
	 * This property corresponds to db column <tt>MTILT</tt>.
	 */
	private String mtilt;

	/**
	 * This property corresponds to db column <tt>ETILT</tt>.
	 */
	private String etilt;

	/**
	 * This property corresponds to db column <tt>ANTENNA</tt>.
	 */
	private String antenna;

	/**
	 * This property corresponds to db column <tt>FAKE_ANTENNA</tt>.
	 */
	private boolean fakeAntenna;

	/**
	 * This property corresponds to db column <tt>UPDATE_TIME</tt>.
	 */
	private Date updateTime;

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

	/**
	 * This property corresponds to db column <tt>UPDATE_USER</tt>.
	 */
	private String updateUser;

	/**
	 * This property corresponds to db column <tt>CELL_GLB_ID</tt>.
	 */
	private int cellGlbId;

	/**
	 * This property corresponds to db column <tt>SITE_GLB_ID</tt>.
	 */
	private int siteGlbId;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>cellId</tt>.
     *
     * @return property value of cellId
     */
	public int getCellId() {
		return cellId;
	}
	
	/**
	 * Setter method for property <tt>cellId</tt>.
	 * 
	 * @param cellId value to be assigned to property cellId
     */
	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

    /**
     * Getter method for property <tt>cellName</tt>.
     *
     * @return property value of cellName
     */
	public String getCellName() {
		return cellName;
	}
	
	/**
	 * Setter method for property <tt>cellName</tt>.
	 * 
	 * @param cellName value to be assigned to property cellName
     */
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

    /**
     * Getter method for property <tt>azimuth</tt>.
     *
     * @return property value of azimuth
     */
	public int getAzimuth() {
		return azimuth;
	}
	
	/**
	 * Setter method for property <tt>azimuth</tt>.
	 * 
	 * @param azimuth value to be assigned to property azimuth
     */
	public void setAzimuth(int azimuth) {
		this.azimuth = azimuth;
	}

    /**
     * Getter method for property <tt>height</tt>.
     *
     * @return property value of height
     */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Setter method for property <tt>height</tt>.
	 * 
	 * @param height value to be assigned to property height
     */
	public void setHeight(int height) {
		this.height = height;
	}

    /**
     * Getter method for property <tt>mtilt</tt>.
     *
     * @return property value of mtilt
     */
	public String getMtilt() {
		return mtilt;
	}
	
	/**
	 * Setter method for property <tt>mtilt</tt>.
	 * 
	 * @param mtilt value to be assigned to property mtilt
     */
	public void setMtilt(String mtilt) {
		this.mtilt = mtilt;
	}

    /**
     * Getter method for property <tt>etilt</tt>.
     *
     * @return property value of etilt
     */
	public String getEtilt() {
		return etilt;
	}
	
	/**
	 * Setter method for property <tt>etilt</tt>.
	 * 
	 * @param etilt value to be assigned to property etilt
     */
	public void setEtilt(String etilt) {
		this.etilt = etilt;
	}

    /**
     * Getter method for property <tt>antenna</tt>.
     *
     * @return property value of antenna
     */
	public String getAntenna() {
		return antenna;
	}
	
	/**
	 * Setter method for property <tt>antenna</tt>.
	 * 
	 * @param antenna value to be assigned to property antenna
     */
	public void setAntenna(String antenna) {
		this.antenna = antenna;
	}

    /**
     * Getter method for property <tt>fakeAntenna</tt>.
     *
     * @return property value of fakeAntenna
     */
	public boolean getFakeAntenna() {
		return fakeAntenna;
	}
	
	/**
	 * Setter method for property <tt>fakeAntenna</tt>.
	 * 
	 * @param fakeAntenna value to be assigned to property fakeAntenna
     */
	public void setFakeAntenna(boolean fakeAntenna) {
		this.fakeAntenna = fakeAntenna;
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
     * Getter method for property <tt>cellGlbId</tt>.
     *
     * @return property value of cellGlbId
     */
	public int getCellGlbId() {
		return cellGlbId;
	}
	
	/**
	 * Setter method for property <tt>cellGlbId</tt>.
	 * 
	 * @param cellGlbId value to be assigned to property cellGlbId
     */
	public void setCellGlbId(int cellGlbId) {
		this.cellGlbId = cellGlbId;
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
