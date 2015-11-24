/**
 * 
 */
app.factory("shippersService", [ '$http', function($http) {
	var factory = {};
	factory.getAll = function() {
		return $http.get(url + "shippers/all");
	};
	factory.getById = function(key) {
		return $http.get(url + "shippers/single", {
			params : {
				id : key
			}
		});
	};
	factory.search = function(model) {
		return $http.post(url + "shippers/search", model);
	};
	factory.save = function(model) {
		return $http.post(url + "shippers/save", model);
	};
	factory.remove = function(key) {
		var model = {
			id : key
		};
		return $http.post(Url + "shippers/delete", model);
	};
	return factory;
} ]);