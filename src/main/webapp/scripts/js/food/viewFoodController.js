app.controller('viewFoodController',['$scope','configService','foodService',
									function($scope,configService1,foodService) {
	
	
	$scope.getfoodData=function(){
	 var id=	configService1.getId();

	foodService.getDataByIds(id).then(function(data)
			{
				$scope.food = data;
				
			}).catch(function(msg){
				console.log('error')
			});	
		
	
	}

	$scope.getfoodData();

}]);