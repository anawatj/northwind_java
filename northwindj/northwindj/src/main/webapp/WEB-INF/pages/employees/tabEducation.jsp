<table class="table table-striped table-bordered table-hover table-condensed">
						<thead class="primary">
								<tr>
										<th></th>
										<th>Education Level</th>
										<th>University</th>
										<th>Major</th>
										<th>Minor</th>
										<th>Gpa</th>
								</tr>
						</thead>
						<tbody>
								<tr ng-repeat="item in model.educations">
										<td>
												<input type="checkbox" ng-model="item.selected"/>
										</td>
										<td>
												<select class="form-control" ng-model="item.educationLevel.id">
														<option value="0"></option>
														<option ng-repeat="sitem in educationLevels" ng-selected="sitem.id==item.educationLevel.id" value="{{sitem.id}}">
															{{sitem.name}}
														</option>
												</select>
										</td>
										<td>
												<input type="text" class="form-control" ng-model="item.university"/>
										</td>
										<td>
												<input type="text" class="form-control" ng-model="item.major"/>
										</td>
										<td>
												<input type="text" class="form-control" ng-model="item.minor"/>
										</td>
										<td>
												<input kendo-numeric-text-box k-ng-model="item.gpa"/>
										</td>
								</tr>
						</tbody>
						<tfoot>
								<tr>
										<td colspan="6">
												<button class="btn btn-primary" ng-click="addEducation()">Add</button>
												<button class="btn btn-primary" ng-click="delEducation()">Del</button>
										</td>
								</tr>
						</tfoot>
</table>