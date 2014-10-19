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
 * A data object class directly models database table <tt>MB_PERF_GSM_BUSISTAT</tt>.
 *
 *
 * @author gaoqs
 */
public class MbPerfGsmBusistatDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>CELL_GLB_ID</tt>.
	 */
	private String cellGlbId;

	/**
	 * This property corresponds to db column <tt>CELL_ID</tt>.
	 */
	private long cellId;

	/**
	 * This property corresponds to db column <tt>CELL_NAME</tt>.
	 */
	private String cellName;

	/**
	 * This property corresponds to db column <tt>CYCLE_DATE</tt>.
	 */
	private Date cycleDate;

	/**
	 * This property corresponds to db column <tt>PERIOD</tt>.
	 */
	private String period;

	/**
	 * This property corresponds to db column <tt>TRAFFIC</tt>.
	 */
	private Float traffic;

	/**
	 * This property corresponds to db column <tt>GPRS_THROU</tt>.
	 */
	private Float gprsThrou;

	/**
	 * This property corresponds to db column <tt>EGPRS_THROU</tt>.
	 */
	private Float egprsThrou;

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
     * Getter method for property <tt>cycleDate</tt>.
     *
     * @return property value of cycleDate
     */
	public Date getCycleDate() {
		return cycleDate;
	}
	
	/**
	 * Setter method for property <tt>cycleDate</tt>.
	 * 
	 * @param cycleDate value to be assigned to property cycleDate
     */
	public void setCycleDate(Date cycleDate) {
		this.cycleDate = cycleDate;
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
     * Getter method for property <tt>gprsThrou</tt>.
     *
     * @return property value of gprsThrou
     */
	public Float getGprsThrou() {
		return gprsThrou;
	}
	
	/**
	 * Setter method for property <tt>gprsThrou</tt>.
	 * 
	 * @param gprsThrou value to be assigned to property gprsThrou
     */
	public void setGprsThrou(Float gprsThrou) {
		this.gprsThrou = gprsThrou;
	}

    /**
     * Getter method for property <tt>egprsThrou</tt>.
     *
     * @return property value of egprsThrou
     */
	public Float getEgprsThrou() {
		return egprsThrou;
	}
	
	/**
	 * Setter method for property <tt>egprsThrou</tt>.
	 * 
	 * @param egprsThrou value to be assigned to property egprsThrou
     */
	public void setEgprsThrou(Float egprsThrou) {
		this.egprsThrou = egprsThrou;
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
