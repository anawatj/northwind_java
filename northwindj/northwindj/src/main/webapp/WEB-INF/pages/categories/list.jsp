<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12">
			<fieldset>
				<legend>Categories List</legend>
				<form>
					<div class="row">
						<div class="col-xs-3">
							<label>CategoryName</label>
						</div>
						<div class="col-xs-6">
							<input type="text" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">
							<label>Description</label>
						</div>
						<div class="col-xs-6">
							<textarea class="form-control"></textarea>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-9">
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
								<th>ID</th>
								<th>Name</th>
								<th>Description</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
