package com.xyc.ssm.webservice.impl;

import org.springframework.stereotype.Component;

import com.xyc.ssm.webservice.TestWebService;
@Component("TestWebService")
public class TestWebServiceImpl implements TestWebService{

	public String hello(String name) {
		System.out.println("hello "+name);
		return "hello "+name;  	
	}

}
