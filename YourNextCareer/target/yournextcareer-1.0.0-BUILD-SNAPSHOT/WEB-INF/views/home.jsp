<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
    <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="#">Your Next Career!</a>
            </div>

<!-- search and submit--
		<div class="navbar-header">
            
			<form class="navbar-form navbar-left" role="search">
    	    	<div class="form-group">
    		   	   <input type="text" class="form-control" placeholder="Search">
        		</div>
        		<button type="submit" class="btn btn-default"><span class="glyphicons glyphicons-search"></span></button>
      		</form>
        </div>      
            --search & submit-->
		<div class="navbar-header">        
			<div class="input-group">
			  <div class="input-group-btn">
			    <!-- Button and dropdown menu -->
			  </div>
			  <input type="text" class="form-control" aria-label="...">
			</div>
    	</div>
        
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                 <ul class="nav pull-right">
          <li class="dropdown" id="menuLogin">
            <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="navLogin">Job seeker</a>
            <div class="dropdown-menu" style="padding:17px;">
<div class="text-center" style="padding:50px 0">
	<div class="logo">login</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="login-form" class="text-left">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="lg_username" class="sr-only">Username</label>
						<input type="text" class="form-control" id="lg_username" name="lg_username" placeholder="username">
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Password</label>
						<input type="password" class="form-control" id="lg_password" name="lg_password" placeholder="password">
					</div>
					<!-- div class="form-group login-group-checkbox">
						<input type="checkbox" id="lg_remember" name="lg_remember">
						<label for="lg_remember">remember</label>
					</div -->
				</div>
				<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				 <button type="button" id="forgotPassword" class="btn">Forgot Password? Click here!</button>
                <br/>
                <button type="button" id="btnLogin" class="btn" onclick="window.location='jobSeeker.htm'">New user? Sign up here!</button>				
		</form>
	</div>
	<!-- end:Main Form -->
</div>
	<!-- Working Form 
			<form class="form" id="formLogin"> 
                <input name="email" id="email" type="email" placeholder="Email ID"> 
                <input name="password" id="password" type="password" placeholder="Password"><br>
                <button type="button" id="btnLogin" class="btn">Login as job seeker</button>
                <button type="button" id="btnLogin" class="btn" onclick="window.location='jobSeeker.htm'">Sign up</button>
            </form>
     <!-- / Working Form -->
            </div>
          </li>
        </ul>
	
	
	<ul class="nav pull-right">
          <li class="dropdown" id="menuLogin">
            <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="navLogin">Post a Job</a>
            <div class="dropdown-menu" style="padding:17px;">
              
              <div class="text-center" style="padding:50px 0">
	<div class="logo">login</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="login-form" class="text-left">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="lg_username" class="sr-only">Username</label>
						<input type="text" class="form-control" id="lg_username" name="lg_username" placeholder="username">
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Password</label>
						<input type="password" class="form-control" id="lg_password" name="lg_password" placeholder="password">
					</div>
					<!-- div class="form-group login-group-checkbox">
						<input type="checkbox" id="lg_remember" name="lg_remember">
						<label for="lg_remember">remember</label>
					</div -->
				</div>
				<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				 <button type="button" id="forgotPassword" class="btn" onclick="window.location='addUserForm.htm'">Forgot Password? Click here!</button>
                <br/>
                <button type="button" id="btnLogin" class="btn" onclick="window.location='jobSeeker.htm'">New user? Sign up here!</button>				
		</form>
	</div>
	<!-- end:Main Form -->
</div>
              
              <!--  Working form<form class="form" id="formLogin"> 
                <input name="email" id="email" type="email" placeholder="Email ID"> 
                <input name="password" id="password" type="password" placeholder="Password"><br>
                <button type="button" id="btnLogin" class="btn">Login as an employer</button>
                <button type="button" id="btnLogin" class="btn">First posting? Sign up</button>
              </form> !-- /Working Form-->
            </div>
          </li>
        </ul>        
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
                        <h3>Your next career is right here  <span class="glyphicon glyphicon-search"></h3>
                        <hr class="intro-divider">
                        <ul class="list-inline intro-social-buttons">

                            <li>
                          		<a href="jobBoard.htm" class="btn btn-default btn-lg"></span>Jobs </a>
                            </li>
                            <li>
                                <a href="studentJobBoard.htm" class="btn btn-default btn-lg"><span>Internships or Co-ops</span></a>
                            </li>
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
                        <li>
                            <a href="#">Home</a>
                        </li>
                        <li class="footer-menu-divider">&sdot;</li>
                        <li>
                            <a href="#about">About</a>
                        </li>
                        <li class="footer-menu-divider">&sdot;</li>
                        <li>
                            <a href="JobBoard.htm">Jobs</a>
                        </li>
                        <li class="footer-menu-divider">&sdot;</li>
                        <li>
                            <a href="StudentJobBoard.htm">Students</a>
                        </li>
                    </ul>
                    <p class="copyright text-muted small">Copyright &copy; Tharunya Pati 2016. All Rights Reserved</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>
  <script src="resources/js/login-dropdown.js"></script>
</body>

</html>
