/**  
 * ConfigUtils.java
 * com.cmcc.optimize.datasyc.config
 * 
 * @author bzhou
 * @date 2014年6月30日 上午11:49:02
 * 版权所有
 */
package com.cmcc.optimize.datasyc.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.cmcc.log4j.CmccLogger;

/**
 * 本项目配置方法通用工具类
 * 
 * @author bzhou
 * @date 2014年6月30日 上午11:49:02
 */

public class ConfigUtils {

    private static CmccLogger logger = CmccLogger.getLogger(ConfigUtils.class);

    /**
     * 替换目录中的时间变量
     * 
     * @param folderTemplate
     * @return
     */
    public static String parseFolderDate(String folderTemplate) {
        // 替换目录中的变量，定义${date:yyyyMMdd}，目前使用简单的替换，后续采用velocity模板替换
        folderTemplate = parseStringDate(folderTemplate);

        // 规范folder path
        if (!folderTemplate.endsWith("/")) {
            folderTemplate = folderTemplate + "/";
        }

        return folderTemplate;
    }

    /**
     * 替换目录中的时间变量
     * 
     * @param folderTemplate
     * @param appointDay
     * @return
     */
    public static String parseFolderDate(String folderTemplate, String appointDay) {
        int idxFolderDate = folderTemplate.indexOf("${data:");
        if (idxFolderDate > -1) {
            // 检查出需要替换时间变量
            String dateFormater = folderTemplate.substring(idxFolderDate, folderTemplate.indexOf("}", idxFolderDate) + 1);
            if (dateFormater.indexOf("-") != -1) {
                String year = appointDay.substring(0, 4);
                String month = appointDay.substring(4, 6);
                String day = appointDay.substring(6, 8);
                appointDay = year + "-" + month + "-" + day;
                folderTemplate = folderTemplate.replace(dateFormater, appointDay);
            } else {
                folderTemplate = folderTemplate.replace(dateFormater, appointDay);
            }
            if (logger.isDebugEnabled()) {
                logger.debug("Target Folder after date parser : " + folderTemplate);
            }
        }
        // 规范folder path
        if (!folderTemplate.endsWith("/")) {
            folderTemplate = folderTemplate + "/";
        }

        return folderTemplate;
    }

    /**
     * 替换字符串中的当前时间
     * 
     * @param folderTemplate 字符串
     * @return 日期替换后的值
     */
    public static String parseStringDate(String folderTemplate) {
        int idxFolderDate = folderTemplate.indexOf("${data:");
        if (idxFolderDate > -1) {
            // 检查出需要替换时间变量
            String dateFormater = folderTemplate.substring(idxFolderDate, folderTemplate.indexOf("}", idxFolderDate) + 1);
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormater.substring(7, dateFormater.length() - 1));
            String dateValue = sdf.format(new Date());
            folderTemplate = folderTemplate.replace(dateFormater, dateValue);
            if (logger.isDebugEnabled()) {
                logger.debug("Target String after date parser : " + folderTemplate);
            }
        }

        return folderTemplate;
    }

    /**
     * 替换目录中的时间变量 例子： folderTemplate：NSN-LTE-MRO-${date:yyyyMMdd}.tar.gz；aFewDaysAgo：3；当前时间：20140824
     * 返回:NSN-LTE-MRO-19340826.tar.gz|NSN-LTE-MRO-19340825.tar.gz|NSN-LTE-MRO-19340824.tar.gz
     * 
     * @param folderTemplate
     * @param aFewDaysAgo 前几天
     * @return
     */
    public static String parseFolderDate(String folderTemplate, int aFewDaysAgo) {
        int idxFolderDate = folderTemplate.indexOf("${data:");
        if (idxFolderDate > -1) {
            // 检查出需要替换时间变量
            String dateFormater = folderTemplate.substring(idxFolderDate, folderTemplate.indexOf("}", idxFolderDate) + 1);
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormater.substring(7, dateFormater.length() - 1));
            sdf.format(new Date());
            Calendar calendar = sdf.getCalendar();
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
            StringBuffer buffer = new StringBuffer();

            buffer.append(folderTemplate.replace(dateFormater, sdf.format(calendar.getTime())));
            for (int i = 1; i < aFewDaysAgo; i++) {
                calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
                String template = folderTemplate;
                template = template.replace(dateFormater, sdf.format(calendar.getTime()));
                buffer.append("|" + template);
            }

            return buffer.toString();
        }
        return folderTemplate;
    }

    public static String getHostName() {
        String hostName = "";
        try {
            hostName = InetAddress.getLocalHost().getHostName().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostName;
    }

    /**
     * 手工回导时，删除不需要回导的文件
     * 
     * @param files
     * @param justImportFiles
     */
    public static void deleteFile(List<String> files, String[] justImportFiles) {
        if (justImportFiles != null && justImportFiles.length > 0) {
            for (int i = files.size() - 1; i >= 0; i--) {
                boolean isIncludeBol = false;
                for (String string : justImportFiles) {

                    // isIncludeBol |= StringUtils.contains(files.get(i), string);

                    if (string.contains("*")) {
                        isIncludeBol = true;
                        String[] args = string.split("\\*");
                        for (String arg : args) {
                            isIncludeBol &= StringUtils.contains(files.get(i), arg);
                            if (!isIncludeBol) {
                                break;
                            }
                        }
                    } else {
                        isIncludeBol |= StringUtils.contains(files.get(i), string);
                    }
                }

                if (!isIncludeBol) {
                    files.remove(i);
                } else if (logger.isDebugEnabled()) {
                    logger.debug("self import just process file:" + files.get(i));
                }
            }
        }
        // return files;
    }

}
