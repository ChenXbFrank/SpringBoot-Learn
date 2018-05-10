package com.cxb.controller.repository;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cxb.model.Grade;
import com.cxb.service.GradeService;

/**
 * 使用模板就要用@Controller 不要用@RestController
 * @author 81046
 *
 */
@Controller
@RequestMapping("/grade")
public class GradeController {
	
	//注意这里的service需要用@Resource注入
	@Resource
	private GradeService gradeService;
	
	@GetMapping("/findById")
	public Grade findById(int id) {
		return gradeService.findById(id);
	}
	
	/**
	 * http://localhost:8888/helloSpringBoot/grade/findByGradeNm?gradeNm=cxb
	 * @param gradeNm
	 * @return
	 */
	@GetMapping("/findByGradeNm")
	public Grade findByGradeNm(String gradeNm) {
		System.out.println("**GradeController******findByGradeNm******");
		return gradeService.findByGradeNm(gradeNm);
	}
	
	@GetMapping("/findMyGradeNm")
	public Grade findMyGradeNm(String gradeNm) {
		System.out.println("**GradeController******findMyGradeNm******");
		return gradeService.findMyGradeNm(gradeNm);
	}
	
	/**
	 * 保存grade对象
	 */
	@RequestMapping("/save")
	public String save() {
		Grade grade=new Grade();
		grade.setGradeNm("jack");
		grade.setTeacherId(789);
		gradeService.save(grade);
		return "save ok";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public String deleteById() {
		gradeService.deleteById(1);
		return "delete ok";
	}
	
	/**
	 * 获取所有    http://localhost:8888/helloSpringBoot/getAll
	 */
	@RequestMapping("/getAll")
	public Iterable<Grade> getAll() {
		return gradeService.getAll();
	}
	
	/**
	 * 获取所有
	 */
	@RequestMapping("/getAll2")
	public Iterable<Grade> getAll2() {
		return gradeService.getAll2();
	}
}
