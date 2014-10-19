/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellParamDO;
import org.springframework.dao.DataAccessException;

/**
 * A dao interface provides methods to access database table <tt>MB_SYS_LTECELL_PARAM</tt>.
 *
 *
 * @author gaoqs
 */
public interface MbSysLtecellParamDAO {
	/**
	 *  Query DB table <tt>MB_SYS_LTECELL_PARAM</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select cell_glb_id, cell_id, cell_name, operastate, csfb, drx, qci6_dur_len, qci7_dur_len, qci8_dur_len, qci9_dur_len, qci6_cont_timer, qci7_cont_timer, qci8_cont_timer, qci9_cont_timer, qci6_notrig_timer, qci7_notrig_timer, qci8_notrig_timer, qci9_notrig_timer, qci6_waitresend_timer, qci7_waitresend_timer, qci8_waitresend_timer, qci9_waitresend_timer, qci6_shortdur_len, qci7_shortdur_len, qci8_shortdur_len, qci9_shortdur_len, qci6_shortdur_timer, qci7_shortdur_timer, qci8_shortdur_timer, qci9_shortdur_timer, rrc_noact_timer, def_paging_dur, rf_sig_power, pdsch_rs_ratio, pa, init_recv_power, preamble_max_count, power_inc_step, acc_ue_max_power, up_pucch_power_ctrl, pucch_optimal_power, up_pusch_power_ctrl, pathloss_comp_param, instant_optimal_power, acc_min_level, cofreq_meas_start_th, q_offsetcell, q_hyst, a3_offset_hyst, a3_hyst, a3_time_trig, if_a2_th, irat_a2_tds_th, irat_a2_gsm_th, irat_a2_errdef_th, update_time, update_user, record_time from mb_sys_ltecell_param where (cell_glb_id = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return MbSysLtecellParamDO
	 *	@throws DataAccessException
	 */	 
    public MbSysLtecellParamDO getLtecellParamBycellId(String cellGlbId) throws DataAccessException;

	/**
	 *  Insert one <tt>MbSysLtecellParamDO</tt> object to DB table <tt>MB_SYS_LTECELL_PARAM</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into mb_sys_ltecell_param(cell_glb_id,cell_id,cell_name,operastate,csfb,drx,qci6_dur_len,qci7_dur_len,qci8_dur_len,qci9_dur_len,qci6_cont_timer,qci7_cont_timer,qci8_cont_timer,qci9_cont_timer,qci6_notrig_timer,qci7_notrig_timer,qci8_notrig_timer,qci9_notrig_timer,qci6_waitresend_timer,qci7_waitresend_timer,qci8_waitresend_timer,qci9_waitresend_timer,qci6_shortdur_len,qci7_shortdur_len,qci8_shortdur_len,qci9_shortdur_len,qci6_shortdur_timer,qci7_shortdur_timer,qci8_shortdur_timer,qci9_shortdur_timer,rrc_noact_timer,def_paging_dur,rf_sig_power,pdsch_rs_ratio,pa,init_recv_power,preamble_max_count,power_inc_step,acc_ue_max_power,up_pucch_power_ctrl,pucch_optimal_power,up_pusch_power_ctrl,pathloss_comp_param,instant_optimal_power,acc_min_level,cofreq_meas_start_th,q_offsetcell,q_hyst,a3_offset_hyst,a3_hyst,a3_time_trig,if_a2_th,irat_a2_tds_th,irat_a2_gsm_th,irat_a2_errdef_th,update_time,update_user,record_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?)</tt>
	 *
	 *	@param mbSysLtecellParam
	 *	@return String
	 *	@throws DataAccessException
	 */	 
    public String insertLtecellParam(MbSysLtecellParamDO mbSysLtecellParam) throws DataAccessException;

	/**
	 *  Update DB table <tt>MB_SYS_LTECELL_PARAM</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update mb_mr_record set cell_glb_id=?, cell_id=?, cell_name=?, operastate=?, csfb=?, drx=?, qci6_dur_len=?, qci7_dur_len=?, qci8_dur_len=?, qci9_dur_len=?, qci6_cont_timer=?, qci7_cont_timer=?, qci8_cont_timer=?, qci9_cont_timer=?, qci6_notrig_timer=?, qci7_notrig_timer=?, qci8_notrig_timer=?, qci9_notrig_timer=?, qci6_waitresend_timer=?, qci7_waitresend_timer=?, qci8_waitresend_timer=?, qci9_waitresend_timer=?, qci6_shortdur_len=?, qci7_shortdur_len=?, qci8_shortdur_len=?, qci9_shortdur_len=?, qci6_shortdur_timer=?, qci7_shortdur_timer=?, qci8_shortdur_timer=?, qci9_shortdur_timer=?, rrc_noact_timer=?, def_paging_dur=?, rf_sig_power=?, pdsch_rs_ratio=?, pa=?, init_recv_power=?, preamble_max_count=?, power_inc_step=?, acc_ue_max_power=?, up_pucch_power_ctrl=?, pucch_optimal_power=?, up_pusch_power_ctrl=?, pathloss_comp_param=?, instant_optimal_power=?, acc_min_level=?, cofreq_meas_start_th=?, q_offsetcell=?, q_hyst=?, a3_offset_hyst=?, a3_hyst=?, a3_time_trig=?, if_a2_th=?, irat_a2_tds_th=?, irat_a2_gsm_th=?, irat_a2_errdef_th=?, update_time=?, update_user=?, record_time=? where (cell_glb_id = ?)</tt>
	 *
	 *	@param mbSysLtecellParam
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateLtecellParam(MbSysLtecellParamDO mbSysLtecellParam) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>MB_SYS_LTECELL_PARAM</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from mb_sys_ltecell_param where (cell_glb_id = ?)</tt>
	 *
	 *	@param cellGlbId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteLtecellParam(String cellGlbId) throws DataAccessException;

}