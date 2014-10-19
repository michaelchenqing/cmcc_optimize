/**  
 * GeneratorForG4EnodeId.java
 * com.cmcc.optimize.datamodel.sync.mapping
 * 
 * @author bzhou
 * @date 2014年6月27日 下午5:34:36
 * 版权所有
 */
package com.cmcc.optimize.datamodel.sync.generator;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.cmcc.log4j.CmccLogger;

/**
 * 生成md5字符串
 * 
 * @author bzhou
 * @date 2014年6月27日 下午5:34:36
 */

public class GeneratorMd5StrValue extends AbstractGenerateColumnValue {

    CmccLogger logger = CmccLogger.getLogger(GeneratorMd5StrValue.class);

    /*
     * (non-Javadoc)
     * @see com.cmcc.optimize.datamodel.sync.generator.AbstractGenerateColumnValue#generateValue(java.lang.String[],
     * java.lang.Object[])
     */
    @Override
    public Object generateValue(String filePath,String[] cells, Object... params) {
        String value = "";
        for (int i = 0; i < params.length; i++) {
            value = value + parseParam(cells, params[i]) + "___";
        }

        try {
            char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            byte[] bytes = value.getBytes("utf-8");
            mdInst.update(bytes);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);

        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5 Algorithm not found", e);
        } catch (UnsupportedEncodingException uce) {
            logger.error("utf-8 unsupported ", uce);
        }

        return null;
    }

}
