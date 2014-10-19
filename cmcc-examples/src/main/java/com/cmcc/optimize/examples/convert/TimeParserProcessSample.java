/**  
 * TimeParserProcessSample.java
 * com.cmcc.optimize.examples.convert
 * 
 * @author gaoqs
 * @date 2014年7月3日 下午2:30:59
 * 版权所有
 */
package com.cmcc.optimize.examples.convert;

/** 
 * 时间字符串处理
 *
 * @author gaoqs
 * @date 2014年7月22日 下午4:46:49
 */
public class TimeParserProcessSample {

    public static void main(String[] args) {
        String s="2014-07-20 12:00:00".substring(0,"yyyy-MM-dd hh".length());
        System.out.println(s);
    }

}
