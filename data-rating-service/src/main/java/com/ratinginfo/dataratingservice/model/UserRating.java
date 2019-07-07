package com.ratinginfo.dataratingservice.model;

import java.util.List;

public class UserRating {
	
	private List<Rating> ratingList;
	
	public UserRating()
	{ 
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	 

}
