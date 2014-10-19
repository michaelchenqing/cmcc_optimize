/**  
 * AbstractEntity.java
 * com.cmcc.optimize.dataapi.entity
 * 
 * @author yuminglang
 * @date 2014年6月24日 下午1:07:39
 * 版权所有
 */
package com.cmcc.optimize.dataapi.entity;

/**
 * 数据概况响应实体
 * 
 * @author yuminglang
 * @date 2014年6月26日 下午1:53:28
 */
public class AbstractEntity {
	private String type;
    private int AllNum;
    private int days7;
    private int today;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAllNum() {
		return AllNum;
	}
	public void setAllNum(int allNum) {
		AllNum = allNum;
	}
	public int getDays7() {
		return days7;
	}
	public void setDays7(int days7) {
		this.days7 = days7;
	}
	public int getToday() {
		return today;
	}
	public void setToday(int today) {
		this.today = today;
	}
}
