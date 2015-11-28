<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="col-xs-12" ng-controller="territoriesEntryCtrl" ng-init="init()">
				<fieldset>
						<legend>Territories Save</legend>
						<form>
							<div class="row">
								<div class="col-xs-3">
										<label>Name</label>
								</div>
								<div class="col-xs-9">
										<input type="text" class="form-control" ng-model="model.name"/>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-3">
										<label>Region</label>
								</div>
								<div class="col-xs-9">
										<select class="form-control" ng-model="model.region.id">
											<option value="0"></option>
											<option ng-repeat="item in regions" value="{{item.id}}" ng-selected="item.id==model.region.id">{{item.name}}</option>
										</select>
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