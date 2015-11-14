<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee HR Portal - List Departments</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>List of Departments</h3>

				</div>

				<div class="clearfix"></div>
				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">Departments Information</h3>

						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-stripped">
									<thead>
										<tr>
											<th>Department Id</th>
											<th>Department Name</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${deptList}" var="dept">
											<tr>
												<td><a
													href="/EmployeeHRPortal/ListEmployeeByDepartment?deptId=<c:out value ="${dept.deptId}"/>"><c:out
															value="${dept.deptId}" /></a></td>
												<td><c:out value="${dept.deptName}" /></td>

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