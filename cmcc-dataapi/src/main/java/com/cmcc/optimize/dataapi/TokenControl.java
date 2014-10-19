/**  
 * TokenControl.java
 * com.cmcc.optimize.dataapi
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:17:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi;

/**
 * 权限token控制
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:28:25
 */
public class TokenControl {

    /**
     * 验证token是否有效，有权限访问接口
     * 
     * @param token 用户访问标识
     * @param error　错误描述
     * @return　是否可以访问
     */
    public boolean isValid(String token, ErrorWrap error) {
        // TODO 权限控制

        return true;
    }

}