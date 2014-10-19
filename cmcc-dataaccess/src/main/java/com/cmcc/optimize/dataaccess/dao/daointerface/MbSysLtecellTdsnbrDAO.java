/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellTdsnbrDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_LTECELL_TDSNBR</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysLtecellTdsnbrDAO {
	/**
	 *  Query DB table <tt>MB_SYS_LTECELL_TDSNBR</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select cgi, name, object_rdn, zh_name, omc_id, city, vendor_id, time_stamp, update_stamp, confirmed, tac, pci, earfcn, m_name, n_name, id, adj_cgi, adjacentcellid, lac, rac, uarfcn, cellparameterid, update_user, ecord_time from mb_sys_ltecell_tdsnbr where (cgi = ?)</tt>
	 *
	 *	@param cgi
	 *	@return MbSysLtecellTdsnbrDO
	 *	@throws DataAccessException
	 */	 
    public MbSysLtecellTdsnbrDO getLtecellByCellId(String cgi) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysLtecellTdsnbrDO</tt> object to DB table <tt>MB_SYS_LTECELL_TDSNBR</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_ltecell_tdsnbr(cgi,name,object_rdn,zh_name,omc_id,city,vendor_id,time_stamp,update_stamp,confirmed,tac,pci,earfcn,m_name,n_name,id,adj_cgi,adjacentcellid,lac,rac,uarfcn,cellparameterid,update_user,ecord_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbSysLtecellTdsnbr
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertLtecell(MbSysLtecellTdsnbrDO mbSysLtecellTdsnbr) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_LTECELL_TDSNBR</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_sys_ltecell_tdsnbr set cgi=?, name=?, object_rdn=?, zh_name=?, omc_id=?, city=?, vendor_id=?, time_stamp=?, update_stamp=?, confirmed=?, tac=?, pci=?, earfcn=?, m_name=?, n_name=?, id=?, adj_cgi=?, adjacentcellid=?, lac=?, rac=?, uarfcn=?, cellparameterid=?, update_user=?, record_time=? where (cgi = ?)</tt>
	 *
	 *	@param mbSysLtecellTdsnbr
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLtecell(MbSysLtecellTdsnbrDO mbSysLtecellTdsnbr) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_LTECELL_TDSNBR</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_ltecell_tdsnbr where (cgi = ?)</tt>
	 *
	 *	@param cgi
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLtecell(String cgi) throws DataAccessException;

}