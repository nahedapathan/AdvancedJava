package com.nk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nk.model.Movie;

public class BookingDao {

	private static final String DB_URL="jdbc:mysql://localhost:3306/batch194";
	private static final String USER="root";
	private static final String PASSWORD="your_password";
	
	private List<Movie> movies=new ArrayList<>();
	
	static{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void addMovie(Movie movie) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASSWORD);
		String query="INSERT INTO movies(name,timing,availableSeats) VALUES(?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(query);
		pstmt.setString(1, movie.getName());
		pstmt.setString(2, movie.getTiming());
		pstmt.setInt(3, movie.getAvailableSeats());
		
		pstmt.executeUpdate();
		movies.add(movie);
		
		
	}

	public List<Movie> getMovies() throws SQLException {
		movies.clear();
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASSWORD);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM movies");
		while(rs.next())
		{
			movies.add(new Movie(rs.getString("name"),rs.getString("timing"),rs.getInt("availableSeats")));
			
		}
		return movies;
	}

	public boolean bookTicket(String name, int tickets) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASSWORD);
		
		String query="SELECT availableSeats FROM movies WHERE name =?";
		PreparedStatement pstmt=conn.prepareStatement(query);
		pstmt.setString(1,name);
		
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			int availableSeats=rs.getInt("availableSeats");
			if(tickets<=availableSeats)
			{
				String query2="UPDATE movies SET availableSeats=? WHERE name=?";
				PreparedStatement pstmt2=conn.prepareStatement(query2);
				pstmt2.setInt(1, availableSeats-tickets);
				pstmt2.setString(2, name);
				pstmt2.executeUpdate();
				return true;
			}
		}
		
		return false;
	}

	
}
