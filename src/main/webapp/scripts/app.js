var app = angular.module('dailyExpenceApp',  ['ngGrid','ngRoute','ngMaterial','blockUI','angular-timezone-selector','ngAnimate', 'ui.router', 'ui.grid','ui.grid.pagination', 'xeditable','ui.bootstrap', 'ui.bootstrap.datetimepicker', 'ui.select']);
//'ngGrid','ngRoute','angularFileUpload','ngMaterial','blockUI','angular-timezone-selector','ngAnimate', 'ui.utils.masks', 'ui.router', 'ui.grid','ui.grid.pagination', 'xeditable','ui.bootstrap', 'ui.bootstrap.datetimepicker', 'ui.select','ngSanitize','ngNotify','components','fcsa-number'

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	  $stateProvider
	    .state('main', { url: "/",templateUrl: "views/dashboard.html",controller: 'dashboardController'})
	    .state('aboutus', { url: "/aboutus",templateUrl: "views/aboutus.html"})
	    .state('help', { url: "/help",templateUrl: "views/help.html"})
	    .state('contact', { url: "/contact",templateUrl: "views/contact.html"})
	    .state('main.usersList',{url:"/usersList",templateUrl:"views/user/userList.html"})
	    .state('main.addFood', {url:'/addFood',  templateUrl: 'views/food/addFood.html', controller: 'addFoodController'})
	    .state('main.addTransportation', {url:'/addTransportation',  templateUrl: 'views/transportation/addTransportation.html', controller: 'addTransportationController'})
	    .state('main.addMiscellaneous', {url:'/addMiscellaneous',  templateUrl: 'views/miscellaneous/addMiscellaneous.html', controller: 'addMiscellaneousController'})
	    .state('main.createCategory', {url:'createCategory', templateUrl: 'views/category/createCategory.html', controller: 'createCategoryController'})
	    .state('viewFood', { url: '/viewFood',templateUrl: 'views/food/viewFood.html',controller:'viewFoodController'})
	    .state('viewTransportation', { url: '/viewTranportation',templateUrl: 'views/tranportation/viewTranportation.html',controller:'viewTranportationController'})
	    .state('main.report', {url:'/searchReport',templateUrl: 'views/reports/report.html',controller:'reportController'})
	    $urlRouterProvider.otherwise('/');
}]);

    