package com.SiliconMoon.WebServer.controller;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.Statement; 
import java.sql.DriverManager; 
import java.sql.DatabaseMetaData; 
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SiliconMoon.WebServer.models.GetResponse;
import com.SiliconMoon.WebServer.WebServerApplication;

@RestController
public class WebController {
    
    @RequestMapping("/category")
    public GetResponse[] findMovieCategory(@RequestParam(value = "category",
    defaultValue = "None") String category) {
        try
        {
            // Create connection and statement in with parameters that let you scroll through the query
            Connection conn = WebServerApplication.connect();
            Statement statement = conn.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            
            // SQL QUERY that retrieves all rows and searches for entities close to the parameter   
            String sql = "SELECT * FROM movies WHERE entity LIKE \'%" + category + "%\'";

            //Get the result
            ResultSet res = statement.executeQuery(sql);

            int counter=0;
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
                response.setYear(res.getInt("year"));
                response.setCategory(res.getString("category"));
                response.setWinner(res.getString("winner"));
                response.setEntity(res.getString("entity"));
                response.setEntity(res.getString("genre"));
                
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

	@RequestMapping("/movie")
	public GetResponse[] findMovieTitle(@RequestParam(value = "title",
	defaultValue = "None") String title) {

		try
		{
			// Create connection and statement in with parameters that let you scroll through the query
			Connection conn = WebServerApplication.connect();
			Statement statement = conn.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			
			// SQL QUERY that retrieves all rows and searches for entities close to the parameter	
			String sql = "SELECT * FROM movies WHERE entity LIKE \'%" + title + "%\'";

			//Get the result
			ResultSet res = statement.executeQuery(sql);

			int counter=0;
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
	
	@RequestMapping("/genre")
    public GetResponse[] findMovieGenre(@RequestParam(value = "genre",
    defaultValue = "None") String genre) {
        try
        {
            // Create connection and statement in with parameters that let you scroll through the query
            Connection conn = WebServerApplication.connect();
            Statement statement = conn.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            
            // SQL QUERY that retrieves all rows and searches for entities close to the parameter   
            String sql = "SELECT * FROM movies WHERE entity LIKE \'%" + genre + "%\'";

            //Get the result
            ResultSet res = statement.executeQuery(sql);

            int counter=0;
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
                response.setYear(res.getInt("year"));
                response.setCategory(res.getString("category"));
                response.setWinner(res.getString("winner"));
                response.setEntity(res.getString("entity"));
                response.setEntity(res.getString("genre"));
                
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
}

