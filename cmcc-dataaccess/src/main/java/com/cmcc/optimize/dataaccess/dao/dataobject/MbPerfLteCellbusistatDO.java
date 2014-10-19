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
 * A data object class directly models database table <tt>MB_PERF_LTE_CELLBUSISTAT</tt>.
 *
 *
 * @author gaoqs
 */
public class MbPerfLteCellbusistatDO {
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
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

	/**
	 * This property corresponds to db column <tt>PERIOD</tt>.
	 */
	private String period;

	/**
	 * This property corresponds to db column <tt>PUSCH_PRBS_USED</tt>.
	 */
	private long puschPrbsUsed;

	/**
	 * This property corresponds to db column <tt>UPLINK_PRBS</tt>.
	 */
	private long uplinkPrbs;

	/**
	 * This property corresponds to db column <tt>PDSCH_PRBS_USED</tt>.
	 */
	private long pdschPrbsUsed;

	/**
	 * This property corresponds to db column <tt>DOWNLINK_PRBS</tt>.
	 */
	private long downlinkPrbs;

	/**
	 * This property corresponds to db column <tt>PDCP_UPLINK_THROU</tt>.
	 */
	private Float pdcpUplinkThrou;

	/**
	 * This property corresponds to db column <tt>PDCP_DOWNLINK_THROU</tt>.
	 */
	private Float pdcpDownlinkThrou;

	/**
	 * This property corresponds to db column <tt>OPER_TIME</tt>.
	 */
	private Date operTime;

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
     * Getter method for property <tt>puschPrbsUsed</tt>.
     *
     * @return property value of puschPrbsUsed
     */
	public long getPuschPrbsUsed() {
		return puschPrbsUsed;
	}
	
	/**
	 * Setter method for property <tt>puschPrbsUsed</tt>.
	 * 
	 * @param puschPrbsUsed value to be assigned to property puschPrbsUsed
     */
	public void setPuschPrbsUsed(long puschPrbsUsed) {
		this.puschPrbsUsed = puschPrbsUsed;
	}

    /**
     * Getter method for property <tt>uplinkPrbs</tt>.
     *
     * @return property value of uplinkPrbs
     */
	public long getUplinkPrbs() {
		return uplinkPrbs;
	}
	
	/**
	 * Setter method for property <tt>uplinkPrbs</tt>.
	 * 
	 * @param uplinkPrbs value to be assigned to property uplinkPrbs
     */
	public void setUplinkPrbs(long uplinkPrbs) {
		this.uplinkPrbs = uplinkPrbs;
	}

    /**
     * Getter method for property <tt>pdschPrbsUsed</tt>.
     *
     * @return property value of pdschPrbsUsed
     */
	public long getPdschPrbsUsed() {
		return pdschPrbsUsed;
	}
	
	/**
	 * Setter method for property <tt>pdschPrbsUsed</tt>.
	 * 
	 * @param pdschPrbsUsed value to be assigned to property pdschPrbsUsed
     */
	public void setPdschPrbsUsed(long pdschPrbsUsed) {
		this.pdschPrbsUsed = pdschPrbsUsed;
	}

    /**
     * Getter method for property <tt>downlinkPrbs</tt>.
     *
     * @return property value of downlinkPrbs
     */
	public long getDownlinkPrbs() {
		return downlinkPrbs;
	}
	
	/**
	 * Setter method for property <tt>downlinkPrbs</tt>.
	 * 
	 * @param downlinkPrbs value to be assigned to property downlinkPrbs
     */
	public void setDownlinkPrbs(long downlinkPrbs) {
		this.downlinkPrbs = downlinkPrbs;
	}

    /**
     * Getter method for property <tt>pdcpUplinkThrou</tt>.
     *
     * @return property value of pdcpUplinkThrou
     */
	public Float getPdcpUplinkThrou() {
		return pdcpUplinkThrou;
	}
	
	/**
	 * Setter method for property <tt>pdcpUplinkThrou</tt>.
	 * 
	 * @param pdcpUplinkThrou value to be assigned to property pdcpUplinkThrou
     */
	public void setPdcpUplinkThrou(Float pdcpUplinkThrou) {
		this.pdcpUplinkThrou = pdcpUplinkThrou;
	}

    /**
     * Getter method for property <tt>pdcpDownlinkThrou</tt>.
     *
     * @return property value of pdcpDownlinkThrou
     */
	public Float getPdcpDownlinkThrou() {
		return pdcpDownlinkThrou;
	}
	
	/**
	 * Setter method for property <tt>pdcpDownlinkThrou</tt>.
	 * 
	 * @param pdcpDownlinkThrou value to be assigned to property pdcpDownlinkThrou
     */
	public void setPdcpDownlinkThrou(Float pdcpDownlinkThrou) {
		this.pdcpDownlinkThrou = pdcpDownlinkThrou;
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
