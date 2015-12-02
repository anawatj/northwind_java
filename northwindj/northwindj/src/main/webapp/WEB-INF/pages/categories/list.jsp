<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12" ng-controller="categoriesListCtrl" ng-init="init()">
			<fieldset>
				<legend>Categories List</legend>
				<form>
					<div class="row">
						<div class="col-xs-3">
							<label>CategoryName</label>
						</div>
						<div class="col-xs-6">
							<input type="text" class="form-control" ng-model="model.categoryName" />
						</div>
					</div>
					<!--  <div class="row">
						<div class="col-xs-3">
							<label>Description</label>
						</div>
						<div class="col-xs-6">
							<textarea class="form-control"></textarea>
						</div>
					</div>-->
					<div class="row">
						<div class="col-xs-9">
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
								<th>ID</th>
								<th>Name</th>
								<th>Description</th>
							</tr>
						</thead>
						<tbody>
								<tr ng-repeat="item in results">
										<td>
												<button class="btn btn-primary" ng-click="edit(item)"><i class="glyphicon glyphicon-pencil"></i></button>
										</td>
										<td>
												<button class="btn btn-primary" ng-click="remove(item)"><i class="glyphicon glyphicon-trash"></i></button>
										</td>
										<td>
											{{item.id}}
										</td>
										<td>
											{{item.categoryName}}
										</td>
										<td>
											{{item.description}}
										</td>
										
								</tr>
						</tbody>

					</table>
												<pagination ng-model="model.page" ng-change="search()" total-items="totalItems" num-pages="numPages"
						items-per-page="pageSize" max-size="maxSize" class="pagination-xs" boundary-links="true" rotate="false"></pagination>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
