/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysGsmcellInfoDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysGsmcellInfoDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysGsmcellInfoDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysGsmcellInfoDAO extends SqlMapClientDaoSupport implements MbSysGsmcellInfoDAO {
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
    public MbSysGsmcellInfoDO getGSMCellInfobyId(long cellId) throws DataAccessException {
        Long param = new Long(cellId);

        return (MbSysGsmcellInfoDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-GSMCELL-INFO-GET-GSM-CELL-INFOBY-ID", param);

    }

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
    public long insertGSMCellInfo(MbSysGsmcellInfoDO mbSysGsmcellInfo) throws DataAccessException {
    	if (mbSysGsmcellInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-GSMCELL-INFO-INSERT-GSM-CELL-INFO", mbSysGsmcellInfo);

        return mbSysGsmcellInfo.getCellId();
    }

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
    public int updateGSMCellInfo(MbSysGsmcellInfoDO mbSysGsmcellInfo) throws DataAccessException {
    	if (mbSysGsmcellInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-GSMCELL-INFO-UPDATE-GSM-CELL-INFO", mbSysGsmcellInfo);
    }

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
    public int deleteGSMCellInfo(long cellId) throws DataAccessException {
        Long param = new Long(cellId);

        return getSqlMapClientTemplate().delete("MS-MB-SYS-GSMCELL-INFO-DELETE-GSM-CELL-INFO", param);
    }

}