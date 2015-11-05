<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee HR Portal - UnApproved TimeSheet List </title>

</head>
<body>
<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>UnApproved TimeSheet List</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">UnApproved TimeSheet Information</h3>

						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-stripped">
									<thead>
										<tr>
											<th>Project Id</th>
											<th>Employee Full Name</th>
											<th>Employee Id</th>
											<th>Date</th>
											<th>Total Work Hours</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${timesheetList}" var="timesheet">
											<tr>

												<td><c:out value="${timesheet.projectId}" /></td>
												<td><c:out value="${timesheet.empFullName}" /></td>
												<td><c:out value="${timesheet.empId}" /></td>
												<td><c:out value="${timesheet.date}" /></td>
												<td><c:out value="${timesheet.workHours}" /></td>
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