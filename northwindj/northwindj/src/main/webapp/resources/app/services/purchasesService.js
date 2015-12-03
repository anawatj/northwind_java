/**
 * 
 */
app.factory("purchasesService", [ '$http', function($http) {
	var factory = {};
	factory.getAll = function() {
		return $http.get(url + "purchases/all");
	};
	factory.getById = function(key) {
		return $http.get(url + "purchases/single", {
			params : {
				id : key
			}
		});
	};
	factory.search = function(model) {
		return $http.post(url + "purchases/search", model);
	};
	factory.save = function(model) {
		return $http.post(url + "purchases/save", model);
	};
	factory.remove = function(key) {
		var model = {
			id : key
		};
		return $http.post(url + "purchases/delete", model);
	};
	return factory;
} ]);