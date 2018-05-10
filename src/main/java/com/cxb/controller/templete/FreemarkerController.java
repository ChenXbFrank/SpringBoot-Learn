package com.cxb.controller.templete;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerController {
	
	@RequestMapping("/frMak")
	public String hello(Map<String,Object> map) {
		map.put("name", "frank");
		map.put("age", 25);
		return "/freemarker";
	}

}
