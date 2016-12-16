angular.module('dailyExpenceApp')
		   .service('foodService',['$http','$filter','$rootScope','$q',	
		                                 foodService]);
function foodService($http,$filter,$rootScope,appConstants,$q) {
	return {
		addFoodExpense : addFoodExpense,
		getFoodData : getFoodData,
		deleteFood : deleteFood,
		getDataByIds : getDataByIds
	
	};
	function addFoodExpense(foodDto){
		return $http.post('/insertFood', foodDto)
		.then(getFoodSuccess)
		.catch('error');
	}
	function getFoodData(){
		
	
			return $http.get('/getAllFood')
			.then(getFoodSuccess)
			.catch(getFoodError);
	
		
	}
	function deleteFood(id){
		
			return $http.delete('deleteFood?id='+id)
						.then('expense deleted')
						.catch("food is not deleted");
	
	}
	
	function getDataByIds(id){
		return $http.get('getFoodById?id='+id)
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