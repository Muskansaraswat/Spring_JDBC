package com.springjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int insert(Student student) {
		// insert query
		String query="insert into student(id,name,city) values(?,?,?)";
		int result=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}
	@Override
	public int change(Student student) {
		// updating data
		String query="UPDATE student SET name=?,city=? where id=?";
		int result=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return result;
	}
	@Override
	public int remove(int studentId) {
		// delete operation
		String query="DELETE FROM student where id=?";
		int result=this.jdbcTemplate.update(query,studentId);
		return result;
	}
	@Override
	public Student getStudent(int studentId) {
		// selecting single student data
		String query="SELECT * FROM student WHERE id=?";
		RowMapper<Student> rw=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query,rw,studentId);
		return student;
	}
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String query="SELECT * FROM student";
		RowMapper<Student> rw=new RowMapperImpl();
		List<Student> students=this.jdbcTemplate.query(query,rw);
		return students;
	}

}
