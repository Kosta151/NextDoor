<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title><tiles:insertAttribute name="title" /></title>

    <!-- Bootstrap core CSS -->
    <link href="resources/main/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="resources/main/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="resources/main/assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="resources/main/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="resources/main/assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="resources/main/assets/css/style.css" rel="stylesheet">
    <link href="resources/main/assets/css/style-responsive.css" rel="stylesheet">
    
  </head>

<body>
  <section id="container" > 
	<!-- Header  영역  -->
	<tiles:insertAttribute name="header" />
	<!-- aside 영역 -->
	<tiles:insertAttribute name="aside" />
	<!-- Main 영역 -->
    <tiles:insertAttribute name="content" />
	<!-- Footer  영역  -->
	<tiles:insertAttribute name="footer" />

	</section>
	<!-- js placed at the end of the document so the pages load faster -->
    <script src="resources/main/assets/js/jquery.js"></script>
    <script src="resources/main/assets/js/jquery-1.8.3.min.js"></script>
    <script src="resources/main/assets/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="resources/main/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="resources/main/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="resources/main/assets/js/jquery.scrollTo.min.js"></script>
    <script src="resources/main/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="resources/main/assets/js/jquery.sparkline.js"></script>

    <!--common script for all pages-->
    <script src="resources/main/assets/js/morris-conf.js"></script>
   	<script src="resources/main/assets/js/common-scripts.js"></script>
   	<script type="text/javascript" src="resources/main/assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="resources/main/assets/js/gritter-conf.js"></script>
	 

  	 

    
</body>
</html> 