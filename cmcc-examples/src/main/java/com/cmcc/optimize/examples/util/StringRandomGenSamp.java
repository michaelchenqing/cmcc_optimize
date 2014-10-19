/**  
 * StringRandomGenSamp.java
 * com.cmcc.optimize.examples.util
 * 
 * @author gaoqs
 * @date 2014年8月24日 下午12:00:29
 * 版权所有
 */
package com.cmcc.optimize.examples.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * 随机生成中文串用于测试
 * 
 * @author gaoqs
 * @date 2014年8月24日 下午12:00:29
 */

public class StringRandomGenSamp {

    /**
     * 获取随机中文
     * 
     * @param nums 个数
     * @return
     */
    public static String getRandomStr(int nums) {
        byte[] by = new byte[2];
        int max = 176;
        int min = 247;
        Random random = new Random(System.nanoTime());
        int pos = random.nextInt(max) % (max - min + 1) + min;

        // 插入5个随机字符
        StringBuffer rInStr = new StringBuffer("");
        for (int i = 0; i < nums; i++) {
            max = 247;
            min = 176;
            random = new Random(System.nanoTime());
            pos = random.nextInt(max) % (max - min + 1) + min;
            by[0] = (byte) pos;
            max = 254;
            min = 161;
            random = new Random(System.nanoTime());
            pos = random.nextInt(max) % (max - min + 1) + min;
            by[1] = (byte) pos;
            try {
                rInStr.append(new String(by, "GB2312"));
            } catch (UnsupportedEncodingException e) {
                rInStr.append("高");
            }
        }
        return rInStr.toString();
    }

}
