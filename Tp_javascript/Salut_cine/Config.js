var app = angular.module('angularApp', ["ngRoute"]);

app.config(function($routeProvider, $locationProvider) {
  $routeProvider
  .when("/Page1", {
    templateUrl : "Page1.html",
    controller: 'page1Controller as ctrl1'
  })
  .when("/", {
    templateUrl : "Accueil.html",
    controller: 'homeController as ctrl'
  })
  .otherwise({ redirectTo: '/' });
   $locationProvider.html5Mode({
     enabled: true,
     requireBase: false
   });
});