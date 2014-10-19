/**  
 * XmlFileLoader.java
 * com.cmcc.optimize.dataaccess.xml
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:11:04
 * 版权所有
 */
package com.cmcc.optimize.dataaccess.xml;

import java.io.InputStream;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;

import cn.cas.common.io.FileUtils;

import com.cmcc.log4j.CmccLogger;

/**
 * 加载xml文件
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:11:04
 */

public class XmlFileLoader {

    private static final CmccLogger logger = CmccLogger.getLogger(XmlFileLoader.class);// 日志

    /**
     * 加载xml文件成jdom document
     * 
     * @param path
     * @return
     */
    public static Document getXmlFileDocument(String path) {
        InputStream is = FileUtils.getRealInputStream(path);
        SAXBuilder builder = new SAXBuilder();
        Document document = null;

        if (logger.isDebugEnabled()) {
            logger.debug("load xml file:" + path);
        }

        try {
            document = builder.build(is);
        } catch (Exception e) {
            logger.error("load xml file error:" + path, e);
        }

        return document;
    }

    // TODO 添加按xpath获取Element的方法

}
