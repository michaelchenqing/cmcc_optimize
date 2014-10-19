/**  
 * OraTableMappingModel.java
 * com.cmcc.optimize.datamodel.sync.mapping
 * 
 * @author bzhou
 * @date 2014年6月25日 下午4:55:32
 * 版权所有
 */
package com.cmcc.optimize.datamodel.sync.mapping;

import java.util.ArrayList;
import java.util.List;

/**
 * oracle映射关系
 * 
 * @author bzhou
 * @date 2014年6月25日 下午3:10:01
 */

public class OraTableMappingModel {

    private String tableName; // 表名

    private List<ColumnMappingModel> columns; // 配置列

    private List<String> columnNames; // 列名

    private List<List<Object>> insertValues; // 入库时候的数据列

    /**
     * @return the columnNames
     */
    public List<String> getColumnNames() {
        return columnNames;
    }

    /**
     * @param columnNames the columnNames to set
     */
    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    /**
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the columns
     */
    public List<ColumnMappingModel> getColumns() {
        return columns;
    }

    /**
     * @return the insertValues
     */
    public List<List<Object>> getInsertValues() {
        return insertValues;
    }

    /**
     * @param insertValues the insertValues to set
     */
    public void setInsertValues(List<List<Object>> insertValues) {
        this.insertValues = insertValues;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(List<ColumnMappingModel> columns) {
        this.columns = columns;
        columnNames = new ArrayList<String>(columns.size());
        for (ColumnMappingModel col : columns) {
            columnNames.add(col.getDbColumn());
        }
    }

}
