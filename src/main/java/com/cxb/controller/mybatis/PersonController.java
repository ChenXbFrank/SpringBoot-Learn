package com.cxb.controller.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.model.Person;
import com.cxb.service.PersonService;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	/**
	 * http://localhost:8888/helloSpringBoot/person/getByName?name=cxb
	 * @param name
	 * @return
	 */
	@RequestMapping("/getByName")
	public List<Person> selectByName(String name){
		return personService.getByName(name);
	}
	
	@RequestMapping("/getById")
	public Person getById(int id){
		return personService.getById(id);
	}
	
	@RequestMapping("/getNameById")
	public String getNameById(int id) {
		return personService.getNameById(id);
	}
	
	@RequestMapping("/getByName2")
	public List<Person> selectByGradeNm2(String name){
		// 第几页；几条数据
		PageHelper.startPage(2,3);
		return personService.getByName(name);
	}
	
	@RequestMapping("/save")
	public Person save(Person person){
		personService.save(person);
		return person;
	}
}
