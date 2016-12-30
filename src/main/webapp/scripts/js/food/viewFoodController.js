app.controller('viewFoodController',['$scope','configService','foodService',
									function($scope,configService1,foodService) {
	 $scope.updateSubmit=function(){
			foodService.updateFoodExpense($scope.food).then(function(msg){
			$scope.sendSharedMessage(msg,'/addFood');
			location.href='#/addFood';
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
			
	$scope.getfoodData=function(){
		debugger;
		var id = configService1.getId();
		foodService.getDataByIds(id).then(function(data){
		   $scope.food = data;
		}).catch(function(msg){
			console.log('error')
	});	
	}
	$scope.getfoodData();
	$scope.sendSharedMessage=function(msg,msgCls){
		$scope.message=msg;
	}
}]);