/**
 * 
 */
app.controller('territoriesEntryCtrl', function($scope, territoriesService,
		masterService, $pageUtils, $CommonUtils, $q) {
	$scope.model = {};
	$scope.regions = [];
	$scope.init = function() {
		$scope.urlParameter = $pageUtils.getUrlVars();
		$scope.id = $scope.urlParameter.id;
		if ($scope.id == null || $scope.id == undefined) {
			$scope.id = 0;
		}
		var promise = $scope.load();
		promise.then(function() {

		});
	};
	$scope.load = function() {
		var deferred = $q.defer();
		var promise = $q.all(
				[ masterService.getAllRegions(),
						territoriesService.getById($scope.id) ]).then(
				function(data) {
					$scope.regions = data[0].data.list;
					if (data[1].data != null && data[1].data != undefined
							&& data[1].data != "") {
						$scope.model = data[1].data;
						$scope.model.region = $CommonUtils
								.convertNullToObject($scope.model.region);
					} else {
						$scope.model = {};
						$scope.model.id = 0;
					}
					deferred.resolve(data);
				});
		return promise;
	};
	$scope.save = function() {
		territoriesService.save($scope.model).success(function(data) {
			window.location = url + "territories/entry.html?id=" + data.id;
		});
	};
	$scope.clear = function() {
		if ($scope.id == 0) {
			$scope.model = {};
			$scope.model.id = 0;
		} else {
			window.location = url + "territories/entry.html?id=" + $scope.id;
		}
	}
});