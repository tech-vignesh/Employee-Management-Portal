<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>
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

/* #a1{
background-color: lightyellow;
width: 30px;
border: 2px solid yellow;
padding: 5px;
margin: 2px;
} */
</style>
<meta charset="ISO-8859-1">
<title>Employee history</title>
</head>
<body>
	<h1 align="center">EMPLOYEE SEARCH LIST SCREEN</h1>
	<hr>

	<h2 align="center">${name.firstName}
		${name.lastName}(#${name.empId})</h2>

	<table>
		<tr>
			<th>ORGANIZATION</th>
			<th>PERIOD</th>
			<th>LOCATION</th>
			<th>POST</th>
		</tr>
		<c:forEach var="history" items="${employeehistory}">
			<tr>
				<td>${history.organization_name}</td>
				<td><p>${history.from_date}T~ ${history.until_date}</p></td>
				<td>${history.location}(${history.country})</td>
				<td>${history.post}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<a href= "${contextRoot}/">Return to home page</a>


</body>
</html>