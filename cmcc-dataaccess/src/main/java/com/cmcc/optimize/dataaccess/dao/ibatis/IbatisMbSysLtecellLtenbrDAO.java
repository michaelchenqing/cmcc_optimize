/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellLtenbrDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellLtenbrDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellLtenbrDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysLtecellLtenbrDAO extends SqlMapClientDaoSupport implements MbSysLtecellLtenbrDAO {
	/**
	 *  Query DB table <tt>MB_SYS_LTECELL_LTENBR</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select cgi, name, object_rdn, zh_name, omc_id, city, vendor_id, time_stamp, update_stamp, confirmed, tac, pci, earfcn, m_name, n_name, id, tci, ttac, tpci, isremoveallowed, ishoallowed, isicicinformationsendallowed, islballowed, plmnidlist, tearfcn, cellindividualoffset, qoffsetcell, update_user, record_time from mb_sys_ltecell_ltenbr where (cgi = ?)</tt>
	 *
	 *	@param cgi
	 *	@return MbSysLtecellLtenbrDO
	 *	@throws DataAccessException
	 */	 
    public MbSysLtecellLtenbrDO getLteNbrBycellId(String cgi) throws DataAccessException {

        return (MbSysLtecellLtenbrDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTECELL-LTENBR-GET-LTE-NBR-BYCELL-ID", cgi);

    }

	/**
	 *  Insert one <tt>MbSysLtecellLtenbrDO</tt> object to DB table <tt>MB_SYS_LTECELL_LTENBR</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_ltecell_ltenbr(cgi,name,object_rdn,zh_name,omc_id,city,vendor_id,time_stamp,update_stamp,confirmed,tac,pci,earfcn,m_name,n_name,id,tci,ttac,tpci,isremoveallowed,ishoallowed,isicicinformationsendallowed,islballowed,plmnidlist,tearfcn,cellindividualoffset,qoffsetcell,update_user,record_time) values (?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbSysLtecellLtenbr
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertLteNbr(MbSysLtecellLtenbrDO mbSysLtecellLtenbr) throws DataAccessException {
    	if (mbSysLtecellLtenbr == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-LTECELL-LTENBR-INSERT-LTE-NBR", mbSysLtecellLtenbr);

        return mbSysLtecellLtenbr.getCgi();
    }

	/**
	 *  Update DB table <tt>MB_SYS_LTECELL_LTENBR</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_sys_ltecell_ltenbr set name=?, object_rdn=?, zh_name=?, omc_id=?, city=?, vendor_id=?, time_stamp=?, update_stamp=sysdate, confirmed=?, tac=?, pci=?, earfcn=?, m_name=?, n_name=?, id=?, tci=?, ttac=?, tpci=?, isremoveallowed=?, ishoallowed=?, isicicinformationsendallowed=?, islballowed=?, plmnidlist=?, tearfcn=?, cellindividualoffset=?, qoffsetcell=?, update_user=?, record_time=? where (cgi = ?)</tt>
	 *
	 *	@param mbSysLtecellLtenbr
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLteNbr(MbSysLtecellLtenbrDO mbSysLtecellLtenbr) throws DataAccessException {
    	if (mbSysLtecellLtenbr == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-LTECELL-LTENBR-UPDATE-LTE-NBR", mbSysLtecellLtenbr);
    }

	/**
	 *  Delete records from DB table <tt>MB_SYS_LTECELL_LTENBR</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_ltecell_ltenbr where (cgi = ?)</tt>
	 *
	 *	@param cgi
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLteNbr(String cgi) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-SYS-LTECELL-LTENBR-DELETE-LTE-NBR", cgi);
    }

}