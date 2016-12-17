package com.daily.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "food")
public class Food implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2988172794450980046L;

	@Id
	private String id;

	//private Long cnt;
	
	@NotNull
	private Date date;
	
	@NotNull
	private String description;
	
	@NotNull
	private String category;
	
	@NotNull
	private String expense;
	
	@NotNull
	private String email;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	/*public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}*/

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
