package com.springjdbc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;

public class CRUDTest {

    private ApplicationContext context;
    private StudentDao studentdao;

    @BeforeClass
    public void setUp() {
        // Load the Spring application context
        context = new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
        studentdao = context.getBean(StudentDao.class);
    }

    @AfterClass
    public void tearDown() {
        // Clean up and close resources if needed
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void testCreateStudent() {
        // Implement test for insert query
		/*try{
			Student student = new Student(30,"Sangeeta","Jabalpur");
	        int result=studentdao.insert(student);
	        int expected = 1;
	        Assertion assertion = new Assertion();
			assertion.assertEquals(expected, result);
	        }catch(Exception e){
	            e.printStackTrace();
	     }*/
    }
    @Test
    public void testReadStudent() {
        // Implement test for read/select operation
    	try{
	        Student student = studentdao.getStudent(24);
	        //System.out.println("Fetching one row");
	        int id = student.getId(); 
	        String name = student.getName();
	        String city = student.getCity();
	        Assertion assertion = new Assertion();
			assertion.assertEquals(id,24);
			assertion.assertEquals(name,"Radha");
			assertion.assertEquals(city,"Vrindavan");
	        }catch(Exception e){
	            e.printStackTrace();
	     }
    }
    @Test
    public void testReadAllStudents() {
        // Implement test for read/select operation
    	try{
    		// Call the method to fetch all students from the database
    		List<Student> students = studentdao.getAllStudents();
    		int expectedStudentCount = 9;
    		Assertion assertion = new Assertion();
			// Assert that the list is not null and contains some students
            assertion.assertNotNull(students);
            assertion.assertFalse(students.isEmpty());

            // You can further assert specific conditions, e.g., check the size of the list
            assertion.assertEquals(students.size(),expectedStudentCount);
	        }catch(Exception e){
	            e.printStackTrace();
	     }
    }

    @Test
    public void testUpdateStudent() {
        // Implement test for update operation
    	/*try{
			Student student = new Student(29,"Kusum","Haridawar");
	        int result=studentdao.change(student);
	        int expected = 1;
	        Assertion assertion = new Assertion();
			assertion.assertEquals(expected, result);
	        }catch(Exception e){
	            e.printStackTrace();
	     }*/
    }
    @Test
    public void testDeleteStudent() {
        // Implement test for delete operation
    	/*try{
	        int result=studentdao.remove(22);
	        int expected = 1;
	        Assertion assertion = new Assertion();
			assertion.assertEquals(expected, result);
	        }catch(Exception e){
	            e.printStackTrace();
	     }*/
    }
}
