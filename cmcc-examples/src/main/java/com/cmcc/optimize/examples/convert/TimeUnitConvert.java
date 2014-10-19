/**  
 * TimeUnitConvert.java
 * com.cmcc.optimize.examples.convert
 * 
 * @author gaoqs
 * @date 2014年7月3日 下午2:30:59
 * 版权所有
 */
package com.cmcc.optimize.examples.convert;

import junit.framework.Assert;
import cn.cas.dps.bean.BeanInfo;
import cn.cas.dps.bean.BeanInfoFactory;
import cn.cas.dps.bean.FieldInfo;
import cn.cas.dps.io.DPS;

import com.cmcc.optimize.dataapi.entity.OmcLoLaEntity;

/**
 * 使用dps框架反射对象
 * 
 * @author gaoqs
 * @date 2014年7月3日 下午2:30:59
 */

public class TimeUnitConvert {

    /**
     * main函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        OmcLoLaEntity obj = new OmcLoLaEntity();
        obj.setEnbid("123");

        //获取bean信息
        BeanInfo beanInfo = BeanInfoFactory.compute(OmcLoLaEntity.class);
        
        //获取字段
        FieldInfo field = beanInfo.getField("enbid");
        
        //获取字段值
        Object resultValue = DPS.CO.getFieldValue(obj, field);
        
        Assert.assertEquals(resultValue,obj.getEnbid());
    }
}
