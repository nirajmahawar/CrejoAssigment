package com.assignment.drivingClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assignment.pojoClasses.Movie;
import com.assignment.pojoClasses.User;
import com.assignment.pojoClasses.UserCategory;

public class AddUserMovie {
	
	Map<String,User> userNameVsUser = new HashMap<>();
	Map<String,Movie> movieNameVsMovie = new HashMap<>();
	
	void addUser(String name) {
		userNameVsUser.put(name,new User(name));
	}
	
	void addMovie(String name,Integer year,String genre) {
		movieNameVsMovie.put(name, new Movie(name,year,genre));
	}
	
	void addReview(String userName,String movieName,Integer review) {
		
		User u=userNameVsUser.get(userName);
		Movie m=movieNameVsMovie.get(movieName);
		
		
		updateMovieObj(u,m,review);
		updateUserObj(u);
		
		userNameVsUser.put(userName, u);
		movieNameVsMovie.put(movieName,m);
		
	}
	
	
	List<Movie> topNMovieInAYear(Integer year,UserCategory userType,int n){
		List<Movie> basedOnYear=new ArrayList<>();
		movieNameVsMovie.forEach((k,v)->{
			if(v.getReleaseYear().equals(year))
				basedOnYear.add(v);
		});
		
		Collections.sort(basedOnYear, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                
                if(m2.getReviewPoints().get(userType)==null) {
                	return 0-m1.getReviewPoints().get(userType);
                }else if(m1.getReviewPoints().get(userType)==null) {
                	return m2.getReviewPoints().get(userType)-0;
                }else {
                	return m2.getReviewPoints().get(userType) - m1.getReviewPoints().get(userType);
                }
            }
        });
		
		return basedOnYear.subList(0, n);
	}
	
	
	List<Movie> topNMovieOfAGenre(String genre,UserCategory userType,int n){
		List<Movie> basedOnGenre=new ArrayList<>();
		movieNameVsMovie.forEach((k,v)->{
			if(v.getGenre().equals(genre))
				basedOnGenre.add(v);
		});
		
		Collections.sort(basedOnGenre, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
            	if(m2.getReviewPoints().get(userType)==null) {
                	return 0-m1.getReviewPoints().get(userType);
                }else if(m1.getReviewPoints().get(userType)==null) {
                	return m2.getReviewPoints().get(userType)-0;
                }else {
                	return m2.getReviewPoints().get(userType) - m1.getReviewPoints().get(userType);
                }
            }
        });
		
		return basedOnGenre.subList(0, n);
	}
	
	
	
	
	
	
	
	
	

	private void updateUserObj(User u) {
		u.setReviewsGiven(u.getReviewsGiven()+1);
		
		if(u.getReviewsGiven()>3) {
			u.setUserType(UserCategory.CRITIC);
		}
		
	}

	private void updateMovieObj(User u, Movie m, Integer review) {
		
		if(u.getUserType()==UserCategory.VIEWER) {
			if(m.getReviewPoints().containsKey(UserCategory.VIEWER)) {
				m.getReviewPoints().put(UserCategory.VIEWER, m.getReviewPoints().get(UserCategory.VIEWER)+review);
			}else {
				m.getReviewPoints().put(UserCategory.VIEWER,1);
			}		
		}
		
		
		if(u.getUserType()==UserCategory.CRITIC) {
			if(m.getReviewPoints().containsKey(UserCategory.CRITIC)) {
				m.getReviewPoints().put(UserCategory.CRITIC, m.getReviewPoints().get(UserCategory.VIEWER)+2*review);
			}else {
				m.getReviewPoints().put(UserCategory.CRITIC,2*review);
			}		
		}
		
		/*
		 * if(u.getUserType()==UserCategory.EXPERT) {
		 * if(m.getReviewPoints().containsKey(UserCategory.EXPERT)) {
		 * m.getReviewPoints().put(UserCategory.EXPERT,
		 * m.getReviewPoints().get(UserCategory.EXPERT)+2*review); }else {
		 * m.getReviewPoints().put(UserCategory.EXPERT,2*review); } }
		 */
		
	}

	public static void main(String args[]) {
		
		AddUserMovie obj=new AddUserMovie();
		
		obj.addUser("Niraj");
		obj.addUser("Danish");
		
		
		obj.addMovie("KGF",2020, "Action");
		obj.addMovie("Naruto",2019, "Anime");
		
		obj.addMovie("ABC",2020, "Comedy");
		obj.addMovie("XYZ",2019, "Comedy");
		
		obj.addMovie("DEF",2020, "Action");
		obj.addMovie("MNO",2019, "Anime");
		
		
		obj.addReview("Niraj", "KGF", 4);
		obj.addReview("Niraj", "Naruto", 6);
		obj.addReview("Niraj", "ABC", 4);
		obj.addReview("Niraj", "XYZ", 6);
		obj.addReview("Niraj", "DEF", 4);
		obj.addReview("Niraj", "MNO", 9);
		
		obj.addReview("Danish", "KGF", 8);
		obj.addReview("Danish", "XYZ", 10);
		
		
		List<Movie> list=obj.topNMovieInAYear(2019, UserCategory.VIEWER, 2);
		
		
		System.out.println(list);
		
		
		
		
		
		
		
	}
}
