/**
 * 
 */
app.factory('categoriesService',['$http',function($http)
                                 {
										var factory = {};
										factory.getAll=function()
										{
											return $http.get(url+"categories/all");
										};
										factory.getById=function(key)
										{
											return $http.get(url+"categories/single",{params:{id:key}});
										};
										factory.search=function(model)
										{
											return $http.post(url+"categories/search",model);
										};
										factory.save=function(model)
										{
											return $http.post(url+"categories/save",model);
										};
										factory.remove=function(key)
										{
											var model = {id:key};
											return $http.post(url+"categories/delete",model);
										};
										return factory;
                                 }]);