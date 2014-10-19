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
 * A data object class directly models database table <tt>MB_PERF_TDS_BUSISTAT</tt>.
 *
 *
 * @author gaoqs
 */
public class MbPerfTdsBusistatDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>CELL_GLB_ID</tt>.
	 */
	private String cellGlbId;

	/**
	 * This property corresponds to db column <tt>CELL_ID</tt>.
	 */
	private String cellId;

	/**
	 * This property corresponds to db column <tt>CELL_NAME</tt>.
	 */
	private String cellName;

	/**
	 * This property corresponds to db column <tt>PERIOD</tt>.
	 */
	private String period;

	/**
	 * This property corresponds to db column <tt>TRAFFIC</tt>.
	 */
	private Float traffic;

	/**
	 * This property corresponds to db column <tt>HS_THROU</tt>.
	 */
	private Float hsThrou;

	/**
	 * This property corresponds to db column <tt>R9_THROU</tt>.
	 */
	private Float r9Throu;

	/**
	 * This property corresponds to db column <tt>OPER_TIME</tt>.
	 */
	private Date operTime;

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

	/**
	 * This property corresponds to db column <tt>CITY</tt>.
	 */
	private String city;

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
     * Getter method for property <tt>period</tt>.
     *
     * @return property value of period
     */
	public String getPeriod() {
		return period;
	}
	
	/**
	 * Setter method for property <tt>period</tt>.
	 * 
	 * @param period value to be assigned to property period
     */
	public void setPeriod(String period) {
		this.period = period;
	}

    /**
     * Getter method for property <tt>traffic</tt>.
     *
     * @return property value of traffic
     */
	public Float getTraffic() {
		return traffic;
	}
	
	/**
	 * Setter method for property <tt>traffic</tt>.
	 * 
	 * @param traffic value to be assigned to property traffic
     */
	public void setTraffic(Float traffic) {
		this.traffic = traffic;
	}

    /**
     * Getter method for property <tt>hsThrou</tt>.
     *
     * @return property value of hsThrou
     */
	public Float getHsThrou() {
		return hsThrou;
	}
	
	/**
	 * Setter method for property <tt>hsThrou</tt>.
	 * 
	 * @param hsThrou value to be assigned to property hsThrou
     */
	public void setHsThrou(Float hsThrou) {
		this.hsThrou = hsThrou;
	}

    /**
     * Getter method for property <tt>r9Throu</tt>.
     *
     * @return property value of r9Throu
     */
	public Float getR9Throu() {
		return r9Throu;
	}
	
	/**
	 * Setter method for property <tt>r9Throu</tt>.
	 * 
	 * @param r9Throu value to be assigned to property r9Throu
     */
	public void setR9Throu(Float r9Throu) {
		this.r9Throu = r9Throu;
	}

    /**
     * Getter method for property <tt>operTime</tt>.
     *
     * @return property value of operTime
     */
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * Setter method for property <tt>operTime</tt>.
	 * 
	 * @param operTime value to be assigned to property operTime
     */
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
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
}
