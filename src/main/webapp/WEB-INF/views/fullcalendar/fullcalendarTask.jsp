<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- DatePicker(UI) -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"> 
<link href="resources/main/assets/css/style2.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
   body {
      margin: 40px 10px;
      padding: 0;
      font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
      font-size: 14px;
        }
</style>

</head>
<body>
     <!--main content start-->
      <section id="main-content">
        <section class="wrapper site-min-height">
             <h3><i class="fa fa-angle-right"></i> 배정된 인원을 달력에서 확인해보세요</h3>
              <!-- page start-->
              <div class="row mt">
                   <aside class="col-lg-0 mt"></aside>
                  <aside class="col-lg-12 mt">
                      <section class="panel">
                          <div class="panel-body">
                              <div id="calendar"></div>
                          </div>
                      </section>
                  </aside>
              </div>
              <!-- page end-->
         </section>
      </section>
      <!-- /MAIN CONTENT -->
      
					  <!-- Modal -->
                      <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal2" class="modal fade">
                          <div class="modal-dialog modal-sm">
                              <div class="modal-content">
                                  <div class="modal-header">
                                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                      <h4 class="modal-title">업무 생성</h4>
                                  </div>
                                  <form action="insertfullcalendartask.htm" method="post">
                                  <div class="modal-body">
                                   <select name="task_no">
	                                		 <option selected="selected">업무를 선택해주세요</option>
	                                 <c:forEach items="${tasklist}" var="list">
	                               		 <option value="${list.task_no}">${list.task_cont}</option>
	                                 </c:forEach>
									</select> 
                                      <p>상세 업무명</p>                                  
										<input type="text" name="specifictask_cont" placeholder="상세업무명을 입력해주세요." autocomplete="off" class="form-control placeholder-no-fix">
										<br> 
									 <select name="member_id">
	                                		 <option selected="selected">업무 배정할 인원을 선택하세요</option>
	                                 <c:forEach items="${memberlist}" var="mlist">
	                               		 <option value="${mlist.member_id}"> ${mlist.member_id}</option>
	                                 </c:forEach>
									</select> 
									<input type="text"  name="specifictask_start"  id="specifictask_start" placeholder="일정의 시작"><br> 
                 				  <input type="text"  name="specifictask_end" id="specifictask_end" placeholder="일정의 마지막"><br>
                                  </div>
                                  <div class="modal-footer centered">
                                      <button class="btn btn-warning" type="submit">생성</button>
                                      <button data-dismiss="modal" class="btn btn-default" type="button">취소</button>
                                  </div>
                                  </form>
                              </div>
                          </div>
                      </div><!-- modal -->

</body>
</html>