/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbPlanLtecellInfoDAO;

// auto generated imports
import java.util.Date;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPlanLtecellInfoDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import com.cmcc.optimize.datamodel.paging.PageList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbPlanLtecellInfoDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbPlanLtecellInfoDAO extends SqlMapClientDaoSupport implements MbPlanLtecellInfoDAO {
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
    public MbPlanLtecellInfoDO getPlanCellByTime(Date recordTime) throws DataAccessException {

        return (MbPlanLtecellInfoDO) getSqlMapClientTemplate().queryForObject("MS-MB-PLAN-LTECELL-INFO-GET-PLAN-CELL-BY-TIME", recordTime);

    }

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
    public PageList getPlanCellParam(List list, String startTime, String endTime, int pageSize, int pageNum) throws DataAccessException {
        Map param = new HashMap();

        param.put("list", list);
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        param.put("pageSize", new Integer(pageSize));
        param.put("pageNum", new Integer(pageNum));

        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(pageSize);
        paginator.setPage(pageNum);

        paginator.setItems(((Integer) getSqlMapClientTemplate().queryForObject("MS-MB-PLAN-LTECELL-INFO-GET-PLAN-CELL-PARAM-COUNT-FOR-PAGING", param)).intValue());
        
        PageList  pageList = new PageList();
        pageList.setPaginator(paginator);
        
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            param.put("startRow", new Integer(paginator.getBeginIndex()));
            param.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(getSqlMapClientTemplate().queryForList("MS-MB-PLAN-LTECELL-INFO-GET-PLAN-CELL-PARAM", param));
        }
        
        return pageList;
    }

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
    public Date insertPlanCell(MbPlanLtecellInfoDO mbPlanLtecellInfo) throws DataAccessException {
    	if (mbPlanLtecellInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-PLAN-LTECELL-INFO-INSERT-PLAN-CELL", mbPlanLtecellInfo);

        return mbPlanLtecellInfo.getRecordTime();
    }

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
    public int updatePlanCell(MbPlanLtecellInfoDO mbPlanLtecellInfo) throws DataAccessException {
    	if (mbPlanLtecellInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-PLAN-LTECELL-INFO-UPDATE-PLAN-CELL", mbPlanLtecellInfo);
    }

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
    public int deleteLPlanCell(Date recordTime) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-PLAN-LTECELL-INFO-DELETE-L-PLAN-CELL", recordTime);
    }

}