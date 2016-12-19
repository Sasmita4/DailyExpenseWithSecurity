package com.daily.dto;

import java.io.Serializable;

public class SearchDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5462829235423403783L;
	private String fromDate;
	private String toDate;
	private String expenseType;
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	
}
