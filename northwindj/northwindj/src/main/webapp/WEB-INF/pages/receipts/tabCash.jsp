<table
	class="table table-striped table-bordered table-hover table-condensed">
	<thead class="primary">
		<tr>
			<th></th>
			<th>ReceiptDate</th>
			<th>CashAmt</th>
		</tr>
	</thead>
	<tbody>
			<tr>
					<td>
							<input type="checkbox"/>
					</td>
					
					<td>
							<input kendo-date-picker k-format="'dd/MM/yyyy'"/>
					</td>
					<td>	
							<input kendo-numeric-text-box/>
					</td>
			</tr>
	</tbody>
	<tfoot>
			<tr>
					<td colspan="3">
							<button class="btn btn-primary">Add</button>
							<button class="btn btn-primary">Del</button>
					</td>
			</tr>
			
	</tfoot>
</table>