package com.daily.dto;

import java.io.Serializable;

public class FoodDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8024959713221637222L;
	private String date;
	private String description;
	private String category;
	private String expense;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	
	
}
