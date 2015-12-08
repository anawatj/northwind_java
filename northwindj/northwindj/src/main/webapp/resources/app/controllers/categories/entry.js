/**
 * 
 */
app.controller('categoriesEntryCtrl',function($scope,categoriesService,$pageUtils,$CommonUtils)
		{
			$scope.model={};
			$scope.init=function()
			{
				$scope.urlParameter = $pageUtils.getUrlVars();
				$scope.id = $scope.urlParameter.id;
				if($scope.id==null || $scope.id==undefined)
				{
					$scope.id=0;
				}
				$('#pleaseWaitDialog').modal('show');
				$scope.load();
			};
			$scope.load=function()
			{
				categoriesService.getById($scope.id)
				.success(function(data)
						{
							if(data!=null && data!=undefined && data!="")
							{
								$scope.model= data;
							}else
							{
									$scope.model={};
									$scope.model.id=0;
							}
							$('#pleaseWaitDialog').modal('hide');
						});
			};
			$scope.save=function()
			{
				categoriesService.save($scope.model)
				.success(function(data)
				{
					window.location=url+"categories/entry.html?id="+data.id;
				})
			};
			$scope.clear=function()
			{
				
				if($scope.id==0)
				{
					$scope.model = {};
					$scope.model.id=0;
				}else
				{
					window.location=url+"categories/entry.html?id="+$scope.id;
				}
			};
			
		});