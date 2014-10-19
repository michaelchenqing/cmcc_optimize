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
 * A data object class directly models database table <tt>MB_SYS_TDSCELL_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysTdscellInfoDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>CELL_ID</tt>.
	 */
	private long cellId;

	/**
	 * This property corresponds to db column <tt>CELL_NAME</tt>.
	 */
	private String cellName;

	/**
	 * This property corresponds to db column <tt>SITE_OID</tt>.
	 */
	private String siteOid;

	/**
	 * This property corresponds to db column <tt>CGI</tt>.
	 */
	private String cgi;

	/**
	 * This property corresponds to db column <tt>RRU_REMOTE</tt>.
	 */
	private String rruRemote;

	/**
	 * This property corresponds to db column <tt>CELL_LONGITUDE</tt>.
	 */
	private int cellLongitude;

	/**
	 * This property corresponds to db column <tt>CELL_LATITUDE</tt>.
	 */
	private int cellLatitude;

	/**
	 * This property corresponds to db column <tt>SECTOR_ID</tt>.
	 */
	private int sectorId;

	/**
	 * This property corresponds to db column <tt>PCI</tt>.
	 */
	private int pci;

	/**
	 * This property corresponds to db column <tt>EARFCN</tt>.
	 */
	private int earfcn;

	/**
	 * This property corresponds to db column <tt>RF_POWER</tt>.
	 */
	private int rfPower;

	/**
	 * This property corresponds to db column <tt>COVERTYPE</tt>.
	 */
	private String covertype;

	/**
	 * This property corresponds to db column <tt>BANDINDICATORFORFREQUENCY</tt>.
	 */
	private String bandindicatorforfrequency;

	/**
	 * This property corresponds to db column <tt>RAC</tt>.
	 */
	private String rac;

	/**
	 * This property corresponds to db column <tt>POWERDIVISIONTYPE</tt>.
	 */
	private String powerdivisiontype;

	/**
	 * This property corresponds to db column <tt>POWERDIVISIONINDEX</tt>.
	 */
	private String powerdivisionindex;

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

	/**
	 * This property corresponds to db column <tt>UPTIME_TIME</tt>.
	 */
	private Date uptimeTime;

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
	public long getCellId() {
		return cellId;
	}
	
	/**
	 * Setter method for property <tt>cellId</tt>.
	 * 
	 * @param cellId value to be assigned to property cellId
     */
	public void setCellId(long cellId) {
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
     * Getter method for property <tt>cgi</tt>.
     *
     * @return property value of cgi
     */
	public String getCgi() {
		return cgi;
	}
	
	/**
	 * Setter method for property <tt>cgi</tt>.
	 * 
	 * @param cgi value to be assigned to property cgi
     */
	public void setCgi(String cgi) {
		this.cgi = cgi;
	}

    /**
     * Getter method for property <tt>rruRemote</tt>.
     *
     * @return property value of rruRemote
     */
	public String getRruRemote() {
		return rruRemote;
	}
	
	/**
	 * Setter method for property <tt>rruRemote</tt>.
	 * 
	 * @param rruRemote value to be assigned to property rruRemote
     */
	public void setRruRemote(String rruRemote) {
		this.rruRemote = rruRemote;
	}

    /**
     * Getter method for property <tt>cellLongitude</tt>.
     *
     * @return property value of cellLongitude
     */
	public int getCellLongitude() {
		return cellLongitude;
	}
	
	/**
	 * Setter method for property <tt>cellLongitude</tt>.
	 * 
	 * @param cellLongitude value to be assigned to property cellLongitude
     */
	public void setCellLongitude(int cellLongitude) {
		this.cellLongitude = cellLongitude;
	}

    /**
     * Getter method for property <tt>cellLatitude</tt>.
     *
     * @return property value of cellLatitude
     */
	public int getCellLatitude() {
		return cellLatitude;
	}
	
	/**
	 * Setter method for property <tt>cellLatitude</tt>.
	 * 
	 * @param cellLatitude value to be assigned to property cellLatitude
     */
	public void setCellLatitude(int cellLatitude) {
		this.cellLatitude = cellLatitude;
	}

    /**
     * Getter method for property <tt>sectorId</tt>.
     *
     * @return property value of sectorId
     */
	public int getSectorId() {
		return sectorId;
	}
	
	/**
	 * Setter method for property <tt>sectorId</tt>.
	 * 
	 * @param sectorId value to be assigned to property sectorId
     */
	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}

    /**
     * Getter method for property <tt>pci</tt>.
     *
     * @return property value of pci
     */
	public int getPci() {
		return pci;
	}
	
	/**
	 * Setter method for property <tt>pci</tt>.
	 * 
	 * @param pci value to be assigned to property pci
     */
	public void setPci(int pci) {
		this.pci = pci;
	}

    /**
     * Getter method for property <tt>earfcn</tt>.
     *
     * @return property value of earfcn
     */
	public int getEarfcn() {
		return earfcn;
	}
	
	/**
	 * Setter method for property <tt>earfcn</tt>.
	 * 
	 * @param earfcn value to be assigned to property earfcn
     */
	public void setEarfcn(int earfcn) {
		this.earfcn = earfcn;
	}

    /**
     * Getter method for property <tt>rfPower</tt>.
     *
     * @return property value of rfPower
     */
	public int getRfPower() {
		return rfPower;
	}
	
	/**
	 * Setter method for property <tt>rfPower</tt>.
	 * 
	 * @param rfPower value to be assigned to property rfPower
     */
	public void setRfPower(int rfPower) {
		this.rfPower = rfPower;
	}

    /**
     * Getter method for property <tt>covertype</tt>.
     *
     * @return property value of covertype
     */
	public String getCovertype() {
		return covertype;
	}
	
	/**
	 * Setter method for property <tt>covertype</tt>.
	 * 
	 * @param covertype value to be assigned to property covertype
     */
	public void setCovertype(String covertype) {
		this.covertype = covertype;
	}

    /**
     * Getter method for property <tt>bandindicatorforfrequency</tt>.
     *
     * @return property value of bandindicatorforfrequency
     */
	public String getBandindicatorforfrequency() {
		return bandindicatorforfrequency;
	}
	
	/**
	 * Setter method for property <tt>bandindicatorforfrequency</tt>.
	 * 
	 * @param bandindicatorforfrequency value to be assigned to property bandindicatorforfrequency
     */
	public void setBandindicatorforfrequency(String bandindicatorforfrequency) {
		this.bandindicatorforfrequency = bandindicatorforfrequency;
	}

    /**
     * Getter method for property <tt>rac</tt>.
     *
     * @return property value of rac
     */
	public String getRac() {
		return rac;
	}
	
	/**
	 * Setter method for property <tt>rac</tt>.
	 * 
	 * @param rac value to be assigned to property rac
     */
	public void setRac(String rac) {
		this.rac = rac;
	}

    /**
     * Getter method for property <tt>powerdivisiontype</tt>.
     *
     * @return property value of powerdivisiontype
     */
	public String getPowerdivisiontype() {
		return powerdivisiontype;
	}
	
	/**
	 * Setter method for property <tt>powerdivisiontype</tt>.
	 * 
	 * @param powerdivisiontype value to be assigned to property powerdivisiontype
     */
	public void setPowerdivisiontype(String powerdivisiontype) {
		this.powerdivisiontype = powerdivisiontype;
	}

    /**
     * Getter method for property <tt>powerdivisionindex</tt>.
     *
     * @return property value of powerdivisionindex
     */
	public String getPowerdivisionindex() {
		return powerdivisionindex;
	}
	
	/**
	 * Setter method for property <tt>powerdivisionindex</tt>.
	 * 
	 * @param powerdivisionindex value to be assigned to property powerdivisionindex
     */
	public void setPowerdivisionindex(String powerdivisionindex) {
		this.powerdivisionindex = powerdivisionindex;
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
     * Getter method for property <tt>uptimeTime</tt>.
     *
     * @return property value of uptimeTime
     */
	public Date getUptimeTime() {
		return uptimeTime;
	}
	
	/**
	 * Setter method for property <tt>uptimeTime</tt>.
	 * 
	 * @param uptimeTime value to be assigned to property uptimeTime
     */
	public void setUptimeTime(Date uptimeTime) {
		this.uptimeTime = uptimeTime;
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
