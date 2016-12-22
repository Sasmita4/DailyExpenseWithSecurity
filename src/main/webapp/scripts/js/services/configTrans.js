	   app.service('configServiceTrans', function() {
		   var id;
			return {
		        setId: function(cnt) {
		           id=cnt;
		        },
		        getId: function() {
		        	return id;
		     },
		    };	
		});	
