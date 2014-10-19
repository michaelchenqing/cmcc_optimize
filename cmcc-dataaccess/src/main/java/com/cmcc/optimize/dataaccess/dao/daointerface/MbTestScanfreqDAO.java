/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbTestScanfreqDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_TEST_SCANFREQ</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbTestScanfreqDAO {
	/**
	 *  Query DB table <tt>MB_TEST_SCANFREQ</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select task_id, cell_glb_id, cell_id, cell_name, pci, earfcn, rs_rp, rs_cinr_sinr, test_time from mb_test_scanfreq where (task_id = ?)</tt>
	 *
	 *	@param taskId
	 *	@return MbTestScanfreqDO
	 *	@throws DataAccessException
	 */	 
    public MbTestScanfreqDO getScanfreqByTackId(String taskId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbTestScanfreqDO</tt> object to DB table <tt>MB_TEST_SCANFREQ</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_test_scanfreq(task_id,cell_glb_id,cell_id,cell_name,pci,earfcn,rs_rp,rs_cinr_sinr,test_time) values (?, ?, ?, ?, ?, ?, ?, ?, sysdate)</tt>
	 *
	 *	@param mbTestScanfreq
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertScanfreq(MbTestScanfreqDO mbTestScanfreq) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_TEST_SCANFREQ</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_test_scanfreq set task_id=?, cell_glb_id=?, cell_id=?, cell_name=?, pci=?, earfcn=?, rs_rp=?, rs_cinr_sinr=?, test_time=? where (task_id = ?)</tt>
	 *
	 *	@param mbTestScanfreq
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateScanfreq(MbTestScanfreqDO mbTestScanfreq) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_TEST_SCANFREQ</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_test_scanfreq where (task_id = ?)</tt>
	 *
	 *	@param taskId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteScanfreq(String taskId) throws DataAccessException;

}