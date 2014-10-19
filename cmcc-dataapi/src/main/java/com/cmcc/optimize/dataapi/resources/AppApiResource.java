/**  
 * AppApiResource.java
 * com.cmcc.optimize.dataapi.resources
 * 
 * @author yuminglang
 * @date 2014年7月9日 下午1:07:39
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
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;
import com.cmcc.optimize.dataaccess.util.DateUtil;
import com.cmcc.optimize.dataapi.ErrorWrap;
import com.cmcc.optimize.dataapi.ErrorWrap.RestError;
import com.cmcc.optimize.dataapi.TokenControl;
import com.cmcc.optimize.dataapi.entity.NetCellinfoEntity;
import com.cmcc.optimize.dataapi.entity.NetworkParameterEntity;
import com.cmcc.optimize.dataapi.entity.Plan7DaysOnlineEntity;
import com.cmcc.optimize.dataapi.param.NetCellinfoParam;
import com.cmcc.optimize.dataapi.param.NetworkParameterParam;
import com.cmcc.optimize.dataapi.param.Plan7DaysOnlineParam;
import com.cmcc.optimize.datamodel.paging.PageList;
import com.cmcc.optimize.datamodel.paging.Paginator;

/**
 * App rest接口服务
 * 
 * @author yuminglang
 */
@Path("optimze")
@Singleton
// 单例
public class AppApiResource {
    private static final CmccLogger logger = CmccLogger.getLogger(AppApiResource.class);

    private TokenControl tokenControl = new TokenControl();// 权限控制

    private static ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtCustomProcessDAO.class, "extCustomProcessDAO");// 扩展查询dao

    private SerializerFeature[] features = new SerializerFeature[] { SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty };// 输出格式定义

    /**
     * App 7天在线 post 参数描述参见：@see EnbParameterParam.class
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
    @Path("appchk7daysonline")
    @Named(value="7天在线App")
    public String app7DaysOnlineWithPost(@QueryParam(Plan7DaysOnlineParam.type) int type, @QueryParam(Plan7DaysOnlineParam.starttime) String starttime, @QueryParam(Plan7DaysOnlineParam.endtime) String endtime, @QueryParam(Plan7DaysOnlineParam.timeunit) String timeunit,
            @QueryParam(Plan7DaysOnlineParam.areainfo) String areainfo, @QueryParam(Plan7DaysOnlineParam.pageindex) int pageindex, @QueryParam(Plan7DaysOnlineParam.itemcount) int itemcount, @QueryParam(Plan7DaysOnlineParam.token) String token) {
        return app7DaysOnlineWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * App 7天在线 get 参数描述参见：@see Plan7DaysOnlineParam.class
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
    @Path("appchk7daysonline")
    @Named(value="7天在线App")
    public String app7DaysOnlineWithGet(@QueryParam(Plan7DaysOnlineParam.type) int type, @QueryParam(Plan7DaysOnlineParam.starttime) String starttime, @QueryParam(Plan7DaysOnlineParam.endtime) String endtime, @QueryParam(Plan7DaysOnlineParam.timeunit) String timeunit,
            @QueryParam(Plan7DaysOnlineParam.areainfo) String areainfo, @QueryParam(Plan7DaysOnlineParam.pageindex) int pageindex, @QueryParam(Plan7DaysOnlineParam.itemcount) int itemcount, @QueryParam(Plan7DaysOnlineParam.token) String token) {

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

        Map<String, Object> params = new HashMap<String, Object>();
        String[] times = DateUtil.getCycle(starttime, endtime, timeunit);
        if (times == null || times.length != 2) {
            logger.warn("enbParameterWithGet 时间参数不正确!" + starttime + "@" + endtime);
            result.error = RestError.PARAM_ERROR;
            result.setErrMsg("时间参数不正确,开始：" + starttime + "，结束：" + endtime);
            return result.toString();
        }
        List<String> areaInfoList = null;
        if (StringUtils.isNotBlank(areainfo)) {
            areaInfoList = Arrays.asList(areainfo.split(","));
        }
        params.put("startTime", times[0]);
        params.put("endTime", times[1]);
        params.put("list", areaInfoList);

        List<Map<String, Object>> list = extCustomProcessDAO.getMapList("MULTI-QUERY-PLAN7DAYSONLINE-SQL-LIST-WITH-MAPPING", params);
        try {
            Plan7DaysOnlineEntity plan7DaysOnlineEntity = new Plan7DaysOnlineEntity();
            for (Map<String, Object> map : list) {
                plan7DaysOnlineEntity.setCity(map.get("CITY") == null ? null : map.get("CITY").toString());
                plan7DaysOnlineEntity.setOnline7cnt(map.get("ONLINE7CNT") == null ? null : Integer.parseInt(map.get("ONLINE7CNT").toString()));
                plan7DaysOnlineEntity.setPhase(map.get("PHASE") == null ? null : map.get("PHASE").toString());
                plan7DaysOnlineEntity.setPlanenbscnt(map.get("PLANENBSCNT") == null ? null : Integer.parseInt(map.get("PLANENBSCNT").toString()));
                plan7DaysOnlineEntity.setRatio(map.get("RATIO") == null ? null : Float.parseFloat(map.get("RATIO").toString()));
                String tsValue = null;
                if (map.get("TS") instanceof TIMESTAMP) {
                    tsValue = DateUtil.dtFormat(((TIMESTAMP) map.get("TS")).dateValue(), DateUtil.dtSimple) + " 00:00:00";
                }
                plan7DaysOnlineEntity.setTs(tsValue);
                array.add(JSON.toJSON(plan7DaysOnlineEntity));
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
     * App 现网工参基站信息 post 参数描述参见：@see NetworkParameterParam.class
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
    @Path("networkparameter")
    @Named(value="现网工参基站信息")
    public String appNetWorkParameterWithPost(@QueryParam(NetworkParameterParam.type) int type, @QueryParam(NetworkParameterParam.starttime) String starttime, @QueryParam(NetworkParameterParam.endtime) String endtime, @QueryParam(NetworkParameterParam.timeunit) String timeunit,
            @QueryParam(NetworkParameterParam.areainfo) String areainfo, @QueryParam(NetworkParameterParam.pageindex) int pageindex, @QueryParam(NetworkParameterParam.itemcount) int itemcount, @QueryParam(NetworkParameterParam.token) String token) {
        return appNetworkParameterWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * App 现网工参基站信息 参数描述参见：@see NetworkParameterParam.class
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
    @Path("networkparameter")
    @Named(value="现网工参基站信息")
    public String appNetworkParameterWithGet(@QueryParam(NetworkParameterParam.type) int type, @QueryParam(NetworkParameterParam.starttime) String starttime, @QueryParam(NetworkParameterParam.endtime) String endtime, @QueryParam(NetworkParameterParam.timeunit) String timeunit,
            @QueryParam(NetworkParameterParam.areainfo) String areainfo, @QueryParam(NetworkParameterParam.pageindex) int pageindex, @QueryParam(NetworkParameterParam.itemcount) int itemcount, @QueryParam(NetworkParameterParam.token) String token) {

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
        List<String> areaInfoList = null;
        if (StringUtils.isNotBlank(areainfo)) {
            areaInfoList = Arrays.asList(areainfo.split(","));
        }
        params.put("startTime", times[0]);
        params.put("endTime", times[1]);
        params.put("list", areaInfoList);

        // 分页查询
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(itemcount);
        paginator.setPage(pageindex);

        paginator.setItems(((Integer) extCustomProcessDAO.queryForObject("MULTI-QUERY-NETWORKPARAMETER-SQL-LIST-WITH-MAPPING-COUNTS", params)).intValue());

        PageList pageList = new PageList();
        pageList.setPaginator(paginator);
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            params.put("startRow", new Integer(paginator.getBeginIndex()));
            params.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(extCustomProcessDAO.getMapList("MULTI-QUERY-NETWORKPARAMETER-SQL-LIST-WITH-MAPPING-PAGING", params));
        }
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            NetworkParameterEntity networkParameterEntity = new NetworkParameterEntity();
            for (int i = 0; i < pageList.size(); i++) {
                map = (Map<String, Object>) pageList.get(i);
                networkParameterEntity.setGid(map.get("GID") == null ? null : map.get("GID").toString());
                networkParameterEntity.setEnbid(map.get("ENBID") == null ? null : map.get("ENBID").toString());
                networkParameterEntity.setName(map.get("NAME") == null ? null : map.get("NAME").toString());
                networkParameterEntity.setTac(map.get("TAC") == null ? null : map.get("TAC").toString());
                networkParameterEntity.setVendor(map.get("VENDOR") == null ? null : map.get("VENDOR").toString());
                networkParameterEntity.setProv(map.get("PROV") == null ? null : map.get("PROV").toString());
                networkParameterEntity.setCity(map.get("CITY") == null ? null : map.get("CITY").toString());
                networkParameterEntity.setTown(map.get("TOWN") == null ? null : map.get("TOWN").toString());
                networkParameterEntity.setGrid(map.get("GRID") == null ? null : map.get("GRID").toString());
                networkParameterEntity.setPhase(map.get("PHASE") == null ? null : map.get("PHASE").toString());
                networkParameterEntity.setAddress(null);// map.get("")==null?"":map.get("").toString()
                networkParameterEntity.setLon(map.get("LON") == null ? null : Float.parseFloat(map.get("LON").toString()));
                networkParameterEntity.setLat(map.get("LAT") == null ? null : Float.parseFloat(map.get("LAT").toString()));
                networkParameterEntity.setMindis(map.get("MINDIS") == null ? null : Float.parseFloat(map.get("MINDIS").toString()));
                networkParameterEntity.setSinglepass(map.get("SINGLEPASS") == null ? null :map.get("SINGLEPASS").toString());
                networkParameterEntity.setCovertype(map.get("COVERTYPE") == null ? null : map.get("COVERTYPE").toString());
                networkParameterEntity.setEnv(map.get("ENV") == null ? null : map.get("ENV").toString());
                networkParameterEntity.setWorkfreq(map.get("WORKFREQ") == null ? null : map.get("WORKFREQ").toString());
                String tsValue = null;
                if (map.get("TS") instanceof TIMESTAMP) {
                    tsValue = DateUtil.dtFormat(((TIMESTAMP) map.get("TS")).dateValue(), DateUtil.dtSimple) + " 00:00:00";
                }
                networkParameterEntity.setRegiontype(map.get("REGIONTYPE")==null?null:map.get("REGIONTYPE").toString());
                networkParameterEntity.setTs(tsValue);
                array.add(JSON.toJSON(networkParameterEntity));
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
     * App 现网工参小区信息 post 参数描述参见：@see NetCellinfoParam.class
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
    @Path("netcellinfo")
    @Named(value="现网工参小区信息")
    public String appNetCellinfoWithPost(@QueryParam(NetCellinfoParam.type) int type, @QueryParam(NetCellinfoParam.starttime) String starttime, @QueryParam(NetCellinfoParam.endtime) String endtime, @QueryParam(NetCellinfoParam.timeunit) String timeunit, @QueryParam(NetCellinfoParam.areainfo) String areainfo,
            @QueryParam(NetCellinfoParam.pageindex) int pageindex, @QueryParam(NetCellinfoParam.itemcount) int itemcount, @QueryParam(NetCellinfoParam.token) String token) {
        return appNetCellinfoWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * App 现网工参小区信息 参数描述参见：@see NetCellinfoParam.class
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
    @Path("netcellinfo")
    @Named(value="现网工参小区信息")
    public String appNetCellinfoWithGet(@QueryParam(NetCellinfoParam.type) int type, @QueryParam(NetCellinfoParam.starttime) String starttime, @QueryParam(NetCellinfoParam.endtime) String endtime, @QueryParam(NetCellinfoParam.timeunit) String timeunit, @QueryParam(NetCellinfoParam.areainfo) String areainfo,
            @QueryParam(NetCellinfoParam.pageindex) int pageindex, @QueryParam(NetCellinfoParam.itemcount) int itemcount, @QueryParam(NetCellinfoParam.token) String token) {

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
        List<String> areaInfoList = null;
        if (StringUtils.isNotBlank(areainfo)) {
            areaInfoList = Arrays.asList(areainfo.split(","));
        }
        params.put("startTime", times[0]);
        params.put("endTime", times[1]);
        params.put("list", areaInfoList);

        // 分页查询
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(itemcount);
        paginator.setPage(pageindex);

        paginator.setItems(((Integer) extCustomProcessDAO.queryForObject("MULTI-QUERY-NETCELLINFO-SQL-LIST-WITH-MAPPING-COUNTS", params)).intValue());

        PageList pageList = new PageList();
        pageList.setPaginator(paginator);
        if (paginator.getItems() > 0 && paginator.getBeginIndex() <= paginator.getItems()) {
            params.put("startRow", new Integer(paginator.getBeginIndex()));
            params.put("endRow", new Integer(paginator.getEndIndex()));
            pageList.addAll(extCustomProcessDAO.getMapList("MULTI-QUERY-NETCELLINFO-SQL-LIST-WITH-MAPPING-PAGING", params));
        }
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            NetCellinfoEntity netCellinfoEntity = new NetCellinfoEntity();
            for (int i = 0; i < pageList.size(); i++) {
                map = (Map<String, Object>) pageList.get(i);
                netCellinfoEntity.setGid(map.get("GID") == null ? null : map.get("GID").toString());
                netCellinfoEntity.setGenbid(map.get("GENBID") == null ? null : map.get("GENBID").toString());
                netCellinfoEntity.setEnbid(map.get("ENBID") == null ? null : map.get("ENBID").toString());
                netCellinfoEntity.setCi(map.get("CI") == null ? null : map.get("CI").toString());
                netCellinfoEntity.setCname(map.get("CNAME") == null ? null : map.get("CNAME").toString());
                netCellinfoEntity.setPci(map.get("PCI") == null ? null : map.get("PCI").toString());
                netCellinfoEntity.setCgi(map.get("CGI") == null ? null : map.get("CGI").toString());
                netCellinfoEntity.setEarfcn(map.get("EARFCN") == null ? null : Float.parseFloat(map.get("EARFCN").toString()));
                netCellinfoEntity.setRspower(map.get("RSPOWER") == null ? null : Float.parseFloat(map.get("RSPOWER").toString()));
                netCellinfoEntity.setSfassign(map.get("SFASSIGN") == null ? null : Float.parseFloat(map.get("SFASSIGN").toString()));
                netCellinfoEntity.setSpecsfr(map.get("SPECSFR") == null ? null : Float.parseFloat(map.get("SPECSFR").toString()));
                netCellinfoEntity.setPa(map.get("PA")==null?null:map.get("PA").toString());
                netCellinfoEntity.setAlti(map.get("ALTI") == null ? null : Float.parseFloat(map.get("ALTI").toString()));
                netCellinfoEntity.setAzimuth(map.get("AZIMUTH") == null ? null : Integer.parseInt(map.get("AZIMUTH").toString()));
                netCellinfoEntity.setTilt(map.get("TILT") == null ? null : Integer.parseInt(map.get("TILT").toString()));
                netCellinfoEntity.setEtilt(map.get("ETILT") == null ? null : Integer.parseInt(map.get("ETILT").toString()));
                netCellinfoEntity.setMtilt(map.get("MTILT") == null ? null : Integer.parseInt(map.get("MTILT").toString()));
                netCellinfoEntity.setHeight(map.get("HEIGHT") == null ? null : Float.parseFloat(map.get("HEIGHT").toString()));
                netCellinfoEntity.setAnttype(map.get("ANTTYPE") == null ? null : map.get("ANTTYPE").toString());
                netCellinfoEntity.setFake(map.get("FAKE") == null ? null : map.get("FAKE").toString());
                netCellinfoEntity.setShare(null);// Integer.parseInt(map.get("") == null ? "0" : map.get("").toString())
                netCellinfoEntity.setRemote(null);
                netCellinfoEntity.setAnttypeold(null);// map.get("") == null ? "" : map.get("").toString()
                String tsValue = null;
                if (map.get("TS") instanceof TIMESTAMP) {
                    tsValue = DateUtil.dtFormat(((TIMESTAMP) map.get("TS")).dateValue(), DateUtil.dtSimple) + " 00:00:00";
                }
                netCellinfoEntity.setTs(tsValue);
                array.add(JSON.toJSON(netCellinfoEntity));
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
}
