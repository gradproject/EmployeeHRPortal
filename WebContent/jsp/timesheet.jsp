<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee Connect - Insert Time Sheet</title>

<style type="text/css">
.timesheetfooter>tbody>tr:last-child {
	background-color: #f9f9f9;
}

.timesheettable>thead>tr:first-child {
	background-color: #f9f9f9;
}

.timesheettable>tbody>tr:first-child, .timesheettable>tbody>tr:first-child>td,
	.timesheettable>tbody>tr:first-child>td>div {
	visibility: collapse;
}

.timesheettable>thead>tr>th {
	text-align: center;
}

.timesheettable>thead>tr>th:first-child {
	text-align: left;
}

.timesheettable>tbody>tr>td {
	padding: 0px !important;
	margin: 0px !important;
	width: 85px !important;
	text-align: center;
}

.timesheettable>tbody>tr>td:first-child {
	width: 300px !important;
	padding-left: 8px !important;
	padding-right: 8px !important;
	padding-top: 0px !important;
	padding-bottom: 0px !important;
	margin: 0px !important;
	text-align: left;
}

.timesheettable>tbody>tr>td>input {
	border: none;
	width: 100%;
	text-align: center;
}

.timesheettable>tbody>tr>td>div {
	overflow: hidden;
}
</style>

<script type="text/javascript">
	var lineNumber = 0;

	function addProject(projectName, projectId) {

		var lineName = 'line' + lineNumber;

		projectId = projectId + '_' + lineName;

		var sun = '<c:out value="${sundayMDY}"></c:out>_sun';
		var mon = '<c:out value="${mondayMDY}"></c:out>_mon';
		var tue = '<c:out value="${tuesdayMDY}"></c:out>_tue';
		var wed = '<c:out value="${wednesdayMDY}"></c:out>_wed';
		var thu = '<c:out value="${thursdayMDY}"></c:out>_thu';
		var fri = '<c:out value="${fridayMDY}"></c:out>_fri';
		var sat = '<c:out value="${saturdayMDY}"></c:out>_sat';

		var timeInputHTML = '<tr>' + '	<td><div id="projectLable">'
				+ projectName + '</div></td>' + '	<td>'
				+ '		<input type="text" id="' + sun + '_' + projectId
				+ '" name="' + sun + '_' + projectId
				+ '" onchange="updateTotals()"/>' + '	</td>' + '	<td>'
				+ '		<input type="text" id="' + mon + '_' + projectId
				+ '" name="' + mon + '_' + projectId
				+ '" onchange="updateTotals()"/>' + '	</td>' + '	<td>'
				+ '		<input type="text" id="' + tue + '_' + projectId
				+ '" name="' + tue + '_' + projectId
				+ '" onchange="updateTotals()"/>' + '	</td>' + '	<td>'
				+ '		<input type="text" id="' + wed + '_' + projectId
				+ '" name="' + wed + '_' + projectId
				+ '" onchange="updateTotals()"/>' + '	</td>' + '	<td>'
				+ '		<input type="text" id="' + thu + '_' + projectId
				+ '" name="' + thu + '_' + projectId
				+ '" onchange="updateTotals()"/>' + '	</td>' + '	<td>'
				+ '		<input type="text" id="' + fri + '_' + projectId
				+ '" name="' + fri + '_' + projectId
				+ '" onchange="updateTotals()"/>' + '	</td>' + '	<td>'
				+ '		<input type="text" id="' + sat + '_' + projectId
				+ '" name="' + sat + '_' + projectId
				+ '" onchange="updateTotals()"/>' + '	</td>'
				+ '	<td id="' + lineName + '_total">0</td>' + '</tr>';

		$('#timescheettalble').append(timeInputHTML);

		lineNumber = lineNumber + 1;

	}

	function updateTotals() {
		var sun_total = getTotal('sun');
		var mon_total = getTotal('mon');
		var tue_total = getTotal('tue');
		var wed_total = getTotal('wed');
		var thu_total = getTotal('thu');
		var fri_total = getTotal('fri');
		var sat_total = getTotal('sat');

		var all_total = sun_total + mon_total + tue_total + wed_total
				+ thu_total + fri_total + sat_total;

		$('#sun_total').text(sun_total);
		$('#mon_total').text(mon_total);
		$('#tue_total').text(tue_total);
		$('#wed_total').text(wed_total);
		$('#thu_total').text(thu_total);
		$('#fri_total').text(fri_total);
		$('#sat_total').text(sat_total);
		$('#all_total').text(all_total);

		for (var i = 0; i < lineNumber; i++) {
			var name = 'line' + i;
			var total = getTotal(name);
			$('#' + name + '_total').text(total);
		}

	}

	function getTotal(name) {
		var total = 0;
		var allInputs = $(":input");
		for (var i = 0; i < allInputs.length; i++) {
			if (allInputs[i].name.indexOf(name) > -1) {
				if (allInputs[i].value != '') {
					var temp = Number(allInputs[i].value);
					if (temp > -1) {
						total = total + temp;
					}
				}
			}
		}
		return total;
	}
</script>

</head>

<body>

	<%@ include file="includes/navBar.jsp"%>

	<div class="container-fluid">

		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<br>
				<h4 class="sub-header">Assigned Projects</h4>
				<ul class="nav nav-sidebar">
					<c:forEach items="${projectList}" var="prj">
						<li><a class="glyphicon-plus"
							href="javascript:addProject('<c:out value="${prj.projectName}" />', '<c:out value="${prj.projectId}"/>');"><c:out
									value="${prj.projectName}" /></a></li>
					</c:forEach>
				</ul>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<%@ include file="includes/messagePopup.jsp"%>
				<h2 class="sub-header">Time Sheet</h2>
				<div class="row">
					<div class="col-xs-6 col-md-4">
						<a href="/EmployeeHRPortal/InitalizeTimeSheet?weekIncrement=-1">
							<button type="button" class="btn btn-primary pull-left ">
								<i class="glyphicon glyphicon-chevron-left"></i>&nbsp;Previous
								Week
							</button>
						</a>
					</div>
					<div class="col-xs-6 col-md-4"
						style="text-align: center; padding: 5px;">
						Week Starting &nbsp;
						<c:out value="${startDate}"></c:out>
					</div>
					<div class="col-xs-6 col-md-4">
						<a href="/EmployeeHRPortal/InitalizeTimeSheet?weekIncrement=1">
							<button type="button" class="btn btn-primary pull-right">
								Next Week&nbsp;<i class="glyphicon glyphicon-chevron-right"></i>
							</button>
						</a>
					</div>
				</div>
				<div class="row">&nbsp;</div>
				<form name="timeSheetForm" id="timeSheetForm"
					action="/EmployeeHRPortal/EnterTimeSheet" method="post">
					<div class="table-responsive">

						<table id="timescheettalble"
							class="timesheettable table table-bordered"
							style="margin: 0px !important;">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Sun <c:out value="${sunday}"></c:out>
									</th>
									<th>Mon <c:out value="${monday}"></c:out></th>
									<th>Tue <c:out value="${tuesday}"></c:out></th>
									<th>Wed <c:out value="${wednesday}"></c:out></th>
									<th>Thr <c:out value="${thursday}"></c:out></th>
									<th>Fri <c:out value="${friday}"></c:out></th>
									<th>Sat <c:out value="${saturday}"></c:out></th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
						<table class="timesheetfooter timesheettable table table-bordered">
							<tbody>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td id="sun_total">0</td>
									<td id="mon_total">0</td>
									<td id="tue_total">0</td>
									<td id="wed_total">0</td>
									<td id="thu_total">0</td>
									<td id="fri_total">0</td>
									<td id="sat_total">0</td>
									<td id="all_total">0</td>
								</tr>
							</tbody>
						</table>

					</div>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-8">
							<div class="form-group fixed_size_inputs pull-right">
								<input type="hidden" id="empId" name="empId"
									value="<c:out value="${empId}"></c:out>" /> <input
									type="hidden" id="submit" name="submit" value="Submit" />
								<button type="submit" class="col-sm-12 btn btn-success btn-sm">Submit</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- /container -->

		<%@ include file="includes/footerIncludes.jsp"%>
</body>
</html>