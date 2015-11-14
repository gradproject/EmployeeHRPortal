<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee HR Portal - Current Projects</title>

</head>
<body>
<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>Current Projects</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">Projects  Information</h3>

						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-stripped">
									<thead>
										<tr>
											<th>Project Id</th>
											<th>Project Name</th>
											<th>Project Status</th>
											<th>Manager</th>
											<th>Description</th>
											<th>Total Cost</th>
											<th>Approve TimeSheet</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${projectList}" var="prj">
											<tr>

												<td><c:out value="${prj.projectId}" /></td>
												<td><c:out value="${prj.projectName}" /></td>
												<td><c:out value="${prj.projectStatus}" /></td>
												<td><c:out value="${prj.empId}" /></td>
												<td><c:out value="${prj.description}" /></td>
												<td><c:out value="${prj.totalCost}" /></td>
												<td><a href="/EmployeeHRPortal/ListUnApprovedTimeSheets?projectId=<c:out value="${ prj.projectId}"/>">Approve Time Sheet</a></td>
												
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