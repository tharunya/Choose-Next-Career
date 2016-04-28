<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Job Seeker home</title>

<!-- Bootstrap Core CSS -->
<link
	href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="resources/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="resources/dist/css/timeline.css" rel="stylesheet">

<!-- "src/main/webapp/WEB-INF/views/checkPassword.jsp"Custom CSS -->
<link href="resources/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="resources/bower_components/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="resources/bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="loggedIn.htm">${sessionScope.personSession.firstName}'s
				home</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" aria-expanded="true"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a
						href="${pageContext.request.contextPath}/jobSeekerUpdateProfile.htm"><i
							class="fa fa-user fa-fw"></i> User Profile</a></li>
					<li class="divider"></li>
					<li><a href="${pageContext.request.contextPath}/home.htm"><i
							class="fa fa-sign-out fa-fw"></i> Logout</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">

					<li><a
						href="${pageContext.request.contextPath}/jobSeekerDashboard.htm"><i
							class="fa fa-dashboard fa-fw"></i> Look out for jobs</a></li>
		 			<li><a
						href="${pageContext.request.contextPath}/jobSeekerUpdateProfile.htm"><i
							class="fa fa-edit fa-fw"></i> Update Profile</a></li>
		<!--			<li><a
						href="${pageContext.request.contextPath}/jobSeekerUpdateBasicProfile.htm">Modify
							Basic Details</a></li> -->
					<li><a
						href="${pageContext.request.contextPath}/jobSeekerApplicationStatus.htm"><i
							class="fa fa-wrench fa-fw"></i> Check Applications</a></li>

				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Applications for jobs</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">

								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>Application ID</th>
											<th>Job ID</th>
											<th>Job Title</th>
											<th>Application Status</th>
											<th>Withdraw application</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="apps" items="${appliedJobList}">
											<tr>
												<td style="display: none"><input type="text"
													value="${apps.appId}" /></td>
												<td>${apps.appId}</td>
												<td>${apps.job.jobID}</td>
												<td>${apps.job.jobTitle}</td>
												<td>${apps.applicationStatus}</td>
												<!--  	<td><a
													href="${pageContext.request.contextPath}/withdrawApplication/${apps.appId}.htm"
													class="btn btn-primary">Withdraw Application</a></td>-->
												<td><a class="btn btn-primary"
													onclick="withdraw(this);" data-toggle="modal"
													data-target="#myModal">Withdraw Job</a></td>
											</tr>
										</c:forEach>
										<div class="modal fade" id="myModal" role="dialog">
											<div class="modal-dialog">

												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
													  <button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">Withdraw Application?</h4>
													</div>
													<div class="modal-body">
														<p>Do you really want to withdraw your application?</p>
													</div>
													<div class="modal-footer">
														<a href="/withdrawApplication/${appId}.htm" class="btn btn-default"
															data-dismiss="modal">Yes</a>
													</div>
												</div>

											</div>
										</div>

									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		type="text/javascript"></script>

	<script>
		//href="/yournextcareer/applyJob/.htm"

		//$(document).ready(function() {
		function withdraw(el) {
			var id = $(el).closest("tr").find('td:eq(0) input').val();
			//alert(id);
			$.ajax({
				type : "GET",
				url : "withdrawApplication/" + id + ".htm",
				data : "id=" + id,
				success : function(response) {
					//$(el).closest("tr").remove();
					//alert("Job applied" + id);
				},
				error : function(e) {
					//alert('Error: ' + e);
				}

			});
		}
		//});
	</script>
</body>
</html>