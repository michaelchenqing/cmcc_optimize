/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellRfDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellRfDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellRfDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysLtecellRfDAO extends SqlMapClientDaoSupport implements MbSysLtecellRfDAO {
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
    public MbSysLtecellRfDO getLtecellBycellID(int cellGlbId) throws DataAccessException {
        Integer param = new Integer(cellGlbId);

        return (MbSysLtecellRfDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTECELL-RF-GET-LTECELL-BYCELL-ID", param);

    }

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
    public int insertLtecell(MbSysLtecellRfDO mbSysLtecellRf) throws DataAccessException {
    	if (mbSysLtecellRf == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-LTECELL-RF-INSERT-LTECELL", mbSysLtecellRf);

        return mbSysLtecellRf.getCellGlbId();
    }

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
    public int updateLtecell(MbSysLtecellRfDO mbSysLtecellRf) throws DataAccessException {
    	if (mbSysLtecellRf == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-LTECELL-RF-UPDATE-LTECELL", mbSysLtecellRf);
    }

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
    public int deleteLtecell(int cellGlbId) throws DataAccessException {
        Integer param = new Integer(cellGlbId);

        return getSqlMapClientTemplate().delete("MS-MB-SYS-LTECELL-RF-DELETE-LTECELL", param);
    }

}