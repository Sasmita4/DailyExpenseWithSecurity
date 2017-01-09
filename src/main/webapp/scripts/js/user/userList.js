app.controller('userListController',['$scope','$state','$http','appConstants','uiGridConstants','userService',
	                                function($scope,$state,$http,appConstants,uiGridConstants,userService){
	$scope.numRows = 10;
	$scope.itemsPerPage = appConstants.ITEMS_PER_PAGE;
	$scope.currentPage = 0;
	$scope.changePage = function(){
		$scope.currentPage = 0;
	}
	$scope.range = function (start) {
		var pageCnt = $scope.pageCount();
        var ret = [];

		if (start + 1 == pageCnt && pageCnt==1) {
			ret.push(0);
			return ret;
		}
		if ((start + 2 >= pageCnt)) {
			while (start + 2 >= pageCnt)
				start--;
		}
		if(start<0)
			start=0;
		for (var i = start; i < pageCnt; i++) {
			ret.push(i);
			if (i == start + 2)
				break;
		}
		return ret;
    };
    $scope.prevPage = function() {
	    if ($scope.currentPage > 0) {
	      $scope.currentPage--;
	    }
	  };

	  $scope.pageCount = function() {
		if (!$scope.position) { return; }
	    return Math.ceil($scope.position.length/$scope.itemsPerPage);
	  };

	  $scope.nextPage = function() {
	    if ($scope.currentPage > $scope.pageCount()) {
	      $scope.currentPage++;
	    }
	  };

	  $scope.setPage = function() {
	    $scope.currentPage = this.n;
	  };
		 $scope.loadUsers = function() {
			 userService.loadUsers().then(function(data){
				  $scope.userData=data;
				  $scope.gridOptions.data = data;
				  $scope.gridOptions.totalItems = data.length;
				  $scope.gridOptions.paginationPageSize = $scope.numRows;
				  $scope.gridOptions.minRowsToShow = data.length < $scope.numRows ? data.length : $scope.numRows;
			 }).catch(function(msg){
			   	  $log.error("Failed To Load Data! ---> "+msg);
			   	  $scope.errorHide = false;
			   	  $scope.errorMsg = msg;
			 })
		  }
			$scope.gridOptions = {
				    enableSorting: true,
				    enableColumnMenus: false,
					enablePaginationControls: false,
					enableHorizontalScrollbar : uiGridConstants.scrollbars.NEVER,
			        enableVerticalScrollbar   : uiGridConstants.scrollbars.NEVER,
					paginationCurrentPage: 1,
				    columnDefs: [
				      { field: 'userName', displayName:"UserName", cellClass: 'ui-grid-align',width:100},
				      { field: 'email', displayName:"E-mail", cellClass: 'ui-grid-align'},
				      { field: 'createdDate', displayName:"CreatedOn",cellClass: 'ui-grid-align'},
				      { field: 'authorities', displayName:"Authorities",cellClass: 'ui-grid-align'}
				    ],
				    onRegisterApi: function( gridApi ) {
				    	$scope.gridApi = gridApi;
			 	        $scope.gridApi.grid.registerRowsProcessor($scope.singleFilter, 200);
				    }
				  };
		
			$scope.loadUsers();
			$scope.sendSharedMessage=function(msg,msgCls){
				$scope.message=msg;
				$scope.cls=msgCls;
				$scope.gotoAnchor();
			}
	
}]);