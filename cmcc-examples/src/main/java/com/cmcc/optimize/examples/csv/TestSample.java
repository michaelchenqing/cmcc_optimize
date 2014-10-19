/**  
 * TestSample.java
 * com.cmcc.optimize.examples.csv
 * 
 * @author gaoqs
 * @date 2014年7月1日 下午6:03:08
 * 版权所有
 */
package com.cmcc.optimize.examples.csv;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * 开发测试使用smaple，待删除
 * 
 * @author gaoqs
 * @deprecated 临时测试代码
 * @date 2014年7月1日 下午6:03:08
 */

public class TestSample {

    /**
     * TODO(这里用一句话描述这个方法的作用)
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileUtils.forceDelete(new File("D:/data/ftpcache/ftp/mianyang/sichuan_Lte_GSMProject_YY_20140701.csv"));
    }

}
