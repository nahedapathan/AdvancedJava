package com.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.controller.StudentController;

public class MainApp {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		StudentController controller=new StudentController();
		Scanner sc=new Scanner(System.in);
		boolean exit=false;
		
		while(!exit)
		{
			System.out.println("***Welcome to Student Management System***");
			System.out.println("1.Add Student Data ");
			System.out.println("2.View Student Data ");
			System.out.println("3.Search Student Data by Using Id ");
			System.out.println("4.Search Student Data by Using Name ");
			System.out.println("5.Update Student Age and Grade ");
			System.out.println("6.Delete Student Data ");
			System.out.println("7.Exit System");
			
			System.out.println("Enter your Choice : ");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:System.out.println("Enter the Id: ");
				   int id=sc.nextInt();
				   sc.nextLine();
				   System.out.println("Enter the Name: ");
				   String name=sc.nextLine();
				   System.out.println("Enter the Age: ");
				   int age=sc.nextInt();
				   sc.nextLine();
				   System.out.println("Enter the Grade: ");
				   String grade=sc.next();
				   
				   controller.createStudent(id, name, age, grade);
				   break;
				   
			case 2:controller.showAllStudent();
				  break;
				  
			case 3:System.out.println("Enter the Id: ");
			       int id1=sc.nextInt();
			       controller.searchId(id1);
				  break;
				  
			case 4:System.out.println("Enter the Name: ");
			      String name1=sc.next();
			      controller.searchName(name1);
				  break;
				  
			case 5:System.out.println("Enter the age: ");
			      int age2=sc.nextInt();
			      sc.nextLine();
			      System.out.println("Enter the Grade: ");
			      String grade2=sc.next();
			      System.out.println("Enter the id: ");
			      int id2=sc.nextInt();
			      
			      controller.updateStudent(id2, age2, grade2);
			      
				  break;
			case 6:System.out.println("Enter the Id: ");
			       int id3=sc.nextInt();
			       controller.deleteStudent(id3);
				  break;
				  
			case 7:exit=true;
			      System.out.println("System Exited!!!");
				  break;
			default:System.out.println("Invalid Choice ");
				  break;
			}
		}
		
	}
}
