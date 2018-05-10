package com.cxb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.cxb.model.Grade;

public interface GradeRepository extends Repository<Grade, Integer>{

	public Grade findByGradeNm(String gradeNm);
	
	public Grade findById(int id);
	
	@Query("from Grade where gradeNm=:nm")
	public Grade findMyGradeNm(@Param("nm") String gradeNm);
	
}
