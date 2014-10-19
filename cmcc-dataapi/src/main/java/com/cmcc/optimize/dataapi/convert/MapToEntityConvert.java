/**  
 * MapToEntityConvert.java
 * com.cmcc.optimize.dataapi.convert
 * 
 * @author gaoqs
 * @date 2014年7月9日 下午3:59:04
 * 版权所有
 */
package com.cmcc.optimize.dataapi.convert;

import java.util.List;
import java.util.Map;

import cn.cas.dps.bean.BeanInfo;
import cn.cas.dps.bean.BeanInfoFactory;
import cn.cas.dps.bean.FieldInfo;
import cn.cas.dps.io.DPS;

/**
 * map值转到entity
 * 
 * @author gaoqs
 * @date 2014年7月9日 下午3:59:04
 */

public class MapToEntityConvert {

    /** 
     * 将map转换成entity
     * 
     * @param entityClass 实体类
     * @param map mapkv值
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <C> C convertMapToEntity(Class<C> entityClass, Map<String, Object> map) throws Exception {

        Object instances = entityClass.newInstance();// 实体无参构造

        // 获取bean信息
        BeanInfo beanInfo = BeanInfoFactory.compute(entityClass);

        List<FieldInfo> fieldList = beanInfo.getFieldList();

        for (FieldInfo fieldInfo : fieldList) {
            DPS.CO.setFieldValue(instances, map.get(fieldInfo.getName()), fieldInfo);
        }

        return (C) instances;
    }

}
