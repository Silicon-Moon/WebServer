# WebServer

### Running the script

In order to run the script type:

`mvn spring-boot:run`


### Testing the script

In order to test the script type:

`./mvnw test`

-------------------------------------------------------------------------------------------------------------------------------------

### Problems

If there are any problems let me know! Or if you figure it out, write in here how to resolve it!

- Eclipse Problem: In order to run code through eclipse, you have to import the project as a maven project. 

-------------------------------------------------------------------------------------------------------------------------------------

### Adding Code

I've been copying and pasting from 

[Spring-boot Site](https://adityasridhar.com/posts/how-to-create-simple-rest-apis-with-springboot)

**FOR NEW API's**
- Add new API calls to WebController.java in WebServer/src/main/java/com/SiliconMoon/WebServer/controller

- Bridge can be used if you want to create a new response class and don't want to recreate the wheel

- Response classes return all their variable, so if you don't want everything to be returned be sure to create a new reponse class. 



-------------------------------------------------------------------------------------------------------------------------------------

## RESTful API
- /movie: to see a collection of the movies nominated.

	- EXAMPLE: GET: http://localhost:8080/movie
	- You can also query:
		- title
			- EXAMPLE: GET: http://localhost:8080/movie?title=cleo


		- category
			- EXAMPLE: GET: http://localhost:8080/movie?category=actor


		- year
			- EXAMPLE: GET: http://localhost:8080/movie?year=1934


		- winner
			- EXAMPLE: GET: http://localhost:8080/movie?winner=true


		- asc
			- entity
			- category
			- year
			- winner
			- EXAMPLE: GET: http://localhost:8080/movie?asc=year

		- desc
			- entity
			- category
			- year
			- winner
			- EXAMPLE: GET: http://localhost:8080/movie?desc=year


- /movie/ASC: sort movies in ascending order according to title

	- EXAMPLE: GET: http://localhost:8080/movie/ASC


- /movie/winner: To just see the winners

	- EXAMPLE: GET: http://localhost:8080/movie/winner
	- You can also query:
		- title
			- EXAMPLE: GET: http://localhost:8080/movie/winner?title=cleo


		- category
			- EXAMPLE: GET: http://localhost:8080/movie/winner?category=actor


		- year
			- EXAMPLE: GET: http://localhost:8080/movie/winner?year=1934


		- asc
			- entity
			- category
			- year
			- winner
			- EXAMPLE: GET: http://localhost:8080/movie/winner?asc=year

		- desc
			- entity
			- category
			- year
			- winner
			- EXAMPLE: GET: http://localhost:8080/movie/winner?desc=year


- /movie/title/{title}: to search for a movie title

	- EXAMPLE: GET: http://localhost:8080/movie/title/cleo
	- You can also query:
		- category
			- EXAMPLE: GET: http://localhost:8080/movie/title/cleo?category=sound+recording


		- year
			- EXAMPLE: GET: http://localhost:8080/movie/title/cleo?year=1934


		- winner
			- EXAMPLE: GET: http://localhost:8080/movie/title/cleo?winner=true


		- asc
			- entity
			- category
			- year
			- winner
			- EXAMPLE: GET: http://localhost:8080/movie/title/cleo?asc=year

		- desc
			- entity
			- category
			- year
			- winner
			- EXAMPLE: GET: http://localhost:8080/movie/title/cleo?desc=year

	

- /movie/category/{category}: to search for an award category

	- EXAMPLE: GET: http://localhost:8080/movie/category/actress
	- EXAMPLE: GET: http://localhost:8080/movie/category/actress&CINEMATOGRAPHY
	- You can also query:
		- title
			- EXAMPLE: GET: http://localhost:8080/movie/category/actress?title=bette


		- year
			- EXAMPLE: GET: http://localhost:8080/movie/category/actor?year=1934


		- winner
			- EXAMPLE: GET: http://localhost:8080/movie/category/actor?winner=true


		- asc
			- entity
			- category
			- year
			- winner
			- EXAMPLE: GET: http://localhost:8080/movie/category/actor?asc=year

		- desc
			- entity
			- category
			- year
			- winner
			- EXAMPLE: GET: http://localhost:8080/movie/category/actor?desc=year


- /movie/yearRange/{year1}/{year2}: Search by date range

	- EXAMPLE: GET: http://localhost:8080/movie/yearRange/1934/1940


- /movie/year/{year}: Search by one year

	- EXAMPLE: GET: http://localhost:8080/movie/year/1934
	- You can also query:
		- title
			- EXAMPLE: GET: http://localhost:8080/movie/year/1934?title=cleo


		- category
			- EXAMPLE: GET: http://localhost:8080/movie/year/1934?category=actor


		- winner
			- EXAMPLE: GET: http://localhost:8080/movie/year/1934?winner=true


		- asc
			- entity
			- category
			- year
			- winner
			- EXAMPLE: GET: http://localhost:8080/movie/year/1934?asc=category

		- desc
			- entity
			- category
			- year
			- winner
			- EXAMPLE: GET: http://localhost:8080/movie/year/1934?desc=category


- /movie/id/{id}: Search by movie id

	- EXAMPLE: GET: http://localhost:8080/movie/id/12
