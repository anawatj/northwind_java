<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12">
			<fieldset>
				<legend>Payments List</legend>
				<form>
					<div class="row">
						<div class="col-xs-3">
							<label>Payment Code</label>
						</div>
						<div class="col-xs-9">
							<input class="form-control" type="text" />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">
							<label>PaymentDate</label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'" />
						</div>
						<div class="col-xs-3">
							<label>To</label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'" />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">Employee</div>
						<div class="col-xs-9">
							<div class="input-group">
								<input type="text" class="form-control"
									ng-model="model.employee.id" />
								<div class="input-group-btn">
									<button class="btn btn-primary" ng-click="findEmployee()">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">Supplier</div>
						<div class="col-xs-9">
							<div class="input-group">
								<input type="text" class="form-control"
									ng-model="model.employee.id" />
								<div class="input-group-btn">
									<button class="btn btn-primary" ng-click="findEmployee()">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
								<button class="btn btn-primary">Search</button>
								<button class="btn btn-primary">Clear</button>
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
									<th>PaymentCode</th>
									<th>PaymentDate</th>
									<th>Employees</th>
									<th>Suppliers</th>
									<th>Amount</th>
								</tr>
							</thead>
							</table>
							
					</div>
				</div>
			</fieldset>
			
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>