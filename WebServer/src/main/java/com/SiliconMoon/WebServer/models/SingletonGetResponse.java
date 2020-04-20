package com.SiliconMoon.WebServer.models;

public class SingletonGetResponse {
	
		private int number;
		private int year;
		private String released;
		private String category;
		private String winner;
		private String actors;
		private String entity;
		private String plot;
		private String awards;
		private String poster;
		private String production;
		
		

		public void setNumber(int number)
		{
			this.number = number;
		}
		
		public void setYear(int year)
		{
			this.year = year;
		}
		
		public void setReleased(String released)
		{
			this.released = released;
		}

		public void setCategory(String category)
		{
			this.category = category;
		}
		
		public void setWinner(String winner)
		{
			this.winner = winner;
		}
		
		public void setActors(String actors)
		{
			this.actors = actors;
		}

		public void setEntity(String entity)
		{
			this.entity = entity;
		}
		
		public void setPlot(String plot)
		{
			this.plot = plot;
		}

		public void setAwards(String awards)
		{
			this.awards = awards;
		}
		
		public void setPoster(String poster)
		{
			this.poster = poster;
		}
		
		public void setProduction(String production)
		{
			this.production = production;
		}
		
		
		
		
		
		
		public int getNumber()
		{
			return number;
		}
		public int getYear() 
		{
			return year;
		}
		
		public String getReleased()
		{
			return released;
		}

		public String getCategory()
		{
			return category;
		}

		public String getWinner()
		{
			return winner;
		}
		
		public String getActors()
		{
			return actors;
		}

		public String getEntity()
		{
			return entity;
		}
		
		public String getPlot()
		{
			return plot;
		}
		
		public String getAwards()
		{
			return awards;
		}
		
		public String getPoster()
		{
			return poster;
		}
		
		public String getProduction()
		{
			return production;
		}
}



