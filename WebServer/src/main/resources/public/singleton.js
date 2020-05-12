const app = document.getElementById('box')
var search = 'http://localhost:8080/movie/id/' + localStorage.getItem("number");

var request = new XMLHttpRequest()
request.open('GET', search, true)

const info = document.createElement('div')
info.setAttribute('class', 'info')


app.appendChild(info)

request.onload = function() {
	  // Begin accessing JSON data here
	  
	  
	  if (request.status >= 200 && request.status < 400) {
		var data = JSON.parse(this.response)
		
		
	    data.forEach(movie => {
		      
	    	const winner = document.createElement('winner')
	    	winner.textContent = 'Award: ' + movie.category + ' \nWinner: ' + movie.winner;
	    	
	    	if (movie.winner == 'True'){
	    		winner.textContent += ' Year Won: ' + movie.year;
	    	}
	    	
	    	const entity = document.createElement('entity')
	    	entity.textContent = movie.entity;
	    	
	    	const awards = document.createElement('awards')
	    	awards.textContent = 'Other Awards: ' + movie.awards;
	    
	    	const actors = document.createElement('actors')
	    	actors.textContent = 'Actors: ' + "\n" +  movie.actors;
	    	
	    	const released = document.createElement('released')
	    	released.textContent = "Date Released: " + movie.released;

	    	const plot = document.createElement('plot')
	    	plot.textContent = "Plot: " + movie.plot;
	    	
	    	var img = document.createElement("img");
 
			img.src = movie.poster;
			var src = document.getElementById("x");
			 
			src.appendChild(img);
	    	document.body.appendChild(entity);
	    	info.appendChild(winner);
	    	info.appendChild(awards);
	    	info.appendChild(actors);
	    	info.appendChild(released);
	    	info.appendChild(plot);

	    	
	    })
		
	    
	  } else {
	    const errorMessage = document.createElement('marquee')
	  }
}

request.send()