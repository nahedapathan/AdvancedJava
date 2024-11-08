package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.DBConnection;
import com.model.Student;

public class StudentDAO {
	
	Connection conn=null;
	
	public void addStudent(Student student) throws ClassNotFoundException, SQLException
	{
		String query="INSERT INTO STUDENTS VALUE(?,?,?,?)";
		conn=DBConnection.setConnection();
		
		PreparedStatement pstmt=conn.prepareStatement(query);
		pstmt.setInt(1, student.getId());
		pstmt.setString(2, student.getName());
		pstmt.setInt(3, student.getAge());
		pstmt.setString(4, student.getGrade());
		pstmt.executeUpdate();
		
	}
	
	public List<Student> getAllStudent() throws SQLException, ClassNotFoundException
	{
		List<Student> students=new ArrayList<Student>();
		conn=DBConnection.setConnection();
		Statement stmt=conn.createStatement();
		
		String query="SELECT * FROM STUDENTS";
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next())
		{
			Student student=new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("grade"));
			students.add(student);
		}
		return students;
	}
	
	
	public void updateStudent(Student student) throws ClassNotFoundException, SQLException
	{
		String query="UPDATE students SET age=?,grade=? WHERE id=?";
		conn=DBConnection.setConnection();
		PreparedStatement pstmt=conn.prepareStatement(query);
		
		pstmt.setInt(1, student.getAge());
		pstmt.setString(2, student.getGrade());
		pstmt.setInt(3, student.getId());
		
		pstmt.executeUpdate();
	}

	
	public void deleteStudent(Student student) throws SQLException, ClassNotFoundException
	{
		String query="DELETE FROM students WHERE id=?";
		conn=DBConnection.setConnection();
		PreparedStatement pstmt=conn.prepareStatement(query);
		
		pstmt.setInt(1, student.getId());
		pstmt.executeUpdate();
	}
	
	public Student serchById(int id) throws SQLException, ClassNotFoundException
	{
		String query="SELECT * FROM students WHERE id=?";
		conn=DBConnection.setConnection();
		try(PreparedStatement pstmt=conn.prepareStatement(query))
		{
			pstmt.setInt(1, id);
			try(ResultSet rs=pstmt.executeQuery())
			{
				if(rs.next())
				{
					return new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("grade"));
				}
				else
				{
					return null;
				}
			}
			
		}
	}
	
	public Student searchByName(String name) throws ClassNotFoundException, SQLException
	{
		String query="SELECT * FROM students WHERE name=?";
		conn=DBConnection.setConnection();
		try(PreparedStatement pstmt=conn.prepareStatement(query))
		{
			pstmt.setString(1, name);
			try(ResultSet rs=pstmt.executeQuery())
			{
				if(rs.next())
				{
					return new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("grade"));
				}
				else
				{
					return null;
				}
			}
		}
		
	}
	
}





















