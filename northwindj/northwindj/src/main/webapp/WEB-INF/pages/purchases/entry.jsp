<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12" ng-controller="purchasesEntryCtrl" ng-init="init()">
			<fieldset>
				<legend>Purchases Entry</legend>
				<form>
					<div class="row">
						<div class="col-xs-3">
							<label>Suppliers</label>
						</div>
						<div class="col-xs-9">
							<div class="input-group">
								<input type="text" class="form-control"
									ng-model="model.supplier.id" />
								<div class="input-group-btn">
									<button class="btn btn-primary" ng-click="findSupplier()">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">
							<label>Employee</label>
						</div>
						<div class="col-xs-9">
							<div class="input-group">
								<input type="text" class="form-control"
									ng-model="model.employee.id" />
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
							<label> Purchase Date </label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.purchaseDate" />
						</div>
						<div class="col-xs-3">
							<label> Require Date </label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.requireDate" />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">
							<label> Shipped Date </label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.shippedDate"/>
						</div>
						<div class="col-xs-3">
							<label> Shipper </label>
						</div>
						<div class="col-xs-3">
							<select class="form-control" ng-model="model.shipper.id">
								<option value="0"></option>
								<option ng-repeat="item in shippers" ng-selected="item.id==model.shipper.id" value="{{item.id}}">{{item.companyName}}</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">
							<label>Freight</label>
						</div>
						<div class="col-xs-9">
							<input kendo-numeric-text-box k-ng-model="item.freight" />
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
										<td><input type="checkbox" ng-model="item.selected" /></td>
										<td>
											<div class="input-group">
												<input type="text" class="form-control" ng-model="item.product.id" />
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
									<button class="btn btn-primary">Save</button>
									<button class="btn btn-primary">Clear</button>
							</div>
					</div>

				</form>
			</fieldset>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>