/**  
 * FtpFileTemplateMappingModel.java
 * com.cmcc.optimize.datamodel.sync
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:33:56
 * 版权所有
 */
package com.cmcc.optimize.datamodel.sync;

import java.util.ArrayList;
import java.util.List;

import com.cmcc.optimize.datamodel.BaseModel;
import com.cmcc.optimize.datamodel.sync.mapping.ExtendsCodeMappingModel;
import com.cmcc.optimize.datamodel.sync.mapping.OraTableMappingModel;
import com.cmcc.optimize.datamodel.sync.mapping.ParserClassMappingModel;

/**
 * ftp模板处理文件与数据库表映射对象
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:33:56
 */

public class FtpFileTemplateModel extends BaseModel {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = -2383213274766024411L;

    private String name;// 模板名称

    private String description;// 模板描述

    private String version;// 版本

    private String otherInfo;// 其他描述信息　

    private int ignoreRows;// 忽略行数

    private String splitString;// 分割字符串

    private List<OraTableMappingModel> tableMapping;// 字段映射

    private List<ExtendsCodeMappingModel> extendsCode;// 扩展代码

    private List<ParserClassMappingModel> parserClass;// 自定义转换类

    private int columnNums = -1;// csv文件列数，-1时，不校验列长度
                                // ，参照FtpFileMappingModel.columnNums，该值由FtpFileMappingModel.columnNums设置

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ExtendsCodeMappingModel> getExtendsCode() {
        return extendsCode;
    }

    public void setExtendsCode(List<ExtendsCodeMappingModel> extendsCode) {
        this.extendsCode = extendsCode;
    }

    public List<ParserClassMappingModel> getParserClass() {
        return parserClass;
    }

    public void setParserClass(List<ParserClassMappingModel> parserClass) {
        this.parserClass = parserClass;
    }

    /**
     * @return the ignoreRows
     */
    public int getIgnoreRows() {
        return ignoreRows;
    }

    /**
     * @param ignoreRows the ignoreRows to set
     */
    public void setIgnoreRows(int ignoreRows) {
        this.ignoreRows = ignoreRows;
    }

    /**
     * @return the splitString
     */
    public String getSplitString() {
        return splitString;
    }

    /**
     * @param splitString the splitString to set
     */
    public void setSplitString(String splitString) {
        this.splitString = splitString;
    }

    /**
     * @return the tableMapping
     */
    public List<OraTableMappingModel> getTableMapping() {
        if (tableMapping == null) {
            tableMapping = new ArrayList<OraTableMappingModel>();
        }
        return tableMapping;
    }

    /**
     * @param tableMapping the tableMapping to set
     */
    public void setTableMapping(List<OraTableMappingModel> tableMapping) {
        this.tableMapping = tableMapping;
    }

    public int getColumnNums() {
        return columnNums;
    }

    public void setColumnNums(int columnNums) {
        this.columnNums = columnNums;
    }

}
