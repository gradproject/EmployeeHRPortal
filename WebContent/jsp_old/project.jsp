<%@ page contentType="text/html"%>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<title>Project Page</title>
	<script>
		function validateProjectForm(){
			alert("Project form validation started :: ");
			var prjName = document.getElementById("prjName").value;
			var prjId = document.getElementById("prjId").value;
			if((prjName === null || prjName === "")||(prjId === null || prjId === "")){
			alert("Please enter both projeact name and project id :: ");
			return false;
			}
			
		}
	</script>
</head>
<body>
	<form name="projectForm" action="/EmployeeHRPortal/ProjectServlet" onsubmit="return validateProjectForm()" method="post">
	<table cellspacing="0" cellpadding="0" border="0">
		<tr>	
			<td>Project Name ::</td>
			<td><input type="text" name="prjName" id="prjName" /></td></tr>
		<tr>
			<td>Project Id   ::</td>
			<td><input type="text" name="prjId" id="prjId" /></td></tr>
		<tr>	
			<td><input type="submit" value="Submit" /></td></tr>
	</table>		
	</form>
</body>
</html>