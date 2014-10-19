/**  
 * AnalysisEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author yuminglang
 * @date 2014年7月22日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 *数据质量分析响应实体
 * 
 * @author yuminglang
 * @date 2014年7月22日 下午1:53:28
 */
public class AnalysisEntity {
	private String type;
    private String recordTime;
    private Integer inputRate;
    private Integer succRate;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	public Integer getInputRate() {
		return inputRate;
	}
	public void setInputRate(Integer inputRate) {
		this.inputRate = inputRate;
	}
	public Integer getSuccRate() {
		return succRate;
	}
	public void setSuccRate(Integer succRate) {
		this.succRate = succRate;
	}
}
