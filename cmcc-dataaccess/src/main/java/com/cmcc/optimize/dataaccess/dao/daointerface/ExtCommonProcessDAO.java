/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.daointerface;

// auto generated imports
import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * 扩展的通用数据库操作接口
 * 
 * @author gaoqs
 */
public interface ExtCommonProcessDAO {

    /**
     * 通用性存入
     * 
     * @param tableName 表名
     * @param columnList 字段列表
     * @param valueList 值列表
     * @return 数据是否存入成功
     * @throws DataAccessException
     */
    public boolean insert(String tableName, List<String> columnList, List<Object> valueList) throws DataAccessException;

    /**
     * 通用性存入-批量，单个表
     * 
     * @param tableName 单个表名
     * @param columnList 单个表对应的字段列表
     * @param valueLists　多个表对应的值列表
     * @param batchCommitNums 批量提交的数值，一般定义为10000，调试时，可设置为1
     * @return　返回是否存入成功
     */
    public boolean batchCommonInsertSingle(final String tableName, final List<String> columnList, final List<List<Object>> valueLists, int batchCommitNums);

    /**
     * 通用性存入-批量，多个表
     * 
     * @param tableNames 多个表名
     * @param columnLists 多个表对应的字段列表
     * @param valueLists　多个表对应的值列表
     * @param batchCommitNums 批量提交的数值，一般定义为10000，调试时，可设置为1
     * @return　返回是否存入成功
     */
    public boolean batchCommonInsertMulti(final List<String> tableNames, final List<List<String>> columnLists, final List<List<Object>> valueLists, int batchCommitNums);

}