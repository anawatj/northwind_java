<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="col-xs-12">
					<fieldset>
							<legend>Orders Entry</legend>
							<form>
									<div class="row">
											<div class="col-xs-3">
													<label>Employee</label>
											</div>
											<div class="col-xs-9">
													<div class="input-group">
															<input type="text" class="form-control"/>
															<div class="input-group-btn">
																	<button class="btn btn-primary">
																		<i class="glyphicon glyphicon-search"></i>
																	</button>
															</div>
													</div>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>Customer</label>
											</div>
											<div class="col-xs-9">
													<div class="input-group">
															<input type="text" class="form-control"/>
															<div class="input-group-btn">
																	<button class="btn btn-primary">
																		<i class="glyphicon glyphicon-search"></i>
																	</button>
															</div>
													</div>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>OrderDate</label>
											</div>
											<div class="col-xs-3">
													<input kendo-date-picker k-format="'dd/MM/yyyy'"/>
											</div>
											<div class="col-xs-3">
													<label>Require Date</label>
											</div>
											<div class="col-xs-3">
													<input kendo-date-picker k-format="'dd/MM/yyyy'"/>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>ShipperDate</label>
											</div>
											<div class="col-xs-3">
													<input kendo-date-picker k-format="'dd/MM/yyyy'"/>
											</div>
											<div class="col-xs-3">
													<label>ShipVia</label>
											</div>
											<div class="col-xs-3">
													<select class="form-control"></select>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>Freight</label>
											</div>
											<div class="col-xs-3">
													<input kendo-numeric-text-box/>
											</div>
											<div calss="col-xs-3">
													<label>ShipName</label>
											</div>
											<div class="col-xs-3">
													<input type="text" class="form-control"/>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>ShipAddress</label>
											</div>
											<div class="col-xs-9">
													<textarea class="form-control"></textarea>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>ShipCountry</label>
											</div>
											<div class="col-xs-3">
													<select class="form-control"></select>
											</div>
											<div class="col-xs-3">
													<label>ShipCity</label>
											</div>
											<div class="col-xs-3">
													<select class="form-control"></select>
											</div>
									</div>
									<div class="row">
											<div class="col-xs-3">
													<label>ShipRegion</label>
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
											<div class="col-xs-12">
														<table
															class="table table-striped table-bordered table-hover table-condensed">
															<thead class="primary">
																<tr>
																	<th></th>
																	<th>Product</th>
																	<th>UnitPrice</th>
																	<th>Quantity</th>
																	<th>Discount</th>
																</tr>
															</thead>
															<tbody>
																	<tr>
																		<td><input type="checkbox"/></td>
																		<td>
																			<div class="input-group">
																					<input type="text" class="form-control"/>
																					<div class="input-group-btn">
																								<button class="btn btn-primary">
																								<i class="glyphicon glyphicon-search"></i>
																								</button>
																					</div>
																			 </div>
																		</td>
																		<td>
																				<input kendo-numeric-text-box/>
																		</td>
																			<td>
																				<input kendo-numeric-text-box/>
																		</td>
																			<td>
																				<input kendo-numeric-text-box/>
																		</td>
																	</tr>
															</tbody>
															<tfoot>
																	<tr>
																		<td colspan="5">
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