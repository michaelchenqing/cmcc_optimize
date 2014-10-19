/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysGsmsiteInfoDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysGsmsiteInfoDO;
import org.springframework.dao.DataAccessException;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysGsmsiteInfoDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysGsmsiteInfoDAO extends SqlMapClientDaoSupport implements MbSysGsmsiteInfoDAO {
	/**
	 *  Query DB table <tt>MB_SYS_GSMSITE_INFO</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select BSC_ID, SITE_ID, SITE_NAME, LAC, VENDOR, LONGITUDE, LATITUDE, NETGRID, ENVIRON, FREQ_BAND, COVER_TYPE, RECORD_TIME, UPDATE_TIME, UPDATE_USER, SITE_GLB_ID from MB_SYS_GSMSITE_INFO where (SITE_GLB_ID = ?)</tt>
	 *
	 *	@param siteGlbId
	 *	@return MbSysGsmsiteInfoDO
	 *	@throws DataAccessException
	 */	 
    public MbSysGsmsiteInfoDO getGSMSiteInfobyId(int siteGlbId) throws DataAccessException {
        Integer param = new Integer(siteGlbId);

        return (MbSysGsmsiteInfoDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-GSMSITE-INFO-GET-GSM-SITE-INFOBY-ID", param);

    }

	/**
	 *  Insert one <tt>MbSysGsmsiteInfoDO</tt> object to DB table <tt>MB_SYS_GSMSITE_INFO</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into MB_SYS_GSMSITE_INFO(BSC_ID,SITE_ID,SITE_NAME,LAC,VENDOR,LONGITUDE,LATITUDE,NETGRID,ENVIRON,FREQ_BAND,COVER_TYPE,RECORD_TIME,UPDATE_TIME,UPDATE_USER,SITE_GLB_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?, ?)</tt>
	 *
	 *	@param mbSysGsmsiteInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int insertGSMSiteInfo(MbSysGsmsiteInfoDO mbSysGsmsiteInfo) throws DataAccessException {
    	if (mbSysGsmsiteInfo == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-GSMSITE-INFO-INSERT-GSM-SITE-INFO", mbSysGsmsiteInfo);

        return mbSysGsmsiteInfo.getSiteGlbId();
    }

	/**
	 *  Update DB table <tt>MB_SYS_GSMSITE_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update MB_SYS_GSMSITE_INFO set BSC_ID=?, SITE_ID=?, SITE_NAME=?, LAC=?, VENDOR=?, LONGITUDE=?, LATITUDE=?, NETGRID=?, ENVIRON=?, FREQ_BAND=?, COVER_TYPE=?, RECORD_TIME=sysdate, UPDATE_TIME=sysdate, UPDATE_USER=? where (SITE_GLB_ID = ?)</tt>
	 *
	 *	@param mbSysGsmsiteInfo
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateGSMSiteInfo(MbSysGsmsiteInfoDO mbSysGsmsiteInfo) throws DataAccessException {
    	if (mbSysGsmsiteInfo == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-GSMSITE-INFO-UPDATE-GSM-SITE-INFO", mbSysGsmsiteInfo);
    }

	/**
	 *  Delete records from DB table <tt>MB_SYS_GSMSITE_INFO</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from MB_SYS_GSMSITE_INFO where (SITE_GLB_ID = ?)</tt>
	 *
	 *	@param siteGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteGSMSiteInfo(int siteGlbId) throws DataAccessException {
        Integer param = new Integer(siteGlbId);

        return getSqlMapClientTemplate().delete("MS-MB-SYS-GSMSITE-INFO-DELETE-GSM-SITE-INFO", param);
    }

}