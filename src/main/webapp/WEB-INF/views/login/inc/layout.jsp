<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Next Door</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/main/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="resources/main/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="resources/main/assets/css/style.css" rel="stylesheet">
    <link href="resources/main/assets/css/style-responsive.css" rel="stylesheet">

  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<tiles:insertAttribute name="content" />

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="resources/main/assets/js/jquery.js"></script>
    <script src="resources/main/assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="resources/main/assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("resources/main/assets/img/login-bg.jpg", {speed: 500});
    </script>


  </body>
</html>