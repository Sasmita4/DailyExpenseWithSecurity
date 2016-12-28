app.controller("mainCtrl", ['$scope','$http','$location', function($scope,$http,$location) {
	
	$scope.go = function () {
		$http.post('/logout', {}).success(function(data) {
	    	  debugger;
	        $location.path("/");
		}).error(function(data) {
	        console.log("Logout failed")
		      //  self.authenticated = false;
		      });
		    };
}]);