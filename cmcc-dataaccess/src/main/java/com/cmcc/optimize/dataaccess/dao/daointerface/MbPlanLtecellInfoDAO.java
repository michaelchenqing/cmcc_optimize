/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import java.util.Date;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPlanLtecellInfoDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import com.cmcc.optimize.datamodel.paging.PageList;

/**
 * A dao interface provides methods to access database table <tt>MB_PLAN_LTECELL_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbPlanLtecellInfoDAO {
	/**
	 *  Query DB table <tt>MB_PLAN_LTECELL_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select record_time, cell_id, city, contry, min_distance, projectphase, cover_type, high, longitude, latitude, ISCHECKTYPE, NETGRNAME from mb_plan_ltecell_info where (record_time = ?)</tt>
	 *
	 *	@param recordTime
	 *	@return MbPlanLtecellInfoDO
	 *	@throws DataAccessException
	 */	 
    public MbPlanLtecellInfoDO getPlanCellByTime(Date recordTime) throws DataAccessException;

	/**
	 *  Query DB table <tt>MB_PLAN_LTECELL_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select record_time, cell_id, city, contry, min_distance, projectphase, cover_type, high, longitude, latitude, ISCHECKTYPE, NETGRNAME from mb_plan_ltecell_info</tt>
	 *
	 *	@param list
	 *	@param startTime
	 *	@param endTime
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getPlanCellParam(List list, String startTime, String endTime, int pageSize, int pageNum) throws DataAccessException;

	/**
	 *  Insert one <tt>MbPlanLtecellInfoDO</tt> object to DB table <tt>MB_PLAN_LTECELL_INFO</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_plan_ltecell_info(record_time,cell_id,city,contry,min_distance,projectphase,cover_type,high,longitude,latitude,ISCHECKTYPE,NETGRNAME) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbPlanLtecellInfo
	 *	@return Date
	 *	@throws DataAccessException
	 */	 
    public Date insertPlanCell(MbPlanLtecellInfoDO mbPlanLtecellInfo) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_PLAN_LTECELL_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_plan_ltecell_info set record_time=?, cell_id=?, city=?, contry=?, min_distance=?, projectphase=?, cover_type=?, high=?, longitude=?, latitude=?, ISCHECKTYPE=?, NETGRNAME=? where (record_time = ?)</tt>
	 *
	 *	@param mbPlanLtecellInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updatePlanCell(MbPlanLtecellInfoDO mbPlanLtecellInfo) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_PLAN_LTECELL_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_plan_ltecell_info where (record_time = ?)</tt>
	 *
	 *	@param recordTime
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLPlanCell(Date recordTime) throws DataAccessException;

}