package com.mercury.actions;

import java.util.List;

import com.mercury.beans.User;
import com.mercury.services.HelloService;

public class HelloAction {
	private String name;
	private int age;
	private String message;
	private List<User> users;
	private HelloService hs;
	
	public HelloAction() {
		if (hs==null) {
			hs = new HelloService();
		}
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public HelloService getHs() {
		return hs;
	}
	public void setHs(HelloService hs) {
		this.hs = hs;
	}
	
	public String execute() {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		users = hs.process(user);
		message = hs.sayHello2(user);
		return "RESULT";
	}
}
