/**
 * 
 */
app.controller('purchasesEntryCtrl',function($scope,masterService,purchasesService,shippersService,$q,$pageUtils,$CommonUtils,$modal)
		{
				$scope.model={};
				$scope.shippers=[];
				$scope.init=function()
				{
					$scope.urlParameter = $pageUtils.getUrlVars();
					$scope.id = $scope.urlParameter.id;
					if($scope.id==null || $scope.id==undefined)
					{
						$scope.id=0;
					}
					var promise  = $scope.load();
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
								 	shippersService.getAll(),
								 	purchasesService.getById($scope.id)
								 ]
					).then(function(data)
					{
						$scope.shippers=data[0].data.list;
						if(data[1].data!=null && data[1].data!=undefined &&data[1].data!="")
						{
							$scope.model=data[1].data;
							$scope.model.shipper = $CommonUtils.convertNullToObject($scope.model.shipper);
							$scope.model.purchaseDate = new Date($scope.model.purchaseDate);
							$scope.model.requireDate = new Date($scope.model.requireDate);
							$scope.model.shippedDate= new Date($scope.model.shippedDate);
							$scope.model.details = $CommonUtils.convertNullToArray($scope.model.details);
							for(var index=0;index<$scope.model.details.length;index++)
							{
								var detail = $scope.model.details[index];
								detail.product = $CommonUtils.convertNullToObject(detail.product);
							}
						}else
						{
							$scope.model={};
							$scope.model.id=0;
							$scope.model.details=[];
						}
						deferred.resolve(data);
						
					});
					return promise;
					
				};
				$scope.addDetail=function()
				{
					var detail = {};
					if($scope.id!=0)
					{
						detail.purchaseId=$scope.id;
					}
					detail.selected=false;
					detail.id=0;
					$scope.model.details.push(detail);
				};
				$scope.delDetail=function()
				{
					for(var index=0;index<$scope.model.details.length;index++)
					{
						var detail = $scope.model.details[index];
						if(detail.selected)
						{
							$scope.model.details.splice(index,1);
							index--;
						}
					}
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
				$scope.findEmployee=function()
				{
					var modalInstance = $modal.open({
						templateUrl : url
								+ 'employees/searchModal.html',
						controller : 'employeeSearchModalCtrl',
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
											$scope.model.employee={};
											$scope.model.employee.id = selectedItem.id;
											$scope.model.employee.firstName = selectedItem.firstName;
											$scope.model.employee.lastName = selectedItem.lastName;
										}
									});
				};
				$scope.findProduct=function(item)
				{
					var modalInstance = $modal.open({
						templateUrl : url
								+ 'products/searchModal.html',
						controller : 'productsSearchModalCtrl',
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
											item.product={};
											item.product.id = selectedItem.id;
											item.product.productName = selectedItem.productName;
										}
									});
				};
				$scope.save=function()
				{
					purchasesService.save($scope.model)
					.success(function(data)
					 {
						window.location= url+"purchases/entry.html?id="+data.id;
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
						window.location= url+"purchases/entry.html?id="+$scope.id;
					}
				};
				
		});