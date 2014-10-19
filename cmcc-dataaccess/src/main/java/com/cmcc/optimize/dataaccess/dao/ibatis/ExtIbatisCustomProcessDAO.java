/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO;

// auto generated imports

/**
 * 自定义扩展的数据库操作处理类
 * 
 * @author gaoqs
 */
public class ExtIbatisCustomProcessDAO extends SqlMapClientDaoSupport implements ExtCustomProcessDAO {

    private static final CmccLogger logger = CmccLogger.getLogger(ExtIbatisCustomProcessDAO.class);// 日志

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO#getMapList(java.lang.String,
     * java.util.Map)
     */
    @Override
    public List<Map<String, Object>> getMapList(String sqlIdStr, Map<String, Object> params) {

        if (StringUtils.isBlank(sqlIdStr)) {
            if (logger.isDebugEnabled()) {
                logger.debug("sqlIdStr is empty when execute getMapList");
            }
            return null;
        }

        return getSqlMapClientTemplate().queryForList(sqlIdStr, params);
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO#queryForObject(java.lang.String,
     * java.util.Map)
     */
    @Override
    public Object queryForObject(String sqlIdStr, Map<String, Object> params) {
        if (StringUtils.isBlank(sqlIdStr)) {
            if (logger.isDebugEnabled()) {
                logger.debug("sqlIdStr is empty when execute queryForObject");
            }
            return null;
        }
        if (params != null) {
            return getSqlMapClientTemplate().queryForObject(sqlIdStr, params);
        } else {
            return getSqlMapClientTemplate().queryForObject(sqlIdStr);
        }
    }

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO#queryForObject(java.lang.Class,
     * java.lang.String, java.util.Map)
     */
    @Override
    public <C> C queryForObject(Class<C> entityClass, String sqlIdStr, Map<String, Object> params) {
        if (StringUtils.isBlank(sqlIdStr)) {
            if (logger.isDebugEnabled()) {
                logger.debug("sqlIdStr is empty when execute queryForObject");
            }
            return null;
        }

        return (C) getSqlMapClientTemplate().queryForObject(sqlIdStr, params);
    }

}