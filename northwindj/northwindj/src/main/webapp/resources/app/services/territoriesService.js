/**
 * 
 */
app.factory("territoriesService", [ '$http', function($http) {
	var factory = {};
	factory.getAll = function() {
		return $http.get(url + "territories/all");
	};
	factory.getById = function(key) {
		return $http.get(url + "territories/single", {
			params : {
				id : key
			}
		});
	};
	factory.search = function(model) {
		return $http.post(url + "territories/search", model);
	};
	factory.save = function(model) {
		return $http.post(url + "territories/save", model);
	};
	factory.remove = function(key) {
		var model = {
			id : key
		};
		return $http.post(url + "territories/delete", model);
	};
	return factory;
} ]);