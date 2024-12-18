package com.nk.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.nk.model.Movie;
import com.nk.service.BookingService;

public class BookingController {

	private BookingService service=new BookingService();
	private Scanner sc=new Scanner(System.in);
	
	
	public void addMovie() throws SQLException {
		System.out.println("Enter Movie Name: ");
		String name=sc.nextLine();
		System.out.println("Enter Timing: ");
		String timing=sc.nextLine();
		System.out.println("Enter Available Seats: ");
		int availableseat=sc.nextInt();
		
		Movie movie=new Movie(name,timing,availableseat);
		service.addMovie(movie);
		System.out.println("Movie Added Successfully!");
		
	}

	public void viewMovies() throws SQLException {
		service.getMovie().forEach(System.out::println);
		
	}

	public void bookTicket() throws SQLException {
		System.out.println("Enter Movie Name to Book Tickets: ");
		String name=sc.nextLine();
		
		System.out.println("Enter Number of Tickets: ");
		int tickets=sc.nextInt();
		
		boolean result=service.bookTicket(name,tickets);
		if(result)
		{
			System.out.println("Booking Successfull!");
		}
		else
		{
			System.out.println("Booking failed. Not enough seats or movie not found.");
		}
		
	}

}
