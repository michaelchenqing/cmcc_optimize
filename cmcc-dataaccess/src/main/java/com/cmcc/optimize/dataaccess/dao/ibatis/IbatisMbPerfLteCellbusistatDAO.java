/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbPerfLteCellbusistatDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPerfLteCellbusistatDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbPerfLteCellbusistatDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbPerfLteCellbusistatDAO extends SqlMapClientDaoSupport implements MbPerfLteCellbusistatDAO {
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
    public MbPerfLteCellbusistatDO getLTEperfbyId(String cellGlbId) throws DataAccessException {

        return (MbPerfLteCellbusistatDO) getSqlMapClientTemplate().queryForObject("MS-MB-PERF-LTE-CELLBUSISTAT-GET-LT-EPERFBY-ID", cellGlbId);

    }

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
    public String insertLTEperf(MbPerfLteCellbusistatDO mbPerfLteCellbusistat) throws DataAccessException {
    	if (mbPerfLteCellbusistat == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-PERF-LTE-CELLBUSISTAT-INSERT-LT-EPERF", mbPerfLteCellbusistat);

        return mbPerfLteCellbusistat.getCellGlbId();
    }

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
    public int updateLTEperf(MbPerfLteCellbusistatDO mbPerfLteCellbusistat) throws DataAccessException {
    	if (mbPerfLteCellbusistat == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-PERF-LTE-CELLBUSISTAT-UPDATE-LT-EPERF", mbPerfLteCellbusistat);
    }

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
    public int deleteLTEperfRecord(String cellGlbId) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-PERF-LTE-CELLBUSISTAT-DELETE-LT-EPERF-RECORD", cellGlbId);
    }

}