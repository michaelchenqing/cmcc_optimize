/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbOmcLoLaDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbOmcLoLaDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import com.cmcc.optimize.datamodel.paging.PageList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbOmcLoLaDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbOmcLoLaDAO extends SqlMapClientDaoSupport implements MbOmcLoLaDAO {
	/**
	 *  Query DB table <tt>MB_OMC_LO_LA</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select city, enodeb_id, enodeb_name, longitude, latitude, RECORD_TIME from mb_omc_lo_la where (city = ?)</tt>
	 *
	 *	@param city
	 *	@return MbOmcLoLaDO
	 *	@throws DataAccessException
	 */	 
    public MbOmcLoLaDO getOMClOlAByCity(String city) throws DataAccessException {

        return (MbOmcLoLaDO) getSqlMapClientTemplate().queryForObject("MS-MB-OMC-LO-LA-GET-OM-CL-OL-A-BY-CITY", city);

    }

	/**
	 *  Query DB table <tt>MB_OMC_LO_LA</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select city, enodeb_id, enodeb_name, longitude, latitude, RECORD_TIME from mb_omc_lo_la</tt>
	 *
	 *	@param list
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getOmcLoLabyParam(List list, int pageSize, int pageNum) throws DataAccessException {
        Map param = new HashMap();

        param.put("list", list);
        param.put("pageSize", new Integer(pageSize));
        param.put("pageNum", new Integer(pageNum));

        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(pageSize);
        paginator.setPage(pageNum);

        paginator.setItems(((Integer) getSqlMapClientTemplate().queryForObject("MS-MB-OMC-LO-LA-GET-OMC-LO-LABY-PARAM-COUNT-FOR-PAGING", param)).intValue());
        
        PageList  pageList = new PageList();
        pageList.setPaginator(paginator);
        
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            param.put("startRow", new Integer(paginator.getBeginIndex()));
            param.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(getSqlMapClientTemplate().queryForList("MS-MB-OMC-LO-LA-GET-OMC-LO-LABY-PARAM", param));
        }
        
        return pageList;
    }

	/**
	 *  Query DB table <tt>MB_OMC_LO_LA</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select count(1) counter from mb_omc_lo_la</tt>
	 *
	 *	@param startTime
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getOmcLoLaMaxDate(String startTime) throws DataAccessException {

	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-MB-OMC-LO-LA-GET-OMC-LO-LA-MAX-DATE", startTime);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }

	/**
	 *  Query DB table <tt>MB_OMC_LO_LA</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select city, enodeb_id, enodeb_name, longitude, latitude, RECORD_TIME from mb_omc_lo_la</tt>
	 *
	 *	@param list
	 *	@param startTime
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getOmcLoLabyDate(List list, String startTime, int pageSize, int pageNum) throws DataAccessException {
        Map param = new HashMap();

        param.put("list", list);
        param.put("startTime", startTime);
        param.put("pageSize", new Integer(pageSize));
        param.put("pageNum", new Integer(pageNum));

        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(pageSize);
        paginator.setPage(pageNum);

        paginator.setItems(((Integer) getSqlMapClientTemplate().queryForObject("MS-MB-OMC-LO-LA-GET-OMC-LO-LABY-DATE-COUNT-FOR-PAGING", param)).intValue());
        
        PageList  pageList = new PageList();
        pageList.setPaginator(paginator);
        
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            param.put("startRow", new Integer(paginator.getBeginIndex()));
            param.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(getSqlMapClientTemplate().queryForList("MS-MB-OMC-LO-LA-GET-OMC-LO-LABY-DATE", param));
        }
        
        return pageList;
    }

	/**
	 *  Insert one <tt>MbOmcLoLaDO</tt> object to DB table <tt>MB_OMC_LO_LA</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_omc_lo_la(city,enodeb_id,enodeb_name,longitude,latitude) values (?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbOmcLoLa
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertOMClOlA(MbOmcLoLaDO mbOmcLoLa) throws DataAccessException {
    	if (mbOmcLoLa == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-OMC-LO-LA-INSERT-OM-CL-OL-A", mbOmcLoLa);

        return mbOmcLoLa.getCity();
    }

	/**
	 *  Update DB table <tt>MB_OMC_LO_LA</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_omc_lo_la set city=?, enodeb_id=?, enodeb_name=?, longitude=?, latitude=? where (city = ?)</tt>
	 *
	 *	@param mbOmcLoLa
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateOMClOlA(MbOmcLoLaDO mbOmcLoLa) throws DataAccessException {
    	if (mbOmcLoLa == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-OMC-LO-LA-UPDATE-OM-CL-OL-A", mbOmcLoLa);
    }

	/**
	 *  Delete records from DB table <tt>MB_OMC_LO_LA</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_omc_lo_la where (city = ?)</tt>
	 *
	 *	@param city
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLtesiteInfo(String city) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-OMC-LO-LA-DELETE-LTESITE-INFO", city);
    }

}