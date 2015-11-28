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
						<input type="text" class="form-control" />
					</div>

				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>FirstName</label>
					</div>
					<div class="col-xs-3">
						<input type="text" class="form-control" />
					</div>
					<div class="col-xs-3">
						<label>LastName</label>
					</div>
					<div class="col-xs-3">
						<input type="text" class="form-control" />
					</div>

				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>BirthDate</label>
					</div>
					<div class="col-xs-3">
						<input type="date" class="form-control" />
					</div>
					<div class="col-xs-3">
						<label>HireDate</label>
					</div>
					<div class="col-xs-3">
						<input type="date" class="form-control" />
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
						<input type="text" class="form-control" />
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Phone</label>
					</div>
					<div class="col-xs-3">
						<input type="tel" class="form-control" />
					</div>
					<div class="col-xs-3">
						<label>Extension</label>
					</div>
					<div class="col-xs-3">
						<input type="text" class="form-control" />
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Notes</label>
					</div>
					<div class="col-xs-9">
						<textarea class="form-control"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Department</label>
					</div>
					<div class="col-xs-3">
						<select class="form-control"></select>
					</div>
					<div class="col-xs-3">
						<label>ReportTo</label>
					</div>
					<div class="col-xs-3">
						<div class="input-group">
							<div class="input-group-btn">
								<input type="text" class="form-control" />
								<button class="btn btn-primary">
									<i class="glyphicon glyphicon-search"></i>
								</button>
								<label></label>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-3">
						<label>Territories</label>
					</div>
					<div class="col-xs-9"></div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#education">Education</a></li>
							<li><a data-toggle="tab" href="#experiences">Experience</a></li>

						</ul>

						<div class="tab-content">
							<div id="education" class="tab-pane fade in active">
								<jsp:include page="${context }/employees/tabEducation.html"></jsp:include>
							</div>
							<div id="experiences" class="tab-pane fade">
								<jsp:include page="${context }/employees/tabExperiences.html"></jsp:include>
							</div>
						</div>
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