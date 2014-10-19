/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCommonProcessDAO;
import com.ibatis.sqlmap.client.SqlMapExecutor;

// auto generated imports

/**
 * 扩展的通用数据库操作处理类
 * 
 * @author gaoqs
 */
public class ExtIbatisCommonProcessDAO extends SqlMapClientDaoSupport implements ExtCommonProcessDAO {

    private static final CmccLogger logger = CmccLogger.getLogger(ExtIbatisCommonProcessDAO.class);// 日志

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 日期格式化

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.dao.daointerface.ExtCommonProcessDAO#insert(java.lang.String, java.util.List,
     * java.util.List)
     */
    @Override
    public boolean insert(String tableName, List<String> columnList, List<Object> valueList) throws DataAccessException {
        if (StringUtils.isBlank(tableName) || columnList == null || columnList.size() <= 0 || valueList == null || valueList.size() <= 0) {
            logger.warn("common insert parmas blan:" + tableName + "@" + columnList + "@" + valueList);
            return false;
        }

        // 构造参数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("tableName", tableName);
        params.put("columnList", columnList);
        params.put("valueList", valueList);

        // 存入库
        getSqlMapClientTemplate().insert("CAS-SYS-COMMON-INSERT", params);

        return true;
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.dao.daointerface.ExtCommonProcessDAO#batchCommonInsertMulti(java.util.List,
     * java.util.List, java.util.List)
     */
    public boolean batchCommonInsertMulti(final List<String> tableNames, final List<List<String>> columnLists, final List<List<Object>> valueLists, final int batchCommitNums) {
        SqlMapClientCallback<Boolean> callBack = new SqlMapClientCallback<Boolean>() {
            final int batchCommitNumsReal = (batchCommitNums > 0) ? batchCommitNums : 1;

            public Boolean doInSqlMapClient(SqlMapExecutor executor) throws SQLException {

                int i = 0;// 定义执行的语句顺序号

                // 是否是执行单个表存入，前2个参数，只有一个值
                boolean isSingleTableInsert = (tableNames.size() == 1 && columnLists.size() == 1 && tableNames.size() != valueLists.size());

                Map<String, Object> params = null;
                // StringBuffer sb = new StringBuffer();// 记录上一次提交前的10000万sql

                try {
                    // getSqlMapClient().startTransaction();
                    executor.startBatch();// 开始批次
                    for (i = 0; i < valueLists.size(); i++) {
                        try {
                            params = new HashMap<String, Object>();
                            params.put("tableName", isSingleTableInsert ? tableNames.get(0) : tableNames.get(i));
                            params.put("columnList", isSingleTableInsert ? columnLists.get(0) : columnLists.get(i));
                            params.put("valueList", valueLists.get(i));

                            executor.insert("CAS-SYS-COMMON-INSERT", params);

                            // sb.append("/** save-" + i + " */ insert into " + params.get("tableName") + " (" +
                            // getListStringValue((List<Object>) params.get("columnList"), false) + ") values (" +
                            // getListStringValue((List<Object>) params.get("valueList"), true) + ");\r\n");

                            if ((i + 1) % batchCommitNumsReal == 0) {// 每10000条执行一次批次
                                executor.executeBatch();
                                // getSqlMapClient().commitTransaction();
                                if (logger.isDebugEnabled()) {
                                    logger.debug("execute batchs for " + (i + 1) + " items");
                                }

                                // if (batchCommitNumsReal == 1) {// 线上日志中不输出，只输出当前行号报错，调试导入，由线下进行
                                // sb = null;
                                // sb = new StringBuffer();
                                // }

                                // getSqlMapClient().startTransaction();
                            }
                        } catch (Exception e) {
                            // logger.error("execute batch insert error:" + tableNames + "@" + i + "@[" +
                            // getListStringValue((List<Object>) params.get("valueList"), true) + "]", e);// +
                            // // ",last batch sqls：[\r\n"
                            // // + sb + "\r\n]\r\n",
                            // // e);
                            // logger.notice("execute batch insert error:" + tableNames + "@" + i + "@[" +
                            // getListStringValue((List<Object>) params.get("valueList"), true) + "]" + e);

                            String startRowValue = "";
                            String endRowValue = "";

                            if (valueLists != null && valueLists.size() > 0) {
                                startRowValue = getListStringValue((List<Object>) valueLists.get(0), true);
                                endRowValue = getListStringValue((List<Object>) valueLists.get(valueLists.size() - 1), true);
                            }

                            logger.error("execute batch insert errors:" + tableNames + "@startRow:[" + startRowValue + "],endRow:[" + endRowValue + "]" + "@" + i, e);// +
                                                                                                                                                                      // ",last batch sqls：[\r\n"
                            logger.notice("execute batch insert error:" + tableNames + "@" + i + "@startRow:[" + startRowValue + "],endRow:[" + endRowValue + "]" + e); // +

                        }
                    }

                    // if (sb.length() > 0) {
                    executor.executeBatch();// 结束批次
                    // }
                    // getSqlMapClient().commitTransaction();
                } catch (SQLException e) {
                    String startRowValue = "";
                    String endRowValue = "";

                    if (valueLists != null && valueLists.size() > 0) {
                        startRowValue = getListStringValue((List<Object>) valueLists.get(0), true);
                        endRowValue = getListStringValue((List<Object>) valueLists.get(valueLists.size() - 1), true);
                    }

                    logger.error("execute batch insert errors:" + tableNames + "@startRow:[" + startRowValue + "],endRow:[" + endRowValue + "]" + "@" + i, e);// +
                                                                                                                                                              // ",last batch sqls：[\r\n"
                    logger.notice("execute batch insert error:" + tableNames + "@" + i + "@startRow:[" + startRowValue + "],endRow:[" + endRowValue + "]" + e); // +
                                                                                                                                                                // sb
                                                                                                                                                                // +
                                                                                                                                                                // "\r\n]\r\n",
                                                                                                                                                                // e);
                    // getSqlMapClient().endTransaction();
                } finally {
                    try {
                        // getSqlMapClient().commitTransaction();
                    } catch (Exception e) {
                        logger.error("commmit batch insert transaction error ", e);
                    }
                }

                return true;
            }
        };

        return getSqlMapClientTemplate().execute(callBack);
    }

    /**
     * 是否需要按类型包装'，用于日志输出错误的sql
     * 
     * @param list 队列
     * @param needWarp　是否需要按类型添加'
     * @return
     */
    private String getListStringValue(List<Object> list, boolean needWarp) {
        StringBuffer sb = new StringBuffer();
        if (list == null || list.size() <= 0) {
            return sb.toString();
        }

        for (Object object : list) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            if (!needWarp) {
                sb.append(object);
            } else {
                if (object instanceof String) {
                    sb.append("'" + object + "'");
                } else if (object instanceof Date) {
                    sb.append("to_date('" + format.format(((Date) object)) + "','yyyy-MM-dd hh24:mi:ss')");
                } else {
                    sb.append(object);
                }
            }
        }

        return sb.toString();
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.dao.daointerface.ExtCommonProcessDAO#batchCommonInsertSingle(java.lang.String,
     * java.util.List, java.util.List)
     */
    @Override
    public boolean batchCommonInsertSingle(String tableName, List<String> columnList, List<List<Object>> valueLists, int batchCommitNums) {
        List<String> tableNames = new ArrayList<String>();
        tableNames.add(tableName);

        List<List<String>> columnLists = new ArrayList<List<String>>();
        columnLists.add(columnList);

        return batchCommonInsertMulti(tableNames, columnLists, valueLists, batchCommitNums);
    }

}