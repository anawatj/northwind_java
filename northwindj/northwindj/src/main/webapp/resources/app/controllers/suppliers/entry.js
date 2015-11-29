/**
 * 
 */
app.controller('suppliersEntryCtrl',function($scope,masterService,suppliersService,$q,$pageUtils,$CommonUtils)
{
	$scope.model={};
	$scope.countries=[];
	$scope.cities=[];
	$scope.regions=[];
	$scope.init=function()
	{
		$scope.urlParameter = $pageUtils.getUrlVars();
		$scope.id = $scope.urlParameter.id;
		if($scope.id==null || $scope.id==undefined)
		{
			$scope.id=0;
		}
		var promise= $scope.load();
		promise.then(function()
				{
			
				});
	};
	$scope.load=function()
	{
		 var deferred = $q.defer();
		 var promise  = $q.all
		 (
				 [
				  	masterService.getAllCountry(),
				  	masterService.getAllRegions(),
				  	suppliersService.getById($scope.id)
				 ]
	     ).then(function(data)
	    		{
	    	 		$scope.countries = data[0].data.list;
	    	 		$scope.regions= data[1].data.list;
	    	 		if(data[2].data!=null && data[2].data!=undefined && data[2].data!="" )
	    	 		{
	    	 			$scope.model = data[2].data;
	    	 			$scope.model.country = $CommonUtils.convertNullToObject($scope.model.country);
	    	 			if($scope.model.country!={})
	    	 			{
	    	 				$scope.countryChange();
	    	 			}
	    	 			$scope.model.city = $CommonUtils.convertNullToObject($scope.model.city);
	    	 			$scope.model.region= $CommonUtils.convertNullToObject($scope.model.region);
	    	 			
	    	 		}else
	    	 		{
	    	 			$scope.model = {};
	    	 			$scope.model.id=0;
	    	 		}
	    	 		deferred.resolve(data);
	    		});
		 return promise;
	};
	$scope.countryChange=function()
	{
		masterService.getAllCity($scope.model.country.id)
		.success(function(data)
			{
				$scope.cities = data.list;
			});
	};
	$scope.save=function()
	{
			suppliersService.save($scope.model)
			.success(function(data)
				{
						window.location = url+"suppliers/entry.html?id="+data.id;
				});
	};
	$scope.clear=function()
	{
		if($scope.id==0)
		{
			$scope.model={};
			$scope.model.id=0;
		}else
		{
			window.location = url+"suppliers/entry.html?id="+$scope.id;
		}
	};
});