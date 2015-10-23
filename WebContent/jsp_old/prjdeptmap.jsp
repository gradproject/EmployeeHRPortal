<%@ page language="java" contentType="text/html"%>
<%@ page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
<head>
	<title>Project Department Map Page</title>
	
</head>
<body>
	<form name="prjDeptMapForm" action="/EmployeeHRPortal/ProjDeptServlet" onsubmit="return validatePrjDeptMapForm()" method="post">
	<table cellspacing="0" cellpadding="0" border="0">
	
		<tr>
			<td>Project Id   ::</td>
			<td>
				<select name="prjId" id="prjId" >
					<c:forEach items="${prjList}" var="prj">
						<option value="<c:out value="${prj.projectId}"/>" ><c:out value="${prj.projectName}" /></option>
					</c:forEach>
				</select>
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
			<td>Hours Allocated :: </td>
			<td><input type="text" name="hoursAllocated" id="hoursAllocated"/></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Submit"/></td>
		</tr>
	</table>		
	</form>
</body>
</html>