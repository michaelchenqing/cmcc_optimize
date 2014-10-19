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
 * A data object class directly models database table <tt>MB_OMC_LO_LA</tt>.
 *
 *
 * @author gaoqs
 */
public class MbOmcLoLaDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>CITY</tt>.
	 */
	private String city;

	/**
	 * This property corresponds to db column <tt>ENODEB_ID</tt>.
	 */
	private String enodebId;

	/**
	 * This property corresponds to db column <tt>ENODEB_NAME</tt>.
	 */
	private String enodebName;

	/**
	 * This property corresponds to db column <tt>LONGITUDE</tt>.
	 */
	private Float longitude;

	/**
	 * This property corresponds to db column <tt>LATITUDE</tt>.
	 */
	private Float latitude;

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

    //========== getters and setters ==========

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
