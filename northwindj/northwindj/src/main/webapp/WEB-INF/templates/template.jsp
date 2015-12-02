<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="context"
	value="${pageContext.request.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Northwind System</title>
<link rel="stylesheet"
	href="${context}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
	
<link rel="stylesheet" href="${context }/resources/css/side-menu.css" />
<link rel= "stylesheet" href="${context }/resources/kendo/style/kendo.common-bootstrap.min.css"/>
<link rel="stylesheet" href="${context }/resources/kendo/style/kendo.bootstrap.min.css"/>


<%-- <link rel="stylesheet" href="${context}/resources/theme/css/material.min.css"/> --%>
<script type="text/javascript"
	src="${context}/webjars/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript"
	src="${context}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="${context}/resources/theme/js/material.min.js"></script> --%>
<script type="text/javascript"
	src="${context}/webjars/angularjs/1.4.4/angular.min.js"></script>
<script type="text/javascript" src="${context }/resources/kendo/script/kendo.ui.core.min.js"></script>
<script type="text/javascript" src="${context }/resources/kendo/script/kendo.angular.min.js"></script>
<script type="text/javascript"
	src="${context }/resources/lib/ui-bootstrap-tpls-0.14.3.min.js"></script>
<script type="text/javascript"
	src="${context }/resources/lib/checklist-model.js"></script>
<script type="text/javascript" src="${context }/resources/app/app.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/services/masterService.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/services/categoriesService.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/services/customersService.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/services/employeesService.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/services/ordersService.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/services/productsService.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/services/purchasesService.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/services/shippersService.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/services/suppliersService.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/services/territoriesService.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/controllers/categories/entry.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/categories/list.js"></script>
<script type="text/javascript"
	src="${context }/resources/app/controllers/customers/entry.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/customers/list.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/customers/searchModal.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/employees/entry.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/employees/searchModal.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/products/entry.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/products/list.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/products/searchModal.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/shippers/entry.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/shippers/list.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/suppliers/entry.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/suppliers/list.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/suppliers/searchModal.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/territories/entry.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/orders/entry.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/orders/list.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/purchases/entry.js"></script>
<script type="text/javascript" src="${context }/resources/app/controllers/purchases/list.js"></script>

<style type="text/css">
.primary {
	color: #fff;
	background-color: #337ab7;
	border-color: #2e6da4;
}
</style>
</head>
<body ng-app="northwind">
	<div class="row">
		<div class="col-xs-12"><h2>Northwind System</h2></div>
	</div>
	<div class="row">
		<div class="col-xs-4">

			<div class="panel-group">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" href="#northwind">Northwind System</a>
						</h4>
					</div>
					<div id="northwind" class="panel-collapse collapse">
						<ul class="list-group">
							<li class="list-group-item"><i
								class="glyphicon glyphicon-home"></i> Home</li>
							<li class="list-group-item"><a href="#categories"
								data-toggle="collapse"><i
									class="glyphicon glyphicon-folder-close"></i>Categories</a>
								<div id="categories" class="panel-collapse collapse">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="${context }/categories/entry.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Create</a></li>
										<li class="list-group-item"><a
											href="${context }/categories/list.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Search</a></li>
									</ul>
								</div></li>
							<li class="list-group-item"><a href="#customers"
								data-toggle="collapse"><i
									class="glyphicon glyphicon-folder-close"></i>Customers</a>
								<div id="customers" class="panel-collapse collapse">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="${context }/customers/entry.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Create</a></li>
										<li class="list-group-item"><a
											href="${context }/customers/list.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Search</a></li>
									</ul>
								</div></li>
							<li class="list-group-item"><a href="#employees"
								data-toggle="collapse"><i
									class="glyphicon glyphicon-folder-close"></i>Employees</a>
								<div id="employees" class="panel-collapse collapse">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="${context }/employees/entry.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Create</a></li>
										<li class="list-group-item"><a
											href="${context }/employees/list.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Search</a></li>
									</ul>
								</div></li>
							<li class="list-group-item"><a href="#orders"
								data-toggle="collapse"><i
									class="glyphicon glyphicon-folder-close"></i>Orders</a>
								<div id="orders" class="panel-collapse collapse">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="${context }/orders/entry.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Create</a></li>
										<li class="list-group-item"><a
											href="${context }/orders/list.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Search</a></li>
									</ul>
								</div></li>
							<li class="list-group-item"><a href="#purchases"
								data-toggle="collapse"><i
									class="glyphicon glyphicon-folder-close"></i>Purchases</a>
								<div id="purchases" class="panel-collapse collapse">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="${context }/purchases/entry.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Create</a></li>
										<li class="list-group-item"><a
											href="${context }/purchases/list.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Search</a></li>
									</ul>
								</div></li>
									<li class="list-group-item"><a href="#products"
								data-toggle="collapse"><i
									class="glyphicon glyphicon-folder-close"></i>Products</a>
								<div id="products" class="panel-collapse collapse">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="${context }/products/entry.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Create</a></li>
										<li class="list-group-item"><a
											href="${context }/products/list.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Search</a></li>
									</ul>
								</div></li>
									<li class="list-group-item"><a href="#shippers"
								data-toggle="collapse"><i
									class="glyphicon glyphicon-folder-close"></i>Shippers</a>
								<div id="shippers" class="panel-collapse collapse">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="${context }/shippers/entry.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Create</a></li>
										<li class="list-group-item"><a
											href="${context }/shippers/list.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Search</a></li>
									</ul>
								</div></li>
									<li class="list-group-item"><a href="#suppliers"
								data-toggle="collapse"><i
									class="glyphicon glyphicon-folder-close"></i>Suppliers</a>
								<div id="suppliers" class="panel-collapse collapse">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="${context }/suppliers/entry.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Create</a></li>
										<li class="list-group-item"><a
											href="${context }/suppliers/list.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Search</a></li>
									</ul>
								</div></li>
									<li class="list-group-item"><a href="#territories"
								data-toggle="collapse"><i
									class="glyphicon glyphicon-folder-close"></i>Territories</a>
								<div id="territories" class="panel-collapse collapse">
									<ul class="list-group">
										<li class="list-group-item"><a
											href="${context }/territories/entry.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Create</a></li>
										<li class="list-group-item"><a
											href="${context }/territories/list.html"><i
												class="glyphicon glyphicon-chevron-right"></i>Search</a></li>
									</ul>
								</div></li>

						</ul>

					</div>
				</div>

			</div>

		</div>

		<div class="col-xs-8">
			<div class="contener">
				<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</div>
		</div>
	</div>









</body>
</html>