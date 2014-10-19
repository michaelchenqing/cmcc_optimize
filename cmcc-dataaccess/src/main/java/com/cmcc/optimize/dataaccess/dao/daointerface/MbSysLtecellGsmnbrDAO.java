/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellGsmnbrDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_LTECELL_GSMNBR</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysLtecellGsmnbrDAO {
	/**
	 *  Query DB table <tt>MB_SYS_LTECELL_GSMNBR</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select cgi, name, object_rdn, zh_name, omc_id, city, vendor_id, time_stamp, update_stamp, confirmed, tac, pci, earfcn, adj_gsm_frqlst, m_name, n_name, id, adjacentcellid, bcch, ncc, bcc, rac, update_user, distance, record_time from mb_sys_ltecell_gsmnbr where (cgi = ?)</tt>
	 *
	 *	@param cgi
	 *	@return MbSysLtecellGsmnbrDO
	 *	@throws DataAccessException
	 */	 
    public MbSysLtecellGsmnbrDO getLtecellById(String cgi) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysLtecellGsmnbrDO</tt> object to DB table <tt>MB_SYS_LTECELL_GSMNBR</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_ltecell_gsmnbr(cgi,name,object_rdn,zh_name,omc_id,city,vendor_id,time_stamp,update_stamp,confirmed,tac,pci,earfcn,adj_gsm_frqlst,m_name,n_name,id,adjacentcellid,bcch,ncc,bcc,rac,update_user,distance,record_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbSysLtecellGsmnbr
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertLtecellGsmNbr(MbSysLtecellGsmnbrDO mbSysLtecellGsmnbr) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_LTECELL_GSMNBR</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_sys_ltecell_gsmnbr set name=?, object_rdn=?, zh_name=?, omc_id=?, city=?, vendor_id=?, update_stamp=sysdate, confirmed=?, tac=?, pci=?, earfcn=?, adj_gsm_frqlst=?, m_name=?, n_name=?, id=?, adjacentcellid=?, bcch=?, ncc=?, bcc=?, rac=?, update_user=?, distance=?, record_time=? where (cgi = ?)</tt>
	 *
	 *	@param mbSysLtecellGsmnbr
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLtecellGsmNbr(MbSysLtecellGsmnbrDO mbSysLtecellGsmnbr) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_LTECELL_GSMNBR</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_ltecell_gsmnbr where (cgi = ?)</tt>
	 *
	 *	@param cgi
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLtecellGsmNbr(String cgi) throws DataAccessException;

}