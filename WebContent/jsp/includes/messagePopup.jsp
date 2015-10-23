<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String messagePopupJspVersion = "1";
%>

<c:if test="${not empty successMessage}">
	<div class="alert alert-success alert-dismissible" style="text-align:center;" role="alert" id="last_login-">
	  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	  <strong><c:out value="${successMessage}" /></strong>
	</div>
</c:if>

<c:if test="${not empty failureMessage}">
	<div class="alert alert-danger alert-dismissible" style="text-align:center;" role="alert" id="last_login-">
	  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	  <strong><c:out value="${failureMessage}" /></strong>
	</div>
</c:if>