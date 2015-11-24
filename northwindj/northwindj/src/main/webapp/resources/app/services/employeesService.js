/**
 * 
 */
app.factory('employeesService',['$http',function($http)
                                {
									var factory ={};
									factory.getAll = function()
									{
										return $http.get(url+"employees/all");
									};
									factory.getById=function(key)
									{
										return $http.get(url+"employees/single",{params:{id:key}});
									};
									factory.search=function(model)
									{
										return $http.post(url+"employees/search",model);
									};
									factory.save=function(model)
									{
										return $http.post(url+"employees/save",model);
									};
									factory.remove=function(key)
									{
										var model = {id:key};
										return $http.post(Url+"employees/delete",model);
									};
									return factory;
                                }]);