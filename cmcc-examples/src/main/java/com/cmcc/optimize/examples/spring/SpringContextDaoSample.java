/**  
 * SpringContextDaoSample.java
 * com.cmcc.optimize.examples.spring
 * 
 * @author gaoqs
 * @date 2014年8月12日 下午3:14:40
 * 版权所有
 */
package com.cmcc.optimize.examples.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCommonProcessDAO;
import com.cmcc.optimize.dataaccess.dao.ibatis.ExtIbatisCommonProcessDAO;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;
import com.cmcc.optimize.examples.util.StringRandomGenSamp;

/**
 * spring 入库示例
 * 
 * @author gaoqs
 * @date 2014年8月12日 下午3:14:40
 */

public class SpringContextDaoSample {

    private static ExtCommonProcessDAO extCommonProcessDAO = SpringBeanContext.getInstance().getBean(ExtIbatisCommonProcessDAO.class, "extCommonProcessDAO"); // ibatisDao

    /**
     * main函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        String[] clos = new String[] { "CELL_ID", "MIN_DISTANCE", "TEST1" };// 列

        List<List<Object>> valueLists = new ArrayList<List<Object>>();
        for (int i = 0; i < 100; i++) {
            List<Object> r = new ArrayList<Object>();
            if(i==9){
                r.add(StringRandomGenSamp.getRandomStr(300));
            }else{
                r.add(StringRandomGenSamp.getRandomStr(127));
            }
            r.add(i);
            r.add(new Date());
            valueLists.add(r);
            if (i % 10000 == 0) {
                System.out.println("==>" + i);

            }
        }

        System.out.println("开始存入数据...");

        long start = new Date().getTime();
        System.out.println("开始：" + start);
        extCommonProcessDAO.batchCommonInsertSingle("T1", Arrays.asList(clos), valueLists, 100);
        long end = new Date().getTime();
        System.out.println("结束：" + end);
        System.out.println("用时：" + (end - start));
    }

}
