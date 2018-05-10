package com.cxb.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.model.UserConfig;

@RestController
public class HelloWorldController {
	private static Logger log = Logger.getLogger(HelloWorldController.class); 
	/**
	 * 这种在配置文件里面定义参数是不安全的 (这是从默认配置文件里面取值)
	 * 通过注解的方式实现安全一些
	 */
	//取配置文件里面的值(这是从默认配置文件里面取值)
	@Value("${test.name}")
	private String name;
	@Value("${test.age}")
	private int age;
	
	@Autowired
	private UserConfig userConfig;
	
	@RequestMapping("/hello")
	public String hello() {
		log.info("name****>"+name);
		log.error("age****>"+age);
		System.err.println(name+"---"+age);
		return "Hello World "+userConfig.getName()+"---"+userConfig.getAge();
	}

}
