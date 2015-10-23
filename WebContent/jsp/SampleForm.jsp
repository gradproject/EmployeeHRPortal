<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>SampleWebApp - Registration</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>Registration</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">User Information</h3>
						</div>

						<div class="panel-body">

							<form id="RegiatrationForm" name="RegistrationForm"
								action="/OnCampusJobsPortal/RegistrationServlet" method="post"
								role="form">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">User
													Type</label>
											</div>
											<div class="col-sm-12  pull-left">
												<div data-toggle="buttons" class="btn-group">
													<label class="col-sm-6 btn btn-primary "> <input
														id="userType" name="userType" value="Employee"
														required="required" type="radio"> Employee
													</label> <label class="col-sm-6 btn btn-primary "> <input
														id="userType" name="userType" value="Student"
														required="required" type="radio"> Student
													</label>
												</div>
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
												<label class="control-label" for="inputUserType1">User
													ID</label>
											</div>
											<div class="col-sm-10  pull-left">
												<input kl_virtual_keyboard_secure_input="on" name="userId"
													id="userId" class="form-control fixed_size_inputs input-sm"
													maxlength="20" required="required" type="text">

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
												<label class="control-label" for="inputUserType1">First
													Name </label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on"
													name="userFirstName" id="userFirstName"
													class="form-control fixed_size_inputs input-sm"
													maxlength="45" required="required" type="text">
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Middle
													Name</label>
											</div>
											<div class="col-sm-6  pull-left">
												<input kl_virtual_keyboard_secure_input="on"
													id="userMiddleName" name="userMiddleName"
													class="form-control fixed_size_inputs input-sm"
													maxlength="45" type="text">
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Last
													Name</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on"
													id="userLastName" name="userLastName"
													class="form-control fixed_size_inputs input-sm"
													maxlength="45" required="required" type="text">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Password</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on" id="password"
													name="password" value=""
													class="form-control fixed_size_inputs input-sm"
													maxlength="20" required="required" type="password">
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Re-enter
													Password</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on"
													id="reEnterPassword" name="reEnterPassword" value=""
													class="form-control fixed_size_inputs input-sm"
													maxlength="20" required="required" type="password">
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Email</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on" id="emailId"
													name="emailId"
													class="form-control fixed_size_inputs input-sm"
													maxlength="45" required="required" type="text">
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-8">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Security
													Question</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on"
													id="securityQuestion" name="securityQuestion"
													class="form-control fixed_size_inputs input-sm"
													maxlength="250" required="required" type="text">
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Answer</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on" id="answer"
													name="answer" value=""
													class="form-control fixed_size_inputs input-sm"
													maxlength="45" required="required" type="password">
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

</body>
</html>