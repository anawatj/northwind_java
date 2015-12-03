<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">	
		<div class="col-xs-12" ng-controller="purchasesListCtrl" ng-init="init()">
			<fieldset>
				<legend>Orders List</legend>
				<form>
					<div class="row">
						<div class="col-xs-3">
							<label>Supplier</label>
						</div>
						<div class="col-xs-9">
							<div class="input-group">
								<input type="text" class="form-control"
									ng-model="model.supplier" />
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
									ng-model="model.employee" />
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
							<label>Order Date</label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'"
								k-ng-model="model.purchaseDateStart" />
						</div>
						<div class="col-xs-3">
							<label>To</label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'"
								k-ng-model="model.purchaseDateEnd" />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">
							<label>Require Date</label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'"
								k-ng-model="model.requireDateStart" />
						</div>
						<div class="col-xs-3">
							<label>To</label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'"
								k-ng-model="model.requireDateEnd" />
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
									<th>Supplier</th>
									<th>Employee</th>
									<th>PurchaseDate</th>
									<th>RequireDate</th>
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
											{{item.supplier.companyName}}
									</td>
									<td>
											{{item.employee.title.name}} {{item.employee.firstName}} {{item.employee.lastName}}
									</td>
									<td>
											{{item.purchaseDate | date:'dd/MM/yyyy'}}
									</td>
									<td>
											{{item.requireDate | date:'dd/MM/yyyy'}}
									</td>
								
								</tr>
							</tbody>
						</table>
						<pagination ng-model="model.page" ng-change="search()"
							total-items="totalItems" num-pages="numPages"
							items-per-page="pageSize" max-size="maxSize"
							class="pagination-xs" boundary-links="true" rotate="false"></pagination>
					</div>
				</div>
			</fieldset>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>