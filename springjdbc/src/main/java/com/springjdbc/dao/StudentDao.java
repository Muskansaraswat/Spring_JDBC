package com.springjdbc.dao;

import java.util.List;

import org.testng.annotations.Test;

import com.springjdbc.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	public int remove(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();
	
}
