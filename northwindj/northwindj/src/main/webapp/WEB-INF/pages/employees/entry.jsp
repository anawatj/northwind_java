<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
			<div class="col-xs-12">
				<form>
						<div class="row">
								<div class="col-xs-3">
										<label>Title</label>
								</div>
								<div class="col-xs-3">
										<select class="form-control"></select>
								</div>
								<div class="col-xs-3">
										<label>TitleOfCourtesy</label>
								</div>
								<div class="col-xs-3">
										<input type="text" class="form-control"/>
								</div>
								
						</div>
						<div class="row">
								<div class="col-xs-3">
										<label>FirstName</label>
								</div>
								<div class="col-xs-3">
										<input type="text" class="form-control"/>
								</div>
								<div class="col-xs-3">
										<label>LastName</label>
								</div>
								<div class="col-xs-3">
										<input type="text" class="form-control"/>
								</div>
								
						</div>
						<div class="row">
								<div class="col-xs-3">
										<label>BirthDate</label>
								</div>
								<div class="col-xs-3">
										<input type="date" class="form-control"/>
								</div>
								<div class="col-xs-3">
										<label>HireDate</label>
								</div>
								<div class="col-xs-3">
										<input type="date" class="form-control"/>
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
								</div>
						</div>
				</form>
			</div>
	</tiles:putAttribute>
</tiles:insertDefinition>