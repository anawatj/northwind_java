<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12">
				<fieldset>
						<legend>Customers Entry</legend>
						<form>
								<div class="row">
										<div class="col-xs-3">
											<label>CustomerCode</label>
										</div>
										<div class="col-xs-3">
											<input type="text" class="form-control"/>
										</div>
										<div class="col-xs-3">
											<label>CompanyName</label>
										</div>
										<div class="col-xs-3">
											<input type="text" class="form-control"/>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-3">
											<label>ContactName</label>
										</div>
										<div class="col-xs-3">
												<input type="text" class="form-control"/>
										</div>
										<div class="col-xs-3">
											<label>ContactTitle</label>
										</div>
										<div class="col-xs-3">
												<input type="text" class="form-control"/>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-3">
												<label>Address</label>
										</div>
										<div class="col-xs-9">
												<textarea class="form-control"></textarea>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-3">
												<label>Country</label>
										</div>
										<div class="col-xs-3">
												<select class="form-control"></select>
										</div>
										<div class="col-xs-3">
												<label>City</label>
										</div>
										<div class="col-xs-3">
												<select class="form-control"></select>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-3">
												<label>Region</label>
										</div>
										<div class="col-xs-3">
												<select class="form-control"></select>
										</div>
										<div class="col-xs-3">
												<label>PostalCode</label>
										</div>
										<div class="col-xs-3">
												<input type="text" class="form-control"/>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-3">
											<label>Phone</label>
										</div>
										<div class="col-xs-3">
												<input type="tel" class="form-control"/>
										</div>
										<div class="col-xs-3">
											<label>Fax</label>
										</div>
										<div class="col-xs-3">
												<input type="tel" class="form-control"/>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-3">
												Demographic
										</div>
										<div class="col-xs-9">
												<label ng-repeat="item in demographics">
									
  													<input type="checkbox" data-checklist-model="model.demos" data-checklist-value="item"> {{item.name}}
  									
											</label>
										</div>
								</div>
								<div class="row">
										<div class="col-xs-12">
												<button class="btn btn-primary">Save</button>
												<button class="btn btn-primary">Clear</button>
										</div>
								</div>
						</form>
				</fieldset>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
