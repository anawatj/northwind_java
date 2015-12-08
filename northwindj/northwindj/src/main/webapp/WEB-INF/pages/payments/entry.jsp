<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12">
			<fieldset>
				<legend>Payments Entry</legend>
				<form>
					<div class="row">
						<div class="col-xs-3">
							<label>PaymentCode</label>
						</div>
						<div class="col-xs-3">
							<input type="text" class="form-control" />
						</div>
						<div class="col-xs-3">
							<label>Payment Date</label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'" />
						</div>

					</div>
					<div class="row">
						<div class="col-xs-3">
							<label>Employee</label>
						</div>
						<div class="col-xs-9">
							<div class="input-group">
								<input type="text" class="form-control" />
								<div class="input-group-btn">
									<button class='btn btn-primary'>
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">
							<label>PaymentTo</label>
						</div>
						<div class="col-xs-9">
							<div class="input-group">
								<input type="text" class="form-control" />
								<div class="input-group-btn">
									<button class='btn btn-primary'>
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table
								class="table table-striped table-bordered table-hover table-condensed">
								<thead class="primary">
									<tr>
										<th></th>
										<th>PurchaseCode</th>
										<th>PurchaseDate</th>
										<th>Purchase Amt</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="checkbox" /></td>
										
										<td><input type="text" class="form-control" /></td>
										<td><input kendo-date-picker k-format="'dd/MM/yyyy'" /></td>
										
										<td><input kendo-numeric-text-box /></td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="4">
											<button class="btn btn-primary">Add</button>
											<button class="btn btn-primary">Del</button>
										</td>
									</tr>

								</tfoot>
							</table>
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