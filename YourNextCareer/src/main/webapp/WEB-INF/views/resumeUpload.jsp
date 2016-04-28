<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	type="text/javascript"></script>

<title>Upload your resume</title>
</head>
<body>

	<h2>Application Submission</h2>
	<ul class="nav nav-pills nav-stacked col-md-2">
		<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
		<li><a data-toggle="tab" href="#menu1">Personal Information</a></li>
		<li><a data-toggle="tab" href="#menu2">Attachments</a></li>
		<li><a data-toggle="tab" href="#menu3">Sign and Submit</a></li>
	</ul>

	<div class="tab-content">
		<div id="home" class="tab-pane fade in active">
			<h3>HOME</h3>
			<p></p>
		</div>
		<div id="menu1" class="tab-pane fade">
			<h3>Personal Information</h3>
			<form:form action=".htm" commandName="seeker" method="get">
				<form:input type="text" class="form-control" path="firstName"
					name="firstName" id="firstName" placeholder="Enter first name" />
				<form:input type="text" class="form-control" path="lastName"
					name="lastName" id="lastName" placeholder="Enter last name" />
				<form:input type="text" class="form-control" path="phoneNumber"
					name="phoneNumber" id="phoneNumber" placeholder="Enter your phone number" />
				<form:input type="text" class="form-control" path="emailID"
					name="emailID" id="emailID" placeholder="Enter your Email ID" />
			</form:form>

		</div>
		<div id="menu2" class="tab-pane fade">
			<h3>Attachments</h3>
			<form>
				<form:input type="multipart" class="form-control" path="resume"
					name="emailID" id="emailID"/>
				<form:input type="text" class="form-control" path="coverLetter"
					name="emailID" id="emailID" placeholder="Enter your Email ID" />

			</form>

		</div>
		<div id="menu3" class="tab-pane fade">
			<h3></h3>
			<form>
				<form:input type="text" path="" />
				<form:input type="text" path="" />
				<form:input type="text" path="" />
			</form>

		</div>
	</div>
	</div>

</body>
</html>


</body>
</html>