
angular.module('dailyExpenceApp')
		   .service('reportServices',['$http','$filter','$rootScope','$q',reportServices]);
function reportServices($http,$filter,$rootScope,$q) {
	return {
		searchExpense : searchExpense,
	};
	function searchExpense(searchDto){
		debugger;
		return $http.post('/api/searchExpenses',searchDto ,{responseType: 'arraybuffer'})
		  .success(function (data) {
		    var file = new Blob([data], {type: 'application/pdf'});
		    var fileURL = URL.createObjectURL(file);
		    window.open(fileURL);
		  });
	}
}