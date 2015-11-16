<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="context"
	value="${pageContext.request.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ManaoTemplate</title>
<link rel="stylesheet"
	href="${context}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
<link rel="stylesheet" href="${context}/resources/theme/css/material.min.css"/>
<script type="text/javascript"
	src="${context}/webjars/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="${context}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${context}/resources/theme/js/material.min.js"></script>
<script type="text/javascript"
	src="${context}/webjars/angularjs/1.4.4/angular.min.js"></script>


</head>
<body ng-app="template" >

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Example</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							Admin</a></li>
					<li><a href="<c:url value="j_spring_security_logout" />"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="row">
		<div class="col-xs-3">

			<div class="panel-group">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" href="#collapse1"><i
								class="fa fa-arrow-circle-right"></i>Example</a>
						</h4>
					</div>
					<div id="collapse1" class="panel-collapse collapse">
						<ul class="list-group">
							<li class="list-group-item"><a
								href="<c:url value='/index.action'/>"><span
									class="glyphicon glyphicon-home"></span>&nbsp;Dashboard</a></li>
							<li class="list-group-item"><a data-toggle="collapse"
								href="#admin"><span class="glyphicon glyphicon-user"></span>&nbsp;Admin<i
									class="pull-right glyphicon glyphicon-chevron-down"></i></a>
								<div id="admin" class="panel-collapse collapse">
									<ul class="list-group">
										<li class="list-group-item"><a href="${context}/role/view.html"><span
												class="glyphicon glyphicon-stop"></span>&nbsp;Role</a></li>
										<li class="list-group-item"><a href="${context}/user/view.html"><span
												class="glyphicon glyphicon-stop"></span>&nbsp;User</a></li>
									</ul>
								</div></li>


						</ul>

					</div>
				</div>

			</div>
		</div>
		<div class="col-xs-9">
			<div class="row">
				<div class="col-xs-12">
					<a href="${context }/index.html">Home</a> > Index
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<label>Page Name</label>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<tiles:insertAttribute name="body"></tiles:insertAttribute>
				</div>
			</div>

		</div>
	</div>





</body>
</html>