<%@ page language="java" contentType="text/html"%>
<%@ page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Time Sheet</title>
</head>
<body>
	<form name="" action="/EmployeeHRPortal/EnterTimeSheet" onSubmit="" method="post">
		<table cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td>Employee Id ::</td>
				<td><input type="text" name="empId" id="empId" /></td>
			</tr>
			<tr>
				<td>Project Id ::</td>
				<td><input type="text" name="projectId" id="projectId" /></td>
			</tr>
			<tr>
				<td>Date ::</td>
				<td><input type="text" name="date" id="date" /></td>
			</tr>
			<tr>
				<td>Work Hours ::</td>
				<td><input type="text" name="workHours" id="workHours" /></td>
			</tr>
			<tr>
				<td>Approved ::</td>
				<td><input type="text" name="approved" id="approved" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enter" /></td>
			</tr>
		</table>
	</form>
</body>
</html>