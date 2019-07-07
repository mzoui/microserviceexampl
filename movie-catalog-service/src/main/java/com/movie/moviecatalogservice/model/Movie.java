package com.movie.moviecatalogservice.model;

public class Movie {
	private String moveiId;
	private String movieName;
	
	public Movie( ) {
	 
	}
	public Movie(String moveiId, String movieName) {
		super();
		this.moveiId = moveiId;
		this.movieName = movieName;
	}
	public String getMoveiId() {
		return moveiId;
	}
	public void setMoveiId(String moveiId) {
		this.moveiId = moveiId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	

}
