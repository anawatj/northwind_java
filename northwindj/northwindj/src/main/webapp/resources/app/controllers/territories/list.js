/**
 * 
 */
app.controller('territoriesListCtrl',function($scope,masterService,territoriesService,config,$q)
{
	$scope.model = {};
	$scope.results = [];
	$scope.pageSize = config.pageSize;
	$scope.maxSize = config.paginationSize;
	$scope.totalItems = 0;
	$scope.regions=[];
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
					 		masterService.getAllRegions()
					 ]
		).then(function(data)
		{
			$scope.regions=data[0].data.list;
			deferred.resolve(data);
		});
		return promise;
	};
	$scope.search = function() {
		$('#pleaseWaitDialog').modal('show');
		if ($scope.model.page == undefined) {
			$scope.model.page = 1;
		}
		territoriesService.search($scope.model).success(function(data) {
			$scope.pages = data.pages;
			$scope.results = data.list;
			$scope.totalItems = data.totalRecord;
			$('#pleaseWaitDialog').modal('hide');
		});
	};
	$scope.clear = function() {
		$scope.model = {};
		$scope.model.page = 1;
	};
	$scope.edit=function(item)
	{
		window.location=url+"territories/entry.html?id="+item.id;
	};
	$scope.remove=function(item)
	{
		territoriesService.remove(item.id)
		.success(function()
				{
					window.location=url+"territories/list.html";
				});
	};
});