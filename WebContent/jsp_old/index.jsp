<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String indexJspVersion = "1";
%>    
<!DOCTYPE html>
<html lang="en">
  <head>

    <%@ include file="includes/headerIncludes.jsp"%>
    
    <title>SampleWebApp - Index</title>
    
  </head>

  <body>

     <%@ include file="includes/navBar.jsp"%>

    <div class="container theme-showcase" role="main">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>On Campus Jobs Portal</h1>
        <p>Welcome to on campus jobs portal. This web site enables university management to reach out to enrolled current students who are in financial need. Work-Study program helps students to gain experience while they are pursuing education at the university.</p>
        <p>To view the current job openings and apply, Please register and login.</p>
        <p style="padding-left: 25%;padding-right: 25%;padding-top: 40px;">
          <a style="margin-right: 50px;" class="btn btn-lg btn-primary" href="/OnCampusJobsPortal/jsp/registration.jsp" role="button">New User Registration  &raquo;</a>
          <a style="margin-right: 10px;" class="btn btn-lg btn-success" href="/OnCampusJobsPortal/jsp/login.jsp" role="button">Login &raquo;</a>
        </p>
      </div>
      
      <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-generic" data-slide-to="0" class=""></li>
          <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
          <li data-target="#carousel-example-generic" data-slide-to="2" class="active"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <div class="item">
            <img width="1140" height="600" data-src="holder.js/1140x500/auto/#777:#555/text:First slide" alt="First slide [1140x600]" src="/OnCampusJobsPortal/images/image.jpg" data-holder-rendered="true">
          </div>
          <div class="item">
            <img width="1140" height="600" data-src="holder.js/1140x500/auto/#666:#444/text:Second slide" alt="Second slide [1140x600]" src="/OnCampusJobsPortal/images/image.jpg" data-holder-rendered="true">
          </div>
          <div class="item active">
            <img width="1140" height="600" data-src="holder.js/1140x500/auto/#555:#333/text:Third slide" alt="Third slide [1140x600]" src="/OnCampusJobsPortal/images/image.jpg" data-holder-rendered="true">
          </div>
        </div>
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

    </div> 
    <!-- /container -->
    
	<%@ include file="includes/footer.jsp"%>
	
	<%@ include file="includes/javaScriptIncludes.jsp"%>
	
  </body>
</html>