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
 * A data object class directly models database table <tt>MB_SYS_LTECELL_RF</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysLtecellRfDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>CELL_GLB_ID</tt>.
	 */
	private int cellGlbId;

	/**
	 * This property corresponds to db column <tt>AZIMUTH</tt>.
	 */
	private long azimuth;

	/**
	 * This property corresponds to db column <tt>DOWNTILT</tt>.
	 */
	private long downtilt;

	/**
	 * This property corresponds to db column <tt>M_DOWNTILT</tt>.
	 */
	private long MDowntilt;

	/**
	 * This property corresponds to db column <tt>E_DOWNTILT</tt>.
	 */
	private long EDowntilt;

	/**
	 * This property corresponds to db column <tt>HEIGHT</tt>.
	 */
	private int height;

	/**
	 * This property corresponds to db column <tt>ALTITUDE</tt>.
	 */
	private int altitude;

	/**
	 * This property corresponds to db column <tt>ANTENNA</tt>.
	 */
	private String antenna;

	/**
	 * This property corresponds to db column <tt>FAKE_ANTENNA</tt>.
	 */
	private boolean fakeAntenna;

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
     * Getter method for property <tt>azimuth</tt>.
     *
     * @return property value of azimuth
     */
	public long getAzimuth() {
		return azimuth;
	}
	
	/**
	 * Setter method for property <tt>azimuth</tt>.
	 * 
	 * @param azimuth value to be assigned to property azimuth
     */
	public void setAzimuth(long azimuth) {
		this.azimuth = azimuth;
	}

    /**
     * Getter method for property <tt>downtilt</tt>.
     *
     * @return property value of downtilt
     */
	public long getDowntilt() {
		return downtilt;
	}
	
	/**
	 * Setter method for property <tt>downtilt</tt>.
	 * 
	 * @param downtilt value to be assigned to property downtilt
     */
	public void setDowntilt(long downtilt) {
		this.downtilt = downtilt;
	}

    /**
     * Getter method for property <tt>MDowntilt</tt>.
     *
     * @return property value of MDowntilt
     */
	public long getMDowntilt() {
		return MDowntilt;
	}
	
	/**
	 * Setter method for property <tt>MDowntilt</tt>.
	 * 
	 * @param MDowntilt value to be assigned to property MDowntilt
     */
	public void setMDowntilt(long MDowntilt) {
		this.MDowntilt = MDowntilt;
	}

    /**
     * Getter method for property <tt>EDowntilt</tt>.
     *
     * @return property value of EDowntilt
     */
	public long getEDowntilt() {
		return EDowntilt;
	}
	
	/**
	 * Setter method for property <tt>EDowntilt</tt>.
	 * 
	 * @param EDowntilt value to be assigned to property EDowntilt
     */
	public void setEDowntilt(long EDowntilt) {
		this.EDowntilt = EDowntilt;
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
     * Getter method for property <tt>altitude</tt>.
     *
     * @return property value of altitude
     */
	public int getAltitude() {
		return altitude;
	}
	
	/**
	 * Setter method for property <tt>altitude</tt>.
	 * 
	 * @param altitude value to be assigned to property altitude
     */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
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
