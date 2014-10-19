package com.cmcc.optimize.dataapi;

import cn.cas.common.utils.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 定义服务常见错误
 * 
 * @author sw
 * 
 */
/**
 * reset常用api错误
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:05:16
 */
public class ErrorWrap {

    public RestError error;// 错误枚举定义

    public String errMsg;// 错误自定义描述

    /**
     * 错误码枚举
     * 
     * @author gaoqs
     * @date 2014年6月29日 上午9:56:28
     */
    public enum RestError {

        DAO_ERROR("701", "db error"), // 数据库查询错误

        TOKEN_ERROR("702", "invalid token"), // token异常

        OTHER_ERROR("703", "other error"), // 其他系统异常

        PARAM_ERROR("704", "error parameter"), // 参数异常

        NOTFOUND_ERROR("705", "info not found"), // 数据未找到

        JSON_ERROR("706", "json parse error");// json转换异常

        private String errorCode;// 错误码

        private String errorDes;// 错误描述

        /**
         * 默认的无参构造函数
         */
        RestError() {
        }

        /**
         * 通过错误码与错误描述构造
         * 
         * @param errorCode
         * @param errorDes
         */
        RestError(String errorCode, String errorDes) {
            this.setErrorCode(errorCode);
            this.setErrorDes(errorDes);
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorDes() {
            return errorDes;
        }

        public void setErrorDes(String errorDes) {
            this.errorDes = errorDes;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            JSONObject jso = new JSONObject();
            jso.put("errorCode", this.errorCode);
            jso.put("errorDes", this.errorDes);
            return jso.toJSONString();
        }

    }

    public RestError getError() {
        return error;
    }

    public void setError(RestError error) {
        this.error = error;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        JSONObject jso = new JSONObject();
        if (this.error != null) {
            jso.put("errorCode", this.error.errorCode);
            jso.put("errorDes", this.error.errorDes);
        }
        if (StringUtils.isNotBlank(errMsg)) {
            jso.put("errorMsg", this.errMsg);
        }
        return jso.toJSONString();
    }

}
