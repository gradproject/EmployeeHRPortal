<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String profileInformationJspVersion = "1";
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

					<h3>Student Profile</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">User Information</h3>
						</div>

						<div class="panel-body">

							<form id="profileInformationForm" name="profileInformationForm"
								action="/OnCampusJobsPortal/ProfileInformationServlet"
								method="post" role="form">
								<div class="row">
									<div class="col-md-12 form-group pull-left">
										<div class="col-sm-12  pull-left">
											<label class="control-label" for="inputUserType1">Status
												Of Visa</label>
										</div>
										<div class="col-sm-3  pull-left">
											<select id="statusOfVisa" name="statusOfVisa"
												class="form-control pull-left input-sm" required="required">
												<option
													<c:if test="${fn:contains(statusOfVisa, 'F1')}">selected</c:if>
													value="F1">F1</option>
												<option
													<c:if test="${fn:contains(statusOfVisa, 'H4')}">selected</c:if>
													value="H4">H4</option>
												<option
													<c:if test="${fn:contains(statusOfVisa, 'J1')}">selected</c:if>
													value="J1">J1</option>
												<option
													<c:if test="${fn:contains(statusOfVisa, 'H1')}">selected</c:if>
													value="H1">H1</option>
												<option
													<c:if test="${fn:contains(statusOfVisa, 'Other')}">selected</c:if>
													value="Other">Other</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group pull-left">
										<div class="col-sm-12  pull-left">
											<label class="control-label" for="inputUserType1">Address1</label>
										</div>
										<div class="col-md-8  pull-left">
											<input type="text" id="address1" name="address1"
												value="<c:out value="${address1}"/>"
												class="form-control fixed_size_inputs input-sm"
												maxlength="250" required="required" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12  form-group pull-left">
										<div class="col-sm-12  pull-left">
											<label class="control-label" for="inputUserType1">Address2</label>
										</div>
										<div class="col-md-8  pull-left">
											<input type="text" id="address2" name="address2" value="<c:out value="${address2}"/>"
												class="form-control fixed_size_inputs input-sm"
												maxlength="250">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">City</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input type="text" id="city" name="city"
													value="<c:out value="${city}"/>"
													class="form-control fixed_size_inputs input-sm"
													maxlength="100" required="required" />
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">State</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input type="text" id="state" name="state"
													value="<c:out value="${state}"/>"
													class="form-control fixed_size_inputs input-sm"
													maxlength="100" required="required" />
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Zipcode</label>
											</div>
											<div class="col-sm-8  pull-left">
												<input type="text" id="zipCode" name="zipCode"
													value="<c:out value="${zipCode}"/>"
													class="form-control fixed_size_inputs input-sm"
													maxlength="20" required="required" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Country</label>
											</div>
											<div class="col-sm-12  pull-left">
												<select id="country" name="country"
													class="form-control pull-left input-sm" required="required">
													<option
														<c:if test="${fn:contains(country, 'United States')}">selected</c:if>
														value="UnitedStates">United States</option>
													<option
														<c:if test="${fn:contains(country, 'India')}">selected</c:if>
														value="India">India</option>
													<option
														<c:if test="${fn:contains(country, 'China')}">selected</c:if>
														value="China">China</option>
													<option
														<c:if test="${fn:contains(country, 'United Kingdom')}">selected</c:if>
														value="United Kingdom">United Kingdom</option>
													<option
														<c:if test="${fn:contains(country, 'Other')}">selected</c:if>
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
												<label class="control-label" for="inputUserType1">Course
													Start Year</label>
											</div>
											<div class="col-sm-8  pull-left">
												<select id="startYearOfCourse" name="startYearOfCourse"
													class="form-control pull-left input-sm" required="required">
													<option
														<c:if test="${fn:contains(startYearOfCourse, '2014')}">selected</c:if>
														value="2014">2014</option>
													<option
														<c:if test="${fn:contains(startYearOfCourse, '2015')}">selected</c:if>
														value="2015">2015</option>
													<option
														<c:if test="${fn:contains(startYearOfCourse, '2016')}">selected</c:if>
														value="2016">2016</option>
													<option
														<c:if test="${fn:contains(startYearOfCourse, '2017')}">selected</c:if>
														value="2017">2017</option>
													<option
														<c:if test="${fn:contains(startYearOfCourse, 'Later')}">selected</c:if>
														value="Later">Later</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Course
													End Year</label>
											</div>
											<div class="col-sm-8  pull-left">
												<select id="endYearOfCourse" name="endYearOfCourse"
													class="form-control pull-left input-sm" required="required">
													<option
														<c:if test="${fn:contains(endYearOfCourse, '2014')}">selected</c:if>
														value="2014">2014</option>
													<option
														<c:if test="${fn:contains(endYearOfCourse, '2015')}">selected</c:if>
														value="2015">2015</option>
													<option
														<c:if test="${fn:contains(endYearOfCourse, '2016')}">selected</c:if>
														value="2016">2016</option>
													<option
														<c:if test="${fn:contains(endYearOfCourse, '2017')}">selected</c:if>
														value="2017">2017</option>
													<option
														<c:if test="${fn:contains(endYearOfCourse, '2018')}">selected</c:if>
														value="2018">2018</option>
													<option
														<c:if test="${fn:contains(endYearOfCourse, '2019')}">selected</c:if>
														value="2019">2019</option>
													<option
														<c:if test="${fn:contains(endYearOfCourse, '2020')}">selected</c:if>
														value="2020">2020</option>
													<option
														<c:if test="${fn:contains(endYearOfCourse, '2021')}">selected</c:if>
														value="2021">2021</option>
													<option
														<c:if test="${fn:contains(endYearOfCourse, 'Later')}">selected</c:if>
														value="Later">Later</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Student
													Status</label>
											</div>
											<div class="col-sm-12  pull-left">
												<select id="studentStatus" name="studentStatus"
													class="form-control pull-left input-sm" required="required">
													<option
														<c:if test="${fn:contains(studentStatus, 'fullTime')}">selected</c:if>
														value="fullTime">Full Time</option>
													<option
														<c:if test="${fn:contains(studentStatus, 'partTime')}">selected</c:if>
														value="partTime">Part Time</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Major</label>
											</div>
											<div class="col-sm-12  pull-left">
												<select id="major" name="major"
													class="form-control pull-left input-sm" required="required">

													<option
														<c:if test="${fn:contains(major, 'Arts')}">selected</c:if>
														value="Arts">Arts</option>
													<option
														<c:if test="${fn:contains(major, 'Biology')}">selected</c:if>
														value="Biology">Biology</option>
													<option
														<c:if test="${fn:contains(major, 'Chemistry')}">selected</c:if>
														value="Chemistry">Chemistry</option>
													<option
														<c:if test="${fn:contains(major, 'Commerce')}">selected</c:if>
														value="Commerce">Commerce</option>
													<option
														<c:if test="${fn:contains(major, 'Computer Science')}">selected</c:if>
														value="Computer Science">Computer Science</option>
													<option
														<c:if test="${fn:contains(major, 'Mathematics')}">selected</c:if>
														value="Mathematics">Mathematics</option>
													<option
														<c:if test="${fn:contains(major, 'Other')}">selected</c:if>
														value="Other">Other</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Enrolled
													Credit Hours</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input type="text" id="enrolledCreditHours"
													name="enrolledCreditHours"
													value="<c:out value="${enrolledCreditHours}"/>"
													class="form-control fixed_size_inputs input-sm"
													maxlength="10" required="required" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group pull-left">
										<div class="col-sm-12  pull-left">
											<label class="control-label" for="inputUserType1">Skills</label>
										</div>
										<div class="col-md-8  pull-left">
											<input type="text" id="skills" name="skills"
												value="<c:out value="${skills}"/>"
												class="form-control fixed_size_inputs input-sm"
												maxlength="500" required="required" />
										</div>
									</div>
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