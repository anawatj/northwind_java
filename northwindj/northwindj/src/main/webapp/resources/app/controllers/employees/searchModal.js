/**
 * 
 */
app.controller('employeeSearchModalCtrl',function($scope,masterService,employeesService,$q,config,$modalInstance)
		{
			$scope.model={};
			$scope.results=[];
			$scope.pageSize = config.pageSize;
			$scope.maxSize = config.paginationSize;
			$scope.totalItems = 0;
			$scope.departments=[];
			$scope.init=function()
			{
				$scope.load();
			};
			$scope.load=function()
			{
					masterService.getAllDepartment()
					.success(function(data)
						{
							$scope.departments=data.list;
						});
			};
			$scope.search=function()
			{
				if($scope.model.page==undefined)
				{
					$scope.model.page=1;
				}
				employeesService.search($scope.model)
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
				$scope.model.page=1;
			};
			$scope.select=function(item)
			{
				$modalInstance.close(item);
			};
			$scope.close=function()
			{
				$modalInstance.dismiss('cancel');
			};
		});