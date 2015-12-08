/**
 * 
 */
app.controller('categoriesListCtrl',function($scope,categoriesService,config)
{
		$scope.model ={};
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
			}
			categoriesService.search($scope.model)
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
			window.location=url+"categories/entry.html?id="+item.id;
		};
		$scope.remove=function(item)
		{
			categoriesService.remove(item.id)
			.success(function(data)
			{
				window.location= url+"categories/list.html";
			})
		};
		
});