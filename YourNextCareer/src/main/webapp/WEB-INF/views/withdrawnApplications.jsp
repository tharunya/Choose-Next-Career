<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Withdraw Application</title>

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
				home</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
						<!-- /.dropdown -->
					
		 <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
    <i class="fa fa-user fa-fw"></i>
    <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
      <li><a href="${pageContext.request.contextPath}/jobSeekerUpdateProfile.htm">User Profile</a></li>
     <li class="divider"></li>
	 <li><a href="<c:url value="/logout"/>">Logout
	 </a></li>
    </ul>
  </div>
		
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" aria-expanded="true"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="/jobSeekerUpdateProfile.htm"><i
							class="fa fa-user fa-fw"></i> User Profile</a></li>
					<li class="divider"></li>
					<li><a href="${pageContext.request.contextPath}/home.htm"><i class="fa fa-sign-out fa-fw"></i>
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
					<li><a href="${pageContext.request.contextPath}/jobSeekerDashboard.htm"><i
							class="fa fa-dashboard fa-fw"></i> Look out for jobs</a></li>
					<li><a href="${pageContext.request.contextPath}/jobSeekerUpdateProfile.htm"><i
							class="fa fa-edit fa-fw"></i> Update Profile</a></li>
					<li><a href="${pageContext.request.contextPath}/jobSeekerUpdateBasicProfile.htm">Modify Basic Details</a></li>
					<li><a href="${pageContext.request.contextPath}/jobSeekerApplicationStatus.htm"><i
							class="fa fa-wrench fa-fw"></i> Check
							Applications</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
		<div id="page-wrapper"></div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>