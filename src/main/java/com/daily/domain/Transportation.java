package com.daily.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transportation")
public class Transportation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4756298707582176450L;

	@Id
	private String date;
	
	@NotNull
	private String description;
	
	@NotNull
	private String category;
	
	@NotNull
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}
	
	
	

}
