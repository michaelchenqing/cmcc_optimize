/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysGisPermissionDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysGisPermissionDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysGisPermissionDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysGisPermissionDAO extends SqlMapClientDaoSupport implements MbSysGisPermissionDAO {
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
    public MbSysGisPermissionDO getLTEPERMISSIONbyId(String enodebGlbId) throws DataAccessException {

        return (MbSysGisPermissionDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-GIS-PERMISSION-GET-LTEPERMISSIO-NBY-ID", enodebGlbId);

    }

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
    public String insertLTEPERMISSION(MbSysGisPermissionDO mbSysGisPermission) throws DataAccessException {
    	if (mbSysGisPermission == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-GIS-PERMISSION-INSERT-LTEPERMISSION", mbSysGisPermission);

        return mbSysGisPermission.getEnodebGlbId();
    }

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
    public int updateLTEPERMISSION(MbSysGisPermissionDO mbSysGisPermission) throws DataAccessException {
    	if (mbSysGisPermission == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-GIS-PERMISSION-UPDATE-LTEPERMISSION", mbSysGisPermission);
    }

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
    public int deleteLTEPERMISSION(String enodebGlbId) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-SYS-GIS-PERMISSION-DELETE-LTEPERMISSION", enodebGlbId);
    }

}