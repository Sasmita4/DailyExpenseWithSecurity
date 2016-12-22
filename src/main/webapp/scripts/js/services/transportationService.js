angular.module('dailyExpenceApp')
		   .service('transportationService',['$http','$filter','$rootScope','$q',	
		                                 transportationService]);
function transportationService($http,$filter,$rootScope,appConstants,$q) {
	return {
		addTransportationExpense : addTransportationExpense,
		getTransportationData:getTransportationData,
		updateTransportationExpense : updateTransportationExpense
	};
	function addTransportationExpense(transportationDto){
		return $http.post('http://localhost:8080/transportationUrl', transportationDto)
		.then('success')
		.catch('error');
	}
	function getTransportationData(){
			return $http.get('http://localhost:8080/transportationUrl')
			.then(getTransportationSuccess)
			.catch(getTransportationError);
	}
	function deleteTransportation(id){
		debugger;
		return $http.delete('http://localhost:8080/transportationUrl?id='+id)
		.then('expense deleted')
		.catch("food is not deleted");
    }
	function updateTransportationExpense(transportationDto){
		return $http.put('http://localhost:8080/transportationUrl', transportationDto)
		.then(getTransportationSuccess)
		.catch('error');
    }
	function getTransportationSuccess(response){
		return response.data;
	}
	function getTransportationError(response){
		return "Failed To Get FoodData! Response";
	}
}