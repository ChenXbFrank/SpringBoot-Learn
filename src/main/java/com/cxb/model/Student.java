package com.cxb.model;

/**
 * jdbc的使用 需要手动创建表  学生类是用来测试jdbc的哦
 * @author 81046
 *				
 */
public class Student {
	private int id;
	private String name;
	private int studentId;
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
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Student() {
		super();
	}
	
}
