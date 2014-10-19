/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtesiteInfoDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtesiteInfoDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtesiteInfoDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysLtesiteInfoDAO extends SqlMapClientDaoSupport implements MbSysLtesiteInfoDAO {
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
    public MbSysLtesiteInfoDO getLtesiteInfoByEnodebGlbId(int enodebGlbId) throws DataAccessException {
        Integer param = new Integer(enodebGlbId);

        return (MbSysLtesiteInfoDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTESITE-INFO-GET-LTESITE-INFO-BY-ENODEB-GLB-ID", param);

    }

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
    public int insertLtesiteInfo(MbSysLtesiteInfoDO mbSysLtesiteInfo) throws DataAccessException {
    	if (mbSysLtesiteInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-LTESITE-INFO-INSERT-LTESITE-INFO", mbSysLtesiteInfo);

        return mbSysLtesiteInfo.getEnodebGlbId();
    }

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
    public int updateLtesiteInfo(MbSysLtesiteInfoDO mbSysLtesiteInfo) throws DataAccessException {
    	if (mbSysLtesiteInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-LTESITE-INFO-UPDATE-LTESITE-INFO", mbSysLtesiteInfo);
    }

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
    public int deleteLtesiteInfo(int enodebGlbId) throws DataAccessException {
        Integer param = new Integer(enodebGlbId);

        return getSqlMapClientTemplate().delete("MS-MB-SYS-LTESITE-INFO-DELETE-LTESITE-INFO", param);
    }

}