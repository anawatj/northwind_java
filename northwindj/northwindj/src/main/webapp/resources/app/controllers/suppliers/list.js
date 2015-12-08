/**
 * 
 */
app.controller('suppliersListCtrl', function($scope, masterService,
		suppliersService, $q, config) {
	$scope.model = {};
	$scope.results = [];
	$scope.pageSize = config.pageSize;
	$scope.maxSize = config.paginationSize;
	$scope.totalItems = 0;
	$scope.countries = [];
	$scope.cities = [];
	$scope.regions = [];
	$scope.init = function() {
		$('#pleaseWaitDialog').modal('show');
		var promise = $scope.load();
		promise.then(function() {
			$('#pleaseWaitDialog').modal('hide');
		});
	};
	$scope.load = function() {
		var deferred = $q.defer();
		var promise = $q
				.all(
						[ masterService.getAllCountry(),
								masterService.getAllRegions() ]).then(
						function(data) {
							$scope.countries = data[0].data.list;
							$scope.regions = data[1].data.list;
							deferred.resolve(data);
						});
		return promise;

	};

	$scope.countryChange = function() {
		masterService.getAllCity($scope.model.country).success(function(data) {
			$scope.cities = data.list;
		});
	};
	$scope.search = function() {
		$('#pleaseWaitDialog').modal('show');
		if ($scope.model.page == undefined) {
			$scope.model.page = 1;
		}
		suppliersService.search($scope.model).success(function(data) {
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
		window.location=url+"suppliers/entry.html?id="+item.id;
	};
	$scope.remove=function(item)
	{
		suppliersService.remove(item.id)
		.success(function()
				{
					window.location=url+"suppliers/list.html";
				});
	};

});