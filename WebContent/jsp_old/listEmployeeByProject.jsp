<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Employee by Project</title>
</head>
<body>
	<table cellspacing="0" cellpadding="0" border="1">
		<tr>
			<th>Employee Id</th>
			<th>Employee First Name</th>
			<th>Employee Middle Name</th>
			<th>Employee Last Name</th>

		</tr>
		<c:forEach items="${employeeList}" var="emp">
			<tr>
				
				<td><c:out value="${emp.empId}" /></td>
				<td><c:out value="${emp.empFirstName}" /></td>
				<td><c:out value="${emp.empMiddleName}" /></td>
				<td><c:out value="${emp.empLastName}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>