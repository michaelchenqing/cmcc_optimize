/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysGisPermissionDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_GIS_PERMISSION</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysGisPermissionDAO {
	/**
	 *  Query DB table <tt>MB_SYS_GIS_PERMISSION</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select PROVINCE, CITY, COUNTY, ENODEB_GLB_ID, ENODEB_ID, ENODEB_NAME, NETGRID, ENVIRON, VENDOR, record_time, UPDATE_TIME, UPDATE_USER, ADDRESS from MB_SYS_GIS_PERMISSION where (ENODEB_GLB_ID = ?)</tt>
	 *
	 *	@param enodebGlbId
	 *	@return MbSysGisPermissionDO
	 *	@throws DataAccessException
	 */	 
    public MbSysGisPermissionDO getLTEPERMISSIONbyId(String enodebGlbId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysGisPermissionDO</tt> object to DB table <tt>MB_SYS_GIS_PERMISSION</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into MB_SYS_GIS_PERMISSION(PROVINCE,CITY,COUNTY,ENODEB_GLB_ID,ENODEB_ID,ENODEB_NAME,NETGRID,ENVIRON,VENDOR,record_time,UPDATE_TIME,UPDATE_USER,ADDRESS) values (?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?, ?)</tt>
	 *
	 *	@param mbSysGisPermission
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertLTEPERMISSION(MbSysGisPermissionDO mbSysGisPermission) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_GIS_PERMISSION</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update MB_SYS_GIS_PERMISSION set PROVINCE=?, CITY=?, COUNTY=?, ENODEB_GLB_ID=?, ENODEB_ID=?, ENODEB_NAME=?, NETGRID=?, ENVIRON=?, VENDOR=?, record_time=sysdate, UPDATE_TIME=sysdate, UPDATE_USER=?, ADDRESS=? where (ENODEB_GLB_ID = ?)</tt>
	 *
	 *	@param mbSysGisPermission
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLTEPERMISSION(MbSysGisPermissionDO mbSysGisPermission) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_GIS_PERMISSION</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from MB_SYS_GIS_PERMISSION where (ENODEB_GLB_ID = ?)</tt>
	 *
	 *	@param enodebGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLTEPERMISSION(String enodebGlbId) throws DataAccessException;

}