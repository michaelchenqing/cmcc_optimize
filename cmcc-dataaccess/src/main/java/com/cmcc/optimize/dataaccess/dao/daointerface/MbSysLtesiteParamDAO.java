/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtesiteParamDO;
import org.springframework.dao.DataAccessException;
import com.cmcc.optimize.datamodel.paging.PageList;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_LTESITE_PARAM</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysLtesiteParamDAO {
	/**
	 *  Query DB table <tt>MB_SYS_LTESITE_PARAM</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select enodeb_glb_id, enodeb_id, enodeb_name, operastate, update_time, record_time from mb_sys_ltesite_param where (enodeb_glb_id = ?)</tt>
	 *
	 *	@param enodebGlbId
	 *	@return MbSysLtesiteParamDO
	 *	@throws DataAccessException
	 */	 
    public MbSysLtesiteParamDO getLteSiteByEnodebGlbId(String enodebGlbId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysLtesiteParamDO</tt> object to DB table <tt>MB_SYS_LTESITE_PARAM</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_ltesite_param(enodeb_glb_id,enodeb_id,enodeb_name,operastate,update_time,record_time) values (?, ?, ?, ?, sysdate, ?)</tt>
	 *
	 *	@param mbSysLtesiteParam
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertLteSite(MbSysLtesiteParamDO mbSysLtesiteParam) throws DataAccessException;

	/**
	 *  Query DB table <tt>MB_SYS_LTESITE_PARAM</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select enodeb_glb_id, enodeb_id, enodeb_name, operastate, update_time, record_time from mb_sys_ltesite_param where ((record_time >= '') AND (record_time < ''))</tt>
	 *
	 *	@param startTime
	 *	@param endTime
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getLteSiteByParam(String startTime, String endTime, int pageSize, int pageNum) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_LTESITE_PARAM</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_sys_ltesite_param set enodeb_glb_id=?, enodeb_id=?, enodeb_name=?, operastate=?, update_time=sysdate, record_time=? where (enodeb_glb_id = ?)</tt>
	 *
	 *	@param mbSysLtesiteParam
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLteSite(MbSysLtesiteParamDO mbSysLtesiteParam) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_LTESITE_PARAM</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_ltesite_param where (enodeb_glb_id = ?)</tt>
	 *
	 *	@param enodebGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLteSiteRecord(String enodebGlbId) throws DataAccessException;

}