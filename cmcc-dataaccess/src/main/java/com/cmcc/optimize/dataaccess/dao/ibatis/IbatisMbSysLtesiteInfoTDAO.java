/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtesiteInfoTDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtesiteInfoTDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import com.cmcc.optimize.datamodel.paging.PageList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtesiteInfoTDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysLtesiteInfoTDAO extends SqlMapClientDaoSupport implements MbSysLtesiteInfoTDAO {
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
    public MbSysLtesiteInfoTDO getLteSiteByEnodebGlbId_t(String intId) throws DataAccessException {

        return (MbSysLtesiteInfoTDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTESITE-INFO-T-GET-LTE-SITE-BY-ENODEB-GLB-ID-T", intId);

    }

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
    public String insertLteSite_t(MbSysLtesiteInfoTDO mbSysLtesiteInfoT) throws DataAccessException {
    	if (mbSysLtesiteInfoT == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-LTESITE-INFO-T-INSERT-LTE-SITE-T", mbSysLtesiteInfoT);

        return mbSysLtesiteInfoT.getIntId();
    }

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
    public PageList getLteSiteByParam_t(String startTime, String endTime, List list, int pageSize, int pageNum) throws DataAccessException {
        Map param = new HashMap();

        param.put("startTime", startTime);
        param.put("endTime", endTime);
        param.put("list", list);
        param.put("pageSize", new Integer(pageSize));
        param.put("pageNum", new Integer(pageNum));

        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(pageSize);
        paginator.setPage(pageNum);

        paginator.setItems(((Integer) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTESITE-INFO-T-GET-LTE-SITE-BY-PARAM-T-COUNT-FOR-PAGING", param)).intValue());
        
        PageList  pageList = new PageList();
        pageList.setPaginator(paginator);
        
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            param.put("startRow", new Integer(paginator.getBeginIndex()));
            param.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(getSqlMapClientTemplate().queryForList("MS-MB-SYS-LTESITE-INFO-T-GET-LTE-SITE-BY-PARAM-T", param));
        }
        
        return pageList;
    }

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
    public int updateLteSite_t(MbSysLtesiteInfoTDO mbSysLtesiteInfoT) throws DataAccessException {
    	if (mbSysLtesiteInfoT == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-LTESITE-INFO-T-UPDATE-LTE-SITE-T", mbSysLtesiteInfoT);
    }

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
    public int deleteLteSiteRecord_t(String intId) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-SYS-LTESITE-INFO-T-DELETE-LTE-SITE-RECORD-T", intId);
    }

}