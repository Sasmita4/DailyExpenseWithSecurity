angular.module('dailyExpenceApp')
		   .service('foodService',['$http','$filter','$rootScope','appConstants','$q',	
		                                 profileService]);
function profileService($http,$filter,$rootScope,appConstants,$q) {
	return {
		getProfileByCreateremailId : getProfileByCreateremailId,
	
	};
}