<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

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

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="true"> <i
						class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
				<li><a href="${pageContext.request.contextPath}/jobSeekerUpdateProfile.htm"><i
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
<!-- 						<li><a
							href="${pageContext.request.contextPath}/jobSeekerUpdateBasicProfile.htm">Modify
								Basic Details</a></li> -->
						<li><a
							href="${pageContext.request.contextPath}/jobSeekerApplicationStatus.htm"><i
								class="fa fa-wrench fa-fw"></i> Check Applications</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- /.row -->
		<div id="page-wrapper">
			<form action="upresume.htm" method="post" enctype="multipart/form-data">

				<div class="form-group">
					<legend>Upload Resume</legend>
					<div class="input-group">
						<input type="file" name="resumefile" id="upload-file-input"
							required  />
						<!-- <button type="submit" class="btn btn-primary">Upload
									Resume</button> -->
					</div>
					file name: <a href="">${resumefilename}</a>
				</div>
				<div>
					<input type="text" class="form-control" name="skills"
						id="skills" placeholder="Enter skills" required="required" />
				</div>
				<br />
				<div>
					<input type="submit" id="uploadBtn" class="btn btn-info"
						value="Submit" />
				</div>
			</form>

			<!-- Trigger the modal with a button -->
			<div>
				<button type="submit" id="modalButton" class="btn btn-info"
					data-toggle="modal" data-target="#myModal" disabled>Get..Set..Apply
					job!</button>
			</div>
			<div id="myModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Start applying..</h4>
						</div>
						<div class="modal-body">
							<p>You've successfully uploaded your resume, get geared to
								apply for jobs</p>
						</div>
						<div class="modal-footer">

							<a href="listAllAvailableJobs.htm" class="btn btn-default">Go
								to available jobs list</a>
						</div>
					</div>

				</div>
			</div>

		</div>
		<!-- /#page-wrapper -->
	</div>
	<script>
		$(document).ready(function() {
			$("#modalButton").prop('disabled', true);
			$("#uploadBtn").onclick
			{

				$("#modalButton").prop('disabled', false);
			}
		});
	</script>
	
</body>
</html>