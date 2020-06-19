<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Employee Application</title>
<style type="text/css">

body{
background-color: #ccc;
}
.container{
display: flex;
    justify-content: space-around;}
</style>
</head>
<body>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4" style="text-align: center;">Welcome to Employee Application</h1>
  <form action="logout" method="get">
 		<input type="submit" class="btn btn-danger" value="Logout">
 	</form>
  </div>
</div>
<div class="container">
 
 	<br>
 	<form action="addEmployee" method="post">
 		Enter your id : <input type="text" name="id">
 		Enter your name : <input type="text" name="name"><br>
 		<input class="btn btn-primary" type="submit">
 	</form>
 	<br>
 	<form action="getEmployees" method="get">
 		<input type="submit" class="btn btn-primary" value="Get all Employees">
 	</form>
 	<br>
 	
 	<form action="getEmployee" method="get">
 		Enter your id : <input type="text" name="id"><br>
 		<input type="submit" class="btn btn-primary" value="Get By id">
 	</form>
 	<br>
 	
 	<form action="getEmployeeByName" method="get">
 		Enter your Name : <input type="text" name="name"><br>
 		<input type="submit" class="btn btn-primary" value="Get By Name">
 	</form>
 	<br>
 	<form action="deleteEmployee" method="post">
 		Enter your id : <input type="text" name="id"><br>
 		<input type="submit" class="btn btn-primary"  value="Delete By id">
 	</form>
 	<br>
 	<form action="getEmployeeGreaterThanId" method="get">
 		Enter id Greater than: <input type="text" name="id"><br>
 		<input type="submit" class="btn btn-primary" value="Get Employee greater than">
 	</form>
 	<br>
 	<form action="getEmployeeSortById" method="get">
 		<input type="submit" class="btn btn-primary" value="Get Employee Sort By Id desc">
 	</form>
 	<br>
 	<form action="getEmployeeSortByNameDesc" method="get">
 		<input type="submit" class="btn btn-primary" value="Get Employee Sort By Name desc">
 	</form>
 	<br>
 	<form action="logout" method="get">
 		<input type="submit" class="btn btn-danger" value="Logout">
 	</form>
 	
 	
 	</div>
 	
</body>
</html>