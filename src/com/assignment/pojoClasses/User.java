package com.assignment.pojoClasses;

public class User {
	
	
	
	private String userName;
	private Integer reviewsGiven;
	private UserCategory userType;
	
	public User(String name) {
		this.userName=name;
		this.reviewsGiven=0;
		this.setUserType(UserCategory.VIEWER);
	}
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getReviewsGiven() {
		return reviewsGiven;
	}
	public void setReviewsGiven(Integer reviewsGiven) {
		this.reviewsGiven = reviewsGiven;
	}
	public UserCategory getUserType() {
		return userType;
	}
	public void setUserType(UserCategory userType) {
		this.userType = userType;
	}
}
