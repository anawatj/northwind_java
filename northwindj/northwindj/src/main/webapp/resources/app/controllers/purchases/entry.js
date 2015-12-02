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
						}
						deferred.resolve(data);
						
					});
					return promise;
					
				};
				$scope.addDetail=function()
				{
					var detail = {};
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
					
				};
				$scope.findEmployee=function()
				{
					
				};
				$scope.findProduct=function(index)
				{
					
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