/**
 * 
 */
app.factory('receiptsService',['$http',function($http)
                       {
							var factory ={};
							factory.getAll=function()
							{
								return $http.get(url+"receipts/all");
							};
							factory.getById=function(key)
							{
								return $http.get(url+"receipts/single",{params:{id:key}});
							};
							factory.search=function(model)
							{
								return $http.post(url+"receipts/search",model);
							};
							factory.save=function(model)
							{
								return $http.post(url+"receipts/save",model);
							};
							factory.remove=function(key)
							{
								var data={id:key};
								return $http.post(url+"receipts/delete",data);
							}
                       }]);	