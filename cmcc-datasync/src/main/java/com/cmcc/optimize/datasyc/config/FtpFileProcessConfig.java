/**  
 * FtpFileProcessConfig.java
 * com.cmcc.optimize.datasyc.config
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:18:30
 * 版权所有
 */
package com.cmcc.optimize.datasyc.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.jdom2.Document;
import org.jdom2.Element;

import cn.cas.common.io.FileUtils;

import com.cmcc.log4j.CmccLogger;
import com.cmcc.optimize.dataaccess.xml.XmlFileLoader;
import com.cmcc.optimize.datamodel.sync.FtpDownConfModel;
import com.cmcc.optimize.datamodel.sync.FtpFileMappingModel;
import com.cmcc.optimize.datamodel.sync.FtpFileTemplateModel;
import com.cmcc.optimize.datamodel.sync.mapping.ColumnMappingModel;
import com.cmcc.optimize.datamodel.sync.mapping.ExtendsCodeMappingModel;
import com.cmcc.optimize.datamodel.sync.mapping.OraTableMappingModel;
import com.cmcc.optimize.datamodel.sync.mapping.ParserClassMappingModel;

/**
 * ftp下载文件转换配置文件加载
 * 
 * @author gaoqs
 * @date 2014年6月23日 下午1:18:30
 */

public class FtpFileProcessConfig {

    private static final CmccLogger logger = CmccLogger.getLogger(FtpFileProcessConfig.class);// 日志

    public static final String FTP_FILE_PROCESS_COUNTER = "ftp_file_process_counter";// ftp文件处理标记

    public static final String FTP_FILE_BACKUP_COUNTER = "ftp_file_backup_counter";// ftp文件备份标记

    public static final String FTP_FILE_SYC_SUCC = "syc_succ";// ftp文件同步到redis标记

    public static final String FTP_FILE_DOWN_SUCC = "down_succ";// ftp文件下载完成标记
    
    public static final String REPLENISH_SUCC = "replenish_succ";// 补采完成标记

    public static final String FTP_FILE_PROCESS_SUCC = "process_succ";// ftp文件处理完成标记

    public static final String FTP_FILE_BACKUP_SUCC = "backup_succ";// ftp文件备份完成标记

    private static String DEFAULT_LOCAL_FTP_CACHE_FOLDER = "/data/ftpcache/ftp/";// 默认的ftp本地下载临时目录

    private static List<FtpDownConfModel> ftpConfigList;// ftp服务器配置

    private static List<FtpFileMappingModel> fileMappingList;// 文件名与模板映射配置

    private static Map<String, FtpFileTemplateModel> fileTemplateMap;// 映射模板map<文件路径，配置对象>

    private static Map<String, String> extendsCodeMap;// 外挂脚本map<文件路径，配置脚本>

    private static Map<String, FtpDownConfModel> map = new HashMap<String, FtpDownConfModel>();// 匹配ftp服务器配置<本地文件夹，ftp配置>

    /**
     * 获取同步reids成功的redis key
     * 
     * @param path
     * @return
     * @throws Exception
     */
    public static String getRedisMarkerSycSucc(String path) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("getRedisMarkerSycSucc: " + FTP_FILE_SYC_SUCC + ":" + formatRedisPath(path));
        }
        return FTP_FILE_SYC_SUCC + ":" + formatRedisPath(path);
    }

    /**
     * 获取下载完成的redis key
     * 
     * @param path
     * @return
     * @throws Exception
     */
    public static String getRedisMarkerDownLoadSucc(String path) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("getRedisMarkerDownLoadSucc: " + FTP_FILE_DOWN_SUCC + ":" + formatRedisPath(path));
        }
        return FTP_FILE_DOWN_SUCC + ":" + formatRedisPath(path);
    }

    /**
     * 获取处理完成的redis key
     * 
     * @param path
     * @return
     * @throws Exception
     */
    public static String getRedisMarkerProcessSucc(String path) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("getRedisMarkerProcessSucc: " + FTP_FILE_PROCESS_SUCC + ":" + formatRedisPath(path));
        }
        return FTP_FILE_PROCESS_SUCC + ":" + formatRedisPath(path);
    }

    /**
     * 获取备份完成的redis key
     * 
     * @param path
     * @return
     * @throws Exception
     */
    public static String getRedisMarkerBackupSucc(String path) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("getRedisMarkerBackupSucc: " + FTP_FILE_BACKUP_SUCC + ":" + formatRedisPath(path));
        }
        return FTP_FILE_BACKUP_SUCC + ":" + formatRedisPath(path);
    }
    
    
    /**
     * 获取mro补采redis key
     * 
     * @param path
     * @return
     * @throws Exception
     */
    public static String getRedisMarkerReplenishSucc(String path) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("getRedisMarkerReplenishSucc: " + REPLENISH_SUCC + ":" + formatRedisPath(path));
        }
        return REPLENISH_SUCC + ":" + formatRedisPath(path);
    }

    /**
     * 格式化path为 foldername/filename, 前面没有'/', speator为'/'
     * 
     * @param path 除去ftpcache根目录外的路径
     * @return
     * @throws Exception
     */
    private static String formatRedisPath(String path) throws Exception {
        String _path = path.replace("\\", "/");
        while (_path.charAt(0) == '/') {
            _path = _path.substring(1);
        }
        // if (!_path.contains("/"))
        // throw new Exception("Illegal redis file key:" + path);
        return _path;
    }

    /**
     * 构造函数，加载配置文件
     */
    public FtpFileProcessConfig() {

        // 读取ftp待下载的配置文件
        Document ftpDownConfigDoc = XmlFileLoader.getXmlFileDocument("ftp_down_conf.xml");
        initFtpDownconf(ftpDownConfigDoc);

        // 读取文件映射配置文件
        Document ftpMappingFileDoc = XmlFileLoader.getXmlFileDocument("file_mapping.xml");
        initFtpMappingConf(ftpMappingFileDoc);
    }

    /**
     * 解析文件映射配置
     * 
     * @param doc xml的document对象
     */
    private void initFtpMappingConf(Document doc) {
        Element root = doc.getRootElement();

        List<Element> mappingTableElement = root.getChildren("file-table-mapping");
        if (mappingTableElement == null || mappingTableElement.size() <= 0) {
            if (logger.isDebugEnabled()) {
                logger.debug("not mapping config in file_mapping.xml");
            }
            return;
        }

        fileMappingList = new ArrayList<FtpFileMappingModel>();// 文件到模板映射
        fileTemplateMap = new HashMap<String, FtpFileTemplateModel>();// 模板文件配置
        extendsCodeMap = new HashMap<String, String>();// 扩展脚本

        for (Element element : mappingTableElement) {
            FtpFileMappingModel model = new FtpFileMappingModel();

            model.setFileNameRegular(element.getChildText("name"));

            String indexValue = element.getAttributeValue("index");
            if (!StringUtils.isBlank(indexValue)) {
                model.setIndex(Long.parseLong(indexValue));
            }

            String mappingFilePath = element.getChildText("parser_file");
            model.setTemplateParserFile(mappingFilePath);

            String columnNums = element.getChildText("columnNums");
            if (StringUtils.isNotBlank(columnNums)) {
                try {
                    model.setColumnNums(Integer.parseInt(columnNums));
                } catch (Exception e) {// 不检测csv文件的列数
                    logger.warn("parse csv file column nums error,use default -1,not check csv file colunm nums:" + model.getFileNameRegular(), e);
                }
            }

            String encoding = element.getChildText("encoding");
            if (StringUtils.isNotBlank(encoding)) {
                model.setEncoding(encoding);
            }

            // 加载是否需要统计表信息
            Element countElement = element.getChild("needCount");
            if (countElement != null) {
                boolean needCount = element.getChildText("needCount").equals("true") ? true : false;
                if (needCount) {
                    model.setNeedCount(needCount);
                    model.setType(element.getChildText("type"));
                    model.setProvince(element.getChildText("province"));
                    model.setProvider(element.getChildText("provider"));
                    model.setCity(element.getChildText("city"));
                    model.setDataGeneration(element.getChildText("data_generation"));

                    Element timeE = element.getChild("time_count");
                    if (timeE != null) {
                        String timeStrs[] = timeE.getText().split(",");
                        model.setTimceCountIndex(Integer.parseInt(timeStrs[0]));
                        model.setTimeCountFormat(timeStrs[1]);
                        if (StringUtils.contains(timeStrs[1], " ")) {// 存在空格，则表示按小时统计
                            model.setTimeCountFlag(true);
                        }
                    }

                    Element areaE = element.getChild("area_count");
                    if (areaE != null) {
                        model.setAreaCountIndex(Integer.parseInt(areaE.getText()));
                    } else {// 未设置时，不使用地区统计
                        model.setAreaCountIndex(-1);
                    }

                }
            }

            // 加载mapping配置文件
            FtpFileTemplateModel mappingTemplate = initMappingFile(mappingFilePath);

            fileTemplateMap.put(mappingFilePath, mappingTemplate);
            fileMappingList.add(model);
        }

        // 对文件映射顺序进行排序调整

    }

    /**
     * 加载映射关联模板文件
     * 
     * @param filePath
     * @return
     */
    private FtpFileTemplateModel initMappingFile(String filePath) {
        Document mappingTemplateDoc = XmlFileLoader.getXmlFileDocument(filePath);
        Element root = mappingTemplateDoc.getRootElement();

        FtpFileTemplateModel model = new FtpFileTemplateModel();

        // 基础信息
        Element descElement = root.getChild("template_desc");
        if (descElement != null) {
            model.setName(descElement.getChildText("name"));
            model.setVersion(descElement.getChildText("ver"));
            model.setDescription(descElement.getChildText("desc"));
            model.setOtherInfo(descElement.getChildText("other"));
            model.setSplitString(descElement.getChildText("split_flag"));

            int ignoreRows = 0;// 设置表头忽略的csv行数
            if (StringUtils.isNotBlank(descElement.getChildText("ignore_rows")) && Integer.parseInt(descElement.getChildText("ignore_rows")) > 0) {
                ignoreRows = Integer.parseInt(descElement.getChildText("ignore_rows"));
            }
            model.setIgnoreRows(ignoreRows);
        }

        // 按mapping中的属性内容，判断设置不同的映射配置
        List<Element> mappingElement = root.getChildren("mapping");
        if (mappingElement == null || mappingElement.size() <= 0) {
            if (logger.isDebugEnabled()) {
                logger.debug("no mappings in mapping template file :" + filePath);
            }
            return model;
        }

        for (Element element : mappingElement) {
            String tableName;
            if ((tableName = element.getAttributeValue("table")) != null) {

                List<ColumnMappingModel> columns = new ArrayList<ColumnMappingModel>();

                String table = element.getAttributeValue("table");

                List<Element> fieldMaps = element.getChildren("field");
                if (fieldMaps != null && fieldMaps.size() > 0) {
                    for (Element fieldElement : fieldMaps) {
                        ColumnMappingModel colMapModel = new ColumnMappingModel();

                        // 表字段与数据源映射
                        colMapModel.setTable(table);
                        if (null != fieldElement.getChildText("col_index")) {
                            colMapModel.setColIndex(Integer.parseInt(fieldElement.getChildText("col_index")));
                        }

                        colMapModel.setDataType(fieldElement.getChildText("data_type"));
                        colMapModel.setRuleValid(fieldElement.getChildText("rule_valid"));
                        colMapModel.setDbColumn(fieldElement.getChildText("db_column"));
                        colMapModel.setDataFormat(fieldElement.getChildText("data_format"));
                        colMapModel.setDefaultValue(fieldElement.getChildText("defaultValue"));
                        colMapModel.setParseHandlerClass(fieldElement.getChildText("handlerClass"));
                        colMapModel.setParseHandlerParams(fieldElement.getChildText("handlerParam"));

                        columns.add(colMapModel);
                    }
                }

                OraTableMappingModel oraTableMapping = new OraTableMappingModel();
                oraTableMapping.setColumns(columns);
                oraTableMapping.setTableName(tableName);

                model.getTableMapping().add(oraTableMapping);

            } else {
                // 外挂脚本与自定义处理类
                String params = element.getAttributeValue("params");

                List<Element> parserClass = element.getChildren("parser_class");
                List<Element> extendsCode = element.getChildren("extends_code");

                List<String> patchs = new ArrayList<String>();// 外挂脚本，自定义转换类

                // 存在自定义转换对象配置
                if (parserClass != null && parserClass.size() > 0) {
                    if (model.getParserClass() == null) {// 需要添加自定义转换类
                        model.setParserClass(new ArrayList<ParserClassMappingModel>());
                    }

                    for (Element e : parserClass) {// 可定义多个自定义转换类
                        patchs.add(e.getValue());
                    }

                    // 自定义转换类
                    ParserClassMappingModel parserModel = new ParserClassMappingModel();
                    parserModel.setParams(params);
                    parserModel.setParserClass(patchs);

                    model.getParserClass().add(parserModel);
                }

                // 存在扩展脚本配置
                if (extendsCode != null && extendsCode.size() > 0) {
                    if (model.getExtendsCode() == null) {// 需要添加脚本扩展类
                        model.setExtendsCode(new ArrayList<ExtendsCodeMappingModel>());
                    }

                    for (Element e : extendsCode) {// 可指定多个外挂脚本执行
                        patchs.add(e.getValue());
                        InputStream input = FileUtils.getRealInputStream(e.getValue());
                        byte[] bytes = null;
                        try {
                            bytes = FileUtils.fromInputStream(input);
                            extendsCodeMap.put(e.getValue(), new String(bytes, "UTF-8"));
                        } catch (IOException e1) {
                            logger.error("extends code load error:" + e.getValue(), e1);
                        } finally {
                            if (input != null) {
                                try {
                                    input.close();
                                } catch (IOException e1) {
                                    logger.error("close input error:" + e1);
                                }
                            }
                        }
                    }

                    // 扩展脚本
                    ExtendsCodeMappingModel extendsModel = new ExtendsCodeMappingModel();
                    extendsModel.setParams(params);
                    extendsModel.setExtendsCode(patchs);

                    model.getExtendsCode().add(extendsModel);
                }

            }
        }

        return model;
    }

    /**
     * 解析ftp下载文件列表配置
     * 
     * @param doc xml的document对象
     */
    private void initFtpDownconf(Document doc) {
        Element root = doc.getRootElement();

        // 设置ftp本地缓存目录
        Element localTempFolderElement = root.getChild("local_temp_folder");
        if (localTempFolderElement != null && StringUtils.isNotBlank(localTempFolderElement.getValue())) {
            if (logger.isDebugEnabled()) {
                logger.debug("use ftp local cache folder:" + localTempFolderElement.getValue());
                DEFAULT_LOCAL_FTP_CACHE_FOLDER = localTempFolderElement.getValue();
                try {
                    if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
                        String path = new File("./").getAbsolutePath().replace("\\", "/");
                        DEFAULT_LOCAL_FTP_CACHE_FOLDER = path.substring(0, path.indexOf("/")) + DEFAULT_LOCAL_FTP_CACHE_FOLDER;
                    }
                } catch (Exception e) {
                    if (logger.isDebugEnabled()) {// 兼容win下调试hdfs
                        logger.debug("set windows debug folder start flag error:" + DEFAULT_LOCAL_FTP_CACHE_FOLDER);
                    }
                }
            }
        }

        // 加载ftp文件监控配置
        Element downConf = root.getChild("ftp_down_conf");
        if (downConf == null) {
            logger.warn("no ftp download config,please add <ftp_down_conf><ftp>");
            return;
        }

        List<Element> ftpElements = downConf.getChildren("ftp");
        if (ftpElements == null || ftpElements.size() <= 0) {
            logger.warn("no ftp download config,please add <ftp>");
            return;
        }

        ftpConfigList = new ArrayList<FtpDownConfModel>();
        for (Element e : ftpElements) {
            FtpDownConfModel model = new FtpDownConfModel();

            // ftp下载配置，xml节点解析为配置对象
            model.setFileNameRule(e.getChild("file_name_rule").getValue());
            model.setFtpFolder(e.getChild("ftp_folder").getValue());
            model.setCornString(e.getChild("corn_string").getValue());
            model.setHost(e.getChild("host").getValue());
            model.setLocalFolder(e.getChild("local_folder").getValue());
            model.setPassword(e.getChild("password").getValue());
            model.setPort(e.getChild("port").getValue());
            model.setUserName(e.getChild("user_name").getValue());
            model.setCustomJobClass(e.getChild("custom_job_class").getValue());

            // 存入文件目录检测，检测指定时间文件是否存在
            Element checkElement = e.getChild("check");
            if (checkElement != null) {
                Element fileListElement = checkElement.getChild("file_list");
                Element checkCornStringElement = checkElement.getChild("corn_string");
                if (fileListElement != null && checkCornStringElement != null && StringUtils.isNotBlank(fileListElement.getText()) && StringUtils.isNotBlank(checkCornStringElement.getText())) {
                    String fileListStr = fileListElement.getText().trim();
                    String[] fileListStrs = fileListStr.split(",");
                    if (fileListStrs != null && fileListStrs.length > 0) {
                        List<String> fileList = new ArrayList<String>();
                        for (String file : fileListStrs) {
                            fileList.add(file);
                        }
                        model.setCheckFileList(fileList);

                        String checkCornStr = checkCornStringElement.getText();
                        model.setCheckCornString(checkCornStr);
                    }

                }

            }

            // 是否列出所有的子目录
            Element listSubElement = e.getChild("list_sub");
            if (listSubElement != null) {
                model.setNeedListSubFtpFiles(Boolean.parseBoolean(listSubElement.getValue()));
            }

            ftpConfigList.add(model);

            // key为本地文件路径，用于匹配ftp连接方式
            map.put(model.getLocalFolder(), model);
        }
    }

    /**
     * 获取ftp本地缓存目录
     * 
     * @return
     */
    public static String getDefaultFtpLocalCacheFolder() {
        return DEFAULT_LOCAL_FTP_CACHE_FOLDER;
    }

    /**
     * ftp服务器配置
     * 
     * @return
     */
    public List<FtpDownConfModel> getFtpConfigList() {
        return ftpConfigList;
    }

    /**
     * 根据文件名获取处理mapping
     * 
     * @param filepath
     * @return
     */
    public static FtpFileMappingModel getFileMappingTypeByPath(String filepath) {
        for (FtpFileMappingModel model : fileMappingList) {
            String filepath_reg = model.getFileNameRegular();
            Pattern p = Pattern.compile(filepath_reg);
            Matcher m = p.matcher(filepath);
            if (m.find()) {
                return model;
            }
        }

        return null;
    }

    /**
     * 根据文件名获取文件转换模板
     * 
     * @param filepath
     * @return
     */
    public static FtpFileTemplateModel getFileTemplateMapByPath(String filepath) {
        filepath = filepath.replaceAll("\\\\", "/");
        if (filepath.contains("/")) {
            filepath = filepath.substring(filepath.lastIndexOf("/") + 1);
        }
        if (filepath.endsWith(".gz")) {
            filepath = filepath.substring(0, filepath.length() - 3);
        }

        FtpFileMappingModel model;
        if ((model = getFileMappingTypeByPath(filepath)) == null)
            return null;

        FtpFileTemplateModel templateModel;
        if ((templateModel = fileTemplateMap.get(model.getTemplateParserFile())) != null) {
            templateModel.setColumnNums(model.getColumnNums());// 将FtpFileTemplateModel.ColumnNums设置到FtpFileTemplateModel.ColumnNums，不再查询一次文件映射
            return templateModel;
        }
        return null;
    }

    /**
     * @return the fileMappingList
     */
    public static List<FtpFileMappingModel> getFileMappingList() {
        return fileMappingList;
    }

    /**
     * @return the fileTemplateMap
     */
    public static Map<String, FtpFileTemplateModel> getFileTemplateMap() {
        return fileTemplateMap;
    }

    /**
     * @return the extendsCodeMap
     */
    public static Map<String, String> getExtendsCodeMap() {
        return extendsCodeMap;
    }

    /**
     * 通过localFolder判断ftp设置
     * 
     * @param localFolder
     * @return
     */
    public FtpDownConfModel getFtpDownConfModel(String localFolder) {
        return map.get(localFolder);
    }
}
