app.controller('reportController',['$scope','$state','$log','$http','reportServices',
									function($scope,$http,$log,$state,reportServices) {
	$scope.report={};
	
	 $scope.reportSubmit=function(){
		 debugger;
		 reportServices.searchExpense($scope.report).then(function(msg){
					 $scope.sendSharedMessage(msg,'/addFood');
	    	}).catch(function(msg){
	    		$scope.message=msg;
				$log.error(msg);
	    	})
	 }
	 $scope.today = function() {
		    $scope.dt = new Date();
		  };
		  
	    $scope.today();

		$scope.clear = function () {
		    $scope.dt = null;
		};
		
		$scope.toggleMin = function() {
		   $scope.minDate = $scope.minDate ? null : new Date();
		};
		$scope.toggleMin();
		$scope.open_fromDate = function($event) {
			   $event.preventDefault();
			   $event.stopPropagation();
		      $scope.opened1 = true;
			};
			$scope.open_toDate = function($event) {
				   $event.preventDefault();
				   $event.stopPropagation();
			      $scope.opened2 = true;
				};

			$scope.dateOptions = {
			   formatYear: 'yy',
			   startingDay: 1
			};
			  
			$scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
			$scope.format = $scope.formats[0];
			$scope.reportTypes=['food','tranportation','miscellaneous'];
			
	 $scope.sendSharedMessage=function(msg,msgCls){
			$scope.message=msg;
		}
}]);
