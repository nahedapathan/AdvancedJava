package com.nk;

import java.sql.SQLException;
import java.util.Scanner;

import com.nk.controller.BookingController;

public class MovieTicketBooking {

	public static void main(String[] args) throws SQLException {
		BookingController system=new BookingController();
		Scanner sc=new Scanner(System.in);
		boolean exit=true;
		
		while(exit)
		{
			System.out.println("***Welcome to Online Movie Ticket Booking System***");
			System.out.println("1.Add Movie ");
			System.out.println("2.View Movie ");
			System.out.println("3.Book Ticket");
			System.out.println("4.Exit!");
			
			System.out.println("Enter the choice: ");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:system.addMovie();
				  break;
			case 2:system.viewMovies();
				  break;
			case 3:system.bookTicket();
				  break;
			case 4:exit=false;
			      System.out.println("Thank you for Using movie Ticket Booking System!");
				  
			      break;
			default:
				System.out.println("Invalid Choice!");
			}
		}
		System.out.println("System Exited!");
		
	}
	
	
}
