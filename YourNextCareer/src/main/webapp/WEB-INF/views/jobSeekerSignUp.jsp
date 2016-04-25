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


<title>Job Seeker Sign Up</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form:form action="jobSeekerSignUp.htm" commandName="seeker"
				method="post">
				<div class="col-lg-6">
					<div class="well well-sm"></div>
					<div class="form-group">
						<label for="firstName">Enter First Name</label>
						<div class="input-group">
							<form:input type="text" class="form-control" path="firstName"
								name="firstName" id="firstName" placeholder="Enter first name" />
							<span class="input-group-addon"> <font color="red"><form:errors
										path="firstName" /></font></span> 

						</div>
					</div>
					<div class="form-group">
						<label for="lastName">Enter Last Name</label>
						<div class="input-group">
							<form:input type="text" path="lastName" class="form-control"
								name="LastName" id="LastName" placeholder="Enter last name" />
							<span class="input-group-addon"> <font color="red"><form:errors
										path="lastName" /></font></span>
						</div>
					</div>

					<div class="form-group">
						<label for="password">Password Input</label>
						<div class="input-group">
							<form:password placeholder="Enter Password" id="password"
								path="password" class="form-control input-md" />
							<span class="input-group-addon"> <font color="red"><form:errors
										path="password" /></font></span>
						</div>
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label for="confirmPassword">Confirm Password</label>
					<div class="input-group">
						<form:password placeholder="Retype password" id="confirmPassword"
							path="confirmPassword" class="form-control input-md" />
						<span class="input-group-addon"> <font color="red"><form:errors
									path="confirmPassword" /></font></span>
					</div>
				</div>

				<div class="form-group">
					<label for="emailID">Enter Email</label>
					<div class="input-group">
						<form:input type="text" path="emailID"
							class="form-control input-md" id="emailID" name="emailID"
							placeholder="Enter Email ID" />
						<span class="input-group-addon"><font color="red"><form:errors
									path="emailID" /></font> </span>
					</div>
				</div>
				<div class="form-group">
					<label for="confirmEmail">Confirm Email</label>
					<div class="input-group">
						<form:input type="email" class="form-control" id="confirmEmailID"
							name="confirmEmailID" path="confirmEmailID"
							placeholder="Confirm Email" />
						<span class="input-group-addon"> <font color="red"><form:errors
									path="confirmEmailID" /></font>
						</span>
					</div>
				</div>
				<input type="submit" class="btn btn-info" name="submit" id="submit"
					value="Submit" />

			</form:form>
		</div>
		<div class="col-lg-5 col-md-push-1" hidden=hidden>
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

	

</body>
</html>