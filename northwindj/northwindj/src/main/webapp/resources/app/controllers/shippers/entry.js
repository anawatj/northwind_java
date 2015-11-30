/**
 * 
 */
app.controller('shippersEntryCtrl',function($scope,shippersService,$pageUtils)
{
	$scope.model={};
	$scope.init=function()
	{
		$scope.urlParameter = $pageUtils.getUrlVars();
		$scope.id = $scope.urlParameter.id;
		if($scope.id==null || $scope.id==undefined)
		{
			$scope.id=0;
		}
		$scope.load();
	};
	$scope.load=function()
	{
		shippersService.getById($scope.id)
		.success(function(data)
		{
			if(data!=null && data!=undefined && data!="")
			{
				$scope.model= data;
			}else
			{
				$scope.model = {};
				$scope.model.id=0;
			}
		});
	};
	$scope.save=function()
	{
		shippersService.save($scope.model)
		.success(function(data)
				{
					window.location = url +"shippers/entry.html?id="+data.id;
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
			window.location = url +"shippers/entry.html?id="+$scope.id;
		}
		
	};
});