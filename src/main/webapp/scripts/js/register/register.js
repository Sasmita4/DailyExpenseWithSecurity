myApp.controller('registerCtrl',['$scope','$state','$http','registerService',
									function($scope,$http,$state,registerService) {
	$scope.user={};
	$scope.submit=function(){
	 registerService.newUserRegister($scope.user).then(function(msg){
	    $scope.sendSharedMessage(msg,'/registerUser');
	}).catch(function(msg){
		$scope.message=msg;
		$log.error(msg);
	})
	}
	$scope.sendSharedMessage=function(msg,msgCls){
		$scope.message=msg;
		$scope.gotoAnchor();
	}
}]);