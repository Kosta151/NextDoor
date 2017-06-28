<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<!-- js placed at the end of the document so the pages load faster -->
 	<script src="resources/main/assets/js/jquery.js"></script>
    <script src="resources/main/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="resources/main/assets/js/jquery.scrollTo.min.js"></script>
    <script src="resources/main/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="resources/main/assets/js/circle-progress.js"></script> 
	<link href="resources/main/assets/css/style2.css" rel="stylesheet">
    <!--common script for all pages-->
	<script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
    <script src="resources/main/assets/js/common-scripts.js"></script>

<%
ArrayList chart_x =(ArrayList)request.getAttribute("chart_x");
ArrayList chart_y = (ArrayList)request.getAttribute("chart_y");
String project_name = (String)request.getAttribute("project_name");
String project_no = (String)request.getAttribute("project_no");

System.out.println(chart_x.get(0));
System.out.println(chart_y.get(0));
System.out.println(project_no);
%>
<script type="text/javascript">
$(function () {
    // data stolen from http://howmanyleft.co.uk/vehicle/jaguar_'e'_type
	 Morris.Bar({
      element: 'hero-bar',
      data: [
        {device: 'iPhone 2G', geekbench: 60},
        {device: 'iPhone 3G', geekbench: 137},
        {device: 'iPhone 3GS', geekbench: 275},
        {device: 'iPhone 4', geekbench: 380},
        {device: 'iPhone 4S', geekbench: 655},
        {device: 'iPhone 5', geekbench: 1571}
      ],
      xkey: 'device',
      ykeys: ['geekbench'],
      labels: ['Geekbench'],
      barRatio: 0.4,
      xLabelAngle: 35,
      hideHover: 'auto',
      barColors: ['#ac92ec']
    });
    
    Morris.Donut({
      element: 'hero-donut',
      data: [
        {label: 'Jam', value: 25 },
        {label: 'Frosted', value: 40 },
        {label: 'Custard', value: 25 },
        {label: 'Sugar', value: 10 }
      ],
        colors: ['#3498db', '#2980b9', '#34495e'],
      formatter: function (y) { return y + "%" }
    });
   
    $('.code-example').each(function (index, el) {
      eval($(el).text());
    });
  });
</script>

</head>
<body>
 <!--main content start-->
  <section id="main-content">
          <section class="wrapper site-min-height">
          
            <div class="row">
                  <div class="col-lg-12 main-chart">
                  
                  	<div class="row mtbox">
                  		
                  		<div class="col-md-6 col-sm-6 box0">
                  			<div class="box1">
					  			<span class="li_news"></span>
					  			<h3>10</h3>
                  			</div>
					  			<p>나에게 배정된 업무 갯수</p>
                  		</div>
                  		
                  		<div class="col-md-6 col-sm-6 box0">
                  			<div class="box1">
					  			<span class="li_stack"></span>
					  			<h3>23</h3>
                  			</div>
					  			<p>전체 업무 갯수</p>
                  		</div>
             		
             		</div>
             		<!-- /row mt -->	
          </div>
          </div>
          <h3><i class="fa fa-angle-right"></i> 차트구역</h3>
              <!-- page start-->
              <div id="morris">
                  <div class="row mt">
      
                      <div class="col-lg-6">
                          <div class="content-panel">
                              <h4><i class="fa fa-angle-right"></i> Chart</h4>
                              <div class="panel-body">
                                  <div id="hero-bar" class="graph"></div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="col-lg-6">
                          <div class="content-panel">
                              <h4><i class="fa fa-angle-right"></i> Chart </h4>
                              <div class="panel-body">
                                  <div id="hero-donut" class="graph"></div>
                              </div>
                          </div>
                      </div>
                      
                  </div>
                  
              </div>
              <!-- page end-->
              
              				<div class="row mt">
                      <!--CUSTOM CHART START -->
                      <div class="border-head">
                          <h3>VISITS</h3>
                      </div>
                      <div class="custom-bar-chart">
                          <ul class="y-axis">
                              <li><span>10.000</span></li>
                              <li><span>80</span></li>
                              <li><span>60</span></li>
                              <li><span>40</span></li>
                              <li><span>20</span></li>
                              <li><span>0</span></li>
                          </ul>
                          <div class="bar">
                              <div class="title"> AB </div>
                              <div class="value tooltips" data-original-title="8.500" data-toggle="tooltip" data-placement="top"> 80% </div>
                          </div>
                          <div class="bar ">
                              <div class="title">FEB</div>
                              <div class="value tooltips" data-original-title="5.000" data-toggle="tooltip" data-placement="top">50%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">MAR</div>
                              <div class="value tooltips" data-original-title="6.000" data-toggle="tooltip" data-placement="top">60%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">APR</div>
                              <div class="value tooltips" data-original-title="4.500" data-toggle="tooltip" data-placement="top">45%</div>
                          </div>
                          <div class="bar">
                              <div class="title">MAY</div>
                              <div class="value tooltips" data-original-title="3.200" data-toggle="tooltip" data-placement="top">32%</div>
                          </div>
                          <div class="bar ">
                              <div class="title">JUN</div>
                              <div class="value tooltips" data-original-title="6.200" data-toggle="tooltip" data-placement="top">62%</div>
                          </div>
                          <div class="bar">
                              <div class="title">JUL</div>
                              <div class="value tooltips" data-original-title="7.500" data-toggle="tooltip" data-placement="top">75%</div>
                          </div>
                      </div>
                      <!--custom chart end-->
					</div><!-- /row -->	
					
                  </div><!-- /col-lg-9 END SECTION MIDDLE -->
              
          </section>
      </section><!-- /MAIN CONTENT -->

</body>
</html>