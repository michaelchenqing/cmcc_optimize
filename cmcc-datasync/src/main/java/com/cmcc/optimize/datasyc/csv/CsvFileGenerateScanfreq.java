package com.cmcc.optimize.datasyc.csv;

import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.cas.common.utils.StringUtils;

import com.cmcc.optimize.dataaccess.csv.AbstractCsvFileGenerate;
import com.cmcc.optimize.dataaccess.dao.daointerface.ExtCustomProcessDAO;
import com.cmcc.optimize.dataaccess.spring.SpringBeanContext;

/**
 * 生成csv文件--扫频数据
 * 
 * @author yuminglang
 * @date 2014年8月24日 上午15:11:42
 */
public class CsvFileGenerateScanfreq extends AbstractCsvFileGenerate {
    public static final String DEFAULT_FTP_FOLDER="/data/dataservice/scanfreq/";//默认的ftp生成目录
	private ExtCustomProcessDAO extCustomProcessDAO = SpringBeanContext.getInstance().getBean(ExtCustomProcessDAO.class, "extCustomProcessDAO");// 扩展查询dao
	private String city;//地市
	private String grid;//网格
	private String sqlId;//sql ID
	private String csvHead;//csv头
	private String startTime;//开始时间
	private String endTime;//结束时间
	private String testStartTime;//扫频开始时间
	private String testEndTime;//扫频结束时间
	private Integer count;//数据量总数
	private String head;
	private Double pageSize=10000.0;//分页数据量条数
	public CsvFileGenerateScanfreq(){}	
	/**
	 * @param pageSize 分页数据量条数， 默认10000条
	 */
	public CsvFileGenerateScanfreq(int pageSize){
		this.pageSize=(double)pageSize;
	}
	public static void main(String[] args) throws Exception {
		CsvFileGenerateScanfreq csvFileGenerateScanfreq=new CsvFileGenerateScanfreq();
		csvFileGenerateScanfreq.generateCsv("/data/ftp/csv/test.csv", "巴中", "网格1", "h1", 100, null, null, "2014-07-27 00:00:00","");
	}
	/**
	 * @param filePath  生成文件本地路径
	 * @param city		地市
	 * @param grid		网格
	 * @param head		表头   可选值：h1|h2|h3	分别对应3个sql
	 * @param count		地市网格下数据的总数量
	 * @param startTime	开始时间	字段值为空为查询当天数据
	 * @param endTime	结束时间	字段值为空为查询当天数据
	 * @throws Exception
	 */
	public void generateCsv(String filePath, String city, String grid, String head, int count, String startTime, String endTime,String testStartTime,String testEndTime) throws Exception {
		if(StringUtils.isBlank(filePath)||StringUtils.isBlank(city)||org.apache.commons.lang.StringUtils.isBlank(grid)||org.apache.commons.lang.StringUtils.isBlank(head)||count<0){
			throw new Exception("参数为空,csv无法生成.");
		}
		this.city = city;
		this.grid = grid;
		this.head=head;
		this.count = count;
		this.startTime = startTime;
		this.endTime = endTime;
		this.testStartTime = testStartTime;
		this.testEndTime = testEndTime;
		if ("h1".equalsIgnoreCase(head)) {
			csvHead = "时间,经度,纬度,CI,现网小区名称,频点,物理小区标识,参考信号电平,RS有用信号与干扰(或噪声或干扰加噪声)相比强度";
			sqlId = "MULTI-QUERY-SCANFREQ-ZL-SQL-LIST-WITH-MAPPING-PAGING";
		} else if ("h2".equalsIgnoreCase(head)) {
			csvHead = "时间,经度,纬度,频点,物理小区标识,SSS_RSSI,SSS_RP,RSRP,RSRQ,RSCINR";
			sqlId = "MULTI-QUERY-SCANFREQ-SP-SQL-LIST-WITH-MAPPING-PAGING";
		} else if ("h3".equalsIgnoreCase(head)) {
			csvHead = "扫频测试时间,经度,纬度,小区ID,小区名称,全球小区标识,物理小区标识（PCI),地市,网格,下行频点,参考信号电平,RS有用信号与干扰(或噪声或干扰加噪声)相比强度,参考电平质量,SSS_RSSI,SSS_RP";
			sqlId = "MULTI-QUERY-SCANFREQ-ASPS-SQL-LIST-WITH-MAPPING-PAGING";
		}
		this.generateCsvFile(filePath);
	}

	/* (non-Javadoc)
	 * @see com.cmcc.optimize.dataaccess.csv.AbstractCsvFileGenerate#generateHeader(java.io.BufferedWriter)
	 */
	public void generateHeader(BufferedWriter csvFileOutputStream) throws Exception {
		csvFileOutputStream.write(csvHead);// 写入标题
	}

	/* (non-Javadoc)
	 * @see com.cmcc.optimize.dataaccess.csv.AbstractCsvFileGenerate#generateBody(java.io.BufferedWriter)
	 */
	public void generateBody(BufferedWriter csvFileOutputStream) throws Exception {
		int pages = 0;
		String split = ",";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("city", city);
		params.put("grid", grid);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("testStartTime", testStartTime);
		params.put("testEndTime", testEndTime);
		pages = (int) Math.ceil(count / pageSize);
		List<Map<String, Object>> data =null;
		for (int i = 0; i < pages; i++) {
			params.put("startRow", i * pageSize);
			params.put("endRow", (i + 1) * pageSize < count ? (i + 1) * pageSize : count);
			data = extCustomProcessDAO.getMapList(sqlId, params);
			for (Map<String, Object> map : data) {
				csvFileOutputStream.newLine();
				if("h1".equalsIgnoreCase(head)){
					csvFileOutputStream.write((map.get("TEST_TIME").toString()+split+map.get("LONGITUDE")+split+map.get("LATITUDE")+split+map.get("CELL_ID")+split+map.get("CELL_NAME")+split+map.get("EARFCN")+split+map.get("PCI")+split+map.get("RSRP")+split+map.get("RS_CINR_SINR")).replaceAll("null", ""));					
				}else if("h2".equalsIgnoreCase(head)){
					csvFileOutputStream.write((map.get("TEST_TIME").toString()+split+map.get("LONGITUDE")+split+map.get("LATITUDE")+split+map.get("EARFCN")+split+map.get("PCI")+split+map.get("SSS_RSSI")+split+map.get("SSS_RP")+split+map.get("RSRP")+split+map.get("RSRQ")+split+map.get("RS_CINR_SINR")).replaceAll("null", ""));										
				}else if("h3".equalsIgnoreCase(head)){
					csvFileOutputStream.write((map.get("TEST_TIME").toString()+split+map.get("LONGITUDE")+split+map.get("LATITUDE")+split+map.get("CELL_ID")+split+map.get("CELL_NAME")+split+map.get("CGI")+split+map.get("PCI")+split+map.get("CITY")+split+map.get("GRID")+split+map.get("EARFCN")+split+map.get("RSRP")+split+map.get("RS_CINR_SINR")+split+map.get("RSRQ")+split+map.get("SSS_RSSI")+split+map.get("SSS_RP")).replaceAll("null", ""));										
				}
				
			}
		}
	}
}
