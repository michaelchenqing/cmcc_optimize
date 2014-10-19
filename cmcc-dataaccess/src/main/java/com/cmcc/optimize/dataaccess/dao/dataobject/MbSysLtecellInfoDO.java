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
 * A data object class directly models database table <tt>MB_SYS_LTECELL_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysLtecellInfoDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>CELL_GLB_ID</tt>.
	 */
	private String cellGlbId;

	/**
	 * This property corresponds to db column <tt>ENODEB_GLB_ID</tt>.
	 */
	private String enodebGlbId;

	/**
	 * This property corresponds to db column <tt>CELL_ID</tt>.
	 */
	private String cellId;

	/**
	 * This property corresponds to db column <tt>CELL_NAME</tt>.
	 */
	private String cellName;

	/**
	 * This property corresponds to db column <tt>CELL_ENGLISH_NAME</tt>.
	 */
	private String cellEnglishName;

	/**
	 * This property corresponds to db column <tt>CGI</tt>.
	 */
	private String cgi;

	/**
	 * This property corresponds to db column <tt>SECTOR_ID</tt>.
	 */
	private Integer sectorId;

	/**
	 * This property corresponds to db column <tt>PCI</tt>.
	 */
	private Integer pci;

	/**
	 * This property corresponds to db column <tt>EARFCN</tt>.
	 */
	private Integer earfcn;

	/**
	 * This property corresponds to db column <tt>RF_POWER</tt>.
	 */
	private Float rfPower;

	/**
	 * This property corresponds to db column <tt>SFASSIGN</tt>.
	 */
	private String sfassign;

	/**
	 * This property corresponds to db column <tt>SEPCSFPATTERN</tt>.
	 */
	private String sepcsfpattern;

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
	 * This property corresponds to db column <tt>MIN_DISTANCE</tt>.
	 */
	private Float minDistance;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>cellGlbId</tt>.
     *
     * @return property value of cellGlbId
     */
	public String getCellGlbId() {
		return cellGlbId;
	}
	
	/**
	 * Setter method for property <tt>cellGlbId</tt>.
	 * 
	 * @param cellGlbId value to be assigned to property cellGlbId
     */
	public void setCellGlbId(String cellGlbId) {
		this.cellGlbId = cellGlbId;
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
     * Getter method for property <tt>cellId</tt>.
     *
     * @return property value of cellId
     */
	public String getCellId() {
		return cellId;
	}
	
	/**
	 * Setter method for property <tt>cellId</tt>.
	 * 
	 * @param cellId value to be assigned to property cellId
     */
	public void setCellId(String cellId) {
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
     * Getter method for property <tt>cellEnglishName</tt>.
     *
     * @return property value of cellEnglishName
     */
	public String getCellEnglishName() {
		return cellEnglishName;
	}
	
	/**
	 * Setter method for property <tt>cellEnglishName</tt>.
	 * 
	 * @param cellEnglishName value to be assigned to property cellEnglishName
     */
	public void setCellEnglishName(String cellEnglishName) {
		this.cellEnglishName = cellEnglishName;
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
     * Getter method for property <tt>sectorId</tt>.
     *
     * @return property value of sectorId
     */
	public Integer getSectorId() {
		return sectorId;
	}
	
	/**
	 * Setter method for property <tt>sectorId</tt>.
	 * 
	 * @param sectorId value to be assigned to property sectorId
     */
	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}

    /**
     * Getter method for property <tt>pci</tt>.
     *
     * @return property value of pci
     */
	public Integer getPci() {
		return pci;
	}
	
	/**
	 * Setter method for property <tt>pci</tt>.
	 * 
	 * @param pci value to be assigned to property pci
     */
	public void setPci(Integer pci) {
		this.pci = pci;
	}

    /**
     * Getter method for property <tt>earfcn</tt>.
     *
     * @return property value of earfcn
     */
	public Integer getEarfcn() {
		return earfcn;
	}
	
	/**
	 * Setter method for property <tt>earfcn</tt>.
	 * 
	 * @param earfcn value to be assigned to property earfcn
     */
	public void setEarfcn(Integer earfcn) {
		this.earfcn = earfcn;
	}

    /**
     * Getter method for property <tt>rfPower</tt>.
     *
     * @return property value of rfPower
     */
	public Float getRfPower() {
		return rfPower;
	}
	
	/**
	 * Setter method for property <tt>rfPower</tt>.
	 * 
	 * @param rfPower value to be assigned to property rfPower
     */
	public void setRfPower(Float rfPower) {
		this.rfPower = rfPower;
	}

    /**
     * Getter method for property <tt>sfassign</tt>.
     *
     * @return property value of sfassign
     */
	public String getSfassign() {
		return sfassign;
	}
	
	/**
	 * Setter method for property <tt>sfassign</tt>.
	 * 
	 * @param sfassign value to be assigned to property sfassign
     */
	public void setSfassign(String sfassign) {
		this.sfassign = sfassign;
	}

    /**
     * Getter method for property <tt>sepcsfpattern</tt>.
     *
     * @return property value of sepcsfpattern
     */
	public String getSepcsfpattern() {
		return sepcsfpattern;
	}
	
	/**
	 * Setter method for property <tt>sepcsfpattern</tt>.
	 * 
	 * @param sepcsfpattern value to be assigned to property sepcsfpattern
     */
	public void setSepcsfpattern(String sepcsfpattern) {
		this.sepcsfpattern = sepcsfpattern;
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
     * Getter method for property <tt>minDistance</tt>.
     *
     * @return property value of minDistance
     */
	public Float getMinDistance() {
		return minDistance;
	}
	
	/**
	 * Setter method for property <tt>minDistance</tt>.
	 * 
	 * @param minDistance value to be assigned to property minDistance
     */
	public void setMinDistance(Float minDistance) {
		this.minDistance = minDistance;
	}
}
