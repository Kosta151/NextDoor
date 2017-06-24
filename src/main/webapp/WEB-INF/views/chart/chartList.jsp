<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <!-- js placed at the end of the document so the pages load faster -->
   <<script src="resources/main/assets/js/jquery.js"></script>
    <script src="resources/main/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="resources/main/assets/js/jquery.scrollTo.min.js"></script>
    <script src="resources/main/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="resources/main/assets/js/circle-progress.js"></script> 

    <!--common script for all pages-->
	<script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
    <script src="resources/main/assets/js/common-scripts.js"></script>

<script type="text/javascript">
var Script = function () {
    //morris chart

    $(function () {
      // data stolen from http://howmanyleft.co.uk/vehicle/jaguar_'e'_type
      Morris.Line({
        element: 'examplefirst',
        xkey: 'year',
        ykeys: ['value'],
        labels: ['Value'],
        data: [
          {year: '2010', value: 10},
          {year: '2015', value: 20},
          {year: '2020', value: 30},
          {year: '2030', value: 40},
          {year: '2040', value: 50},
          {year: '2050', value: 10},
          {year: '2060', value: 10},
          {year: '2070', value: 20},
          {year: '2080', value: 30},
          {year: '2090', value: 40},
          {year: '2100', value: 50},
          {year: '2110', value: 600}
        ]
      });

      Morris.Bar({
        element: 'hero-bar',
        data: [
          {device: 'iPhone', geekbench: 136},
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
/*       $('.code-example').each(function (index, el) {
        eval($(el).text());
      }); */
    });

}();
</script>
</head>
<body>
 <!--main content start-->
      <section id="main-content">
          <section class="wrapper site-min-height">
         <h3><i class="fa fa-angle-right"></i> Morris Charts</h3>
          	<div id="morris">
          		<!--  page start -->
             
                  <div class="row mt">
                  		
      				<div class="showback">
      					<h4><i class="fa fa-angle-right"></i> 프로젝트 진행률</h4>
	      				<div class="progress progress-striped active">
						  <div class="progress-bar"  role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
						    <span class="sr-only">45% Complete</span>
						  </div>
						</div>
      				</div>
                  	
                      <div class="col-lg-6">
                          <div class="content-panel">
                              <h4><i class="fa fa-angle-right"></i> 업//무//별//진//척//률(%)</h4>
                              <div class="panel-body">
                                   <div id="examplefirst" class="graph"></div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="col-lg-6">
                          <div class="content-panel">
                              <h4><i class="fa fa-angle-right"></i> 날/짜/별/진/척/률(%)</h4>
                              <div class="panel-body">
                                  <div id="hero-bar" class="graph"></div>
                              </div>
                          </div>
                      </div>
              </div>
           <!--    page end -->
          	</div>
          	<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
          </section>
      </section><!-- /MAIN CONTENT -->
</body>
</html>