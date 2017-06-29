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
            // 무한 스크롤링 실행 이벤트
            var bool_sw = true;
            var start_idx = 0;
            var cont = "";
            var taskno = "";
            var speicficcont="";
            var projectno="";
            var cidx=0;
            var end_idx=0;
			$(window).scroll(function() {

				if ($(window).scrollTop() == $(document).height() - $(window).height()){
	                    
	              	if(bool_sw){
						
	              		infinite();
	              		}
	              	
	              		      
	       	     }
	            });
			infinite();      
	       function infinite(){    	 
            $.ajax({
    			url : "tasklist.htm",
    			type : "post",
    			data : {idx:start_idx},
    			dataType : "json",
    			success : function(data){
    				var taskcont = "";
    				var taskcomp = "";
    				
    				
    				start_idx = start_idx+5;
    				
    				console.log("end_idx" + end_idx);
    				console.log("cidx" + cidx);
    				
    				if(end_idx!=cidx){
    					bool_sw=false;
    				}
    				cidx = cidx+5;
    				console.log(bool_sw);
    				
    				$(".ajaxtest").append("<div id='"+start_idx+"containtask' style='float:left; width : 100%; height : 500px;' margin:'20px;'>");
    				$.each(data.data , function(index,obj){	
    					
    					end_idx++;
    					
   					 
    					 taskcont = "<div class='taskcont' id='"+obj.task_no+"tasktitle'>"
    						 + "<input type='text' class='taskinput ' value='"+obj.task_cont+"'>"
    						 + "<div class='dropdown btn-alian' style='margin-top:3px;'>"
    						 + "<a class='dropdown-toggle' data-toggle='dropdown'>"
    						 + "<i class='fa fa-plus' ></i></a>"
    						 + "<div class='dropdown-menu taskbox'>"    						
    						 + "<form  onsubmit='return false;'><div class='modal-header taskcont'>"
    						 + "<h4 class='modal-title'>세부업무생성</h4></div><div class='modal-body'>"
    						 + "<p>세부업무명</p>"
    						 + "<input type='text' id='"+obj.task_cont+"cont' name='specifictask_cont' placeholder='세부업무명을 입력해주세요.' autocomplete='off' class='form-control placeholder-no-fix'>"
    						 + "<input type='hidden' id='"+obj.task_no+"task_no' name='task_no' value='"+obj.task_no+"'>"
    						 + "</div><div class='modal-footer centered'>" 
    						 + "<button class='btn btn-theme03' id='"+obj.task_no+"submit'>생성</button>"
    						 + "<button data-dismiss='modal' class='btn btn-theme04' type='button'>취소</button>"
    						 + "</div></form></div></div>"
    						 + "<a class='dropdown-toggle'></a>"
    					  	 + "<div id='"+obj.task_no+"delete' style='height : 16px; width:12px; float:right; margin-right:10px; margin-top:2px;'>"
    						 + "<i class='fa fa-trash-o' >"		
    						 + "</i></div>"
    						 + "</div>";
    					 
    						 
    						 
   						 taskcomp = "<div id='"+obj.task_no+"comp'>"
	 		  				+ "<div class='taskcomp'>완료된 업무</div>"
	 		 				+ "</div>"
    					    					 			
    					 $("#"+start_idx+"containtask").append("<div id='"+obj.task_no+"task' style='margin:10px; height:100%;' class='taskbox'>");
    					 $("#"+obj.task_no+"task").append(taskcont);
    					 $("#"+start_idx+"containtask").append("</div>");
    					 $("#"+obj.task_no+"task").append(taskcomp);
    					 
    					 
    					
    					 cont = $("#"+obj.task_cont+"cont").val();
    					 
    					 
    					 
    					//insert event 
    					$("#"+obj.task_no+"submit").click(function(){

    						taskno = obj.task_no;
        					cont = $("#"+obj.task_cont+"cont").val();
        					 
    						console.log("cont : " + cont);
    						console.log("taskno : " + taskno);
    						
    						 insertspecific(cont,taskno);
    					});
    					
    					//delete event
    		 			 $("#"+obj.task_no+"delete").click(function(){
    						alert("delete");
    						projectno = obj.project_no;
    						 taskno = obj.task_no;
    						console.log("projectno : " + projectno);
    						console.log("taskno : " + taskno);
    						deletespecific(projectno, taskno);
    					}); 
    						
    					
    					
    					 
    					 
    					 //세부 리스트 뿌리는 부분
    					 $.ajax({
    						 url : "specifictask.htm",
    						 type : "post",
    						 data : {task_no : obj.task_no},
    						 dataType : "json",
    						 success : function(data){
    							console.log(data.data);
    							
    							 
    							 
    							 var comp="";
    							    						  					 		 				
    							 $.each(data.data, function(spindex, spobj){
    								
    								 if(obj.task_no=spobj.task_no){
    									 
    									 console.log(comp);
    									 speicficcont="<div class='specifictaskbox' style='background-color : none;' id='"+spobj.specifictask_no+"specific'>"
    									 	  + spobj.specifictask_cont   									 	  						 	  	
	   									 	  + "<a class='dropdown-toggle'  style='float;right; margin-right:10px;'>"    	
	   									 	  + "<button style='background-color: window;' id='"+spobj.specifictask_no+"toggletest' value='"+spobj.specifictask_no+"'>" 
	   									 	  + "<i class='fa fa-pencil'>"    									 	
	   									 	  + "</i></button></a>"  
	   									 	  + "<input type='checkbox' class='sp-checkbox' id='"+spobj.specifictask_no+"sp-checkbox' value='"+spobj.specifictask_no+"'>"
	   									 	  + "</div>";
 							 	
    									 	 comp = spobj.specifictask_comp; 									 	
    									if(comp==0){
    										 $("#"+obj.task_no+"tasktitle").append(speicficcont);
    									 }else if(comp==1){
    										 $("#"+obj.task_no+"comp").append(speicficcont);
    									 } 							
    									 var spcont =speicficcont;		
    									 
    									 //작업 확인 버튼
    									 $("#"+spobj.specifictask_no+"sp-checkbox").click(function(){
    										alert("세부 업무 번호" + spobj.specifictask_no); 
    										var specifictaskno=spobj.specifictask_no;
    										var taskno = obj.task_no;
    										checkspecifictask(specifictaskno,taskno,spcont);
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
								            $('#toggletest_jjh').hide(1000); 
								            
									    } else {
									            $('#main-content').css({
									                'margin-right': '0px'
									            });
									             $('#toggletest_jjh').slideToggle();   
									            $('#toggletest_jjh').css({
									                'margin-right': '0'
									            }); 
									             
									            
									         }  
								        var specifictaskno=spobj.specifictask_no;
								        /* var specifictaskcont=spobj.specifictask_cont; */
								        detailSpecifictask(specifictaskno);
								        /* var specifictaskstart = $('#specifictask_start').val();
								        var specifictaskend = $('#specifictask_end').val(); */
								        
									    
									 });
								 
								 
								 
							 });
							 
							
						 },
    						 error : function(){
    							alert("error");
    						 }
    					 });   				
    				});
    				 $(".ajaxtest").append("</div>");
    			},
    			error : function(){
    				alert("error");
    			}
    		});
           
	      }
		
        });
        
       
        //작업완료 버튼 클리시  실행
        function checkspecifictask(specifictaskno,taskno,spcont){
        	
       	  $.ajax({
				 url : "checkspecifictask.htm",
				 type : "post",
				 data : {specifictask_no :  $("#"+specifictaskno+"sp-checkbox").val()},
				 success : function(data){
					console.log(data);
					 alert("success");
					
					$("#"+specifictaskno + "specific").hide();
					$("#" +taskno+"task").append(spcont);
					
				
				 },
				 error : function(){
					alert("error");
				 }
			 }); 
       }
        

        //insert
        function insertspecific(cont,taskno){
        	
        	console.log("taskno : "+taskno);
        	console.log("cont: "+cont);
        	
         	  $.ajax({
  				 url : "insertspecifictask.htm",
  				 type : "post",
  				 data : {specifictask_cont : cont, task_no : taskno},
  				 dataType : "json",
  				 success : function(data){
  					alert("success");
  					
  					  var insertspecific = "<div class='specifictaskbox' style='background-color : none;' id='"+taskno.cont+"specific'>"
				 	  + cont   									 	  						 	  	
				 	  + "<a class='dropdown-toggle'  style='float;right; margin-right:10px;'>"    					
				 	  + "<i class='fa fa-pencil'>"    									 	
				 	  + "</i></a></a>"  
				 	  + "<input type='checkbox' class='sp-checkbox' id='"+taskno+1+"sp-checkbox' value='"+taskno+1+"'>"
				 	  + "</div>";
  					
  					
  					
  					
  					
  					
  					 $("#"+taskno+"tasktitle").append(insertspecific);
  				 },
  				 error : function(){
  					 }
  				 });
        }
  				

         function detailSpecifictask(specifictaskno,specifictaskcont){
        	console.log(specifictaskno);  
         	  $.ajax({
  				 url : "detailSpecifictaskajax.htm",
  				 type : "post",
  				 data : {specifictask_no : $("#"+specifictaskno+"toggletest").val()},			 
  				 dataType : "json",
  				 success : function(data){
  					 	
  					 	console.log(data.data);
  					 				
  					 if(data.data!=null){
  						 $("#specifictask_start").val(data.data.specifictask_start);
  						 $("#specifictask_end").val(data.data.specifictask_end);
  						 $("#taskmember_id").val(data.data.member_id); 
  						 $("#specifictask_no").val(specifictaskno);
  						 $(".specifictask_no").val(specifictaskno);
  						 
  					 }else{			 
  						 $("#specifictask_start").val("");
  						 $("#specifictask_end").val("");
  						 $("#taskmember_id").val(""); 
  						 $("#specifictask_no").val(specifictaskno);
  						 $(".specifictask_no").val(specifictaskno);
  					 } 						

  				 },
  				 error : function(){
  					alert("error");
  				 }
  			 }); 

         } 

         //delete
		 function deletespecific(projectno, taskno){
        	
        	console.log("taskno : "+taskno);
        	console.log("projectno: "+projectno);
        	
         	  $.ajax({
  				 url : "deletetask.htm",
  				 type : "post",
  				 data : {project_no : projectno, task_no : taskno},
  				 success : function(data){
  					alert("success");
  					$("#"+taskno+"task").remove();
  					
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