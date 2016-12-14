package com.daily.dto;

import java.io.Serializable;

public class SearchDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5462829235423403783L;
	private String startDate;
	private String endDate;
	private String expenseType;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	
}
