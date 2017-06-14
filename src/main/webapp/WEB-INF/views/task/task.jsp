<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<section id="main-content">
          <section class="wrapper">
 		
 			<div class="col-lg-9 main-chart">
                  		<div>
                  			<h3><i class="fa fa-angle-right"></i> 보람사조</h3>
                  			<button type="button" class="btn btn-theme02" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> 업무 리스트 추가</button>
                  			
	                  		<!-- Modal -->
					          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
					              <div class="modal-dialog">
					                  <div class="modal-content">
					                  	<form action="insertTask.htm">
					                      <div class="modal-header">
					                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					                          <h4 class="modal-title">새 업무생성</h4>
					                      </div>
					                      <div class="modal-body">
					                      	  
					                          <p class="centered"></p>
					                          <p>업무명</p>
					                          <input type="text" name="task_cont" placeholder="업무명을 입력해주세요." autocomplete="off" class="form-control placeholder-no-fix">
					                      </div>
					                      <div class="modal-footer centered">
					                      	  
						                          <button class="btn btn-theme03" type="submit">생성</button>
						                          <button data-dismiss="modal" class="btn btn-theme04" type="button">취소</button>
					                      </div>
					                      </form>
					                  </div>
					              </div>
					          </div>
					         <!-- modal -->
                  		</div>
                  		
                  		<!-- userid와 프로젝트 name을 가지고 업무리스트 뿌리기 -->
                  	<c:forEach items="${tasklist}" var="list">
                  		<div class="col-lg-3 col-md-3 col-sm-3 mb">
							<div class="steps pn">
								
							    <label for="op1">${list.task_cont}
							    	<button class="btn btn-success btn-xs"><i class="fa fa-plus"></i></button>
							    </label>					   
							</div>
					   </div>
				  </c:forEach>
                  
                  		
                  		
					  					  
					  
          </div>
 
		  </section>
</section>