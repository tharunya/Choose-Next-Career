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
			<form:form action="${pageContext.request.contextPath}/jobSeekerSignUp.htm" commandName="seeker"
				method="post">
				<div class="col-lg-6">
					<div class="well well-sm"></div>
					<div class="form-group">
						<label for="firstName">Enter First Name</label>
						<div class="input-group">
							<form:input type="text" class="form-control" path="firstName"
								name="firstName" id="firstName" placeholder="Enter first name"
								required="required" />
							<form:errors path="firstName" />
							<span class="input-group-addon"> </span>

						</div>
					</div>
					<div class="form-group">
						<label for="lastName">Enter Last Name</label>
						<div class="input-group">
							<form:input type="text" path="lastName" class="form-control"
								name="LastName" id="LastName" placeholder="Enter last name"
								required="required" />
							<font color="red"><form:errors path="lastName" /></font> <span
								class="input-group-addon"></span></span>
						</div>
					</div>

					<!-- Password input-->

					<div class="form-group">
						<label for="password">Password Input</label>
						<div class="input-group">
							<form:password placeholder="Enter Password" path="password"
								class="form-control input-md" />
							<span class="input-group-addon"> <font color="red"><form:errors
										path="password" required="required" /></font>
							</span>
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label for="confirmPassword">Confirm Password</label>
						<div class="input-group">
							<form:password placeholder="Retype password"
								path="confirmPassword" class="form-control input-md"
								required="required" />
							<span class="input-group-addon"> <form:errors
									path="confirmPassword" /></span>
						</div>
					</div>



					<div class="form-group">
						<label for="emailID">Enter Email</label>
						<div class="input-group">
							<form:input type="email" path="emailID" class="form-control"
								id="emailID" name="emailID" placeholder="Enter Email ID"
								required="required" />
							<font color="red"><form:errors path="emailID" /></font> <span
								class="input-group-addon"> </span>
						</div>
					</div>
					<div class="form-group">
						<label for="confirmEmail">Confirm Email</label>
						<div class="input-group">
							<form:input type="email" class="form-control" id="confirmEmailID"
								name="confirmEmailID" path="confirmEmailID" required="required"
								placeholder="Confirm Email" />
							<font color="red"><form:errors path="confirmEmailID" /></font> <span
								class="input-group-addon"> </span>
						</div>
					</div>
					<input type="submit" class="btn btn-info" name="submit" id="submit"
						value="Submit profile" />
				</div>
			</form:form>
		</div>

	</div>

</body>
</html>