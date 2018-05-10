package com.cxb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 这是测试原生的repository
 * @author 81046
 *
 */
@Entity
public class Grade {
	
	//主键 自增长
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String gradeNm;
	private int teacherId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGradeNm() {
		return gradeNm;
	}
	public void setGradeNm(String gradeNm) {
		this.gradeNm = gradeNm;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public Grade() {
		
	}
	
}
