app.controller('addTransportationController',['$scope','$http','$log','transportationService','$mdDialog','appConstants','uiGridConstants','sharedDataService','$location','configServiceTrans',
									function($scope,$http,$log,transportationService,$mdDialog,appConstants,uiGridConstants,sharedDataService,$location,configServiceTrans) {
	$scope.transportation={};

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
	
		 transportationService.addTransportationExpense($scope.transportation).then(function(msg){
					 $scope.sendSharedMessage(msg,'/addTransportation');
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
			
	 $scope.loadTransportationData = function() {
		
		 transportationService.getTransportationData().then(function(data){
			        $scope.transportationData = data._embedded.transportation;
					$scope.position=data._embedded.transportation;
					$scope.gridOptions.data = data._embedded.transportation;
					$scope.gridOptions.totalItems =(data._embedded.transportation).length;
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
			      { field: 'expense', displayName:"Expense", cellClass: 'ui-grid-align', cellTemplate: '<div class="text-wrap"><a ng-click="grid.appScope.editTransportation(row.entity.id); $event.stopPropagation();">{{row.entity.expense}}<md-tooltip>{{row.entity.expense}}} </md-tooltip> </a></div>'},
			      { field: 'date', displayName:"Date", cellClass: 'ui-grid-align'},
			      { field: 'category', displayName:"category", width: 100, cellClass: 'ui-grid-align'},
			      { field: 'description', displayName:"Description", width: 100, cellClass: 'ui-grid-align'},
			      { field: 'delete', enableSorting: false, cellTemplate: '<a class="glyphicon glyphicon-remove" ng-click="grid.appScope.deleteTransportation(row.entity)"></a>' }
			    ],
			    onRegisterApi: function( gridApi ) {
			    	$scope.gridApi = gridApi;
		 	        $scope.gridApi.grid.registerRowsProcessor($scope.singleFilter, 200);
			    }
			  };
	
		$scope.loadTransportationData();
		$scope.deleteTransportation = function(rowEntity) {
			sharedDataService.showConformPopUp("Are you sure you want to delete?","Delete Transportation",$mdDialog).then(function(){
				$scope.transportationData.splice($scope.transportationData.indexOf(rowEntity), 1);
	        	transportationService.deleteTransportation(rowEntity.id).then(function(msg){
		        	$scope.message = rowEntity.expense+ " " + msg;
		        	$scope.cls = appConstants.SUCCESS_CLASS;
		        	$timeout(function() { $scope.alHide();},3000);
	    		}).catch(function(deleteMessage){
	    			sendSharedMessage(msg, appConstants.ERROR_CLASS);
	                $timeout(function() { $scope.alHide(); }, 5000);
	    		}); 
			});
			$scope.editTransportation = function(cnt) {
				configServiceTrans.setId(cnt);
				location.href='#/viewTransportation';
				
			};
	    }
		/*http://localhost:8080/people/search/findByLastName{?name}*/
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