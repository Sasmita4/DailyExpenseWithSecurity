

var app = angular.module('dailyExpenceApp',  ['ngRoute','ui.router']);


app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    
	
	  $stateProvider
	    .state('main', { url: "/",templateUrl: "views/dashboard.html",controller: 'dashboardController'})
	    .state('aboutus', { url: "/aboutus",templateUrl: "views/aboutus.html"})
	       .state('main.addFood', {url:'/addFood',  templateUrl: 'views/food/addFood.html', controller: 'addFoodController'})
	  
	 $urlRouterProvider.otherwise('/');
	
}]);

    