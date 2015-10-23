<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String jobPostingsJspVersion = "1";
%>

<!DOCTYPE html>
<html lang="en">
<head>

<%@ include file="includes/headerIncludes.jsp"%>

<title>SampleWebApp - Create Job Opening</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<%@ include file="includes/messagePopup.jsp"%>

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>Create Job Opening</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">Job Information</h3>
						</div>

						<div class="panel-body">

							<form id="jobPostingsForm" name="jobPostingsForm"
								action="/OnCampusJobsPortal/JobPostingsServlet" method="post"
								role="form">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Department</label>
											</div>
											<div class="col-sm-12  pull-left">
												<select id="department" name="department"
													class="form-control pull-left input-sm" required="required" >
													<option
														<c:if test="${fn:contains(department, 'Arts')}">selected</c:if>
														value="Arts">Arts</option>
													<option
														<c:if test="${fn:contains(department, 'Biology')}">selected</c:if>
														value="Biology">Biology</option>
													<option
														<c:if test="${fn:contains(department, 'Chemistry')}">selected</c:if>
														value="Chemistry">Chemistry</option>
													<option
														<c:if test="${fn:contains(department, 'Commerce')}">selected</c:if>
														value="Commerce">Commerce</option>
													<option
														<c:if test="${fn:contains(department, 'Computer Science')}">selected</c:if>
														value="Computer Science">Computer Science</option>
													<option
														<c:if test="${fn:contains(department, 'Mathematics')}">selected</c:if>
														value="Mathematics">Mathematics</option>
													<option
														<c:if test="${fn:contains(department, 'Other')}">selected</c:if>
														value="Other">Other</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Job
													Title</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input type="text" id="jobTitle" name="jobTitle" value="<c:out value="${jobTitle}"/>"
													class="form-control fixed_size_inputs input-sm"
													maxlength="100" required="required" />
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group pull-left">
										<div class="col-sm-12  pull-left">
											<label class="control-label" for="inputUserType1">Job
												Description</label>
										</div>
										<div class="col-md-8 pull-left">
											<textarea id="jobDescription" maxlength="500"
												name="jobDescription"
												class="col-md-12 input-xxlarge" required="required" ><c:out value="${jobDescription}"/></textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Job
													Requirements</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input type="text" id="jobRequirements"
													name="jobRequirements" value="<c:out value="${jobRequirements}"/>"
													class="form-control fixed_size_inputs input-sm" maxlength="200" required="required" />
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Job
													Function</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input type="text" id="jobFunction" name="jobFunction"
													value="<c:out value="${jobFunction}"/>" class="form-control fixed_size_inputs input-sm" maxlength="200" required="required" />
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-8">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Documents
													Required</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input type="text" id="documentsRequired"
													name="documentsRequired" value="<c:out value="${documentsRequired}"/>"
													class="form-control fixed_size_inputs input-sm" maxlength="150" required="required" />
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group pull-left">
										<div class="col-sm-12  pull-left">
											<label class="control-label" for="inputUserType1">Contact
												Information</label>
										</div>
										<div class="col-md-8 pull-left">
											<textarea id="contactInformation"  maxlength="800" name="contactInformation"
												 class="col-md-12 input-xxlarge" required="required" ><c:out value="${contactInformation}"/></textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">How
													To Apply</label>
											</div>
											<div class="col-sm-12  pull-left">
												<select type="text" id="howToApply" name="howToApply"
													value="" class="form-control pull-left input-sm" required="required" >
													
													<option <c:if test="${fn:contains(howToApply, 'Email')}">selected</c:if> value="Email">Email</option>
													<option <c:if test="${fn:contains(howToApply, 'Mail')}">selected</c:if> value="Mail">Mail</option>
													<option <c:if test="${fn:contains(howToApply, 'Online')}">selected</c:if> value="Online">Online</option>
													<option <c:if test="${fn:contains(howToApply, 'Office')}">selected</c:if> value="Office">Office</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-4"></div>
									<div class="col-md-8">
										<div class="form-group fixed_size_inputs pull-right">
											<button type="submit"
												class="col-sm-12 btn btn-success btn-sm">Submit</button>
										</div>
									</div>
								</div>
							</form>

						</div>

					</div>

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