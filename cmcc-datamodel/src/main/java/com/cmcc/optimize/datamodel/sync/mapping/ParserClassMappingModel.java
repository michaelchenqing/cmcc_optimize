/**  
 * ParserClassMappingModel.java
 * com.cmcc.optimize.datamodel.sync.mapping
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:52:02
 * 版权所有
 */
package com.cmcc.optimize.datamodel.sync.mapping;

import java.util.List;

import com.cmcc.optimize.datamodel.BaseModel;

/**
 * 自定义转换对象配置模型
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:52:02
 */

public class ParserClassMappingModel extends BaseModel{

    /**
     * 序列化id
     */
    private static final long serialVersionUID = -4776948964233421314L;

    private String params;// 传入参数

    private List<String> parserClass;// 执行的自定义转换类

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public List<String> getParserClass() {
        return parserClass;
    }

    public void setParserClass(List<String> parserClass) {
        this.parserClass = parserClass;
    }

}
