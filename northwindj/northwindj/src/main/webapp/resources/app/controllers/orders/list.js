/**
 * 
 */
app.controller('ordersListCtrl',function($scope,ordersService,$modal,config)
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
		$('#pleaseWaitDialog').modal('show');
		if($scope.model.page==undefined)
		{
			$scope.model.page=1;
		};
		ordersService.search($scope.model)
		.success(function(data)
		{
			$scope.pages= data.pages;
			$scope.results =data.list;
			$scope.totalItems= data.totalRecord;
			$('#pleaseWaitDialog').modal('hide');
		});
	};
	$scope.edit=function(item)
	{
		window.location = url+"orders/entry.html?id="+item.id;
	};
	$scope.remove=function(item)
	{
		ordersService.remove(item.id)
		.success(function(data)
		{
			window.location= url+"orders/list.html";
		});
	};
	$scope.findCustomer=function()
	{
		var modalInstance = $modal.open({
			templateUrl : url
					+ 'customers/searchModal.html',
			controller : 'customersSearchModalCtrl',
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
								$scope.model.customer={};
								$scope.model.customer = selectedItem.id;
								//$scope.model.customer.customerCode = selectedItem.customerCode;
								//$scope.model.customer.companyName = selectedItem.companyName;
							}
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
});