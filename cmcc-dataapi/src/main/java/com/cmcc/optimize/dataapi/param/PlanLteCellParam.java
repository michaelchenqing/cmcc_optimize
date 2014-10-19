/**  
 * PlanLteCellParam.java
 * com.cmcc.optimize.dataapi.param
 * 
 * @author yuminglang
 * @date 2014年7月4日 下午17:39:24
 * 版权所有
 */
package com.cmcc.optimize.dataapi.param;

/**
 * 规划小区信息查询参数
 * 
 * @author yuminglang
 * @date 2014年7月4日 下午17:39:24
 */
public class PlanLteCellParam extends Param{

    public static final String starttime = "starttime";// 开始时间（yyyy-MM-ddHH:mm:ss）

    public static final String endtime = "endtime";// 结束时间（yyyy-MM-ddHH:mm:ss）

    public static final String timeunit = "timeunit";// 时间粒度（小时、天、周、月）

    public static final String areainfo = "areainfo";// 对应地市集合，不传默认四川全省，传递类似“绵阳”，或者“绵阳,成都”

}
