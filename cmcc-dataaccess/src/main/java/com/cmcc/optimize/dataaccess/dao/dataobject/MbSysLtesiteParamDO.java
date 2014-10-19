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
 * A data object class directly models database table <tt>MB_SYS_LTESITE_PARAM</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysLtesiteParamDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>ENODEB_GLB_ID</tt>.
	 */
	private String enodebGlbId;

	/**
	 * This property corresponds to db column <tt>ENODEB_ID</tt>.
	 */
	private String enodebId;

	/**
	 * This property corresponds to db column <tt>ENODEB_NAME</tt>.
	 */
	private String enodebName;

	/**
	 * This property corresponds to db column <tt>OPERASTATE</tt>.
	 */
	private String operastate;

	/**
	 * This property corresponds to db column <tt>UPDATE_TIME</tt>.
	 */
	private Date updateTime;

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

    //========== getters and setters ==========

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
     * Getter method for property <tt>operastate</tt>.
     *
     * @return property value of operastate
     */
	public String getOperastate() {
		return operastate;
	}
	
	/**
	 * Setter method for property <tt>operastate</tt>.
	 * 
	 * @param operastate value to be assigned to property operastate
     */
	public void setOperastate(String operastate) {
		this.operastate = operastate;
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
