<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12" ng-controller="suppliersListCtrl" ng-init="init()">
			<fieldset>
				<legend>Customers List</legend>
				<form>
					<div class="row">

						<div class="col-xs-3">
							<label>CompanyName</label>
						</div>
						<div class="col-xs-3">
							<input type="text" class="form-control"
								ng-model="model.companyName" />
						</div>
						<div class="col-xs-3">
							<label>ContactName</label>
						</div>
						<div class="col-xs-3">
							<input type="text" class="form-control"
								ng-model="model.contactName" />
						</div>
					</div>
					<div class="row">

						<div class="col-xs-3">
							<label>ContactTitle</label>
						</div>
						<div class="col-xs-3">
							<input type="text" class="form-control"
								ng-model="model.contactTitle" />
						</div>
						<div class="col-xs-3">
							<label>Region</label>
						</div>
						<div class="col-xs-3">
							<select class="form-control" ng-model="model.region">
								<option value="0"></option>
								<option ng-repeat="item in regions" value="{{item.id}}">{{item.name}}</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">
							<label>Country</label>
						</div>
						<div class="col-xs-3">
							<select class="form-control" ng-model="model.country"
								ng-change="countryChange()">
								<option value="0"></option>
								<option ng-repeat="item in countries" value="{{item.id}}">{{item.name}}</option>
							</select>
						</div>
						<div class="col-xs-3">
							<label>City</label>
						</div>
						<div class="col-xs-3">
							<select class="form-control" ng-model="model.city">
								<option value="0"></option>
								<option ng-repeat="item in cities" value="{{item.id}}">{{item.name}}</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<button class="btn btn-primary" ng-click="search()">Search</button>
							<button class="btn btn-primary" ng-click="clear()">Clear</button>
						</div>

					</div>
				</form>
			</fieldset>
			<div class="row">
				<div class="col-xs-12">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<thead class="primary">
							<tr>
								<th></th>
								<th></th>
								<th>CompanyName</th>
								<th>ContactName</th>
								<th>ContactTitle</th>
								<th>City</th>
								<th>Region</th>
								<th>Country</th>
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
								<td>{{item.companyName}}</td>
								<td>{{item.contactName}}</td>
								<td>{{item.contactTitle}}</td>
								<td>{{item.city.name}}</td>
								<td>{{item.region.name}}</td>
								<td>{{item.country.name}}</td>
							</tr>
						</tbody>
					</table>
						<pagination ng-model="model.page" ng-change="search()"
							total-items="totalItems" num-pages="numPages"
							items-per-page="pageSize" max-size="maxSize"
							class="pagination-xs" boundary-links="true" rotate="false"></pagination>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
