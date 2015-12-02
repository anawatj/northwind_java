/**
 * 
 */
app.controller('customersListCtrl',function($scope,masterService,customersService,$pageUtils,$q,config)
		{
			$scope.model={};
			$scope.results=[];
			$scope.pageSize = config.pageSize;
			$scope.maxSize = config.paginationSize;
			$scope.totalItems = 0;
			$scope.countries=[];
			$scope.regions=[];
			$scope.cities=[];
			$scope.init=function()
			{
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
							   masterService.getAllRegions()
							 ]
				).then(function(data)
				{
					$scope.countries = data[0].data.list;
					$scope.regions = data[1].data.list;
					deferred.resolve(data);
				});
				return promise;
			};
			$scope.countryChange=function()
			{
				masterService.getAllCity($scope.model.country)
				.success(function(data)
					{
							$scope.cities= data.list;
					});
			};
			$scope.search=function()
			{
					if($scope.model.page==undefined)
					{
						$scope.model.page=1;
					}
					customersService.search($scope.model)
					.success(function(data)
						{
							$scope.pages= data.pages;
							$scope.results =data.list;
							$scope.totalItems= data.totalRecord;
						});
			};
			$scope.clear=function()
			{
				$scope.model={};
				
			};
			$scope.edit=function(item)
			{
				window.location = url+"customers/entry.html?id="+item.id;
			};
			$scope.remove=function(item)
			{
				customersService.remove(item.id)
				.success(function(data)
				{
					window.location= url+"customers/list.html";
				});
			};
		});