<table
	class="table table-striped table-bordered table-hover table-condensed">
	<thead class="primary">
		<tr>
			<th></th>
			<th>ChequeNo</th>
			<th>Bank</th>
			<th>Branch</th>
			<th>TransferDate</th>
			<th>AccountNumber</th>
			<th>Amount</th>
		</tr>
	</thead>
	<tbody>
			<tr>
					<td>
							<input type="checkbox"/>
					</td>
					<td>
							<input type="text" class="form-control"/>
					</td>
					<td>
							<select class="form-control"/>
					</td>
					<td>	
							<select class="form-control"/>
					</td>
					<td>
							<input kendo-date-picker k-format="'dd/MM/yyyy'"/>
					</td>
					<td>
							<input type="text" class="form-control"/>
					</td>
					<td>	
							<input kendo-numeric-text-box/>
					</td>
			</tr>
	</tbody>
	<tfoot>
			<tr>
					<td colspan="7">
							<button class="btn btn-primary">Add</button>
							<button class="btn btn-primary">Del</button>
					</td>
			</tr>
			
	</tfoot>
</table>