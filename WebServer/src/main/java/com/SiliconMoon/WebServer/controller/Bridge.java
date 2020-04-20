package com.SiliconMoon.WebServer.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.SiliconMoon.WebServer.WebServerApplication;
import com.SiliconMoon.WebServer.models.CollectionGetResponse;
import com.SiliconMoon.WebServer.models.SingletonGetResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class Bridge {
	public static String omdbKey = "de1ec873";
	public static int counter=0;
	public static Connection conn = WebServerApplication.connect("new.db");
	
	public static SingletonGetResponse[] singletonRequestGenerator(String sql)
	{
		try
        	{ 
        		// Create connection and statement in with parameters that let you scroll through the query
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
        		SingletonGetResponse resArray[] = new SingletonGetResponse[counter];

        		//Must create a new response with every entry
            	while (res.next()) 
        		{ 
            		String[] omdb = getDataFromOmdb(res.getString("entity"), res.getInt("year"));
            		SingletonGetResponse response = new SingletonGetResponse();
            		
            		
            		response.setNumber(res.getInt("number"));
            		response.setYear(res.getInt("year"));
            		response.setReleased(getValue(omdb, "Released"));
            		response.setCategory(res.getString("category"));
            		response.setWinner(res.getString("winner"));
            		response.setActors(getValue(omdb, "Actors"));
            		response.setEntity(res.getString("entity"));
            		response.setPlot(getValue(omdb, "Plot"));
            		response.setAwards(getValue(omdb, "Awards"));
            		response.setPoster(getValue(omdb, "Poster"));
            		response.setProduction(getValue(omdb, "Production"));
            
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
        		SingletonGetResponse resArray[]= new SingletonGetResponse[1];
        		return resArray;
        	}

	}

	public static CollectionGetResponse[] collectionRequestGenerator(String sql)
	{
		try
        	{
        		// Create connection and statement in with parameters that let you scroll through the query
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
        		CollectionGetResponse resArray[] = new CollectionGetResponse[counter];

        		//Must create a new response with every entry
            	while (res.next()) 
        		{   
            		CollectionGetResponse response = new CollectionGetResponse();
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
        		CollectionGetResponse resArray[]= new CollectionGetResponse[1];
        		return resArray;
        	}

	}
	
	public static String[] getDataFromOmdb(String title, int year)
	{
		try
		{
			
			int counter = 0;
			
			String site = "http://www.omdbapi.com/?apikey=";
			
			
			title = title.replaceAll("\\p{P}", "");
			title = title.replaceAll("\\s", "+");
				
			HttpResponse <String> response = Unirest
					.get(site + omdbKey + "&t=" + title + "&y=" + year)
					.asString();
				
			String omdbData = response.getBody().toString();
			System.out.println(omdbData);
			omdbData = omdbData.replaceAll("[\"{}]", "");
			String[] structuredData = omdbData.split(",");
					
			for (int i=0; i < structuredData.length; i++)
			{
				String b[] = structuredData[i].split(":");
				if (b.length > 1)
				{
					counter = i;
				}
				else
				{
					structuredData[i] = structuredData[i].replaceAll("^\\s$", "");
					structuredData[counter] += "+" + structuredData[i];
					structuredData[i] = "";
				}
			}
			
			return structuredData;
			
		}
		catch (Exception e)
		{
			System.out.println(e);
			String[] exit = {""};
			return exit;
		}
	}
	
	
	public static String getValue(String[] json, String thing)
	{
		for(String a: json)
		{
			if(a.equals(""))
			{
				continue;
			}
			else 
			{

				String[] splitter = a.split(":", 2);

				if(splitter[0].equals(thing))
				{
					splitter[1] = splitter[1].replaceAll("\\+", "");
					return splitter[1];
				}
			}
		}
		
		return "";
	}


}
