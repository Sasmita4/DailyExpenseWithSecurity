angular.module('dailyExpenceApp')
		   .service('miscellaneousService',['$http','$filter','$rootScope','$q',	
		                                 miscellaneousService]);
function miscellaneousService($http,$filter,$rootScope,appConstants,$q) {
	return {
		addFoodExpense : addFoodExpense,
		getFoodData:getFoodData
	
	};
	function addFoodExpense(foodDto){
		return $http.post('/insertMiscellaneous', foodDto)
		.then('success')
		.catch('error');
	}
	function getFoodData(){
		
	
			return $http.get('/getAllMiscellaneous')
			.then(getFoodSuccess)
			.catch(getFoodError);
	
		
	}
	function getFoodSuccess(response){
		return response.data;
	}
	function getFoodError(response){
		return "Failed To Get FoodData! Response";
	}
}