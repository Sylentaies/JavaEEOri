package com.mercury.beans;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class User extends ActionForm {
	private String name;
	private int age;
	public User(){}
	public User(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
