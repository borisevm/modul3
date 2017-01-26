var App = angular.module('App', ['ngRoute']);

App.controller('Ctrl', function($scope,  $http){
	
});


App.config(function($routeProvider) {
  $routeProvider
        //http://localhost:8080/static/app/html/index.html/#!/
        .when("/", {
          templateUrl : '/static/app/html/partials/home.html'
        })        
        //http://localhost:8080/static/app/html/index.html/#!/activity
        .when('/activity/:id', {
         templateUrl : '/static/app/html/partials/activity.html'
       })
        //sve ostalo radi redirekciju na
        //http://localhost:8080/static/app/html/index.html/#!/
        .otherwise({
         redirectTo: '/'
       });

});