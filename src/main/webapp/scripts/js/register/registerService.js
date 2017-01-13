angular.module('myApp')
		   .service('registerService',['$http','$filter','$rootScope','$q',	registerService]);
function registerService($http,$filter,$rootScope,$q) {
	return {
		newUserRegister : newUserRegister
	};
	function newUserRegister(usersDto){
		return $http.post('/registerUser', usersDto)
		.then('success')
		.catch('error');
	}
}

	