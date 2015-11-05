<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String loginJspVersion = "1";
%>
<!DOCTYPE html>
<html lang="en">
<head>

<%@ include file="includes/header.jsp"%>

<title>Employee HR Portal - Admin Login</title>

</head>

<body style="background-color: #eee;">

	<%@ include file="includes/navBar.jsp"%>

	<div class="container">

		<%@ include file="includes/messagePopup.jsp"%>

		<div class="row" style="padding-top: 100px;">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong class="">Admin Login</strong>

					</div>
					<div class="panel-body">
						<form id="adminloginForm" name="adminloginForm"
							action="/EmployeeHRPortal/AdminLoginServlet" method="post"
							class="form-horizontal" role="form">
							<div class="form-group">
								<div class="col-sm-9">
									<div data-toggle="buttons" class="btn-group">
										<!-- 										<label -->
										<%-- 											class="col-sm-6 btn btn-primary <c:if test="${fn:contains(userType, 'Employee')}">active</c:if>"> --%>
										<!-- 											<input type="radio" id="inputUserType1" name="userType" -->
										<%-- 											<c:if test="${fn:contains(userType, 'Employee')}">checked="checked"</c:if> --%>
										<!-- 											value="Employee" required="required" /> Employee -->
										<!-- 										</label>  -->
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="inputUserId3" class="col-sm-3 control-label">Admin
									User Name</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="inputUserId3"
										name="adminUserName" value=""
										required="required" maxlength="50" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword4" class="col-sm-3 control-label">Password</label>
								<div class="col-sm-6">
									<input type="password" class="form-control" id="inputPassword4"
										name="adminPassword" value="" required="required"
										maxlength="20" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9"></div>
							</div>
							<div class="form-group last">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-success btn-sm">Login</button>
<!-- 									<button type="reset" class="btn btn-default btn-sm">Reset</button> -->
								</div>
							</div>
						</form>
					</div>
					<!-- <div class="panel-footer">
						Not Registered? <a href="/EmployeeHRPortal/jsp/employee.jsp"
							class="">Register here</a>
					</div>-->
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>

	</div>
	<!-- /container -->

	<%@ include file="includes/footer.jsp"%>
</body>
</html>