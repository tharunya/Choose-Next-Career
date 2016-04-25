<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Employer home</title>

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
				data-toggle="dropdown" href="#"> <i class="fa fa-envelope fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-tasks fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a> <!-- 	<ul class="dropdown-menu dropdown-tasks">
					<li><a href="#">
							<div>
								<p>
									<strong>Task 1</strong> <span class="pull-right text-muted">40%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-success"
										role="progressbar" aria-valuenow="40" aria-valuemin="0"
										aria-valuemax="100" style="width: 40%">
										<span class="sr-only">40% Complete (success)</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<p>
									<strong>Task 2</strong> <span class="pull-right text-muted">20%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-info" role="progressbar"
										aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
										style="width: 20%">
										<span class="sr-only">20% Complete</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<p>
									<strong>Task 3</strong> <span class="pull-right text-muted">60%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-warning"
										role="progressbar" aria-valuenow="60" aria-valuemin="0"
										aria-valuemax="100" style="width: 60%">
										<span class="sr-only">60% Complete (warning)</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<p>
									<strong>Task 4</strong> <span class="pull-right text-muted">80%
										Complete</span>
								</p>
								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-danger"
										role="progressbar" aria-valuenow="80" aria-valuemin="0"
										aria-valuemax="100" style="width: 80%">
										<span class="sr-only">80% Complete (danger)</span>
									</div>
								</div>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>See
								All Tasks</strong> <i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-tasks --></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a> <!-- 			<ul class="dropdown-menu dropdown-alerts">
					<li><a href="#">
							<div>
								<i class="fa fa-comment fa-fw"></i> New Comment <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
									class="pull-right text-muted small">12 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-envelope fa-fw"></i> Message Sent <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-tasks fa-fw"></i> New Task <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
									class="pull-right text-muted small">4 minutes ago</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>See
								All Alerts</strong> <i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-alerts --></li>
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" aria-expanded="true"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> User
							Profile</a></li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li><a href="home.htm"><i class="fa fa-sign-out fa-fw"></i>
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
					<li><a href="${pageContext.request.contextPath}/employerDashboard.htm"><i
							class="fa fa-dashboard fa-fw"></i> Dashboard</a></li>
					<li><a href="${pageContext.request.contextPath}/employerUpdateProfile"><i
							class="fa fa-table fa-fw"></i> Update Profile</a></li>

					<li><a href="${pageContext.request.contextPath}/employerJobPost.htm"><i
							class="fa fa-edit fa-fw"></i> Post a new job!</a></li>
					<li><a href="${pageContext.request.contextPath}/employerApplicationList.htm"><i
							class="fa fa-wrench fa-fw"></i> Accept/ Reject Application</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">New Job Posting</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<!-- Form Name -->
									<div>

										<form:form class="form-horizontal" action="jobPosted.htm"
											commandName="job" method="post">

											<!-- Text input-->
											<div class="form-group">
												<label class="col-md-4 control-label has-error"
													for="jobTitle">Job Title</label>
												<div class="col-md-5">
													<form:input path="jobTitle" placeholder="Add a job title"
														class="form-control input-md" />

												</div>
											</div>

											<!-- Select Basic -->
											<div class="form-group">
												<label class="col-md-4 control-label" for="selectJobType">Select
													job type</label>
												<div class="col-md-5">
													<form:select id="selectJobType" name="selectJobType"
														class="form-control" path="jobType">
														<option value="Internship">Internship</option>
														<option value="Co-op">Co-op</option>
														<option value="Full time">Full time</option>
														<option value="Part time">Part time</option>
														<option value="Contract">Contract</option>
													</form:select>
												</div>
											</div>

											<!-- Text input-->
											<div class="form-group">
												<label class="col-md-4 control-label" for="jobCategory">Category</label>
												<div class="col-md-5">
													<form:input placeholder="Add a category"
														class="form-control input-md" path="jobCategory" />

												</div>
											</div>

											<!-- Text input-->
											<div class="form-group">
												<label class="col-md-4 control-label" for="jobDescription">Description</label>
												<div class="col-md-5">
													<form:input placeholder="Describe the job"
														path="jobDescription" class="form-control input-md" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label" for="jobRequirement">Requirement</label>
												<div class="col-md-5">
													<form:input placeholder="Job requirements"
														path="jobRequirement" class="form-control input-md" />
												</div>
											</div>

											<!-- Text input-->
											<div class="form-group">
												<label class="col-md-4 control-label"
													for="jobResponsibilities">Responsibilities</label>
												<div class="col-md-5">
													<form:input placeholder="Job Duties"
														path="jobResponsibilities" class="form-control input-md" />
												</div>
											</div>
											
											
											<!-- Text input-->
											<div class="form-group">
												<label class="col-md-4 control-label" for="jobLocation">Location</label>
												<div class="col-md-5">
													<form:input placeholder="Primary location of the Job"
														path="jobLocation" class="form-control input-md" />

												</div>
											</div>

											<!-- Text input-->
											<div class="form-group">
												<label class="col-md-4 control-label" for="jobCompany">Company</label>
												<div class="col-md-5">
													<form:input placeholder="Posted under which company"
														 path="jobCompany" class="form-control input-md"/>

												</div>
											</div>

											<!-- Button -->
											<div class="form-group">
												<label class="col-md-4 control-label" for="saveJobButton"></label>
												<div class="col-md-4">
													<button id="saveJobButton" name="saveJobButton"
														type="submit" class="btn btn-info">Save Job</button>
												</div>
											</div>

										</form:form>

									</div>
								</div>

							</div>

							<!-- /.row (nested) -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>

				<!-- /.col-lg-12 -->
			</div>
			<!-- row -->
		</div>

		<!-- /#page-wrapper -->

	</div>

</body>
</html>