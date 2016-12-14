app.service('sharedDataService', function() {
	var data;
	var message;
	var cls;
		return {
			setData: function(body) {
	        	data=body;
	        },
	        getData: function() {
	        	return data;
	     },
	        setmessage: function(msg) {
	        	message=msg;
	        },
	        getmessage: function() {
	        	return message;
	     },
	        setClass: function(msg) {
	        	cls=msg;
	        },
	        getClass: function() {
	        	return cls;
	     },
	        showAlertPopUp: function(message,$mdDialog)
	        {
	        	var confirm = $mdDialog.confirm()
	  	      .title('Warning')
	  	      .content(message)
	  	      .ariaLabel('Warning')
	  	      .ok('Got It!')
	  	    return $mdDialog.show(confirm);
	        	
	        },
	     	showConformPopUp: function(message,title,$mdDialog)
	        {
	          var confirm = $mdDialog.confirm()
	  	      .title(title)
	  	      .content(message)
	  	      .ariaLabel('Warning')
	  	      .ok('OKAY!')
	  	      .cancel("NOPE")
	  	      return $mdDialog.show(confirm);
	        	
	        }
	        
	    };	
	});