package com.mercury.services;

import java.util.List;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mercury.dao.impl.HelloDaoImpl;

public class HelloService {
	private HelloDao hd;
	
	public HelloService() {
		if (hd==null) {
			hd = new HelloDaoImpl();
		}
	}
	public String sayHello1(User user) {
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<h2><font color=blue>");
		sb.append("Hello " + user.getName() + " with age " + user.getAge() + ", welcome to Struts 2!");
		sb.append("</font></h2>");
		sb.append("</body></html>");
		return sb.toString();
	}
	
	public String sayHello2(User user) {
		return "Hello " + user.getName() + "(" + user.getAge() + "), welcome to Struts 2!";
	}
	
	public List<User> process(User user) {
		hd.save(user);
		return hd.queryAll();
	}
}
