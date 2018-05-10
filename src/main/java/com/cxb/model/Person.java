package com.cxb.model;

/**
 * 这是用来测试mybatis的实体类
 * @author 81046
 *
 */
public class Person {
	private int id;
	private String name;
	private int sex; //0男  1女
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
}
