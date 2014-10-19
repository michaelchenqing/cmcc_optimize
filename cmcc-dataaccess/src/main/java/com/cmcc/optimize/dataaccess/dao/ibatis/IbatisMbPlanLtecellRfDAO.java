/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbPlanLtecellRfDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPlanLtecellRfDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbPlanLtecellRfDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbPlanLtecellRfDAO extends SqlMapClientDaoSupport implements MbPlanLtecellRfDAO {
	/**
	 *  Query DB table <tt>MB_PLAN_LTECELL_RF</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select cell_id, cell_name, azimuth, downtilt, m_downtilt, e_downtilt, height, altitude, antenna, fake_antenna, release_time, update_time, update_user from MB_PLAN_LTECELL_RF where (cell_id = ?)</tt>
	 *
	 *	@param cellId
	 *	@return MbPlanLtecellRfDO
	 *	@throws DataAccessException
	 */	 
    public MbPlanLtecellRfDO getPlanCellRFbyId(long cellId) throws DataAccessException {
        Long param = new Long(cellId);

        return (MbPlanLtecellRfDO) getSqlMapClientTemplate().queryForObject("MS-MB-PLAN-LTECELL-RF-GET-PLAN-CELL-R-FBY-ID", param);

    }

	/**
	 *  Insert one <tt>MbPlanLtecellRfDO</tt> object to DB table <tt>MB_PLAN_LTECELL_RF</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into MB_PLAN_LTECELL_RF(cell_id,cell_name,azimuth,downtilt,m_downtilt,e_downtilt,height,altitude,antenna,fake_antenna,release_time,update_time,update_user) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?)</tt>
	 *
	 *	@param mbPlanLtecellRf
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insertPlanCellRF(MbPlanLtecellRfDO mbPlanLtecellRf) throws DataAccessException {
    	if (mbPlanLtecellRf == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-PLAN-LTECELL-RF-INSERT-PLAN-CELL-RF", mbPlanLtecellRf);

        return mbPlanLtecellRf.getCellId();
    }

	/**
	 *  Update DB table <tt>MB_PLAN_LTECELL_RF</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update MB_PLAN_LTECELL_RF set cell_name=?, azimuth=?, downtilt=?, m_downtilt=?, e_downtilt=?, height=?, altitude=?, antenna=?, fake_antenna=?, release_time=sysdate, update_time=sysdate, update_user=? where (cell_id = ?)</tt>
	 *
	 *	@param mbPlanLtecellRf
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updatePlanCellRF(MbPlanLtecellRfDO mbPlanLtecellRf) throws DataAccessException {
    	if (mbPlanLtecellRf == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-PLAN-LTECELL-RF-UPDATE-PLAN-CELL-RF", mbPlanLtecellRf);
    }

	/**
	 *  Delete records from DB table <tt>MB_PLAN_LTECELL_RF</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from MB_PLAN_LTECELL_RF where (cell_id = ?)</tt>
	 *
	 *	@param cellId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deletePlanCellRFRecord(long cellId) throws DataAccessException {
        Long param = new Long(cellId);

        return getSqlMapClientTemplate().delete("MS-MB-PLAN-LTECELL-RF-DELETE-PLAN-CELL-RF-RECORD", param);
    }

}