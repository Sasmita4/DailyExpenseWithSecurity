

var app = angular.module('dailyExpenceApp',  ['ngGrid','ngRoute','ngMaterial','blockUI','angular-timezone-selector','ngAnimate', 'ui.router', 'ui.grid','ui.grid.pagination', 'xeditable','ui.bootstrap', 'ui.bootstrap.datetimepicker', 'ui.select']);
//'ngGrid','ngRoute','angularFileUpload','ngMaterial','blockUI','angular-timezone-selector','ngAnimate', 'ui.utils.masks', 'ui.router', 'ui.grid','ui.grid.pagination', 'xeditable','ui.bootstrap', 'ui.bootstrap.datetimepicker', 'ui.select','ngSanitize','ngNotify','components','fcsa-number'


app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    
	
	  $stateProvider
	    .state('main', { url: "/",templateUrl: "views/dashboard.html",controller: 'dashboardController'})
	    .state('aboutus', { url: "/aboutus",templateUrl: "views/aboutus.html"})
	       .state('main.addFood', {url:'/addFood',  templateUrl: 'views/food/addFood.html', controller: 'addFoodController'})
	  
	 $urlRouterProvider.otherwise('/');
	
}]);

    