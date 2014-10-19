/**  
 * HbaseTest.java
 * com.cmcc.dataprocess.hbase.dao
 * 
 * @author gaoqs
 * @date 2014年8月19日 上午10:10:18
 * 版权所有
 */
package com.cmcc.dataprocess.hbase.dao;

import junit.framework.TestCase;
import cn.cas.common.exception.DaoException;

import com.cmcc.optimize.dataaccess.redis.UidGenerator;
import com.cmcc.optimize.datamodel.signal.SignalMMSModel;

/**
 * hbase操作单元测试
 * 
 * @author gaoqs
 * @date 2014年8月19日 上午10:10:18
 */

public class HbaseTest extends TestCase {

    protected SignalMMSModelDao dao;

    protected int netType;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        dao = new SignalMMSModelDao();
        netType = 2;
    }

    /**
     * 测试单个对象表存入
     * 
     * @throws DaoException
     */
    public void testInsertTable() throws DaoException {

        // 存入对象
        SignalMMSModel model = new SignalMMSModel();
        long uid;
        uid = UidGenerator.generate();
        model.setId(uid);
        model.setAppSession(1);
        model.setErrorType(1);
        model.setLac(222);
        model.setNetType(netType);
        model.setUrl("http://www.cmcc.com");

        dao.put(model);
        
//        // 按rowkey查询对象
//        boolean isExists = dao.exist(uid);
//        assertTrue(isExists);
//
//        model = dao.get(uid);
//        assertEquals(model.getNetType(), netType);
//
//        // 删除对象
//        dao.delete(uid);
//        isExists = dao.exist(uid);
//        assertFalse(isExists);
    }
}
