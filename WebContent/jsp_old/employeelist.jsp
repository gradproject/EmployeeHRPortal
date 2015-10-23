<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%
String successMessage = (String) request.getAttribute("successMessage");
if(successMessage == null){
	successMessage = "";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
<div id="messageDiv" ><%=successMessage%>
</div>
	<table cellspacing="0" cellpadding="0" border="1">
	
	
			
		<tr>
			<th>Employee Id</th>
			<th>Employee First Name</th>
			<th>Employee Middle Name</th>
			<th>Employee Last Name</th>
			<th>Email Id</th>
			<th>Phone Number </th>
			<th>Deptartment Id </th>
			<th>Employee Desgination</th>
			<th>Employee Experience</th>
		</tr>
		<c:forEach items="${empList}" var="emp">
		<tr>
			<td><a href="/EmployeeHRPortal/AssignEmployeeDeptData?empId=<c:out value ="${emp.empId}"/>" ><c:out value ="${emp.empId}"/></a></td>
			<td><c:out value ="${emp.empFirstName}"/></td>
			<td><c:out value ="${emp.empMiddleName}"/></td>
			<td><c:out value ="${emp.empLastName}"/></td>
			<td><c:out value ="${emp.empEmailId}"/></td>
			<td><c:out value ="${emp.phoneNumber}"/></td>
			<td><c:out value ="${emp.deptId}"/></td>
			<td><c:out value ="${emp.empDesg}"/></td>
			<td><c:out value ="${emp.empExp}"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>