/**  
 * ExpVolReductionResource.java
 * com.cmcc.optimize.dataapi.resources
 * 
 * @author yuminglang
 * @date 2014年8月13日 上午08:55:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.resources;

import java.util.HashMap;
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
import com.cmcc.optimize.dataapi.param.ExpVolReductionParam;
import com.cmcc.optimize.datamodel.paging.PageList;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * 扩减容 rest接口服务
 * 
 * @author yuminglang
 */
@Path("optimze")
@Singleton
// 单例
public class ExpVolReductionResource {
	private static final CmccLogger logger = CmccLogger.getLogger(ExpVolReductionResource.class);

	private TokenControl tokenControl = new TokenControl();// 权限控制

	private static ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtCustomProcessDAO.class, "extCustomProcessDAO");// 扩展查询dao

	private SerializerFeature[] features = new SerializerFeature[] { SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty };// 输出格式定义

	/**
	 * 扩减容 post 参数描述参见：@see ExpVolReductionParam.class
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
	@Path("expvolreduction")
	@Named(value = "扩减容")
	public String expVolReductionWithPost(@QueryParam(ExpVolReductionParam.type) String type, @QueryParam(ExpVolReductionParam.starttime) String starttime, @QueryParam(ExpVolReductionParam.endtime) String endtime, @QueryParam(ExpVolReductionParam.timeunit) String timeunit, @QueryParam(ExpVolReductionParam.areainfo) String areainfo,
			@QueryParam(ExpVolReductionParam.pageindex) int pageindex, @QueryParam(ExpVolReductionParam.itemcount) int itemcount, @QueryParam(ExpVolReductionParam.token) String token) {
		return expVolReductionWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
	}

	/**
	 * 扩减容 get 参数描述参见：@see ExpVolReductionParam.class
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
	@Path("expvolreduction")
	@Named(value = "扩减容")
	public String expVolReductionWithGet(@QueryParam(ExpVolReductionParam.type) String type, @QueryParam(ExpVolReductionParam.starttime) String starttime, @QueryParam(ExpVolReductionParam.endtime) String endtime, @QueryParam(ExpVolReductionParam.timeunit) String timeunit, @QueryParam(ExpVolReductionParam.areainfo) String areainfo,
			@QueryParam(ExpVolReductionParam.pageindex) int pageindex, @QueryParam(ExpVolReductionParam.itemcount) int itemcount, @QueryParam(ExpVolReductionParam.token) String token) {
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
			logger.warn("expvolreduction 时间参数不正确!" + starttime + "@" + endtime);
			result.error = RestError.PARAM_ERROR;
			result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
			return result.toString();
		}
		params.put("startTime", times[0]);
		params.put("endTime", times[1]);

		// 分页查询
		Paginator paginator = new Paginator();
		paginator.setItemsPerPage(itemcount);
		paginator.setPage(pageindex);
		paginator.setItems(((Integer) extCustomProcessDAO.queryForObject("MULTI-QUERY-MB_"+type.toUpperCase()+"-SQL-LIST-WITH-MAPPING-COUNT", params)).intValue());
		PageList pageList = new PageList();
		pageList.setPaginator(paginator);
		try {
			if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
				params.put("startRow", new Integer(paginator.getBeginIndex()));
				params.put("endRow", new Integer(paginator.getEndIndex()));
				pageList.addAll(extCustomProcessDAO.getMapList("MULTI-QUERY-MB_"+type.toUpperCase()+"-SQL-LIST-WITH-MAPPING-PAGING", params));
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
}
