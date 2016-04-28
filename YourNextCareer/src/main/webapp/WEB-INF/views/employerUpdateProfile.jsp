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
				data-toggle="dropdown" href="#" aria-expanded="true"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="${pageContext.request.contextPath}/employerUpdateProfile.htm"><i class="fa fa-user fa-fw"></i> User
							Profile</a></li>
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
						href="${pageContext.request.contextPath}/employerDashboard.htm"><i
							class="fa fa-dashboard fa-fw"></i> Look for applicants</a></li>
					<li><a
						href="${pageContext.request.contextPath}/employerUpdateProfile.htm"><i
							class="fa fa-table fa-fw"></i> Update Profile</a></li>

					<li><a
						href="${pageContext.request.contextPath}/employerJobPost.htm"><i
							class="fa fa-edit fa-fw"></i> Click to post a new job!</a></li>
					<li><a
						href="${pageContext.request.contextPath}/employerJobApplicantsList.htm"><i
							class="fa fa-wrench fa-fw"></i> Posted Jobs</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
			</div>
		<!-- /.navbar-static-side --> </nav>
			
			<div id="page-wrapper">
							
										<!-- Form Name -->
										<form:form action="employerUpdateProfile.htm" commandName="employer"
											method="post">
											<div class="col-lg-6">
												<div class="well well-sm"><div class="panel-heading">Update employer profile</div></div>
												<div class="form-group">
													<label for="InputName">First Name</label>
													<div class="input-group">
														<form:input type="text" class="form-control"
															path="firstName" name="firstName" id="firstName"
															placeholder="Enter first name" />
														<span class="input-group-addon"> <font color="red"><form:errors
																	path="firstName" /></font></span>
													</div>
												</div>
												<div class="form-group">
													<label for="lastName">Last Name</label>
													<div class="input-group">
														<form:input type="text" path="lastName"
															class="form-control" name="lastName" id="lastName"
															placeholder="Enter last name" />
														<span class="input-group-addon"> <font color="red"><form:errors
																	path="lastName" /></font></span>
													</div>
												</div>

												<!-- Password input-->

												<div class="form-group">
													<label for="passwordinput">Password</label>
													<div class="input-group">
														<form:input type="password" placeholder="Enter Password"
															path="password" class="form-control input-md" />
														<span class="input-group-addon"> <font color="red"><form:errors
																	path="password" /></font></span>
													</div>
												</div>

												<!-- Password input-->
												<div class="form-group">
													<label for="passwordretype">Confirm Password</label>
													<div class="input-group">
														<form:password placeholder="Retype password"
															path="confirmPassword" class="form-control input-md" />
														<span class="input-group-addon"> <font color="red"><form:errors
																	path="confirmPassword" /></font></span>
													</div>
												</div>



												<div class="form-group">
													<label for="InputEmail">Email</label>
													<div class="input-group">
														<form:input type="email" path="emailID"
															class="form-control" id="emailID" name="emailID"
															placeholder="Enter Email ID" />
														<span class="input-group-addon"> <font color="red"><form:errors
																	path="emailID" /></font></span>
													</div>
												</div>
												<div class="form-group">
													<label for="confirmEmail">Confirm Email</label>
													<div class="input-group">
														<form:input type="email" class="form-control"
															id="confirmEmailID" name="confirmEmailID"
															path="confirmEmailID" placeholder="Confirm Email" />
														<span class="input-group-addon"> <font color="red"><form:errors
																	path="confirmEmailID" /></font></span>
													</div>
												</div>
												<input type="submit" class="btn btn-info" name="submit"
													id="submit" value="Submit" />
											</div>
										</form:form>
						</div>
		<!-- /#page-wrapper -->
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>