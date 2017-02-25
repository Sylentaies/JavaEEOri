package com.mercury.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	private String name;
	private int age;
	private String viewPage;
	
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
	public String getViewPage() {
		return viewPage;
	}
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	
	
	@RequestMapping ("/hello")
	public ModelAndView sayHello(HttpServletRequest request){
		String name=request.getParameter("name");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("helloworld");
		mav.addObject("msg","Hello, "+name+ ", welcome to spring MVC!!!");
		return mav;
	}
	@RequestMapping("/main")
	public String main(){
		return "main";
	}
	@RequestMapping("/message")
	@ResponseBody
	public String getMessage(){
		return "This is a message";
	}
	@RequestMapping("/change")
	public ModelAndView change(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:"+viewPage);
		mav.addObject("name",this.name);
		mav.addObject("age",this.age);
		return mav;
	}
	
}
