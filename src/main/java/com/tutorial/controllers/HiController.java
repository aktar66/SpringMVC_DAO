package com.tutorial.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tutorial._01DAOConnectionPoolingDummy.SelectImple;


public class HiController implements Controller{
	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String empName = getEmpName();
		
		return new ModelAndView("helloworld", "newMessage",empName);
		//helloworld is my view
		// message is double quotes is my key to the model data
		// message without double quotes is my model data
	}
	
	String getEmpName(){
		
		String empName = null;
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/tutorial/_01DAOConnectionPoolingDummy/spring.cfg.xml");
		SelectImple s=(SelectImple)ctx.getBean("sel");
		empName = s.fetchEmpName(100);
		System.out.println("Employee name is: "+ empName);		
		//ctx.close();
		return empName;
		
		
	}
	
	
}