/**
 * 
 */
app.factory("productsService", [ '$http', function($http) {
	var factory = {};
	factory.getAll = function() {
		return $http.get(url + "products/all");
	};
	factory.getById = function(key) {
		return $http.get(url + "products/single", {
			params : {
				id : key
			}
		});
	};
	factory.search = function(model) {
		return $http.post(url + "products/search", model);
	};
	factory.save = function(model) {
		return $http.post(url + "products/save", model);
	};
	factory.remove = function(key) {
		var model = {
			id : key
		};
		return $http.post(Url + "products/delete", model);
	};
	return factory;
} ]);