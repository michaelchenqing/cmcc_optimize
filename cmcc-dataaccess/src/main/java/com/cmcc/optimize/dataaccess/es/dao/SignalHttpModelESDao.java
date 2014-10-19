/**  
 * SignalHttpModelESDao.java
 * com.cmcc.optimize.dataaccess.es.dao
 * 
 * @author gaoqs
 * @date 2014年9月1日 下午1:45:22
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.es.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cmcc.optimize.dataaccess.es.ESDao;
import com.cmcc.optimize.dataaccess.es.ESException;
import com.cmcc.optimize.datamodel.signal.SignalHttpModel;

/**
 * es操作对象封装
 * 
 * @author gaoqs
 */
public class SignalHttpModelESDao extends ESDao<SignalHttpModel> {

    public SignalHttpModelESDao() throws ESException {
        super(SignalHttpModel.class, "SignalHttpModel");
    }

    /**
     * 批量更新索引
     * 
     * @param beans 索引对象队列
     * @throws ESException
     */
    public void updateBulk(List<SignalHttpModel> beans) throws ESException {
        Map<String, SignalHttpModel> data = new HashMap<String, SignalHttpModel>();
        for (SignalHttpModel bean : beans) {
            data.put(bean.getId() + "", bean);
        }
        super.bulkUpdate(data);
    }
   
}
