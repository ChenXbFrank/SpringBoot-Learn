package com.cxb.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//这里是配置文件的获取值的前缀
@ConfigurationProperties(prefix="text")
//这里是加载配置文件的路径
@PropertySource("classpath:user.properties")
public class UserConfig {
	private String name;
	private int age;
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
