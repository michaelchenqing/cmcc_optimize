/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellRfDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_LTECELL_RF</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysLtecellRfDAO {
	/**
	 *  Query DB table <tt>MB_SYS_LTECELL_RF</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select cell_glb_id, azimuth, downtilt, m_downtilt, e_downtilt, height, altitude, antenna, fake_antenna, record_time, update_time, update_user from mb_sys_ltecell_rf where (cell_glb_id = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return MbSysLtecellRfDO
	 *	@throws DataAccessException
	 */	 
    public MbSysLtecellRfDO getLtecellBycellID(int cellGlbId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysLtecellRfDO</tt> object to DB table <tt>MB_SYS_LTECELL_RF</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_ltecell_rf(cell_glb_id,azimuth,downtilt,m_downtilt,e_downtilt,height,altitude,antenna,fake_antenna,record_time,update_time,update_user) values (?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?)</tt>
	 *
	 *	@param mbSysLtecellRf
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int insertLtecell(MbSysLtecellRfDO mbSysLtecellRf) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_LTECELL_RF</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_sys_ltecell_rf set cell_glb_id=?, azimuth=?, downtilt=?, m_downtilt=?, e_downtilt=?, height=?, altitude=?, antenna=?, fake_antenna=?, record_time=?, update_time=?, update_user=? where (cell_glb_id = ?)</tt>
	 *
	 *	@param mbSysLtecellRf
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLtecell(MbSysLtecellRfDO mbSysLtecellRf) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_LTECELL_RF</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_ltecell_rf where (cell_glb_id = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLtecell(int cellGlbId) throws DataAccessException;

}