<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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


<title>Careers for you</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form:form action="jobSeeker.htm" commandName="seeker" method="post">
				<div class="col-lg-6">
					<div class="well well-sm">
						<strong><span class="glyphicon glyphicon-asterisk"></span>Required
							Field</strong>
					</div>
					<div class="form-group">
						<label for="InputName">Enter First Name</label>
						<div class="input-group">
							<form:input type="text" class="form-control" path="firstName"
								name="firstName" id="firstName" placeholder="Enter first name"
								required />
							<form:errors path="firstName" />
							<span class="glyphicon glyphicon-asterisk"></span>

						</div>
					</div>
					<div class="form-group">
						<label for="LastName">Enter Last Name</label>
						<div class="input-group">
							<form:input type="text" path="lastName" class="form-control"
								name="LastName" id="LastName" placeholder="Enter last name"
								required />
							<font color="red"><form:errors path="lastName" /></font> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Password input-->

					<div class="form-group">
						<label for="passwordinput">Password Input</label>
						<div class="input-group">
							<form:input id="passwordinput" path="password"
								name="passwordinput" type="password"
								placeholder="Enter Password" class="form-control input-md"
								required />
							<font color="red"><form:errors path="password" /></font> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label for="passwordretype">Confirm Password</label>
						<div class="input-group">
							<form:input id="passwordretype" name="passwordretype"
								type="password" placeholder="Retype password"
								class="form-control input-md" path="passwordretype" required />
							<font color="red"><form:errors path="passwordretype" /></font> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>



					<div class="form-group">
						<label for="InputEmail">Enter Email</label>
						<div class="input-group">
							<form:input type="email" path="emailID" class="form-control"
								id="InputEmailFirst" name="InputEmail" placeholder="Enter Email"
								required />
							<font color="red"><form:errors path="emailID" /></font> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<div class="form-group">
						<label for="confirmEmail">Confirm Email</label>
						<div class="input-group">
							<form:input type="email" class="form-control" id="confirmEmail"
								path="confirmEmail" name="confirmEmail"
								placeholder="Confirm Email" required />
							<font color="red"><form:errors path="confirmEmail" /></font> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>
					<form:input type="text" name="role" path="role" />
					<form:input type="submit" name="submit" id="submit" value="Submit"
						class="btn btn-info" />
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
		<spring:hasBindErrors name="seeker">
			<c:if test="${errors.globalErrorCount &gt; 0}">
				<div class="alert alert-danger">
					<form:errors />
				</div>
			</c:if>
		</spring:hasBindErrors>

	</div>
</body>
</html>