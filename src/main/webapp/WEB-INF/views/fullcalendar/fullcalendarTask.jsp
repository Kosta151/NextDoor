<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
   uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 달콤한 얼럿 -->
<script src="resources/main/assets/js/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/main/assets/css/sweetalert.css">
<!-- DatePicker(UI) -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"> 
<link href="resources/main/assets/css/style2.css" rel="stylesheet">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$.ajax({
	url:"owner.htm",
	type:"get",
	dataType : "json",
	success : function(data){
		console.log("죽는다:" + data.owner);
		console.log("유저유저:" + data.user);
		cal(data.owner , data.user);
		
	}
});

function cal(owner,user){
/* 	console.log("안녕:" +title);
	console.log("너도 안녕:" + content); */
	console.log("안녕:" +owner);
	console.log("gg" + user)
   	 $('#calendar').fullCalendar({
     	
		 header: {
		      left: 'prev,next today',
		      center: 'title',
		      right: 'month,agendaWeek,agendaDay'
		    },
      
        /* editable: true, */
        selectable:true,
        select: function() {
        	if(owner == user){
        		 $('#myModal2').modal();
        	}
           },
        
    events: 
        {
            url : 'clist.htm'
        },
		});
}

$('#specifictask_start').datepicker({
   dateFormat: "yy-mm-dd"
});
$('#specifictask_end').datepicker({
   dateFormat: "yy-mm-dd"
   
});
</script>

<script type="text/javascript">
	
	$(function(){
		$("#calendaralarm").click(function(){
	         if($("#specifictask_cont").val()==""){
	            swal("상세업무명을 입력해주세요"); 
	            $("#specifictask_cont").focus();
	            return false;
	         }else if($("#specifictask_start").val()==""){
	             swal("업무시작일을 입력해주세요");
	            $("#specifictask_start").focus();
	            return false;
	            
	         }else if($("#specifictask_end").val()==""){
	            swal("업무마감일을 입력해주세요");
	             $("#specifictask_end").focus();
	             return false;
	         }else{
	             swal({
	                       title: "등록 성공!",
	                       type: "success",
	                       showCancelButton: false,
	                       confirmButtonColor: "#194f89",
	                       confirmButtonText: "확인",
	                       closeOnConfirm: false
	                       
	                     },
	                     function(isConfirm){
	                         if (isConfirm) {
	                            location.href="insertfullcalendartask.htm";
	                             $('#modalform').submit();
	                         }
	                   }
	             );
	           
	         }
	         
	         }); 
	});
</script>
<title>Insert title here</title>
<style>
   body {
       margin: 40px 10px;
        padding: 0;
        font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
        font-size: 18px;
        }
</style>

</head>
<body>

       <section id="main-content">
          <section class="wrapper">
          	 <h3><i class="fa fa-angle-right"></i> 세부업무명 과 날짜를 확인하세요</h3>
              <!-- page start-->
              <div class="row mt">
                  <aside class="col-lg-2 mt">
                  </aside>
                  <aside class="col-lg-8 mt">
                      <section class="panel">
                          <div class="panel-body">
                              <div id="calendar" class="has-toolbar"></div>
                          </div>
                      </section>
                  </aside>
              </div>
              <!-- page end-->
		</section>
      </section><!-- /MAIN CONTENT -->
      
      
					  <!-- Modal -->
                      <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal2" class="modal fade">
                          <div class="modal-dialog modal-sm">
                              <div class="modal-content" style="width: 352px;">
                                  <div class="modal-header">
                                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                      <h4 class="modal-title">업무 생성</h4>
                                  </div>
                                  <form action="insertfullcalendartask.htm" method="post"  id="modalform">
                                  <div class="modal-body">
                                   <select name="task_no" style="width: 322px;">
	                                		 <option selected="selected">업무를 선택해주세요</option>
	                                 <c:forEach items="${tasklist}" var="list">
	                               		 <option value="${list.task_no}">${list.task_cont}</option>
	                                 </c:forEach>
									</select> 
                                      <p>상세 업무명</p>                                  
										<input type="text" id="specifictask_cont" name="specifictask_cont" placeholder="상세업무명을 입력해주세요." autocomplete="off" class="form-control placeholder-no-fix">
										<br> 
									 <select name="member_id" id="calendar_receiver" style="width: 322px;">
	                                		 <option selected="selected">업무 배정할 인원을 선택하세요</option>
	                                 <c:forEach items="${memberlist}" var="mlist">
	                               		 <option value="${mlist.member_id}"> ${mlist.member_id}</option>
	                                 </c:forEach>
									</select> 
									<input type="text"  name="specifictask_start"  id="specifictask_start" placeholder="일정의 시작" class="form-control placeholder-no-fix"><br> 
                 				  <input type="text"  name="specifictask_end" id="specifictask_end" placeholder="일정의 마지막" class="form-control placeholder-no-fix"><br>
                                  </div>
                                  <div class="modal-footer centered">
                                      <button class="btn btn-warning" type="button" id="calendaralarm">생성</button>
                                      <button data-dismiss="modal" class="btn btn-default" type="button">취소</button>
                                  </div>
                                  </form>
                              </div>
                          </div>
                      </div><!-- modal -->

</body>
</html>