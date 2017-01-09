angular.module('dailyExpenceApp')
		   .service('userService',['$http','$filter','$rootScope','$q',	userService]);
function userService($http,$filter,$rootScope,$q) {
	return {
		loadUsers : loadUsers
	};
	function loadUsers(userDto){
		return $http.get('/getAllUsers', userDto)
		.then(getUserSuccess)
		.catch(getUserError);
	}
	function getUserSuccess(response){
		return response.data;
	}
	function getUserError(response){
		return "Failed To Get UserList! Response";
	}
};