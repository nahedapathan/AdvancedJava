package com.controller;

import java.sql.SQLException;

import com.model.Student;
import com.service.StudentService;

public class StudentController {

	StudentService studentservice=new StudentService();
	
	public void createStudent(int id, String name,int age,String grade) throws ClassNotFoundException, SQLException
	{
		Student student=new Student(id,name,age,grade);
		studentservice.registerStudent(student);
		System.out.println("Student has been Added!");
	}
	
	public void showAllStudent() throws ClassNotFoundException, SQLException
	{
		System.out.println("All Details are as: ");
		for(Student stu:studentservice.getStudent())
		{
			System.out.println(stu);
		}
	}
	
    public void updateStudent(int id,int age ,String grade) throws ClassNotFoundException, SQLException
    {
    	Student student=new Student(id,"",age,grade);
    	studentservice.updateStudent(student);
    	System.out.println("Student data Updated");
    }
    
    public void deleteStudent(int id) throws ClassNotFoundException, SQLException
    {
    	Student student =new Student(id,"",0,"");
    	studentservice.deleteStudent(student);
    	System.out.println("Student Data Delete");
    }
    
    public void searchId(int id) throws ClassNotFoundException, SQLException
    {
    	Student student=new Student(id,"",0,"");
    	studentservice.searchId(id);
    }
    
    public void searchName(String name) throws ClassNotFoundException, SQLException
    {
    	Student student=new Student(0,name,0,"");
    	studentservice.searchName(name);
    }
    
    
    
    
    
    
    
    
}


















