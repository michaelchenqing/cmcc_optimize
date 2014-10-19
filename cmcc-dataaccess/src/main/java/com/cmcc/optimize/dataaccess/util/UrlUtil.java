package com.cmcc.optimize.dataaccess.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import ahocorasick.patternmatcher.IPatternMatcher;
import ahocorasick.patternmatcher.PatternMatcher;
import cn.cas.common.io.FileUtils;

import com.cmcc.log4j.CmccLogger;

/**
 * url解析工具类 url文件地址：resources/urls.txt url文件格式： URL(key),分类名(value) url文件标准：URL无重复-->key
 * 
 * @author huangc
 * @date 2014年9月16日
 */
public class UrlUtil {
    private static final CmccLogger logger = CmccLogger.getLogger(UrlUtil.class);// 日志

    private Map<String, String> businessMap = null;

    private IPatternMatcher patternMatcher = null;

    /**
     * 无参构造
     */
    public UrlUtil() {

        patternMatcher = new PatternMatcher();
        businessMap = new HashMap<String, String>();

        InputStream inputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = FileUtils.getRealInputStream("urls.txt");
            reader = new InputStreamReader(inputStream, "GBK");
            bufferedReader = new BufferedReader(reader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] args = line.split(",");
                if (args.length != 2) { // txt文件格式控制
                    logger.error("urls.txt  context error!");
                    continue;
                }
                String key = args[0].replaceAll("\\*", "");
                businessMap.put(key, args[1]); // map赋值,url-业务类型

                patternMatcher.addPattern(key);

            }

        } catch (Exception e) {
            logger.error("reader urls.txt error", e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error("close reader stream error!");
            }

        }

    }

    /**
     * 返回url对应的业务大类 url包含了某個key，即取這個key，否則返回“未定義類型”
     * 
     * @param url
     * @return
     */
    public String urlParse(String url) {
        // 正则
        for (String string : patternMatcher.checkText(url)) {
            return businessMap.get(string);
        }
        return "未定义";
        
    }
    
    public static void main(String[] args) {
        UrlUtil url = new UrlUtil();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 40000; i++) {
            url.urlParse("info.3g.qq.com");
        }

        System.out.println(System.currentTimeMillis() - time);
    }
}
