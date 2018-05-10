package com.cxb.controller.templete;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
	
	@RequestMapping("/thyHtml")
	public String thyHtml(Map<String,Object> map) {
		map.put("name", "cxb");
		map.put("age", 18);
		return "/thymeleaf";
	}

}
