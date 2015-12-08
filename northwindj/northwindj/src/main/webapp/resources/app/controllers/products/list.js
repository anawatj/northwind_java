/**
 * 
 */
app.controller("productsListCtrl",function($scope,categoriesService,productsService,$modal,config,$q)
{
	$scope.model={};
	$scope.pageSize = config.pageSize;
	$scope.maxSize = config.paginationSize;
	$scope.totalItems = 0;
	$scope.results=[];
	$scope.categories = [];
	$scope.init=function()
	{
		$('#pleaseWaitDialog').modal('show');
		var promise = $scope.load();
		promise.then(function()
				{
			$('#pleaseWaitDialog').modal('hide');
				});
	};
	$scope.load=function()
	{
		var deferred = $q.defer();
		var promise = $q.all
		(
				[
				 	categoriesService.getAll()
				 ]
		).then(function(data)
		{
			$scope.categories =data[0].data.list;
			deferred.resolve(data);
		});
		return promise;
		
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
	$scope.search=function()
	{
		$('#pleaseWaitDialog').modal('show');
		if($scope.model.page==undefined)
		{
			$scope.model.page=1;
		}
		productsService.search($scope.model)
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
		window.location = url+"products/entry.html?id="+item.id;
	};
	$scope.remove=function(item)
	{
		productsService.remove(item.id)
		.success(function(data)
			{
					window.location= url+"products/list.html";
			});
	}
});