/**  
 * TcpModelDao.java
 * com.cmcc.dataprocess.hbase.dao
 * 
 * @author gaoqs
 * @date 2014年8月18日 上午11:45:22
 * 版权所有
 */
package com.cmcc.dataprocess.hbase.dao;

import cn.cas.dps.hbase.dao.HbaseDaoImpl;

import com.cmcc.optimize.dataaccess.hbase.CreateTableHanlder;
import com.cmcc.optimize.dataaccess.hbase.HTableCreator;
import com.cmcc.optimize.datamodel.signal.SignalHttpModel;

/**
 * 信令http对象hbase dao层
 * 
 * @author gaoqs
 * @date 2014年8月18日 上午11:45:22
 */

public class SignalHttpModelDao extends HbaseDaoImpl<SignalHttpModel, Long> implements HTableCreator {

    /** 
     * 构造函数，指定表名
     */
    public SignalHttpModelDao() {
        super("SignalHttpModel");
    }

    /* (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.hbase.HTableCreator#create(boolean)
     */ 
    @Override
    public void create(boolean forceDeleteIfExist) {
        CreateTableHanlder.createTable(tableName, forceDeleteIfExist, true, true);
    }

}
