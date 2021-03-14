package com.assignment.pojoClasses;

import java.util.HashMap;
import java.util.Map;

public class Movie {

	
	private String movieName;
	private Integer releaseYear;
	private String genre;
	private Map<UserCategory,Integer> reviewPoints;

	public Movie(String name,Integer year,String genre) {
		this.movieName=name;
		this.releaseYear=year;
		this.genre=genre;
		this.reviewPoints=new HashMap<>();
	}
	
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public Map<UserCategory,Integer> getReviewPoints() {
		return reviewPoints;
	}
	public void setReviewPoints(Map<UserCategory,Integer> reviewPoints) {
		this.reviewPoints = reviewPoints;
	}
	
	
	
	@Override
    public String toString(){
        return "Movie Name -  "+movieName+" and  Release Year :" +releaseYear;
    }
}
