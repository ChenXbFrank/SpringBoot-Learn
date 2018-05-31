package com.cxb.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public User(String userId, String userName, Date createDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
	}
	public User() {
		super();
	}
	
}
