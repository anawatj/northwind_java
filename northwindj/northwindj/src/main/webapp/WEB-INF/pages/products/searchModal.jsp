<progressbar class="progress-striped active" value="dynamic" ng-show="loading"> </progressbar>
<div class="modal-header">
	<h3 class="modal-title">Find Product</h3>
</div>
<div class="modal-body col-xs-12 form-horizontal form-group-sm table-bordered" ng-init="init()">
		<div class="col-xs-12">
				<form>
						<div class="row">
								<div class="col-xs-3">
										<label>ProductName</label>
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
										<select class="form-control" ng-model="model.category">
												<option value="0"></option>
												<option ng-repeat="item in categories" value="{{item.id}}">{{item.categoryName}}</option>
										</select>
								</div>
						</div>
						<div class="row">
								<div class="col-xs-3">
										<label>Suppliers</label>
								</div>
								<div class="col-xs-9">
										<div class="input-group">
												<input type="text" class="form-control" ng-model="model.supplier"/>
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
										<button class="btn btn-primary" ng-click="close()">Close</button>
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
												<th>Name</th>
												<th>Categories</th>
												<th>Suppliers</th>
										</tr>
									</thead>
									<tbody>
											<tr ng-repeat="item in results">
													<td><button class="btn btn-primary" ng-click="select(item)">Select</button></td>
													<td>{{item.productName}}</td>
													<td>{{item.category.categoryName}}</td>
													<td>{{item.supplier.companyName}}</td>
											</tr>
									</tbody>
								</table>
									<pagination ng-model="model.page" ng-change="search()" total-items="totalItems" num-pages="numPages"
						items-per-page="pageSize" max-size="maxSize" class="pagination-xs" boundary-links="true" rotate="false"></pagination>
						</div>
				</div>
		</div>
</div>
<div class="modal-footer"></div>