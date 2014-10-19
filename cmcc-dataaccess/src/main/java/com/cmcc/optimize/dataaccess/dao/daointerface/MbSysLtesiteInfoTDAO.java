/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtesiteInfoTDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import com.cmcc.optimize.datamodel.paging.PageList;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_LTESITE_INFO_T</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysLtesiteInfoTDAO {
	/**
	 *  Query DB table <tt>MB_SYS_LTESITE_INFO_T</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select record_time, int_id, object_rdn, name, zh_name, omc_id, vendor_id, city_id, time_stamp, update_stamp, confirmed, state, enodeb_id, enbid, x2blacklist, x2whitelist, x2hoblacklist, cover_area_info, x2ipaddresslist, max_throughput_rate, administrativestate, operationalstate, x2_num, integrityprotalgorithm, cipheringalgorithm, related_me from MB_SYS_LTESITE_INFO_T where (int_id = ?)</tt>
	 *
	 *	@param intId
	 *	@return MbSysLtesiteInfoTDO
	 *	@throws DataAccessException
	 */	 
    public MbSysLtesiteInfoTDO getLteSiteByEnodebGlbId_t(String intId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysLtesiteInfoTDO</tt> object to DB table <tt>MB_SYS_LTESITE_INFO_T</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_ltesite_info_t(record_time,int_id,object_rdn,name,zh_name,omc_id,vendor_id,city_id,time_stamp,update_stamp,confirmed,state,enodeb_id,enbid,x2blacklist,x2whitelist,x2hoblacklist,cover_area_info,x2ipaddresslist,max_throughput_rate,administrativestate,operationalstate,x2_num,integrityprotalgorithm,cipheringalgorithm,related_me) values (sysdate, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbSysLtesiteInfoT
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertLteSite_t(MbSysLtesiteInfoTDO mbSysLtesiteInfoT) throws DataAccessException;

	/**
	 *  Query DB table <tt>MB_SYS_LTESITE_INFO_T</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select record_time, int_id, object_rdn, name, zh_name, omc_id, vendor_id, city_id, time_stamp, update_stamp, confirmed, state, enodeb_id, enbid, x2blacklist, x2whitelist, x2hoblacklist, cover_area_info, x2ipaddresslist, max_throughput_rate, administrativestate, operationalstate, x2_num, integrityprotalgorithm, cipheringalgorithm, related_me from MB_SYS_LTESITE_INFO_T where ((record_time >= '') AND (record_time < ''))</tt>
	 *
	 *	@param startTime
	 *	@param endTime
	 *	@param list
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getLteSiteByParam_t(String startTime, String endTime, List list, int pageSize, int pageNum) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_LTESITE_INFO_T</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update MB_SYS_LTESITE_INFO_T set name=?, zh_name=? where (int_id = ?)</tt>
	 *
	 *	@param mbSysLtesiteInfoT
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLteSite_t(MbSysLtesiteInfoTDO mbSysLtesiteInfoT) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_LTESITE_INFO_T</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from MB_SYS_LTESITE_INFO_T where (int_id = ?)</tt>
	 *
	 *	@param intId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLteSiteRecord_t(String intId) throws DataAccessException;

}