<progressbar class="progress-striped active" value="dynamic" ng-show="loading"> </progressbar>
<div class="modal-header">
	<h3 class="modal-title">Find Employee</h3>
</div>
<div class="modal-body col-xs-12 form-horizontal form-group-sm table-bordered" ng-init="init()">
		<div class="col-xs-12">	
			<form>
					<div class="row">
						<div class="col-xs-3">
							<label>FirstName</label>
						</div>
						<div class="col-xs-9">
							<input type="text" class="form-control" ng-model="model.firstName"/>
						</div>
					</div>
					<div class="row">
							<div class="col-xs-3">
								<label>LastName</label>
							</div>
							<div class="col-xs-9">
								<input type="text" class="form-control" ng-model="model.lastName"/>
							</div>
					</div>
					<div class="row">
						<div class="col-xs-3">
								<label>Department</label>
						</div>
						<div class="col-xs-9">
								<select class="form-control" ng-model="model.department">
										<option value="0"></option>
										<option ng-repeat="item in departments" value="{{item.id}}">{{item.name}}</option>
								</select>
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
												<th>Department</th>
										</tr>
									</thead>
									<tbody>
											<tr ng-repeat="item in results">
													<td>
															<button class="btn btn-primary" ng-click="select(item)">Select</button>
													</td>
													<td>
															{{item.firstName}} {{item.lastName}}
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
</div>
<div class="modal-footer"></div>