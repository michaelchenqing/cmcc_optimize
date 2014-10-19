/**  
 * ReportResource.java
 * com.cmcc.optimize.dataapi.resources
 * 
 * @author yuminglang
 * @date 2014年7月22日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.resources;

import java.util.ArrayList;
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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;
import com.cmcc.optimize.dataapi.ErrorWrap;
import com.cmcc.optimize.dataapi.ErrorWrap.RestError;
import com.cmcc.optimize.dataapi.TokenControl;
import com.cmcc.optimize.dataapi.entity.AbstractEntity;
import com.cmcc.optimize.dataapi.entity.AnalysisEntity;
import com.cmcc.optimize.dataapi.param.AppStatusParam;
import com.cmcc.optimize.dataapi.param.DataAbstarctParam;
import com.cmcc.optimize.dataapi.param.DataAmountParam;
import com.cmcc.optimize.dataapi.param.DataAnalysisParam;
import com.cmcc.optimize.dataapi.param.FileSizeParam;
import com.cmcc.optimize.dataapi.param.PlanNowVolParam;
import com.cmcc.optimize.dataapi.param.ReportParam;
import com.cmcc.optimize.dataapi.param.SignalParam;

/**
 * Report rest接口服务
 * 
 * @author yuminglang
 */
@Path("report")
@Singleton
// 单例
public class ReportResource {
    private static final CmccLogger logger = CmccLogger.getLogger(ReportResource.class);

    private TokenControl tokenControl = new TokenControl();// 权限控制

    
    public static Map cacheData=new HashMap();
    
    private static ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtCustomProcessDAO.class, "extCustomProcessDAO");// 扩展查询dao

    private SerializerFeature[] features = new SerializerFeature[] { SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty };// 输出格式定义

    /**
     * 数据概况 post 参数描述参见：@see EnbParameterParam.class
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
    @Path("abstract")
    @Named(value="数据报表")
    public String reportAbstractWithPost(@QueryParam(DataAbstarctParam.type) int type, @QueryParam(DataAbstarctParam.starttime) String starttime, @QueryParam(DataAbstarctParam.endtime) String endtime, @QueryParam(DataAbstarctParam.timeunit) String timeunit,
            @QueryParam(DataAbstarctParam.areainfo) String areainfo, @QueryParam(DataAbstarctParam.pageindex) int pageindex, @QueryParam(DataAbstarctParam.itemcount) int itemcount, @QueryParam(DataAbstarctParam.token) String token) {
        return reportAbstractWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 数据概况  get 参数描述参见：@see DataAbstarctParam.class
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
    @Path("abstract")
    @Named(value="数据报表")
    public String reportAbstractWithGet(@QueryParam(DataAbstarctParam.type) int type, @QueryParam(DataAbstarctParam.starttime) String starttime, @QueryParam(DataAbstarctParam.endtime) String endtime, @QueryParam(DataAbstarctParam.timeunit) String timeunit,
            @QueryParam(DataAbstarctParam.areainfo) String areainfo, @QueryParam(DataAbstarctParam.pageindex) int pageindex, @QueryParam(DataAbstarctParam.itemcount) int itemcount, @QueryParam(DataAbstarctParam.token) String token) {

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

        JSONObject res = new JSONObject();
        JSONArray array = new JSONArray();
        List<Map<String, Object>> list = (List<Map<String, Object>>)ReportResource.cacheData.get("reportAbstractWithGet");
        try {
        	AbstractEntity abstractEntity = new AbstractEntity();
            for (Map<String, Object> map : list) {
            	abstractEntity.setToday(map.get("TODAY")==null?0:Integer.parseInt(map.get("TODAY").toString()));
            	abstractEntity.setDays7(map.get("DAYS7")==null?0:Integer.parseInt(map.get("DAYS7").toString()));
            	abstractEntity.setAllNum(map.get("ALLNUM")==null?0:Integer.parseInt(map.get("ALLNUM").toString()));
            	abstractEntity.setType(map.get("TYPE").toString());
                array.add(JSON.toJSON(abstractEntity));
            }
        } catch (Exception e) {
            logger.error("type:" + type, e);
            result.error = RestError.OTHER_ERROR;
            result.setErrMsg(e.toString());
            return result.error.toString();
        }
        // 输出的json字符串构造
        res.put("list", array);
        res.put("message", "成功");
        res.put("result", 0);

        return JSONObject.toJSONString(res, features);
    }
    /**
     * 数据质量分析 post 参数描述参见：@see DataAnalysisParam.class
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
    @Path("analysis")
    @Named(value="数据报表")
    public String dataAnalysisWithPost(@QueryParam(DataAnalysisParam.type) int type, @QueryParam(DataAnalysisParam.starttime) String starttime, @QueryParam(DataAnalysisParam.endtime) String endtime, @QueryParam(DataAnalysisParam.timeunit) String timeunit,
    		@QueryParam(DataAnalysisParam.areainfo) String areainfo, @QueryParam(DataAnalysisParam.pageindex) int pageindex, @QueryParam(DataAnalysisParam.itemcount) int itemcount, @QueryParam(DataAnalysisParam.token) String token) {
    	return dataAnalysisWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 数据质量分析 get 参数描述参见：@see DataAnalysisParam.class
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
    @Path("analysis")
    @Named(value="数据报表")
    public String dataAnalysisWithGet(@QueryParam(DataAnalysisParam.type) int type, @QueryParam(DataAnalysisParam.starttime) String starttime, @QueryParam(DataAnalysisParam.endtime) String endtime, @QueryParam(DataAnalysisParam.timeunit) String timeunit,
    		@QueryParam(DataAnalysisParam.areainfo) String areainfo, @QueryParam(DataAnalysisParam.pageindex) int pageindex, @QueryParam(DataAnalysisParam.itemcount) int itemcount, @QueryParam(DataAnalysisParam.token) String token) {
    	
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
    	
    	JSONObject res = new JSONObject();
    	JSONArray array = new JSONArray();
    	List<Map<String, Object>> list = (List<Map<String, Object>>)ReportResource.cacheData.get("dataAnalysisWithGet");
    	try {
    		AnalysisEntity analysisEntity = new AnalysisEntity();
    		for (Map<String, Object> map : list) {
    			analysisEntity.setInputRate(map.get("INPUT_RATE")==null?0:Integer.parseInt(map.get("INPUT_RATE").toString()));
    			analysisEntity.setSuccRate(map.get("SUCC_RATE")==null?0:Integer.parseInt(map.get("SUCC_RATE").toString()));
    			analysisEntity.setType(map.get("TYPE").toString());
    			analysisEntity.setRecordTime(map.get("RECORD_TIME").toString().substring(4,6)+"/"+map.get("RECORD_TIME").toString().substring(6,8));
    			array.add(JSON.toJSON(analysisEntity));
    		}
    	} catch (Exception e) {
    		logger.error("type:" + type, e);
    		result.error = RestError.OTHER_ERROR;
    		result.setErrMsg(e.toString());
    		return result.error.toString();
    	}
    	// 输出的json字符串构造
    	res.put("list", array);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }
    /**
     * 数据总量 post 参数描述参见：@see DataFileSize.class
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
    @Path("filesize")
    @Named(value="数据报表")
    public String fileSizeWithPost(@QueryParam(FileSizeParam.type) int type, @QueryParam(FileSizeParam.starttime) String starttime, @QueryParam(FileSizeParam.endtime) String endtime, @QueryParam(FileSizeParam.timeunit) String timeunit,
    		@QueryParam(FileSizeParam.areainfo) String areainfo, @QueryParam(FileSizeParam.pageindex) int pageindex, @QueryParam(FileSizeParam.itemcount) int itemcount, @QueryParam(FileSizeParam.token) String token) {
    	return fileSizeWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 数据总量 get 参数描述参见：@see DataFileSize.class
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
    @Path("filesize")
    @Named(value="数据报表")
    public String fileSizeWithGet(@QueryParam(FileSizeParam.type) int type, @QueryParam(FileSizeParam.starttime) String starttime, @QueryParam(FileSizeParam.endtime) String endtime, @QueryParam(FileSizeParam.timeunit) String timeunit,
    		@QueryParam(FileSizeParam.areainfo) String areainfo, @QueryParam(FileSizeParam.pageindex) int pageindex, @QueryParam(FileSizeParam.itemcount) int itemcount, @QueryParam(FileSizeParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	List<Map<String, Object>> list = (List<Map<String, Object>>)ReportResource.cacheData.get("fileSizeWithGet");
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }
    /**
     * 应用支撑情况 post 参数描述参见：@see AppStatusParam.class
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
    @Path("appstatus")
    @Named(value="数据报表")
    public String appStatusWithPost(@QueryParam(AppStatusParam.type) int type, @QueryParam(AppStatusParam.starttime) String starttime, @QueryParam(AppStatusParam.endtime) String endtime, @QueryParam(AppStatusParam.timeunit) String timeunit,
    		@QueryParam(AppStatusParam.areainfo) String areainfo, @QueryParam(AppStatusParam.pageindex) int pageindex, @QueryParam(AppStatusParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	return appStatusWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 应用支撑情况 get 参数描述参见：@see AppStatusParam.class
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
    @Path("appstatus")
    @Named(value="数据报表")
    public String appStatusWithGet(@QueryParam(AppStatusParam.type) int type, @QueryParam(AppStatusParam.starttime) String starttime, @QueryParam(AppStatusParam.endtime) String endtime, @QueryParam(AppStatusParam.timeunit) String timeunit,
    		@QueryParam(AppStatusParam.areainfo) String areainfo, @QueryParam(AppStatusParam.pageindex) int pageindex, @QueryParam(AppStatusParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	List list = (List)ReportResource.cacheData.get("appStatusWithGet");
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }
    /**
     * 数据量趋势分析 post 参数描述参见：@see DataAmountParam.class
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
    @Path("dataamount")
    @Named(value="数据报表")
    public String dataAmountWithPost(@QueryParam(DataAmountParam.type) int type, @QueryParam(DataAmountParam.starttime) String starttime, @QueryParam(DataAmountParam.endtime) String endtime, @QueryParam(DataAmountParam.timeunit) String timeunit,
    		@QueryParam(DataAmountParam.areainfo) String areainfo, @QueryParam(DataAmountParam.pageindex) int pageindex, @QueryParam(DataAmountParam.itemcount) int itemcount, @QueryParam(DataAmountParam.token) String token) {
    	return dataAmountWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 数据量趋势分析 get 参数描述参见：@see DataAmountParam.class
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
    @Path("dataamount")
    @Named(value="数据报表")
    public String dataAmountWithGet(@QueryParam(DataAmountParam.type) int type, @QueryParam(DataAmountParam.starttime) String starttime, @QueryParam(DataAmountParam.endtime) String endtime, @QueryParam(DataAmountParam.timeunit) String timeunit,
    		@QueryParam(DataAmountParam.areainfo) String areainfo, @QueryParam(DataAmountParam.pageindex) int pageindex, @QueryParam(DataAmountParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	List list = (List)ReportResource.cacheData.get("dataAmountWithGet");
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }
    /**
     * 规划现网话统 post 参数描述参见：@see PlanNowVolParam.class
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
    @Path("plannowvol")
    @Named(value="数据报表")
    public String planNowVolWithPost(@QueryParam(PlanNowVolParam.type) int type, @QueryParam(PlanNowVolParam.starttime) String starttime, @QueryParam(PlanNowVolParam.endtime) String endtime, @QueryParam(PlanNowVolParam.timeunit) String timeunit,
    		@QueryParam(PlanNowVolParam.areainfo) String areainfo, @QueryParam(PlanNowVolParam.pageindex) int pageindex, @QueryParam(PlanNowVolParam.itemcount) int itemcount, @QueryParam(PlanNowVolParam.token) String token) {
    	return planNowVolWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 规划现网话统 get 参数描述参见：@see PlanNowVolParam.class
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
    @Path("plannowvol")
    @Named(value="数据报表")
    public String planNowVolWithGet(@QueryParam(PlanNowVolParam.type) int type, @QueryParam(PlanNowVolParam.starttime) String starttime, @QueryParam(PlanNowVolParam.endtime) String endtime, @QueryParam(PlanNowVolParam.timeunit) String timeunit,
    		@QueryParam(PlanNowVolParam.areainfo) String areainfo, @QueryParam(PlanNowVolParam.pageindex) int pageindex, @QueryParam(PlanNowVolParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	List list = (List)ReportResource.cacheData.get("planNowVolWithGet");
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }
    /**
     * 规划现网话统  各当天地市数据质量分析post 参数描述参见：@see PlanNowVolParam.class
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
    @Path("plannowvoltab")
    @Named(value="数据报表")
    public String planNowVolTabWithPost(@QueryParam(PlanNowVolParam.type) int type, @QueryParam(PlanNowVolParam.starttime) String starttime, @QueryParam(PlanNowVolParam.endtime) String endtime, @QueryParam(PlanNowVolParam.timeunit) String timeunit,
    		@QueryParam(PlanNowVolParam.areainfo) String areainfo, @QueryParam(PlanNowVolParam.pageindex) int pageindex, @QueryParam(PlanNowVolParam.itemcount) int itemcount, @QueryParam(PlanNowVolParam.token) String token) {
    	return planNowVolTabWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 规划现网话统  各当天地市数据质量分析 get 参数描述参见：@see PlanNowVolParam.class
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
    @Path("plannowvoltab")
    @Named(value="数据报表")
    public String planNowVolTabWithGet(@QueryParam(PlanNowVolParam.type) int type, @QueryParam(PlanNowVolParam.starttime) String starttime, @QueryParam(PlanNowVolParam.endtime) String endtime, @QueryParam(PlanNowVolParam.timeunit) String timeunit,
    		@QueryParam(PlanNowVolParam.areainfo) String areainfo, @QueryParam(PlanNowVolParam.pageindex) int pageindex, @QueryParam(PlanNowVolParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	List list = extCustomProcessDAO.getMapList("MULTI-QUERY-PLANNOWVOLTAB-SQL-LIST-WITH-MAPPING-PAGING",null);
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }
    /**
     * 规划现网话统  各当天地市数据质量分析post 参数描述参见：@see ReportParam.class
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
    @Path("reportmro")
    @Named(value="数据报表")
    public String reportMroWithPost(@QueryParam(ReportParam.type) int type, @QueryParam(ReportParam.starttime) String starttime, @QueryParam(ReportParam.endtime) String endtime, @QueryParam(ReportParam.timeunit) String timeunit,
    		@QueryParam(ReportParam.areainfo) String areainfo, @QueryParam(ReportParam.pageindex) int pageindex, @QueryParam(ReportParam.itemcount) int itemcount, @QueryParam(ReportParam.token) String token) {
    	return reportMroWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 规划现网话统  各当天地市数据质量分析 get 参数描述参见：@see ReportParam.class
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
    @Path("reportmro")
    @Named(value="数据报表")
    public String reportMroWithGet(@QueryParam(ReportParam.type) int type, @QueryParam(ReportParam.starttime) String starttime, @QueryParam(ReportParam.endtime) String endtime, @QueryParam(ReportParam.timeunit) String timeunit,
    		@QueryParam(ReportParam.areainfo) String areainfo, @QueryParam(ReportParam.pageindex) int pageindex, @QueryParam(ReportParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	List list =null;
    	if(type==1){    		
    		list = (List) ReportResource.cacheData.get("reportMroWithGet_type1");
    	}else if(type==2){
    		list = (List) ReportResource.cacheData.get("reportMroWithGet_type2");
    		//list = extCustomProcessDAO.getMapList("MULTI-QUERY-REPORTMROFS-SQL-LIST-WITH-MAPPING-PAGING",null);
    	}else if(type==3){    		
    		list = (List) ReportResource.cacheData.get("reportMroWithGet_type3");
    		//list = extCustomProcessDAO.getMapList("MULTI-QUERY-REPORTMROTAB-SQL-LIST-WITH-MAPPING-PAGING",null);
    	}
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }
    /**
     * 信令 各地市数据量分析 post 参数描述参见：@see SignalParam.class
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
    @Path("signal")
    @Named(value="数据报表")
    public String signalWithPost(@QueryParam(SignalParam.type) int type, @QueryParam(SignalParam.starttime) String starttime, @QueryParam(SignalParam.endtime) String endtime, @QueryParam(SignalParam.timeunit) String timeunit,
    		@QueryParam(SignalParam.areainfo) String areainfo, @QueryParam(SignalParam.pageindex) int pageindex, @QueryParam(SignalParam.itemcount) int itemcount, @QueryParam(SignalParam.token) String token) {
    	return signalWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 信令 各地市数据量分析  get 参数描述参见：@see SignalParam.class
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
    @Path("signal")
    @Named(value="数据报表")
    public String signalWithGet(@QueryParam(SignalParam.type) int type, @QueryParam(SignalParam.starttime) String starttime, @QueryParam(SignalParam.endtime) String endtime, @QueryParam(SignalParam.timeunit) String timeunit,
    		@QueryParam(SignalParam.areainfo) String areainfo, @QueryParam(SignalParam.pageindex) int pageindex, @QueryParam(SignalParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	//List list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SIGNAL-SQL-LIST-WITH-MAPPING-PAGING",null);
    	List list=(List)ReportResource.cacheData.get("signalWithGet");
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }
    /**
     * TD/GSM最近14天数据量走势&单验最近14天数据量走势&扫频最近14周数据量 post 参数描述参见：@see ReportParam.class
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
    @Path("amount14data")
    @Named(value="数据报表")
    public String amount14DataWithPost(@QueryParam(ReportParam.type) int type, @QueryParam(ReportParam.starttime) String starttime, @QueryParam(ReportParam.endtime) String endtime, @QueryParam(ReportParam.timeunit) String timeunit,@QueryParam(ReportParam.areainfo) String areainfo, @QueryParam(ReportParam.pageindex) int pageindex, @QueryParam(ReportParam.itemcount) int itemcount, @QueryParam(ReportParam.token) String token) {
    	return amount14DataWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * TD/GSM最近14天数据量走势&单验最近14天数据量走势&扫频最近14周数据量  get 参数描述参见：@see ReportParam.class
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
    @Path("amount14data")
    @Named(value="数据报表")
    public String amount14DataWithGet(@QueryParam(ReportParam.type) int type, @QueryParam(ReportParam.starttime) String starttime, @QueryParam(ReportParam.endtime) String endtime, @QueryParam(ReportParam.timeunit) String timeunit,@QueryParam(ReportParam.areainfo) String areainfo, @QueryParam(ReportParam.pageindex) int pageindex, @QueryParam(ReportParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	List list =new ArrayList();
    	if(1==type){
    		list  = extCustomProcessDAO.getMapList("MULTI-QUERY-TD-GSM-SQL-LIST-WITH-MAPPING-PAGING",null);    		
    	}else if(2==type){    		
    		list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SINGLETON-SQL-LIST-WITH-MAPPING-PAGING",null);    		
    	}else if(3==type){
    		list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SCANFREQ-SQL-LIST-WITH-MAPPING-PAGING",null);    		    		
    	}
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }    
    /**
     * 各地市数据对比 post 参数描述参见：@see ReportParam.class
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
    @Path("allcitydata")
    @Named(value="数据报表")
    public String allCityDataWithPost(@QueryParam(ReportParam.type) int type, @QueryParam(ReportParam.starttime) String starttime, @QueryParam(ReportParam.endtime) String endtime, @QueryParam(ReportParam.timeunit) String timeunit,@QueryParam(ReportParam.areainfo) String areainfo, @QueryParam(ReportParam.pageindex) int pageindex, @QueryParam(ReportParam.itemcount) int itemcount, @QueryParam(ReportParam.token) String token) {
    	return allCityDataWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 各地市数据对比  get 参数描述参见：@see ReportParam.class
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
    @Path("allcitydata")
    @Named(value="数据报表")
    public String allCityDataWithGet(@QueryParam(ReportParam.type) int type, @QueryParam(ReportParam.starttime) String starttime, @QueryParam(ReportParam.endtime) String endtime, @QueryParam(ReportParam.timeunit) String timeunit,@QueryParam(ReportParam.areainfo) String areainfo, @QueryParam(ReportParam.pageindex) int pageindex, @QueryParam(ReportParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	List list =new ArrayList();
    	if(1==type){
    		list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SCANFREQ-CITY-SQL-LIST-WITH-MAPPING-PAGING",null);    		
    	}else if(2==type){    		
    		list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SINGLETON-CITY-SQL-LIST-WITH-MAPPING-PAGING",null);    		
    	}else if(3==type){
    		list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SCANFREQ-SQL-LIST-WITH-MAPPING-PAGING",null);    		    		
    	}
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }    
    /**
     * 数据质量分析 post 参数描述参见：@see ReportParam.class
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
    @Path("alldataanalysis")
    @Named(value="数据报表")
    public String allDataAnalysisWithPost(@QueryParam(ReportParam.type) int type, @QueryParam(ReportParam.starttime) String starttime, @QueryParam(ReportParam.endtime) String endtime, @QueryParam(ReportParam.timeunit) String timeunit,@QueryParam(ReportParam.areainfo) String areainfo, @QueryParam(ReportParam.pageindex) int pageindex, @QueryParam(ReportParam.itemcount) int itemcount, @QueryParam(ReportParam.token) String token) {
    	return allDataAnalysisWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 数据质量分析  get 参数描述参见：@see ReportParam.class
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
    @Path("alldataanalysis")
    @Named(value="数据报表")
    public String allDataAnalysisWithGet(@QueryParam(ReportParam.type) int type, @QueryParam(ReportParam.starttime) String starttime, @QueryParam(ReportParam.endtime) String endtime, @QueryParam(ReportParam.timeunit) String timeunit,@QueryParam(ReportParam.areainfo) String areainfo, @QueryParam(ReportParam.pageindex) int pageindex, @QueryParam(ReportParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	List list =new ArrayList();
    	if(1==type){
    		list  = extCustomProcessDAO.getMapList("MULTI-QUERY-TD-GSM-INPUT-CITY-SQL-LIST-WITH-MAPPING-PAGING",null);    		
    	}else if(2==type){    		
    		list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SINGLETON-ANAL-CITY-SQL-LIST-WITH-MAPPING-PAGING",null);    		
    	}else if(3==type){
    		list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SCANFREQ-SQL-LIST-WITH-MAPPING-PAGING",null);    		    		
    	}
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }   
    /**
     * 地市数据质量分析（表格） post 参数描述参见：@see ReportParam.class
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
    @Path("tabanalysis")
    @Named(value="数据报表")
    public String tabAnalysisWithPost(@QueryParam(ReportParam.type) int type, @QueryParam(ReportParam.starttime) String starttime, @QueryParam(ReportParam.endtime) String endtime, @QueryParam(ReportParam.timeunit) String timeunit,@QueryParam(ReportParam.areainfo) String areainfo, @QueryParam(ReportParam.pageindex) int pageindex, @QueryParam(ReportParam.itemcount) int itemcount, @QueryParam(ReportParam.token) String token) {
    	return tabAnalysisWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }
    
    /**
     * 地市数据质量分析（表格）  get 参数描述参见：@see ReportParam.class
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
    @Path("tabanalysis")
    @Named(value="数据报表")
    public String tabAnalysisWithGet(@QueryParam(ReportParam.type) int type, @QueryParam(ReportParam.starttime) String starttime, @QueryParam(ReportParam.endtime) String endtime, @QueryParam(ReportParam.timeunit) String timeunit,@QueryParam(ReportParam.areainfo) String areainfo, @QueryParam(ReportParam.pageindex) int pageindex, @QueryParam(ReportParam.itemcount) int itemcount, @QueryParam(AppStatusParam.token) String token) {
    	
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
    	JSONObject res = new JSONObject();
    	List list =new ArrayList();
    	if(1==type){
    		list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SINGLETON-ANAL-CITY-TAB-SQL-LIST-WITH-MAPPING-PAGING",null);    		
    	}else if(2==type){    		
    		//list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SINGLETON-ANAL-CITY-SQL-LIST-WITH-MAPPING-PAGING",null);    		
    	}else if(3==type){
    	//	list  = extCustomProcessDAO.getMapList("MULTI-QUERY-SCANFREQ-SQL-LIST-WITH-MAPPING-PAGING",null);    		    		
    	}
    	res.put("list", list);
    	res.put("message", "成功");
    	res.put("result", 0);
    	
    	return JSONObject.toJSONString(res, features);
    }   
    
    
    
    
}
