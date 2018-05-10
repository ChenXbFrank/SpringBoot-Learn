package com.cxb.controller.jdbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.model.Student;
import com.cxb.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Resource
	private StudentService studentService;

	/**
	 * 根据名称获取学生    http://localhost:8888/helloSpringBoot/student/selectByName?name=cxb
	 */
	@RequestMapping("/selectByName")
	public Student selectByName(String name) {
		return studentService.selectByName(name);
	}
	
	/**
	 * 查询所有的学生
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Student> findAll(){
		return studentService.findAll();
	}
	
	/**
	 * 新增一个学生对象
	 * @return
	 */
	@RequestMapping("/create")
	public Student create() {
		Student student=new Student();
		student.setName("dyx");
		student.setStudentId(666);
		return studentService.create(student);
	}
	
	/**
	 * 更新学生对象
	 */
	@RequestMapping("/update")
	public void update() {
		Student student=studentService.findStudentById(1);
		student.setName("陈小兵");
		student.setStudentId(8888);
		studentService.update(student);
	}
	
	/**
	 * 根据id删除学生对象
	 * @param id
	 */
	@RequestMapping("/delete")
	public void deleteById(Integer id) {
		studentService.deleteById(id);
	}
}
