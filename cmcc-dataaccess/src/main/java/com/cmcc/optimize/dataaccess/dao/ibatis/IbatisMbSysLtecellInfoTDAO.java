/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellInfoTDAO;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellInfoTDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import com.cmcc.optimize.datamodel.paging.PageList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * An ibatis based implementation of dao interface <tt>com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellInfoTDAO</tt>.
 *
 *
 * @author gaoqs
 */
public class IbatisMbSysLtecellInfoTDAO extends SqlMapClientDaoSupport implements MbSysLtecellInfoTDAO {
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
    public MbSysLtecellInfoTDO getLtecellByIntId(String intId) throws DataAccessException {

        return (MbSysLtecellInfoTDO) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTECELL-INFO-T-GET-LTECELL-BY-INT-ID", intId);

    }

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
    public PageList getLtecellByParam(String startTime, String endTime, List list, int pageSize, int pageNum) throws DataAccessException {
        Map param = new HashMap();

        param.put("startTime", startTime);
        param.put("endTime", endTime);
        param.put("list", list);
        param.put("pageSize", new Integer(pageSize));
        param.put("pageNum", new Integer(pageNum));

        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(pageSize);
        paginator.setPage(pageNum);

        paginator.setItems(((Integer) getSqlMapClientTemplate().queryForObject("MS-MB-SYS-LTECELL-INFO-T-GET-LTECELL-BY-PARAM-COUNT-FOR-PAGING", param)).intValue());
        
        PageList  pageList = new PageList();
        pageList.setPaginator(paginator);
        
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            param.put("startRow", new Integer(paginator.getBeginIndex()));
            param.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(getSqlMapClientTemplate().queryForList("MS-MB-SYS-LTECELL-INFO-T-GET-LTECELL-BY-PARAM", param));
        }
        
        return pageList;
    }

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
    public String insertLtecell(MbSysLtecellInfoTDO mbSysLtecellInfoT) throws DataAccessException {
    	if (mbSysLtecellInfoT == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-MB-SYS-LTECELL-INFO-T-INSERT-LTECELL", mbSysLtecellInfoT);

        return mbSysLtecellInfoT.getIntId();
    }

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
    public int updateLtecell(MbSysLtecellInfoTDO mbSysLtecellInfoT) throws DataAccessException {
    	if (mbSysLtecellInfoT == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-MB-SYS-LTECELL-INFO-T-UPDATE-LTECELL", mbSysLtecellInfoT);
    }

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
    public int deleteltecell(String intId) throws DataAccessException {

        return getSqlMapClientTemplate().delete("MS-MB-SYS-LTECELL-INFO-T-DELETELTECELL", intId);
    }

}