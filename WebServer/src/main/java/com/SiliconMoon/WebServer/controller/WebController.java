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

	@RequestMapping("/movie")
	public GetResponse[] Sample(@RequestParam(value = "title",
	defaultValue = "None") String title) {
		GetResponse response = new GetResponse();

		try
		{
		
			Connection conn = WebServerApplication.connect();
			Statement statement = conn.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
				
			String sql = "SELECT * FROM movies WHERE entity LIKE \'%" + title + "%\'";
			System.out.println(sql);
			ResultSet res = statement.executeQuery(sql);

			int counter=0;

			while (res.next()) 
			{
				counter++;			
       			}
			System.out.println(counter);
			res.beforeFirst();
			GetResponse resArray[] = new GetResponse[counter];
      			while (res.next()) 
			{
				
				response.setYear(res.getInt("year"));
				response.setCategory(res.getString("category"));
				response.setWinner(res.getString("winner"));
				response.setEntity(res.getString("entity"));

				resArray[counter] = response;
			
				
       			}
      
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

