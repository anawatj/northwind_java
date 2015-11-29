/**
 * 
 */
app.controller('productsEntryCtrl',function($scope,productsService,categoriesService,$pageUtils,$CommonUtils,$q,$modal)
		{
			$scope.model={};
			$scope.categories=[];
			$scope.init=function()
			{
				$scope.urlParameter = $pageUtils.getUrlVars();
				$scope.id = $scope.urlParameter.id;
				if($scope.id==null || $scope.id==undefined)
				{
					$scope.id=0;
				}
				var promise = $scope.load();
				promise.then(function()
						{
					
						});
			};
			$scope.load=function()
			{
				 var deferred = $q.defer();
				 var promise = $q.all
				 (
						[
						 		categoriesService.getAll(),
						 		productsService.getById($scope.id)
						 ] 
				 ).then(function(data)
				{
					 $scope.categories = data[0].data.list;
					 if(data[1].data!=null && data[1].data!=undefined&& data[1].data!="")
					 {
						 $scope.model=data[1].data;
						 $scope.model.category = $CommonUtils.convertNullToObject($scope.model.category);
						 $scope.model.supplier = $CommonUtils.convertNullToObject($scope.model.supplier);
						 
					 }else
					 {
						 $scope.model= {};
						 $scope.model.id=0;
						 
					 }
					 deferred.resolve(data);
				});
				 return promise;
			};
			$scope.findSupplier=function()
			{
				var modalInstance = $modal.open({
					templateUrl : url
							+ 'suppliers/searchModal.html',
					controller : 'suppliersSearchModalCtrl',
					size : 'lg',
					backdrop : false,
					animation : true,
					resolve : {
						parameter : function() {
				
						}
					}
				});

				modalInstance.result
						.then(
								function(selectedItem) {
									if(selectedItem!=undefined)
									{
										$scope.model.supplier={};
										$scope.model.supplier.id = selectedItem.id;
										$scope.model.supplier.companyName = selectedItem.companyName;
									}
								});
			};
			$scope.save=function()
			{
				productsService.save($scope.model)
				.success(function(data)
				{
					window.location= url+"products/entry.html?id="+data.id;
				});
			};
			$scope.clear=function()
			{
				if($scope.id==0)
				{
					$scope.model={};
					$scope.model.id=0;
				}else
			    {
					window.location= url+"products/entry.html?id="+$scope.id;
			    }
				
			};
		});