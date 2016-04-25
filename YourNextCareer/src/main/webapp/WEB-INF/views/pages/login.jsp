<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/landing-page.css" rel="stylesheet">
<link href="resources/css/login-dropdown.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

</head>
<body onload='document.f.j_username.focus();'>
	<div class="container">
		<form:form id="login-form" name="f" class="text-left" method="post"
			action="/j_spring_security_check" commandName="loginObject">
			<!-- 	<div class="login-form-main-message"></div> -->
			<div class="main-login-form">
				<div class="login-group">

					<div>
						<c:if test="${!empty requestScope.error}">
							<p style="color: red">UserName/Password did not match</p>
						</c:if>
					</div>

					<div class="form-group">
						<label for="lg_username" class="sr-only">Email ID</label> <input
							type="text" class="form-control" id="emailID" name="j_username"
							placeholder="Enter your Email ID">
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Password</label> <input
							type="password" class="form-control" id="lg_password"
							name="j_password" name="password"
							placeholder="Enter your password">
					</div>
					<!-- div class="form-group login-group-checkbox">
													<input type="checkbox" id="lg_remember" name="lg_remember">
													<label for="lg_remember">remember</label>
												</div -->
				</div>
				<button type="submit" class="login-button form-control">
					<i class="fa fa-chevron-right"></i>
				</button>

			</div>

		</form:form>
	</div>
</body>
</html>