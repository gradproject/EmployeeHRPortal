<%@ page language="java" contentType="text/html"%>
<%@ page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<%
String failureMessage = (String) request.getAttribute("failureMessage");
if(failureMessage == null){
	failureMessage = "";
	
}
%>
<!DOCTYPE html>
<html>
<head>
	<title>Employee Page</title>
	 <script>
		function validateEmplyeeForm(){
			alert("function validateEmplyeeForm started :: ");
			var empId = document.getElementById("empId").value;
			var empFirstName = document.getElementById("empFirstName").value;
			var empMiddleName = document.getElementById("empMiddleName").value;
			var empLastName = document.getElementById("empLastName").value;
			var empEmailId = document.getElementById("empEmailId").value;
			var PhoneNumber = document.getElementById("phoneNumber").value;
			var deptId = document.getElementById("deptId").value;
			var empDesg = document.getElementById("empDesg").value;
			var empExp = document.getElementById("empExp").value;
				if((empId === null || empId === "" )||(empFirstName === null || empFirstName === "")||(empMiddleName === null || empMiddleName === "")||(empLastName === null || empLastName === "")||(empEmailId === null || empEmailId === "")||(phoneNumber === null || phoneNumber === "")||(deptId === null || deptId === "")||(empDesg === null || empDesg === "")||(empExp === null || empExp === "") ){
				alert("Please enter all fields");
				return false;
				}
		}
	</script>
</head>
<body>
<div id="messageDiv" ><%=failureMessage%>
</div>
	<form name="employeeForm" action="/EmployeeHRPortal/EmployeeServlet" onsubmit="return validateEmplyeeForm()" method="post">
	<table cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td>Employee Id   ::</td>
			<td><input type="text" name="empId" id="empId" /></td>
		</tr>
		<tr>	
			<td>Employee First Name ::</td>
			<td><input type="text" name="empFirstName" id="empFirstName" /></td>
		</tr>
		<tr>	
			<td>Employee Middle Name ::</td>
			<td><input type="text" name="empMiddleName" id="empMiddleName" /></td>
		</tr>
		<tr>	
			<td>Employee Last Name ::</td>
			<td><input type="text" name="empLastName" id="empLastName" /></td>
		</tr>
		<tr>
			<td>Employee Email Id   ::</td>
			<td><input type="text" name="empEmailId" id="empEmailId" /></td>
		</tr>
		<tr>
			<td>Phone Number :: </td>
			<td><input type="text" name="phoneNumber" id="phoneNumber"/></td>
		</tr>
		<tr>
			<td>Department Id   ::</td>
			<td>
				<select name="deptId" id="deptId">
				<!--  the c forEach tag is accepting the list object through items attribute
						it is iterating the data over the list and then storing each object in the department variable  -->
					<c:forEach items="${deptList}" var="dept">
						<option value="<c:out value ="${dept.deptId}"/>"><c:out value ="${dept.deptName}"/></option>
					</c:forEach>
				</select>
			</td>
			
		</tr>
		<tr>
			<td>Employee Desgination ::</td>
			<td><input type="text" name="empDesg" id="empDesg" /></td>
		</tr>
		<tr>
			<td>Employee Experience ::</td>
			<td><input type="text" name="empExp" id="empExp" /></td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" id="submit" value="Create"/></td>
		</tr>
	</table>		
	</form>
</body>
</html>