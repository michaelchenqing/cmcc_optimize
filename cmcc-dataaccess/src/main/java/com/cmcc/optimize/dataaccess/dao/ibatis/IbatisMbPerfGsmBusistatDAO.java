/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbPerfGsmBusistatDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPerfGsmBusistatDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbPerfGsmBusistatDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbPerfGsmBusistatDAO extends SqlMapClientDaoSupport implements MbPerfGsmBusistatDAO {
	/**
	 *  Query DB table <tt>MB_PERF_GSM_BUSISTAT</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select CELL_GLB_ID, CELL_ID, CELL_NAME, CYCLE_DATE, PERIOD, TRAFFIC, GPRS_THROU, EGPRS_THROU, OPER_TIME, RECORD_TIME from mb_perf_gsm_busistat where (CELL_GLB_ID = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return MbPerfGsmBusistatDO
	 *	@throws DataAccessException
	 */	 
    public MbPerfGsmBusistatDO getperfbyId(String cellGlbId) throws DataAccessException {

        return (MbPerfGsmBusistatDO) getSqlMapClientTemplate().queryForObject("MS-MB-PERF-GSM-BUSISTAT-GETPERFBY-ID", cellGlbId);

    }

	/**
	 *  Insert one <tt>MbPerfGsmBusistatDO</tt> object to DB table <tt>MB_PERF_GSM_BUSISTAT</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_perf_gsm_busistat(CELL_GLB_ID,CELL_ID,CELL_NAME,CYCLE_DATE,PERIOD,TRAFFIC,GPRS_THROU,EGPRS_THROU,OPER_TIME,RECORD_TIME) values (?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)</tt>
	 *
	 *	@param mbPerfGsmBusistat
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertperf(MbPerfGsmBusistatDO mbPerfGsmBusistat) throws DataAccessException {
    	if (mbPerfGsmBusistat == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-PERF-GSM-BUSISTAT-INSERTPERF", mbPerfGsmBusistat);

        return mbPerfGsmBusistat.getCellGlbId();
    }

	/**
	 *  Update DB table <tt>MB_PERF_GSM_BUSISTAT</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_perf_gsm_busistat set CELL_ID=?, CELL_NAME=?, CYCLE_DATE=?, PERIOD=?, TRAFFIC=?, GPRS_THROU=?, EGPRS_THROU=?, OPER_TIME=sysdate, RECORD_TIME=? where (CELL_GLB_ID = ?)</tt>
	 *
	 *	@param mbPerfGsmBusistat
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateperf(MbPerfGsmBusistatDO mbPerfGsmBusistat) throws DataAccessException {
    	if (mbPerfGsmBusistat == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-PERF-GSM-BUSISTAT-UPDATEPERF", mbPerfGsmBusistat);
    }

	/**
	 *  Delete records from DB table <tt>MB_PERF_GSM_BUSISTAT</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_perf_gsm_busistat where (CELL_GLB_ID = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteperfRecord(String cellGlbId) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-PERF-GSM-BUSISTAT-DELETEPERF-RECORD", cellGlbId);
    }

}