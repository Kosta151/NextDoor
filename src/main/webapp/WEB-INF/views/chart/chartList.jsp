<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/main/assets/css/style2.css" rel="stylesheet">

<script type="text/javascript">
$(function () {
	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: '업무별 완료 상황 상태'
	    },
	    xAxis: {
	        categories: ['업무1', '업무2', '업무3', '업무4', '업무5','업무6','업무7']
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: '완료/미완료'
	        }
	    },
	    tooltip: {
	        pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
	        shared: true
	    },
	    plotOptions: {
	        column: {
	            stacking: 'percent'
	        }
	    },
	    series: [{
	        name: '완료된 세부업무',
	        data: [5, 3, 4, 7, 2, 4,8]
	    }, {
	        name: '미완료된 세부업무',
	        data: [2, 2, 3, 2, 1, 8,2]
	    }
/* 	    , {
	        name: 'Joe',
	        data: [3, 4, 4, 2, 5, 7]
	    } */
	    ]
	});
});
</script>

</head>
<body>
 <!--main content start-->
  <section id="main-content">
          <section class="wrapper site-min-height">
           <!--  <div class="row">
                  <div class="col-lg-12 main-chart">
                  
                  	<div class="row mtbox">
                  		
                  		<div class="col-md-6 col-sm-6 box0">
                  			<div class="box1">
					  			<span class="li_news"></span>
					  			<h3>1</h3>
                  			</div>
					  			<p>나에게 배정된 업무 갯수</p>
                  		</div>
                  		
                  		<div class="col-md-6 col-sm-6 box0">
                  			<div class="box1">
					  			<span class="li_stack"></span>
					  			<h3>15</h3>
                  			</div>
					  			<p>전체 업무 갯수</p>
                  		</div>
             		
             		</div>
             		/row mt	
          </div>
          </div> -->
		
              
          </section>
      </section><!-- /MAIN CONTENT -->

</body>
</html>