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
 * A data object class directly models database table <tt>MB_SYS_LTECELL_GSMNBR</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysLtecellGsmnbrDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>CGI</tt>.
	 */
	private String cgi;

	/**
	 * This property corresponds to db column <tt>NAME</tt>.
	 */
	private String name;

	/**
	 * This property corresponds to db column <tt>OBJECT_RDN</tt>.
	 */
	private String objectRdn;

	/**
	 * This property corresponds to db column <tt>ZH_NAME</tt>.
	 */
	private String zhName;

	/**
	 * This property corresponds to db column <tt>OMC_ID</tt>.
	 */
	private String omcId;

	/**
	 * This property corresponds to db column <tt>CITY</tt>.
	 */
	private String city;

	/**
	 * This property corresponds to db column <tt>VENDOR_ID</tt>.
	 */
	private String vendorId;

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
	 * This property corresponds to db column <tt>TAC</tt>.
	 */
	private String tac;

	/**
	 * This property corresponds to db column <tt>PCI</tt>.
	 */
	private String pci;

	/**
	 * This property corresponds to db column <tt>EARFCN</tt>.
	 */
	private String earfcn;

	/**
	 * This property corresponds to db column <tt>ADJ_GSM_FRQLST</tt>.
	 */
	private String adjGsmFrqlst;

	/**
	 * This property corresponds to db column <tt>M_NAME</tt>.
	 */
	private String MName;

	/**
	 * This property corresponds to db column <tt>N_NAME</tt>.
	 */
	private String NName;

	/**
	 * This property corresponds to db column <tt>ID</tt>.
	 */
	private String id;

	/**
	 * This property corresponds to db column <tt>ADJACENTCELLID</tt>.
	 */
	private String adjacentcellid;

	/**
	 * This property corresponds to db column <tt>BCCH</tt>.
	 */
	private String bcch;

	/**
	 * This property corresponds to db column <tt>NCC</tt>.
	 */
	private String ncc;

	/**
	 * This property corresponds to db column <tt>BCC</tt>.
	 */
	private String bcc;

	/**
	 * This property corresponds to db column <tt>RAC</tt>.
	 */
	private String rac;

	/**
	 * This property corresponds to db column <tt>UPDATE_USER</tt>.
	 */
	private String updateUser;

	/**
	 * This property corresponds to db column <tt>DISTANCE</tt>.
	 */
	private Integer distance;

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

    //========== getters and setters ==========

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
	public String getOmcId() {
		return omcId;
	}
	
	/**
	 * Setter method for property <tt>omcId</tt>.
	 * 
	 * @param omcId value to be assigned to property omcId
     */
	public void setOmcId(String omcId) {
		this.omcId = omcId;
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
     * Getter method for property <tt>tac</tt>.
     *
     * @return property value of tac
     */
	public String getTac() {
		return tac;
	}
	
	/**
	 * Setter method for property <tt>tac</tt>.
	 * 
	 * @param tac value to be assigned to property tac
     */
	public void setTac(String tac) {
		this.tac = tac;
	}

    /**
     * Getter method for property <tt>pci</tt>.
     *
     * @return property value of pci
     */
	public String getPci() {
		return pci;
	}
	
	/**
	 * Setter method for property <tt>pci</tt>.
	 * 
	 * @param pci value to be assigned to property pci
     */
	public void setPci(String pci) {
		this.pci = pci;
	}

    /**
     * Getter method for property <tt>earfcn</tt>.
     *
     * @return property value of earfcn
     */
	public String getEarfcn() {
		return earfcn;
	}
	
	/**
	 * Setter method for property <tt>earfcn</tt>.
	 * 
	 * @param earfcn value to be assigned to property earfcn
     */
	public void setEarfcn(String earfcn) {
		this.earfcn = earfcn;
	}

    /**
     * Getter method for property <tt>adjGsmFrqlst</tt>.
     *
     * @return property value of adjGsmFrqlst
     */
	public String getAdjGsmFrqlst() {
		return adjGsmFrqlst;
	}
	
	/**
	 * Setter method for property <tt>adjGsmFrqlst</tt>.
	 * 
	 * @param adjGsmFrqlst value to be assigned to property adjGsmFrqlst
     */
	public void setAdjGsmFrqlst(String adjGsmFrqlst) {
		this.adjGsmFrqlst = adjGsmFrqlst;
	}

    /**
     * Getter method for property <tt>MName</tt>.
     *
     * @return property value of MName
     */
	public String getMName() {
		return MName;
	}
	
	/**
	 * Setter method for property <tt>MName</tt>.
	 * 
	 * @param MName value to be assigned to property MName
     */
	public void setMName(String MName) {
		this.MName = MName;
	}

    /**
     * Getter method for property <tt>NName</tt>.
     *
     * @return property value of NName
     */
	public String getNName() {
		return NName;
	}
	
	/**
	 * Setter method for property <tt>NName</tt>.
	 * 
	 * @param NName value to be assigned to property NName
     */
	public void setNName(String NName) {
		this.NName = NName;
	}

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
	public String getId() {
		return id;
	}
	
	/**
	 * Setter method for property <tt>id</tt>.
	 * 
	 * @param id value to be assigned to property id
     */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * Getter method for property <tt>adjacentcellid</tt>.
     *
     * @return property value of adjacentcellid
     */
	public String getAdjacentcellid() {
		return adjacentcellid;
	}
	
	/**
	 * Setter method for property <tt>adjacentcellid</tt>.
	 * 
	 * @param adjacentcellid value to be assigned to property adjacentcellid
     */
	public void setAdjacentcellid(String adjacentcellid) {
		this.adjacentcellid = adjacentcellid;
	}

    /**
     * Getter method for property <tt>bcch</tt>.
     *
     * @return property value of bcch
     */
	public String getBcch() {
		return bcch;
	}
	
	/**
	 * Setter method for property <tt>bcch</tt>.
	 * 
	 * @param bcch value to be assigned to property bcch
     */
	public void setBcch(String bcch) {
		this.bcch = bcch;
	}

    /**
     * Getter method for property <tt>ncc</tt>.
     *
     * @return property value of ncc
     */
	public String getNcc() {
		return ncc;
	}
	
	/**
	 * Setter method for property <tt>ncc</tt>.
	 * 
	 * @param ncc value to be assigned to property ncc
     */
	public void setNcc(String ncc) {
		this.ncc = ncc;
	}

    /**
     * Getter method for property <tt>bcc</tt>.
     *
     * @return property value of bcc
     */
	public String getBcc() {
		return bcc;
	}
	
	/**
	 * Setter method for property <tt>bcc</tt>.
	 * 
	 * @param bcc value to be assigned to property bcc
     */
	public void setBcc(String bcc) {
		this.bcc = bcc;
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
     * Getter method for property <tt>distance</tt>.
     *
     * @return property value of distance
     */
	public Integer getDistance() {
		return distance;
	}
	
	/**
	 * Setter method for property <tt>distance</tt>.
	 * 
	 * @param distance value to be assigned to property distance
     */
	public void setDistance(Integer distance) {
		this.distance = distance;
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
}
