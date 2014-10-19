/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysTdssiteInfoDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysTdssiteInfoDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysTdssiteInfoDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysTdssiteInfoDAO extends SqlMapClientDaoSupport implements MbSysTdssiteInfoDAO {
	/**
	 *  Query DB table <tt>MB_SYS_TDSSITE_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select rnc_id, site_oid, site_name, lac, vendor, longitude, latitude, netgrid, environ, freq_band, cover_type, record_time, update_time, update_user, site_glb_id from mb_sys_tdssite_info where (rnc_id = ?)</tt>
	 *
	 *	@param rncId
	 *	@return MbSysTdssiteInfoDO
	 *	@throws DataAccessException
	 */	 
    public MbSysTdssiteInfoDO getRNCByRncId(String rncId) throws DataAccessException {

        return (MbSysTdssiteInfoDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-TDSSITE-INFO-GET-RNC-BY-RNC-ID", rncId);

    }

	/**
	 *  Insert one <tt>MbSysTdssiteInfoDO</tt> object to DB table <tt>MB_SYS_TDSSITE_INFO</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_tdssite_info(rnc_id,site_oid,site_name,lac,vendor,longitude,latitude,netgrid,environ,freq_band,cover_type,record_time,update_time,update_user,site_glb_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?, ?)</tt>
	 *
	 *	@param mbSysTdssiteInfo
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertRNC(MbSysTdssiteInfoDO mbSysTdssiteInfo) throws DataAccessException {
    	if (mbSysTdssiteInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-TDSSITE-INFO-INSERT-RNC", mbSysTdssiteInfo);

        return mbSysTdssiteInfo.getRncId();
    }

	/**
	 *  Update DB table <tt>MB_SYS_TDSSITE_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_sys_tdssite_info set rnc_id=?, site_oid=?, site_name=?, lac=?, vendor=?, longitude=?, latitude=?, netgrid=?, environ=?, freq_band=?, cover_type=?, update_user=?, site_glb_id=? where (rnc_id = ?)</tt>
	 *
	 *	@param mbSysTdssiteInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateRNC(MbSysTdssiteInfoDO mbSysTdssiteInfo) throws DataAccessException {
    	if (mbSysTdssiteInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-TDSSITE-INFO-UPDATE-RNC", mbSysTdssiteInfo);
    }

	/**
	 *  Delete records from DB table <tt>MB_SYS_TDSSITE_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_tdssite_info where (rnc_id = ?)</tt>
	 *
	 *	@param rncId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteRNC(String rncId) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-SYS-TDSSITE-INFO-DELETE-RNC", rncId);
    }

}