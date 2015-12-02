/**
 * 
 */
app.factory("ordersService", [ '$http', function($http) {
	var factory = {};
	factory.getAll = function() {
		return $http.get(url + "orders/all");
	};
	factory.getById = function(key) {
		return $http.get(url + "orders/single", {
			params : {
				id : key
			}
		});
	};
	factory.search = function(model) {
		return $http.post(url + "orders/search", model);
	};
	factory.save = function(model) {
		return $http.post(url + "orders/save", model);
	};
	factory.remove = function(key) {
		var model = {
			id : key
		};
		return $http.post(url + "orders/delete", model);
	};
	return factory;
} ]);