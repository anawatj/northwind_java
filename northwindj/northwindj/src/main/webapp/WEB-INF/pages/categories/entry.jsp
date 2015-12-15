<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12" ng-controller="categoriesEntryCtrl" ng-init="init()">
				<fieldset>
						<legend>Categories Save</legend>
						<form>
								<div class="row">
										<div class="col-xs-3">
											<label>CategoryCode</label>
										</div>
										<div class="col-xs-6">
												<input type="text" class="form-control" ng-model="model.categoryCode" disabled/>
										</div>
								</div>
								<div class="row">
									<div class="col-xs-3">
											<label>CategoryName</label>
									</div>
									<div class="col-xs-6">
											<input type="text" class="form-control" ng-model="model.categoryName"/>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-3">
												<label>Description</label>
									</div>
									<div class="col-xs-6">
											<textarea class="form-control" ng-model="model.description"></textarea>
									</div>
								</div>
								<div class="row">
										<div class="col-xs-9">
												<button class="btn btn-primary" ng-click="save()">Save</button>
												<button class="btn btn-primary" ng-click="clear()">Clear</button>
										</div>
								</div>
						</form>
				</fieldset>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
