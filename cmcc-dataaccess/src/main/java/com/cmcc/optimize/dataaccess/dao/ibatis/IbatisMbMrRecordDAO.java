/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbMrRecordDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbMrRecordDO;
import org.springframework.dao.DataAccessException;
import com.cmcc.optimize.datamodel.paging.PageList;
import java.util.Map;
import java.util.HashMap;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbMrRecordDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbMrRecordDAO extends SqlMapClientDaoSupport implements MbMrRecordDAO {
	/**
	 *  Query DB table <tt>MB_MR_RECORD</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select mmegroupid, mmecode, mmeues2apid, cellid, test_date, test_time, eventtype, mrltescrsrp, mrltencrsrp, mrltescrsrq, mrltencrsrq, mrltescrttd, mrltescphr, mrltescrip, mrltescaoa, mrltescplrdlqcix, freq_band, mrltescsinrul, mrltescearfcn, mrltescpci from mb_mr_record where (mmegroupid = ?)</tt>
	 *
	 *	@param mmegroupid
	 *	@return MbMrRecordDO
	 *	@throws DataAccessException
	 */	 
    public MbMrRecordDO getMRByLoginId(String mmegroupid) throws DataAccessException {

        return (MbMrRecordDO) getSqlMapClientTemplate().queryForObject("MS-MB-MR-RECORD-GET-MR-BY-LOGIN-ID", mmegroupid);

    }

	/**
	 *  Insert one <tt>MbMrRecordDO</tt> object to DB table <tt>MB_MR_RECORD</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_mr_record(mmegroupid,mmecode,mmeues2apid,cellid,test_date,test_time,eventtype,mrltescrsrp,mrltencrsrp,mrltescrsrq,mrltencrsrq,mrltescrttd,mrltescphr,mrltescrip,mrltescaoa,mrltescplrdlqcix,freq_band,mrltescsinrul,mrltescearfcn,mrltescpci) values (?, ?, ?, ?, sysdate, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbMrRecord
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertMr(MbMrRecordDO mbMrRecord) throws DataAccessException {
    	if (mbMrRecord == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-MR-RECORD-INSERT-MR", mbMrRecord);

        return mbMrRecord.getMmegroupid();
    }

	/**
	 *  Update DB table <tt>MB_MR_RECORD</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_mr_record set DAY=sysdate, CELLID=?, EVENTTYPE='1' where (MMEGROUPID = ?)</tt>
	 *
	 *	@param mbMrRecord
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateMR(MbMrRecordDO mbMrRecord) throws DataAccessException {
    	if (mbMrRecord == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-MR-RECORD-UPDATE-MR", mbMrRecord);
    }

	/**
	 *  Delete records from DB table <tt>MB_MR_RECORD</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_mr_record where (MMEGROUPID = ?)</tt>
	 *
	 *	@param mmegroupid
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteMRRecord(String mmegroupid) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-MR-RECORD-DELETE-MR-RECORD", mmegroupid);
    }

	/**
	 *  Query DB table <tt>MB_MR_RECORD</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select mmegroupid, mmecode, mmeues2apid, cellid, test_date, test_time, eventtype, mrltescrsrp, mrltencrsrp, mrltescrsrq, mrltencrsrq, mrltescrttd, mrltescphr, mrltescrip, mrltescaoa, mrltescplrdlqcix, freq_band, mrltescsinrul, mrltescearfcn, mrltescpci from mb_mr_record where (mmegroupid = '1') order by test_time DESC</tt>
	 *
	 *	@param mmegroupid
	 *	@param cellid
	 *	@param eventtype
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getMultiMrRecord(String mmegroupid, String cellid, String eventtype, int pageSize, int pageNum) throws DataAccessException {
        Map param = new HashMap();

        param.put("mmegroupid", mmegroupid);
        param.put("cellid", cellid);
        param.put("eventtype", eventtype);
        param.put("pageSize", new Integer(pageSize));
        param.put("pageNum", new Integer(pageNum));

        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(pageSize);
        paginator.setPage(pageNum);

        paginator.setItems(((Integer) getSqlMapClientTemplate().queryForObject("MS-MB-MR-RECORD-GET-MULTI-MR-RECORD-COUNT-FOR-PAGING", param)).intValue());
        
        PageList  pageList = new PageList();
        pageList.setPaginator(paginator);
        
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            param.put("startRow", new Integer(paginator.getBeginIndex()));
            param.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(getSqlMapClientTemplate().queryForList("MS-MB-MR-RECORD-GET-MULTI-MR-RECORD", param));
        }
        
        return pageList;
    }

}