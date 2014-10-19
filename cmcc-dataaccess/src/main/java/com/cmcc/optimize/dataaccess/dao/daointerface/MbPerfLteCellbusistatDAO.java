/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPerfLteCellbusistatDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_PERF_LTE_CELLBUSISTAT</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbPerfLteCellbusistatDAO {
	/**
	 *  Query DB table <tt>MB_PERF_LTE_CELLBUSISTAT</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select CELL_GLB_ID, CELL_ID, CELL_NAME, record_time, PERIOD, pusch_prbs_used, uplink_prbs, pdsch_prbs_used, downlink_prbs, pdcp_uplink_throu, pdcp_downlink_throu, oper_time from mb_perf_lte_cellbusistat where (CELL_GLB_ID = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return MbPerfLteCellbusistatDO
	 *	@throws DataAccessException
	 */	 
    public MbPerfLteCellbusistatDO getLTEperfbyId(String cellGlbId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbPerfLteCellbusistatDO</tt> object to DB table <tt>MB_PERF_LTE_CELLBUSISTAT</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_perf_lte_cellbusistat(CELLCELL_GLB_ID,CELL_ID,CELL_NAME,record_time,PERIOD,pusch_prbs_used,uplink_prbs,pdsch_prbs_used,downlink_prbs,pdcp_uplink_throu,pdcp_downlink_throu,oper_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)</tt>
	 *
	 *	@param mbPerfLteCellbusistat
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertLTEperf(MbPerfLteCellbusistatDO mbPerfLteCellbusistat) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_PERF_LTE_CELLBUSISTAT</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_perf_lte_cellbusistat set CELL_ID=?, CELL_NAME=?, record_time=?, PERIOD=?, pusch_prbs_used=?, uplink_prbs=?, pdsch_prbs_used=?, downlink_prbs=?, pdcp_uplink_throu=?, pdcp_downlink_throu=?, oper_time=sysdate where (CELL_GLB_ID = ?)</tt>
	 *
	 *	@param mbPerfLteCellbusistat
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLTEperf(MbPerfLteCellbusistatDO mbPerfLteCellbusistat) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_PERF_LTE_CELLBUSISTAT</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_perf_lte_cellbusistat where (CELL_GLB_ID = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLTEperfRecord(String cellGlbId) throws DataAccessException;

}