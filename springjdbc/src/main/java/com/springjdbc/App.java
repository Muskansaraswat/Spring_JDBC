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
    	//JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
    	//String query="INSERT INTO Student values(?,?,?)";
    	//int result=template.update(query,27,"Prakash Jha","Kanpur");    	
    	
     	StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
     	/*//INSERT
	   	Student student1=new Student();
    	student1.setId(25);
	   	student1.setName("Rutu");
	  	student1.setCity("Nasik");
    	System.out.println("Rows affected "+studentDao.insert(student1));
    	
     	//UPDATE
    	Student student2=new Student();
    	student2.setId(26);
    	student2.setName("Prerna");
	   	student2.setCity("Bhopal");
	   	System.out.println("Data Updated"+studentDao.change(student2));
	     	
     	//DELETE
   	    Scanner input=new Scanner(System.in);
        System.out.print("Enter Student Id : ");
        int id=input.nextInt();
   	    System.out.println("Data Deleted "+studentDao.remove(id));
     	
     	//Selecting single Data
    	Student std=studentDao.getStudent(26);
     	System.out.println(std);*/
     	
     	//Selecting all rows Data
     	List<Student> students=studentDao.getAllStudents();
     	for(Student s:students) {
     		System.out.println(s);
     	}
     	
    }
}
