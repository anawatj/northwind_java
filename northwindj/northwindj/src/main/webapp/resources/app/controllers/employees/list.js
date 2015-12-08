/**
 * 
 */
app.controller('employeesListCtrl',function($scope,masterService,employeesService,$q,config)
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
		$('#pleaseWaitDialog').modal('show');
			masterService.getAllDepartment()
			.success(function(data)
				{
					$scope.departments=data.list;
					$('#pleaseWaitDialog').modal('hide');
				});
	};
	$scope.search=function()
	{
		$('#pleaseWaitDialog').modal('show');
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
			$('#pleaseWaitDialog').modal('hide');
		});
	};
	$scope.clear=function()
	{
		$scope.model={};
		$scope.model.page=1;
	};
	$scope.edit=function(item)
	{
		window.location=url+"employees/entry.html?id="+item.id;
	};
	$scope.remove=function(item)
	{
		employeesService.remove(item.id)
		.success(function(data)
		{
			window.location= url+"employees/list.html";
		});
	};
	
	
});