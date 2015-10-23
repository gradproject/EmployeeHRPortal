<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<jsp:useBean id="employee" class="com.gsu.bean.Employee"/>
<jsp:setProperty name="emp" property="*" />
<%
String failureMessage = (String) request.getAttribute("failureMessage");
if(failureMessage == null){
	failureMessage = "";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div value="successMessageDiv"><%=failureMessage %>
</div>
	<form name="employeeForm" action="/EmployeeHRPortal/EmployeeServlet" onsubmit="return validateEmplyeeForm()" method="post">
	<table cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td>Employee Id   ::</td>
			<td><input type="text"  name="empId" id="empId" value="${emp.empId}"/></td>
		</tr>
		<tr>	
			<td>Employee First Name ::</td>
			<td><input type="text" name="empFirstName" id="empFirstName" value="${emp.empFirstName}"/></td>
		</tr>
		<tr>	
			<td>Employee Middle Name ::</td>
			<td><input type="text"  name="empMiddleName" id="empMiddleName" value="${emp.empMiddleName}"/></td>
		</tr>
		<tr>	
			<td>Employee Last Name ::</td>
			<td><input type="text"  name="empLastName" id="empLastName" value="${emp.empLastName}" /></td>
		</tr>
		<tr>
			<td>Employee Email Id   ::</td>
			<td><input type="text"  name="empEmailId" id="empEmailId" value="${emp.empEmailId}" /></td>
		</tr>
		<tr>
			<td>Phone Number :: </td>
			<td><input type="text" name="phoneNumber" id="phoneNumber" value="${emp.phoneNumber}"/></td>
		</tr>
		<tr>
			<td>Department Id   ::</td>
			<td>
				<select name="deptId" id="deptId" value="${emp.deptId}">
				<!--  the c forEach tag is accepting the list object through items attribute
						it is iterating the data over the list and then storing each object in the department variable  -->
					<c:forEach items="${deptList}" var="dept">
						<option value="<c:out value ="${dept.deptId}"/>"  <c:if test="${fn:contains(emp.deptId, dept.deptId)}">selected</c:if>><c:out value ="${dept.deptName}"/></option>
					</c:forEach>
				</select>
			</td>
			
		</tr>
		<tr>
			<td>Employee Desgination ::</td>
			<td><input type="text" name="empDesg" id="empDesg" value="${emp.empDesg}" /></td>
		</tr>
		<tr>
			<td>Employee Experience ::</td>
			<td><input type="text" name="empExp" id="empExp" value="${emp.empExp}" /></td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" id="submit" value="Update"/></td>
		</tr>
	</table>		
	</form>
</body>
</html>