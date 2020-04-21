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

- /movie/title/{title}: to search for a movie title
	- EXAMPLE: GET: http://localhost:8080/movie/title/cleo

- /movie/category/{category}: to search for an award category
	- EXAMPLE: GET: http://localhost:8080/movie/category/actor
