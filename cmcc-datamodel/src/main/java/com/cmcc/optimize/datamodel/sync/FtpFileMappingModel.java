/**  
 * FtpFileTemplateMappingModel.java
 * com.cmcc.optimize.datamodel.sync
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:33:56
 * 版权所有
 */
package com.cmcc.optimize.datamodel.sync;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.cmcc.optimize.datamodel.BaseModel;

/**
 * ftp文件名与模板处理文件映射关系对象
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:33:56
 */

public class FtpFileMappingModel extends BaseModel {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 6070378191602610685L;

    private long index;// 匹配顺序

    private String fileNameRegular;// 文件名规则

    private String templateParserFile;// 匹配映射模板文件

    private int columnNums = -1;// csv文件列数，-1时，不校验列长度

    private boolean needCount;// 是否需要统计入库

    private String type;// 统计类型

    private String province;// 省份

    private String city;// 市

    private String provider;// 提供者

    private String dataGeneration;// 数据网络制式:GSM/TDSCDMA/TDLTE

    private String timeCount;// 按时间统计

    private int timceCountIndex;// 时间统计字段

    private String timeCountFormat;// 时间统计格式化

    private int areaCountIndex;// 按地区统计字段

    private boolean timeCountFlag;// 设置timceCount字段和areaCount字时，该值为true，不进行按天统计

    public static final String countTableName = "MB_BIN_PROCESS_INFO"; // 统计存入的表名

    // 统计表存入的列名：时间,数据类型,省，市，数据制式，原始数据数目,原始数据文件数,当日处理或存储数据量大小,数据来源
    public static final List<String> countTableColumNames = Arrays.asList(new String[] { "record_time", "type", "province", "city", "data_generation", "original_record_num", "original_file_num", "original_file_size", "data_origin" });

    private SimpleDateFormat format;// 原数据格式

    private SimpleDateFormat produceFormat = new SimpleDateFormat("yyyyMMdd hh");// 统计存储过程需要格式

    private String encoding = "GB18030";// 指定文件编码

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getFileNameRegular() {
        return fileNameRegular;
    }

    public boolean isNeedCount() {
        return needCount;
    }

    public void setNeedCount(boolean needCount) {
        this.needCount = needCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getDataGeneration() {
        return dataGeneration;
    }

    public void setDataGeneration(String dataGeneration) {
        this.dataGeneration = dataGeneration;
    }

    public void setFileNameRegular(String fileNameRegular) {
        this.fileNameRegular = fileNameRegular;
    }

    public String getTemplateParserFile() {
        return templateParserFile;
    }

    public void setTemplateParserFile(String templateParserFile) {
        this.templateParserFile = templateParserFile;
    }

    public int getColumnNums() {
        return columnNums;
    }

    public void setColumnNums(int columnNums) {
        this.columnNums = columnNums;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(String timeCount) {
        this.timeCount = timeCount;
    }

    public int getTimceCountIndex() {
        return timceCountIndex;
    }

    public void setTimceCountIndex(int timceCountIndex) {
        this.timceCountIndex = timceCountIndex;
    }

    public String getTimeCountFormat() {
        return timeCountFormat;
    }

    public void setTimeCountFormat(String timeCountFormat) {
        this.timeCountFormat = timeCountFormat;
        this.format = new SimpleDateFormat(timeCountFormat);
    }

    public int getAreaCountIndex() {
        return areaCountIndex;
    }

    public void setAreaCountIndex(int areaCountIndex) {
        this.areaCountIndex = areaCountIndex;
    }

    public boolean isTimeCountFlag() {
        return timeCountFlag;
    }

    public void setTimeCountFlag(boolean timeCountFlag) {
        this.timeCountFlag = timeCountFlag;
    }

    /**
     * 调用话统和路测数据统计时，将type映射成为输入参数 '1' 话统，'2' 路测,'3' MRO,'4' 信令
     * 
     * @return
     */
    public String getProduceTypeIndex() {
        if (StringUtils.equals("话统", type)) {
            return "1";
        } else if (StringUtils.equals("路测", type)) {
            return "2";
        } else if (StringUtils.equals("MRO", type)) {
            return "3";
        } else if (StringUtils.equals("信令", type)) {
            return "4";
        } else {
            return "-1";
        }
    }

    /**
     * 将日期格式成存储过程需要的输入 20121212 12
     * 
     * @param time 原始的字符串
     * @return
     * @throws ParseException
     */
    public String getProduceTimeFormat(String time) throws ParseException {
        return produceFormat.format(format.parse(time));
    }

    /**
     * 将日期格式成存储过程需要的输入
     * 
     * @param time 原始的字符串
     * @return
     * @throws ParseException
     */
    public Date getTimeDateFormat(String time) throws ParseException {
        return format.parse(time);
    }

    public Date getTimeDateFormat(String time, String formatStr) throws ParseException {
        return new SimpleDateFormat(formatStr).parse(time);
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

}
