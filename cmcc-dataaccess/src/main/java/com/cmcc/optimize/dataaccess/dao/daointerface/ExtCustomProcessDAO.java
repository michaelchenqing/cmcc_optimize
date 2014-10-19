/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

import java.util.List;
import java.util.Map;

// auto generated imports

/**
 * 自定义扩展的数据库操作接口
 * 
 * @author gaoqs
 */
public interface ExtCustomProcessDAO {

    /**
     * 按指定的sql返回map list查询，不支持insert,update,delete操作
     * 
     * @param sqlIdStr 查询sql的ibatis标识id
     * @param params参数
     * @return 字段map对应的队列
     */
    public List<Map<String, Object>> getMapList(String sqlIdStr, Map<String, Object> params);

    /**
     * 查询单条记录
     * 
     * @param sqlIdStr 查询sql的ibatis标识id
     * @param params 参数
     * @return 结果对象
     */
    public Object queryForObject(String sqlIdStr, Map<String, Object> params);

    /**
     * TODO(这里用一句话描述这个方法的作用)
     * 
     * @param entityClass 返回对象类型
     * @param sqlIdStr 查询sql的ibatis标识id
     * @param params 参数
     * @return　结果对象
     */
    public <C> C queryForObject(Class<C> entityClass, String sqlIdStr, Map<String, Object> params);

}