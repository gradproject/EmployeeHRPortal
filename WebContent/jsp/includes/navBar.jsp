<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

			<ul class="nav navbar-nav">
				<li class="active"><a href="/EmployeeHRPortal/index.html">Home</a></li>


				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Employees <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/EmployeeHRPortal/AssignEmployeeDeptData">Create
								New Employee</a></li>
						<li class="divider"></li>
						<li><a href="/EmployeeHRPortal/EmployeeListServlet">List
								Employees</a></li>
						
						<li><a href="/EmployeeHRPortal/jsp/enterTimeSheet.jsp">Enter
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
						<li><a href="/EmployeeHRPortal/IntialiseProjectDeptData">Assign Project to
								Department</a></li>
						<li><a href="/EmployeeHRPortal/IntialiseEmpProjectData">Assign
								Employee to Project</a></li>
								<li><a href="/EmployeeHRPortal/ListEmployeeByProject?projectId=9990">List
								Employee By Project</a></li>

					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Departments <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<!-- <li><a href="/OnCampusJobsPortal/jsp/profileInformation.jsp">Update
									Profile Information</a></li>
							<li class="divider"></li>-->
						<li><a href="/EmployeeHRPortal/jsp/department.jsp">Create
								New Department</a></li>
						<li><a href="/EmployeeHRPortal/IntialiseProjectDeptData"> Assign Project to
								Department</a></li>
						<li><a
							href="/EmployeeHRPortal/ListEmployeeByDepartment?deptId=10">List
								Employee By Department</a></li>
						<li>
					</ul></li>


				<!-- <li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li> -->
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<!--  	<li><a href="#">Dashboard</a></li> -->
				<li><a href="#">Settings</a></li>
				<!--  <li><a href="#">Profile</a></li> -->
				<li><a href="/EmployeeHRPortal/index.html">Help</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input kl_virtual_keyboard_secure_input="on" class="form-control"
					placeholder="Search..." type="text">
			</form>
		</div>
	</div>
</nav>