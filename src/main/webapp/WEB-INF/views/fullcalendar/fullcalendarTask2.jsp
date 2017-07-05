<%--
   @Project : NextDoor
   @File name : fullcalendarTask2.jsp
   @Author : 최성용
   @Data : 2017. 07.05
   @Desc : 상세업무 추가 , 업무 배정, 시작일, 마감일
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Sweet alert -->
<script src="resources/main/assets/js/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/main/assets/css/sweetalert.css">

<!-- DatePicker(UI) -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"> 
<link href="resources/main/assets/css/style2.css" rel="stylesheet">

<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <%----------------------------------------------------
멤버와 오너를 비교해서 멤버만 insert 만 할수 있게, 멤버는 추가를 못하고 볼수 만 있다
 ----------------------------------------------------%> 
<script type="text/javascript">
$.ajax({
	url:"owner.htm",
	type:"get",
	dataType : "json",
	success : function(data){
		cal(data.owner , data.user);
		
	}
});

<%----------------------------------------------------
Controller 에서 받아서 events 에서 json 으로 뿌려짐 , 달력은 josn 이다
 ----------------------------------------------------%>  
function cal(owner,user){
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
<style>
   body {
       margin: 40px 10px;
        padding: 0;
        font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
       font-size: 15px;
        }
</style>

<title>Insert title here</title>
</head>
<body>

       <section id="main-content">
          <section class="wrapper">
          	 <h2><i class="fa fa-angle-right"></i> 세부업무명 과 날짜를 확인하세요</h2>
              <!-- page start-->
              <div class="row mt">
                  <aside class="col-lg-2 mt">
                  </aside>
                  <aside class="col-lg-8 mt">
                      <section class="panel">
                          <div class="panel-body">
                           <%----------------------------------------------------
							calendar 호출 되는 부분
 							----------------------------------------------------%>  
                              <div id="calendar" class="has-toolbar"></div>
                          </div>
                      </section>
                  </aside>
              </div>
              <!-- page end-->
		</section>
      </section><!-- /MAIN CONTENT -->
      
 <%----------------------------------------------------
세부업부명 insert , 시작일/마감일 insert 
 ----------------------------------------------------%>       
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