package com.cxb.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cxb.model.Grade;
import com.cxb.repository.GradeRepository;
import com.cxb.repository.GradeRepository2;
import com.cxb.repository.GradeRepository3;

@Service
public class GradeService {
	
	@Resource
	private GradeRepository gradeRepository;
	
	@Resource
	private GradeRepository2 gradeRepository2;
	
	@Resource
	private GradeRepository3 gradeRepository3;
	
	public Grade findByGradeNm(String gradeNm) {
		return gradeRepository.findByGradeNm(gradeNm);
	}
	
	public Grade findById(int id) {
		return gradeRepository.findById(id);
	}
	
	public Grade findMyGradeNm(String gradeNm) {
		return gradeRepository.findMyGradeNm(gradeNm);
	}
	
	/**
	 * 保存
	 */
	@Transactional
	public void save(Grade grade) {
		gradeRepository2.save(grade);
	}
	
	/**
	 * 删除
	 */
	@Transactional
	public void deleteById(int id) {
		gradeRepository2.deleteById(id);
	}
	
	/**
	 * 获取所有的grade   new PageRequest(0, 3)     Pageable   http://localhost:8888/helloSpringBoot/getAll
	 */
	public Iterable<Grade> getAll() {
		return gradeRepository3.findAll();
	}
	
	/**
	 * 获取所有的grade
	 */
	public Iterable<Grade> getAll2() {
		//这里的teacherId必须为garde里面的属性teacherId 才行哦
		return gradeRepository3.findAll(new Sort(Direction.DESC,"teacherId"));
	}
}
