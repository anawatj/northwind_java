<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="col-xs-12">
			<fieldset>
				<legend>Receipts Entry</legend>
				<form>
					<div class="row">
						<div class="col-xs-3">
							<label>Receipt Code</label>
						</div>
						<div class="col-xs-3">
							<input type="text" class="form-control" />
						</div>
						<div class="col-xs-3">
							<label>Receipt Date</label>
						</div>
						<div class="col-xs-3">
							<input kendo-date-picker k-format="'dd/MM/yyyy'" />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3">
							<label>Receipt By</label>
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
							<label>Receipt From</label>
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
							<label>Receipt Total</label>
						</div>
						<div class="col-xs-3">
							<input kendo-numeric-text-box disabled />
						</div>
						<div class="col-xs-3">
							<label>Receipt Amount</label>
						</div>
						<div class="col-xs-3">
							<input kendo-numeric-text-box disabled />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<ul class="nav nav-tabs">
								<li class="active"><a data-toggle="tab" href="#orders">Order</a></li>
								<li><a data-toggle="tab" href="#cash">Cash</a></li>
								<li><a data-toggle="tab" href="#bank">Bank</a></li>
								<li><a data-toggle="tab" href="#cheque">Cheque</a></li>

							</ul>

							<div class="tab-content">
								<div id="orders" class="tab-pane fade in active">
									<jsp:include page="${context }/receipts/tabOrders.html"></jsp:include>
								</div>
								<div id="cash" class="tab-pane fade">
									<jsp:include page="${context }/receipts/tabCash.html"></jsp:include>
								</div>
								<div id="bank" class="tab-pane fade">
									<jsp:include page="${context }/receipts/tabBank.html"></jsp:include>
								</div>
								<div id="cheque" class="tab-pane fade">
									<jsp:include page="${context }/receipts/tabCheque.html"></jsp:include>
								</div>
							</div>
						</div>
					</div>
				</form>
			</fieldset>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>