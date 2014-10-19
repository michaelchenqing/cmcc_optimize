/**  
 * TestDaoProcess.java
 * com.cmcc.optimize.dataacces.dao
 * 
 * @author gaoqs
 * @date 2014年6月29日 下午2:16:04
 * 版权所有
 */
package com.cmcc.optimize.dataacces.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCommonProcessDAO;
import com.cmcc.optimize.dataaccess.dao.daointerface.MbMrRecordDAO;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbMrRecordDO;
import com.cmcc.optimize.dataaccess.dao.ibatis.ExtIbatisCommonProcessDAO;
import com.cmcc.optimize.dataaccess.dao.ibatis.IbatisMbMrRecordDAO;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;
import com.cmcc.optimize.datamodel.paging.PageList;

/**
 * <pre>
 * 测试dao层通用的底层方法  通用存储
 * </pre>
 * 
 * @author gaoqs
 * @date 2014年6月29日 下午2:16:04
 */

public class TestDaoCommonInsertProcess extends TestCase {

    /**
     * 测试ibatis数据单表存入
     */
    public void testIbatisSingleTableInsert() {
        MbMrRecordDAO mbMrRecordDAO = SpringBeanContext.getInstance().getBean(IbatisMbMrRecordDAO.class, "mbMrRecordDAO");
        // 获取bean成功
        assertNotNull(mbMrRecordDAO);

        // 构建存入do对象
        MbMrRecordDO mbMrRecord = new MbMrRecordDO();
        mbMrRecord.setCellid("cellid");
        mbMrRecord.setMmegroupid("xixihaha");
        mbMrRecord.setMmecode("123456");

        // ...其他属性暂不设置，不影响，数据全部字段目前可空

        String id = mbMrRecordDAO.insertMr(mbMrRecord);
        // 存入id非空，数据存入成功
        assertNotNull(id);
    }

    /**
     * 测试ibatis数据通用存入
     */
    public void testIbatisCommonInsert() {
        ExtCommonProcessDAO extCommonProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCommonProcessDAO.class, "extCommonProcessDAO");

        // 获取bean成功
        assertNotNull(extCommonProcessDAO);

        // 测试存入表
        String tableName = "mb_mr_record";

        // 添加表列
        List<String> columnList = new ArrayList<String>();
        columnList.add("mmegroupid");
        columnList.add("test_date");
        columnList.add("mrltescrsrp");

        // 添加列值
        List<Object> valueList = new ArrayList<Object>();
        valueList.add("id2");
        valueList.add(new Date(new Date().getTime() - 2 * 24 * 60 * 60 * 1000));
        valueList.add(123456);

        boolean isSucc = extCommonProcessDAO.insert(tableName, columnList, valueList);

        // 预期存入成功
        assertTrue(isSucc);
    }

    /**
     * 多条记录的批次入库
     */
    public void testIbatisCommonInsertMulti() {
        ExtCommonProcessDAO extCommonProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCommonProcessDAO.class, "extCommonProcessDAO");

        // 获取bean成功
        assertNotNull(extCommonProcessDAO);

        // 测试存入表
        String tableName = "mb_mr_record";

        // 添加表列
        List<String> columnList = new ArrayList<String>();
        columnList.add("mmegroupid");
        columnList.add("test_date");
        columnList.add("mmecode");

        // 构件多个值
        List<List<Object>> valueLists = new ArrayList<List<Object>>();

        for (int i = 0; i < 300; i++) {
            List<Object> valueList = new ArrayList<Object>();
            valueList.add("id222");
            valueList.add(new Date(new Date().getTime() - 1 * 24 * 60 * 60 * 1000));
            valueList.add("" + i);
            valueLists.add(valueList);
        }

        boolean isSucc = extCommonProcessDAO.batchCommonInsertSingle(tableName, columnList, valueLists,1);
        assertTrue(isSucc);
    }

    /**
     * 测试分页查询
     */
    public void testPagingQuery() {
        MbMrRecordDAO mbMrRecordDAO = SpringBeanContext.getInstance().getBean(IbatisMbMrRecordDAO.class, "mbMrRecordDAO");
        // 获取bean成功
        assertNotNull(mbMrRecordDAO);

        // 分页查询
        PageList list = mbMrRecordDAO.getMultiMrRecord("id222", null, null, 10, 2);

        // 分页查询结果对象非空
        assertNotNull(list);

        // 无对应的数据返回
        assertTrue(list.size() == 10);

    }
}
