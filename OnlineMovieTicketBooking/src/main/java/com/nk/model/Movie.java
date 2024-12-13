package com.nk.model;

public class Movie {

	private String name;
	private String timing;
	private int availableSeats;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String name, String timing, int availableSeats) {
		super();
		this.name = name;
		this.timing = timing;
		this.availableSeats = availableSeats;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", timing=" + timing + ", availableSeats=" + availableSeats + "]";
	}
	
	
}
