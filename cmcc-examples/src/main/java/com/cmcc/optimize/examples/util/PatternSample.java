/**  
 * PatternSample.java
 * com.cmcc.optimize.examples.util
 * 
 * @author gaoqs
 * @date 2014年7月10日 上午10:04:20
 * 版权所有
 */
package com.cmcc.optimize.examples.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datasyc.config.ConfigUtils;
import com.cmcc.optimize.datasyc.config.FtpFileProcessConfig;

/**
 * 正则sample
 * 
 * @author gaoqs
 * @date 2014年7月10日 上午10:04:20
 */

public class PatternSample {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        test2();
        
        
        String time = ConfigUtils.parseFolderDate("NSN-LTE-MRO-${data:yyyy-MM-dd}.tar.gz").replaceAll("/", "");
        String fileName = "NSN-LTE-MRO-2014-08-21.tar.gz";
        System.out.println(fileName);
        System.out.println(time);
        boolean isFileNameEnableDown = Pattern.compile(time).matcher(fileName).matches();
        System.out.println(isFileNameEnableDown);
    }

    public static void test2() {
        FtpFileProcessConfig ftpProcessConfig = new FtpFileProcessConfig();

        for (FtpDownConfModel conf : ftpProcessConfig.getFtpConfigList()) {
            if(!conf.getHost().equals("10.101.147.167")){
                continue;
            }
            
            String regex = conf.getFileNameRule();
            List<String> list = new ArrayList<String>();

            list.add("HUAWEI-TDD-LTE-20140813.tar.gz");

            for (String string : list) {

                boolean isFileNameEnableDown = Pattern.compile(regex).matcher(string).find();
                if (!isFileNameEnableDown) {
                    System.out.println("未找到：" + string);
                } else {
                    System.out.println(isFileNameEnableDown);
                }
            }
        }

        // number(12,8) |(null)|(([-]?(([1-9]{1}\d{0,5})|((([1-9]{1}\d{0,5})|(0))\.\d{1,8})))|[0])
        // Pattern p=Pattern.compile("|(null)|(([-]?(([1-9]{1}\\d{0,6})|((([1-9]{1}\\d{0,6})|(0))\\.\\d{1,8})))|[0])");
        // boolean isSucc=p.matcher("1986753.41").matches();
        // System.out.println(isSucc);
    }
}
