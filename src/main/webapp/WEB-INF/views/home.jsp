<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<style>

div.navi{
	text-align : center;
	

}
a.button {
	background-color: #b8e0d4; 
	border: 3px solid black;
	color: #b30000;
	padding: 16px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
}

table {
	width: 1100px;
	border: 3px solid black;
	border-collapse: collapse;
	background-color: #fff0d4;
	margin: 50px;
}

th {
	background-color: #b8e0d4;
}

th, td {
	padding: 12px;
	border: 2px solid #000066;
}

table.center {
	margin-left: auto;
	margin-right: auto;
}

body {
	background-image: url("https://wallpapercave.com/wp/wp2581374.jpg");
	background-position: center center;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 1440px;
}

#empId {
	margin: 10 px;
}

form.form1{

	text-align : center;

}

/* #a1{
background-color: lightyellow;
width: 30px;
border: 2px solid yellow;
padding: 5px;
margin: 2px;
} */
</style>

<meta charset="ISO-8859-1">
<title>Employee Management portal</title>
</head>
<body bgcolor="#d6eadf">
	<h1 align="center">Employee Search List Screen</h1>
	<hr>
	<div class="form1">
	<form action="/search" method="post" class="form1">
		Employee ID: <input type="number" id="empId" name="empId" placeholder="Enter Id"/>
		Employee Name: <input type="text" id="firstname" name="firstname" placeholder="Enter name" />
		<button type="submit" value="submit">Submit</button>
	</form>
	</div>
	<br>
	<br>
	
	<div class = "navi">
	<a href="${contextRoot}/employee" id="a1" class="button">Add New Employee</a>
	<a href="${contextRoot}/export" class="button">Export as CSV</a>
	</div>
	<table class="center">
		<tr>
			<th>Employee</th>
			<th>Contact</th>
			<th>Level & Post</th>
			<th>Action</th>
		</tr>
		<c:forEach var="employee" items="${employees}">
			<tr>
				<td>#${employee.empId}<br>${employee.firstName}
					${employee.lastName}
				</td>
				<td>${employee.mobileNum}<br>${employee.emailId}</td>
				<td>${employee.emp_Level}<br>${employee.post_name}</td>
				<td><a href="${contextRoot}/employee/${employee.empId}">Edit</a>/
					<a href="${contextRoot}/${employee.empId}">Delete</a>/
					<a href="${xontextRoot}/employments/${employee.empId}">Employments</a>
					
					</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

