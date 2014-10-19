/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysGsmcellInfoDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_GSMCELL_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysGsmcellInfoDAO {
	/**
	 *  Query DB table <tt>MB_SYS_GSMCELL_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select CELL_ID, CELL_NAME, CELL_ENGLISH_NAME, SITE_ID, CGI, RRU_REMOTE, CELL_LONGITUDE, CELL_LATITUDE, SECTOR_ID, POWERDIVISIONTYPE, POWERDIVISIONINDEX, NCC, BCC, BCCH, COVERTYPE, BANDINDICATORFORFREQUENCY, RAC, RECORD_TIME, UPTIME_TIME, UPDATE_USER, CELL_GLB_ID, SITE_GLB_ID from MB_SYS_GSMCELL_INFO where (CELL_ID = ?)</tt>
	 *
	 *	@param cellId
	 *	@return MbSysGsmcellInfoDO
	 *	@throws DataAccessException
	 */	 
    public MbSysGsmcellInfoDO getGSMCellInfobyId(long cellId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysGsmcellInfoDO</tt> object to DB table <tt>MB_SYS_GSMCELL_INFO</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into MB_SYS_GSMCELL_INFO(CELL_ID,CELL_NAME,CELL_ENGLISH_NAME,SITE_ID,CGI,RRU_REMOTE,CELL_LONGITUDE,CELL_LATITUDE,SECTOR_ID,POWERDIVISIONTYPE,POWERDIVISIONINDEX,NCC,BCC,BCCH,COVERTYPE,BANDINDICATORFORFREQUENCY,RAC,RECORD_TIME,UPTIME_TIME,UPDATE_USER,CELL_GLB_ID,SITE_GLB_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?, ?, ?)</tt>
	 *
	 *	@param mbSysGsmcellInfo
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insertGSMCellInfo(MbSysGsmcellInfoDO mbSysGsmcellInfo) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_GSMCELL_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update MB_SYS_GSMCELL_INFO set CELL_NAME=?, CELL_ENGLISH_NAME=?, SITE_ID=?, CGI=?, RRU_REMOTE=?, CELL_LONGITUDE=?, CELL_LATITUDE=?, SECTOR_ID=?, POWERDIVISIONTYPE=?, POWERDIVISIONINDEX=?, NCC=?, BCC=?, BCCH=?, COVERTYPE=?, BANDINDICATORFORFREQUENCY=?, RAC=?, RECORD_TIME=sysdate, UPTIME_TIME=sysdate, UPDATE_USER=?, CELL_GLB_ID=?, SITE_GLB_ID=? where (CELL_ID = ?)</tt>
	 *
	 *	@param mbSysGsmcellInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateGSMCellInfo(MbSysGsmcellInfoDO mbSysGsmcellInfo) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_GSMCELL_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from MB_SYS_GSMCELL_INFO where (CELL_ID = ?)</tt>
	 *
	 *	@param cellId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteGSMCellInfo(long cellId) throws DataAccessException;

}