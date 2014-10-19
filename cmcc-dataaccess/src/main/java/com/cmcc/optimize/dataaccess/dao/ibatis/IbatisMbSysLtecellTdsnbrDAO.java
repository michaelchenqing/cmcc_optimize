/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellTdsnbrDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellTdsnbrDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellTdsnbrDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysLtecellTdsnbrDAO extends SqlMapClientDaoSupport implements MbSysLtecellTdsnbrDAO {
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
    public MbSysLtecellTdsnbrDO getLtecellByCellId(String cgi) throws DataAccessException {

        return (MbSysLtecellTdsnbrDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTECELL-TDSNBR-GET-LTECELL-BY-CELL-ID", cgi);

    }

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
    public String insertLtecell(MbSysLtecellTdsnbrDO mbSysLtecellTdsnbr) throws DataAccessException {
    	if (mbSysLtecellTdsnbr == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-LTECELL-TDSNBR-INSERT-LTECELL", mbSysLtecellTdsnbr);

        return mbSysLtecellTdsnbr.getCgi();
    }

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
    public int updateLtecell(MbSysLtecellTdsnbrDO mbSysLtecellTdsnbr) throws DataAccessException {
    	if (mbSysLtecellTdsnbr == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-LTECELL-TDSNBR-UPDATE-LTECELL", mbSysLtecellTdsnbr);
    }

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
    public int deleteLtecell(String cgi) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-SYS-LTECELL-TDSNBR-DELETE-LTECELL", cgi);
    }

}