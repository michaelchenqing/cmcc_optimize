/**  
 * HTableCreator.java
 * com.cmcc.optimize.dataaccess.hbase
 * 
 * @author gaoqs
 * @date 2014年8月18日 上午9:27:59
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.hbase;

/**
 * 创建hbase表接口
 * 
 * @author gaoqs
 * @date 2014年8月18日 上午9:27:59
 */

public interface HTableCreator {
    /**
     * 创建hbase表
     */
    void create(boolean forceDeleteIfExist);
}
