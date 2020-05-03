package com.SiliconMoon.WebServer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.SiliconMoon.WebServer.models.CollectionGetResponse;
import com.SiliconMoon.WebServer.models.SingletonGetResponse;
import com.SiliconMoon.WebServer.controller.Bridge;


@RestController
public class WebController {
	
	//Retrieves a collection of Movie Awards
	@RequestMapping("/movie")
	public CollectionGetResponse[] findMovie() {		
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
		String sql = "SELECT * FROM movies";
		CollectionGetResponse resArray[] = Bridge.collectionRequestGenerator(sql);
        return resArray;
	
	}

	//Searches for a specific movie category
	@RequestMapping("/movie/category/{category}")
	public SingletonGetResponse[] findMovieCategory(@PathVariable(value = "category") String category) {
		category = category.toLowerCase();
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter   
	    String sql = "SELECT * FROM movies WHERE lower(category) LIKE \'%" + category + "%\'";
		SingletonGetResponse resArray[] = Bridge.singletonRequestGenerator(sql);
	    return resArray;
	}


	//Searches for a specific movie title
	@RequestMapping("/movie/title/{title}")
	public SingletonGetResponse[] findMovieTitle(@PathVariable(value = "title") String title) {
		title = title.toLowerCase();			
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
		String sql = "SELECT * FROM movies WHERE lower(entity) LIKE \'%" + title + "%\'";
		SingletonGetResponse resArray[] = Bridge.singletonRequestGenerator(sql);
        return resArray;
	
	}
   
   //Retrieves a collection of Movies in Alphabetical order 
	@RequestMapping("/movie/ASC")
	public CollectionGetResponse[] sortMoviesASC() {		
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter in Ascending Order
		String sql = "SELECT * FROM movies ORDER BY entity ASC";
		CollectionGetResponse resArray[] = Bridge.collectionRequestGenerator(sql);
        return resArray;
	
	}
   
   //Retrieves a collection of Movies from Date Range
	@RequestMapping("/movie/yearRange/{year1}/{year2}")
	public CollectionGetResponse[] findDateRange(@PathVariable(value = "year1") int year1, @PathVariable(value = "year2") int year2) {		
		// SQL QUERY that retrieves all rows and searches for entities in parameter range
		String sql = "SELECT * FROM movies WHERE \"year\" BETWEEN " +year1+" AND "+year2+"";
		CollectionGetResponse resArray[] = Bridge.collectionRequestGenerator(sql);
        return resArray;
	
	}
	

}

