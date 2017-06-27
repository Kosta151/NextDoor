<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title><tiles:insertAttribute name="title" /></title>

    <!-- Bootstrap core CSS -->
    <link href="resources/main/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="resources/main/assets/js/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
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
    <script src="resources/main/assets/js/fullcalendar/fullcalendar.min.js"></script>
    <script src="resources/main/assets/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="resources/main/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="resources/main/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="resources/main/assets/js/jquery.scrollTo.min.js"></script>
    <script src="resources/main/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="resources/main/assets/js/jquery.sparkline.js"></script>
	
	
    <!--common script for all pages-->
   	<script src="resources/main/assets/js/common-scripts.js"></script>
   	<script type="text/javascript" src="resources/main/assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="resources/main/assets/js/gritter-conf.js"></script> 
    <script src="resources/main/assets/js/calendar-conf-events.js"></script>
   	
    <!--script for this page-->
  	<script src="resources/main/assets/js/sparkline-chart.js"></script>    
	<script src="resources/main/assets/js/zabuto_calendar.js"></script>	
	
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
            
            $.ajax({
    			url : "tasklist.htm",
    			type : "post",
    			dataType : "json",
    			success : function(data){
    				var taskcont = "";
    				var taskcomp = "";

    				$.each(data.data , function(index,obj){	
    					 taskcont = "<div class='taskcont' id='"+obj.task_no+"tasktitle'>"
    						 + "<input type='text' class='taskinput' value='"+obj.task_cont+"'>"
    						 + "<div class='dropdown btn-alian' >"
    						 + "<button class='btn btn-success btn-xs btn-pualian' data-toggle='dropdown'>"
    						 + "<i class='fa fa-plus'></i></button>"
    						 + "<div class='dropdown-menu taskbox'>"    						
    						 + "<form action='insertspecifictask.htm'><div class='modal-header taskcont'>"
    						 + "<h4 class='modal-title'>세부업무생성</h4></div><div class='modal-body'>"
    						 + "<p>세부업무명</p>"
    						 + "<input type='text' name='specifictask_cont' placeholder='세부업무명을 입력해주세요.' autocomplete='off' class='form-control placeholder-no-fix'>"
    						 + "<input type='hidden' name='task_no' value='"+obj.task_no+"'>"
    						 + "</div><div class='modal-footer centered'>" 
    						 + "<button class='btn btn-theme03' type='submit'>생성</button>"
    						 + "<button data-dismiss='modal' class='btn btn-theme04' type='button'>취소</button>"
    						 + "</div></form></div></div>"
    						 + "<button class='btn btn-danger btn-xs btn-alian'>"
    						 + "<a href='deletetask.htm?task_no="+obj.task_no+"&project_no="+obj.project_no+"'>"
    						 + "<i class='fa fa-trash-o'>"		
    						 + "</i></a></button>"
    						 + "</div>";
    					 
   						 taskcomp = "<div id='"+obj.task_no+"comp'>"
	 		  				+ "<h4>완료된 업무</h4>"
	 		 				+ "</div>"
    					    					 			
    					 $("#ajaxtest").append("<div id='"+obj.task_no+"task' style='margin:10px; height:100%; float:left; ' class='taskbox'>");
    					 $("#"+obj.task_no+"task").append(taskcont);
    					 $("#ajaxtest").append("</div>");
    					 $("#"+obj.task_no+"task").append(taskcomp);
    					 
    					 $.ajax({
    						 url : "specifictask.htm",
    						 type : "post",
    						 data : {task_no : obj.task_no},
    						 dataType : "json",
    						 success : function(data){
    							 var speicficcont="";
    							 var comp="";
    							    							   					 		 				
    							 $.each(data.data, function(spindex, spobj){
    								 if(obj.task_no=spobj.task_no){
    									 
    									 console.log(comp);
    									 speicficcont="<div class='specifictaskbox' style='background-color : none;' id='"+spobj.specifictask_no+"specific'>"
    									 	  + spobj.specifictask_cont   									 	  						 	  	
    									 	  + "<button class='btn btn-success btn-xs btn-alian'>"    	
    									 	  + "<a href='detailSpecifictask.htm?specifictask_no="+spobj.specifictask_no+"&specifictask_cont="+spobj.specifictask_cont+"'>" 
    									 	  + "<i class='fa fa-pencil'>"    									 	
    									 	  + "</i></a></button>"  
    									 	 
    									 	  + "<input type='checkbox' class='sp-checkbox' id='"+spobj.specifictask_no+"sp-checkbox' value='"+spobj.specifictask_no+"'>"
    									 	  + "</div>"
    									 	
    									 	/*  $("#"+obj.task_no+"task").append(speicficcont); */
    									 	 comp = spobj.specifictask_comp;
    									 	
    									if(comp==0){
    										 $("#"+obj.task_no+"tasktitle").append(speicficcont);
    									 }else if(comp==1){
    										 $("#"+obj.task_no+"comp").append(speicficcont);
    									 } 
    									   	 
    									 $("#"+spobj.specifictask_no+"sp-checkbox").click(function(){
    										alert("세부 업무 번호" + spobj.specifictask_no); 
    										var specifictaskno=spobj.specifictask_no;
    										var taskno = obj.task_no;
    										speicficcont
    										checkspecifictask(specifictaskno,taskno,speicficcont);
    									 });
    								 }
    								 
    								 $("#"+spobj.specifictask_no+"toggletest").click(function () {
    								        if ($('#toggletest_jjh').is(":visible") == true) {
    								            $('#main-content').css({
    								                'margin-left': '210px'
    								            });
    								            $('#toggletest_jjh').css({
    								                'margin-right': '-210px'
    								            });
    								            $('#toggletest_jjh').hide(); 
    								            $("#container").addClass("sidebar-closed");
    									    } else {
    									            $('#main-content').css({
    									                'margin-right': '0px'
    									            });
    									            $('#toggletest_jjh').show();
    									            $('#toggletest_jjh').css({
    									                'margin-right': '0'
    									            }); 
    									            $("#container").removeClass("sidebar-closed");
    									            
    									         } 
    								        
    									    
    									 });
    								 
    								 
    								 
    							 });
    							 
    							
    						 },
    						 error : function(){
    							alert("error");
    						 }
    					 });
    					 
    					 
    				});
    			},
    			error : function(){
    				alert("error")
    			}
    		});
        });
        
        function checkspecifictask(specifictaskno,taskno,speicficcont){
        	console.log(specifictaskno);
       	  $.ajax({
				 url : "checkspecifictask.htm",
				 type : "post",
				 data : {specifictask_no :  $("#"+specifictaskno+"sp-checkbox").val()},
				 success : function(data){
					console.log(data);
					 alert("success");
					
					$("#"+specifictaskno + "specific").hide();
					$("#" +taskno+"task").append(speicficcont);
					
				
				 },
				 error : function(){
					alert("error");
				 }
			 }); 
       }
        
        
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
    
</body>
</html> 