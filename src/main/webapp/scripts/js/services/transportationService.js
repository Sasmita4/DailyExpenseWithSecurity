angular.module('dailyExpenceApp')
		   .service('transportationService',['$http','$filter','$rootScope','$q',	
		                                 transportationService]);
function transportationService($http,$filter,$rootScope,appConstants,$q) {
	return {
		addFoodExpense : addFoodExpense,
		getFoodData:getFoodData
	
	};
	function addFoodExpense(foodDto){
		return $http.post('/insertTransportation', foodDto)
		.then('success')
		.catch('error');
	}
	function getFoodData(){
		
	
			return $http.get('/getAllTransportation')
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