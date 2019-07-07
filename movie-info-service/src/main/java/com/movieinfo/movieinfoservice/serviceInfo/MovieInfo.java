package com.movieinfo.movieinfoservice.serviceInfo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import com.movieinfo.movieinfoservice.serviceInfo.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieInfo {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "testMovie");
	}

}
