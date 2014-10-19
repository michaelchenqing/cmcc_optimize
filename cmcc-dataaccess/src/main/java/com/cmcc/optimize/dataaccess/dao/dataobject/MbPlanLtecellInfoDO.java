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
 * A data object class directly models database table <tt>MB_PLAN_LTECELL_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public class MbPlanLtecellInfoDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

	/**
	 * This property corresponds to db column <tt>CELL_ID</tt>.
	 */
	private String cellId;

	/**
	 * This property corresponds to db column <tt>CITY</tt>.
	 */
	private String city;

	/**
	 * This property corresponds to db column <tt>CONTRY</tt>.
	 */
	private String contry;

	/**
	 * This property corresponds to db column <tt>MIN_DISTANCE</tt>.
	 */
	private Float minDistance;

	/**
	 * This property corresponds to db column <tt>PROJECTPHASE</tt>.
	 */
	private String projectphase;

	/**
	 * This property corresponds to db column <tt>COVER_TYPE</tt>.
	 */
	private String coverType;

	/**
	 * This property corresponds to db column <tt>HIGH</tt>.
	 */
	private Float high;

	/**
	 * This property corresponds to db column <tt>LONGITUDE</tt>.
	 */
	private Float longitude;

	/**
	 * This property corresponds to db column <tt>LATITUDE</tt>.
	 */
	private Float latitude;

	/**
	 * This property corresponds to db column <tt>ISCHECKTYPE</tt>.
	 */
	private String ischecktype;

	/**
	 * This property corresponds to db column <tt>NETGRNAME</tt>.
	 */
	private String netgrname;

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
     * Getter method for property <tt>contry</tt>.
     *
     * @return property value of contry
     */
	public String getContry() {
		return contry;
	}
	
	/**
	 * Setter method for property <tt>contry</tt>.
	 * 
	 * @param contry value to be assigned to property contry
     */
	public void setContry(String contry) {
		this.contry = contry;
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

    /**
     * Getter method for property <tt>projectphase</tt>.
     *
     * @return property value of projectphase
     */
	public String getProjectphase() {
		return projectphase;
	}
	
	/**
	 * Setter method for property <tt>projectphase</tt>.
	 * 
	 * @param projectphase value to be assigned to property projectphase
     */
	public void setProjectphase(String projectphase) {
		this.projectphase = projectphase;
	}

    /**
     * Getter method for property <tt>coverType</tt>.
     *
     * @return property value of coverType
     */
	public String getCoverType() {
		return coverType;
	}
	
	/**
	 * Setter method for property <tt>coverType</tt>.
	 * 
	 * @param coverType value to be assigned to property coverType
     */
	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}

    /**
     * Getter method for property <tt>high</tt>.
     *
     * @return property value of high
     */
	public Float getHigh() {
		return high;
	}
	
	/**
	 * Setter method for property <tt>high</tt>.
	 * 
	 * @param high value to be assigned to property high
     */
	public void setHigh(Float high) {
		this.high = high;
	}

    /**
     * Getter method for property <tt>longitude</tt>.
     *
     * @return property value of longitude
     */
	public Float getLongitude() {
		return longitude;
	}
	
	/**
	 * Setter method for property <tt>longitude</tt>.
	 * 
	 * @param longitude value to be assigned to property longitude
     */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

    /**
     * Getter method for property <tt>latitude</tt>.
     *
     * @return property value of latitude
     */
	public Float getLatitude() {
		return latitude;
	}
	
	/**
	 * Setter method for property <tt>latitude</tt>.
	 * 
	 * @param latitude value to be assigned to property latitude
     */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

    /**
     * Getter method for property <tt>ischecktype</tt>.
     *
     * @return property value of ischecktype
     */
	public String getIschecktype() {
		return ischecktype;
	}
	
	/**
	 * Setter method for property <tt>ischecktype</tt>.
	 * 
	 * @param ischecktype value to be assigned to property ischecktype
     */
	public void setIschecktype(String ischecktype) {
		this.ischecktype = ischecktype;
	}

    /**
     * Getter method for property <tt>netgrname</tt>.
     *
     * @return property value of netgrname
     */
	public String getNetgrname() {
		return netgrname;
	}
	
	/**
	 * Setter method for property <tt>netgrname</tt>.
	 * 
	 * @param netgrname value to be assigned to property netgrname
     */
	public void setNetgrname(String netgrname) {
		this.netgrname = netgrname;
	}
}
