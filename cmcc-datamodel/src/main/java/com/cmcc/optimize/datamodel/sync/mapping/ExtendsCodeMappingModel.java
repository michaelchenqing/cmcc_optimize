/**  
 * ExtendsCodeMappingModel.java
 * com.cmcc.optimize.datamodel.sync.mapping
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:48:38
 * 版权所有
 */
package com.cmcc.optimize.datamodel.sync.mapping;

import java.util.List;

import com.cmcc.optimize.datamodel.BaseModel;

/**
 * 扩展脚本配置对象
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:48:38
 */

public class ExtendsCodeMappingModel extends BaseModel {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = -57118677970103794L;

    private String params;// 传入参数

    private List<String> extendsCode;// 执行的扩展的代码

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public List<String> getExtendsCode() {
        return extendsCode;
    }

    public void setExtendsCode(List<String> extendsCode) {
        this.extendsCode = extendsCode;
    }

}
