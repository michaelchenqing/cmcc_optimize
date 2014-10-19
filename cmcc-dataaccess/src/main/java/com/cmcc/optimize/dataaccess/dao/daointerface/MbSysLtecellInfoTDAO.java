/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellInfoTDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import com.cmcc.optimize.datamodel.paging.PageList;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_LTECELL_INFO_T</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysLtecellInfoTDAO {
	/**
	 *  Query DB table <tt>MB_SYS_LTECELL_INFO_T</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select int_id, object_rdn, name, zh_name, omc_id, vendor_id, city_id, time_stamp, update_stamp, confirmed, state, related_enodeb, cgi, eutrancell_id, cell_identity, cell_type, cellsize, plmnidlist, tac, pci, pcilist, maximumtransmissionpower, referencesignalpower, pb, part_of_sectorpower, administrativestate, operationalstate, celllocalid, relatedrrulist, relatedantennalist, cellresvinfo, bandindicator, earfcn, bandwidth, sfassignment, specialsfpatterns, mbmsswitch, adj_td_num, adj_lte_num, adj_gsm_num, u_sf_num, d_sf_num, totalprb, ecarrier_num, dwpts_over_9, adj_lte_frqlst, adj_td_frqlst, adj_gsm_frqlst, CELL_GLB_ID, RECORD_TIME from mb_sys_ltecell_info_t where (int_id = ?)</tt>
	 *
	 *	@param intId
	 *	@return MbSysLtecellInfoTDO
	 *	@throws DataAccessException
	 */	 
    public MbSysLtecellInfoTDO getLtecellByIntId(String intId) throws DataAccessException;

	/**
	 *  Query DB table <tt>MB_SYS_LTECELL_INFO_T</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select int_id, object_rdn, name, zh_name, omc_id, vendor_id, city_id, time_stamp, update_stamp, confirmed, state, related_enodeb, cgi, eutrancell_id, cell_identity, cell_type, cellsize, plmnidlist, tac, pci, pcilist, maximumtransmissionpower, referencesignalpower, pb, part_of_sectorpower, administrativestate, operationalstate, celllocalid, relatedrrulist, relatedantennalist, cellresvinfo, bandindicator, earfcn, bandwidth, sfassignment, specialsfpatterns, mbmsswitch, adj_td_num, adj_lte_num, adj_gsm_num, u_sf_num, d_sf_num, totalprb, ecarrier_num, dwpts_over_9, adj_lte_frqlst, adj_td_frqlst, adj_gsm_frqlst, CELL_GLB_ID, RECORD_TIME from mb_sys_ltecell_info_t where ((RECORD_TIME >= '') AND (RECORD_TIME < ''))</tt>
	 *
	 *	@param startTime
	 *	@param endTime
	 *	@param list
	 *	@param pageSize
	 *	@param pageNum
	 *	@return PageList
	 *	@throws DataAccessException
	 */	 
    public PageList getLtecellByParam(String startTime, String endTime, List list, int pageSize, int pageNum) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysLtecellInfoTDO</tt> object to DB table <tt>MB_SYS_LTECELL_INFO_T</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_ltecell_info_t(int_id,object_rdn,name,zh_name,omc_id,vendor_id,city_id,time_stamp,update_stamp,confirmed,state,related_enodeb,cgi,eutrancell_id,cell_identity,cell_type,cellsize,plmnidlist,tac,pci,pcilist,maximumtransmissionpower,referencesignalpower,pb,part_of_sectorpower,administrativestate,operationalstate,celllocalid,relatedrrulist,relatedantennalist,cellresvinfo,bandindicator,earfcn,bandwidth,sfassignment,specialsfpatterns,mbmsswitch,adj_td_num,adj_lte_num,adj_gsm_num,u_sf_num,d_sf_num,totalprb,ecarrier_num,dwpts_over_9,adj_lte_frqlst,adj_td_frqlst,adj_gsm_frqlst,CELL_GLB_ID,RECORD_TIME) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param mbSysLtecellInfoT
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertLtecell(MbSysLtecellInfoTDO mbSysLtecellInfoT) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_LTECELL_INFO_T</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_sys_ltecell_info_t set int_id=?, object_rdn=?, name=?, zh_name=?, omc_id=?, vendor_id=?, city_id=?, time_stamp=?, update_stamp=?, confirmed=?, state=?, related_enodeb=?, cgi=?, eutrancell_id=?, cell_identity=?, cell_type=?, cellsize=?, plmnidlist=?, tac=?, pci=?, pcilist=?, maximumtransmissionpower=?, referencesignalpower=?, pb=?, part_of_sectorpower=?, administrativestate=?, operationalstate=?, celllocalid=?, relatedrrulist=?, relatedantennalist=?, cellresvinfo=?, bandindicator=?, earfcn=?, bandwidth=?, sfassignment=?, specialsfpatterns=?, mbmsswitch=?, adj_td_num=?, adj_lte_num=?, adj_gsm_num=?, u_sf_num=?, d_sf_num=?, totalprb=?, ecarrier_num=?, dwpts_over_9=?, adj_lte_frqlst=?, adj_td_frqlst=?, adj_gsm_frqlst=?, CELL_GLB_ID=? where (int_id = ?)</tt>
	 *
	 *	@param mbSysLtecellInfoT
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLtecell(MbSysLtecellInfoTDO mbSysLtecellInfoT) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_LTECELL_INFO_T</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_ltecell_info_t where (int_id = ?)</tt>
	 *
	 *	@param intId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteltecell(String intId) throws DataAccessException;

}