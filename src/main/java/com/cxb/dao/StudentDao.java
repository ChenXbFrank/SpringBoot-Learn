package com.cxb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.model.Student;

@Repository
public class StudentDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据名称获取学生对象
	 * @param name
	 * @return
	 */
	public Student selectByName(String name) {
		/**
		 * 1、定义一个Sql语句； 2、定义一个RowMapper. 3、执行查询方法.
		 */
		String sql="select * from student where name = ? ";
		RowMapper<Student> sMapper=new BeanPropertyRowMapper<>(Student.class);
		return jdbcTemplate.queryForObject(sql, new Object[] {name},sMapper);
	}
	
	/**
	 * 获取所有的学生对象
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Student> findAll() {
		return jdbcTemplate.query("select * from student", new StudentRowMapper());
	}

	/**
	 * 根据id查询学生
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Student findStudentById(int id) {
		return jdbcTemplate.queryForObject("select * from student where id=?", new Object[] { id }, new StudentRowMapper());
	}

	/**
	 * 插入学生对象
	 * @param student
	 * @return
	 */
	public Student create(final Student student) {
		final String sql = "insert into student(name,student_id) values(?,?)";

		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, student.getName());
				ps.setInt(2, student.getStudentId());
				return ps;
			}
		}, holder);
		//获取自增长的id
		int newGradeId = holder.getKey().intValue();
		student.setId(newGradeId);
		return student;
	}

	/**
	 * 删除学生对象
	 * @param id
	 */
	public void deleteById(final Integer id) {
		final String sql = "delete from student where id=?";
		jdbcTemplate.update(sql, new Object[] { id }, new int[] { java.sql.Types.INTEGER });
	}

	/**
	 * 修改更新学生对象
	 * @param student
	 */
	public void update(final Student student) {
		jdbcTemplate.update("update student set name=?,student_id=? where id=?",
				new Object[] { student.getName(), student.getStudentId(), student.getId() });
	}
	
	/**
	 * 这里将结果集封装成对象  一一对应
	 * @author 81046
	 *
	 */
	class StudentRowMapper implements RowMapper<Student>{
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student=new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setStudentId(rs.getInt("student_id"));
			return student;
		}
	}
}
