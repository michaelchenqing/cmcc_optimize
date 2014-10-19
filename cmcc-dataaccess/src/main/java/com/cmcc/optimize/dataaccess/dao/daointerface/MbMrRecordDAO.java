/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbMrRecordDO;
import org.springframework.dao.DataAccessException;
import com.cmcc.optimize.datamodel.paging.PageList;

/**
 * A dao interface provides methods to access database table <tt>MB_MR_RECORD</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbMrRecordDAO {
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
    public MbMrRecordDO getMRByLoginId(String mmegroupid) throws DataAccessException;

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
    public String insertMr(MbMrRecordDO mbMrRecord) throws DataAccessException;

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
    public int updateMR(MbMrRecordDO mbMrRecord) throws DataAccessException;

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
    public int deleteMRRecord(String mmegroupid) throws DataAccessException;

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
    public PageList getMultiMrRecord(String mmegroupid, String cellid, String eventtype, int pageSize, int pageNum) throws DataAccessException;

}