package com.cxb.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.dao.PersonMapper;
import com.cxb.model.Person;

@Service
public class PersonService {
	@Autowired
	private PersonMapper personMapper;
	
	public List<Person> getByName(String name){
		return personMapper.getByName(name);
	}
	
	public Person getById(int id) {
		return personMapper.getById(id);
	}

	public String getNameById(int id) {
		return personMapper.getNameById(id);
	}
	
	@Transactional
	public void save(Person person) {
		personMapper.save(person);
	}
}
