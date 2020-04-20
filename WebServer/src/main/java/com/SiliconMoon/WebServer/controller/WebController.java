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


	@RequestMapping("/movie/category/{category}")
	public SingletonGetResponse[] findMovieCategory(@PathVariable(value = "category") String category) {
		category = category.toLowerCase();
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter   
	    String sql = "SELECT * FROM movies WHERE lower(category) LIKE \'%" + category + "%\'";
		SingletonGetResponse resArray[] = Bridge.singletonRequestGenerator(sql);
	    return resArray;
	}



	@RequestMapping("/movie/title/{title}")
	public SingletonGetResponse[] findMovieTitle(@PathVariable(value = "title") String title) {
		title = title.toLowerCase();			
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
		String sql = "SELECT * FROM movies WHERE lower(entity) LIKE \'%" + title + "%\'";
		SingletonGetResponse resArray[] = Bridge.singletonRequestGenerator(sql);
        return resArray;
	
	}
	

}

