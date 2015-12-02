<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12" ng-controller="productsListCtrl"
			ng-init="init()">
			<form>
				<div class="row">
					<div class="col-xs-3">
						<label>ProductName</label>
					</div>
					<div class="col-xs-9">
						<input type="text" class="form-control"
							ng-model="model.productName" />
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Categories</label>
					</div>
					<div class="col-xs-9">
						<select class="form-control" ng-model="model.category">
							<option value="0"></option>
							<option ng-repeat="item in categories" value="{{item.id}}">
								{{item.categoryName}}</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Suppliers</label>
					</div>
					<div class="col-xs-9">
						<div class="input-group">
							<input type="text" class="form-control" ng-model="model.supplier" />
							<div class="input-group-btn">
								<button class="btn btn-primary" ng-click="findSupplier()">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
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
								<th>Categories</th>
								<th>Suppliers</th>
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
								<td>{{item.productName}}</td>
								<td>{{item.category.categoryName}}</td>
								<td>{{item.supplier.companyName}}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>