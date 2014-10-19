/**  
 * EnbParameterParam.java
 * com.cmcc.optimize.dataapi.param
 * 
 * @author gaoqs
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.param;

/**
 * 现网工参查询参数
 * 
 * @author yuminglang
 * @date 2014年6月24日 下午1:34:24
 */
public class EnbParameterParam extends Param{

    public static final String starttime = "starttime";// 开始时间（yyyy-MM-ddHH:mm:ss）

    public static final String endtime = "endtime";// 结束时间（yyyy-MM-ddHH:mm:ss）

    public static final String timeunit = "timeunit";// 时间粒度（小时、天、周、月）

    public static final String areainfo = "areainfo";// 区域粒度（地市、区县、网格、栅格、小区）

}
