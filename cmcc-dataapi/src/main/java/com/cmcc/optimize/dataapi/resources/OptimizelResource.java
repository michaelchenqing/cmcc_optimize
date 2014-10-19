/**  
 * OptimizelResource.java
 * com.cmcc.optimize.dataapi.resources
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.resources;

import java.util.Arrays;
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

import oracle.sql.TIMESTAMP;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO;
import com.cmcc.optimize.dataaccess.dao.daointerface.MbOmcLoLaDAO;
import com.cmcc.optimize.dataaccess.dao.daointerface.MbPlanLtecellInfoDAO;
import com.cmcc.optimize.dataaccess.dao.daointerface.MbPlanLtesiteInfoDAO;
import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtecellInfoTDAO;
import com.cmcc.optimize.dataaccess.dao.daointerface.MbSysLtesiteInfoTDAO;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;
import com.cmcc.optimize.dataaccess.util.DateUtil;
import com.cmcc.optimize.dataapi.ErrorWrap;
import com.cmcc.optimize.dataapi.ErrorWrap.RestError;
import com.cmcc.optimize.dataapi.TokenControl;
import com.cmcc.optimize.dataapi.convert.ResultEntityConvert;
import com.cmcc.optimize.dataapi.entity.CellInfoEntity;
import com.cmcc.optimize.dataapi.entity.EnbInfoEntity;
import com.cmcc.optimize.dataapi.entity.EnbParameterEntity;
import com.cmcc.optimize.dataapi.entity.OmcLoLaEntity;
import com.cmcc.optimize.dataapi.entity.PlanEnbParameterEntity;
import com.cmcc.optimize.dataapi.entity.PlanLteCellEntity;
import com.cmcc.optimize.dataapi.entity.PlanParameterEntity;
import com.cmcc.optimize.dataapi.param.CellInfoParam;
import com.cmcc.optimize.dataapi.param.EnbInfoParam;
import com.cmcc.optimize.dataapi.param.EnbParameterParam;
import com.cmcc.optimize.dataapi.param.OmcLoLaParam;
import com.cmcc.optimize.dataapi.param.PlanEnbParameterParam;
import com.cmcc.optimize.dataapi.param.PlanLteCellParam;
import com.cmcc.optimize.dataapi.param.PlanParameterParam;
import com.cmcc.optimize.datamodel.paging.PageList;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * 网优rest接口服务
 * 
 * @author gaoqs
 */
@Path("optimze")
@Singleton
// 单例
public class OptimizelResource {
    private static final CmccLogger logger = CmccLogger.getLogger(OptimizelResource.class);

    private TokenControl tokenControl = new TokenControl();// 权限控制

    private static ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtCustomProcessDAO.class, "extCustomProcessDAO");// 扩展查询dao

    // private static MbSysLtecellInfoDAO mbSysLtecellInfoDAO = SpringBeanContext.getInstance().getBean(MbSysLtecellInfoDAO.class, "mbSysLtecellInfoDAO");// 小区信息查询dao

    private static MbPlanLtesiteInfoDAO mbPlanLtesiteInfoDAO = SpringBeanContext.getInstance().getBean(MbPlanLtesiteInfoDAO.class, "mbPlanLtesiteInfoDAO");// 规划工参查询dao

    // private static MbSysLtesiteParamDAO mbSysLtesiteParamDAO = SpringBeanContext.getInstance().getBean(MbSysLtesiteParamDAO.class, "mbSysLtesiteParamDAO");// 基站信息查询dao

    private static MbSysLtesiteInfoTDAO mbSysLtesiteInfoTDAO = SpringBeanContext.getInstance().getBean(MbSysLtesiteInfoTDAO.class, "mbSysLtesiteInfoTDAO");// 基站信息查询dao 临时的 后续会删除

    private static MbSysLtecellInfoTDAO mbSysLtecellInfoTDAO = SpringBeanContext.getInstance().getBean(MbSysLtecellInfoTDAO.class, "mbSysLtecellInfoTDAO");// 小区信息查询dao 临时的 后续会删除

    private static MbOmcLoLaDAO mbOmcLoLaDAO = SpringBeanContext.getInstance().getBean(MbOmcLoLaDAO.class, "mbOmcLoLaDAO");// OMC小区经纬度

    private static MbPlanLtecellInfoDAO mbPlanLtecellInfoDAO = SpringBeanContext.getInstance().getBean(MbPlanLtecellInfoDAO.class, "mbPlanLtecellInfoDAO");// 规划小区信息
    
    private SerializerFeature[] features = new SerializerFeature[] { SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty };//输出格式定义

    /**
     * 规划工参 post 参数描述参见：@see PlanEnbParameterParam.class
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
    @Path("planenbparameter")
    @Named(value="7天在线对标,工参对标,网络结构对标")
    public String planEnbParameterParamWithPost(@QueryParam(PlanEnbParameterParam.type) int type, @QueryParam(PlanEnbParameterParam.starttime) String starttime, @QueryParam(PlanEnbParameterParam.endtime) String endtime, @QueryParam(PlanEnbParameterParam.timeunit) String timeunit,
            @QueryParam(PlanEnbParameterParam.areainfo) String areainfo, @QueryParam(PlanEnbParameterParam.pageindex) int pageindex, @QueryParam(PlanEnbParameterParam.itemcount) int itemcount, @QueryParam(PlanEnbParameterParam.token) String token) {
        return planEnbParameterParamWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 规划工参 get 参数描述参见：@see PlanEnbParameterParam.class
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
    @GET
    @Produces({ "text/plain;charset=utf-8" })
    @Path("planenbparameter")
    @Named(value="7天在线对标,工参对标,网络结构对标")
    public String planEnbParameterParamWithGet(@QueryParam(PlanEnbParameterParam.type) int type, @QueryParam(PlanEnbParameterParam.starttime) String starttime, @QueryParam(PlanEnbParameterParam.endtime) String endtime, @QueryParam(PlanEnbParameterParam.timeunit) String timeunit,
            @QueryParam(PlanEnbParameterParam.areainfo) String areainfo, @QueryParam(PlanEnbParameterParam.pageindex) int pageindex, @QueryParam(PlanEnbParameterParam.itemcount) int itemcount, @QueryParam(PlanEnbParameterParam.token) String token) {

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

        // 分页信息
        if (pageindex <= 0) {
            pageindex = 1;
        }
        if (itemcount <= 0) {
            itemcount = 10;
        }
        List<PlanEnbParameterEntity> list = null;// <MbPlanLtesiteInfoDO>
        String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
        if (times == null) {
            logger.warn("planEnbParameterParamWithGet 时间参数不正确!" + starttime + "@" + endtime);
            result.error = RestError.PARAM_ERROR;
            result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
            return result.toString();
        }
        List<String> areaInfoList=null;
        if(StringUtils.isNotBlank(areainfo)){
            areaInfoList= Arrays.asList(areainfo.split(","));
        }
        try {
            PageList pageList = mbPlanLtesiteInfoDAO.getPlanInfobyParam(times[0], times[1], areaInfoList, itemcount, pageindex);

            // 循环对象转换
            list = ResultEntityConvert.planEnbParameterConvertWithList(pageList);

        } catch (Exception e) {
            logger.error("type:" + type, e);
            result.error = RestError.OTHER_ERROR;
            return result.error.toString();
        }
        // 输出的json字符串构造
        res.put("list", JSON.toJSON(list));
        res.put("message", "成功");
        res.put("result", 0);

        return JSONObject.toJSONString(res,features);
    }

    /**
     * 现网工参 post 参数描述参见：@see EnbParameterParam.class
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
    @Path("enbparameter")
    @Named(value="7天在线对标,工参对标,网络结构对标")
    public String enbParameterWithPost(@QueryParam(EnbParameterParam.type) int type, @QueryParam(EnbParameterParam.starttime) String starttime, @QueryParam(EnbParameterParam.endtime) String endtime, @QueryParam(EnbParameterParam.timeunit) String timeunit, @QueryParam(EnbParameterParam.areainfo) String areainfo,
            @QueryParam(EnbParameterParam.pageindex) int pageindex, @QueryParam(EnbParameterParam.itemcount) int itemcount, @QueryParam(EnbParameterParam.token) String token) {
        return enbParameterWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 现网工参 get 参数描述参见：@see EnbParameterParam.class
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
    @Path("enbparameter")
    @Named(value="7天在线对标,工参对标,网络结构对标")
    public String enbParameterWithGet(@QueryParam(EnbParameterParam.type) int type, @QueryParam(EnbParameterParam.starttime) String starttime, @QueryParam(EnbParameterParam.endtime) String endtime, @QueryParam(EnbParameterParam.timeunit) String timeunit, @QueryParam(EnbParameterParam.areainfo) String areainfo,
            @QueryParam(EnbParameterParam.pageindex) int pageindex, @QueryParam(EnbParameterParam.itemcount) int itemcount, @QueryParam(EnbParameterParam.token) String token) {

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
        JSONArray array = new JSONArray();

        Map<String, Object> params = new HashMap<String, Object>();
        String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
        if (times == null || times.length != 2) {
            logger.warn("enbParameterWithGet 时间参数不正确!" + starttime + "@" + endtime);
            result.error = RestError.PARAM_ERROR;
            result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
            return result.toString();
        }
        List<String> areaInfoList=null;
        if(StringUtils.isNotBlank(areainfo)){
            areaInfoList= Arrays.asList(areainfo.split(","));
        }
        params.put("startTime", times[0]);
        params.put("endTime", times[1]);
        params.put("list", areaInfoList);

        // 分页查询
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(itemcount);
        paginator.setPage(pageindex);

        paginator.setItems(((Integer) extCustomProcessDAO.queryForObject("MULTI-QUERY-PLANENBPARAMETER-SQL-LIST-WITH-MAPPING-COUNTS", params)).intValue());

        PageList pageList = new PageList();
        pageList.setPaginator(paginator);
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            params.put("startRow", new Integer(paginator.getBeginIndex()));
            params.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(extCustomProcessDAO.getMapList("MULTI-QUERY-PLANENBPARAMETER-SQL-LIST-WITH-MAPPING-PAGING", params));
        }

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            EnbParameterEntity enbParameterEntity = new EnbParameterEntity();
            for (int i = 0; i < pageList.size(); i++) {
                map = (Map<String, Object>) pageList.get(i);
                enbParameterEntity.setCity(map.get("CITY") == null ? null : map.get("CITY").toString());
                enbParameterEntity.setUid(map.get("UIDS") == null ? null : map.get("UIDS").toString());
                enbParameterEntity.setMindis(map.get("MINDIS") == null ? null :Float.parseFloat( map.get("MINDIS").toString()));
                enbParameterEntity.setGrid(map.get("GRID") == null ? null : map.get("GRID").toString());
                enbParameterEntity.setCgi(map.get("CGI") == null ? null : map.get("CGI").toString());
                enbParameterEntity.setPhase(map.get("PHASE") == null ? null : map.get("PHASE").toString());
                enbParameterEntity.setTilt(map.get("TILT") == null ? null :Integer.parseInt( map.get("TILT").toString()));
                enbParameterEntity.setAzimuth(map.get("AZIMUTH") == null ? null : Integer.parseInt(map.get("AZIMUTH").toString()));
                enbParameterEntity.setEtilt(map.get("ETILT") == null ? null :Integer.parseInt( map.get("ETILT").toString()));
                enbParameterEntity.setHeight(map.get("HEIGHT") == null ? null : Float.parseFloat(map.get("HEIGHT").toString()));
                enbParameterEntity.setLon(map.get("LON") == null ? null :Float.parseFloat( map.get("LON").toString()));
                enbParameterEntity.setLat(map.get("LAT") == null ? null : Float.parseFloat(map.get("LAT").toString()));
                enbParameterEntity.setWorkfreq(map.get("WORKFREQ") == null ? null : map.get("WORKFREQ").toString());
                enbParameterEntity.setCovertype(map.get("COVERTYPE") == null ? null : map.get("COVERTYPE").toString());
                String tsValue = null;
                if (map.get("TS") instanceof TIMESTAMP) {
                    tsValue = DateUtil.dtFormat(((TIMESTAMP) map.get("TS")).dateValue(), DateUtil.dtSimple) + " 00:00:00";
                }
                enbParameterEntity.setTs(tsValue);
                array.add(JSON.toJSON(enbParameterEntity));
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

        return JSONObject.toJSONString(res,features);
    }

    /**
     * 基站信息请求响应rest 参数描述，参见：@see EnbInfoParam.class post请求
     * 
     * @param type
     * @param starttime
     * @param endtime
     * @param timeunit
     * @param areainfo
     * @param pageindex
     * @return
     */
    @POST
    @Produces({ "text/plain;charset=utf-8" })
    @Path("enbinfo")
    @Named(value="网络结构对标")
    public String enbInfoWithPost(@QueryParam(EnbInfoParam.type) int type, @QueryParam(EnbInfoParam.starttime) String starttime, @QueryParam(EnbInfoParam.endtime) String endtime, @QueryParam(EnbInfoParam.timeunit) String timeunit, @QueryParam(EnbInfoParam.areainfo) String areainfo,
            @QueryParam(EnbInfoParam.pageindex) int pageindex, @QueryParam(EnbInfoParam.itemcount) int itemcount, @QueryParam(EnbInfoParam.token) String token) {
        return enbInfoWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 基站信息请求响应rest 参数描述，参见：@see EnbInfoParam.class get请求
     * 
     * @param type
     * @param starttime
     * @param endtime
     * @param timeunit
     * @param areainfo
     * @param pageindex
     * @return
     */
    @GET
    @Produces({ "text/plain;charset=utf-8" })
    @Path("enbinfo")
    @Named(value="网络结构对标")
    public String enbInfoWithGet(@QueryParam(EnbInfoParam.type) int type, @QueryParam(EnbInfoParam.starttime) String starttime, @QueryParam(EnbInfoParam.endtime) String endtime, @QueryParam(EnbInfoParam.timeunit) String timeunit, @QueryParam(EnbInfoParam.areainfo) String areainfo,
            @QueryParam(EnbInfoParam.pageindex) int pageindex, @QueryParam(EnbInfoParam.itemcount) int itemcount, @QueryParam(EnbInfoParam.token) String token) {
        if (logger.isInfoEnabled()) {
            logger.info("enbinfo:" + type);
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

        List<EnbInfoEntity> list = null;// <MbSysLtesiteParamDO>
        String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
        if (times == null || times.length != 2) {
            logger.warn("enbInfoWithGet 时间参数不正确!" + starttime + "@" + endtime);
            result.error = RestError.PARAM_ERROR;
            result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
            return result.toString();
        }
        List<String> areaInfoList=null;
        if(StringUtils.isNotBlank(areainfo)){
            areaInfoList= Arrays.asList(areainfo.split(","));
        }
        // 生成数据
        try {
            PageList pageList = mbSysLtesiteInfoTDAO.getLteSiteByParam_t(times[0], times[1],areaInfoList, itemcount, pageindex);// 临时的
                                                                                                                   // 后续删除
            // PageList pageList = mbSysLtesiteParamDAO.getLteSiteByParam(starttime, endtime, itemcount, pageindex);

            // 转换pagelist

            list = ResultEntityConvert.enbInfoTConvertWithList(pageList);
            // list = ResultEntityConvert.enbInfoConvertWithList(pageList);

        } catch (Exception e) {
            logger.error("type:" + type, e);
            result.error = RestError.OTHER_ERROR;
            result.setErrMsg(e.toString());
            return result.error.toString();
        }

        // 输出的json字符串构造
        res.put("result", 0);
        res.put("message", "success!!");
        res.put("list", JSON.toJSON(list));

        return JSONObject.toJSONString(res,features);
    }

    /**
     * 小区信息请求响应rest 参数描述，参见：@see CellInfoParam.class post请求
     * 
     * @param type
     * @param starttime
     * @param endtime
     * @param timeunit
     * @param areainfo
     * @param pageindex
     * @return
     */
    @POST
    @Produces({ "text/plain;charset=utf-8" })
    @Path("cellinfo")
    @Named(value="7天在线对标,网络结构对标")
    public String cellInfoWithPost(@QueryParam(CellInfoParam.type) int type, @QueryParam(CellInfoParam.starttime) String starttime, @QueryParam(CellInfoParam.endtime) String endtime, @QueryParam(CellInfoParam.timeunit) String timeunit, @QueryParam(CellInfoParam.areainfo) String areainfo,
            @QueryParam(CellInfoParam.pageindex) int pageindex, @QueryParam(CellInfoParam.itemcount) int itemcount, @QueryParam(CellInfoParam.token) String token) {
        return cellInfoWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 小区信息请求响应rest 参数描述，参见：@see CellInfoParam.class get请求
     * 
     * @param type
     * @param starttime
     * @param endtime
     * @param timeunit
     * @param areainfo
     * @param pageindex
     * @return
     */
    @GET
    @Produces({ "text/plain;charset=utf-8" })
    @Path("cellinfo")
    @Named(value="7天在线对标,网络结构对标")
    public String cellInfoWithGet(@QueryParam(CellInfoParam.type) int type, @QueryParam(CellInfoParam.starttime) String starttime, @QueryParam(CellInfoParam.endtime) String endtime, @QueryParam(CellInfoParam.timeunit) String timeunit, @QueryParam(CellInfoParam.areainfo) String areainfo,
            @QueryParam(CellInfoParam.pageindex) int pageindex, @QueryParam(CellInfoParam.itemcount) int itemcount, @QueryParam(CellInfoParam.token) String token) {

        if (logger.isInfoEnabled()) {
            logger.info("cellinfo:" + type);
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

        List<CellInfoEntity> list = null;// <MbSysLtecellInfoDO>
        String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
        if (times == null || times.length != 2) {
            logger.warn("enbInfoWithGet 时间参数不正确!" + starttime + "@" + endtime);
            result.error = RestError.PARAM_ERROR;
            result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
            return result.toString();
        }
        List<String> areaInfoList=null;
        if(StringUtils.isNotBlank(areainfo)){
            areaInfoList= Arrays.asList(areainfo.split(","));
        }
        // 生成数据
        try {

            PageList pageList = mbSysLtecellInfoTDAO.getLtecellByParam(times[0], times[1],areaInfoList, itemcount, pageindex); // 临时的
                                                                                                                  // 后续可能会删除
            // PageList pageList = mbSysLtecellInfoDAO.getLtecellByParam(starttime, endtime, itemcount, pageindex);

            // 转换pagelist
            list = ResultEntityConvert.cellInfoTConvertWithList(pageList);

        } catch (Exception e) {
            logger.error("type:" + type, e);
            result.error = RestError.OTHER_ERROR;
            result.setErrMsg(e.toString());
            return result.error.toString();
        }

        // 输出的json字符串构造
        res.put("result", 0);
        res.put("message", "success!!");
        res.put("list", JSON.toJSON(list));

        return JSONObject.toJSONString(res,features);
    }

    /**
     * OMC小区经纬度请求响应rest 参数描述，参见：@see OmcLoLaParam.class post请求
     * 
     * @param type
     * @param starttime
     * @param endtime
     * @param timeunit
     * @param areainfo
     * @param pageindex
     * @return
     */
    @POST
    @Produces({ "text/plain;charset=utf-8" })
    @Path("omclola")
    @Named(value="工参对标")
    public String omcLoLaWithPost(@QueryParam(OmcLoLaParam.type) int type, @QueryParam(OmcLoLaParam.starttime) String starttime, @QueryParam(OmcLoLaParam.endtime) String endtime, @QueryParam(OmcLoLaParam.timeunit) String timeunit, @QueryParam(OmcLoLaParam.areainfo) String areainfo,
            @QueryParam(OmcLoLaParam.pageindex) int pageindex, @QueryParam(OmcLoLaParam.itemcount) int itemcount, @QueryParam(OmcLoLaParam.token) String token) {
        return omcLoLaWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * OMC小区经纬度请求响应rest 参数描述，参见：@see OmcLoLaParam.class get请求
     * 
     * @param type
     * @param starttime
     * @param endtime
     * @param timeunit
     * @param areainfo
     * @param pageindex
     * @return
     */
    @GET
    @Produces({ "text/plain;charset=utf-8" })
    @Path("omclola")
    @Named(value="工参对标")
    public String omcLoLaWithGet(@QueryParam(OmcLoLaParam.type) int type, @QueryParam(OmcLoLaParam.starttime) String starttime, @QueryParam(OmcLoLaParam.endtime) String endtime, @QueryParam(OmcLoLaParam.timeunit) String timeunit, @QueryParam(OmcLoLaParam.areainfo) String areainfo,
            @QueryParam(OmcLoLaParam.pageindex) int pageindex, @QueryParam(OmcLoLaParam.itemcount) int itemcount, @QueryParam(OmcLoLaParam.token) String token) {

        if (logger.isInfoEnabled()) {
            logger.info("cellinfo:" + type);
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

        List<OmcLoLaEntity> list = null;// <MbSysLtecellInfoDO>
        
        String[] times = DateUtil.getCycle(starttime, starttime, timeunit);
        if (times == null || times.length <1 || times.length >2 ) {
            logger.warn("omcLoLaWithGet 时间参数不正确!" + starttime + "@" + endtime);
            result.error = RestError.PARAM_ERROR;
            result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
            return result.toString();
        }
        List<String> areaInfoList=null;
        if(StringUtils.isNotBlank(areainfo)){
            areaInfoList= Arrays.asList(areainfo.split(","));
        }
        // 生成数据
        try {
             int counter = (int) mbOmcLoLaDAO.getOmcLoLaMaxDate(starttime.substring(0, 10) + " 00:00:00");//数据库内是否有指定日期的数据
             System.out.println("counter"+counter);
            System.out.println("inputTime"+times[0]);
            PageList pageList = null;
            if (counter==0){
                 pageList = mbOmcLoLaDAO.getOmcLoLabyParam(areaInfoList,itemcount, pageindex);//如果没有就取当前表最新的数据
                
            }else {
                 pageList = mbOmcLoLaDAO.getOmcLoLabyDate(areaInfoList,starttime.substring(0, 10) + " 00:00:00",itemcount, pageindex);//如果有就按指定时间查询
	
            }
            
              // 转换pagelist
            list = ResultEntityConvert.omcLoLaConvertWithList(pageList);

        } catch (Exception e) {
            logger.error("type:" + type, e);
            result.error = RestError.OTHER_ERROR;
            result.setErrMsg(e.toString());
            return result.error.toString();
        }

        // 输出的json字符串构造
        res.put("result", 0);
        res.put("message", "success!!");
        res.put("list", JSON.toJSON(list));

        return JSONObject.toJSONString(res,features);
    }

    /**
     * 规划小区请求响应rest 参数描述，参见：@see PlanLteCellParam.class post请求
     * 
     * @param type
     * @param starttime
     * @param endtime
     * @param timeunit
     * @param areainfo
     * @param pageindex
     * @return
     */
    @POST
    @Produces({ "text/plain;charset=utf-8" })
    @Path("plancellinfo")
    @Named(value="网络结构对标")
    public String planCellInfoWithPost(@QueryParam(PlanLteCellParam.type) int type, @QueryParam(PlanLteCellParam.starttime) String starttime, @QueryParam(PlanLteCellParam.endtime) String endtime, @QueryParam(PlanLteCellParam.timeunit) String timeunit, @QueryParam(PlanLteCellParam.areainfo) String areainfo,
            @QueryParam(PlanLteCellParam.pageindex) int pageindex, @QueryParam(PlanLteCellParam.itemcount) int itemcount, @QueryParam(PlanLteCellParam.token) String token) {
        return planCellInfoWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 规划小区请求响应rest 参数描述，参见：@see PlanLteCellParam.class get请求
     * 
     * @param type
     * @param starttime
     * @param endtime
     * @param timeunit
     * @param areainfo
     * @param pageindex
     * @return
     */
    @GET
    @Produces({ "text/plain;charset=utf-8" })
    @Path("plancellinfo")
    @Named(value="网络结构对标")
    public String planCellInfoWithGet(@QueryParam(PlanLteCellParam.type) int type, @QueryParam(PlanLteCellParam.starttime) String starttime, @QueryParam(PlanLteCellParam.endtime) String endtime, @QueryParam(PlanLteCellParam.timeunit) String timeunit, @QueryParam(PlanLteCellParam.areainfo) String areainfo,
            @QueryParam(PlanLteCellParam.pageindex) int pageindex, @QueryParam(PlanLteCellParam.itemcount) int itemcount, @QueryParam(PlanLteCellParam.token) String token) {

        if (logger.isInfoEnabled()) {
            logger.info("cellinfo:" + type);
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

        List<PlanLteCellEntity> list = null;// <MbSysLtecellInfoDO>
        String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
        if (times == null || times.length != 2) {
            logger.warn("planCellInfoWithGet 时间参数不正确!" + starttime + "@" + endtime);
            result.error = RestError.PARAM_ERROR;
            result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
            return result.toString();
        }
        List<String> areaInfoList=null;
        if(StringUtils.isNotBlank(areainfo)){
            areaInfoList= Arrays.asList(areainfo.split(","));
        }
        // 生成数据
        try {
            PageList pageList = mbPlanLtecellInfoDAO.getPlanCellParam(areaInfoList,times[0],times[1], itemcount, pageindex);
            // 转换pagelist

            list = ResultEntityConvert.planLteCellConvertWithList(pageList);

        } catch (Exception e) {
            logger.error("type:" + type, e);
            result.error = RestError.OTHER_ERROR;
            result.setErrMsg(e.toString());
            return result.error.toString();
        }

        // 输出的json字符串构造
        res.put("result", 0);
        res.put("message", "success!!");
        res.put("list", JSON.toJSON(list));

        return JSONObject.toJSONString(res,features);
    }
    /**
     * 规划工参 post 参数描述参见：@see PlanParameterParam.class
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
    @Path("planparameter")
    @Named(value="单站验收")
    public String planParameterParamWithPost(@QueryParam(PlanParameterParam.type) int type, @QueryParam(PlanParameterParam.starttime) String starttime, @QueryParam(PlanParameterParam.endtime) String endtime, @QueryParam(PlanParameterParam.timeunit) String timeunit,
            @QueryParam(PlanParameterParam.areainfo) String areainfo, @QueryParam(PlanParameterParam.pageindex) int pageindex, @QueryParam(PlanParameterParam.itemcount) int itemcount, @QueryParam(PlanParameterParam.token) String token) {
        return PlanParameterParamWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 规划工参 get 参数描述参见：@see PlanParameterParam.class
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
    @GET
    @Produces({ "text/plain;charset=utf-8" })
    @Path("planparameter")
    @Named(value="单站验收")
    public String PlanParameterParamWithGet(@QueryParam(PlanParameterParam.type) int type, @QueryParam(PlanParameterParam.starttime) String starttime, @QueryParam(PlanParameterParam.endtime) String endtime, @QueryParam(PlanParameterParam.timeunit) String timeunit,
            @QueryParam(PlanParameterParam.areainfo) String areainfo, @QueryParam(PlanParameterParam.pageindex) int pageindex, @QueryParam(PlanParameterParam.itemcount) int itemcount, @QueryParam(PlanParameterParam.token) String token) {

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

        // 分页信息
        if (pageindex <= 0) {
            pageindex = 1;
        }
        if (itemcount <= 0) {
            itemcount = 10;
        }
        List<PlanParameterEntity> list = null;// <MbPlanLtesiteInfoDO>
        String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
        if (times == null) {
            logger.warn("planEnbParameterParamWithGet 时间参数不正确!" + starttime + "@" + endtime);
            result.error = RestError.PARAM_ERROR;
            result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
            return result.toString();
        }
        List<String> areaInfoList=null;
        if(StringUtils.isNotBlank(areainfo)){
            areaInfoList= Arrays.asList(areainfo.split(","));
        }
        try {
            PageList pageList = mbPlanLtesiteInfoDAO.getPlanInfobyParam(times[0], times[1], areaInfoList, itemcount, pageindex);

            // 循环对象转换
            list = ResultEntityConvert.planParameterConvertWithList(pageList);

        } catch (Exception e) {
            logger.error("type:" + type, e);
            result.error = RestError.OTHER_ERROR;
            return result.error.toString();
        }
        // 输出的json字符串构造
        res.put("list", JSON.toJSON(list));
        res.put("message", "成功");
        res.put("result", 0);
        return JSONObject.toJSONString(res,features);
    }
    

    /**
     * 规划工参 post 参数描述参见：@see PlanParameterParam.class
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
    @Path("singlestation")
    @Named(value="单验回传")
    public String singleStationWithPost(@QueryParam(PlanParameterParam.type) int type, @QueryParam(PlanParameterParam.starttime) String starttime, @QueryParam(PlanParameterParam.endtime) String endtime, @QueryParam(PlanParameterParam.timeunit) String timeunit,
            @QueryParam(PlanParameterParam.areainfo) String areainfo, @QueryParam(PlanParameterParam.pageindex) int pageindex, @QueryParam(PlanParameterParam.itemcount) int itemcount, @QueryParam(PlanParameterParam.token) String token) {
        return singleStationWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 规划工参 get 参数描述参见：@see PlanParameterParam.class
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
    @GET
    @Produces({ "text/plain;charset=utf-8" })
    @Path("singlestation")
    @Named(value="单验回传")
    public String singleStationWithGet(@QueryParam(PlanParameterParam.type) int type, @QueryParam(PlanParameterParam.starttime) String starttime, @QueryParam(PlanParameterParam.endtime) String endtime, @QueryParam(PlanParameterParam.timeunit) String timeunit,
            @QueryParam(PlanParameterParam.areainfo) String areainfo, @QueryParam(PlanParameterParam.pageindex) int pageindex, @QueryParam(PlanParameterParam.itemcount) int itemcount, @QueryParam(PlanParameterParam.token) String token) {
    	if (logger.isInfoEnabled()) {
			logger.info("singlestation:" + type);
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
			logger.warn("singlestation 时间参数不正确!" + starttime + "@" + endtime);
			result.error = RestError.PARAM_ERROR;
			result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
			return result.toString();
		}
		params.put("startTime", times[0]);
		params.put("endTime", times[1]);
	if (areainfo !=null){	
		String[] args = areainfo.split(",");
		String areas = "";
		for (int i=0;i<args.length;i++){
			areas += args[i]+"市,";		
		}
		 List<String> areaInfoList = null;
	        if (StringUtils.isNotBlank(areas)) {
	            areaInfoList = Arrays.asList(areas.substring(0,areas.length()-1).split(","));
	        }
		params.put("list", areaInfoList);
	}

		// 分页查询
		Paginator paginator = new Paginator();
		paginator.setItemsPerPage(itemcount);
		paginator.setPage(pageindex);
		paginator.setItems(((Integer) extCustomProcessDAO.queryForObject("MULTI-QUERY-SINGLE-SQL-LIST-WITH-MAPPING-COUNT", params)).intValue());
		PageList pageList = new PageList();
		pageList.setPaginator(paginator);
		try {
			if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
				params.put("startRow", new Integer(paginator.getBeginIndex()));
				params.put("endRow", new Integer(paginator.getEndIndex()));
				pageList.addAll(extCustomProcessDAO.getMapList("MULTI-QUERY-SINGLE-SQL-LIST-WITH-MAPPING-PAGING", params));
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
