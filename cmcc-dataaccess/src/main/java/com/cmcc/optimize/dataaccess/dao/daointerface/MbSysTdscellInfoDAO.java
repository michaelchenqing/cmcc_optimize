/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysTdscellInfoDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_TDSCELL_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysTdscellInfoDAO {
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
    public MbSysTdscellInfoDO getTdCellInfoByCellId(long cellId) throws DataAccessException;

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
    public long insertRF(MbSysTdscellInfoDO mbSysTdscellInfo) throws DataAccessException;

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
    public int updateRF(MbSysTdscellInfoDO mbSysTdscellInfo) throws DataAccessException;

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
    public int deleteRFRecord(long cellId) throws DataAccessException;

}