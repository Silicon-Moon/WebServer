package com.SiliconMoon.WebServer.models;
public class CollectionGetResponse {
	private int number;
	private int year;
	private String category;
	private String winner;
	private String entity;

	public void setNumber(int number)
	{
		this.number = number;
	}
	
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


	public int getNumber()
	{
		return number;
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
}
