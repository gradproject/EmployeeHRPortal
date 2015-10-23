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

<title>OnCampusJobsPortal- Applied Jobs</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<%@ include file="includes/messagePopup.jsp"%>

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3> Applied Jobs </h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<form action="/OnCampusJobsPortal/AppliedJobsListServlet">
		<table cellspacing="0" border="1" cellpadding="5px" width="100%">
			<tr  style="background-color: #eee">
				<th>Job Id</th>
				<th>Job Title</th>
				<th>Department</th>
				<th>Contact Information</th>
				<th>How to apply</th>
			</tr>
			<c:forEach items="${jobsApplied}" var="jobs">
				<tr>
					<td><c:out value="${jobs.jobId}" /></td>
					<td><c:out value="${jobs.jobTitle}" /></td>
					<td><c:out value="${jobs.department}" /></td>
					<td><c:out value="${jobs.contactInformation}" /></td>
					<td><c:out value="${jobs.howToApply}" /></td>
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

	