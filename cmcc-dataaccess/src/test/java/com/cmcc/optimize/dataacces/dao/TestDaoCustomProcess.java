/**  
 * TestDaoProcess.java
 * com.cmcc.optimize.dataacces.dao
 * 
 * @author gaoqs
 * @date 2014年6月29日 下午2:16:04
 * 版权所有
 */
package com.cmcc.optimize.dataacces.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO;
import com.cmcc.optimize.dataaccess.dao.ibatis.ExtIbatisCustomProcessDAO;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;

/**
 * <pre>
 * 测试dao层通用的底层方法 通用查询
 * </pre>
 * 
 * @author gaoqs
 * @date 2014年6月29日 下午2:16:04
 */

public class TestDaoCustomProcess extends TestCase {

    /**
     * 测试ibatis数据通用查询
     */
    public void testIbatisCommonInsert() {
        ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCustomProcessDAO.class, "extCustomProcessDAO");

        // 获取bean成功
        assertNotNull(extCustomProcessDAO);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("mmegroupid", "12456");

        List<Map<String, Object>> list = extCustomProcessDAO.getMapList("TEST-QUERY-SQL-LIST-WITH-MAPPING", params);

        // 分页查询结果对象非空
        assertNotNull(list);

        // 无对应的数据返回
        assertTrue(list.size() <= 0);
    }
    
    /**
     * 测试谳用存储过程
     */
    public void testExecuteProduce(){
    	ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCustomProcessDAO.class, "extCustomProcessDAO");

        // 获取bean成功
        assertNotNull(extCustomProcessDAO);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("table", "mb_perf_lte_cellbusistat");
        params.put("day", "2014-07-05");
        
        extCustomProcessDAO.queryForObject("DAY-DATA-MULTI-CLEAN-PROCEDURE", params);

    }
}
