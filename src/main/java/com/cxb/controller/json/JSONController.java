package com.cxb.controller.json;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.model.User;

@RestController
public class JSONController {
	
	/**
	 * 这是使用的默认的处理json的方法
	 * @return
	 */
	@RequestMapping("/getUser")
	public User getUser() {
		User user=new User();
		user.setUserId("123456");
		user.setUserName("cxb");
		user.setCreateDate(new Date());
		return user;
	}
	
	@RequestMapping("/getUserALi")
	public User getUserALi() {
		User user=new User();
		user.setUserId("123456");
		user.setUserName("cxb");
		user.setCreateDate(new Date());
		return user;
	}
}
