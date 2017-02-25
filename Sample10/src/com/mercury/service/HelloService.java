package com.mercury.service;

import java.util.List;

import com.mercury.beans.User;
import com.mercury.beans.UserInfo;
import com.mercury.dao.HelloDao;

public class HelloService {
	private HelloDao hd;
	
	public HelloDao getHd() {
		return hd;
	}
	public void setHd(HelloDao hd) {
		this.hd = hd;
	}
	public String sayHello1(User user) {
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<h2><font color=blue>");
		sb.append("Hello " + user.getName() + " with age " + 
				user.getAge() + ", welcome to JavaEE!");
		sb.append("</font></h2>");
		sb.append("</body></html>");
		return sb.toString();
	}
	public String sayHello2(User user) {
		return "Hello " + user.getName() + "(" + user.getAge() 
				+ "), welcome to JavaEE!";
	}
	
	public String process(User user) {
		hd.save(user);
		UserInfo userInfo = new UserInfo();
		userInfo.setMsg(this.sayHello2(user));
		userInfo.setUsers(hd.queryAll());
		return toXML(userInfo.getUsers());
	}
	
	private String toXML(List<User> users) {
		StringBuffer sb = new StringBuffer();
		sb.append("<users>");
		for (User user:users) {
			sb.append("<user>");
			sb.append("<name>" + user.getName() + "</name>");
			sb.append("<age>" + user.getAge() + "</age>");
			sb.append("</user>");
		}
		sb.append("</users>");
		return sb.toString();
	}
}
