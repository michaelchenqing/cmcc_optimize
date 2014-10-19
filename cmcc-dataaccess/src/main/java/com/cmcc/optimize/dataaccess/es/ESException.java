/**  
 * ESException.java
 * com.cmcc.optimize.dataaccess.es
 * 
 * @author gaoqs
 * @date 2014年9月1日 上午11:45:22
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.es;

/**
 * es处理异常
 * 
 * @author gaoqs
 * @date 2014年9月1日 下午2:35:14
 */
public class ESException extends Exception {

    static final long serialVersionUID = 7818375828146090155L;

    public ESException() {
        super();
    }

    public ESException(String message) {
        super(message);
    }

    public ESException(String message, Throwable cause) {
        super(message, cause);
    }

    public ESException(Throwable cause) {
        super(cause);
    }
}
