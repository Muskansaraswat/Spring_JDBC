package com.springjdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("My JDBC Connectivity Program ");
    	//spring jdbc ->JdbcTemplate
    	ApplicationContext context=new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
		//Simplest method without using interface
//		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
//		String query="INSERT INTO Student values(?,?,?)";
//		int result=template.update(query,23,"Prakash Jha","Kanpur");
//    	
    	
     	StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
//    	//INSERT
//    	Student std=new Student();
//    	std.setId(20);
//    	std.setName("Manish");
//    	std.setCity("Lucknow");
//    	System.out.println("Rows affected "+studentDao.insert(std));
    	
     	//UPDATE
//    	Student std=new Student();
//    	std.setId(222);
//    	std.setName("Meghna Arora");
//    	std.setCity("Punjab");
//    	System.out.println("Data Updated"+studentDao.change(std));
     	
     	//DELETE
//    	Scanner input=new Scanner(System.in);
//        System.out.print("Enter Student Id : ");
//        int id=input.nextInt();
//     	System.out.println("Data Deleted "+studentDao.remove(id));
     	
     	//Selecting single Data
//     	Student std=studentDao.getStudent(id);
//     	System.out.println(std);
     	
     	//Selecting all rows Data
     	List<Student> students=studentDao.getAllStudents();
     	for(Student s:students) {
     		System.out.println(s);
     	}
     	
    }
}
