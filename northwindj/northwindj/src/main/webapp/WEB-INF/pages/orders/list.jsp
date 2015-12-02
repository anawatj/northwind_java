<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">	
		<div class="col-xs-12">
				<fieldset>
						<legend>Orders List</legend>
						<form>
								<div class="row">
										<div class="col-xs-3">
												<label>Customers</label>
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
						</form>
				</fieldset>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>