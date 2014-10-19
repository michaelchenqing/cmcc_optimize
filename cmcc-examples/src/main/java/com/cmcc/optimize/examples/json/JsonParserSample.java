/**  
 * JsonParserSample.java
 * com.cmcc.optimize.examples.json
 * 
 * @author gaoqs
 * @date 2014年8月24日 上午10:58:45
 * 版权所有
 */
package com.cmcc.optimize.examples.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.util.DateUtil;
import com.cmcc.optimize.dataapi.entity.PlanEnbParameterEntity;
import com.cmcc.optimize.examples.util.StringRandomGenSamp;

/**
 * json转换处理示例
 * 
 * @author gaoqs
 * @date 2014年8月24日 上午10:58:45
 */

public class JsonParserSample {

    private static SerializerFeature[] features = new SerializerFeature[] { SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty };// 输出格式定义

    private static final CmccLogger logger = CmccLogger.getLogger(CmccLogger.class);
    
    /**
     * main
     * 
     * @param args
     */
    public static void main(String[] args) {
        logger.notice("aaaaaaa");
        // 1.生成10万条json数据
        long start = new Date().getTime();
        String now = DateUtil.dtFormat(new Date(start), DateUtil.simple);
        System.out.println("初始：" + now);

        List<PlanEnbParameterEntity> res = new ArrayList<PlanEnbParameterEntity>();
        for (int i = 0; i < 100000; i++) {
            PlanEnbParameterEntity e = new PlanEnbParameterEntity();
            e.setAzimuth1(1);
            e.setAzimuth2(2);
            e.setCity(StringRandomGenSamp.getRandomStr(5));
            e.setEnbtype(StringRandomGenSamp.getRandomStr(1));
            e.setEtilt1(2222);
            e.setName(StringRandomGenSamp.getRandomStr(50));
            e.setPenbid(StringRandomGenSamp.getRandomStr(10));
            e.setH2(6544);
            e.setMindis(new Float(1114.3));
            e.setLat(new Float(1114.3));
            e.setH3(55);
            e.setTown(StringRandomGenSamp.getRandomStr(10));
            res.add(e);
        }

        String result = JSONObject.toJSONString(res, features);
        long end = new Date().getTime();
        now = DateUtil.dtFormat(new Date(end), DateUtil.simple);
        System.out.println("len:"+result.length());
        System.out.println("生成完成：" + now + ",上次耗时：" + ((end - start)) + "毫秒");
        start = end;

        // 2.解析成对象
        List<PlanEnbParameterEntity> obj = JSONObject.parseArray(result, PlanEnbParameterEntity.class);

        end = new Date().getTime();
        now = DateUtil.dtFormat(new Date(end), DateUtil.simple);
        System.out.println("size:"+obj.size());
        System.out.println("解析完成：" + now + ",上次耗时：" + ((end - start)) + "毫秒");
        start = end;
        
        for (int i = 0; i <500; i+=100) {
            System.out.println("测试输出对象："+obj.get(i));
        }

        // 3.拼装入库串
        StringBuffer sb = new StringBuffer();
        for (PlanEnbParameterEntity e : obj) {
            sb.append("insert into tablesssssss (aaaa,aaaaaaaaaaaaaaaa,aaaaaaaaa,aaaaaaaaaaaaaaaaaaaaaaa,aaaaaaaaaaa,aaaaaaaaa) values (");
            sb.append(e.getCity() + ",");
            sb.append(e.getCname() + ",");
            sb.append(e.getPhase() + ",");
            sb.append(e.getLon() + ",");
            sb.append(e.getName() + ",");
            sb.append(e.getH1() + ",");
            sb.append(e.getTown() + ",");
            sb.append("111,");
            sb.append("append");
            sb.append("append");
            sb.append("append");
            sb.append("append");
            sb.append("append");
            sb.append("append");
            sb.append("\r\n");
        }

        end = new Date().getTime();
        now = DateUtil.dtFormat(new Date(end), DateUtil.simple);
        System.out.println("parser:"+sb.length());
        System.out.println("转换输出完成：" + now + ",上次耗时：" + ((end - start)) + "毫秒");

    }

}
