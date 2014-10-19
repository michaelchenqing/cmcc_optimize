/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysGisGsmpermissionDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_GIS_GSMPERMISSION</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysGisGsmpermissionDAO {
	/**
	 *  Query DB table <tt>MB_SYS_GIS_GSMPERMISSION</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select PROVINCE, CITY, COUNTY, BSC_NAME, SITE_NAME, NETGRID, ENVIRON, VENDOR, RECORD_TIME, UPDATE_TIME, UPDATE_USER, SITE_GLB_ID from MB_SYS_GIS_GSMPERMISSION where (SITE_GLB_ID = ?)</tt>
	 *
	 *	@param siteGlbId
	 *	@return MbSysGisGsmpermissionDO
	 *	@throws DataAccessException
	 */	 
    public MbSysGisGsmpermissionDO getGSMPERMISSIONbyId(int siteGlbId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysGisGsmpermissionDO</tt> object to DB table <tt>MB_SYS_GIS_GSMPERMISSION</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into MB_SYS_GIS_GSMPERMISSION(PROVINCE,CITY,COUNTY,BSC_NAME,SITE_NAME,NETGRID,ENVIRON,VENDOR,RECORD_TIME,UPDATE_TIME,UPDATE_USER,SITE_GLB_ID) values (?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?, ?)</tt>
	 *
	 *	@param mbSysGisGsmpermission
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int insertGSMPERMISSION(MbSysGisGsmpermissionDO mbSysGisGsmpermission) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_GIS_GSMPERMISSION</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update MB_SYS_GIS_GSMPERMISSION set PROVINCE=?, CITY=?, COUNTY=?, BSC_NAME=?, SITE_NAME=?, NETGRID=?, ENVIRON=?, VENDOR=?, RECORD_TIME=sysdate, UPDATE_TIME=sysdate, UPDATE_USER=? where (SITE_GLB_ID = ?)</tt>
	 *
	 *	@param mbSysGisGsmpermission
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateGSMPERMISSION(MbSysGisGsmpermissionDO mbSysGisGsmpermission) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_GIS_GSMPERMISSION</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from MB_SYS_GIS_GSMPERMISSION where (SITE_GLB_ID = ?)</tt>
	 *
	 *	@param siteGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteGSMPERMISSION(int siteGlbId) throws DataAccessException;

}