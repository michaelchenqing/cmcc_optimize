/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbOmcLoLaDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import com.cmcc.optimize.datamodel.paging.PageList;

/**
 * A dao interface provides methods to access database table <tt>MB_OMC_LO_LA</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbOmcLoLaDAO {
	/**
	 *  Query DB table <tt>MB_OMC_LO_LA</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select city, enodeb_id, enodeb_name, longitude, latitude, RECORD_TIME from mb_omc_lo_la where (city = ?)</tt>
	 *
	 *	@param city
	 *	@return MbOmcLoLaDO
	 *	@throws DataAccessException
	 */	 
    public MbOmcLoLaDO getOMClOlAByCity(String city) throws DataAccessException;

	/**
	 *  Query DB table <tt>MB_OMC_LO_LA</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select city, enodeb_id, enodeb_name, longitude, latitude, RECORD_TIME from mb_omc_lo_la</tt>
	 *
	 *	@param list
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getOmcLoLabyParam(List list, int pageSize, int pageNum) throws DataAccessException;

	/**
	 *  Query DB table <tt>MB_OMC_LO_LA</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select count(1) counter from mb_omc_lo_la</tt>
	 *
	 *	@param startTime
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long getOmcLoLaMaxDate(String startTime) throws DataAccessException;

	/**
	 *  Query DB table <tt>MB_OMC_LO_LA</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select city, enodeb_id, enodeb_name, longitude, latitude, RECORD_TIME from mb_omc_lo_la</tt>
	 *
	 *	@param list
	 *	@param startTime
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getOmcLoLabyDate(List list, String startTime, int pageSize, int pageNum) throws DataAccessException;

	/**
	 *  Insert one <tt>MbOmcLoLaDO</tt> object to DB table <tt>MB_OMC_LO_LA</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_omc_lo_la(city,enodeb_id,enodeb_name,longitude,latitude) values (?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbOmcLoLa
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertOMClOlA(MbOmcLoLaDO mbOmcLoLa) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_OMC_LO_LA</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_omc_lo_la set city=?, enodeb_id=?, enodeb_name=?, longitude=?, latitude=? where (city = ?)</tt>
	 *
	 *	@param mbOmcLoLa
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateOMClOlA(MbOmcLoLaDO mbOmcLoLa) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_OMC_LO_LA</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_omc_lo_la where (city = ?)</tt>
	 *
	 *	@param city
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLtesiteInfo(String city) throws DataAccessException;

}