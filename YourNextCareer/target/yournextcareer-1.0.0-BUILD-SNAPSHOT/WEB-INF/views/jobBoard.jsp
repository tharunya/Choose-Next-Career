<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Jobs</title>
</head>
<body>

<form class="form-horizontal" name="search-form">
<!-- Form Name -->
<legend>Job Board</legend>

<!-- Search input-->

<div class="container">
<fieldset>
<!-- Button -->
<div class="col-md-12">
	<div class="form-group">
  		<div class="col-md-4">
    		<a href="studentJobBoard.htm" class="btn btn-primary">Interns/ Co-ops</a>
  		</div>
	</div>
</div>

<div class="col-md-12">
	<div class="form-group">
      <input id="searchinput" name="searchinput" type="search" 
	    	placeholder="What are you looking for?" 
	    		class="form-control input-md">
	  </div>

  <div class="input-group">
      <input type="text" class="form-control input-md" id="searchPlace" 
      		placeholder="Location" style="z-index:90000">
    <span class="input-group-addon">
      <i class="map-pin-icon form-control-feedback"></i>
     </span>
    </div>      
  </div>

  <div class="form-group pull-right">
      <a href="#searchCriteriaDiv"> More Search criteria </a>
  </div>
  
  <div class="col-md-12">
	<div class="form-group">
  		<div class="col-md-4">
    		<button id="searchBtn" name="searchBtn" class="btn btn-primary" onclick="check">Search Jobs</button>
  		</div>
	</div>
</div>
  

</fieldset>

<div class = "form-group">
	<h4>You have (1240) jobs from (302) employers</h4>
</div>
</form>
</div>
<script>
$(function check() {
    var minlength = 3;

    $("#searchinput").keyup(function () {
        var that = this,
        value = $(this).val();

        if (value.length >= minlength ) {
            $.ajax({
                type: "GET",
                url: "jobBoard.jsp",
                data: {
                    'search_keyword' : value
                },
                dataType: "text",
                success: function(msg){
                    //we need to check if the value is the same
                    if (value==$(that).val()) {
                    //Receiving the result of search here
                    System.out.println("Output"+value);
                    }
                }
            });
        }
    });
});

</script>
</body>
</html>