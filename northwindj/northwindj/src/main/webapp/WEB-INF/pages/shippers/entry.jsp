<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="col-xs-12" ng-controller="shippersEntryCtrl" ng-init="init()">
					<fieldset>
							<legend>Shippers Entry</legend>
							<form>
									<div class="row">
											<div class="col-xs-3">
													<label>CompanyName</label>
											</div>
											<div class="col-xs-9">
													<input type="text" class="form-control" ng-model="model.companyName"/>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>Phone</label>
											</div>
											<div class="col-xs-9">
													<input type="tel" class="form-control" ng-model="model.phone"/>
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