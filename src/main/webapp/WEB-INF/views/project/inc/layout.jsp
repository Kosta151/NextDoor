<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
  <head>
     <!-- DatePicker(jQuery UI) -->
   <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"> 
   <script src="//code.jquery.com/jquery-1.10.2.js"></script>
   <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
   
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

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

    <script src="resources/main/assets/js/chart-master/Chart.js"></script>
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
    <script src="resources/main/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="resources/main/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="resources/main/assets/js/jquery.scrollTo.min.js"></script>
    <script src="resources/main/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="resources/main/assets/js/jquery.sparkline.js"></script>
    
    <!--common script for all pages--> 
    <script src="resources/main/assets/js/jquery-ui-1.9.2.custom.min.js"></script>
      <script src="resources/main/assets/js/common-scripts.js"></script>
      <script type="text/javascript" src="resources/main/assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="resources/main/assets/js/gritter-conf.js"></script>
      
    <!--script for this page-->
      <script src="resources/main/assets/js/sparkline-chart.js"></script>    
   <script src="resources/main/assets/js/zabuto_calendar.js"></script>   
   

</body>
</html> 