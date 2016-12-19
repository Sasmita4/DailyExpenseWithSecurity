package com.daily.dto;

import java.io.Serializable;

public class ReportResultDto implements Serializable{
   /**
	 * 
	 */
   private static final long serialVersionUID = -6821220424484734651L;
   
	private String expense;
	private String description;
	private String date;
	private String category;
	   
    private String fromDate;
    private String toDate;
	private String totalExpense;
   

	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
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
	public String getTotalExpense() {
		return totalExpense;
	}
	public void setTotalExpense(String totalExpense) {
		this.totalExpense = totalExpense;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
