/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysGsmcellRfDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_GSMCELL_RF</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysGsmcellRfDAO {
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
    public MbSysGsmcellRfDO getGSMCellRFbyId(int cellId) throws DataAccessException;

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
    public int insertGSMCellRF(MbSysGsmcellRfDO mbSysGsmcellRf) throws DataAccessException;

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
    public int updateGSMCellRF(MbSysGsmcellRfDO mbSysGsmcellRf) throws DataAccessException;

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
    public int deleteGSMCellRF(int cellId) throws DataAccessException;

}