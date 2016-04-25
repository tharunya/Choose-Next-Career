<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Jobs</title>
</head>
<body>

	<!-- Form Name -->
	<legend>Reset your password</legend>
	<div class="container">

		<form:form class="form-horizontal" name="
	reset-form"
			commandName="reset">

			<!-- Search input-->

			<fieldset>
				<!-- Button -->
				<div class="row">
					<div class="col-md-4">

						<div class="input-group">
							<form:input type="email" path="emailID"
								class="form-control input-md" />
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-envelope"></i>
							</span>
						</div>
					</div>
				</div>

				<!-- Password input-->
				<div class="row">
					<div class="col-md-4">

						<div class="input-group">
							<form:input type="password" path="password"
								class="form-control input-md" />
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-lock"></i>
							</span>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">

						<div class="input-group">
							<form:input type="password" path="confirmPassword"
								class="form-control input-md" />
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-lock"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group pull-right">
							<a href data-toggle="collapse" data-target="#demo">Help</a>
						</div>
					</div>
					<div class="col-md-6">
						<div id="demo" class="col-md-6" class="collapse out"></div>
					</div>
				</div>

				<div class="col-md-12">
					<div class="form-group">
						<div class="col-md-4">
							<button id="reset" name="resetBtn" class="btn btn-primary"
								onclick="check">Reset Password</button>
						</div>
					</div>
				</div>
	</div>
	</div>

	</fieldset>
	</form:form>
	</div>
	<script>
		$(document).ready(function() {

			$("#moreDiv").click(function() {
				$("p").show();
			})
		})
	</script>


</body>
</html>