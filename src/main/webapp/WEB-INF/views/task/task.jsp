<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
 
<section id="main-content" style="width:auto; overflow: scroll;">
	<section class="wrapper site-min-height">
    	<div>
         	<div>
            <h3>
               	<i class="fa fa-angle-right"></i> ${project_name}
            </h3>
            <button type="button" class="btn btn-theme02" data-toggle="modal"
               data-target="#myModal">
               <i class="fa fa-plus"></i> 업무 리스트 추가
            </button>
<!-- 업무리스트 추가 Modal -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
               tabindex="-1" id="myModal" class="modal fade">
               <div class="modal-dialog">
                  <div class="modal-content">
                     <form action="insertTask.htm">
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
                           <button class="btn btn-theme03" type="submit">생성</button>
                           <button data-dismiss="modal" class="btn btn-theme04"
                              type="button">취소</button>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
         
        
<!-- 업무리스트 추가 modal end -->
    
<!-- userid와 프로젝트 name을 가지고 업무리스트 뿌리기 -->
    <div class="col-lg-9">
       <div class="ajaxtest"></div>
       <div id="ajaxspecific"></div>
	</div>  
</div>
 <ul id="alarmarea"></ul>
<div class="col-lg-3" id="toggletest_jjh">
	<div class="form-panel">
	
		<form action="updateSpecifictask.htm" method="post">
		
	  	<%-- <div class="form-group">
	  	  	<p>세부업무명 :	
			<input id="specont" type="text" name="specifictask_cont" value="${specifictask_cont}" readonly="readonly"></p>
		</div>
	  	<hr> --%>
		<div class="form-group">
        	<label>업무배정  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            	<select name="member_id" id="select">
                	<option value="${modidto.member_id}">${modidto.member_id}</option>   
                    	<c:forEach items="${memberlist}" var="mlist">         
                        	<option value="${mlist.member_id}" >${mlist.member_id}</option>   
                        </c:forEach>                     
                 </select>
        	<p>배정된 인원 : <input type="text" readonly="readonly" id="taskmember_id" name="memberid" value="${modidto.member_id}"></p>
		</div>
		<hr>
	      
        	<div class="form-group">
	            	<label>
	                	<i></i>기간설정
	                 </label>
	             
		        <div class="form-group">
		        	<p>시작일:<input class="form-control form-control-inline input-medium default-date-picker" width="50%" type="text" value="${modidto.specifictask_start}" id="specifictask_start" name="specifictask_start">
		            
		            </p>
		        <%-- <input type="text" id="specifictask_start" name="specifictask_start" value="${modidto.specifictask_start}"></p> --%>
		        </div>      
                <div class="form-group">
		        	<p>마감일:<input class="form-control form-control-inline input-medium default-date-picker" size="8" type="text" value="${modidto.specifictask_end}" id="specifictask_end" name="specifictask_end">
		            </p>
		        <%-- <input type="text" id="specifictask_start" name="specifictask_start" value="${modidto.specifictask_start}"></p> --%>
		        </div>                                                                                                                              
       		</div>
       		<hr>
	        <input type="hidden" id="specifictask_no" name="specifictask_no" value="">
	        <button type="submit" class="btn btn-primary" id="btn-submit">수정</button>
	       	 <%-- <button type="button"><a href="deleteSpecifictask.htm?specifictask_no=${specifictaskno}">업무삭제</a></button> --%>                      
	      </form> 
	      <br>
	      	  <form action="deleteSpecifictask.htm">  
	        	<input type="hidden" class="specifictask_no" name="specifictask_no" value="">  
	        	<button type="submit" class="btn btn-danger">삭제</button>
	     	 </form>        	
	</div>
	</div>
   </section>
</section>