/**  
 * GetDataService.java
 * com.cmcc.optimize.dataapi.resources
 * 
 * @author yuminglang
 * @date 2014年8月13日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.resources;

import java.util.List;
import java.util.Map;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;

/**
 * Report 数据缓存服务
 * 
 * @author yuminglang
 */
public class GetDataService extends java.util.TimerTask {
	private static final CmccLogger logger = CmccLogger.getLogger(GetDataService.class);
	private static ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtCustomProcessDAO.class, "extCustomProcessDAO");// 扩展查询dao

	/*
	 * @see java.util.TimerTask#run() 定时缓存数据线程
	 */
	public void run() {
		if (logger.isInfoEnabled()) {
            logger.info("开始缓存数据");
        }
		List<Map<String, Object>> reportAbstractWithGet_list = extCustomProcessDAO.getMapList("MULTI-QUERY-DATAABSTRACT-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("reportAbstractWithGet", reportAbstractWithGet_list);

		List<Map<String, Object>> dataAnalysisWithGet_list = extCustomProcessDAO.getMapList("MULTI-QUERY-DATAANALYSIS-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("dataAnalysisWithGet", dataAnalysisWithGet_list);

		List<Map<String, Object>> fileSizeWithGet_list = extCustomProcessDAO.getMapList("MULTI-QUERY-DATAFILESIZE-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("fileSizeWithGet", fileSizeWithGet_list);

		List<Map<String, Object>> appStatusWithGet_list = extCustomProcessDAO.getMapList("MULTI-QUERY-APPSTATUS-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("appStatusWithGet", appStatusWithGet_list);

		List<Map<String, Object>> dataAmountWithGet_list = extCustomProcessDAO.getMapList("MULTI-QUERY-DATAAMOUNT-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("dataAmountWithGet", dataAmountWithGet_list);

		List<Map<String, Object>> planNowVolWithGet_list = extCustomProcessDAO.getMapList("MULTI-QUERY-PLANNOWVOL-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("planNowVolWithGet", planNowVolWithGet_list);

		List<Map<String, Object>> planNowVolTabWithGet_list = extCustomProcessDAO.getMapList("MULTI-QUERY-PLANNOWVOLTAB-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("planNowVolTabWithGet", planNowVolTabWithGet_list);

		List<Map<String, Object>> reportMroWithGet_type1_list = extCustomProcessDAO.getMapList("MULTI-QUERY-REPORTMROAMOUNT-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("reportMroWithGet_type1", reportMroWithGet_type1_list);

		List<Map<String, Object>> reportMroWithGet_type2_list = extCustomProcessDAO.getMapList("MULTI-QUERY-REPORTMROFS-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("reportMroWithGet_type2", reportMroWithGet_type2_list);

		List<Map<String, Object>> reportMroWithGet_type3_list = extCustomProcessDAO.getMapList("MULTI-QUERY-REPORTMROTAB-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("reportMroWithGet_type3", reportMroWithGet_type3_list);

		List<Map<String, Object>> signalWithGet_list = extCustomProcessDAO.getMapList("MULTI-QUERY-SIGNAL-SQL-LIST-WITH-MAPPING-PAGING", null);
		ReportResource.cacheData.put("signalWithGet", signalWithGet_list);
		if (logger.isInfoEnabled()) {
			logger.info("缓存数据完成");
		}
	}
}
