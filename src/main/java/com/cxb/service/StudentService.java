package com.cxb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxb.dao.StudentDao;
import com.cxb.model.Student;

@Service
public class StudentService {
	
	@Resource
	private StudentDao studentDao;
	
	public Student selectByName(String name) {
		return studentDao.selectByName(name);
	}
	
	public Student findStudentById(int id) {
		return studentDao.findStudentById(id);
	}
	
	public List<Student> findAll(){
		return studentDao.findAll();
	}
	
	public Student create(Student student) {
		return studentDao.create(student);
	}
	
	public void update(Student student) {
		studentDao.update(student);
	}
	
	public void deleteById(Integer id) {
		studentDao.deleteById(id);
	}

}
