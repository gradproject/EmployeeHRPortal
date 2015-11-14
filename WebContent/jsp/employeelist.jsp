<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee HR Portal - List Employees</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>List of Employees</h3>

				</div>

				<div class="clearfix"></div>
				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">Employees Information</h3>

						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-stripped">
									<thead>
										<tr>
											<c:if test="${fn:contains(sessionScope.role, 'admin')}">
												<th>Employee Id</th>
											</c:if>
											<th>Employee First Name</th>
											<th>Employee Middle Name</th>
											<th>Employee Last Name</th>
											<th>Email Id</th>
											<th>Phone Number</th>
											<th>Deptartment</th>
											<th>Employee Desgination</th>
											<th>Employee Experience</th>
											<th>Role</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach items="${empList}" var="emp">
											<tr>
												<c:if test="${fn:contains(sessionScope.role, 'admin')}">
													<td><a
														href="/EmployeeHRPortal/AssignEmployeeDeptData?empId=<c:out value ="${emp.empId}"/>"><c:out
																value="${emp.empId}" /></a></td>
												</c:if>
												<td><c:out value="${emp.empFirstName}" /></td>
												<td><c:out value="${emp.empMiddleName}" /></td>
												<td><c:out value="${emp.empLastName}" /></td>
												<td><c:out value="${emp.empEmailId}" /></td>
												<td><c:out value="${emp.phoneNumber}" /></td>
												<td><c:out value="${emp.deptId}" /></td>
												<td><c:out value="${emp.empDesg}" /></td>
												<td><c:out value="${emp.empExp}" /></td>
												<td><c:out value="${emp.roleId}" /></td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /col -->

					</div>
					<!-- /row -->

				</div>
				<!-- /container -->
			</div>
		</div>
	</div>
	<%@ include file="includes/footer.jsp"%>
</body>
</html>