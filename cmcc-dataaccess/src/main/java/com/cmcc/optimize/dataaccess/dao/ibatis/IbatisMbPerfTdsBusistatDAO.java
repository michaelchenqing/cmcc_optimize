/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbPerfTdsBusistatDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPerfTdsBusistatDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbPerfTdsBusistatDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbPerfTdsBusistatDAO extends SqlMapClientDaoSupport implements MbPerfTdsBusistatDAO {
	/**
	 *  Query DB table <tt>MB_PERF_TDS_BUSISTAT</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select cell_glb_id, CELL_ID, CELL_NAME, record_time, PERIOD, traffic, hs_throu, r9_throu, oper_time from mb_perf_tds_busistat where (CELL_GLB_ID = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return MbPerfTdsBusistatDO
	 *	@throws DataAccessException
	 */	 
    public MbPerfTdsBusistatDO getTDSperfbyId(String cellGlbId) throws DataAccessException {

        return (MbPerfTdsBusistatDO) getSqlMapClientTemplate().queryForObject("MS-MB-PERF-TDS-BUSISTAT-GET-TD-SPERFBY-ID", cellGlbId);

    }

	/**
	 *  Insert one <tt>MbPerfTdsBusistatDO</tt> object to DB table <tt>MB_PERF_TDS_BUSISTAT</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_perf_tds_busistat(cell_glb_id,CELL_ID,CELL_NAME,record_time,PERIOD,traffic,hs_throu,r9_throu,oper_time) values (?, ?, ?, ?, ?, ?, ?, ?, sysdate)</tt>
	 *
	 *	@param mbPerfTdsBusistat
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertTDSperf(MbPerfTdsBusistatDO mbPerfTdsBusistat) throws DataAccessException {
    	if (mbPerfTdsBusistat == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-PERF-TDS-BUSISTAT-INSERT-TD-SPERF", mbPerfTdsBusistat);

        return mbPerfTdsBusistat.getCellGlbId();
    }

	/**
	 *  Update DB table <tt>MB_PERF_TDS_BUSISTAT</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_perf_tds_busistat set CELL_ID=?, CELL_NAME=?, record_time=?, PERIOD=?, traffic=?, hs_throu=?, r9_throu=?, oper_time=sysdate where (CELL_GLB_ID = ?)</tt>
	 *
	 *	@param mbPerfTdsBusistat
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateTDSperf(MbPerfTdsBusistatDO mbPerfTdsBusistat) throws DataAccessException {
    	if (mbPerfTdsBusistat == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-PERF-TDS-BUSISTAT-UPDATE-TD-SPERF", mbPerfTdsBusistat);
    }

	/**
	 *  Delete records from DB table <tt>MB_PERF_TDS_BUSISTAT</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_perf_tds_busistat where (CELL_GLB_ID = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteTDSperfRecord(String cellGlbId) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-PERF-TDS-BUSISTAT-DELETE-TD-SPERF-RECORD", cellGlbId);
    }

}