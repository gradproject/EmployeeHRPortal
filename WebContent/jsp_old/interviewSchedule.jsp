<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String registrationJspVersion = "1";
%>


<!DOCTYPE html>
<html lang="en">
<head>

<%@ include file="includes/headerIncludes.jsp"%>

<title>SampleWebApp - Registration</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<%@ include file="includes/messagePopup.jsp"%>
		
		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>Schedule Interview Appointment</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix" style="padding-top: 15px;"></div>

				<div class="row">
					<div class="col-md-12 form-horizontal pull-left">
						<div class="col-sm-3  pull-left">
							<label class="control-label" for="inputUserType1">Applicant
								Name : </label>
						</div>
						<div class="col-sm-5  pull-left">
							<label class="control-label" for="inputUserType1"><c:out
									value="${param['userName']}" /></label>
						</div>
						<div class="col-sm-4  pull-left"></div>
					</div>
				</div>

				<div class="clearfix"></div>

				<div class="row">
					<div class="col-md-12 form-horizontal pull-left">
						<div class="col-sm-3  pull-left">
							<label class="control-label" for="inputUserType1">Job
								Title : </label>
						</div>
						<div class="col-sm-5  pull-left">
							<label class="control-label" for="inputUserType1"><c:out
									value="${param['jobTitle']}" /></label>
						</div>
						<div class="col-sm-4  pull-left"></div>
					</div>
				</div>

				<div class="clearfix"
					style="padding-top: 15px; padding-bottom: 15px;"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">Appointment Information</h3>
						</div>

						<div class="panel-body">

							<form id="InterviewScheduling" name="InterviewScheduling"
								action="/OnCampusJobsPortal/InterviewScheduleServlet"
								method="post" role="form">
								<input type="hidden" name="userId" id="userId"
									value="<c:out value="${param['userId']}" />" /> <input
									type="hidden" name="jobId" id="jobId"
									value="<c:out value="${param['jobId']}" />" /> <input
									type="hidden" name="userName" id="userName"
									value="<c:out value="${param['userName']}" />" /> <input
									type="hidden" name="jobTitle" id="jobTitle"
									value="<c:out value="${param['jobTitle']}" />" />
								<div class="row">
									<div class="col-md-8">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Requirements</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input type="text" id="requirements" name="requirements"
													value="<c:out value="${requirements}"/>"
													class="form-control fixed_size_inputs input-sm"
													maxlength="250" required="required" />
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Interview
													Date</label>
											</div>
											<div class="col-sm-12  pull-left">
												<div class="form-group">
									                <div class="input-group date" id="interviewDatePicker">
									                    <input type="text" name="interviewDate"
																						value="<c:out value="${interviewDate}"/>"
																						id="interviewDate"
																						class="form-control fixed_size_inputs input-sm"
																						maxlength="10" required="required" placeholder="YYYY-MM-DD" data-date-format="YYYY-MM-DD"/>
									                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
									                    </span>
									                </div>
									            </div>
											</div>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Hour</label>
											</div>
											<div class="col-sm-12  pull-left">
												<select id="hour" name="hour"
													class="form-control pull-left input-sm" required="required">
													<option
														<c:if test="${fn:contains(hour, '1')}">selected</c:if>
														value="1">1</option>
													<option
														<c:if test="${fn:contains(hour, '2')}">selected</c:if>
														value="2">2</option>
													<option
														<c:if test="${fn:contains(hour, '3')}">selected</c:if>
														value="3">3</option>
													<option
														<c:if test="${fn:contains(hour, '4')}">selected</c:if>
														value="4">4</option>
													<option
														<c:if test="${fn:contains(hour, '5')}">selected</c:if>
														value="5">5</option>
													<option
														<c:if test="${fn:contains(hour, '6')}">selected</c:if>
														value="6">6</option>
													<option
														<c:if test="${fn:contains(hour, '7')}">selected</c:if>
														value="7">7</option>
													<option
														<c:if test="${fn:contains(hour, '8')}">selected</c:if>
														value="8">8</option>
													<option
														<c:if test="${fn:contains(hour, '9')}">selected</c:if>
														value="9">9</option>
													<option
														<c:if test="${fn:contains(hour, '10')}">selected</c:if>
														value="10">10</option>
													<option
														<c:if test="${fn:contains(hour, '11')}">selected</c:if>
														value="11">11</option>
													<option
														<c:if test="${fn:contains(hour, '12')}">selected</c:if>
														value="12">12</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Minutes</label>
											</div>
											<div class="col-sm-12  pull-left">
												<select id="minutes" name="minutes" 
													class="form-control pull-left input-sm" required="required">
													<option
														<c:if test="${fn:contains(minutes, '00')}">selected</c:if>
														value="00">00</option>
													<option
														<c:if test="${fn:contains(minutes, '15')}">selected</c:if>
														value="15">15</option>
													<option
														<c:if test="${fn:contains(minutes, '30')}">selected</c:if>
														value="30">30</option>
													<option
														<c:if test="${fn:contains(minutes, '45')}">selected</c:if>
														value="45">45</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">AM
													/ PM</label>
											</div>
											<div class="col-sm-8  pull-left">
												<div data-toggle="buttons" class="btn-group">
													<label
														class="col-sm-6 btn btn-primary <c:if test="${fn:contains(amPM, 'AM')}">active</c:if>">
														<input type="radio" id="am" name="amPM"
														<c:if test="${fn:contains(amPM, 'AM')}">checked="checked"</c:if>
														value="AM" required="required" /> AM
													</label> <label
														class="col-sm-6 btn btn-primary <c:if test="${fn:contains(amPM, 'PM')}">active</c:if>">
														<input type="radio" id="pm" name="amPM"
														<c:if test="${fn:contains(amPM, 'PM')}">checked="checked"</c:if>
														value="PM" required="required" /> PM
													</label>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Location</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input type="text" id="location" name="location"
													value="<c:out value="${location}"/>"
													class="form-control fixed_size_inputs input-sm"
													maxlength="150" required="required" />
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
											<c:choose>
												<c:when test="${fn:contains(interviewScheduled, 'true')}"> 
										             <button type="submit" class="col-sm-12 btn btn-success btn-sm" value="Update">Update</button>
										        </c:when>
												<c:otherwise>
													<button type="submit" class="col-sm-12 btn btn-success btn-sm" value="Submit">Submit</button>
												</c:otherwise>
											</c:choose>
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

	<script type="text/javascript">
		// When the document is ready
		$(document).ready(function() {

			$('#interviewDatePicker').datetimepicker({
				pickTime: false
			});

		});
	</script>
		
</body>
</html>