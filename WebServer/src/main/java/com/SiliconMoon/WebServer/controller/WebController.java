package com.SiliconMoon.WebServer.controller;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.SiliconMoon.WebServer.models.GetResponse;
import com.SiliconMoon.WebServer.WebServerApplication;

@RestController
public class WebController {
	public static int counter=0;

	private GetResponse[] requestGenerator(String sql)
	{
		try
        	{
            		// Create connection and statement in with parameters that let you scroll through the query
            		Connection conn = WebServerApplication.connect("new.db");
            		Statement statement = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
            
            		
            		//Get the result
            		ResultSet res = statement.executeQuery(sql);

            		counter=0;
            		int i=0;
            
          		//See how many results are given.
            		while (res.next()) 
            		{
                		counter++;      
                	}

            		//Set the cursor to before the first
            		res.beforeFirst();
            		//Create an array of responses with the amount of counter
            		GetResponse resArray[] = new GetResponse[counter];

            		//Must create a new response with every entry
                	while (res.next()) 
            		{   
                		GetResponse response = new GetResponse();
                		response.setNumber(res.getInt("number"));
                		response.setYear(res.getInt("year"));
                		response.setCategory(res.getString("category"));
                		response.setWinner(res.getString("winner"));
                		response.setEntity(res.getString("entity"));
                
                		if (i <= counter)
                		{
                    			resArray[i] = response;
                		}
                		i++;
                
                	}
                	//Close all the open connections so we don't lock ourselves out of the database. 
            		res.close();
            		statement.close();
            		conn.close();
        
            		return resArray;

        	} catch (Exception e) {
            		System.out.println(e);
            		GetResponse resArray[]= new GetResponse[1];
            		return resArray;
        	}

	}

	//Retrieves a collection of Movie Awards
	@RequestMapping("/movie")
	public GetResponse[] findMovie() {		
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
		String sql = "SELECT * FROM movies";
		GetResponse resArray[] = requestGenerator(sql);
            	return resArray;
	
	}


	@RequestMapping("/movie/category/{category}")
    	public GetResponse[] findMovieCategory(@PathVariable(value = "category") String category) {
		category = category.toLowerCase();
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter   
            	String sql = "SELECT * FROM movies WHERE lower(category) LIKE \'%" + category + "%\'";
		GetResponse resArray[] = requestGenerator(sql);
            	return resArray;
    	}



	@RequestMapping("/movie/title/{title}")
	public GetResponse[] findMovieTitle(@PathVariable(value = "title") String title) {
		title = title.toLowerCase();			
		// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
		String sql = "SELECT * FROM movies WHERE lower(entity) LIKE \'%" + title + "%\'";
		GetResponse resArray[] = requestGenerator(sql);
            	return resArray;
	
	}
	
	@RequestMapping("/movie/genre/{genre}")
    	public GetResponse[] findMovieGenre(@PathVariable(value = "genre") String genre) {
      		genre = genre.toLowerCase();
            	// SQL QUERY that retrieves all rows and searches for entities close to the parameter   
            	String sql = "SELECT * FROM movies WHERE lower(entity) LIKE \'%" + genre + "%\'";
		GetResponse resArray[] = requestGenerator(sql);
            	return resArray;
      	}

}

