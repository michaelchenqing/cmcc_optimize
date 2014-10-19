/**  
 * TestHdfsUpload.java
 * com.cmcc.optimize.datasyc.scheduler
 * 
 * @author gaoqs
 * @date 2014年7月8日 上午10:09:48
 * 版权所有
 */ 
package com.cmcc.optimize.datasyc.scheduler;

import junit.framework.TestCase;

import com.cmcc.optimize.dataaccess.hdfs.HdfsUploadFileImpl;

/** 
 * hdfs文件上传单元测试
 * 注意：win环境下，需要在hadoop环境/bin下执行：./hadoop fs -chmod 777 /,设置访问权限
 *
 * @author gaoqs
 * @date 2014年7月8日 上午10:09:48
 */

public class TestHdfsUpload extends TestCase{

    /** 
     *
     * @param args
     */
    public  void testHdfsUpload() {
        HdfsUploadFileImpl m=new HdfsUploadFileImpl();
        m.createFile("test/test1.txt", "123456");
    }

}
