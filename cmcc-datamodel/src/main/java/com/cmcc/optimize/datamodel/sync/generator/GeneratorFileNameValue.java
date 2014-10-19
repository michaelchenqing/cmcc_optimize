/**  
 * GeneratorFileNameValue.java
 * com.cmcc.optimize.datamodel.sync.generator
 * 
 * @author gaoqs
 * @date 2014年8月24日 下午1:15:17
 * 版权所有
 */
package com.cmcc.optimize.datamodel.sync.generator;

import java.io.File;

import com.cmcc.log4j.CmccLogger;

/**
 * 从文件名中取出对应的内容，进行赋值：分隔符，取第几个值(从0开始) _,2
 * 
 * @author gaoqs
 * @date 2014年8月24日 下午1:15:17
 */

public class GeneratorFileNameValue extends AbstractGenerateColumnValue {

    CmccLogger logger = CmccLogger.getLogger(GeneratorFileNameValue.class);// 日志

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.datamodel.sync.generator.AbstractGenerateColumnValue#generateValue(java.lang.String,
     * java.lang.String[], java.lang.Object[])
     */
    @Override
    public Object generateValue(String filePath, String[] cells, Object... params) {
        File file = new File(filePath);
        if (file.isDirectory()) {
            return null;
        }

        if (params == null || params.length <= 0) {
            return null;
        }
        String detailParams[] = params[0].toString().split(",");

        String split =null;
        int index =0;
        
        try {
            split = detailParams[0].toString();
            index = Integer.parseInt(detailParams[1].toString());
            String value = file.getName().split(split)[index];

            return value;
        } catch (Exception e) {
            logger.error("parser value error:" + filePath+"@"+split+"@"+index, e);
        }
        return null;
    }

}
