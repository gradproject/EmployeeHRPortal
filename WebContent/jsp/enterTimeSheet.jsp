<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee HR Portal - Insert Time Sheet</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>Insert Time Sheet</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">Time Sheet Information</h3>
						</div>

						<div class="panel-body">

							<form id="" name=""
								action="/EmployeeHRPortal/EnterTimeSheet" method="post"
								role="form">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Employee ID</label>
											</div>
											<div class="col-sm-10  pull-left">
												<input kl_virtual_keyboard_secure_input="on" name="empId"
													id="empId" class="form-control fixed_size_inputs input-sm"
													maxlength="20" required="required" type="text">

											</div>
										</div>
									</div>
									</div>
									
									
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Project ID</label>
											</div>
											<div class="col-sm-10  pull-left">
												<input kl_virtual_keyboard_secure_input="on" name="projectId"
													id="projectId" class="form-control fixed_size_inputs input-sm"
													maxlength="20" required="required" type="text">

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
												<label class="control-label" for="inputUserType1">Date</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on"
													id="date" name="date"
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
												<label class="control-label" for="inputUserType1">Work Hours</label>
											</div>
											<div class="col-sm-10  pull-left">
												<input kl_virtual_keyboard_secure_input="on" name="workHours"
													id="workHours" class="form-control fixed_size_inputs input-sm"
													maxlength="20" required="required" type="text">

											</div>
										</div>
									</div>
									<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Approved</label>
											</div>
											<div class="col-sm-10  pull-left">
												<input kl_virtual_keyboard_secure_input="on" name="approved"
													id="approved" class="form-control fixed_size_inputs input-sm"
													maxlength="20" required="required" type="text">

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
</body>
</html>