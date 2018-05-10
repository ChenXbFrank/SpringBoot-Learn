package com.cxb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cxb.model.Grade;

public interface GradeRepository2 extends CrudRepository<Grade, Integer>{

	public Grade findByGradeNm(String gradeNm);
	
	@Query("from Grade where gradeNm=:nm")
	public Grade findMyGradeNm(@Param("nm") String gradeNm);
	
}
