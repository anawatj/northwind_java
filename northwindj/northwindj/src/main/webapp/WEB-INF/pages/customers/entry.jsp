<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12" ng-controller="customersEntryCtrl" ng-init="init()">
				<fieldset>
						<legend>Customers Entry</legend>
						<form>
								<div class="row">
										<div class="col-xs-3">
											<label>CustomerCode</label>
										</div>
										<div class="col-xs-3">
											<input type="text" class="form-control" ng-model="model.customerCode"/>
										</div>
										<div class="col-xs-3">
											<label>CompanyName</label>
										</div>
										<div class="col-xs-3">
											<input type="text" class="form-control" ng-model="model.companyName"/>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-3">
											<label>ContactName</label>
										</div>
										<div class="col-xs-3">
												<input type="text" class="form-control" ng-model="model.contactName"/>
										</div>
										<div class="col-xs-3">
											<label>ContactTitle</label>
										</div>
										<div class="col-xs-3">
												<input type="text" class="form-control" ng-model="model.contactTitle"/>
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
														<option ng-repeat="item in countries" value="{{item.id}}" ng-selected="item.id==model.country.id">{{item.name}}</option>
												</select>
										</div>
										<div class="col-xs-3">
												<label>City</label>
										</div>
										<div class="col-xs-3">
												<select class="form-control" ng-model="model.city.id">
														<option value="0"></option>
														<option ng-repeat="item in cities" value="{{item.id}}" ng-selected="item.id==model.city.id">{{item.name}}</option>
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
														<option ng-repeat="item in regions" value="{{item.id}}" ng-selected="item.id==model.region.id">{{item.name}}</option>
												</select>
										</div>
										<div class="col-xs-3">
												<label>PostalCode</label>
										</div>
										<div class="col-xs-3">
												<input type="text" class="form-control" ng-model="model.postalCode"/>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-3">
											<label>Phone</label>
										</div>
										<div class="col-xs-3">
												<input type="tel" class="form-control" ng-model="model.phone"/>
										</div>
										<div class="col-xs-3">
											<label>Fax</label>
										</div>
										<div class="col-xs-3">
												<input type="tel" class="form-control" ng-model="model.fax"/>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-3">
												Demographic
										</div>
										<div class="col-xs-9">
												<label ng-repeat="item in demographics">
									
  													<input type="checkbox" data-checklist-model="model.demos" data-checklist-value="item"> {{item.name}}
  									
											</label>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-12">
												<button class="btn btn-primary" ng-click="save()">Save</button>
												<button class="btn btn-primary" ng-click="clear()">Clear</button>
										</div>
								</div>
						</form>
				</fieldset>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
