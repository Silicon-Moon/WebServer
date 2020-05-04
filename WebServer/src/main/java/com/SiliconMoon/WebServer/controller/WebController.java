package com.SiliconMoon.WebServer.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SiliconMoon.WebServer.models.CollectionGetResponse;
import com.SiliconMoon.WebServer.models.SingletonGetResponse;
import com.SiliconMoon.WebServer.controller.Bridge;


@RestController
public class WebController {
	
	//Retrieves a collection of Movie Awards
	@RequestMapping("/movie")
	public CollectionGetResponse[] findMovie(@RequestParam(defaultValue="", required=false) String title,
											 @RequestParam(defaultValue="", required=false) String category,
											 @RequestParam(defaultValue="0",required=false) int year,
											 @RequestParam(defaultValue="", required=false) String winner,
											 @RequestParam(defaultValue="", required=false) String asc,
											 @RequestParam(defaultValue="", required=false) String desc) 
	{		
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
		String sql = "SELECT * FROM movies";
		
		sql = Bridge.sqlGenerator(sql, title.toLowerCase(), category.toLowerCase(), year, winner.toLowerCase(), asc.toLowerCase(), desc.toLowerCase());
		CollectionGetResponse resArray[] = Bridge.collectionRequestGenerator(sql);
        return resArray;
	
	}
	
	//Retrieves a collection of Movie Winners
	@RequestMapping("/movie/winner")
	public CollectionGetResponse[] findMovieWinner(@RequestParam(defaultValue="", required=false) String title,
												   @RequestParam(defaultValue="", required=false) String category,
												   @RequestParam(defaultValue="0",required=false) int year,
												   @RequestParam(defaultValue="", required=false) String asc,
												   @RequestParam(defaultValue="", required=false) String desc) 
	{		
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
		String sql = "SELECT * FROM movies WHERE lower(winner) = true";
			
		sql = Bridge.sqlGenerator(sql, title.toLowerCase(), category.toLowerCase(), year, "", asc.toLowerCase(), desc.toLowerCase());
		CollectionGetResponse resArray[] = Bridge.collectionRequestGenerator(sql);
	    return resArray;
			
	}

	//Searches for a specific movie category
	@RequestMapping("/movie/category/{category}")
	public SingletonGetResponse[] findMovieCategory(@PathVariable(value = "category") String category,
													@RequestParam(defaultValue="", required=false) String title,
													@RequestParam(defaultValue="0", required=false) int year,
													@RequestParam(defaultValue="", required=false) String winner,
													@RequestParam(defaultValue="", required=false) String asc,
													@RequestParam(defaultValue="", required=false) String desc) 
	{
		category = category.toLowerCase();
		category = category.replaceAll("+", " ");
		String[] categories = category.split("&");
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter   
	    String sql = "SELECT * FROM movies WHERE (lower(category) LIKE '%" + categories[0] + "%'";
	 
	    for (int i=1; i < categories.length; i++) 
	    {
	        sql += " OR lower(category) LIKE '%" + categories[i] + "%'";
	    }
	    sql += ")";
	    sql = Bridge.sqlGenerator(sql, title.toLowerCase(), "", year, winner.toLowerCase(), asc.toLowerCase(), desc.toLowerCase());
		SingletonGetResponse resArray[] = Bridge.singletonRequestGenerator(sql);
	    return resArray;
	}


	//Searches for a specific movie title
	@RequestMapping("/movie/title/{title}")
	public SingletonGetResponse[] findMovieTitle(@PathVariable(value = "title") String title,
												 @RequestParam(defaultValue="", required=false) String category,
												 @RequestParam(defaultValue="0", required=false) int year,
												 @RequestParam(defaultValue="", required=false) String winner,
												 @RequestParam(defaultValue="", required=false) String asc,
												 @RequestParam(defaultValue="", required=false) String desc) 
	{
		title = title.toLowerCase();			
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
		String sql = "SELECT * FROM movies WHERE lower(entity) LIKE \'%" + title + "%\'";
		sql = Bridge.sqlGenerator(sql, "", category.toLowerCase(), year, winner.toLowerCase(), asc.toLowerCase(), desc.toLowerCase());
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
	
	//Searches for a specific movie year
	@RequestMapping("/movie/year/{year}")
	public SingletonGetResponse[] findMovieYear(@PathVariable(value = "year") int year,
												@RequestParam(defaultValue="", required=false) String title,
												@RequestParam(defaultValue="", required=false) String category,
												@RequestParam(defaultValue="", required=false) String winner,
												@RequestParam(defaultValue="", required=false) String asc,
												@RequestParam(defaultValue="", required=false) String desc) 
	{		
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
		String sql = "SELECT * FROM movies WHERE \"year\" = " + year;
		sql = Bridge.sqlGenerator(sql, title.toLowerCase(), category.toLowerCase(), 0, winner.toLowerCase(), asc.toLowerCase(), desc.toLowerCase());
		SingletonGetResponse resArray[] = Bridge.singletonRequestGenerator(sql);
		return resArray;
				
	}

	
	//Searches for a specific movie id
	@RequestMapping("/movie/id/{id}")
	public SingletonGetResponse[] findMovieId(@PathVariable(value = "id") int id) 
	{		
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
		String sql = "SELECT * FROM movies WHERE number = " + id;
		SingletonGetResponse resArray[] = Bridge.singletonRequestGenerator(sql);
	    return resArray;
		
	}
	

}

