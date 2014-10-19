package com.cmcc.optimize.examples.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

/** 
 * 自动生成模板映射文件
 * 
 * @author zhangyonglei
 * @date 2014年8月26日 下午6:10:22
 */
public class Xmlprocess {
    
    private static String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<!-- 数据文件转换模板 -->\n" + "<root>\n" + "	<template_desc>\n" + "		<name>亿阳</name>\n" + "		<desc>亿阳</desc>\n" + "		<ver>1.0</ver>\n" + "		<other>.gz</other>\n" + "		<split_flag>,</split_flag>\n" + "		<ignore_rows>1</ignore_rows>\n"
            + "	</template_desc>\n\n" + "	<!--  -->\n";//文件头

    private static String end = "	</mapping>\n" + "</root>\n";//文件结尾

    /**
     * 生成模板配置
     * 
     * @param sqlfile sql文件脚本
     * @param outpath 输出文件路径
     * @param index 序号
     * @throws IOException
     */
    public static void generateXml(String sqlfile, String outpath, int index) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(sqlfile)));
        String str = reader.readLine();
        FileWriter fwmap = new FileWriter(outpath + "map.xml");
        while (str != null) {
            str = str.trim();
            if (str.length() == 0) {
                str = reader.readLine();
                continue;
            }

            if (str.contains("table")) {
                int countId = -1;
                str = str.replace("(", "");
                String[] strs = str.split("\\s+");
                String table = strs[2].toUpperCase();
                String name = generateFilename(table);

                FileWriter fw = new FileWriter(outpath + name + ".xml");

                fw.write(header);
                fw.write("	<mapping table=\"" + table + "\">" + "\n");
                str = reader.readLine();
                int id = 0;
                for (; !str.trim().equals(")");) {
                    str = str.trim();
                    if (str.length() == 0 || str.equals("(")) {
                        str = reader.readLine();
                        continue;
                    }
                    if (str.startsWith("(")) {
                        str = str.substring(1);
                    }
                    str = str.toLowerCase();
                    String[] tags = str.split("\\s+");
                    if (tags[0].toUpperCase().trim().equals("RECORD_TIME")) {
                        countId = id;
                    }
                    fw.write("		<field>" + "\n");
                    fw.write("			<col_index>" + id + "</col_index>" + "\n");
                    fw.write("			<db_column>" + tags[0].toUpperCase().trim() + "</db_column>" + "\n");
                    // string
                    if (tags[1].trim().contains("varchar")) {
                        fw.write("			<data_type>string</data_type>" + "\n");
                        String strTmp = tags[1].trim();
                        String len = strTmp.substring(strTmp.indexOf("(") + 1, strTmp.indexOf(")"));
                        fw.write("			<rule_valid>.{0," + len + "}</rule_valid>\n");
                    }
                    // timestamp
                    else if (tags[1].trim().contains("timestamp")) {
                        fw.write("			<data_type>timestamp</data_type>" + "\n");
                        fw.write("			<rule_valid></rule_valid>\n");
                        fw.write("			<data_format>yyyy-MM-dd HH:mm:ss</data_format>\n");
                        fw.write("			<defaultValue>${sysdate}</defaultValue>\n");
                    }
                    // number
                    else if (tags[1].trim().contains("number")) {
                        String pattern = generatePattern(tags[1].trim());
                        fw.write("			<data_type>number</data_type>" + "\n");
                        fw.write("			<rule_valid>" + pattern + "</rule_valid>\n");
                    }
                    fw.write("		</field>\n");
                    id++;
                    str = reader.readLine();
                }
                fw.write(end);
                fw.close();
                if (countId >= 0) {
                    fwmap.write("	<file-table-mapping index=\"" + (++index) + "\">\n" + "		<name></name>\n" + "		<parser_file>td_gsm_mapping_mapping/" + name + ".xml</parser_file>\n" + "		<columnNums>" + id + "</columnNums>\n" + "		<needCount>true</needCount><!-- 是否需要统计入库 -->\n" + "		<type>TD/GSM</type>\n"
                            + "		<province>四川</province><!-- 省份 -->\n" + "		<provider>亿阳</provider><!-- 提供者 -->\n" + "		<time_count>" + countId + ",yyyy/MM/dd</time_count><!-- 暂不考虑通用类的处理统计方法，目前只提供按时间，地区的合并统计 --><!-- 按天统计 -->\n" + "	</file-table-mapping>\n");
                } else {
                    fwmap.write("	<file-table-mapping index=\"" + (++index) + "\">\n" + "		<name></name>\n" + "		<parser_file>mapping/" + name + "</parser_file>\n" + "		<columnNums>" + id + "</columnNums>\n" + "		<type>TD/GSM</type>\n" + "		<province>四川</province><!-- 省份 -->\n"
                            + "		<provider>亿阳</provider><!-- 提供者 -->\n" + "	</file-table-mapping>\n");
                }

            } else {
                str = reader.readLine();
                while (str != null) {
                    if (str.trim().equals(")")) {
                        str = reader.readLine();
                        break;
                    }
                    str = reader.readLine();
                }
            }
        }
        reader.close();
        fwmap.close();
    }

    /**
     * 生成模板映射文件
     * 
     * @param tableName 表名
     * @return
     */
    public static String generateFilename(String tableName) {
        StringBuffer buffer = new StringBuffer();
        String words[] = tableName.toLowerCase().split("_");
        for (int id = 1; id < words.length; id++) {
            String word = words[id];
            buffer.append(word.substring(0, 1).toUpperCase() + word.replaceFirst("\\w", ""));
        }
        return buffer.toString();
    }

    /**
     * 生成正则规范
     * 
     * @param num 数值
     * @return
     */
    public static String generatePattern(String num) {
        String word = StringUtils.substringBetween(num, "(", ")");
        String[] tags = word.split(",");
        String pattern3 = "";
        if (tags.length == 2) {
            String num1 = tags[0];
            String num2 = tags[1];
            int numss = Integer.parseInt(num1) - Integer.parseInt(num2) - 1;
            String pattern1 = "([1-9]{1}\\d{0," + numss + "})";
            String pattern2 = "((([1-9]{1}\\d{0," + numss + "})|(0))\\.\\d{1," + num2 + "})";
            pattern3 = "|(null)|(([-]?(" + pattern1 + "|" + pattern2 + "))|[0])";
        } else if (tags.length == 1) {
            String num1 = tags[0];
            String pattern1 = "([1-9]{1}\\d{0," + (Integer.parseInt(num1) - 1) + "})";
            pattern3 = "|(null)|(([-]?" + pattern1 + ")|[0])";
        } else {
            System.out.println("Error");
        }
        return pattern3;
    }

    /**
     * main函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            generateXml("d:/single_sql.txt", "d:/", 10016);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
