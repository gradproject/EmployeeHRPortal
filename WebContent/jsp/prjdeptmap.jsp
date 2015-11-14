<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee HR Portal - Assign Project to Department</title>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container theme-showcase" role="main">
	<%@ include file="includes/messagePopup.jsp"%>

		<div class="row read-only---" style="padding-top: -20px;">

			<div class="col-lg-12">

				<div class="page-header--">

					<h3>Assign Project to Department</h3>

				</div>
				<!-- /page-header-- -->

				<div class="clearfix"></div>

				<div class="panel-group" id="accordion">

					<div class="panel panel-default ">

						<div class="panel-heading ">
							<h3 class="panel-title">Project Department Information</h3>
						</div>

						<div class="panel-body">

							<form id="prjDeptMapForm" name="prjDeptMapForm" action="/EmployeeHRPortal/ProjDeptServlet" method="post"
								role="form">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Project</label>
											</div>
											<div class="col-sm-10  pull-left">
												<select name="prjId" id="prjId"
												class="form-control pull-left input-sm" >
					<c:forEach items="${prjList}" var="prj">
						<option value="<c:out value="${prj.projectId}"/>" ><c:out value="${prj.projectName}" /></option>
					</c:forEach>
				</select>
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
												<label class="control-label" for="inputUserType1">Department</label>
											</div>
											<div class="col-sm-12  pull-left">
												<select name="deptId" id="deptId"
												class="form-control pull-left input-sm">
				<!--  the c forEach tag is accepting the list object through items attribute
						it is iterating the data over the list and then storing each object in the department variable  -->
					<c:forEach items="${deptList}" var="dept">
						<option value="<c:out value ="${dept.deptId}"/>"><c:out value ="${dept.deptName}"/></option>
					</c:forEach>
				</select>
											</div>
										</div>
									</div>
									<div class="row">
									<div class="col-md-8">
										<div class="form-group pull-left">
											<div class="col-sm-12  pull-left">
												<label class="control-label" for="inputUserType1">Hours Allocated</label>
											</div>
											<div class="col-sm-12  pull-left">
												<input kl_virtual_keyboard_secure_input="on"
													id="hoursAllocated" name="hoursAllocated"
													class="form-control fixed_size_inputs input-sm"
													maxlength="250" required="required" type="text">
											</div>
										</div>
									</div>
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