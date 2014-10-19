/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtesiteInfoDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_LTESITE_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysLtesiteInfoDAO {
	/**
	 *  Query DB table <tt>MB_SYS_LTESITE_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select enodeb_glb_id, enodeb_id, enodeb_name, tac, vendor, longitude, latitude, netgrid, environ, freq_band, cover_type, project_period, single_pass, init_time, run_time, record_time, update_time, update_user from mb_sys_ltesite_info where (enodeb_glb_id = ?)</tt>
	 *
	 *	@param enodebGlbId
	 *	@return MbSysLtesiteInfoDO
	 *	@throws DataAccessException
	 */	 
    public MbSysLtesiteInfoDO getLtesiteInfoByEnodebGlbId(int enodebGlbId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysLtesiteInfoDO</tt> object to DB table <tt>MB_SYS_LTESITE_INFO</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_ltesite_info(enodeb_glb_id,enodeb_id,enodeb_name,tac,vendor,longitude,latitude,netgrid,environ,freq_band,cover_type,project_period,single_pass,init_time,run_time,record_time,update_time,update_user) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, sysdate, sysdate, ?)</tt>
	 *
	 *	@param mbSysLtesiteInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int insertLtesiteInfo(MbSysLtesiteInfoDO mbSysLtesiteInfo) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_LTESITE_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_sys_ltesite_info set enodeb_glb_id=?, enodeb_id=?, enodeb_name=?, tac=?, vendor=?, longitude=?, latitude=?, netgrid=?, environ=?, freq_band=?, cover_type=?, project_period=?, single_pass=?, init_time=sysdate, run_time=sysdate, record_time=sysdate, update_time=sysdate, update_user=? where (enodeb_glb_id = ?)</tt>
	 *
	 *	@param mbSysLtesiteInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLtesiteInfo(MbSysLtesiteInfoDO mbSysLtesiteInfo) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_LTESITE_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_ltesite_info where (enodeb_glb_id = ?)</tt>
	 *
	 *	@param enodebGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLtesiteInfo(int enodebGlbId) throws DataAccessException;

}