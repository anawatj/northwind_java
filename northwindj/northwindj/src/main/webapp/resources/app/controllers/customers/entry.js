/**
 * 
 */
app.controller('customersEntryCtrl',function($scope,masterService,customersService,$pageUtils,$q,$CommonUtils)
		{
			$scope.model={};
			$scope.countries=[];
			$scope.cities=[];
			$scope.regions=[];
			$scope.demographics=[];
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
				  			masterService.getAllDemoGraphics(),
				  			customersService.getById($scope.id)
				  			
				  		]
				  	).then(function(data)
				  			{
				  					$scope.countries = data[0].data.list;
				  					$scope.regions= data[1].data.list;
				  					$scope.demographics = data[2].data.list;
				  					if(data[3].data!=null && data[3].data!=undefined  && data[3].data!="")
				  					{
				  						$scope.model = data[3].data;
				  						$scope.model.country= $CommonUtils.convertNullToObject($scope.model.country);
				  						if($scope.model.country!={})
				  						{
				  							$scope.countryChange();
				  						}
				  						$scope.model.city= $CommonUtils.convertNullToObject($scope.model.city);
				  						$scope.model.region = $CommonUtils.convertNullToObject($scope.model.region);
				  						$scope.model.demos = $CommonUtils.convertNullToArray($scope.model.demos);
				  						
				  					}else
				  					{
				  						$scope.model={};
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
							$scope.cities= data.list;
						})	;
			};
			$scope.save=function()
			{
				customersService.save($scope.model)
				.success(function(data)
						{
							window.location=url+"customers/entry.html?id="+data.id;
						})	;
			};
			$scope.clear=function()
			{
				$scope.model={};
			};
		});