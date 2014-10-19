/**  
 * TestSpringBeanContext.java
 * com.cmcc.optimize.dataaccess.spring
 * 
 * @author gaoqs
 * @date 2014年6月25日 下午2:08:26
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.spring;

import junit.framework.TestCase;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 测试springbeancontext加载，构件context，获取bean
 * 
 * @author gaoqs
 * @date 2014年6月25日 下午2:08:26
 */

public class TestSpringBeanContext extends TestCase {

    /**
     * 测试spring 加载及bean获取
     */
    public void testGetBean() {
        BasicDataSource dataSource = SpringBeanContext.getInstance().getDataSource();

        // 取出的bean为非空
        assertNotNull(dataSource);

        // 取出的对象属性非空
        assertNotNull(dataSource.getDriverClassName());

    }

}
