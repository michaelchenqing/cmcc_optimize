/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysGisTdspermissionDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_GIS_TDSPERMISSION</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysGisTdspermissionDAO {
	/**
	 *  Query DB table <tt>MB_SYS_GIS_TDSPERMISSION</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select PROVINCE, CITY, COUNTY, RNCID, SITE_OID, SITE_NAME, NETGRID, ENVIRON, VENDOR, RECORD_TIME, UPDATE_TIME, UPDATE_USER, SITE_GLB_ID from MB_SYS_GIS_TDSPERMISSION where (SITE_GLB_ID = ?)</tt>
	 *
	 *	@param siteGlbId
	 *	@return MbSysGisTdspermissionDO
	 *	@throws DataAccessException
	 */	 
    public MbSysGisTdspermissionDO getTDSPERMISSIONbyId(int siteGlbId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysGisTdspermissionDO</tt> object to DB table <tt>MB_SYS_GIS_TDSPERMISSION</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into MB_SYS_GIS_TDSPERMISSION(PROVINCE,CITY,COUNTY,RNCID,SITE_OID,SITE_NAME,NETGRID,ENVIRON,VENDOR,RECORD_TIME,UPDATE_TIME,UPDATE_USER,SITE_GLB_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, syadate, sysdate, ?, ?)</tt>
	 *
	 *	@param mbSysGisTdspermission
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int insertTDSPERMISSION(MbSysGisTdspermissionDO mbSysGisTdspermission) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_GIS_TDSPERMISSION</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update MB_SYS_GIS_TDSPERMISSION set PROVINCE=?, CITY=?, COUNTY=?, RNCID=?, SITE_OID=?, SITE_NAME=?, NETGRID=?, ENVIRON=?, VENDOR=?, RECORD_TIME=sysdate, UPDATE_TIME=sysdate, UPDATE_USER=? where (SITE_GLB_ID = ?)</tt>
	 *
	 *	@param mbSysGisTdspermission
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateTDSPERMISSION(MbSysGisTdspermissionDO mbSysGisTdspermission) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_GIS_TDSPERMISSION</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from MB_SYS_GIS_TDSPERMISSION where (SITE_GLB_ID = ?)</tt>
	 *
	 *	@param siteGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteTDSPERMISSION(int siteGlbId) throws DataAccessException;

}