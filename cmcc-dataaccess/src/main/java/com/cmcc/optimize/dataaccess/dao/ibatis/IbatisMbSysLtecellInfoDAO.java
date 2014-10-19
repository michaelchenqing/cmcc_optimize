/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellInfoDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellInfoDO;
import org.springframework.dao.DataAccessException;
import com.cmcc.optimize.datamodel.paging.PageList;
import java.util.Map;
import java.util.HashMap;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellInfoDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysLtecellInfoDAO extends SqlMapClientDaoSupport implements MbSysLtecellInfoDAO {
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
    public MbSysLtecellInfoDO getLtecellByCellId() throws DataAccessException {

        return (MbSysLtecellInfoDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTECELL-INFO-GET-LTECELL-BY-CELL-ID", null);

    }

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
    public PageList getLtecellByParam(String startTime, String endTime, int pageSize, int pageNum) throws DataAccessException {
        Map param = new HashMap();

        param.put("startTime", startTime);
        param.put("endTime", endTime);
        param.put("pageSize", new Integer(pageSize));
        param.put("pageNum", new Integer(pageNum));

        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(pageSize);
        paginator.setPage(pageNum);

        paginator.setItems(((Integer) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTECELL-INFO-GET-LTECELL-BY-PARAM-COUNT-FOR-PAGING", param)).intValue());
        
        PageList  pageList = new PageList();
        pageList.setPaginator(paginator);
        
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            param.put("startRow", new Integer(paginator.getBeginIndex()));
            param.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(getSqlMapClientTemplate().queryForList("MS-MB-SYS-LTECELL-INFO-GET-LTECELL-BY-PARAM", param));
        }
        
        return pageList;
    }

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
    public String insertLtecell(MbSysLtecellInfoDO mbSysLtecellInfo) throws DataAccessException {
    	if (mbSysLtecellInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-LTECELL-INFO-INSERT-LTECELL", mbSysLtecellInfo);

        return mbSysLtecellInfo.getCellGlbId();
    }

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
    public int updateLtecell(MbSysLtecellInfoDO mbSysLtecellInfo) throws DataAccessException {
    	if (mbSysLtecellInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-LTECELL-INFO-UPDATE-LTECELL", mbSysLtecellInfo);
    }

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
    public int deleteltecell(String cellGlbId) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-SYS-LTECELL-INFO-DELETELTECELL", cellGlbId);
    }

}