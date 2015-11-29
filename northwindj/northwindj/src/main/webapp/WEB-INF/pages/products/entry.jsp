<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="col-xs-12">
				<form>
						<div class="row">
							<div class="col-xs-3">
								<label>Name</label>
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
							<div class="col-xs-3">
									
									<label>Quantity Per Unit</label>
							</div>
							<div class="col-xs-9">
									<input type="text" class="form-control"/>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3">
									<label>UnitPrice</label>
							</div>
							<div class="col-xs-9">
									<input kendo-numeric-text-box style="width:100%"/>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3">
									<label>Recorder Level</label>
							</div>
							<div class="col-xs-9">
									<input kendo-numeric-text-box style="width:100%"/>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3">
									<label>Discontinued</label>
							</div>
							<div class="col-xs-9">
									<input type="checkbox" />
							</div>
						</div>
						<div class="row">
								<div class="col-xs-12">
										<button class="btn btn-primary">Save</button>
										<button class="btn btn-primary">Clear</button>
								</div>
						</div>
				</form>
			</div>
	</tiles:putAttribute>
</tiles:insertDefinition>