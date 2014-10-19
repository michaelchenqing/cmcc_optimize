/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtesiteParamDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtesiteParamDO;
import org.springframework.dao.DataAccessException;
import com.cmcc.optimize.datamodel.paging.PageList;
import java.util.Map;
import java.util.HashMap;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtesiteParamDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysLtesiteParamDAO extends SqlMapClientDaoSupport implements MbSysLtesiteParamDAO {
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
    public MbSysLtesiteParamDO getLteSiteByEnodebGlbId(String enodebGlbId) throws DataAccessException {

        return (MbSysLtesiteParamDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTESITE-PARAM-GET-LTE-SITE-BY-ENODEB-GLB-ID", enodebGlbId);

    }

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
    public String insertLteSite(MbSysLtesiteParamDO mbSysLtesiteParam) throws DataAccessException {
    	if (mbSysLtesiteParam == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-LTESITE-PARAM-INSERT-LTE-SITE", mbSysLtesiteParam);

        return mbSysLtesiteParam.getEnodebGlbId();
    }

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
    public PageList getLteSiteByParam(String startTime, String endTime, int pageSize, int pageNum) throws DataAccessException {
        Map param = new HashMap();

        param.put("startTime", startTime);
        param.put("endTime", endTime);
        param.put("pageSize", new Integer(pageSize));
        param.put("pageNum", new Integer(pageNum));

        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(pageSize);
        paginator.setPage(pageNum);

        paginator.setItems(((Integer) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTESITE-PARAM-GET-LTE-SITE-BY-PARAM-COUNT-FOR-PAGING", param)).intValue());
        
        PageList  pageList = new PageList();
        pageList.setPaginator(paginator);
        
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            param.put("startRow", new Integer(paginator.getBeginIndex()));
            param.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(getSqlMapClientTemplate().queryForList("MS-MB-SYS-LTESITE-PARAM-GET-LTE-SITE-BY-PARAM", param));
        }
        
        return pageList;
    }

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
    public int updateLteSite(MbSysLtesiteParamDO mbSysLtesiteParam) throws DataAccessException {
    	if (mbSysLtesiteParam == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-LTESITE-PARAM-UPDATE-LTE-SITE", mbSysLtesiteParam);
    }

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
    public int deleteLteSiteRecord(String enodebGlbId) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-SYS-LTESITE-PARAM-DELETE-LTE-SITE-RECORD", enodebGlbId);
    }

}