/**  
 * AbstractGenerateColumnValue.java
 * com.cmcc.optimize.datamodel.sync.generator
 * 
 * @author bzhou
 * @date 2014年6月29日 上午9:44:33
 * 版权所有
 */
package com.cmcc.optimize.datamodel.sync.generator;

/**
 * 自定义生成列值抽象类
 * 
 * @author bzhou
 * @date 2014年6月29日 上午9:44:33
 */

public class AbstractGenerateColumnValue implements IGenerateColumnValue {

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.datamodel.sync.generator.IGenerateColumnValue#generateValue(java.lang.String,
     * java.lang.String[], java.lang.Object[])
     */
    @Override
    public Object generateValue(String filePath, String[] cells, Object... params) {
        return null;
    }

    /**
     * 根据参数解析出指定的列值
     * 
     * @param cells
     * @param params
     * @return
     */
    protected String parseParam(String[] cells, Object param) {
        // TODO 这里暂时只解析了一种#{格式
        String[] _params = String.valueOf(param).split(",");
        String value = "";
        for (String _param : _params) {
            if (_param.startsWith("#{")) {
                // 是列号
                int colIndex = Integer.parseInt(_param.substring(2, _param.length() - 1));
                value = value + cells[colIndex] + "_";
            }
        }
        return value;

    }
}
