package com.cxb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.cxb.model.Person;

/**
 * mybatis的mapper
 * @author 81046
 *
 */
public interface PersonMapper {
	/**
	 * 这里没有在xml中配置  直接在这里将对象和数据库的列名进行一一的对应
	 * @param name
	 * @return
	 */
	@Select("select * from Person where name = #{name}")
	/*@Results({
		@Result(property="id",column="id"),
		@Result(property="name",column="name"),
		@Result(property="sex",column="sex")
	})*/
	public List<Person> getByName(String name);
	
	@Select("select * from Person where id = #{id}")
	public Person getById(int id);
	
	@Select("select name from Person where id = #{id}")
	public String getNameById(int id);

	@Insert("insert into Person(name,sex) values(#{name},#{sex})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") 
	public void save(Person person);
}
