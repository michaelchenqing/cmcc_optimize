/**  
 * ＣolumnMappingModel.java
 * com.cmcc.optimize.datamodel.sync.mapping
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:47:49
 * 版权所有
 */
package com.cmcc.optimize.datamodel.sync.mapping;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang.StringUtils;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.datamodel.BaseModel;

/**
 * 数据源与数据库表字段一一关联映射对象
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:47:49
 */

public class ColumnMappingModel extends BaseModel {

    public static final String DB_DATA_TYPE_VARCHAR = "string"; // ORACLE数据类型-VARCHAR

    public static final String DB_DATA_TYPE_TIMESTAMP = "timestamp"; // ORACLE数据类型-TIMESTAMP

    public static final String DB_DATA_TYPE_NUMBER = "number"; // ORACLE数据类型-NUMBER

    public static final String DEFAULT_VAL_PATTERN_SYSDATE = "${sysdate}"; // DefaultValue中的sysdate

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 默认oracle timestamp转换器

    private static final CmccLogger logger = CmccLogger.getLogger(ColumnMappingModel.class);// 日志

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1235329613877230936L;

    private String table;// 存入数据表名

    private int colIndex;// 数据文件中的列值

    private String dbColumn;// 数据库表字段

    private String dataType;// 数据类型，java的基础类型及对象类型

    private String ruleValid;// 数据校验规则，校验失败时，将整个文件不进行导入

    private String dataFormat; // 日期格式化格式

    private Pattern pattern; // 校验数据格式的模板

    private SimpleDateFormat speDataFormat; // 私有日期格式化

    private String defaultValue = ""; // 默认数据

    private String parseHandlerClass; // 指定处理类

    private Class<?> _parseHandlerClass;

    private Object _parseHandler;

    private String parseHandlerParams; // 指定处理参数

    /**
     * @return the dataFormat
     */
    public String getDataFormat() {
        return dataFormat;
    }

    /**
     * @param dataFormat the dataFormat to set
     */
    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
        if (null == dataFormat || dataFormat.length() == 0)
            return;
        if (dataType.equalsIgnoreCase(DB_DATA_TYPE_TIMESTAMP)) {
            speDataFormat = new SimpleDateFormat(dataFormat);
        }
    }

    public int getColIndex() {
        return colIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }

    public String getDbColumn() {
        return dbColumn;
    }

    public void setDbColumn(String dbColumn) {
        this.dbColumn = dbColumn;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getRuleValid() {
        return ruleValid;
    }

    public void setRuleValid(String ruleValid) {
        this.ruleValid = ruleValid;
        if (null == ruleValid || ruleValid.length() == 0)
            return;
        try {
            pattern = Pattern.compile(ruleValid);
        } catch (PatternSyntaxException pse) {
            logger.error("Colunm Rule Pattern Error", pse);
        }
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * 在csv行数据中获取入库的实际值
     * 
     * @param cells
     * @return
     */
    public Object getInsertValue(String filePath, String[] cells) {
        if (null != _parseHandler) {
            try {
                Method m = _parseHandlerClass.getMethod("generateValue", String.class,String[].class, Object[].class);
                return m.invoke(_parseHandler, filePath, cells, new Object[] { parseHandlerParams });
            } catch (NoSuchMethodException nsme) {
                logger.error("Config Error, No Such Method", nsme);
            } catch (Exception e) {
                logger.error(e);
            }
        }

        if (colIndex < 0)
            return getInsertValue(defaultValue);

        if (colIndex >= cells.length)
            return null;

        return getInsertValue(cells[colIndex]);
    }

    /**
     * 获取oracle下对应数据类型的Insert方法
     * 
     * @param value
     * @return
     */
    public Object getInsertValue(String value) {
        // 首先检查通配符

        // 转换通配符${sysdate}
        if (DEFAULT_VAL_PATTERN_SYSDATE.equalsIgnoreCase(value)) {
            return new Date();
        }

        // VARCHAR
        if (dataType.equalsIgnoreCase(DB_DATA_TYPE_VARCHAR)) {
            return value;
        }

        // TIMESTAMP
        if (dataType.equalsIgnoreCase(DB_DATA_TYPE_TIMESTAMP)) {
            if (null == value || value.trim().length() == 0) {
                return null;
            }

            try {
                if (speDataFormat != null) {
                    return speDataFormat.parse(value);
                } else {
                    return sdf.parse(value);
                }
            } catch (Exception e) {
                return null;
            }
        }

        // NUMBER
        if (dataType.equalsIgnoreCase(DB_DATA_TYPE_NUMBER)) {
            if (null == value || value.trim().length() == 0)
                return null;
            else
                return value;
        }

        return null;
    }

    /**
     * 检查数据合法性
     * 
     * @param cells
     * @return
     */
    public boolean checkValue(String[] cells) {
        // 使用default value
        if (colIndex < 0)
            return true;
        else if (colIndex < cells.length)
            return checkValue(cells[colIndex]);
        else {
            logger.warn("check value error , get column index " + colIndex + " of cells length :" + cells.length);
            return false;
        }

    }

    /**
     * 检查数据是否符合rule
     * 
     * @param value
     * @return
     */
    public boolean checkValue(String value) {
        if (pattern == null) {
            return true;
        }

        if (!DB_DATA_TYPE_VARCHAR.equalsIgnoreCase(dataType)) {
            value = value.trim();
        }

        Matcher matcher = pattern.matcher(value);
        boolean isMatch = matcher.matches();
        if (!isMatch) {
            return isMatch;
        }

        // 对于字符类型的数据，如果存在中文，计算长度时，为2个
        if (StringUtils.isNotBlank(ruleValid) && StringUtils.startsWith(ruleValid, ".{") && StringUtils.endsWith(ruleValid, "}")) {
            String lengthCheck[] = ruleValid.substring(2, ruleValid.length() - 1).split(",");
            if (lengthCheck != null && lengthCheck.length == 2) {
                try {
                    // 获取字符串的长度约定
                    int maxInt = Integer.parseInt(lengthCheck[1]);
                    // 获取字符串二进制长度
                    int realLen = getWordCount(value);
                    if (realLen > maxInt) {
                        logger.error("db length not enough：" + value + ",realLen：" + realLen + "，needLen：" + maxInt);
                        return false;
                    }
                } catch (Exception e) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("no integer length:" + ruleValid, e);
                    }
                    return true;
                }
            }
        }

        return true;
    }

    /**
     * 获取字符串实际长度，中文为2，存入db，验证
     * 
     * @param s 字符串
     * @return 实际的长度
     */
    private static int getWordCount(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255)
                length++;
            else
                length += 2;

        }
        return length;

    }

    /**
     * @return the parseHandlerClass
     */
    public String getParseHandlerClass() {
        return parseHandlerClass;
    }

    /**
     * @param parseHandlerClass the parseHandlerClass to set
     */
    public void setParseHandlerClass(String parseHandlerClass) {
        if (null == parseHandlerClass)
            return;
        this.parseHandlerClass = parseHandlerClass;
        try {
            _parseHandlerClass = Class.forName(parseHandlerClass);
            _parseHandler = _parseHandlerClass.newInstance();
        } catch (ClassNotFoundException cnfe) {
            logger.error("Config Error, No Such Handler For " + parseHandlerClass, cnfe);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * @return the parseHandlerParmas
     */
    public String getParseHandlerParams() {
        return parseHandlerParams;
    }

    /**
     * @param parseHandlerParmas the parseHandlerParmas to set
     */
    public void setParseHandlerParams(String parseHandlerParams) {
        this.parseHandlerParams = parseHandlerParams;
    }

}
