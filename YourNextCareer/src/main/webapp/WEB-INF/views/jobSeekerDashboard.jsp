<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Job Seeker dashboard</title>

<!-- Bootstrap Core CSS -->
<link
	href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="resources/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="resources/dist/css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
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
				Home</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
							<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" aria-expanded="true"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="${pageContext.request.contextPath}/jobSeekerUpdateProfile.htm"><i
							class="fa fa-user fa-fw"></i> User Profile</a></li>
					<li class="divider"></li>
					<li><a href="/logout.htm"><i class="fa fa-sign-out fa-fw"></i>
							Logout</a></li>

				</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li class="sidebar-search">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="Search...">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div> <!-- /input-group -->
					</li>
					<li><a href="jobSeekerDashboard.htm"><i
							class="fa fa-dashboard fa-fw"></i> Look out for jobs</a></li>
					<li><a href="jobSeekerUpdateProfile.htm"><i
							class="fa fa-edit fa-fw"></i> Update Profile</a></li>
					<li><a href="jobApplicationStatus.htm"><i
							class="fa fa-wrench fa-fw"></i> Check Status/ Withdraw
							Application</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Dashboard</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tasks fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="small">${job.jobList.size()}</div>
									<div>Jobs!</div>
									Job
								</div>
							</div>
						</div>
						<a href="listAllJobsFromAllEmps.htm">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="panel panel-yellow">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-shopping-cart fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">124</div>
									<div>Job cart!</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-8">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-bar-chart-o fa-fw"></i> Area Chart Example
							<div class="pull-right">
								<div class="btn-group">
									<button type="button"
										class="btn btn-default btn-xs dropdown-toggle"
										data-toggle="dropdown">
										Actions <span class="caret"></span>
									</button>
									<ul class="dropdown-menu pull-right" role="menu">
										<li><a href="#">Action</a></li>
										<li><a href="#">Another action</a></li>
										<li><a href="#">Something else here</a></li>
										<li class="divider"></li>
										<li><a href="#">Separated link</a></li>
									</ul>

								</div>
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div id="morris-area-chart"></div>
						</div>
						<!-- /.panel-body -->

						<div id="table">
							<table border="1" cellpadding="5" cellspacing="5">
								<tr>
									<td><b>Job Title</b></td>
									<td><b>Job type</b></td>
									<td><b>Job Category</b>
								</tr>
								<c:forEach var="job" items="${jobs}">
									<tr>
										<td>${job.jobTitle}</td>
										<td>${job.jobType}</td>
										<td>${job.jobCategory}</td>
									</tr>
								</c:forEach>
							</table>
						</div>

					</div>
					<!-- /.panel -->
					<!-- /.panel-heading -->
				</div>
				<!-- /.col-lg-4 (nested) -->
				<div class="col-lg-8">
					<div id="morris-bar-chart"></div>
				</div>
				<!-- /.col-lg-8 (nested) -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.row -->

	<!-- /#page-wrapper -->
	</div>

</body>
</html>