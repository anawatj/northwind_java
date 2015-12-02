<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12">
				<form>
						<div class="row">
								<div class="col-xs-3">
										<label>ProductName</label>
								</div>
								<div class="col-xs-9">
										<input type="text" class="form-control"/>
								</div>
						</div>
						<div class="row">
								<div class="col-xs-3">
										<label>Categories</label>
								</div>
								<div class="col-xs-9">
										<select class="form-control"></select>
								</div>
						</div>
						<div class="row">
								<div class="col-xs-3">
										<label>Suppliers</label>
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
												<th>Name</th>
												<th>Categories</th>
												<th>Suppliers</th>
										</tr>
									</thead>
								</table>
						</div>
				</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>