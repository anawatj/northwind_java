<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12" ng-controller="employeesEntryCtrl" ng-init="init()">
			<form>
				<div class="row">
					<div class="col-xs-3">
						<label>EmployeeCode</label>
					</div>
					<div class="col-xs-3">
						<input type="text" class="form-control" ng-model="model.employeeCode" disabled/>
					</div>
					<div class="col-xs-3">
						<label>Title</label>
					</div>
					<div class="col-xs-3">
						<select class="form-control" ng-model="model.title.id">
								<option value="0"></option>
								<option ng-repeat="item in titles" value="{{item.id}}" ng-selected="item.id==model.title.id">{{item.name}}</option>
						</select>
					</div>
				</div>
				<div class="row">
					
					<div class="col-xs-3">
						<label>TitleOfCourtesy</label>
					</div>
					<div class="col-xs-3">
						<input type="text" class="form-control" ng-model="model.titleOfCourstesy"/>
					</div>
				
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>FirstName</label>
					</div>
					<div class="col-xs-3">
						<input type="text" class="form-control" ng-model="model.firstName" />
					</div>
					<div class="col-xs-3">
						<label>LastName</label>
					</div>
					<div class="col-xs-3">
						<input type="text" class="form-control" ng-model="model.lastName" />
					</div>
				
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>BirthDate</label>
					</div>
					<div class="col-xs-3">
						<input kendo-date-picker k-ng-model="model.birthDate" style="width:100%" k-format="'dd/MM/yyyy'" />
					</div>
					<div class="col-xs-3">
						<label>HireDate</label>
					</div>
					<div class="col-xs-3">
						<input kendo-date-picker k-ng-model="model.hireDate" style="width:100%" k-format="'dd/MM/yyyy'"/>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Address</label>
					</div>
					<div class="col-xs-9">
						<textarea class="form-control" ng-model="model.address"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Country</label>
					</div>
					<div class="col-xs-3">
						<select class="form-control" ng-model="model.country.id" ng-change="countryChange()">
								<option value="0"></option>
								<option ng-repeat="item in countries" ng-selected="item.id==model.country.id" value="{{item.id}}">
								{{item.name}}
								</option>
						</select>
					</div>
					<div class="col-xs-3">
						<label>City</label>
					</div>
					<div class="col-xs-3">
						<select class="form-control" ng-model="model.city.id">
								<option value="0"></option>
								<option ng-repeat="item in cities" ng-selected="item.id==model.city.id" value="{{item.id}}">{{item.name}}</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Region</label>
					</div>
					<div class="col-xs-3">
						<select class="form-control" ng-model="model.region.id">
								<option value="0"></option>
								<option ng-repeat="item in regions" ng-selected="item.id==model.region.id" value="{{item.id}}">{{item.name}}</option>
						</select>
					</div>
					<div class="col-xs-3">
						<label>PostalCode</label>
					</div>
					<div class="col-xs-3">
						<input type="text" class="form-control" ng-model="model.postalCode" />
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Phone</label>
					</div>
					<div class="col-xs-3">
						<input type="tel" class="form-control"  ng-model="model.homePhone"/>
					</div>
					<div class="col-xs-3">
						<label>Extension</label>
					</div>
					<div class="col-xs-3">
						<input type="text" class="form-control" ng-model="model.extention" />
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Notes</label>
					</div>
					<div class="col-xs-9">
						<textarea class="form-control" ng-model="model.notes"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Department</label>
					</div>
					<div class="col-xs-3">
						<select class="form-control" ng-model="model.department.id">
							<option value="0"></option>
							<option ng-repeat="item in departments" ng-selected="item.id==model.department.id" value="{{item.id}}">{{item.name}}</option>
						</select>
					</div>
					<div class="col-xs-3">
						<label>ReportTo</label>
					</div>
					<div class="col-xs-3">
						<div class="input-group">
							<div class="input-group-btn">
								<input type="text" class="form-control" ng-model="model.reportTo.id" />
								<button class="btn btn-primary" ng-click="findReportTo()">
									<i class="glyphicon glyphicon-search"></i>
								</button>
								<label></label>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Territories</label>
					</div>
					<div class="col-xs-9">
								<div class="checkbox" ng-repeat="item in territories">
															<input type="checkbox" data-checklist-model="model.territories" data-checklist-value="item"> <label >{{item.name}}</label>
								</div>
  													
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#education">Education</a></li>
							<li><a data-toggle="tab" href="#experiences">Experience</a></li>

						</ul>

						<div class="tab-content">
							<div id="education" class="tab-pane fade in active">
								<jsp:include page="${context }/employees/tabEducation.html"></jsp:include>
							</div>
							<div id="experiences" class="tab-pane fade">
								<jsp:include page="${context }/employees/tabExperiences.html"></jsp:include>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<button class="btn btn-primary" ng-click="save()">Save</button>
						<button class="btn btn-primary" ng-click="clear()">Clear</button>
					</div>
				</div>
			</form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>