<%@ page contentType="text/html"%>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<title>Department Page</title>
	<script>
		function validateDepartmentForm(){
			alert("Department Form validation started :: ");
			var deptName = document.getElementById("deptName").value;
			var deptId = document.getElementById("deptId").value;
			if((deptName === null || deptName === "")||(deptId === null || deptId === "")){
			alert("Please enter both department name and department id :: ");
			return false;
			}
		}
	</script>
</head>
<body>
	<form name="departmentForm" action="/EmployeeHRPortal/DepartmentServlet" onsubmit="return validateDepartmentForm()" method="post">
	<table cellspacing="0" cellpadding="0" border="0">
		<tr>	
			<td>Department Name ::</td>
			<td><input type="text" name="deptName" id="deptName" /></td>
		</tr>
		<tr>
			<td>Department Id   ::</td>
			<td><input type="text" name="deptId" id="deptId" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"/></td>
		</tr>
	</table>		
	</form>
</body>
</html>