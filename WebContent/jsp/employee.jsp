<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String failureMessage = (String) request
			.getAttribute("failureMessage");
	if (failureMessage == null) {
		failureMessage = "";

	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee HR Portal - Create New Employee</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>Create New Employee</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">Employee Information</h3>
						</div>

						<div class="panel-body">
							<div id="messageDiv"><%=failureMessage%>
							</div>
							<form id="employeeForm" name="employeeForm"
								action="/EmployeeHRPortal/EmployeeServlet" method="post"
								role="form">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left"></div>
											<div class="col-sm-12  pull-left">
												<div data-toggle="buttons" class="btn-group"></div>
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
												<label class="control-label" for="inputUserType1">Employee
													ID</label>
											</div>
											<div class="col-sm-10  pull-left">
												<input kl_virtual_keyboard_secure_input="on" name="empId"
													id="empId" class="form-control fixed_size_inputs input-sm"
													maxlength="50" required="required" type="text">

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
													name="empFirstName" id="empFirstName"
													class="form-control fixed_size_inputs input-sm"
													maxlength="50" required="required" type="text">
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Middle
													Name</label>
											</div>
											<div class="col-sm-10  pull-left">
												<input kl_virtual_keyboard_secure_input="on"
													id="empMiddleName" name="empMiddleName"
													class="form-control fixed_size_inputs input-sm"
													maxlength="50" type="text">
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
													id="empLastName" name="empLastName"
													class="form-control fixed_size_inputs input-sm"
													maxlength="50" required="required" type="text">
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
												<input type="password" id="password" name="password"
													value="" class="form-control fixed_size_inputs input-sm"
													maxlength="50" required="required" type="password" />
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Re-enter
													Password</label>
											</div>
											<div class="col-sm-10  pull-left">
												<input type="password" id="reEnterPassword"
													name="reEnterPassword" value=""
													class="form-control fixed_size_inputs input-sm"
													maxlength="50" required="required" type="password" />
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Email
													Id</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on" id="empEmailId"
													name="empEmailId" value=""
													class="form-control fixed_size_inputs input-sm"
													maxlength="50" required="required" type="text">
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Phone
													Number </label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on"
													id="phoneNumber" name="phoneNumber" value=""
													class="form-control fixed_size_inputs input-sm"
													maxlength="50" required="required" type="text">
											</div>
										</div>
									</div>
									<div class="col-md-4"></div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Department
													Id</label>
											</div>
											<div class="col-sm-12  pull-left">
												<select name="deptId" id="deptId"
													class="form-control pull-left input-sm">
													<!--  the c forEach tag is accepting the list object through items attribute
						it is iterating the data over the list and then storing each object in the department variable  -->
													<c:forEach items="${deptList}" var="dept">
														<option value="<c:out value ="${dept.deptId}"/>"><c:out
																value="${dept.deptName}" /></option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-md-4">
											<div class="form-group pull-left">
												<div class="col-sm-12  pull-left">
													<label class="control-label" for="inputUserType1">Designation
													</label>
												</div>
												<div class="col-sm-12  pull-left">
													<input kl_virtual_keyboard_secure_input="on" id="empDesg"
														name="empDesg"
														class="form-control fixed_size_inputs input-sm"
														maxlength="50" required="required" type="text">
												</div>
											</div>
										</div>
										<div class="col-md-4"></div>
									</div>
									
									
										<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Experience</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on"
													id="empExp" name="empExp"
													class="form-control fixed_size_inputs input-sm"
													maxlength="50" required="required" type="text">
											</div>
										</div>
									</div>
								</div>
									<div class="row">
										<div class="col-md-4"></div>
										<div class="col-md-8">
											<div class="form-group fixed_size_inputs pull-right">
												<input type="hidden" id="submit" name="submit"
													value="Create" />
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