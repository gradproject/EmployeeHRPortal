<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="includes/header.jsp"%>

<title>Employee Connect - Insert Time Sheet</title>

<style type="text/css">

.timesheetfooter > tbody > tr:last-child {
	background-color: #f9f9f9;
}

.timesheettable > thead > tr:first-child {
	background-color: #f9f9f9;
}

.timesheettable > tbody > tr:first-child, .timesheettable > tbody > tr:first-child > td, .timesheettable > tbody > tr:first-child > td > div {
	visibility: collapse ;
}

.timesheettable > thead > tr > th {
	text-align: center;
}

.timesheettable > thead > tr > th:first-child {
	text-align: left;
}

.timesheettable > tbody > tr > td {
	padding:0px !important;
	margin:0px !important;
	width:65px !important;
	text-align: center;
}

.timesheettable > tbody > tr > td:first-child {
	width:350px !important;
	padding-left:8px !important;
	padding-right:8px !important;
	padding-top:0px !important;
	padding-bottom:0px !important;
	margin:0px !important;
	text-align: left;
}

.timesheettable > tbody > tr > td > input {
	border:none;
	width : 100%;
	text-align: center;
}

.timesheettable > tbody > tr > td > div {
	overflow: hidden;
}



</style>

<script type="text/javascript">

	var lineNumber = 0;
	
	function addProject(projectName, projectId){
		
		var lineName = 'line' + lineNumber;

		projectId = projectId + '_' + lineName;
		
		var sun = 'sun';
		var mon = 'mon';
		var tue = 'tue';
		var wed = 'wed';
		var thu = 'thu';
		var fri = 'fri';
		var sat = 'sat';
	
		
		var timeInputHTML =   '<tr>'
							+ '	<td><div id="projectLable">' + projectName + '</div></td>'
							+ '	<td>'
							+ '		<input type="text" id="' + sun + '_' + projectId + '" name="' + sun + '_' + projectId + '" onchange="updateTotals()"/>'
							+ '	</td>'
							+ '	<td>'
							+ '		<input type="text" id="' + mon + '_' + projectId + '" name="' + mon + '_' + projectId + '" onchange="updateTotals()"/>'
							+ '	</td>'
							+ '	<td>'
							+ '		<input type="text" id="' + tue + '_' + projectId + '" name="' + tue + '_' + projectId + '" onchange="updateTotals()"/>'
							+ '	</td>'
							+ '	<td>'
							+ '		<input type="text" id="' + wed + '_' + projectId + '" name="' + wed + '_' + projectId + '" onchange="updateTotals()"/>'
							+ '	</td>'
							+ '	<td>'
							+ '		<input type="text" id="' + thu + '_' + projectId + '" name="' + thu + '_' + projectId + '" onchange="updateTotals()"/>'
							+ '	</td>'
							+ '	<td>'
							+ '		<input type="text" id="' + fri + '_' + projectId + '" name="' + fri + '_' + projectId + '" onchange="updateTotals()"/>'
							+ '	</td>'
							+ '	<td>'
							+ '		<input type="text" id="' + sat + '_' + projectId + '" name="' + sat + '_' + projectId + '" onchange="updateTotals()"/>'
							+ '	</td>'
							+ '	<td id="' + lineName + '_total">0</td>'
							+ '</tr>';
		
		$('#timescheettalble').append(timeInputHTML);
							
		lineNumber = lineNumber + 1;					
		
	}
	
	function  updateTotals(){
		var sun_total = getTotal('sun');
		var mon_total = getTotal('mon');
		var tue_total = getTotal('tue');
		var wed_total = getTotal('wed');
		var thu_total = getTotal('thu');
		var fri_total = getTotal('fri');
		var sat_total = getTotal('sat');
		
		var all_total = sun_total + mon_total + tue_total + wed_total + thu_total + fri_total + sat_total;
		
		$('#sun_total').text(sun_total);
		$('#mon_total').text(mon_total);
		$('#tue_total').text(tue_total);
		$('#wed_total').text(wed_total);
		$('#thu_total').text(thu_total);
		$('#fri_total').text(fri_total);
		$('#sat_total').text(sat_total);
		$('#all_total').text(all_total);
		
		for(var i = 0; i < lineNumber; i++){
			var name = 'line' + i;
			var total = getTotal(name);
			$('#'+name+'_total').text(total);
		}
		
	}
	
	function getTotal(name){
		var total = 0;
		var allInputs = $( ":input" );
		for(var i= 0; i < allInputs.length; i++ ){
			if(allInputs[i].name.indexOf(name)>-1){
				if(allInputs[i].value != ''){
					var temp = Number(allInputs[i].value);
					if(temp > -1){
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
					<li><a class="glyphicon-plus" href="javascript:addProject('Project1', '1');">Project1</a></li>
					<li><a class="glyphicon-plus" href="javascript:addProject('Project2', '2');">Project2</a></li>
					<li><a class="glyphicon-plus" href="javascript:addProject('Project3', '3');">Project3</a></li>
					<li><a class="glyphicon-plus" href="javascript:addProject('Project4', '4');">Project4</a></li>
					<li><a class="glyphicon-plus" href="javascript:addProject('Project5', '5');">Project5</a></li>
					<li><a class="glyphicon-plus" href="javascript:addProject('Project6', '6');">Project6</a></li>
					<li><a class="glyphicon-plus" href="javascript:addProject('Project7', '7');">Project7</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
				<h2 class="sub-header">Time Sheet</h2>
				<div class="table-responsive">
					<table id="timescheettalble" class="timesheettable table table-bordered" style="margin: 0px !important;">
						<thead>
							<tr>
								<th >Project Name</th>
								<th >Sun 18</th>
								<th >Mon 19</th>
								<th >Tue 20</th>
								<th >Wed 21</th>
								<th >Thr 22</th>
								<th >Fri 23</th>
								<th >Sat 24</th>
								<th >Total</th>
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
			</div>
		</div>
	<!-- /container -->

	<%@ include file="includes/footerIncludes.jsp"%>

</body>
</html>