package com.cxb.controller.templete;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	
	/**
	 * 这个问题困扰了很久没有明白  最终需要建立maven web 项目才可以  心塞
	 * 这里不知道为什么就是访问不成功   因为需要建立的是maven web 项目才可以支持JSP  看下一个JspDemo则成功了
	 * Error resolving template "indexJsp", template might not exist or 
	 * might not be accessible by any of the configured Template Resolvers
	 * @param map
	 * @return
	 */
	@RequestMapping("/jspIndex")
	public String hello(Map<String,Object> map) {
		map.put("name", "小石潭记");
		map.put("age", 28);
		return "indexJsp";
	}
}
