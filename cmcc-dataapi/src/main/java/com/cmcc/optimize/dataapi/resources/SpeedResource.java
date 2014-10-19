/**  
 * ReportResource.java
 * com.cmcc.optimize.dataapi.resources
 * 
 * @author yuminglang
 * @date 2014年8月1日 上午11:00:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;
import com.cmcc.optimize.dataaccess.util.DateUtil;
import com.cmcc.optimize.dataapi.ErrorWrap;
import com.cmcc.optimize.dataapi.ErrorWrap.RestError;
import com.cmcc.optimize.dataapi.TokenControl;
import com.cmcc.optimize.dataapi.param.DataAbstarctParam;
import com.cmcc.optimize.dataapi.param.FTPParam;
import com.cmcc.optimize.dataapi.param.HttpParam;
import com.cmcc.optimize.dataapi.param.PingParam;
import com.cmcc.optimize.dataapi.param.VideoParam;
import com.cmcc.optimize.datamodel.paging.PageList;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * 手机测速 rest接口服务
 * 
 * @author yuminglang
 */
@Path("speed")
@Singleton
// 单例
public class SpeedResource {
	private static final CmccLogger logger = CmccLogger.getLogger(SpeedResource.class);

	private TokenControl tokenControl = new TokenControl();// 权限控制

	private static ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtCustomProcessDAO.class, "extCustomProcessDAO");// 扩展查询dao

	private SerializerFeature[] features = new SerializerFeature[] { SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty };// 输出格式定义

	/**
	 * FTP post 参数描述参见：@see FTPParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@POST
	@Produces({ "text/plain;charset=utf-8" })
	@Path("ftp")
	@Named(value = "手机测速")
	public String speedFtpWithPost(@QueryParam(FTPParam.type) int type, @QueryParam(FTPParam.starttime) String starttime, @QueryParam(FTPParam.endtime) String endtime, @QueryParam(FTPParam.timeunit) String timeunit, @QueryParam(FTPParam.areainfo) String areainfo,
			@QueryParam(FTPParam.pageindex) int pageindex, @QueryParam(FTPParam.itemcount) int itemcount, @QueryParam(FTPParam.token) String token) {
		return speedFtpWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
	}

	/**
	 * FTP get 参数描述参见：@see FTPParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Produces({ "text/plain;charset=utf-8" })
	@Path("ftp")
	@Named(value = "手机测速")
	public String speedFtpWithGet(@QueryParam(FTPParam.type) int type, @QueryParam(FTPParam.starttime) String starttime, @QueryParam(FTPParam.endtime) String endtime, @QueryParam(FTPParam.timeunit) String timeunit, @QueryParam(FTPParam.areainfo) String areainfo,
			@QueryParam(FTPParam.pageindex) int pageindex, @QueryParam(FTPParam.itemcount) int itemcount, @QueryParam(FTPParam.token) String token) {
		if (logger.isInfoEnabled()) {
			logger.info("enbparameter:" + type);
		}

		ErrorWrap result = new ErrorWrap();// 返回结果

		// 权限验证
		boolean isSucc = tokenControl.isValid(token, result);
		if (!isSucc) {
			if (result.error == null) {
				result.error = RestError.TOKEN_ERROR;
			}
			return result.error.toString();
		}
		// 分页信息
		if (pageindex <= 0) {
			pageindex = 1;
		}
		if (itemcount <= 0) {
			itemcount = 10;
		}
		JSONObject res = new JSONObject();
		Map<String, Object> params = new HashMap<String, Object>();
		String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
		if (times == null || times.length != 2) {
			logger.warn("enbParameterWithGet 时间参数不正确!" + starttime + "@" + endtime);
			result.error = RestError.PARAM_ERROR;
			result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
			return result.toString();
		}
		params.put("startTime", times[0]);
		params.put("endTime", times[1]);
		params.put("city", areainfo);

		// 分页查询
		Paginator paginator = new Paginator();
		paginator.setItemsPerPage(itemcount);
		paginator.setPage(pageindex);
		paginator.setItems(((Integer) extCustomProcessDAO.queryForObject("MULTI-QUERY-FTP-SQL-LIST-WITH-MAPPING-COUNT", params)).intValue());
		res.put("total", paginator.getItems());
		PageList pageList = new PageList();
		pageList.setPaginator(paginator);
		try {
			if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
				params.put("startRow", new Integer(paginator.getBeginIndex()));
				params.put("endRow", new Integer(paginator.getEndIndex()));
				pageList.addAll(extCustomProcessDAO.getMapList("MULTI-QUERY-FTP-SQL-LIST-WITH-MAPPING-PAGING", params));
			}
		} catch (Exception e) {
			logger.error("type:" + type, e);
			result.error = RestError.OTHER_ERROR;
			result.setErrMsg(e.toString());
			return result.error.toString();
		}
		// 输出的json字符串构造
		res.put("list", JSON.toJSON(pageList));
		res.put("message", "成功");
		res.put("result", 0);
		return JSONObject.toJSONString(res, features);
	}
	/**
	 * HTTP post 参数描述参见：@see HttpParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@POST
	@Produces({ "text/plain;charset=utf-8" })
	@Path("http")
	@Named(value = "手机测速")
	public String speedHttpWithPost(@QueryParam(HttpParam.type) int type, @QueryParam(HttpParam.starttime) String starttime, @QueryParam(HttpParam.endtime) String endtime, @QueryParam(HttpParam.timeunit) String timeunit, @QueryParam(HttpParam.areainfo) String areainfo,
			@QueryParam(HttpParam.pageindex) int pageindex, @QueryParam(HttpParam.itemcount) int itemcount, @QueryParam(HttpParam.token) String token) {
		return speedHttpWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
	}
	
	/**
	 * HTTP get 参数描述参见：@see HttpParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Produces({ "text/plain;charset=utf-8" })
	@Path("http")
	@Named(value = "手机测速")
	public String speedHttpWithGet(@QueryParam(HttpParam.type) int type, @QueryParam(HttpParam.starttime) String starttime, @QueryParam(HttpParam.endtime) String endtime, @QueryParam(HttpParam.timeunit) String timeunit, @QueryParam(HttpParam.areainfo) String areainfo,
			@QueryParam(HttpParam.pageindex) int pageindex, @QueryParam(HttpParam.itemcount) int itemcount, @QueryParam(HttpParam.token) String token) {
		if (logger.isInfoEnabled()) {
			logger.info("enbparameter:" + type);
		}
		
		ErrorWrap result = new ErrorWrap();// 返回结果
		
		// 权限验证
		boolean isSucc = tokenControl.isValid(token, result);
		if (!isSucc) {
			if (result.error == null) {
				result.error = RestError.TOKEN_ERROR;
			}
			return result.error.toString();
		}
		// 分页信息
		if (pageindex <= 0) {
			pageindex = 1;
		}
		if (itemcount <= 0) {
			itemcount = 10;
		}
		JSONObject res = new JSONObject();
		Map<String, Object> params = new HashMap<String, Object>();
		String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
		if (times == null || times.length != 2) {
			logger.warn("enbParameterWithGet 时间参数不正确!" + starttime + "@" + endtime);
			result.error = RestError.PARAM_ERROR;
			result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
			return result.toString();
		}
		params.put("startTime", times[0]);
		params.put("endTime", times[1]);
		params.put("city", areainfo);
		
		// 分页查询
		Paginator paginator = new Paginator();
		paginator.setItemsPerPage(itemcount);
		paginator.setPage(pageindex);
		paginator.setItems(((Integer) extCustomProcessDAO.queryForObject("MULTI-QUERY-HTTP-SQL-LIST-WITH-MAPPING-COUNT", params)).intValue());
		res.put("total", paginator.getItems());
		PageList pageList = new PageList();
		pageList.setPaginator(paginator);
		try {
			if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
				params.put("startRow", new Integer(paginator.getBeginIndex()));
				params.put("endRow", new Integer(paginator.getEndIndex()));
				pageList.addAll(extCustomProcessDAO.getMapList("MULTI-QUERY-HTTP-SQL-LIST-WITH-MAPPING-PAGING", params));
			}
		} catch (Exception e) {
			logger.error("type:" + type, e);
			result.error = RestError.OTHER_ERROR;
			result.setErrMsg(e.toString());
			return result.error.toString();
		}
		// 输出的json字符串构造
		res.put("list", JSON.toJSON(pageList));
		res.put("message", "成功");
		res.put("result", 0);
		return JSONObject.toJSONString(res, features);
	}
	/**
	 * Ping post 参数描述参见：@see PingParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@POST
	@Produces({ "text/plain;charset=utf-8" })
	@Path("ping")
	@Named(value = "手机测速")
	public String speedPingWithPost(@QueryParam(PingParam.type) int type, @QueryParam(PingParam.starttime) String starttime, @QueryParam(PingParam.endtime) String endtime, @QueryParam(PingParam.timeunit) String timeunit, @QueryParam(PingParam.areainfo) String areainfo,
			@QueryParam(PingParam.pageindex) int pageindex, @QueryParam(PingParam.itemcount) int itemcount, @QueryParam(PingParam.token) String token) {
		return speedPingWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
	}
	
	/**
	 * HTTP get 参数描述参见：@see PingParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Produces({ "text/plain;charset=utf-8" })
	@Path("ping")
	@Named(value = "手机测速")
	public String speedPingWithGet(@QueryParam(PingParam.type) int type, @QueryParam(PingParam.starttime) String starttime, @QueryParam(PingParam.endtime) String endtime, @QueryParam(PingParam.timeunit) String timeunit, @QueryParam(PingParam.areainfo) String areainfo,
			@QueryParam(PingParam.pageindex) int pageindex, @QueryParam(PingParam.itemcount) int itemcount, @QueryParam(PingParam.token) String token) {
		if (logger.isInfoEnabled()) {
			logger.info("enbparameter:" + type);
		}
		
		ErrorWrap result = new ErrorWrap();// 返回结果
		
		// 权限验证
		boolean isSucc = tokenControl.isValid(token, result);
		if (!isSucc) {
			if (result.error == null) {
				result.error = RestError.TOKEN_ERROR;
			}
			return result.error.toString();
		}
		// 分页信息
		if (pageindex <= 0) {
			pageindex = 1;
		}
		if (itemcount <= 0) {
			itemcount = 10;
		}
		JSONObject res = new JSONObject();
		Map<String, Object> params = new HashMap<String, Object>();
		String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
		if (times == null || times.length != 2) {
			logger.warn("enbParameterWithGet 时间参数不正确!" + starttime + "@" + endtime);
			result.error = RestError.PARAM_ERROR;
			result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
			return result.toString();
		}
		params.put("startTime", times[0]);
		params.put("endTime", times[1]);
		params.put("city", areainfo);
		
		// 分页查询
		Paginator paginator = new Paginator();
		paginator.setItemsPerPage(itemcount);
		paginator.setPage(pageindex);
		paginator.setItems(((Integer) extCustomProcessDAO.queryForObject("MULTI-QUERY-PING-SQL-LIST-WITH-MAPPING-COUNT", params)).intValue());
		res.put("total", paginator.getItems());
		PageList pageList = new PageList();
		pageList.setPaginator(paginator);
		try {
			if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
				params.put("startRow", new Integer(paginator.getBeginIndex()));
				params.put("endRow", new Integer(paginator.getEndIndex()));
				pageList.addAll(extCustomProcessDAO.getMapList("MULTI-QUERY-PING-SQL-LIST-WITH-MAPPING-PAGING", params));
			}
		} catch (Exception e) {
			logger.error("type:" + type, e);
			result.error = RestError.OTHER_ERROR;
			result.setErrMsg(e.toString());
			return result.error.toString();
		}
		// 输出的json字符串构造
		res.put("list", JSON.toJSON(pageList));
		res.put("message", "成功");
		res.put("result", 0);
		return JSONObject.toJSONString(res, features);
	}
	/**
	 * Video post 参数描述参见：@see VideoParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@POST
	@Produces({ "text/plain;charset=utf-8" })
	@Path("video")
	@Named(value = "手机测速")
	public String speedVideoWithPost(@QueryParam(VideoParam.type) int type, @QueryParam(VideoParam.starttime) String starttime, @QueryParam(VideoParam.endtime) String endtime, @QueryParam(VideoParam.timeunit) String timeunit, @QueryParam(VideoParam.areainfo) String areainfo,
			@QueryParam(VideoParam.pageindex) int pageindex, @QueryParam(VideoParam.itemcount) int itemcount, @QueryParam(VideoParam.token) String token) {
		return speedVideoWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
	}
	
	/**
	 * HTTP get 参数描述参见：@see VideoParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Produces({ "text/plain;charset=utf-8" })
	@Path("video")
	@Named(value = "手机测速")
	public String speedVideoWithGet(@QueryParam(VideoParam.type) int type, @QueryParam(VideoParam.starttime) String starttime, @QueryParam(VideoParam.endtime) String endtime, @QueryParam(VideoParam.timeunit) String timeunit, @QueryParam(VideoParam.areainfo) String areainfo,
			@QueryParam(VideoParam.pageindex) int pageindex, @QueryParam(VideoParam.itemcount) int itemcount, @QueryParam(VideoParam.token) String token) {
		if (logger.isInfoEnabled()) {
			logger.info("enbparameter:" + type);
		}
		
		ErrorWrap result = new ErrorWrap();// 返回结果
		
		// 权限验证
		boolean isSucc = tokenControl.isValid(token, result);
		if (!isSucc) {
			if (result.error == null) {
				result.error = RestError.TOKEN_ERROR;
			}
			return result.error.toString();
		}
		// 分页信息
		if (pageindex <= 0) {
			pageindex = 1;
		}
		if (itemcount <= 0) {
			itemcount = 10;
		}
		JSONObject res = new JSONObject();
		Map<String, Object> params = new HashMap<String, Object>();
		String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
		if (times == null || times.length != 2) {
			logger.warn("enbParameterWithGet 时间参数不正确!" + starttime + "@" + endtime);
			result.error = RestError.PARAM_ERROR;
			result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
			return result.toString();
		}
		params.put("startTime", times[0]);
		params.put("endTime", times[1]);
		params.put("city", areainfo);
		
		// 分页查询
		Paginator paginator = new Paginator();
		paginator.setItemsPerPage(itemcount);
		paginator.setPage(pageindex);
		paginator.setItems(((Integer) extCustomProcessDAO.queryForObject("MULTI-QUERY-VIDEO-SQL-LIST-WITH-MAPPING-COUNT", params)).intValue());
		res.put("total", paginator.getItems());
		PageList pageList = new PageList();
		pageList.setPaginator(paginator);
		try {
			if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
				params.put("startRow", new Integer(paginator.getBeginIndex()));
				params.put("endRow", new Integer(paginator.getEndIndex()));
				pageList.addAll(extCustomProcessDAO.getMapList("MULTI-QUERY-VIDEO-SQL-LIST-WITH-MAPPING-PAGING", params));
			}
		} catch (Exception e) {
			logger.error("type:" + type, e);
			result.error = RestError.OTHER_ERROR;
			result.setErrMsg(e.toString());
			return result.error.toString();
		}
		// 输出的json字符串构造
		res.put("list", JSON.toJSON(pageList));
		res.put("message", "成功");
		res.put("result", 0);
		return JSONObject.toJSONString(res, features);
	}
	/**
	 * INDEX post 参数描述参见：@see DataAbstarctParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@POST
	@Produces({ "text/plain;charset=utf-8" })
	@Path("index")
	@Named(value = "手机测速")
	public String speedIndexWithPost(@QueryParam(DataAbstarctParam.type) int type, @QueryParam(DataAbstarctParam.starttime) String starttime, @QueryParam(DataAbstarctParam.endtime) String endtime, @QueryParam(DataAbstarctParam.timeunit) String timeunit,
			@QueryParam(DataAbstarctParam.areainfo) String areainfo, @QueryParam(DataAbstarctParam.pageindex) int pageindex, @QueryParam(DataAbstarctParam.itemcount) int itemcount, @QueryParam(DataAbstarctParam.token) String token) {
		return speedIndexWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
	}

	/**
	 * INDEX get 参数描述参见：@see DataAbstarctParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Produces({ "text/plain;charset=utf-8" })
	@Path("index")
	@Named(value = "手机测速")
	public String speedIndexWithGet(@QueryParam(DataAbstarctParam.type) int type, @QueryParam(DataAbstarctParam.starttime) String starttime, @QueryParam(DataAbstarctParam.endtime) String endtime, @QueryParam(DataAbstarctParam.timeunit) String timeunit,
			@QueryParam(DataAbstarctParam.areainfo) String areainfo, @QueryParam(DataAbstarctParam.pageindex) int pageindex, @QueryParam(DataAbstarctParam.itemcount) int itemcount, @QueryParam(DataAbstarctParam.token) String token) {

		ErrorWrap result = new ErrorWrap();// 返回结果

		// 权限验证
		boolean isSucc = tokenControl.isValid(token, result);
		if (!isSucc) {
			if (result.error == null) {
				result.error = RestError.TOKEN_ERROR;
			}
			return result.error.toString();
		}
		// 全省数据概览查询
		List<Map<String, Object>> absList = extCustomProcessDAO.getMapList("MULTI-QUERY-INDEX-ABSTRACT1-SQL-LIST-WITH-MAPPING-PAGING", null);// 首页全省数据概览中--测速地市数量、测速地市、网络类型、平均电平
		List<Map<String, Object>> avgList = extCustomProcessDAO.getMapList("MULTI-QUERY-INDEX-ABSTRACT2-SQL-LIST-WITH-MAPPING-PAGING", null);// 首页全省数据概览中--FTP平均速率、HTTP平均速率、PING平均历时、VIDEO流畅度

		JSONObject res = new JSONObject();
		// 输出的json字符串构造
		res.put("absList", JSON.toJSON(absList));
		res.put("avgList", JSON.toJSON(avgList));
		res.put("message", "成功");
		res.put("result", 0);
		return JSONObject.toJSONString(res, features);
	}

	/**
	 * INDEX chart post 参数描述参见：@see DataAbstarctParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@POST
	@Produces({ "text/plain;charset=utf-8" })
	@Path("chart")
	@Named(value = "手机测速")
	public String speedChartWithPost(@QueryParam(DataAbstarctParam.type) int type, @QueryParam(DataAbstarctParam.starttime) String starttime, @QueryParam(DataAbstarctParam.endtime) String endtime, @QueryParam(DataAbstarctParam.timeunit) String timeunit,
			@QueryParam(DataAbstarctParam.areainfo) String areainfo, @QueryParam(DataAbstarctParam.pageindex) int pageindex, @QueryParam(DataAbstarctParam.itemcount) int itemcount, @QueryParam(DataAbstarctParam.token) String token) {
		return speedChartWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
	}

	/**
	 * INDEX chart get 参数描述参见：@see DataAbstarctParam.class
	 * 
	 * @param type
	 * @param starttime
	 * @param endtime
	 * @param timeunit
	 * @param areainfo
	 * @param pageindex
	 * @param itemcount
	 * @param token
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Produces({ "text/plain;charset=utf-8" })
	@Path("chart")
	@Named(value = "手机测速")
	public String speedChartWithGet(@QueryParam(DataAbstarctParam.type) int type, @QueryParam(DataAbstarctParam.starttime) String starttime, @QueryParam(DataAbstarctParam.endtime) String endtime, @QueryParam(DataAbstarctParam.timeunit) String timeunit,
			@QueryParam(DataAbstarctParam.areainfo) String areainfo, @QueryParam(DataAbstarctParam.pageindex) int pageindex, @QueryParam(DataAbstarctParam.itemcount) int itemcount, @QueryParam(DataAbstarctParam.token) String token) {
		ErrorWrap result = new ErrorWrap();// 返回结果
		// 权限验证
		boolean isSucc = tokenControl.isValid(token, result);
		if (!isSucc) {
			if (result.error == null) {
				result.error = RestError.TOKEN_ERROR;
			}
			return result.error.toString();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
		if (times == null || times.length != 2) {
			logger.warn("enbParameterWithGet 时间参数不正确!" + starttime + "@" + endtime);
			result.error = RestError.PARAM_ERROR;
			result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
			return result.toString();
		}
		try {
			SimpleDateFormat sdf=new SimpleDateFormat(DateUtil.dtSimple);
			String max=extCustomProcessDAO.queryForObject("MULTI-QUERY-INDEX-CHART-MAXDAY-SQL-LIST-WITH-MAPPING-PAGING", null).toString();
			Date maxD=sdf.parse(max);
			Date endD=sdf.parse(endtime);
			if(maxD.before(endD)){
				Calendar c = Calendar.getInstance();
				c.setTime(maxD);
				c.add(Calendar.DAY_OF_MONTH, 1);
				times[1]=sdf.format(c.getTime());
				c.add(Calendar.DAY_OF_MONTH, -7);
				times[0]=sdf.format(c.getTime());
			}
		} catch (ParseException e) {
			logger.error("日期参数不正确");
		}
		params.put("startTime", times[0]);
		params.put("endTime", times[1]);
		params.put("city", areainfo);
		// 全省数据概览查询
		List<Map<String, Object>> list = extCustomProcessDAO.getMapList("MULTI-QUERY-INDEX-CHART-SQL-LIST-WITH-MAPPING-PAGING", params);// 图表数据
		JSONObject res = new JSONObject();
		res.put("list", JSON.toJSON(list));
		res.put("times", times);
		res.put("message", "成功");
		res.put("result", 0);
		return JSONObject.toJSONString(res, features);
	}
}
