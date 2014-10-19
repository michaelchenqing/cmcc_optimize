/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysTdscellRfDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_TDSCELL_RF</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysTdscellRfDAO {
	/**
	 *  Insert one <tt>MbSysTdscellRfDO</tt> object to DB table <tt>MB_SYS_TDSCELL_RF</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into MB_SYS_TDSCELL_RF(cell_id,cell_name,azimuth,height,mtilt,etilt,antenna,fake_antenna,update_time,record_time,update_user,cell_glb_id,site_glb_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbSysTdscellRf
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int insertSysTD(MbSysTdscellRfDO mbSysTdscellRf) throws DataAccessException;

}