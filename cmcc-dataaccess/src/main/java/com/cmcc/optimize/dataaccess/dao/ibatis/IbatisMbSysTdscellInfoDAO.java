/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysTdscellInfoDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysTdscellInfoDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysTdscellInfoDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysTdscellInfoDAO extends SqlMapClientDaoSupport implements MbSysTdscellInfoDAO {
	/**
	 *  Query DB table <tt>MB_SYS_TDSCELL_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select cell_id, cell_name, site_oid, cgi, rru_remote, cell_longitude, cell_latitude, sector_id, pci, earfcn, rf_power, covertype, bandindicatorforfrequency, rac, powerdivisiontype, powerdivisionindex, record_time, uptime_time, update_user, cell_glb_id, site_glb_id from mb_sys_tdscell_info where (cell_id = ?)</tt>
	 *
	 *	@param cellId
	 *	@return MbSysTdscellInfoDO
	 *	@throws DataAccessException
	 */	 
    public MbSysTdscellInfoDO getTdCellInfoByCellId(long cellId) throws DataAccessException {
        Long param = new Long(cellId);

        return (MbSysTdscellInfoDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-TDSCELL-INFO-GET-TD-CELL-INFO-BY-CELL-ID", param);

    }

	/**
	 *  Insert one <tt>MbSysTdscellInfoDO</tt> object to DB table <tt>MB_SYS_TDSCELL_INFO</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_tdscell_info(cell_id,cell_name,site_oid,cgi,rru_remote,cell_longitude,cell_latitude,sector_id,pci,earfcn,rf_power,covertype,bandindicatorforfrequency,rac,powerdivisiontype,powerdivisionindex,record_time,uptime_time,update_user,cell_glb_id,site_glb_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?, ?, ?)</tt>
	 *
	 *	@param mbSysTdscellInfo
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insertRF(MbSysTdscellInfoDO mbSysTdscellInfo) throws DataAccessException {
    	if (mbSysTdscellInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-TDSCELL-INFO-INSERT-RF", mbSysTdscellInfo);

        return mbSysTdscellInfo.getCellId();
    }

	/**
	 *  Update DB table <tt>MB_SYS_TDSCELL_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_sys_tdscell_info set cell_id=?, cell_name=?, site_oid=?, cgi=?, rru_remote=?, cell_longitude=?, cell_latitude=?, sector_id=?, pci=?, earfcn=?, rf_power=?, covertype=?, bandindicatorforfrequency=?, rac=?, powerdivisiontype=?, powerdivisionindex=?, record_time=?, uptime_time=?, update_user=?, cell_glb_id=?, site_glb_id=? where (cell_id = ?)</tt>
	 *
	 *	@param mbSysTdscellInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateRF(MbSysTdscellInfoDO mbSysTdscellInfo) throws DataAccessException {
    	if (mbSysTdscellInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-TDSCELL-INFO-UPDATE-RF", mbSysTdscellInfo);
    }

	/**
	 *  Delete records from DB table <tt>MB_SYS_TDSCELL_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_tdscell_info where (cell_id = ?)</tt>
	 *
	 *	@param cellId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteRFRecord(long cellId) throws DataAccessException {
        Long param = new Long(cellId);

        return getSqlMapClientTemplate().delete("MS-MB-SYS-TDSCELL-INFO-DELETE-RF-RECORD", param);
    }

}