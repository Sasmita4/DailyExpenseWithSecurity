app.controller('viewFoodController',['$scope','configTrans','transportationService',
									function($scope,configTrans,transportationService) {
	 
	
	
	 $scope.updateSubmit=function(){
		 transportationService.updateTransportationExpense($scope.transportation).then(function(msg){
			$scope.sendSharedMessage(msg,'/addTransportation');
			location.href='#/addTransportation';
	    	}).catch(function(msg){
	    		console.log('error')
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
		$scope.open = function($event) {
			   $event.preventDefault();
			   $event.stopPropagation();
		      $scope.opened = true;
			};
			$scope.dateOptions = {
			   formatYear: 'yy',
			   startingDay: 1
			};
			$scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
			$scope.format = $scope.formats[0];
			$scope.categorys=['Online','By Cash'];
			
	$scope.getTransportationData=function(){
		debugger;
		var id = configTrans.getId();
		transportationService.getDataByIds(id).then(function(data){
		   $scope.transportation = data;
		}).catch(function(msg){
			console.log('error')
	});	
	}
	$scope.getTransportationData();
	$scope.sendSharedMessage=function(msg,msgCls){
		$scope.message=msg;
	}
}]);