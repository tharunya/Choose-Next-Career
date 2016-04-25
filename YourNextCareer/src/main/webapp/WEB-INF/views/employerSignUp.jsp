<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

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

<title>Employer Sign Up</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form:form action="employerSignUp.htm" commandName="employer" method="post">
				<div class="col-lg-6">
					<div class="well well-sm">
					</div>
					<div class="form-group">
						<label for="InputName">Enter First Name</label>
						<div class="input-group">
							<form:input type="text" action="/employerSignUp.htm" class="form-control" path="firstName"
								name="firstName" id="firstName" placeholder="Enter first name" />
							<form:errors path="firstName" />
							<span class="input-group-addon">
							</span>

						</div>
					</div>
					<div class="form-group">
						<label for="LastName">Enter Last Name</label>
						<div class="input-group">
							<form:input type="text" path="lastName" class="form-control"
								name="LastName" id="LastName" placeholder="Enter last name" />
							<font color="red"><form:errors path="lastName" /></font> <span
								class="input-group-addon"></span>
						</div>
					</div>

					<!-- Password input-->

					<div class="form-group">
						<label for="passwordinput">Password Input</label>
						<div class="input-group">
							<form:password placeholder="Enter Password" path="password"
								class="form-control input-md" />
							<font color="red"><form:errors path="password" /></font> <span
								class="input-group-addon"></span></span>
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label for="passwordretype">Confirm Password</label>
						<div class="input-group">
							<form:password placeholder="Retype password"
								path="confirmPassword" class="form-control input-md" />
							<span class="input-group-addon"> <form:errors
									path="confirmPassword" /></span>
						</div>
					</div>



					<div class="form-group">
						<label for="InputEmail">Enter Email</label>
						<div class="input-group">
							<form:input type="email" path="emailID" class="form-control"
								id="emailID" name="emailID" placeholder="Enter Email ID" />
							<font color="red"><form:errors path="emailID" /></font> <span
								class="input-group-addon"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="confirmEmail">Confirm Email</label>
						<div class="input-group">
							<form:input type="email" class="form-control" id="confirmEmailID"
								name="confirmEmailID" path="confirmEmailID"
								placeholder="Confirm Email" />
							<font color="red"><form:errors path="confirmEmailID" /></font> <span
								class="input-group-addon">
							</span>
						</div>
					</div>
					<input type="submit" class="btn btn-info" name="submit" id="submit"
						value="Submit" />
				</div>
			</form:form>
			<div class="col-lg-5 col-md-push-1" hidden>
				<div class="col-md-12">
					<div class="alert alert-success">
						<strong><span class="glyphicon glyphicon-ok"></span>
							Success! Logged In.</strong>
					</div>
					<div class="alert alert-danger">
						<span class="glyphicon glyphicon-remove"></span><strong>
							Error! Please check all page inputs.</strong>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>