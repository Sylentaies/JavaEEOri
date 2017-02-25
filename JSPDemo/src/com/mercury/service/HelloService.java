package com.mercury.service;

import com.mercury.beans.User;
import com.mercury.beans.UserInfo;
import com.mercury.dao.HelloDao;
import com.mercury.dao.impl.HelloDaoImpl;

public class HelloService {
	private HelloDao hd;
	
	public HelloService(){
		if(hd == null){
			hd = new HelloDaoImpl();
		}
	}
	public String sayHello1(User user){
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<h1 style = 'color:blue'>");
		sb.append("Hello "+ user.getName()+ " with age "+ user.getAge()+", Welcome to JSP!");
		sb.append("</h1>");
		sb.append("</html></body>");
		return sb.toString();
	}
	public String sayHello2(User user){
		return "Hello "+ user.getName()+ " ("+ user.getAge()+"), Welcome to JSP!";
	}
	public UserInfo process(User user){
		hd.save(user);
//		hd.update(user);
		UserInfo userInfo = new UserInfo();
		userInfo.setMsg(this.sayHello2(user));
//		userInfo.setMsg(this.sayHello2(hd.loadUserByName(user.getName())));
		userInfo.setUsers(hd.queryAll());
		return userInfo;
	}

}
