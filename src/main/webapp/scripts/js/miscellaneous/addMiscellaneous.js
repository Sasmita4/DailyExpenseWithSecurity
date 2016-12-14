

app.controller('addMiscellaneousController',['$scope','$http','$log','miscellaneousService','appConstants','uiGridConstants','sharedDataService','$location',
									function($scope,$http,$log,miscellaneousService,appConstants,uiGridConstants,sharedDataService,$location) {
	$scope.food={};

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
	 $scope.submit=function(){
	
			miscellaneousService.addFoodExpense($scope.food).then(function(msg){
				
					 $scope.sendSharedMessage(msg,'/addFood');
				
	    	}).catch(function(msg){
	    		$scope.message=msg;
	    		$scope.cls=appConstants.ERROR_CLASS;
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
		
		// Disable weekend selection
		$scope.disabled = function(date, mode) {
		   return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
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
			
	 $scope.loadFoodData = function() {
		
		 miscellaneousService.getFoodData().then(function(data){
					$scope.position=data;
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
			      { field: 'expense', displayName:"Expense", cellClass: 'ui-grid-align'},
			      { field: 'date', displayName:"Date", cellClass: 'ui-grid-align'},
			      { field: 'category', displayName:"category", width: 100, cellClass: 'ui-grid-align'},
			      { field: 'description', displayName:"Description", width: 100, cellClass: 'ui-grid-align'}
			      
			    ],
			    onRegisterApi: function( gridApi ) {
			    	$scope.gridApi = gridApi;
		 	        $scope.gridApi.grid.registerRowsProcessor($scope.singleFilter, 200);
			    }
			  };
	
		$scope.loadFoodData();
		$scope.gotoAnchor = function() {
		       var newHash = 'top';
		       if ($location.hash() !== newHash) {
		         $location.hash('top');
		       } else {
		         $anchorScroll();
		       }
		};
		$scope.sendSharedMessage=function(msg,msgCls){
			$scope.message=msg;
			$scope.cls=msgCls;
			$scope.gotoAnchor();
		}
}]);