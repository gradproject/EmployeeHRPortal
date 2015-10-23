<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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

<title>OnCampusJobsPortal- Job Listing</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<%@ include file="includes/messagePopup.jsp"%>

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>Job Listing</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>
				<form action="/OnCampusJobsPortal/AppliedJobsListServlet">
					<div id="jobListingsDataDiv" name="jobListingsDataDiv">
						<!-- Begin -->

						<table id="jobListingsTable" name="jobListingsTable"
							class="display" cellpadding="5px" cellspacing="0" width="100%" border="1">
							<thead>
								<tr style="background-color: #eee">
								<c:if test="${fn:contains(sessionScope.userType, 'Student')}">
									<th>
										&nbsp;
									</th>
								</c:if>	
									<th>Job Title</th>
									<th>Department</th>
									<th>Job Description</th>
									<!-- <th>Job Function</th>
									<th>Job Requirements</th>
									<th>Documents Required</th>-->
									<th>Contact Information</th>
									<th>How to Apply</th>
									<c:if test="${fn:contains(sessionScope.userType, 'Employee')}">
									<th>&nbsp;</th>
									</c:if>
								</tr>
							</thead>
							<tfoot>
								<tr style="background-color: #eee">
								<c:if test="${fn:contains(sessionScope.userType, 'Student')}">
									<th>
										&nbsp;
									</th>
								</c:if>	
									<th>Job Title</th>
									<th>Department</th>
									<th>Job Description</th>
									<!-- <th>Job Function</th>
									<th>Job Requirements</th>
									<th>Documents Required</th>-->
									<th>Contact Information</th>
									<th>How to Apply</th>
									<c:if test="${fn:contains(sessionScope.userType, 'Employee')}">
										<th>&nbsp;</th>
									</c:if>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${jobsList}" var="job">
																				<tr>
																				<c:if test="${fn:contains(sessionScope.userType, 'Student')}">
																					<td>
																						<input type="checkbox" id="jobIds" name="jobIds"
																						 	
																						 value="<c:out value ="${job.jobId}"/>" style="margin-right:10px;"/>
																					</td>
																				</c:if>	
																					<td>	 
																						 <c:out value ="${job.jobTitle}"/>
																					</td>
																					<td>
																						<c:out value ="${job.department}"/>
																					</td>
																					<td>
																						<c:out value ="${job.jobDescription}"/>
																					</td>
																					
																					<!-- <td>
																						<c:out value ="${job.jobFunction}"/>
																					</td>
																					<td>
																						<c:out value ="${job.jobRequirements}"/>
																					</td>
																					<td>
																						<c:out value ="${job.documentsRequired}"/>
																					</td>-->
																					<td>
																						<c:out value ="${job.contactInformation}"/>
																					</td> 
																					<td>
																						<c:out value ="${job.howToApply}"/>
																					</td>
																					<c:if test="${fn:contains(sessionScope.userType, 'Employee')}">
																					<td>
																						<a href="/OnCampusJobsPortal/AppliedStudentsListServlet?jobId=<c:out value ="${job.jobId}"/>&jobTitle=<c:out value ="${job.jobTitle}"/>">list applicants</a>
																					</td>
																					</c:if>
																				</tr>
																			</c:forEach>
																			</tbody>
						</table>
						<!-- End -->
					</div>
					<c:if test="${fn:contains(sessionScope.userType, 'Student')}">
					<div class="row">
						<div class="col-md-4">
							<p
								style="padding-left: 0%; padding-right: 25%; padding-top: 40px;">
								<button type="submit" class="btn btn-primary btn-sm">Apply &raquo;</button>
								
							</p>
						</div>
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
					</div>
					</c:if>
				</form>
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