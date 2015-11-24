/**
 * 
 */
app.factory("suppliersService", [ '$http', function($http) {
	var factory = {};
	factory.getAll = function() {
		return $http.get(url + "suppliers/all");
	};
	factory.getById = function(key) {
		return $http.get(url + "suppliers/single", {
			params : {
				id : key
			}
		});
	};
	factory.search = function(model) {
		return $http.post(url + "suppliers/search", model);
	};
	factory.save = function(model) {
		return $http.post(url + "suppliers/save", model);
	};
	factory.remove = function(key) {
		var model = {
			id : key
		};
		return $http.post(Url + "suppliers/delete", model);
	};
	return factory;
} ]);