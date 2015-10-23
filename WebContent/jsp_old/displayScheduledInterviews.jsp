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

<title>OnCampusJobsPortal- Scheduled Interviews</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<%@ include file="includes/messagePopup.jsp"%>

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>Scheduled Interviews</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<form action="/OnCampusJobsPortal/AppliedJobsListServlet">
					<table cellspacing="0" cellpadding="5" border="1" width="100%">
						<tr style="background-color: #eee">
							<th>User Id</th>
							<th>Interview Date</th>
							<th>Interview Time Hour</th>
							<th>Interview Time Minutes</th>
							<th>Interview Time AM/PM</th>
							<th>Location</th>
							<th>Requirements</th>
							<th>Job Id</th>
							<th>Job Title</th>

						</tr>
						<c:forEach items="${listOfInterviews}" var="interview">
							<tr>
								<td><c:out value="${interview.userId}" /></td>
								<td><c:out value="${interview.interviewDate}" /></td>
								<td><c:out value="${interview.hour}" /></td>
								<td><c:out value="${interview.minutes}" /></td>
								<td><c:out value="${interview.amPm}" /></td>
								<td><c:out value="${interview.location}" /></td>
								<td><c:out value="${interview.requirements}" /></td>
								<td><c:out value="${interview.jobId}" /></td>
								<td><c:out value="${interview.jobTitle}"/></td>

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