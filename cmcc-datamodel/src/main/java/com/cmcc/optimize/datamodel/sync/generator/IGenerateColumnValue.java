/**  
 * IGenerateColumnValue.java
 * com.cmcc.optimize.datamodel.sync.mapping
 * 
 * @author bzhou
 * @date 2014年6月27日 下午5:30:44
 * 版权所有
 */ 
package com.cmcc.optimize.datamodel.sync.generator;

/** 
 * 自定义生成列数据接口
 *
 * @author bzhou
 * @date 2014年6月27日 下午5:30:44
 */

public interface IGenerateColumnValue {

    /** 
     * 生成数据
     * 
     * @param filePath 文件路径
     * @param cells csv行数据
     * @param params 参数配置
     * @return
     */
    public Object generateValue(String filePath,String[] cells , Object... params);
    
}
