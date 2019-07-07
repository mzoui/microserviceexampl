package com.movie.moviecatalogservice.service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.movie.moviecatalogservice.model.CatalogItem;
import com.movie.moviecatalogservice.model.Movie;
import com.movie.moviecatalogservice.model.Rating;
import com.movie.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	
	private RestTemplate restTemplte  ;
	@Autowired
	WebClient.Builder webClientBuilder;
		
	@RequestMapping("/{userId}")
	public List<CatalogItem>getCatalogItemForUser(@PathVariable("userId")String userId){ 
		
	
		UserRating rating =   restTemplte.getForObject("http://DATA-RATING-SERVICE/ratingdata/user/"+userId ,  UserRating.class);
		
			 
		
		
	return	rating.getRatingList().stream().map(rat->{
			 Movie movie =  restTemplte.getForObject("http://MOVIE-INFO-SERVICE/movie/"+rat.getMovieId(), Movie.class);
			
//		Movie movie = webClientBuilder.build()
//		                .get()
//		                .uri("http://localhost:8082/movie/"+rat.getMovieId())
//		                .retrieve()
//		                .bodyToMono(Movie.class) 
//		                .block();
		return new CatalogItem(movie.getMovieName(), null, rat.getRating());
			   
		}).collect(Collectors.toList());
 
	 
	}

}
