/**
 * 
 */
app.factory('masterService',['$http',function($http)
                             {
									var factory = {};
									factory.getAllCountry=function()
									{
										return $http.get(url+"master/country/all");
									};
									factory.getAllCity=function(countryId)
									{
										return $http.get(url+"master/city/all",{params:{id:countryId}});
									};
									factory.getAllDemoGraphics=function()
									{
										return $http.get(url+"master/demographics/all");
									};
									factory.getAllDepartment=function()
									{
										return $http.get(url+"master/department/all");
									};
									factory.getAllEducationLevel=function()
									{
										return $http.get(url+"master/educationLevel/all");
									};
									factory.getAllRegions=function()
									{
										return $http.get(url+"master/regions/all");
									};
									factory.getAllTitle=function()
									{
										return $http.get(url+"master/title/all");
									};
									return factory;
									
                             }]);	