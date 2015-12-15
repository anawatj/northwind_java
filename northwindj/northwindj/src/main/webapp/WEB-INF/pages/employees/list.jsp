<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12" ng-controller="employeesListCtrl" ng-init="init()">
			<form>
				<div class="row">
					<div class="col-xs-3">
							<label>EmployeeCode</label>
					</div>
					<div class="col-xs-9">
							<input type="text" class="form-control" ng-model="model.employeeCode"/>
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
						<label>Department</label>
					</div>
					<div class="col-xs-3">
						<select class="form-control" ng-model="model.department">
							<option value="0"></option>
							<option ng-repeat="item in departments" value="{{item.id}}">{{item.name}}</option>
						</select>
					</div>
					<div class="col-xs-3">
						<label>DepartmentName</label>
					</div>
					<div class="col-xs-3">
							<input type="text" class="form-control" list="departmentList" ng-model="item.departmentName"/>
							<datalist id="departmentList">
								<option ng-repeat="item in departments" value="{{item.name}}">
								</option>
							</datalist>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<button class="btn btn-primary" ng-click="search()">Search</button>
						<button class="btn btn-primary" ng-click="clear()">Clear</button>
					</div>
				</div>
			</form>
			<div class="row">
				<div class="col-xs-12">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<thead class="primary">
							<tr>
								<th></th>
								<th></th>
								<th>Name</th>
								<th>Department</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="item in results">
								<td>
									<button class="btn btn-primary" ng-click="edit(item)">
										<i class="glyphicon glyphicon-pencil"></i>
									</button>
								</td>
								<td>
									<button class="btn btn-primary" ng-click="remove(item)">
										<i class="glyphicon glyphicon-trash"></i>
									</button>
								</td>
								<td>
										{{item.title.name}} {{item.firstName}} {{item.lastName}}
								</td>
								<td>
										{{item.department.name}}
								</td>
							</tr>
						</tbody>
					</table>
						<pagination ng-model="model.page" ng-change="search()" total-items="totalItems" num-pages="numPages"
						items-per-page="pageSize" max-size="maxSize" class="pagination-xs" boundary-links="true" rotate="false"></pagination>

				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>