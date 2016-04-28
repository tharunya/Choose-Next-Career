<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  .logout{
  margin:15px;
  background-color:white;
  color:black;
  width:120px;
  height: 30px;
  font-size: 20px;
  }
  #but {
  width:300px;
  color: white;
  background-color:red;
  height:100px;
  border:2px black;
  }
  #row{
  margin: 50px 50px 0px 50px;
  }
  #row1{
  padding: 50px 50px 0px 50px;
  }
  #hre{
  text-decoration:none;
  color:white;
  font-size:20px;
  }
  </style>
</head>

<body>
<div class="row" style="background-color:black;color:white;height:100px;font-size:30px">
<div class="col-md-3">
welcome ${sessionScope.emp1.username}
</div>
<div class="col-md-7">
</div>
<div class="col-md-2">
<a href="loginuser.htm"><button class="logout">Logout</button></a>
</div>
</div>
<div class="row">
<div class="col-md-4" style="background-color:red;font-size:20px;width:300px;height:800px">
<div id="row1">
<a href="buildprofile.htm" id="hre">Build profile</a>
</div>
<div id="row">
<a href="postajob.htm" id="hre">post a job</a>
</div>
<div id="row">
<a href="viewjob.htm" id="hre">View Posted Jobs</a>
</div>
</div>
<div class="col-md-8" style="background-color:white;height:800px;width:1070px">
<div id="row">
<form:form action ="buildprofile.htm" commandName="employer" method ="get"  role="form">  

<div class="row">
            <div class="form-group">
                <div class="col-sm-2"></div>
                <label class="col-sm-2" for="Title">Firstname</label>
                <div class="col-sm-4">
    <form:input type="text" path="firstName" class="form-control" placeholder="company name" />
                <font color="red"><form:errors path="firstName"/></font>
                </div>
                <div class="col-sm-4"></div>
   </div>
   </div>
   <br>
            <div class="row">
            <div class="form-group">
                <div class="col-sm-2"></div>
                <label class="col-sm-2" for="Title">lastName</label>
                <div class="col-sm-4">
    <form:input type="text" path="lastName" class="form-control" placeholder="company name" />
                <font color="red"><form:errors path="lastName"/></font>
                </div>
                <div class="col-sm-4"></div>
   </div>
   </div>
   <br>
   <div class="row">
            <div class="form-group">
                <div class="col-sm-2"></div>
                <label class="col-sm-2" for="Title">Password</label>
                <div class="col-sm-4">
    <form:input type="text" path="password" class="form-control" placeholder="company name" />
                <font color="red"><form:errors path="password"/></font>
                </div>
                <div class="col-sm-4"></div>
   </div>
   </div>
   <br>
   <div class="row">
            <div class="form-group">
                <div class="col-sm-2"></div>
                <label class="col-sm-2" for="Title">Email</label>
                <div class="col-sm-4">
    <form:input type="text" path="email" class="form-control" placeholder="company name" />
                <font color="red"><form:errors path="email"/></font>
                </div>
                <div class="col-sm-4"></div>
   </div>
   </div>
   <br>
            <div class="row">
            <div class="form-group">
                <div class="col-sm-2"></div>
                <label class="col-sm-2" for="Title">Companyname</label>
                <div class="col-sm-4">
    <form:input type="text" path="company" class="form-control" placeholder="company name" />
                <font color="red"><form:errors path="company"/></font>
                </div>
                <div class="col-sm-4"></div>
   </div>
   </div>
   <br>
            <div class="row">
            <div class="form-group">
                <div class="col-sm-2"></div>
                <label class="col-sm-2" for="Title">Designation</label>
                <div class="col-sm-4">
    <form:input type="text" path="designation" class="form-control" placeholder="designation" />
                <font color="red"><form:errors path="designation"/></font>
                </div>
                <div class="col-sm-4"></div>
   </div>
   </div>
   <br>
   <div class="row">
    <div class="form-group">
                <div class="col-sm-2"></div>
                <label class="col-sm-2" for="Name">Company Description</label>
                <div class="col-sm-4">
    <form:textarea path="compdesc" name="Company Description" class="form-control" rows="10" 
    placeholder="Company Description"></form:textarea>
                <font color="red"><form:errors path="compdesc"/></font>
                </div>
                <div class="col-sm-4"></div>
   </div>
   </div>
   <br>
   <br>
   <div class="row">
    <div class="form-group">
    <div class="col-sm-3"></div>
    <div class="col-sm-4">
    <button type="submit" class="form-control" style="background-color:black">Build profile</button>
    </div>
    </div>
    </div>
   
   
</form:form>
</div>
</div>
</div>
</body>
</html>