<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="col-xs-12">
					<fieldset>
							<legend>Orders Entry</legend>
							<form>
									<div class="row">
											<div class="col-xs-3">
													<label>Employee</label>
											</div>
											<div class="col-xs-9">
													<div class="input-group">
															<input type="text" class="form-control" ng-model="model.employee.id"/>
															<div class="input-group-btn">
																	<button class="btn btn-primary" ng-click="findEmployee()">
																		<i class="glyphicon glyphicon-search"></i>
																	</button>
															</div>
													</div>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>Customer</label>
											</div>
											<div class="col-xs-9">
													<div class="input-group">
															<input type="text" class="form-control" ng-model="model.customer.id"/>
															<div class="input-group-btn">
																	<button class="btn btn-primary" ng-click="findCustomer()">
																		<i class="glyphicon glyphicon-search"></i>
																	</button>
															</div>
													</div>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>OrderDate</label>
											</div>
											<div class="col-xs-3">
													<input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.orderDate"/>
											</div>
											<div class="col-xs-3">
													<label>Require Date</label>
											</div>
											<div class="col-xs-3">
													<input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.requireDate"/>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>ShipperDate</label>
											</div>
											<div class="col-xs-3">
													<input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.shipperDate"/>
											</div>
											<div class="col-xs-3">
													<label>ShipVia</label>
											</div>
											<div class="col-xs-3">
													<select class="form-control" ng-model="model.shipVia.id">
														<option value="0"></option>
														<option ng-repeat="item in shippers" ng-selected="item.id==model.shipVia.id" value="{{item.id}}">{{item.companyName}}</option>
													</select>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>Freight</label>
											</div>
											<div class="col-xs-3">
													<input kendo-numeric-text-box k-ng-model="model.freight"/>
											</div>
											<div calss="col-xs-3">
													<label>ShipName</label>
											</div>
											<div class="col-xs-3">
													<input type="text" class="form-control" ng-model="model.shipName"/>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>ShipAddress</label>
											</div>
											<div class="col-xs-9">
													<textarea class="form-control" ng-model="model.shipAddress"></textarea>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>ShipCountry</label>
											</div>
											<div class="col-xs-3">
													<select class="form-control" ng-model="model.shipCountry.id" ng-change="countryChange()">
															<option value="0"></option>
															<option ng-repeat="item in countries" ng-selected="item.id==model.shipCountry.id" value="{{item.id}}">{{item.name}}</option>
													</select>
											</div>
											<div class="col-xs-3">
													<label>ShipCity</label>
											</div>
											<div class="col-xs-3">
													<select class="form-control" ng-model="model.shipCity.id">
															<option value="0"></option>
															<option ng-repeat="item in cities" ng-selected="item.id==model.shipCity.id" value="{{item.id}}">{{item.name}}</option>
													</select>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>ShipRegion</label>
											</div>
											<div class="col-xs-3">
													<select class="form-control" ng-model="model.shipRegion.id">
															<option value="0"></option>
															<option ng-repeat="item in regions" ng-selected="item.id==model.shipRegion.id" value="{{item.id}}" >{{item.name}}</option>
													</select>
											</div>
											<div class="col-xs-3">
													<label>PostalCode</label>
											</div>
											<div class="col-xs-3">
													<input type="text" class="form-control" ng-model="item.postalCode"/>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-12">
														<table
															class="table table-striped table-bordered table-hover table-condensed">
															<thead class="primary">
																<tr>
																	<th></th>
																	<th>Product</th>
																	<th>UnitPrice</th>
																	<th>Quantity</th>
																	<th>Discount</th>
																</tr>
															</thead>
															<tbody>
																	<tr ng-repeat="item in model.details">
																		<td><input type="checkbox" ng-model="item.selected"/></td>
																		<td>
																			<div class="input-group">
																					<input type="text" class="form-control" ng-model="item.product.id"/>
																					<div class="input-group-btn">
																								<button class="btn btn-primary" ng-click="findProduct(item)">
																								<i class="glyphicon glyphicon-search"></i>
																								</button>
																					</div>
																			 </div>
																		</td>
																		<td>
																				<input kendo-numeric-text-box k-ng-model="item.unitPrice"/>
																		</td>
																			<td>
																				<input kendo-numeric-text-box k-ng-model="item.quantity"/>
																		</td>
																			<td>
																				<input kendo-numeric-text-box k-ng-model="item.discount"/>
																		</td>
																	</tr>
															</tbody>
															<tfoot>
																	<tr>
																		<td colspan="5">
																				<button class="btn btn-primary" ng-click="addDetail()">Add</button>
																				<button class="btn btn-primary" ng-click="delDetail()">Del</button>
																		</td>
																	</tr>
															</tfoot>
														</table>
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