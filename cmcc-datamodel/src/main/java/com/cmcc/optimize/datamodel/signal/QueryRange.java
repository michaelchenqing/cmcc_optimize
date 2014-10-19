package com.cmcc.optimize.datamodel.signal;

/**
 * 查询范围
 * @author zzs
 *
 */
public class QueryRange {

	private String queryField;  //查询字段   例：time
	private String queryStartPos;//查询开始位置 列：1409878075000
	private String queryEndPos; //查询结束位置 列：1409878079000
	
	public String getQueryField() {
		return queryField;
	}
	public void setQueryField(String queryField) {
		this.queryField = queryField;
	}
	public String getQueryStartPos() {
		return queryStartPos;
	}
	public void setQueryStartPos(String queryStartPos) {
		this.queryStartPos = queryStartPos;
	}
	public String getQueryEndPos() {
		return queryEndPos;
	}
	public void setQueryEndPos(String queryEndPos) {
		this.queryEndPos = queryEndPos;
	}
}
