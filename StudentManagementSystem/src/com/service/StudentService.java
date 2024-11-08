package com.service;

import java.sql.SQLException;
import java.util.List;

import com.DAO.StudentDAO;
import com.model.Student;

public class StudentService {

	private StudentDAO studentdao=new StudentDAO();
	
	public void registerStudent(Student student) throws ClassNotFoundException, SQLException
	{
		if(student.getName()!=null && !student.getName().isEmpty() && student.getId()!=0 )
		{
			studentdao.addStudent(student);
		}
		else
		{
			System.out.println("Invalid Student Details...");
		}
	}
	
	public List<Student> getStudent() throws ClassNotFoundException, SQLException
	{
		return studentdao.getAllStudent();
	}
	
	public void updateStudent(Student student) throws ClassNotFoundException, SQLException
	{
		studentdao.updateStudent(student);
	}
	
	public void deleteStudent(Student student) throws ClassNotFoundException, SQLException
	{
		studentdao.deleteStudent(student);
	}
	
	
	
	public void searchId(int id) throws ClassNotFoundException, SQLException
	{
		Student student=studentdao.serchById(id);
		if(student!=null)
		{
			System.out.println(student);
		}
		else
		{
			System.out.println(id+" Does not exit!");
		}
	}
	
	public void searchName(String name) throws ClassNotFoundException, SQLException
	{
		Student student=studentdao.searchByName(name);
		if(student!=null)
		{
			System.out.println(student);
		}
		else
		{
			System.out.println(name+" does not exit! ");
		}
	}
	
	
	
	
}










