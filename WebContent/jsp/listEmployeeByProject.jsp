<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee HR Portal - List Employee By Project</title>

</head>
<body>
<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>List Employee By Project</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">Project Employee Information</h3>

						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-stripped">
									<thead>
										<tr>
											<th>Employee Id</th>
											<th>Employee First Name</th>
											<th>Employee Middle Name</th>
											<th>Employee Last Name</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${employeeList}" var="emp">
											<tr>

												<td><c:out value="${emp.empId}" /></td>
												<td><c:out value="${emp.empFirstName}" /></td>
												<td><c:out value="${emp.empMiddleName}" /></td>
												<td><c:out value="${emp.empLastName}" /></td>
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