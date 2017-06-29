<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="resources/main/assets/js/sweetalert.min.js"></script>
<link href="resources/main/assets/css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/main/assets/css/sweetalert.css">
<script src="<%=request.getContextPath() %>/resources/task/jquery.form.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/task/jQuery.MultiFile.min.js"></script>
<section id="main-content" style="width:auto; overflow: scroll;">
<script type="text/javascript">
$(function(){
	
	/* 업무 생성 */
	$("#taskbtn").click(function(){
	   if($("#task_cont").val()==""){
	      swal("업무명을 입력해주세요");
	      $("#task_cont").focus();
	      return false;
	   }else{
	      /* swal('프로젝트 생성!', 'You clicked the button!', 'success') */
	       swal({
                 title: "업무 생성 완료!",
                 type: "success",
                 showCancelButton: false,
                 confirmButtonColor: "#194f89",
                 confirmButtonText: "확인",
                 closeOnConfirm: false      
               },
	        	 function(isConfirm){
	        		  if (isConfirm) {
	        			  location.href="insertTask.htm";
	        				$('#taskform').submit();
	        		  	}
				 	}
	       		);
	      		}
	   		});
	
	/* 무한 스크롤링 이벤트 */
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
	
	/* 업무 리스트 */
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
				 	 
				//세부업무 생성 (insert)
				$("#"+obj.task_no+"submit").click(function(){

					taskno = obj.task_no;
					cont = $("#"+obj.task_cont+"cont").val();
					 
					console.log("cont : " + cont);
					console.log("taskno : " + taskno);
					
					insertspecific(cont,taskno);
				});
				
				//세부업무 삭제 (delete)
	 			 $("#"+obj.task_no+"delete").click(function(){
					alert("delete");
					projectno = obj.project_no;
					taskno = obj.task_no;
					console.log("projectno : " + projectno);
					console.log("taskno : " + taskno);
					deletespecific(projectno, taskno);
				}); 
 
				 //세부업무 리스트 (select)
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
								 
								 //세부업무 확인 버튼
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
	
	}); //end
	
	/* function start */
	//세부업무작업완료
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
    

    //세부업무 생성
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
					 alert("error");
				 }
		});
    }
				
	//세부업무삭제
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

     //업무 삭제
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

</script>
	<section class="wrapper site-min-height">
    	<div>
        	<div>
            <h3><i class="fa fa-angle-right"></i> ${project_name}</h3>
            <button type="button" class="btn btn-theme02" data-toggle="modal"
               data-target="#myModal">
               <i class="fa fa-plus"></i> 업무 리스트 추가
            </button>
			<!-- 업무리스트 추가 Modal -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
               tabindex="-1" id="myModal" class="modal fade">
               <div class="modal-dialog">
                  <div class="modal-content">
                     <form action="insertTask.htm" id="taskform">
                        <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal"
                              aria-hidden="true">&times;</button>
                           <h4 class="modal-title">새 업무생성</h4>
                        </div>
                        <div class="modal-body">
                           <p class="centered"></p>
                           <p>업무명</p>
                           <input type="text" id="task_cont" name="task_cont"
                              placeholder="업무명을 입력해주세요." autocomplete="off"
                              class="form-control placeholder-no-fix"> <input
                              type="hidden" id="project_no" name="project_no"
                              value="${project_no}">
                        </div>
                        <div class="modal-footer centered">
                           <button class="btn btn-theme03" type="button" id="taskbtn">생성</button>
                           <button data-dismiss="modal" class="btn btn-theme04"
                              type="button">취소</button>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
		<!-- 업무리스트 추가 modal end -->
		<!-- 업무 목록 보여지는 부분 -->
	    <div class="col-lg-9">
	       <div class="ajaxtest"></div>
	       <div id="ajaxspecific"></div>
		</div>  
</div>

<div class="col-lg-3" id="toggletest_jjh">
	<div class="form-panel" style="height: 550px;">
		<div class="tab">
			<hr>
	     	<button class="tablinks btn btn-primary" onclick="openCity(event, 'London')" id="defaultOpen" style=" margin-left:20px; width:40%;  background-color: #fafafa; color: black; ">속성</button>
	     	<button class="tablinks btn btn-danger" onclick="openCity(event, 'Paris')" style="width:40%; background-color: #fafafa; color: black;">파일</button>
	     	<hr>
	   	</div>
	   	
	   	<!-- 속성 -->
		<div id="London" class="tabcontent">		
		<form action="updateSpecifictask.htm" method="post">
	  	 <div class="form-group">
	  	  	<p>세부업무명 :	
			<input id="specont" type="text" name="specifictask_cont" value="${specifictask_cont}" readonly="readonly"></p>
		</div>
	  	<hr> 
		<div class="form-group">
        	<label>업무배정  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            	<select name="member_id">
                	<option value="${modidto.member_id}">${modidto.member_id}</option>   
                    	<c:forEach items="${memberlist}" var="mlist">         
                        	<option value="${mlist.member_id}" >${mlist.member_id}</option>   
                        </c:forEach>                     
                 </select>
        	<p>배정된 인원 : <input type="text" readonly="readonly" id="taskmember_id" name="memberid" value="${modidto.member_id}"></p>
		</div>
		<hr>	      
     	<label>
       		<i></i>기간설정
        </label> 
			<div class="form-group">
			    <p>시작일:<input class="form-control form-control-inline input-medium default-date-picker" width="50%" type="text" value="${modidto.specifictask_start}" id="specifictask_start" name="specifictask_start"></p>
			    <%-- <input type="text" id="specifictask_start" name="specifictask_start" value="${modidto.specifictask_start}"></p> --%>
		    </div>      
            <div class="form-group">
			    <p>마감일:<input class="form-control form-control-inline input-medium default-date-picker" size="8" type="text" value="${modidto.specifictask_end}" id="specifictask_end" name="specifictask_end"></p>
			    <%-- <input type="text" id="specifictask_start" name="specifictask_start" value="${modidto.specifictask_start}"></p> --%>
		    </div> 
			    <input type="hidden" id="specifictask_no" name="specifictask_no" value="">
		        <button type="submit" class="btn btn-primary" style="float: left;margin-left: 30px; width:30%; background-color: #ffd777; color:navy;">수정</button>
		       	<%-- <button type="button"><a href="deleteSpecifictask.htm?specifictask_no=${specifictaskno}">업무삭제</a></button> --%>                      
	    </form> 
	    <form action="deleteSpecifictask.htm">  
	       	<input type="hidden" class="specifictask_no" name="specifictask_no" value="">  
	       	<button type="submit" class="btn btn-danger" style="float: left;margin-left: 10px; width:30%; background-color: #ffd777; color:navy;">삭제</button>
		</form>
		</div>
		
		<!-- 파일 -->
		<div id="Paris" class="tabcontent">
     	<form name="multiform" id="multiform" class="form-horizontal style-form" action="uploadfile.htm" method="post" enctype="multipart/form-data">
	       	<div>
	          <label>파일업로드</label>
	          <input type="hidden" name="specifictask_no" value="${specifictask_no}"> 
	          <input type="file" name="file">
	          <div id="afile3-list" style="border:2px solid #c9c9c9;min-height:50px"></div> 
	       	</div>   
	       	<br>             
	       	<button id="btnSubmit" type="submit" class="btn btn-primary" style="background-color: #ffd777; color:navy;">파일올리기</button> 
      	</form>
   		</div>
   		<div id="result"></div>      	
	</div><!-- form-panel end -->	
</div><!-- toggletest_jjh end -->


   </section>
</section>

<!-- 파일 업로드 비동기 -->
<script>

$(document).ready(function(){
    
    //use jQuery MultiFile Plugin 
    $('#multiform input[name=file]').MultiFile({
        max: 5, //업로드 최대 파일 갯수 (지정하지 않으면 무한대)
        accept: 'jpg|png|gif', //허용할 확장자(지정하지 않으면 모든 확장자 허용)
        maxfile: 1024, //각 파일 최대 업로드 크기
        maxsize: 3024,  //전체 파일 최대 업로드 크기
        STRING: { //Multi-lingual support : 메시지 수정 가능
            remove : "제거", //추가한 파일 제거 문구, 이미태그를 사용하면 이미지사용가능
            duplicate : "$file 은 이미 선택된 파일입니다.", 
            denied : "$ext 는(은) 업로드 할수 없는 파일확장자입니다.",
            selected:'$file 을 선택했습니다.', 
            toomuch: "업로드할 수 있는 최대크기를 초과하였습니다.($size)", 
            toomany: "업로드할 수 있는 최대 갯수는 $max개 입니다.",
            toobig: "$file 은 크기가 매우 큽니다. (max $size)"
        },
        list:"#afile3-list" //파일목록을 출력할 요소 지정가능
});
</script>

<script>

/*jQuery form 플러그인을 사용하여 폼데이터를 ajax로 전송*/

var downGroupCnt =0; //다운로드그룹 개수카운트

$(function(){
    
    //폼전송 : 해당폼의 submit 이벤트가 발생했을경우 실행  
    $('#multiform').ajaxForm({
       cache: false,
       dataType:"json",
       //보내기전 validation check가 필요할경우
       beforeSubmit: function (data, frm, opt) {
           //console.log(data);
           alert("전송전!!");
           return true;
       },
       //submit이후의 처리
       success: function(data, statusText){
           
           alert("전송성공!!");
           console.log(data); //응답받은 데이터 콘솔로 출력         
           
           output(data); //받은 정보를 화면 출력하는 함수 호출
       },
       //ajax error
       error: function(e){
           alert("에러발생!!");
           console.log(e);
       }                               
    });
});

//전달받은 정보를 가지고 화면에 보기 좋게 출력
function output(data) {
    //업로드한 파일을 다운로드할수있도록 화면 구성
    $("#result").append("<h3>("+(++downGroupCnt)+") 다운로드</h3>");
    $("#result").append("제목:"+data.title+"<br/>");
    $("#result").append("설명:"+data.description+"<br/>");
  
    if(data.file && data.file.length != 0){
        $("#result").append("파일:<br/>");           
        $.each(data.file, function(index, item){
            //var link = "fileDownload2?f="+item.fileName+"&of="+item.uploadedFileName;
            $("#result").append("<a href='"+ item.downlink +"' download>"+item.fileName+"</a>");
           $("#result").append("<br/>");                   
        });
    }       
    
    $('#multiform')[0].reset(); //폼 초기화(리셋);
    //$('#multiform').resetForm(); //(jQuery.Form 플러그인 메서드)
    //$('#multiform').clearForm(); //(jQuery.Form 플러그인 메서드)  
    $('#multiform input:file').MultiFile('reset'); //멀티파일 초기화        
}

</script>
<script>

/*jQuery form 플러그인을 사용하여 폼데이터를 ajax로 전송*/
var downGroupCnt =0; //다운로드그룹 개수카운트

$(function(){
    
    //폼전송 : 해당폼의 submit 이벤트가 발생했을경우 실행  
    $('#multiform').ajaxForm({
       cache: false,
       dataType:"json",
       //보내기전 validation check가 필요할경우
       beforeSubmit: function (data, frm, opt) {
           //console.log(data);
           alert("전송전!!");
           return true;
       },
       //submit이후의 처리
       success: function(data, statusText){
           
           alert("전송성공!!");
           console.log(data); //응답받은 데이터 콘솔로 출력         
           
           output(data); //받은 정보를 화면 출력하는 함수 호출
       },
       //ajax error
       error: function(e){
           alert("에러발생!!");
           console.log(e);
       }                               
    });
});

//전달받은 정보를 가지고 화면에 보기 좋게 출력
function output(data) {
    //업로드한 파일을 다운로드할수있도록 화면 구성
    $("#result").append("<h3>("+(++downGroupCnt)+") 다운로드</h3>");
    $("#result").append("제목:"+data.title+"<br/>");
    $("#result").append("설명:"+data.description+"<br/>");
  
    if(data.file && data.file.length != 0){
        $("#result").append("파일:<br/>");           
        $.each(data.file, function(index, item){
            //var link = "fileDownload2?f="+item.fileName+"&of="+item.uploadedFileName;
            $("#result").append("<a href='"+ item.downlink +"' download>"+item.fileName+"</a>");
           $("#result").append("<br/>");                   
        });
    }       
    
    $('#multiform')[0].reset(); //폼 초기화(리셋);
    //$('#multiform').resetForm(); //(jQuery.Form 플러그인 메서드)
    //$('#multiform').clearForm(); //(jQuery.Form 플러그인 메서드)  
    $('#multiform input:file').MultiFile('reset'); //멀티파일 초기화        
}
</script>




<!-- tab 자바스크립트 -->
<script>
   function openCity(evt, cityName) {
      var i, tabcontent, tablinks;
      tabcontent = document.getElementsByClassName("tabcontent");
      for (i = 0; i < tabcontent.length; i++) {
         tabcontent[i].style.display = "none";
      }
      tablinks = document.getElementsByClassName("tablinks");
      for (i = 0; i < tablinks.length; i++) {
         tablinks[i].className = tablinks[i].className
               .replace(" active", "");
      }
      document.getElementById(cityName).style.display = "block";
      evt.currentTarget.className += " active";
   }

   // Get the element with id="defaultOpen" and click on it
   document.getElementById("defaultOpen").click();
</script>