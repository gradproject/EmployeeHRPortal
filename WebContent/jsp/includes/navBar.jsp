<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Employee HR Portal</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<c:if test="${fn:contains(sessionScope.userLoggedIn, 'true')}">

				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li class="dropdown"><a
						href="/EmployeeHRPortal/jsp/adminLogin.jsp"
						class="dropdown-toggle" data-toggle="dropdown">Admin</a></li>


					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Employees <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/EmployeeHRPortal/AssignEmployeeDeptData">Create
									New Employee</a></li>
							<li class="divider"></li>
							<li><a href="/EmployeeHRPortal/EmployeeListServlet">List
									Employees</a></li>

							<li><a href="/EmployeeHRPortal/InitalizeTimeSheet">Enter
									Time Sheet</a></li>
						</ul></li>


					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Projects <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<!-- <li><a href="/OnCampusJobsPortal/jsp/profileInformation.jsp">Update
									Profile Information</a></li>
							<li class="divider"></li>-->
							<li><a href="/EmployeeHRPortal/jsp/project.jsp">Create
									New Project</a></li>
							<li><a href="/EmployeeHRPortal/IntialiseProjectDeptData">Assign
									Project to Department</a></li>
							<li><a href="/EmployeeHRPortal/IntialiseEmpProjectData">Assign
									Employee to Project</a></li>
							<!-- 								<li><a -->
							<!-- 									href="/EmployeeHRPortal/ListEmployeeByProject?projectId=1235">List -->
							<!-- 										Employee By Project</a></li> -->
							<li><a href="/EmployeeHRPortal/ProjectListServlet">List
									Projects</a></li>
							<li><a href="/EmployeeHRPortal/ListProjectByManager">List
									Projects By Manager</a></li>


						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Departments <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<!-- <li><a href="/OnCampusJobsPortal/jsp/profileInformation.jsp">Update
									Profile Information</a></li>
							<li class="divider"></li>-->
							<li><a href="/EmployeeHRPortal/jsp/department.jsp">Create
									New Department</a></li>
							<li><a href="/EmployeeHRPortal/IntialiseProjectDeptData">
									Assign Project to Department</a></li>
							<!-- 								<li><a -->
							<!-- 									href="/EmployeeHRPortal/ListEmployeeByDepartment?deptId=10">List -->
							<!-- 										Employee By Department</a></li> -->

							<li><a href="/EmployeeHRPortal/DepartmentListServlet">List
									Departments</a></li>
						</ul></li>


				</ul>
				<ul class="nav navbar-nav navbar-right">

					<li><a href="/EmployeeHRPortal/WelcomeServlet">LogOut</a></li>
				</ul>
			</c:if>

		</div>
	</div>
</nav>