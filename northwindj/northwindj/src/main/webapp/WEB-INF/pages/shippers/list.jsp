<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12" ng-controller="shippersListCtrl"
			ng-init="init()">
			<fieldset>
				<legend>Shippers List</legend>
				<form>

					<div class="row">
						<div class="col-xs-3">
							<label>CompanyName</label>
						</div>
						<div class="col-xs-9">
							<input type="text" class="form-control"
								ng-model="model.companyName" />
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
									<th>CompanyName</th>
									<th>Phone</th>
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
											{{item.companyName}}
									</td>
									<td>	
											{{item.phone}}
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