/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbPlanLtesiteInfoDAO;

// auto generated imports
import java.util.Date;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPlanLtesiteInfoDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import com.cmcc.optimize.datamodel.paging.PageList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbPlanLtesiteInfoDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbPlanLtesiteInfoDAO extends SqlMapClientDaoSupport implements MbPlanLtesiteInfoDAO {
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
    public MbPlanLtesiteInfoDO getPlanInfobyTime(Date recordTime) throws DataAccessException {

        return (MbPlanLtesiteInfoDO) getSqlMapClientTemplate().queryForObject("MS-MB-PLAN-LTESITE-INFO-GET-PLAN-INFOBY-TIME", recordTime);

    }

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
    public PageList getPlanInfobyParam(String startTime, String endTime, List list, int pageSize, int pageNum) throws DataAccessException {
        Map param = new HashMap();

        param.put("startTime", startTime);
        param.put("endTime", endTime);
        param.put("list", list);
        param.put("pageSize", new Integer(pageSize));
        param.put("pageNum", new Integer(pageNum));

        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(pageSize);
        paginator.setPage(pageNum);

        paginator.setItems(((Integer) getSqlMapClientTemplate().queryForObject("MS-MB-PLAN-LTESITE-INFO-GET-PLAN-INFOBY-PARAM-COUNT-FOR-PAGING", param)).intValue());
        
        PageList  pageList = new PageList();
        pageList.setPaginator(paginator);
        
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            param.put("startRow", new Integer(paginator.getBeginIndex()));
            param.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(getSqlMapClientTemplate().queryForList("MS-MB-PLAN-LTESITE-INFO-GET-PLAN-INFOBY-PARAM", param));
        }
        
        return pageList;
    }

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
    public Date insertPlanInfo(MbPlanLtesiteInfoDO mbPlanLtesiteInfo) throws DataAccessException {
    	if (mbPlanLtesiteInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-PLAN-LTESITE-INFO-INSERT-PLAN-INFO", mbPlanLtesiteInfo);

        return mbPlanLtesiteInfo.getRecordTime();
    }

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
    public int updatePlanInfo(MbPlanLtesiteInfoDO mbPlanLtesiteInfo) throws DataAccessException {
    	if (mbPlanLtesiteInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-PLAN-LTESITE-INFO-UPDATE-PLAN-INFO", mbPlanLtesiteInfo);
    }

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
    public int deletePlanInfoRecord(Date recordTime) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-PLAN-LTESITE-INFO-DELETE-PLAN-INFO-RECORD", recordTime);
    }

}