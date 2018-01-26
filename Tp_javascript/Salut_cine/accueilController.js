var app = angular.module('angularApp');


app.controller('homeController', function($http,$location,myService) {
	var ctrl = this;
  this.title = "Bienvenue sur la page d'accueil";


  
this.listeFilm=myService.getTableau();;
this.rechercher=function(){

	var url='http://www.omdbapi.com/?apikey=83489a5b&s='+ ctrl.recherche;
	ctrl.listeFilm=[];

  	$http.get(url)

	.then(function(info){

    	ctrl.listeFilm=info.data.Search;

  	});


}

this.selectionnerFilm=function(i){

    myService.chargerImdb(ctrl.listeFilm[i].imdbID);
    myService.chargertableau(ctrl.listeFilm);
    $location.path("/Page1");

}


});