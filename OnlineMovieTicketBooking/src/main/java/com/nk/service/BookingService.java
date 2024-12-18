package com.nk.service;

import java.sql.SQLException;
import java.util.List;

import com.nk.dao.BookingDao;
import com.nk.model.Movie;

public class BookingService {

	 private BookingDao dao=new BookingDao();
	 
	public void addMovie(Movie movie) throws SQLException {
		dao.addMovie(movie);
		
	}

	public List<Movie> getMovie() throws SQLException {
		
		return dao.getMovies();
	}

	public boolean bookTicket(String name, int tickets) throws SQLException {
		
		return dao.bookTicket(name,tickets);
	}

}
