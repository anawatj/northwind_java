/**
 * 
 */
app.factory('paymentsService',['$http',function($http)
                            {
								var factory ={};
								factory.getAll=function()
								{
									return $http.get(url+"payments/all");
								};
								factory.getById=function(key)
								{
									return $http.get(url+"payments/single",{params:{id:key}});
								};
								factory.search=function(model)
								{
									return $http.post(url+"payments/search",model);
								};
								factory.save=function(model)
								{
									return $http.post(url+"payments/save",model);
								};
								factory.remove=function(key)
								{
									var data={id:key};
									return $http.post(url+"payments/delete",data);
								};
								return factory;
                            }]);