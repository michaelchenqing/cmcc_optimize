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
 * A data object class directly models database table <tt>MB_SYS_LTECELL_PARAM</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysLtecellParamDO {
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
	 * This property corresponds to db column <tt>OPERASTATE</tt>.
	 */
	private String operastate;

	/**
	 * This property corresponds to db column <tt>CSFB</tt>.
	 */
	private String csfb;

	/**
	 * This property corresponds to db column <tt>DRX</tt>.
	 */
	private String drx;

	/**
	 * This property corresponds to db column <tt>QCI6_DUR_LEN</tt>.
	 */
	private String qci6DurLen;

	/**
	 * This property corresponds to db column <tt>QCI7_DUR_LEN</tt>.
	 */
	private String qci7DurLen;

	/**
	 * This property corresponds to db column <tt>QCI8_DUR_LEN</tt>.
	 */
	private String qci8DurLen;

	/**
	 * This property corresponds to db column <tt>QCI9_DUR_LEN</tt>.
	 */
	private String qci9DurLen;

	/**
	 * This property corresponds to db column <tt>QCI6_CONT_TIMER</tt>.
	 */
	private String qci6ContTimer;

	/**
	 * This property corresponds to db column <tt>QCI7_CONT_TIMER</tt>.
	 */
	private String qci7ContTimer;

	/**
	 * This property corresponds to db column <tt>QCI8_CONT_TIMER</tt>.
	 */
	private String qci8ContTimer;

	/**
	 * This property corresponds to db column <tt>QCI9_CONT_TIMER</tt>.
	 */
	private String qci9ContTimer;

	/**
	 * This property corresponds to db column <tt>QCI6_NOTRIG_TIMER</tt>.
	 */
	private String qci6NotrigTimer;

	/**
	 * This property corresponds to db column <tt>QCI7_NOTRIG_TIMER</tt>.
	 */
	private String qci7NotrigTimer;

	/**
	 * This property corresponds to db column <tt>QCI8_NOTRIG_TIMER</tt>.
	 */
	private String qci8NotrigTimer;

	/**
	 * This property corresponds to db column <tt>QCI9_NOTRIG_TIMER</tt>.
	 */
	private String qci9NotrigTimer;

	/**
	 * This property corresponds to db column <tt>QCI6_WAITRESEND_TIMER</tt>.
	 */
	private String qci6WaitresendTimer;

	/**
	 * This property corresponds to db column <tt>QCI7_WAITRESEND_TIMER</tt>.
	 */
	private String qci7WaitresendTimer;

	/**
	 * This property corresponds to db column <tt>QCI8_WAITRESEND_TIMER</tt>.
	 */
	private String qci8WaitresendTimer;

	/**
	 * This property corresponds to db column <tt>QCI9_WAITRESEND_TIMER</tt>.
	 */
	private String qci9WaitresendTimer;

	/**
	 * This property corresponds to db column <tt>QCI6_SHORTDUR_LEN</tt>.
	 */
	private String qci6ShortdurLen;

	/**
	 * This property corresponds to db column <tt>QCI7_SHORTDUR_LEN</tt>.
	 */
	private String qci7ShortdurLen;

	/**
	 * This property corresponds to db column <tt>QCI8_SHORTDUR_LEN</tt>.
	 */
	private String qci8ShortdurLen;

	/**
	 * This property corresponds to db column <tt>QCI9_SHORTDUR_LEN</tt>.
	 */
	private String qci9ShortdurLen;

	/**
	 * This property corresponds to db column <tt>QCI6_SHORTDUR_TIMER</tt>.
	 */
	private Integer qci6ShortdurTimer;

	/**
	 * This property corresponds to db column <tt>QCI7_SHORTDUR_TIMER</tt>.
	 */
	private Integer qci7ShortdurTimer;

	/**
	 * This property corresponds to db column <tt>QCI8_SHORTDUR_TIMER</tt>.
	 */
	private Integer qci8ShortdurTimer;

	/**
	 * This property corresponds to db column <tt>QCI9_SHORTDUR_TIMER</tt>.
	 */
	private Integer qci9ShortdurTimer;

	/**
	 * This property corresponds to db column <tt>RRC_NOACT_TIMER</tt>.
	 */
	private Integer rrcNoactTimer;

	/**
	 * This property corresponds to db column <tt>DEF_PAGING_DUR</tt>.
	 */
	private String defPagingDur;

	/**
	 * This property corresponds to db column <tt>RF_SIG_POWER</tt>.
	 */
	private Integer rfSigPower;

	/**
	 * This property corresponds to db column <tt>PDSCH_RS_RATIO</tt>.
	 */
	private Integer pdschRsRatio;

	/**
	 * This property corresponds to db column <tt>PA</tt>.
	 */
	private String pa;

	/**
	 * This property corresponds to db column <tt>INIT_RECV_POWER</tt>.
	 */
	private String initRecvPower;

	/**
	 * This property corresponds to db column <tt>PREAMBLE_MAX_COUNT</tt>.
	 */
	private String preambleMaxCount;

	/**
	 * This property corresponds to db column <tt>POWER_INC_STEP</tt>.
	 */
	private String powerIncStep;

	/**
	 * This property corresponds to db column <tt>ACC_UE_MAX_POWER</tt>.
	 */
	private Integer accUeMaxPower;

	/**
	 * This property corresponds to db column <tt>UP_PUCCH_POWER_CTRL</tt>.
	 */
	private Integer upPucchPowerCtrl;

	/**
	 * This property corresponds to db column <tt>PUCCH_OPTIMAL_POWER</tt>.
	 */
	private Integer pucchOptimalPower;

	/**
	 * This property corresponds to db column <tt>UP_PUSCH_POWER_CTRL</tt>.
	 */
	private String upPuschPowerCtrl;

	/**
	 * This property corresponds to db column <tt>PATHLOSS_COMP_PARAM</tt>.
	 */
	private String pathlossCompParam;

	/**
	 * This property corresponds to db column <tt>INSTANT_OPTIMAL_POWER</tt>.
	 */
	private Integer instantOptimalPower;

	/**
	 * This property corresponds to db column <tt>ACC_MIN_LEVEL</tt>.
	 */
	private Integer accMinLevel;

	/**
	 * This property corresponds to db column <tt>COFREQ_MEAS_START_TH</tt>.
	 */
	private String cofreqMeasStartTh;

	/**
	 * This property corresponds to db column <tt>Q_OFFSETCELL</tt>.
	 */
	private String QOffsetcell;

	/**
	 * This property corresponds to db column <tt>Q_HYST</tt>.
	 */
	private String QHyst;

	/**
	 * This property corresponds to db column <tt>A3_OFFSET_HYST</tt>.
	 */
	private String a3OffsetHyst;

	/**
	 * This property corresponds to db column <tt>A3_HYST</tt>.
	 */
	private String a3Hyst;

	/**
	 * This property corresponds to db column <tt>A3_TIME_TRIG</tt>.
	 */
	private String a3TimeTrig;

	/**
	 * This property corresponds to db column <tt>IF_A2_TH</tt>.
	 */
	private String ifA2Th;

	/**
	 * This property corresponds to db column <tt>IRAT_A2_TDS_TH</tt>.
	 */
	private String iratA2TdsTh;

	/**
	 * This property corresponds to db column <tt>IRAT_A2_GSM_TH</tt>.
	 */
	private String iratA2GsmTh;

	/**
	 * This property corresponds to db column <tt>IRAT_A2_ERRDEF_TH</tt>.
	 */
	private String iratA2ErrdefTh;

	/**
	 * This property corresponds to db column <tt>UPDATE_TIME</tt>.
	 */
	private Date updateTime;

	/**
	 * This property corresponds to db column <tt>UPDATE_USER</tt>.
	 */
	private String updateUser;

	/**
	 * This property corresponds to db column <tt>ENODEB_NAME</tt>.
	 */
	private String enodebName;

	/**
	 * This property corresponds to db column <tt>ENODEB_ID</tt>.
	 */
	private String enodebId;

	/**
	 * This property corresponds to db column <tt>ENODEB_GLB_ID</tt>.
	 */
	private String enodebGlbId;

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

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
     * Getter method for property <tt>csfb</tt>.
     *
     * @return property value of csfb
     */
	public String getCsfb() {
		return csfb;
	}
	
	/**
	 * Setter method for property <tt>csfb</tt>.
	 * 
	 * @param csfb value to be assigned to property csfb
     */
	public void setCsfb(String csfb) {
		this.csfb = csfb;
	}

    /**
     * Getter method for property <tt>drx</tt>.
     *
     * @return property value of drx
     */
	public String getDrx() {
		return drx;
	}
	
	/**
	 * Setter method for property <tt>drx</tt>.
	 * 
	 * @param drx value to be assigned to property drx
     */
	public void setDrx(String drx) {
		this.drx = drx;
	}

    /**
     * Getter method for property <tt>qci6DurLen</tt>.
     *
     * @return property value of qci6DurLen
     */
	public String getQci6DurLen() {
		return qci6DurLen;
	}
	
	/**
	 * Setter method for property <tt>qci6DurLen</tt>.
	 * 
	 * @param qci6DurLen value to be assigned to property qci6DurLen
     */
	public void setQci6DurLen(String qci6DurLen) {
		this.qci6DurLen = qci6DurLen;
	}

    /**
     * Getter method for property <tt>qci7DurLen</tt>.
     *
     * @return property value of qci7DurLen
     */
	public String getQci7DurLen() {
		return qci7DurLen;
	}
	
	/**
	 * Setter method for property <tt>qci7DurLen</tt>.
	 * 
	 * @param qci7DurLen value to be assigned to property qci7DurLen
     */
	public void setQci7DurLen(String qci7DurLen) {
		this.qci7DurLen = qci7DurLen;
	}

    /**
     * Getter method for property <tt>qci8DurLen</tt>.
     *
     * @return property value of qci8DurLen
     */
	public String getQci8DurLen() {
		return qci8DurLen;
	}
	
	/**
	 * Setter method for property <tt>qci8DurLen</tt>.
	 * 
	 * @param qci8DurLen value to be assigned to property qci8DurLen
     */
	public void setQci8DurLen(String qci8DurLen) {
		this.qci8DurLen = qci8DurLen;
	}

    /**
     * Getter method for property <tt>qci9DurLen</tt>.
     *
     * @return property value of qci9DurLen
     */
	public String getQci9DurLen() {
		return qci9DurLen;
	}
	
	/**
	 * Setter method for property <tt>qci9DurLen</tt>.
	 * 
	 * @param qci9DurLen value to be assigned to property qci9DurLen
     */
	public void setQci9DurLen(String qci9DurLen) {
		this.qci9DurLen = qci9DurLen;
	}

    /**
     * Getter method for property <tt>qci6ContTimer</tt>.
     *
     * @return property value of qci6ContTimer
     */
	public String getQci6ContTimer() {
		return qci6ContTimer;
	}
	
	/**
	 * Setter method for property <tt>qci6ContTimer</tt>.
	 * 
	 * @param qci6ContTimer value to be assigned to property qci6ContTimer
     */
	public void setQci6ContTimer(String qci6ContTimer) {
		this.qci6ContTimer = qci6ContTimer;
	}

    /**
     * Getter method for property <tt>qci7ContTimer</tt>.
     *
     * @return property value of qci7ContTimer
     */
	public String getQci7ContTimer() {
		return qci7ContTimer;
	}
	
	/**
	 * Setter method for property <tt>qci7ContTimer</tt>.
	 * 
	 * @param qci7ContTimer value to be assigned to property qci7ContTimer
     */
	public void setQci7ContTimer(String qci7ContTimer) {
		this.qci7ContTimer = qci7ContTimer;
	}

    /**
     * Getter method for property <tt>qci8ContTimer</tt>.
     *
     * @return property value of qci8ContTimer
     */
	public String getQci8ContTimer() {
		return qci8ContTimer;
	}
	
	/**
	 * Setter method for property <tt>qci8ContTimer</tt>.
	 * 
	 * @param qci8ContTimer value to be assigned to property qci8ContTimer
     */
	public void setQci8ContTimer(String qci8ContTimer) {
		this.qci8ContTimer = qci8ContTimer;
	}

    /**
     * Getter method for property <tt>qci9ContTimer</tt>.
     *
     * @return property value of qci9ContTimer
     */
	public String getQci9ContTimer() {
		return qci9ContTimer;
	}
	
	/**
	 * Setter method for property <tt>qci9ContTimer</tt>.
	 * 
	 * @param qci9ContTimer value to be assigned to property qci9ContTimer
     */
	public void setQci9ContTimer(String qci9ContTimer) {
		this.qci9ContTimer = qci9ContTimer;
	}

    /**
     * Getter method for property <tt>qci6NotrigTimer</tt>.
     *
     * @return property value of qci6NotrigTimer
     */
	public String getQci6NotrigTimer() {
		return qci6NotrigTimer;
	}
	
	/**
	 * Setter method for property <tt>qci6NotrigTimer</tt>.
	 * 
	 * @param qci6NotrigTimer value to be assigned to property qci6NotrigTimer
     */
	public void setQci6NotrigTimer(String qci6NotrigTimer) {
		this.qci6NotrigTimer = qci6NotrigTimer;
	}

    /**
     * Getter method for property <tt>qci7NotrigTimer</tt>.
     *
     * @return property value of qci7NotrigTimer
     */
	public String getQci7NotrigTimer() {
		return qci7NotrigTimer;
	}
	
	/**
	 * Setter method for property <tt>qci7NotrigTimer</tt>.
	 * 
	 * @param qci7NotrigTimer value to be assigned to property qci7NotrigTimer
     */
	public void setQci7NotrigTimer(String qci7NotrigTimer) {
		this.qci7NotrigTimer = qci7NotrigTimer;
	}

    /**
     * Getter method for property <tt>qci8NotrigTimer</tt>.
     *
     * @return property value of qci8NotrigTimer
     */
	public String getQci8NotrigTimer() {
		return qci8NotrigTimer;
	}
	
	/**
	 * Setter method for property <tt>qci8NotrigTimer</tt>.
	 * 
	 * @param qci8NotrigTimer value to be assigned to property qci8NotrigTimer
     */
	public void setQci8NotrigTimer(String qci8NotrigTimer) {
		this.qci8NotrigTimer = qci8NotrigTimer;
	}

    /**
     * Getter method for property <tt>qci9NotrigTimer</tt>.
     *
     * @return property value of qci9NotrigTimer
     */
	public String getQci9NotrigTimer() {
		return qci9NotrigTimer;
	}
	
	/**
	 * Setter method for property <tt>qci9NotrigTimer</tt>.
	 * 
	 * @param qci9NotrigTimer value to be assigned to property qci9NotrigTimer
     */
	public void setQci9NotrigTimer(String qci9NotrigTimer) {
		this.qci9NotrigTimer = qci9NotrigTimer;
	}

    /**
     * Getter method for property <tt>qci6WaitresendTimer</tt>.
     *
     * @return property value of qci6WaitresendTimer
     */
	public String getQci6WaitresendTimer() {
		return qci6WaitresendTimer;
	}
	
	/**
	 * Setter method for property <tt>qci6WaitresendTimer</tt>.
	 * 
	 * @param qci6WaitresendTimer value to be assigned to property qci6WaitresendTimer
     */
	public void setQci6WaitresendTimer(String qci6WaitresendTimer) {
		this.qci6WaitresendTimer = qci6WaitresendTimer;
	}

    /**
     * Getter method for property <tt>qci7WaitresendTimer</tt>.
     *
     * @return property value of qci7WaitresendTimer
     */
	public String getQci7WaitresendTimer() {
		return qci7WaitresendTimer;
	}
	
	/**
	 * Setter method for property <tt>qci7WaitresendTimer</tt>.
	 * 
	 * @param qci7WaitresendTimer value to be assigned to property qci7WaitresendTimer
     */
	public void setQci7WaitresendTimer(String qci7WaitresendTimer) {
		this.qci7WaitresendTimer = qci7WaitresendTimer;
	}

    /**
     * Getter method for property <tt>qci8WaitresendTimer</tt>.
     *
     * @return property value of qci8WaitresendTimer
     */
	public String getQci8WaitresendTimer() {
		return qci8WaitresendTimer;
	}
	
	/**
	 * Setter method for property <tt>qci8WaitresendTimer</tt>.
	 * 
	 * @param qci8WaitresendTimer value to be assigned to property qci8WaitresendTimer
     */
	public void setQci8WaitresendTimer(String qci8WaitresendTimer) {
		this.qci8WaitresendTimer = qci8WaitresendTimer;
	}

    /**
     * Getter method for property <tt>qci9WaitresendTimer</tt>.
     *
     * @return property value of qci9WaitresendTimer
     */
	public String getQci9WaitresendTimer() {
		return qci9WaitresendTimer;
	}
	
	/**
	 * Setter method for property <tt>qci9WaitresendTimer</tt>.
	 * 
	 * @param qci9WaitresendTimer value to be assigned to property qci9WaitresendTimer
     */
	public void setQci9WaitresendTimer(String qci9WaitresendTimer) {
		this.qci9WaitresendTimer = qci9WaitresendTimer;
	}

    /**
     * Getter method for property <tt>qci6ShortdurLen</tt>.
     *
     * @return property value of qci6ShortdurLen
     */
	public String getQci6ShortdurLen() {
		return qci6ShortdurLen;
	}
	
	/**
	 * Setter method for property <tt>qci6ShortdurLen</tt>.
	 * 
	 * @param qci6ShortdurLen value to be assigned to property qci6ShortdurLen
     */
	public void setQci6ShortdurLen(String qci6ShortdurLen) {
		this.qci6ShortdurLen = qci6ShortdurLen;
	}

    /**
     * Getter method for property <tt>qci7ShortdurLen</tt>.
     *
     * @return property value of qci7ShortdurLen
     */
	public String getQci7ShortdurLen() {
		return qci7ShortdurLen;
	}
	
	/**
	 * Setter method for property <tt>qci7ShortdurLen</tt>.
	 * 
	 * @param qci7ShortdurLen value to be assigned to property qci7ShortdurLen
     */
	public void setQci7ShortdurLen(String qci7ShortdurLen) {
		this.qci7ShortdurLen = qci7ShortdurLen;
	}

    /**
     * Getter method for property <tt>qci8ShortdurLen</tt>.
     *
     * @return property value of qci8ShortdurLen
     */
	public String getQci8ShortdurLen() {
		return qci8ShortdurLen;
	}
	
	/**
	 * Setter method for property <tt>qci8ShortdurLen</tt>.
	 * 
	 * @param qci8ShortdurLen value to be assigned to property qci8ShortdurLen
     */
	public void setQci8ShortdurLen(String qci8ShortdurLen) {
		this.qci8ShortdurLen = qci8ShortdurLen;
	}

    /**
     * Getter method for property <tt>qci9ShortdurLen</tt>.
     *
     * @return property value of qci9ShortdurLen
     */
	public String getQci9ShortdurLen() {
		return qci9ShortdurLen;
	}
	
	/**
	 * Setter method for property <tt>qci9ShortdurLen</tt>.
	 * 
	 * @param qci9ShortdurLen value to be assigned to property qci9ShortdurLen
     */
	public void setQci9ShortdurLen(String qci9ShortdurLen) {
		this.qci9ShortdurLen = qci9ShortdurLen;
	}

    /**
     * Getter method for property <tt>qci6ShortdurTimer</tt>.
     *
     * @return property value of qci6ShortdurTimer
     */
	public Integer getQci6ShortdurTimer() {
		return qci6ShortdurTimer;
	}
	
	/**
	 * Setter method for property <tt>qci6ShortdurTimer</tt>.
	 * 
	 * @param qci6ShortdurTimer value to be assigned to property qci6ShortdurTimer
     */
	public void setQci6ShortdurTimer(Integer qci6ShortdurTimer) {
		this.qci6ShortdurTimer = qci6ShortdurTimer;
	}

    /**
     * Getter method for property <tt>qci7ShortdurTimer</tt>.
     *
     * @return property value of qci7ShortdurTimer
     */
	public Integer getQci7ShortdurTimer() {
		return qci7ShortdurTimer;
	}
	
	/**
	 * Setter method for property <tt>qci7ShortdurTimer</tt>.
	 * 
	 * @param qci7ShortdurTimer value to be assigned to property qci7ShortdurTimer
     */
	public void setQci7ShortdurTimer(Integer qci7ShortdurTimer) {
		this.qci7ShortdurTimer = qci7ShortdurTimer;
	}

    /**
     * Getter method for property <tt>qci8ShortdurTimer</tt>.
     *
     * @return property value of qci8ShortdurTimer
     */
	public Integer getQci8ShortdurTimer() {
		return qci8ShortdurTimer;
	}
	
	/**
	 * Setter method for property <tt>qci8ShortdurTimer</tt>.
	 * 
	 * @param qci8ShortdurTimer value to be assigned to property qci8ShortdurTimer
     */
	public void setQci8ShortdurTimer(Integer qci8ShortdurTimer) {
		this.qci8ShortdurTimer = qci8ShortdurTimer;
	}

    /**
     * Getter method for property <tt>qci9ShortdurTimer</tt>.
     *
     * @return property value of qci9ShortdurTimer
     */
	public Integer getQci9ShortdurTimer() {
		return qci9ShortdurTimer;
	}
	
	/**
	 * Setter method for property <tt>qci9ShortdurTimer</tt>.
	 * 
	 * @param qci9ShortdurTimer value to be assigned to property qci9ShortdurTimer
     */
	public void setQci9ShortdurTimer(Integer qci9ShortdurTimer) {
		this.qci9ShortdurTimer = qci9ShortdurTimer;
	}

    /**
     * Getter method for property <tt>rrcNoactTimer</tt>.
     *
     * @return property value of rrcNoactTimer
     */
	public Integer getRrcNoactTimer() {
		return rrcNoactTimer;
	}
	
	/**
	 * Setter method for property <tt>rrcNoactTimer</tt>.
	 * 
	 * @param rrcNoactTimer value to be assigned to property rrcNoactTimer
     */
	public void setRrcNoactTimer(Integer rrcNoactTimer) {
		this.rrcNoactTimer = rrcNoactTimer;
	}

    /**
     * Getter method for property <tt>defPagingDur</tt>.
     *
     * @return property value of defPagingDur
     */
	public String getDefPagingDur() {
		return defPagingDur;
	}
	
	/**
	 * Setter method for property <tt>defPagingDur</tt>.
	 * 
	 * @param defPagingDur value to be assigned to property defPagingDur
     */
	public void setDefPagingDur(String defPagingDur) {
		this.defPagingDur = defPagingDur;
	}

    /**
     * Getter method for property <tt>rfSigPower</tt>.
     *
     * @return property value of rfSigPower
     */
	public Integer getRfSigPower() {
		return rfSigPower;
	}
	
	/**
	 * Setter method for property <tt>rfSigPower</tt>.
	 * 
	 * @param rfSigPower value to be assigned to property rfSigPower
     */
	public void setRfSigPower(Integer rfSigPower) {
		this.rfSigPower = rfSigPower;
	}

    /**
     * Getter method for property <tt>pdschRsRatio</tt>.
     *
     * @return property value of pdschRsRatio
     */
	public Integer getPdschRsRatio() {
		return pdschRsRatio;
	}
	
	/**
	 * Setter method for property <tt>pdschRsRatio</tt>.
	 * 
	 * @param pdschRsRatio value to be assigned to property pdschRsRatio
     */
	public void setPdschRsRatio(Integer pdschRsRatio) {
		this.pdschRsRatio = pdschRsRatio;
	}

    /**
     * Getter method for property <tt>pa</tt>.
     *
     * @return property value of pa
     */
	public String getPa() {
		return pa;
	}
	
	/**
	 * Setter method for property <tt>pa</tt>.
	 * 
	 * @param pa value to be assigned to property pa
     */
	public void setPa(String pa) {
		this.pa = pa;
	}

    /**
     * Getter method for property <tt>initRecvPower</tt>.
     *
     * @return property value of initRecvPower
     */
	public String getInitRecvPower() {
		return initRecvPower;
	}
	
	/**
	 * Setter method for property <tt>initRecvPower</tt>.
	 * 
	 * @param initRecvPower value to be assigned to property initRecvPower
     */
	public void setInitRecvPower(String initRecvPower) {
		this.initRecvPower = initRecvPower;
	}

    /**
     * Getter method for property <tt>preambleMaxCount</tt>.
     *
     * @return property value of preambleMaxCount
     */
	public String getPreambleMaxCount() {
		return preambleMaxCount;
	}
	
	/**
	 * Setter method for property <tt>preambleMaxCount</tt>.
	 * 
	 * @param preambleMaxCount value to be assigned to property preambleMaxCount
     */
	public void setPreambleMaxCount(String preambleMaxCount) {
		this.preambleMaxCount = preambleMaxCount;
	}

    /**
     * Getter method for property <tt>powerIncStep</tt>.
     *
     * @return property value of powerIncStep
     */
	public String getPowerIncStep() {
		return powerIncStep;
	}
	
	/**
	 * Setter method for property <tt>powerIncStep</tt>.
	 * 
	 * @param powerIncStep value to be assigned to property powerIncStep
     */
	public void setPowerIncStep(String powerIncStep) {
		this.powerIncStep = powerIncStep;
	}

    /**
     * Getter method for property <tt>accUeMaxPower</tt>.
     *
     * @return property value of accUeMaxPower
     */
	public Integer getAccUeMaxPower() {
		return accUeMaxPower;
	}
	
	/**
	 * Setter method for property <tt>accUeMaxPower</tt>.
	 * 
	 * @param accUeMaxPower value to be assigned to property accUeMaxPower
     */
	public void setAccUeMaxPower(Integer accUeMaxPower) {
		this.accUeMaxPower = accUeMaxPower;
	}

    /**
     * Getter method for property <tt>upPucchPowerCtrl</tt>.
     *
     * @return property value of upPucchPowerCtrl
     */
	public Integer getUpPucchPowerCtrl() {
		return upPucchPowerCtrl;
	}
	
	/**
	 * Setter method for property <tt>upPucchPowerCtrl</tt>.
	 * 
	 * @param upPucchPowerCtrl value to be assigned to property upPucchPowerCtrl
     */
	public void setUpPucchPowerCtrl(Integer upPucchPowerCtrl) {
		this.upPucchPowerCtrl = upPucchPowerCtrl;
	}

    /**
     * Getter method for property <tt>pucchOptimalPower</tt>.
     *
     * @return property value of pucchOptimalPower
     */
	public Integer getPucchOptimalPower() {
		return pucchOptimalPower;
	}
	
	/**
	 * Setter method for property <tt>pucchOptimalPower</tt>.
	 * 
	 * @param pucchOptimalPower value to be assigned to property pucchOptimalPower
     */
	public void setPucchOptimalPower(Integer pucchOptimalPower) {
		this.pucchOptimalPower = pucchOptimalPower;
	}

    /**
     * Getter method for property <tt>upPuschPowerCtrl</tt>.
     *
     * @return property value of upPuschPowerCtrl
     */
	public String getUpPuschPowerCtrl() {
		return upPuschPowerCtrl;
	}
	
	/**
	 * Setter method for property <tt>upPuschPowerCtrl</tt>.
	 * 
	 * @param upPuschPowerCtrl value to be assigned to property upPuschPowerCtrl
     */
	public void setUpPuschPowerCtrl(String upPuschPowerCtrl) {
		this.upPuschPowerCtrl = upPuschPowerCtrl;
	}

    /**
     * Getter method for property <tt>pathlossCompParam</tt>.
     *
     * @return property value of pathlossCompParam
     */
	public String getPathlossCompParam() {
		return pathlossCompParam;
	}
	
	/**
	 * Setter method for property <tt>pathlossCompParam</tt>.
	 * 
	 * @param pathlossCompParam value to be assigned to property pathlossCompParam
     */
	public void setPathlossCompParam(String pathlossCompParam) {
		this.pathlossCompParam = pathlossCompParam;
	}

    /**
     * Getter method for property <tt>instantOptimalPower</tt>.
     *
     * @return property value of instantOptimalPower
     */
	public Integer getInstantOptimalPower() {
		return instantOptimalPower;
	}
	
	/**
	 * Setter method for property <tt>instantOptimalPower</tt>.
	 * 
	 * @param instantOptimalPower value to be assigned to property instantOptimalPower
     */
	public void setInstantOptimalPower(Integer instantOptimalPower) {
		this.instantOptimalPower = instantOptimalPower;
	}

    /**
     * Getter method for property <tt>accMinLevel</tt>.
     *
     * @return property value of accMinLevel
     */
	public Integer getAccMinLevel() {
		return accMinLevel;
	}
	
	/**
	 * Setter method for property <tt>accMinLevel</tt>.
	 * 
	 * @param accMinLevel value to be assigned to property accMinLevel
     */
	public void setAccMinLevel(Integer accMinLevel) {
		this.accMinLevel = accMinLevel;
	}

    /**
     * Getter method for property <tt>cofreqMeasStartTh</tt>.
     *
     * @return property value of cofreqMeasStartTh
     */
	public String getCofreqMeasStartTh() {
		return cofreqMeasStartTh;
	}
	
	/**
	 * Setter method for property <tt>cofreqMeasStartTh</tt>.
	 * 
	 * @param cofreqMeasStartTh value to be assigned to property cofreqMeasStartTh
     */
	public void setCofreqMeasStartTh(String cofreqMeasStartTh) {
		this.cofreqMeasStartTh = cofreqMeasStartTh;
	}

    /**
     * Getter method for property <tt>QOffsetcell</tt>.
     *
     * @return property value of QOffsetcell
     */
	public String getQOffsetcell() {
		return QOffsetcell;
	}
	
	/**
	 * Setter method for property <tt>QOffsetcell</tt>.
	 * 
	 * @param QOffsetcell value to be assigned to property QOffsetcell
     */
	public void setQOffsetcell(String QOffsetcell) {
		this.QOffsetcell = QOffsetcell;
	}

    /**
     * Getter method for property <tt>QHyst</tt>.
     *
     * @return property value of QHyst
     */
	public String getQHyst() {
		return QHyst;
	}
	
	/**
	 * Setter method for property <tt>QHyst</tt>.
	 * 
	 * @param QHyst value to be assigned to property QHyst
     */
	public void setQHyst(String QHyst) {
		this.QHyst = QHyst;
	}

    /**
     * Getter method for property <tt>a3OffsetHyst</tt>.
     *
     * @return property value of a3OffsetHyst
     */
	public String getA3OffsetHyst() {
		return a3OffsetHyst;
	}
	
	/**
	 * Setter method for property <tt>a3OffsetHyst</tt>.
	 * 
	 * @param a3OffsetHyst value to be assigned to property a3OffsetHyst
     */
	public void setA3OffsetHyst(String a3OffsetHyst) {
		this.a3OffsetHyst = a3OffsetHyst;
	}

    /**
     * Getter method for property <tt>a3Hyst</tt>.
     *
     * @return property value of a3Hyst
     */
	public String getA3Hyst() {
		return a3Hyst;
	}
	
	/**
	 * Setter method for property <tt>a3Hyst</tt>.
	 * 
	 * @param a3Hyst value to be assigned to property a3Hyst
     */
	public void setA3Hyst(String a3Hyst) {
		this.a3Hyst = a3Hyst;
	}

    /**
     * Getter method for property <tt>a3TimeTrig</tt>.
     *
     * @return property value of a3TimeTrig
     */
	public String getA3TimeTrig() {
		return a3TimeTrig;
	}
	
	/**
	 * Setter method for property <tt>a3TimeTrig</tt>.
	 * 
	 * @param a3TimeTrig value to be assigned to property a3TimeTrig
     */
	public void setA3TimeTrig(String a3TimeTrig) {
		this.a3TimeTrig = a3TimeTrig;
	}

    /**
     * Getter method for property <tt>ifA2Th</tt>.
     *
     * @return property value of ifA2Th
     */
	public String getIfA2Th() {
		return ifA2Th;
	}
	
	/**
	 * Setter method for property <tt>ifA2Th</tt>.
	 * 
	 * @param ifA2Th value to be assigned to property ifA2Th
     */
	public void setIfA2Th(String ifA2Th) {
		this.ifA2Th = ifA2Th;
	}

    /**
     * Getter method for property <tt>iratA2TdsTh</tt>.
     *
     * @return property value of iratA2TdsTh
     */
	public String getIratA2TdsTh() {
		return iratA2TdsTh;
	}
	
	/**
	 * Setter method for property <tt>iratA2TdsTh</tt>.
	 * 
	 * @param iratA2TdsTh value to be assigned to property iratA2TdsTh
     */
	public void setIratA2TdsTh(String iratA2TdsTh) {
		this.iratA2TdsTh = iratA2TdsTh;
	}

    /**
     * Getter method for property <tt>iratA2GsmTh</tt>.
     *
     * @return property value of iratA2GsmTh
     */
	public String getIratA2GsmTh() {
		return iratA2GsmTh;
	}
	
	/**
	 * Setter method for property <tt>iratA2GsmTh</tt>.
	 * 
	 * @param iratA2GsmTh value to be assigned to property iratA2GsmTh
     */
	public void setIratA2GsmTh(String iratA2GsmTh) {
		this.iratA2GsmTh = iratA2GsmTh;
	}

    /**
     * Getter method for property <tt>iratA2ErrdefTh</tt>.
     *
     * @return property value of iratA2ErrdefTh
     */
	public String getIratA2ErrdefTh() {
		return iratA2ErrdefTh;
	}
	
	/**
	 * Setter method for property <tt>iratA2ErrdefTh</tt>.
	 * 
	 * @param iratA2ErrdefTh value to be assigned to property iratA2ErrdefTh
     */
	public void setIratA2ErrdefTh(String iratA2ErrdefTh) {
		this.iratA2ErrdefTh = iratA2ErrdefTh;
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
