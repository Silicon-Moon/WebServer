package com.SiliconMoon.WebServer.models;
public class GetResponse {
	private int year;
	private String category;
	private String winner;
	private String entity;
	private String genre;

	public void setYear(int year)
	{
		this.year = year;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public void setWinner(String winner)
	{
		this.winner = winner;
	}

	public void setEntity(String entity)
	{
		this.entity = entity;
	}
	
	public void setGenre(Strign genre)
	{
	    this.genre = genre;
	}


	public int getYear() 
	{
		return year;
	}

	public String getCategory()
	{
		return category;
	}

	public String getWinner()
	{
		return winner;
	}

	public String getEntity()
	{
		return entity;
	}
	public String getGenre()
	{
	    return genre;
	}
}
