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
 * A data object class directly models database table <tt>MB_TEST_SCANFREQ</tt>.
 *
 *
 * @author gaoqs
 */
public class MbTestScanfreqDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>TASK_ID</tt>.
	 */
	private String taskId;

	/**
	 * This property corresponds to db column <tt>CELL_GLB_ID</tt>.
	 */
	private int cellGlbId;

	/**
	 * This property corresponds to db column <tt>CELL_ID</tt>.
	 */
	private long cellId;

	/**
	 * This property corresponds to db column <tt>CELL_NAME</tt>.
	 */
	private String cellName;

	/**
	 * This property corresponds to db column <tt>PCI</tt>.
	 */
	private int pci;

	/**
	 * This property corresponds to db column <tt>EARFCN</tt>.
	 */
	private int earfcn;

	/**
	 * This property corresponds to db column <tt>RS_RP</tt>.
	 */
	private long rsRp;

	/**
	 * This property corresponds to db column <tt>RS_CINR_SINR</tt>.
	 */
	private long rsCinrSinr;

	/**
	 * This property corresponds to db column <tt>TEST_TIME</tt>.
	 */
	private Date testTime;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>taskId</tt>.
     *
     * @return property value of taskId
     */
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * Setter method for property <tt>taskId</tt>.
	 * 
	 * @param taskId value to be assigned to property taskId
     */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
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
     * Getter method for property <tt>rsRp</tt>.
     *
     * @return property value of rsRp
     */
	public long getRsRp() {
		return rsRp;
	}
	
	/**
	 * Setter method for property <tt>rsRp</tt>.
	 * 
	 * @param rsRp value to be assigned to property rsRp
     */
	public void setRsRp(long rsRp) {
		this.rsRp = rsRp;
	}

    /**
     * Getter method for property <tt>rsCinrSinr</tt>.
     *
     * @return property value of rsCinrSinr
     */
	public long getRsCinrSinr() {
		return rsCinrSinr;
	}
	
	/**
	 * Setter method for property <tt>rsCinrSinr</tt>.
	 * 
	 * @param rsCinrSinr value to be assigned to property rsCinrSinr
     */
	public void setRsCinrSinr(long rsCinrSinr) {
		this.rsCinrSinr = rsCinrSinr;
	}

    /**
     * Getter method for property <tt>testTime</tt>.
     *
     * @return property value of testTime
     */
	public Date getTestTime() {
		return testTime;
	}
	
	/**
	 * Setter method for property <tt>testTime</tt>.
	 * 
	 * @param testTime value to be assigned to property testTime
     */
	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}
}
