/**  
 * TestSignalHttpModelESDao.java
 * com.cmcc.optimize.dataacces.es
 * 
 * @author gaoqs
 * @date 2014年9月1日 下午3:01:31
 * 版权所有
 */
package com.cmcc.optimize.dataacces.es;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.search.sort.SortOrder;

import junit.framework.TestCase;

import com.cmcc.optimize.dataaccess.es.ESException;
import com.cmcc.optimize.dataaccess.es.dao.SignalHttpModelESDao;
import com.cmcc.optimize.datamodel.signal.QueryRange;
import com.cmcc.optimize.datamodel.signal.SignalHttpModel;

/**
 * http信令 es同步处理单元测试
 * 
 * @author gaoqs
 * @date 2014年9月1日 下午3:01:31
 */

public class TestSignalHttpModelESDao extends TestCase {

    SignalHttpModel info1 = null;// 测试实体1

    SignalHttpModel info2 = null;// 测试实体2

    // @Override
    // protected void setUp() throws Exception {
    // super.setUp();
    // info1 = new SignalHttpModel();
    // info1.setId(Long.MAX_VALUE);
    // info1.setMobileType("123");
    //
    // info2 = new SignalHttpModel();
    // info2.setId(Long.MAX_VALUE - 1);
    // info2.setMobileType("345");
    // }

    /**
     * 测试存入索引
     * 
     * @throws ESException
     */
    public void testPutIndex() throws ESException {
        SignalHttpModelESDao dao = new SignalHttpModelESDao();

        // // 批量更新存入
        // dao.updateBulk(new SignalHttpModel[] { info1, info2 });
        //
        // // 查询出info1
        // info1 = dao.searchByUId(Long.MAX_VALUE);
        // assertNotNull(info1);
        // assertEquals("123", info1.getMobileType());
        //
        // // 删除info2
        // dao.deleteBulk(new Long[] { Long.MAX_VALUE - 1 });
        //
        // // 查询info2
        // info2 = dao.searchByUId(Long.MAX_VALUE - 1);
        // assertNull(info2);
        //
        // // 删除info1
        // dao.deleteBulk(new Long[] { Long.MAX_VALUE });

    }

    public static void main(String[] args) throws ESException {
        // Queryfilter queryfileter = new Queryfilter();
        // queryfileter.put("url4", 2);
        // queryfileter.
        //
        SignalHttpModelESDao dao = new SignalHttpModelESDao();
        // for (Entry<SignalHttpModel, Float> entry : dao.searchByKeywords("", 0, 1000, queryfileter,
        // 0.9f).sliceResult.entrySet()) {
        // System.out.println(entry.getKey() + ":" + entry.getValue());
        // }
        Map<String, Object> querys = new HashMap<String, Object>();
        querys.put("lac", "32918");
        querys.put("cell", "32166");
        
       //List<SignalHttpModel> list = dao.searchByKeywords(querys, 0, 2);
        
        //传递对象      
        QueryRange qRange =new QueryRange();    
        qRange.setQueryField("time");
        qRange.setQueryStartPos("1409878075000");
        qRange.setQueryEndPos("1409878079000");
       
        //排序
        
       // List<SignalHttpModel> list = dao.searchByTime(querys,"time","1409878075000","1409878079000", 0, 4);
        List<SignalHttpModel> list = dao.search(querys,qRange, 0, 4,"time",SortOrder.DESC);
        //List<SignalHttpModel> list = dao.search(querys, 0, 4);
        //List<SignalHttpModel> list = dao.search(qRange, 0, 4);
        for (SignalHttpModel signalHttpModel : list) {
            System.out.println(signalHttpModel.toJsonString());
        }
        //long count=dao.searchCount(querys,null);
        //System.out.println(count);
        
        // dao.searchByKeywords("460025805091303", 0, 50, kwsFields, matchQuery, existQuery, notExistQuery, minScore)
        // System.out.println(dao.searchByUId(21148656l).toJsonString());
    }

}
