/**  
 * AccessHttpHandler.java
 * com.cmcc.optimize.dataapi.runtime.filter
 * 
 * @author Administrator
 * @date 2014年7月24日 下午5:11:37
 * 版权所有
 */
package com.cmcc.optimize.dataapi.runtime.filter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;
import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.server.internal.routing.UriRoutingContext;

import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;

/**
 * 访问统计的hanlder
 * 
 * @author gaoqs
 * @date 2014年7月24日 下午5:11:37
 */

public class AccessHttpFilter implements ContainerRequestFilter, ContainerResponseFilter {
	public static final ThreadLocal<Long> session = new ThreadLocal<Long>();
	private static ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtCustomProcessDAO.class, "extCustomProcessDAO");// 扩展查询dao

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		Annotation[] ts = ((UriRoutingContext) requestContext.getUriInfo()).getResourceMethod().getAnnotations();
		String appNames = "";
		String apiName = "";
		for (Annotation a : ts) {
			if (a instanceof Named) {
				appNames = ((Named) a).value();
			}
			if (a instanceof Path) {
				apiName = ((Path) a).value();
			}
		}

		MultivaluedMap<String, String> qparams = requestContext.getUriInfo().getQueryParameters();
		if (qparams.get("jsoncallback") != null) {
			responseContext.setEntity(requestContext.getUriInfo().getQueryParameters().get("jsoncallback").get(0) + "(" + responseContext.getEntity() + ")");
		}
		if (qparams.get("callback") != null) {
			responseContext.setEntity(requestContext.getUriInfo().getQueryParameters().get("callback").get(0) + "(" + responseContext.getEntity() + ")");
		}
		String[] appName = appNames.split(",");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("API_NAME", apiName);
		params.put("REQUEST_API_TIME", null);
		params.put("API_CALL_TIME", new Timestamp(System.currentTimeMillis()));
		params.put("CALL_STATE", responseContext.getStatus() == 200 ? 1 : 0);
		params.put("CALL_IP", requestContext.getHeaders().getFirst("ip"));
		new LogThread(params, appName).start();
//		long timeEnd = new Date().getTime();
//		System.out.println("end:" + timeEnd);
//		long timeStart = (Long) session.get();
//		System.out.println("sub:" + (timeEnd - timeStart) + "==" + timeStart);// 访问接口时间
//
//		String reqPath = requestContext.getUriInfo().getPath();
//		System.out.println(reqPath);// 请求地址
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
//		long timeStart = new Date().getTime();
//		System.out.println("start:" + timeStart);
//		session.set(timeStart);
	}
}
