<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12">
				<fieldset>
						<legend>Customers List</legend>
						<form>
									<div class="row">
									
										<div class="col-xs-3">
											<label>CompanyName</label>
										</div>
										<div class="col-xs-3">
											<input type="text" class="form-control"/>
										</div>
											<div class="col-xs-3">
											<label>ContactName</label>
										</div>
										<div class="col-xs-3">
												<input type="text" class="form-control"/>
										</div>
								</div>
								<div class="row">
									
										<div class="col-xs-3">
											<label>ContactTitle</label>
										</div>
										<div class="col-xs-3">
												<input type="text" class="form-control"/>
										</div>
												<div class="col-xs-3">
												<label>Region</label>
										</div>
										<div class="col-xs-3">
												<select class="form-control"></select>
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
										<div class="col-xs-12">
												<button class="btn btn-primary">Search</button>
												<button class="btn btn-primary">Clear</button>
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
								<th>CustomerCode</th>
								<th>CompanyName</th>
								<th>ContactName</th>
								<th>ContactTitle</th>
								<th>City</th>
								<th>Region</th>
								<th>Country</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
