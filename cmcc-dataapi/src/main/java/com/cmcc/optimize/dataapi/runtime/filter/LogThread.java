package com.cmcc.optimize.dataapi.runtime.filter;

/**  
 * LogThread.java
 * com.cmcc.optimize.dataapi.runtime.filter
 * 
 * @author Administrator
 * @date 2014年7月24日 下午5:11:37
 * 版权所有
 */
import java.util.Map;

import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;

/**
 * 访问统计数据入库
 * 
 * @author
 * @date 2014年7月24日 下午5:11:37
 */
public class LogThread extends Thread {
	private Map param; 
	private String[] appName;
	private static ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtCustomProcessDAO.class, "extCustomProcessDAO");// 扩展查询dao

	public LogThread(Map param, String[] appName) {
		this.param = param;
		this.appName = appName;
	}

	@Override
	public void run() {
		for (String na : appName) {
			param.put("APP_NAME", na);
			extCustomProcessDAO.queryForObject("MULTI-INSERT-APPSTATUS-SQL", param);
		}
	}


}
