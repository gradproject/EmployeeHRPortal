<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String jobListingsJspVersion = "1";
%>

<!DOCTYPE html>
<html lang="en">
<head>

<%@ include file="includes/headerIncludes.jsp"%>

<!-- jQuery datatable css -->
<link rel="stylesheet" type="text/css"
	href="/OnCampusJobsPortal/css/jquery.dataTables.css">

<title>OnCampusJobsPortal- Applied Students</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<%@ include file="includes/messagePopup.jsp"%>

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>Applied Students</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<form action="/OnCampusJobsPortal/AppliedJobsListServlet">
					<table cellspacing="0" border="1" cellpadding="5px">
						<tr style="background-color: #eee">
							<th>User Id</th>
							<th>User Name</th>
							<th>Status of Visa</th>
							<th>Start Year Of Course</th>
							<th>Expected Graduate Year</th>
							<th>Enrolled Credit Hours</th>
							<th>Student Status</th>
							<th>Major</th>
							<th>Skills</th>
							<th></th>
						</tr>
						<c:forEach items="${studentListAttribute}" var="student">
							<tr>
								<td><c:out value="${student.userId}" /></td>
								<td><c:out value="${student.name}" /></td>
								<td><c:out value="${student.statusOfVisa}" /></td>
								<td><c:out value="${student.startYearOfCourse}" /></td>
								<td><c:out value="${student.endYearOfCourse}" /></td>
								<td><c:out value="${student.enrolledCreditHours}" /></td>
								<td><c:out value="${student.studentStatus}" /></td>
								<td><c:out value="${student.major}" /></td>
								<td><c:out value="${student.skills}" /></td>
								<td><a
									href="/OnCampusJobsPortal/jsp/interviewSchedule.jsp?userId=<c:out value="${student.userId}" />&jobId=<c:out value="${jobIdA}"/>&userName=<c:out value="${student.name}" />&jobTitle=<c:out value="${jobTitleA}"/>">Schedule
										Interview</a></td>
							</tr>
						</c:forEach>

					</table>
				</form>

				<div class="row">
					<div class="col-md-4">
						<p
							style="padding-left: 0%; padding-right: 25%; padding-top: 40px;">

						</p>
					</div>
					<div class="col-md-4"></div>
					<div class="col-md-4"></div>
				</div>
			</div>
			<!-- /col -->

		</div>
		<!-- /row -->

	</div>
	<!-- /container -->

	<%@ include file="includes/footer.jsp"%>

	<%@ include file="includes/javaScriptIncludes.jsp"%>
</body>
</html>