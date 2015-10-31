<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee HR Portal - List Employee TimeSheet</title>

</head>
<body>
<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>List Employee TimeSheet</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">Employee TimeSheet Project
								Information</h3>

						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-stripped">
									<thead>
										<tr>
											<th>Employee Id</th>
											<th>Project Name</th>
											<th>Date</th>
											<th>Work Hours</th>
											<th>Approved</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${timeSheetList}" var="timeSheet">
											<tr>

												<td><c:out value="${timeSheet.empId}" /></td>
												<td><c:out value="${timeSheet.projectId}" /></td>
												<td><c:out value="${timeSheet.date}" /></td>
												<td><c:out value="${timeSheet.workHours}" /></td>
												<td><c:out value="${timeSheet.approved}" /></td>
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