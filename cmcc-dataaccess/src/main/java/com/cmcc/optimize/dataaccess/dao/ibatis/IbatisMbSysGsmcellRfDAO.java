/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysGsmcellRfDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysGsmcellRfDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysGsmcellRfDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysGsmcellRfDAO extends SqlMapClientDaoSupport implements MbSysGsmcellRfDAO {
	/**
	 *  Query DB table <tt>MB_SYS_GSMCELL_RF</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select CELL_ID, CELL_NAME, AZIMUTH, HEIGHT, MTILT, ETILT, ANTENNA, FAKE_ANTENNA, UPDATE_TIME, RECORD_TIME, UPDATE_USER, CELL_GLB_ID, SITE_GLB_ID from MB_SYS_GSMCELL_RF where (CELL_ID = ?)</tt>
	 *
	 *	@param cellId
	 *	@return MbSysGsmcellRfDO
	 *	@throws DataAccessException
	 */	 
    public MbSysGsmcellRfDO getGSMCellRFbyId(int cellId) throws DataAccessException {
        Integer param = new Integer(cellId);

        return (MbSysGsmcellRfDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-GSMCELL-RF-GET-GSM-CELL-R-FBY-ID", param);

    }

	/**
	 *  Insert one <tt>MbSysGsmcellRfDO</tt> object to DB table <tt>MB_SYS_GSMCELL_RF</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into MB_SYS_GSMCELL_RF(CELL_ID,CELL_NAME,AZIMUTH,HEIGHT,MTILT,ETILT,ANTENNA,FAKE_ANTENNA,UPDATE_TIME,RECORD_TIME,UPDATE_USER,CELL_GLB_ID,SITE_GLB_ID) values (?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?, ?, ?)</tt>
	 *
	 *	@param mbSysGsmcellRf
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int insertGSMCellRF(MbSysGsmcellRfDO mbSysGsmcellRf) throws DataAccessException {
    	if (mbSysGsmcellRf == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-GSMCELL-RF-INSERT-GSM-CELL-RF", mbSysGsmcellRf);

        return mbSysGsmcellRf.getCellId();
    }

	/**
	 *  Update DB table <tt>MB_SYS_GSMCELL_RF</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update MB_SYS_GSMCELL_RF set CELL_NAME=?, AZIMUTH=?, HEIGHT=?, MTILT=?, ETILT=?, ANTENNA=?, FAKE_ANTENNA=?, UPDATE_TIME=sysdate, RECORD_TIME=sysdate, UPDATE_USER=?, CELL_GLB_ID=?, SITE_GLB_ID=? where (CELL_ID = ?)</tt>
	 *
	 *	@param mbSysGsmcellRf
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateGSMCellRF(MbSysGsmcellRfDO mbSysGsmcellRf) throws DataAccessException {
    	if (mbSysGsmcellRf == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-GSMCELL-RF-UPDATE-GSM-CELL-RF", mbSysGsmcellRf);
    }

	/**
	 *  Delete records from DB table <tt>MB_SYS_GSMCELL_RF</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from MB_SYS_GSMCELL_RF where (CELL_ID = ?)</tt>
	 *
	 *	@param cellId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteGSMCellRF(int cellId) throws DataAccessException {
        Integer param = new Integer(cellId);

        return getSqlMapClientTemplate().delete("MS-MB-SYS-GSMCELL-RF-DELETE-GSM-CELL-RF", param);
    }

}