var app = angular.module('angularApp');

app.service('myService', function() {

	this.imdb="";
	this.temp=[];
  this.chargerImdb=function (str) {
  	this.imdb=str;
  }

   this.chargertableau=function (tableau) {
  this.temp=tableau;
  }

  this.getImdb=function(){
  	return this.imdb;
  }

  this.getTableau=function(){
  	return this.temp;
  }
});