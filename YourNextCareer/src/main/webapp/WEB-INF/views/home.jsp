<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Find Careers here</title>

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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
		<div class="container topnav">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand topnav"
					href="${pageContext.request.contextPath}/home.htm">Your Next
					Career!</a>
			</div>


			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<!--search & submit	<div class="col-sm-3 col-md-3 pull-right">
					<form class="navbar-form" role="search">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search"
								name="q">
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>
				</div>-->

				<div class="col-sm-3 col-md-3 pull-right">

					<!-- 					<ul class="nav pull-right"> -->
					<ul class="nav">
						<li class="dropdown" id="menuLogin"><a
							class="dropdown-toggle" href="#" data-toggle="dropdown"
							id="navLogin">Login here</a>
							<div class="dropdown-menu" style="padding: 17px;">

								<div class="text-center" style="padding: 10px 0">
									<!-- 	<div class="logo">login</div> -->
									<!-- Main Form -->
									<a href="${pageContext.request.contextPath}/forgotPassword.htm">Forgot
										Password? Click here! </a>

									<div class="login-form-1">

										<form:form id="login-form" class="text-left" method="post"
											action="loggedin.htm" commandName="person">
											<!-- 	<div class="login-form-main-message"></div> -->
											<div class="main-login-form">
												<div class="login-group">

													<div>
														<c:if test="${!empty requestScope.error}">
															<p style="color: red">UserName/Password did not match</p>
														</c:if>
													</div>

													<div class="form-group">
														<label for="lg_username" class="sr-only">Email ID</label>
														<input type="text" class="form-control" id="emailID"
															name="emailID" placeholder="Enter your Email ID">
													</div>
													<div class="form-group">
														<label for="lg_password" class="sr-only">Password</label>
														<input type="password" class="form-control"
															id="lg_password" name="password"
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
											<div class="etc-login-form">
												<button type="button" id="btnLogin" class="btn btn-primary"
													onclick="window.location='jobSeekerSignUp.htm'">
													Apply for a job? Sign up here!</button>
												<button type="button" id="btnLogin" class="btn btn-primary"
													onclick="window.location='employerSignUp.htm'">
													Post a job? Sign up here!</button>
											</div>
										</form:form>
									</div>
									<!-- end:Main Form -->
								</div>
							</div> <!--  Working form<form class="form" id="formLogin"> 
                <input name="email" id="email" type="email" placeholder="Email ID"> 
                <input name="password" id="password" type="password" placeholder="Password"><br>
                <button type="button" id="btnLogin" class="btn">Login as an employer</button>
                <button type="button" id="btnLogin" class="btn">First posting? Sign up</button>
              </form> !-- /Working Form--></li>
					</ul>
				</div>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>


	<!-- Header -->
	<a name="about"></a>
	<div class="intro-header">
		<div class="container">

			<div class="row">
				<div class="col-lg-12">
					<div class="intro-message">
						<h1>Looking for careers?</h1>
						<h3>Your next career is right here !</h3>
						<hr class="intro-divider">
						<ul class="list-inline intro-social-buttons">

							<li><a href="jobBoard.htm" class="btn btn-default btn-lg">Jobs
							</a></li>
							<li><a href="studentJobBoard.htm"
								class="btn btn-default btn-lg"><span>Internships or
										Co-ops</span></a></li>
							<li><a href="candidateProfiles.htm"
								class="btn btn-default btn-lg"><span>Applicant
										Profiles</span></a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container -->

	</div>
	<!-- /.intro-header -->

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="list-inline">
						<li><a href="${pageContext.request.contextPath}/home.htm">Home</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="about.htm">About</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="JobBoard.htm">Jobs</a></li>
						<li class="footer-menu-divider">&sdot;</li>
						<li><a href="StudentJobBoard.htm">Students</a></li>
						<li><a href="candidateProfiles.htm">Profiles</a></li>
					</ul>
					<p class="copyright text-muted small">Copyright &copy; Tharunya
						Pati 2016. All Rights Reserved</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
</body>

</html>
