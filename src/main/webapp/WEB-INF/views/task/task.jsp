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

<div class="col-lg-3" id="toggletest_jjh">
	
	<div class="form-panel" style="height: 550px;">
		<div class="tab">
			<hr>
	     	<button class="tablinks btn btn-primary" onclick="openCity(event, 'London')" id="defaultOpen" style=" margin-left:20px; width:40%;  background-color: #fafafa; color: black; ">속성</button>
	     	<button class="tablinks btn btn-danger" onclick="openCity(event, 'Paris')" style="width:40%; background-color: #fafafa; color: black;">파일</button>
	     	<hr>
	   	</div>
	
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
		       
		        <input type="hidden" id="specifictask_no" name="specifictask_no" value="">
	        <button type="submit" class="btn btn-primary" style="float: left;margin-left: 30px; width:30%; background-color: #ffd777; color:navy;">수정</button>
	       	 <%-- <button type="button"><a href="deleteSpecifictask.htm?specifictask_no=${specifictaskno}">업무삭제</a></button> --%>                      
	      </form> 
	      
	      	                                                                                                                               
         
	       	<form action="deleteSpecifictask.htm">  
		        	<input type="hidden" class="specifictask_no" name="specifictask_no" value="">  
		        	<button type="submit" class="btn btn-danger" style="float: left;margin-left: 10px; width:30%; background-color: #ffd777; color:navy;">삭제</button>
		    </form>  
	    </div>          	
	</div>
		
	<div id="Paris" class="tabcontent">
    
     <form class="form-horizontal style-form" action="uploadfile.htm" method="post" enctype="multipart/form-data">
       <div>
          <label>파일업로드</label>
          <input type="hidden" name="specifictask_no" value="${specifictask_no}"> 
          <input type="file" name="file">
       </div>   
       <br>             
       <button type="submit" class="btn btn-primary" style="background-color: #ffd777; color:navy;">파일올리기</button>
         
      </form>
   </div>

	</div>
   </section>
</section>

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