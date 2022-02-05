package com.baruntech.model;

import java.time.LocalDate;

public class User extends BaseUser {
    private String name;
    private Integer age;
    private String decription;
    private static Long id=0l;
	
    public User(String name,Integer age,String dec) {
    	super(++id,LocalDate.now(),LocalDate.now());
    	this.name=name;
    	this.age=age;
    	this.decription=dec;
    	
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
    
    
	
}
