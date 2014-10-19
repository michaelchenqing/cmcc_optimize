/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import java.util.Date;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPlanLtesiteInfoDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import com.cmcc.optimize.datamodel.paging.PageList;

/**
 * A dao interface provides methods to access database table <tt>MB_PLAN_LTESITE_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbPlanLtesiteInfoDAO {
	/**
	 *  Query DB table <tt>MB_PLAN_LTESITE_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select record_time, penodebclass, penodebname, province_name, city_name, longitude, latitude, country_name, regiontype, projectphase, penodebid, isopen, coveragecharacter, work_frqband, ischeck, isnodebname, ischecklon, ischecklat, azimuthcell1, azimuthcell2, azimuthcell3, heightcell1, heightcell2, heightcell3, downtiltcell1, downtiltcell2, downtiltcell3, electricaldowntiltcell1, electricaldowntiltcell2, electricaldowntiltcell3, ISCHECKTYPE, NETGRNAME from mb_plan_ltesite_info where (record_time = ?)</tt>
	 *
	 *	@param recordTime
	 *	@return MbPlanLtesiteInfoDO
	 *	@throws DataAccessException
	 */	 
    public MbPlanLtesiteInfoDO getPlanInfobyTime(Date recordTime) throws DataAccessException;

	/**
	 *  Query DB table <tt>MB_PLAN_LTESITE_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select record_time, penodebclass, penodebname, province_name, city_name, longitude, latitude, country_name, regiontype, projectphase, penodebid, isopen, coveragecharacter, work_frqband, ischeck, isnodebname, ischecklon, ischecklat, azimuthcell1, azimuthcell2, azimuthcell3, heightcell1, heightcell2, heightcell3, downtiltcell1, downtiltcell2, downtiltcell3, electricaldowntiltcell1, electricaldowntiltcell2, electricaldowntiltcell3, ISCHECKTYPE, NETGRNAME from mb_plan_ltesite_info where ((record_time >= '') AND (record_time < '') AND (city_name = ''))</tt>
	 *
	 *	@param startTime
	 *	@param endTime
	 *	@param list
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getPlanInfobyParam(String startTime, String endTime, List list, int pageSize, int pageNum) throws DataAccessException;

	/**
	 *  Insert one <tt>MbPlanLtesiteInfoDO</tt> object to DB table <tt>MB_PLAN_LTESITE_INFO</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_plan_ltesite_info(record_time,penodebclass,penodebname,province_name,city_name,longitude,latitude,country_name,regiontype,projectphase,penodebid,isopen,coveragecharacter,work_frqband,ischeck,isnodebname,ischecklon,ischecklat,azimuthcell1,azimuthcell2,azimuthcell3,heightcell1,heightcell2,heightcell3,downtiltcell1,downtiltcell2,downtiltcell3,electricaldowntiltcell1,electricaldowntiltcell2,electricaldowntiltcell3,ISCHECKTYPE,NETGRNAME) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbPlanLtesiteInfo
	 *	@return Date
	 *	@throws DataAccessException
	 */	 
    public Date insertPlanInfo(MbPlanLtesiteInfoDO mbPlanLtesiteInfo) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_PLAN_LTESITE_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_plan_ltesite_info set record_time=?, penodebclass=?, penodebname=?, province_name=?, city_name=?, longitude=?, latitude=?, country_name=?, regiontype=?, projectphase=?, penodebid=?, isopen=?, coveragecharacter=?, work_frqband=?, ischeck=?, isnodebname=?, ischecklon=?, ischecklat=?, azimuthcell1=?, azimuthcell2=?, azimuthcell3=?, heightcell1=?, heightcell2=?, heightcell3=?, downtiltcell1=?, downtiltcell2=?, downtiltcell3=?, electricaldowntiltcell1=?, electricaldowntiltcell2=?, electricaldowntiltcell3=?, ISCHECKTYPE=?, NETGRNAME=? where (record_time = ?)</tt>
	 *
	 *	@param mbPlanLtesiteInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updatePlanInfo(MbPlanLtesiteInfoDO mbPlanLtesiteInfo) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_PLAN_LTESITE_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_plan_ltesite_info where (record_time = ?)</tt>
	 *
	 *	@param recordTime
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deletePlanInfoRecord(Date recordTime) throws DataAccessException;

}