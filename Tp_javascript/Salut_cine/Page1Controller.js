var app = angular.module('angularApp');

app.controller('page1Controller', function($http,myService) {
  var ctrl=this;
  this.film=[];

this.IMDB=myService.getImdb();
var url='http://www.omdbapi.com/?apikey=83489a5b&i='+ ctrl.IMDB;

$http.get(url)

	.then(function(info){
		console.log(info.data);
		console.log(info.data.Title);
		console.log(info.data.Year);

    	ctrl.film=info.data;
    	console.log(ctrl.film.Title)

  	});

});


