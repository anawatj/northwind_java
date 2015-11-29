<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="col-xs-12" ng-controller="productsEntryCtrl" ng-init="init()">
 				<form>
						<div class="row">
							<div class="col-xs-3">
								<label>Name</label>
							</div>
							<div class="col-xs-9">
								<input type="text" class="form-control" ng-model="model.productName"/>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3">
								<label>Categories</label>
							</div>
							<div class="col-xs-9">
								<select class="form-control" ng-model="model.category.id">
										<option value="0"></option>
										<option ng-repeat="item in categories" ng-selected="item.id==model.category.id" value="{{item.id}}">{{item.categoryName}}</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3">
								<label>Suppliers</label>
							</div>
							<div class="col-xs-9">
								<div class="input-group">
									<input type="text" class="form-control" ng-model="model.supplier.id"/>
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
									
									<label>Quantity Per Unit</label>
							</div>
							<div class="col-xs-9">
									<input type="text" class="form-control" ng-model="model.quantityPerUnit"/>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3">
									<label>UnitPrice</label>
							</div>
							<div class="col-xs-9">
									<input kendo-numeric-text-box style="width:100%" k-ng-model="model.unitPrice"/>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3">
									<label>Recorder Level</label>
							</div>
							<div class="col-xs-9">
									<input kendo-numeric-text-box style="width:100%" k-ng-model="model.recorderLevel"/>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3">
									<label>Discontinued</label>
							</div>
							<div class="col-xs-9">
									<input type="checkbox" ng-model="model.discontinued" />
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