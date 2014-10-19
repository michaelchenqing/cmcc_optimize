/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysTdssiteInfoDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_TDSSITE_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysTdssiteInfoDAO {
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
    public MbSysTdssiteInfoDO getRNCByRncId(String rncId) throws DataAccessException;

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
    public String insertRNC(MbSysTdssiteInfoDO mbSysTdssiteInfo) throws DataAccessException;

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
    public int updateRNC(MbSysTdssiteInfoDO mbSysTdssiteInfo) throws DataAccessException;

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
    public int deleteRNC(String rncId) throws DataAccessException;

}