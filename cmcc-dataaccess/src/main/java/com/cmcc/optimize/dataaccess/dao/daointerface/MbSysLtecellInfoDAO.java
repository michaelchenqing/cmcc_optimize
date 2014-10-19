/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellInfoDO;
import org.springframework.dao.DataAccessException;
import com.cmcc.optimize.datamodel.paging.PageList;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_LTECELL_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysLtecellInfoDAO {
	/**
	 *  Query DB table <tt>MB_SYS_LTECELL_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select cell_glb_id, enodeb_glb_id, cell_id, cell_name, cell_english_name, cgi, sector_id, pci, earfcn, rf_power, sfassign, sepcsfpattern, record_time, update_time, update_user, MIN_DISTANCE from mb_sys_ltecell_info where cell_glb_id</tt>
	 *
	 *	@return MbSysLtecellInfoDO
	 *	@throws DataAccessException
	 */	 
    public MbSysLtecellInfoDO getLtecellByCellId() throws DataAccessException;

	/**
	 *  Query DB table <tt>MB_SYS_LTECELL_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select cell_glb_id, enodeb_glb_id, cell_id, cell_name, cell_english_name, cgi, sector_id, pci, earfcn, rf_power, sfassign, sepcsfpattern, record_time, update_time, update_user, MIN_DISTANCE from mb_sys_ltecell_info where ((update_time >= '') AND (update_time < ''))</tt>
	 *
	 *	@param startTime
	 *	@param endTime
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getLtecellByParam(String startTime, String endTime, int pageSize, int pageNum) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysLtecellInfoDO</tt> object to DB table <tt>MB_SYS_LTECELL_INFO</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_ltecell_info(cell_glb_id,enodeb_glb_id,cell_id,cell_name,cell_english_name,cgi,sector_id,pci,earfcn,rf_power,sfassign,sepcsfpattern,record_time,update_time,update_user,MIN_DISTANCE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?, ?)</tt>
	 *
	 *	@param mbSysLtecellInfo
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertLtecell(MbSysLtecellInfoDO mbSysLtecellInfo) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_LTECELL_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_sys_ltecell_info set cell_glb_id=?, enodeb_glb_id=?, cell_id=?, cell_name=?, cell_english_name=?, cgi=?, sector_id=?, pci=?, earfcn=?, rf_power=?, sfassign=?, sepcsfpattern=?, record_time=?, update_time=?, update_user=?, MIN_DISTANCE=? where (cell_glb_id = ?)</tt>
	 *
	 *	@param mbSysLtecellInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLtecell(MbSysLtecellInfoDO mbSysLtecellInfo) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_LTECELL_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_ltecell_info where (cell_glb_id = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteltecell(String cellGlbId) throws DataAccessException;

}