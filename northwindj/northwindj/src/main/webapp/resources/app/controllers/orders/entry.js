/**
 * 
 */
app.controller('ordersEntryCtrl',function($scope,masterService,ordersService,shippersService,$pageUtils,$CommonUtils,$q,$modal)
		{
			$scope.model={};
			$scope.countries=[];
			$scope.cities=[];
			$scope.regions=[];
			$scope.shippers=[];
			$scope.init=function()
			{
				$scope.urlParameter = $pageUtils.getUrlVars();
				$scope.id = $scope.urlParameter.id;
				if($scope.id==null || $scope.id==undefined)
				{
					$scope.id=0;
				}
				var promise = $scope.load();
				promise.then(function()
						{
					
						});
			};
			$scope.load=function()
			{
				 var deferred = $q.defer();
				 var promise = $q.all
				 (
						[
						 masterService.getAllCountry(),
						 masterService.getAllRegions(),
						 shippersService.getAll(),
						 ordersService.getById($scope.id)
						 ]
				 ).then(function(data)
				   {
					 	$scope.countries =data[0].data.list;
					 	$scope.regions = data[1].data.list;
					 	$scope.shippers=  data[2].data.list;
					 	if(data[3].data!=null && data[3].data!=undefined && data[3].data!="")
					 	{
					 		$scope.model = data[3].data;
					 		$scope.model.customer = $CommonUtils.convertNullToObject($scope.model.customer);
					 		$scope.model.employee = $CommonUtils.convertNullToObject($scope.model.employee);
					 		$scope.model.shipVia = $CommonUtils.convertNullToObject($scope.model.shipVia);
					 		$scope.model.shipCity = $CommonUtils.convertNullToObject($scope.model.shipCity);
					 		$scope.model.shipRegion = $CommonUtils.convertNullToObject($scope.model.shipRegion);
					 		$scope.model.shipCountry = $CommonUtils.convertNullToObject($scope.model.shipCountry);
					 		if($scope.model.shipCountry!={})
					 		{
					 			$scope.countryChange();
					 		}
					 		$scope.model.orderDate = new Date($scope.model.orderDate);
					 		$scope.model.requireDate= new Date($scope.model.requireDate);
					 		$scope.model.shipperDate= new Date($scope.model.shipperDate);
					 		$scope.model.details = $CommonUtils.convertNullToArray($scope.model.details);
					 		if($scope.model.details!=[])
					 		{
					 			for(var index=0;index<$scope.model.details.length;index++)
					 			{
					 				var detail = $scope.model.details[index];
					 				detail.product = $CommonUtils.convertNullToObject(detail.product);
					 			}
					 		}
					 	}else
					 	{
					 		$scope.model={};
					 		$scope.model.id=0;
					 	}
					 	deferred.resolve(data);
				   });
				 return promise;
			};
			$scope.countryChange=function()
			{
				masterService.getAllCity($scope.model.shipCountry.id)
				.success(function(data)
				{
					$scope.cities=data.list;
				});
			};
			$scope.addDetail=function()
			{
				var detail = {};
				detail.id=0;
				detail.selected=false;
				$scope.model.details.push(detail);
			};
			$scope.delDetail=function()
			{
				for(var index=0;index<$scope.model.details.length;index++)
				{
					var detail = $scope.model.details[index];
					if(detail.selected==true)
					{
						$scope.model.details.splice(index,1);
						index--;
					}
				}
			};
			$scope.findEmployee=function()
			{
				
			};
			$scope.findCustomer=function()
			{
				
			};
			$scope.findProduct=function(index)
			{
				
			};
			$scope.save=function()
			{
				ordersService.save($scope.model)
				.success(function(data)
					{
							window.location = url+"orders/entry.html?id="+data.id;
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
					window.location = url+"orders/entry.html?id="+$scope.id;
				}
			}
		});