<table class="table table-striped table-bordered table-hover table-condensed">
						<thead class="primary">
								<tr>
										<th></th>
										<th>Company</th>
										<th>Start</th>
										<th>End</th>
										<th>Salary</th>
										<th>Reason Of Resign</th>
								</tr>
						</thead>
						<tbody>
								<tr ng-repeat="item in model.experiences">
										<td>
												<input type="checkbox" ng-model="item.selected"/>
										</td>
										<td>
												<input type="text" class="form-control" ng-model="item.company"/>
										</td>
										<td>
												<input kendo-date-picker k-format="'MM/yyyy'" k-ng-model="item.start"/>
										</td>
										<td>
												<input kendo-date-picker k-format="'MM/yyyy'" k-ng-model="item.end"/>
										</td>
										<td>
												<input kendo-numeric-text-box k-ng-model="item.salary"/>
										</td>
										<td>
												<textarea class="form-control" ng-model="item.reasonOfResign"></textarea>
										</td>
								</tr>
						</tbody>
						<tfoot>
								<tr>
									<td colspan="6">
											<button class="btn btn-primary" ng-click="addExperience()">Add</button>
											<button class="btn btn-primary" ng-click="delExperience()">Del</button>
									</td>
								</tr>
						</tfoot>
</table>