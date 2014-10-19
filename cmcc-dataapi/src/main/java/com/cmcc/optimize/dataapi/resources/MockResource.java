/**  
 * OptimizelResource.java
 * com.cmcc.optimize.dataapi.resources
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.resources;

import java.util.ArrayList;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.DefaultValue;
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
import com.cmcc.optimize.dataapi.ErrorWrap;
import com.cmcc.optimize.dataapi.ErrorWrap.RestError;
import com.cmcc.optimize.dataapi.Param;
import com.cmcc.optimize.dataapi.TokenControl;
import com.cmcc.optimize.dataapi.entity.EngineerParamEntity;
import com.cmcc.optimize.dataapi.entity.NetstrChkEntity;
import com.cmcc.optimize.dataapi.entity.SevenDaysOnlineEntity;
import com.cmcc.optimize.dataapi.param.EnginnerParam;
import com.cmcc.optimize.dataapi.param.NetChk7DaysOnlineParam;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;

/**
 * 模拟rest接口
 * 
 * @author gaoqs
 */
@Path("mock")
@Singleton
// 单例
public class MockResource {
    private static final CmccLogger logger = CmccLogger.getLogger(MockResource.class);

    private TokenControl tokenControl = new TokenControl();// 权限控制

    private SerializerFeature[] features = new SerializerFeature[] { SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty };//输出格式定义

    /**
     * 测试接口方法
     * 
     * @param id
     * @param token
     * @param current_page
     * @param page_size
     * @return
     */
    @POST
    @Produces({ "text/plain;charset=utf-8" })
    @Path("test")
    public String resultParamsWithpost(@QueryParam(Param.uid) String id, @QueryParam(Param.token) String token, @QueryParam(Param.current_page) @DefaultValue("1") int current_page, @QueryParam(Param.page_size) @DefaultValue("10") int page_size) {
        return resultParamsWithGet(id, token, current_page, page_size);
    }

    @GET
    @Produces({ "text/plain;charset=utf-8" })
    @Path("test")
    public String resultParamsWithGet(@QueryParam(Param.uid) String id, @QueryParam(Param.token) String token, @QueryParam(Param.current_page) @DefaultValue("1") int current_page, @QueryParam(Param.page_size) @DefaultValue("10") int page_size) {
        if (logger.isInfoEnabled()) {
            logger.info("resultParams:" + id);
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

        // 用户id转换
        long uid;
        try {
            uid = Long.parseLong(id);
            if (uid <= 0) {
                uid = 1;
            }
        } catch (NumberFormatException e) {
            return RestError.OTHER_ERROR.toString();
        }

        JSONObject res = new JSONObject();
        JSONArray array = new JSONArray();

        // 生成数据
        try {
            // 通过传入参数，生成指定个数的测试数据
            for (int i = 0; i < uid; i++) {
                FtpDownConfModel config = new FtpDownConfModel();
                config.setCornString("cornstr-" + i);
                config.setFileNameRule("file-" + i);
                config.setHost("127.0.0." + i);
                config.setUserName("gaoqs" + i);

                array.add(JSON.toJSON(config));
            }
        } catch (Exception e) {
            logger.error("id:" + id, e);
        }

        // 输出的json字符串构造
        res.put("params", array);
        res.put("current_page", current_page);
        res.put("page_size", page_size);
        res.put("total", uid);
        
        return JSONObject.toJSONString(res,features);
    }

    /**
     * 工参对标请求响应rest 参数描述，参见：@see EnginnerParam.class post请求
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
    @Path("netchkprjpara")
    @Named(value="工参对标")
    public String netchkprjparaPost(@QueryParam(EnginnerParam.type) int type, @QueryParam(EnginnerParam.starttime) String starttime, @QueryParam(EnginnerParam.endtime) String endtime, @QueryParam(EnginnerParam.timeunit) String timeunit, @QueryParam(EnginnerParam.areainfo) String areainfo,
            @QueryParam(EnginnerParam.pageindex) int pageindex, @QueryParam(EnginnerParam.itemcount) int itemcount, @QueryParam(EnginnerParam.token) String token) {
        return netchkprjparaGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 工参对标请求响应rest 参数描述，参见：@see EnginnerParam.class
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
    @Path("netchkprjpara")
    @Named(value="工参对标")
    public String netchkprjparaGet(@QueryParam(EnginnerParam.type) int type, @QueryParam(EnginnerParam.starttime) String starttime, @QueryParam(EnginnerParam.endtime) String endtime, @QueryParam(EnginnerParam.timeunit) String timeunit, @QueryParam(EnginnerParam.areainfo) String areainfo,
            @QueryParam(EnginnerParam.pageindex) int pageindex, @QueryParam(EnginnerParam.itemcount) int itemcount, @QueryParam(EnginnerParam.token) String token) {

        if (logger.isInfoEnabled()) {
            logger.info("netchkprjpara:" + type);
        }
        ErrorWrap result = new ErrorWrap();// 返回结果

        // 权限验证
        boolean isSucc = tokenControl.isValid(starttime, result);
        if (!isSucc) {
            if (result.error == null) {
                result.error = RestError.TOKEN_ERROR;
            }
            return result.error.toString();
        }

        JSONObject res = new JSONObject();
        JSONArray array = new JSONArray();
        ArrayList<EngineerParamEntity> engParamers = new ArrayList<EngineerParamEntity>();
        // 生成数据
        try {
            // 通过传入参数，生成指定个数的测试数据
            for (int i = 0; i < 3; i++) {
                // 生成工参实体
                EngineerParamEntity e = new EngineerParamEntity();
                e.setCity("绵阳");
                e.setPlanedenbname("绵阳新华内燃");
                e.setPlanedenbid("528640");
                e.setCgi("460-00-528640-" + i);
                e.setPlanlongitude((float) 104.70953);
                e.setPlanlatitude((float) 31.46252);
                e.setEnblongitued((float) 104.70953);
                e.setEnblatitude((float) 31.46252);
                e.setCell1azimuth(120);
                e.setCell2azimuth(220);
                e.setCell3azimuth(330);
                e.setRfazimuth(330);
                e.setCell1height((float) 27);
                e.setCell2height((float) 27);
                e.setCell3height((float) 27);
                e.setRfheight((float) 35);
                e.setCell1electilt(9);
                e.setCell2electilt(9);
                e.setCell3electilt(9);
                e.setRfelectilt(6);
                e.setFrequency("D");
                e.setWorkfrequency("D频段");
                e.setTimestamp("2014-6-20 00:00:00");
                engParamers.add(e);
            }
            array.add(JSON.toJSON(engParamers));
        } catch (Exception e) {
            logger.error("type:" + type, e);
            result.error = RestError.OTHER_ERROR;
            return result.error.toString();
        }

        // 输出的json字符串构造
        res.put("result", 0);
        res.put("message", "success!!");
        res.put("prjparachk", array);

        return JSONObject.toJSONString(res,features);
    }

    /**
     * 7天对标 post 参数描述参见：@see NetChk7DaysOnlineParam.class
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
    @Path("netchk7daysonline")
    @Named(value="7天对标")
    public String netChk7DaysOnlineWithPost(@QueryParam(NetChk7DaysOnlineParam.type) int type, @QueryParam(NetChk7DaysOnlineParam.starttime) String starttime, @QueryParam(NetChk7DaysOnlineParam.endtime) String endtime, @QueryParam(NetChk7DaysOnlineParam.timeunit) String timeunit,
            @QueryParam(NetChk7DaysOnlineParam.areainfo) String areainfo, @QueryParam(NetChk7DaysOnlineParam.pageindex) int pageindex, @QueryParam(NetChk7DaysOnlineParam.itemcount) int itemcount, @QueryParam(NetChk7DaysOnlineParam.token) String token) {
        return netChk7DaysOnlineWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 7天对标 get 参数描述参见：@see NetChk7DaysOnlineParam.class
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
    @Path("netchk7daysonline")
    @Named(value="7天对标")
    public String netChk7DaysOnlineWithGet(@QueryParam(NetChk7DaysOnlineParam.type) int type, @QueryParam(NetChk7DaysOnlineParam.starttime) String starttime, @QueryParam(NetChk7DaysOnlineParam.endtime) String endtime, @QueryParam(NetChk7DaysOnlineParam.timeunit) String timeunit,
            @QueryParam(NetChk7DaysOnlineParam.areainfo) String areainfo, @QueryParam(NetChk7DaysOnlineParam.pageindex) int pageindex, @QueryParam(NetChk7DaysOnlineParam.itemcount) int itemcount, @QueryParam(NetChk7DaysOnlineParam.token) String token) {
        ErrorWrap result = new ErrorWrap();// 返回结果

        JSONObject res = new JSONObject();
        JSONArray array = new JSONArray();
        String[] planenbname = new String[] { "绵阳新华内燃", "绵阳新华内燃", "绵阳新华内燃", "绵阳绵中零二", "绵阳绵中零二", "绵阳绵中零二", "绵阳白土村站", "绵阳白土村站", "绵阳白土村站", "绵阳双发市场", "绵阳双发市场", "绵阳双发市场", "绵阳柏杨宾馆", "绵阳柏杨宾馆", "绵阳柏杨宾馆", "绵阳肉联厂站", "绵阳肉联厂站", "绵阳肉联厂站", "绵阳气象局站", "绵阳气象局站", "绵阳气象局站", "绵阳涪城联社", "绵阳涪城联社", "绵阳涪城联社" };
        String[] planedenbid = new String[] { "528640", "528640", "528640", "528641", "528641", "528641", "528643", "528643", "528643", "528644", "528644", "528644", "528645", "528645", "528645", "528646", "528646", "528646", "528647", "528647", "528647", "528648", "528648", "528648" };
        float[] planedlongitude = new float[] { 104.70953f, 104.70953f, 104.70953f, 104.7161f, 104.7161f, 104.7161f, 104.69864f, 104.69864f, 104.69864f, 104.68634f, 104.68634f, 104.68634f, 104.68064f, 104.68064f, 104.68064f, 104.72449f, 104.72449f, 104.72449f, 104.74369f, 104.74369f, 104.74369f, 104.73706f,
                104.73706f, 104.73706f };
        float[] planedlatitude = new float[] { 31.46252f, 31.46252f, 31.46252f, 31.46879f, 31.46879f, 31.46879f, 31.49983f, 31.49983f, 31.49983f, 31.47079f, 31.47079f, 31.47079f, 31.48524f, 31.48524f, 31.48524f, 31.47267f, 31.47267f, 31.47267f, 31.44979f, 31.44979f, 31.44979f, 31.45761f, 31.45761f, 31.45761f };
        String[] uniqueenbid = new String[] { "8881640000000000000", "8881640000000000000", "8881640000000000000", "-2094990000000000000", "-2094990000000000000", "-2094990000000000000", "515967000000000000", "515967000000000000", "515967000000000000", "-5748520000000000000", "-5748520000000000000",
                "-5748520000000000000", "4817490000000000000", "4817490000000000000", "4817490000000000000", "6196150000000000000", "6196150000000000000", "6196150000000000000", "-6404360000000000000", "-6404360000000000000", "-6404360000000000000", "-1319440000000000000", "-1319440000000000000",
                "-1319440000000000000" };
        String[] cgi = new String[] { "460-00-528640-3", "460-00-528640-2", "460-00-528640-1", "460-00-528641-1", "460-00-528641-2", "460-00-528641-3", "460-00-528643-3", "460-00-528643-1", "460-00-528643-2", "460-00-58644-3", "460-00-528644-2", "460-00-528644-1", "460-00-528645-2", "460-00-528645-1",
                "460-00-528645-3", "460-00-528646-3", "460-00-528646-2", "460-00-528646-1", "460-00-528647-1", "460-00-528647-3", "460-00-528647-2", "460-00-528648-3", "460-00-528648-2", "460-00-528648-1" };
        String[] timestamp = new String[] { "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00",
                "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00" };
        try {
            for (int i = 0; i < 24; i++) {
                SevenDaysOnlineEntity sevenDaysOnline = new SevenDaysOnlineEntity();
                sevenDaysOnline.setCity("绵阳");
                sevenDaysOnline.setPlanenbname(planenbname[i]);
                sevenDaysOnline.setPlanedenbid(planedenbid[i]);
                sevenDaysOnline.setEnbtype("宏站");
                sevenDaysOnline.setPlanedlongitude(planedlongitude[i]);
                sevenDaysOnline.setPlanedlatitude(planedlatitude[i]);
                sevenDaysOnline.setUniqueenbid(uniqueenbid[i]);
                sevenDaysOnline.setCgi(cgi[i]);
                sevenDaysOnline.setTimestamp(timestamp[i]);
                array.add(JSON.toJSON(sevenDaysOnline));
            }
        } catch (Exception e) {
            logger.error("type:" + type, e);
            result.error = RestError.OTHER_ERROR;
            return result.error.toString();
        }

        // 输出的json字符串构造
        res.put("list", array);
        res.put("message", "成功");
        res.put("result", 0);

        return JSONObject.toJSONString(res,features);
    }

    /**
     * 网络结构对标 post 参数描述参见：@see NetChk7DaysOnlineParam.class
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
    @Path("netchknetstr")
    @Named(value="网络结构对标")
    public String netChkNetstrWithPost(@QueryParam(NetChk7DaysOnlineParam.type) int type, @QueryParam(NetChk7DaysOnlineParam.starttime) String starttime, @QueryParam(NetChk7DaysOnlineParam.endtime) String endtime, @QueryParam(NetChk7DaysOnlineParam.timeunit) String timeunit,
            @QueryParam(NetChk7DaysOnlineParam.areainfo) String areainfo, @QueryParam(NetChk7DaysOnlineParam.pageindex) int pageindex, @QueryParam(NetChk7DaysOnlineParam.itemcount) int itemcount, @QueryParam(NetChk7DaysOnlineParam.token) String token) {
        return netChkNetstrWithGet(type, starttime, endtime, timeunit, areainfo, pageindex, itemcount, token);
    }

    /**
     * 网络结构对标 get 参数描述参见：@see NetChk7DaysOnlineParam.class
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
    @Path("netchknetstr")
    @Named(value="网络结构对标")
    public String netChkNetstrWithGet(@QueryParam(NetChk7DaysOnlineParam.type) int type, @QueryParam(NetChk7DaysOnlineParam.starttime) String starttime, @QueryParam(NetChk7DaysOnlineParam.endtime) String endtime, @QueryParam(NetChk7DaysOnlineParam.timeunit) String timeunit,
            @QueryParam(NetChk7DaysOnlineParam.areainfo) String areainfo, @QueryParam(NetChk7DaysOnlineParam.pageindex) int pageindex, @QueryParam(NetChk7DaysOnlineParam.itemcount) int itemcount, @QueryParam(NetChk7DaysOnlineParam.token) String token) {

        ErrorWrap result = new ErrorWrap();// 返回结果

        JSONObject res = new JSONObject();
        JSONArray array = new JSONArray();

        String[] planedenbname = new String[] { "绵阳肉联厂站", "绵阳高炮旅站", "绵阳凝详晓月", "绵阳新华内燃", "绵阳气象局站", "绵阳御营坝站", "绵阳浸水九组", "绵阳绵中零二", "绵阳涪城联社", "绵阳引马桥站", "绵阳白土村站", "绵阳鼎盛花园", "绵阳五三局站", "绵阳双发市场", "绵阳西科大站", "绵阳双碑村站", "绵阳柏杨宾馆", "绵阳西科大三", "绵阳新欣公司" };
        String[] planedenbid = new String[] { "528646", "528654", "528661", "528640", "528647", "528655", "528662", "528641", "528648", "528657", "528643", "528651", "528658", "528644", "528652", "528659", "528645", "528653", "528660" };
        float[] planlongitude = new float[] { 104.72449f, 104.67861f, 104.69368f, 104.70953f, 104.74369f, 104.73766f, 104.74921f, 104.7161f, 104.73706f, 104.74386f, 104.69864f, 104.79078f, 104.67876f, 104.68634f, 104.69192f, 104.69182f, 104.68064f, 104.6971f, 104.66822f };
        float[] planlatitude = new float[] { 31.47267f, 31.49639f, 31.46241f, 31.46252f, 31.44979f, 31.45211f, 31.43212f, 31.46879f, 31.45761f, 31.45541f, 31.49983f, 31.39514f, 31.47027f, 31.47079f, 31.54361f, 31.46654f, 31.48524f, 31.54361f, 31.46691f };
        float[] rfheight = new float[] { 26f, 35f, 35f, 35f, 22f, 35f, 16f, 26f, 20f, 30f, 35f, 28f, 35f, 24f, 22f, 17f, 24f, 25f, 25f };
        float[] cell1height = new float[] { 24f, 18f, 31f, 27f, 35f, 34f, 22f, 20f, 28f, 31f, 10f, 22f, 40f, 22f, 34f, 33f, 16f, 23f, 24f };
        float[] cell2height = new float[] { 24f, 18f, 31f, 27f, 35f, 30f, 22f, 20f, 28f, 31f, 10f, 22f, 40f, 22f, 34f, 33f, 16f, 23f, 24f };
        float[] cell3height = new float[] { 24f, 18f, 31f, 27f, 35f, 28f, 22f, 20f, 28f, 31f, 10f, 22f, 40f, 22f, 34f, 33f, 16f, 23f, 24 };
        String[] timestamp = new String[] { "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00",
                "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00", "2014/6/20 0:00" };
        try {
            for (int i = 0; i < 19; i++) {
                NetstrChkEntity netstrChkEntity = new NetstrChkEntity();
                netstrChkEntity.setCity("绵阳");
                netstrChkEntity.setPlanedenbname(planedenbname[i]);
                netstrChkEntity.setPlanedenbid(planedenbid[i]);
                netstrChkEntity.setEnbtype("宏站");
                netstrChkEntity.setPlanlongitude(planlongitude[i]);
                netstrChkEntity.setPlanlatitude(planlatitude[i]);
                netstrChkEntity.setRfheight(rfheight[i]);
                netstrChkEntity.setMinenbdistance(50f);
                netstrChkEntity.setCell1height(cell1height[i]);
                netstrChkEntity.setCell2height(cell2height[i]);
                netstrChkEntity.setCell3height(cell3height[i]);
                netstrChkEntity.setPlanedminenbdistance(50f);
                netstrChkEntity.setGridid(1f);
                netstrChkEntity.setTimestamp(timestamp[i]);
                array.add(JSON.toJSON(netstrChkEntity));
            }
        } catch (Exception e) {
            logger.error("type:" + type, e);
            result.error = RestError.OTHER_ERROR;
            return result.error.toString();
        }

        // 输出的json字符串构造
        res.put("list", array);
        res.put("message", "成功");
        res.put("result", 0);

        return JSONObject.toJSONString(res,features);
    }

}
