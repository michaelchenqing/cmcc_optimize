/**  
 * BasicModel.java
 * com.cmcc.optimize.datamodel
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:54:02
 * 版权所有
 */
package com.cmcc.optimize.datamodel;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 模型蕨类
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:54:02
 */

@SuppressWarnings("serial")
public class BaseModel implements Serializable {

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
