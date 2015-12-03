/**
 * 
 */
app.controller('purchasesListCtrl',function($scope,purchasesService,$modal,config)
{
	$scope.model={};
	$scope.results=[];
	$scope.pageSize = config.pageSize;
	$scope.maxSize = config.paginationSize;
	$scope.totalItems = 0;
	$scope.init=function()
	{
		
	};
	$scope.search=function()
	{
		if($scope.model.page==undefined)
		{
			$scope.model.page=1;
		};
		purchasesService.search($scope.model)
		.success(function(data)
		{
			$scope.pages= data.pages;
			$scope.results =data.list;
			$scope.totalItems= data.totalRecord;
		});
	};
	$scope.edit=function(item)
	{
		window.location = url+"purchases/entry.html?id="+item.id;
	};
	$scope.remove=function(item)
	{
		purchasesService.remove(item.id)
		.success(function(data)
		{
			window.location= url+"purchases/list.html";
		});
	};
	$scope.findEmployee=function()
	{
		var modalInstance = $modal.open({
			templateUrl : url
					+ 'employees/searchModal.html',
			controller : 'employeeSearchModalCtrl',
			size : 'lg',
			backdrop : false,
			animation : true,
			resolve : {
				parameter : function() {
		
				}
			}
		});

		modalInstance.result
				.then(
						function(selectedItem) {
							if(selectedItem!=undefined)
							{
								$scope.model.employee={};
								$scope.model.employee = selectedItem.id;
								//$scope.model.employee.firstName = selectedItem.firstName;
								//$scope.model.employee.lastName = selectedItem.lastName;
							}
						});
	};
	$scope.findSupplier=function()
	{
		var modalInstance = $modal.open({
			templateUrl : url
					+ 'suppliers/searchModal.html',
			controller : 'suppliersSearchModalCtrl',
			size : 'lg',
			backdrop : false,
			animation : true,
			resolve : {
				parameter : function() {
		
				}
			}
		});

		modalInstance.result
				.then(
						function(selectedItem) {
							if(selectedItem!=undefined)
							{
								$scope.model.supplier=selectedItem.id;
						
							}
						});
	};
});