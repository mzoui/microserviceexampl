package com.ratinginfo.dataratingservice.rateResource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratinginfo.dataratingservice.model.Rating;
import com.ratinginfo.dataratingservice.model.UserRating; 
 

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {

	@RequestMapping("/{movieId}")
	public Rating getRting(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);

	} 
	
	@RequestMapping("user/{movieId}")
	public UserRating getUserMovieRating(@PathVariable("movieId") String movieId) {
		List<Rating> rating =   Arrays.asList(
				new Rating("3", 5),
				new Rating("4", 1)
			);
		UserRating userRating =  new UserRating();
		
		  userRating.setRatingList(rating);
		  return userRating;
		} 
}
