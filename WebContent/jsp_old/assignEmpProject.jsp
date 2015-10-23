<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Employee Project</title>
</head>
<body>
	<form name="" action="/EmployeeHRPortal/AssignEmployeeProject" onsubmit="" method="post">
		<table cellspacing="0" cellpadding="0" border="0">

			<tr>
				<td>Employee Id ::</td>
				<td><select name="empId" id="empId">
						<c:forEach items="${empList}" var="emp">
							<option value="<c:out value ="${emp.empId}"/>"><c:out
									value="${emp.empId}" /></option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Department Id ::</td>
				<td><select name="deptId" id="deptId">
						<!--  the c forEach tag is accepting the list object through items attribute
						it is iterating the data over the list and then storing each object in the department variable  -->
						<c:forEach items="${deptList}" var="dept">
							<option value="<c:out value ="${dept.deptId}"/>"><c:out
									value="${dept.deptId}" /></option>
						</c:forEach>
				</select></td>

			</tr>
			<tr>
				<td>Project Id ::</td>
				<td><select name="prjId" id="prjId">
						<c:forEach items="${prjList}" var="prj">
							<option value="<c:out value="${prj.projectId}"/>"><c:out
									value="${prj.projectName}" /></option>
						</c:forEach>
				</select>
			</tr>
			<tr>
			</tr>
			<tr>
			<td><input type="submit" value="Enter"/></td>
			</tr>
		</table>
	</form>

</body>
</html>