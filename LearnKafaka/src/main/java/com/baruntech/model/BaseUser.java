package com.baruntech.model;

import java.time.LocalDate;

public class BaseUser {
	
	private Long id;
	private LocalDate createddate;
	private LocalDate modifieDate;
	
	public BaseUser(Long id,LocalDate creDate,LocalDate moDate) {
		this.id=id;
		this.createddate=creDate;
		this.modifieDate=moDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getCreateddate() {
		return createddate;
	}
	public void setCreateddate(LocalDate createddate) {
		this.createddate = createddate;
	}
	public LocalDate getModifieDate() {
		return modifieDate;
	}
	public void setModifieDate(LocalDate modifieDate) {
		this.modifieDate = modifieDate;
	}
	
	

}
