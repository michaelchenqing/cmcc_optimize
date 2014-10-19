/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellGsmnbrDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellGsmnbrDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellGsmnbrDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysLtecellGsmnbrDAO extends SqlMapClientDaoSupport implements MbSysLtecellGsmnbrDAO {
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
    public MbSysLtecellGsmnbrDO getLtecellById(String cgi) throws DataAccessException {

        return (MbSysLtecellGsmnbrDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTECELL-GSMNBR-GET-LTECELL-BY-ID", cgi);

    }

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
    public String insertLtecellGsmNbr(MbSysLtecellGsmnbrDO mbSysLtecellGsmnbr) throws DataAccessException {
    	if (mbSysLtecellGsmnbr == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-LTECELL-GSMNBR-INSERT-LTECELL-GSM-NBR", mbSysLtecellGsmnbr);

        return mbSysLtecellGsmnbr.getCgi();
    }

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
    public int updateLtecellGsmNbr(MbSysLtecellGsmnbrDO mbSysLtecellGsmnbr) throws DataAccessException {
    	if (mbSysLtecellGsmnbr == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-LTECELL-GSMNBR-UPDATE-LTECELL-GSM-NBR", mbSysLtecellGsmnbr);
    }

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
    public int deleteLtecellGsmNbr(String cgi) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-SYS-LTECELL-GSMNBR-DELETE-LTECELL-GSM-NBR", cgi);
    }

}