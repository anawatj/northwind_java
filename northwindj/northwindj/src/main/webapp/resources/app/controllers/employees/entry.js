/**
 * 
 */
app.controller('employeesEntryCtrl',function($scope,
		employeesService,
		masterService,
		territoriesService,
		$pageUtils,
		$CommonUtils,
		$q)
{
	
	$scope.model={};
	$scope.countries=[];
	$scope.regions=[];
	$scope.cities=[];
	$scope.departments=[];
	$scope.titles=[];
	$scope.educationLevels=[];
	$scope.territories=[];
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
				  	masterService.getAllCountry(),
				  	masterService.getAllRegions(),
				  	masterService.getAllTitle(),
				  	masterService.getAllDepartment(),
				  	masterService.getAllEducationLevel(),
				    territoriesService.getAll(),
				    employeesService.getById($scope.id)
				 ]
	     ).then(function(data)
	    {
	    	 $scope.countries= data[0].data.list;
	    	 $scope.regions=data[1].data.list;
	    	 $scope.titles = data[2].data.list;
	    	 $scope.departments =data[3].data.list;
	    	 $scope.educationLevels = data[4].data.list;
	    	 $scope.territories = data[5].data.list;
	    	 if(data[6].data!=null && data[6].data!=undefined && data[6].data!="")
	    	 {
	    		 $scope.model = data[6].data;
	    		 $scope.model.title = $CommonUtils.convertNullToObject($scope.model.title);
	    		 $scope.model.city= $CommonUtils.convertNullToObject($scope.model.city);
	    		 $scope.model.region= $CommonUtils.convertNullToObject($scope.model.region);
	    		 $scope.model.country = $CommonUtils.convertNullToObject($scope.model.country);
	    		 $scope.model.reportTo = $CommonUtils.convertNullToObject($scope.model.reportTo);
	    		 $scope.model.department = $CommonUtils.convertNullToObject($scope.model.department);
	    		 $scope.model.territories = $CommonUtils.convertNullToArray($scope.model.territories);
	    		 $scope.model.educations = $CommonUtils.convertNullToArray($scope.model.educations);
	    		 $scope.model.experiences = $CommonUtils.convertNullToArray($scope.model.experiences);
	    		 $scope.model.hireDate = new Date($scope.model.hireDate);
	    		 $scope.model.birthDate = new Date($scope.model.birthDate);
	    		 
	    		 for(var index=0;index<$scope.model.educations.length;index++)
	    		 {
	    			 var education = $scope.model.educations[index];
	    			 education.educationLevel = $CommonUtils.convertNullToObject(education.educationLevel);
	    		 }
	    		 for(var index=0;index<$scope.model.experiences.length;index++)
	    		{
	    			 var experience = $scope.model.experiences[index];
	    			 experience.start = new Date(experience.start);
	    			 experience.end = new Date(experience.end);
	    		}
	    	 }else
	    	 {
	    		 $scope.model={};
	    		 $scope.model.id=0;
	    		 $scope.model.educations=[];
	    		 $scope.model.territories=[];
	    		 $scope.model.experiences=[];
	    	 }
	    	 deferred.resolve(data);
	    	 
	    });
		return promise;
	};
	$scope.addEducation=function()
	{
		var education = {};
		education.selected=false;
		education.id=0;
		$scope.model.educations.push(education);
	};
	$scope.delEducation=function()
	{
	    for(var index=0;index<$scope.model.educations.length;index++)
	    {
	    	var education = $scope.model.educations[index];
	    	if(education.selected==true)
	    	{
	    		$scope.model.educations.splice(index,1);
	    		index--;
	    	}
	    }
	}
	$scope.addExperience=function()
	{
		var experience = {};
		experience.selected=false;
		experience.id=0;
		$scope.model.experiences.push(experience);
	};
	$scope.delExperience=function()
	{
		for(var index=0;index<$scope.model.experiences.length;index++)
		{
			var experience = $scope.model.experiences[index];
			if(experience.selected==true)
			{
				$scope.model.experiences.splice(index,1);
			}
		}
	};
	$scope.countryChange=function()
	{
		masterService.getAllCity($scope.model.country.id)
		.success(function(data)
				{
					$scope.cities=data.list;
				})	;
		
	};
	$scope.save=function()
	{
		employeesService.save($scope.model)
		.success(function(data)
				{
					window.location= url+"employees/entry.html?id="+data.id;
				})	;
	};
	$scope.clear=function()
	{
		if($scope.id==0)
		{
			$scope.model={};
			$scope.model.id=0;
		}else
		{
			window.location= url+"employees/entry.html?id="+$scope.id;
		}
	};
});
