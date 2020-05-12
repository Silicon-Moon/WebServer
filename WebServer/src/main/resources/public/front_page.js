const app = document.getElementById('root')

const container = document.createElement('div')
container.setAttribute('class', 'container')

app.appendChild(container)

var search = 'http://localhost:8080/movie';
var request = new XMLHttpRequest()
request.open('GET', search, true)
var parameter = ''
	

function updateResult(query) {
	if(parameter !== "")
	{
		search = 'http://localhost:8080/movie?' + parameter + '=' + query
	}
	else{
		search = 'http://localhost:8080/movie?title=' + query
	}
	request.open('GET', search, true)
	request.send()
	request.onload()
}


request.onload = function() {
	  // Begin accessing JSON data here
	  while (container.firstChild) {
		    container.removeChild(container.lastChild);
	  }
	  
	  if (request.status >= 200 && request.status < 400) {
		var data = JSON.parse(this.response)
		
		
	    data.forEach(movie => {
	      const card = document.createElement('div')
	      card.setAttribute('class', 'card')
	
	      const h1 = document.createElement('h1')
		  h1.textContent = movie.number + ". " + movie.entity
		  
		  const p = document.createElement('p')
	      p.textContent = movie.category
	
	
	      container.appendChild(card)
	      card.appendChild(h1)
	      card.appendChild(p)
	      card.addEventListener("click", function(){
	    	    myFunction(movie.number);
	      }, false);
	    })
		
	    
	  } else {
	    const errorMessage = document.createElement('marquee')
	    app.appendChild(errorMessage)
	  }
}

request.send()

document.getElementById('target')
        .addEventListener('change', function () {
            'use strict';
            var vis = document.querySelector('.vis'),  
            target = document.getElementById(this.value);
            parameter = this.value;
            
            if (vis !== null) {
                vis.className = 'inv';
            }
            
            if (target !== null ) {
                target.className = 'vis';
            }
});

function myFunction(number) {
	  location.href = 'single_page.html'
	  localStorage.setItem("number",number);
}


