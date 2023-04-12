<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>
hr {
	border: 2px solid black;
}

body {
	background-image:
		url("https://png.pngtree.com/back_origin_pic/04/16/74/c70166cf73843f33a9999c440cf1762a.jpg");
	background-position: center center;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 1440px;
	font-weight: bold;
}

.error {
	color: red;
	border: 1px solid black;
}

input {
	margin: 5px;
	width: 180px;
	padding: 4px;
	border: 1px solid black;
	border-radius: 20px;
	background: #ffffe6;
	
}
</style>

<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body bgcolor="#d6eadf" align="center">
	<h1>Add New Employee</h1>
	<hr>

	<form:form action="${contextRoot}/employee" method="post"
		modelAttribute="employee" float="right">
		<br>
		<div>
			<span> Employee Id<form:input path="empId" />
			</span> <span> First Name: <form:input path="firstName" /><br>
			</span>
		</div>
		<div>
			<span> Last Name: <form:input path="lastName" />
			</span> <span> Gender:<form:select path="gender">
					<form:option value="F" label="F" />
					<form:option value="M" label="M" />
					<form:option value="ND" label="ND" />
				</form:select><br>
			</span>
		</div>
		<span> Date Of Birth: <form:input path="dob" type="date"
				data-date-inline-picker="false" data-date-open-on-focus="true"
				placeholder="(YYYY/MM/DD)" />
		</span>
		<span> PAN Number: <form:input path="panNum" /><br>
		</span>
		<div>
			<span> Aadhaar Number: <form:input path="aadhaarNum" />
			</span> <span> MobileNumber: <form:input path="mobileNum" /><br>
			</span>
		</div>
		<div>
			<span> Email ID: <form:input path="emailId" />
			</span> <span> Office Email: <form:input path="officeMail" /><br>
			</span>
		</div>
		<div>
			<span> Permanent Address: <form:input path="permanantAddresss" />
			</span> <span> Present Address: <form:input path="presentAddresss" /><br>
			</span>
		</div>
		<div>
			<span> Blood Group: <form:input path="bloodGroup" />
			</span> <span> Date Of Joining: <form:input path="doj" type="date"
					data-date-inline-picker="false" data-date-open-on-focus="true"
					placeholder="(YYYY/MM/DD)" /><br>
			</span>
		</div>
		<div>
			<span>Employee Level: <form:select path="emp_Level">
					<form:option value="1" label="1" />
					<form:option value="2" label="2" />
					<form:option value="3" label="3" />
					<form:option value="4" label="4" />
					<form:option value="5" label="5" />
					<form:option value="6" label="6" />
				</form:select></span> <span> Post Name: <form:input path="post_name" /><br>
			</span>
		</div>
		<div>
			<span> Basic Pay: <form:input path="basicPay" />
			</span> <span> Home Allowance: <form:input path="houseAllowance" /><br>
			</span>
		</div>
		<div>
			<span><button type="submit">Submit</button></span> <span><button
					type="reset">Cancel</button></span>
		</div>
		<div>
			<span><form:errors path="empId" cssClass="error"></form:errors></span><br>
			<span><form:errors path="firstName" cssClass="error"></form:errors></span><br>
			<span><form:errors path="lastName" cssClass="error"></form:errors></span><br>
			<span><form:errors path="gender" cssClass="error"></form:errors></span><br>
			<span><form:errors path="dob" cssClass="error"></form:errors></span><br>
			<span><form:errors path="panNum" cssClass="error"></form:errors></span><br>
			<span><form:errors path="aadhaarNum" cssClass="error"></form:errors></span><br>
			<span><form:errors path="mobileNum" cssClass="error"></form:errors></span><br>
			<span><form:errors path="emailId" cssClass="error"></form:errors></span><br>
			<span><form:errors path="officeMail" cssClass="error"></form:errors></span><br>
			<span><form:errors path="permanantAddresss" cssClass="error"></form:errors></span><br>
			<span><form:errors path="presentAddresss" cssClass="error"></form:errors></span><br>
			<span><form:errors path="bloodGroup" cssClass="error"></form:errors></span><br>
			<span><form:errors path="doj" cssClass="error"></form:errors></span><br>
			<span><form:errors path="emp_Level" cssClass="error"></form:errors></span><br>
			<span><form:errors path="post_name" cssClass="error"></form:errors></span><br>
			<span><form:errors path="basicPay" cssClass="error"></form:errors></span><br>
			<span><form:errors path="houseAllowance" cssClass="error"></form:errors></span><br>

		</div>

	</form:form>

</body>
</html>

