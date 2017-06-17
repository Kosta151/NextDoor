<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   


 
<%-- <c:set value="${project_no}" var="project_no"></c:set> --%>

<section id="main-content">
          <section class="wrapper site-min-height">
 			<div class="col-lg-9 main-chart">
                  		<div>
                  			<h3><i class="fa fa-angle-right"></i> 보람사조</h3>
                  			<button type="button" class="btn btn-theme02" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> 업무 리스트 추가</button>
                  			
	                  		<!-- Modal -->
					          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
					              <div class="modal-dialog">
					                  <div class="modal-content">
					                  	<form action="insertTask.htm" >
					                      <div class="modal-header">
					                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					                          <h4 class="modal-title">새 업무생성</h4>
					                      </div>
					                      <div class="modal-body">					                	  
					                          <p class="centered"></p>
					                          <p>업무명</p>
					                          <input type="text" id="task_cont" name="task_cont" placeholder="업무명을 입력해주세요." autocomplete="off" class="form-control placeholder-no-fix">
					                          <input type="hidden" id="project_no" name="project_no" value="${project_no}" > 
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
                  		<br>
                  
                  	
                  		<div class="col-lg-4 col-md-4 col-sm-4 mb">
                  			<div class="darkblue-panel pn">
                  			<section class="task-panel tasks-widget">
	                	<div class="panel-heading">
	                        <div class="pull-left" id="ajaxtest"><h5><i class="fa fa-tasks"></i> ${list.task_cont}</h5></div>
	                        <br>
	                 	</div>
                          <!-- <div class="panel-body">
                              <div class="task-content">
                                  <ul id="sortable" class="task-list ui-sortable">                                   
                                      <li class="list-primary" style="position: relative; left: 0px; top: 0px;">
                                          <i class=" fa fa-ellipsis-v"></i>
                                          <div class="task-checkbox">
                                              <input type="checkbox" class="list-child" value="">
                                          </div>
                                          <div class="task-title">
                                              <span class="task-title-sp">Dashgum - Admin Panel Theme</span>
                                              <span class="badge bg-theme">Done</span>
                                              <div class="pull-right hidden-phone">
                                                  <button class="btn btn-success btn-xs fa fa-check"></button>
                                                  <button class="btn btn-primary btn-xs fa fa-pencil"></button>
                                                  <button class="btn btn-danger btn-xs fa fa-trash-o"></button>
                                              </div>
                                          </div>
                                      </li><li class="list-danger">
                                          <i class=" fa fa-ellipsis-v"></i>
                                          <div class="task-checkbox">
                                              <input type="checkbox" class="list-child" value="">
                                          </div>
                                          <div class="task-title">
                                              <span class="task-title-sp">Extensive collection of plugins</span>
                                              <span class="badge bg-warning">Cool</span>
                                              <div class="pull-right hidden-phone">
                                                  <button class="btn btn-success btn-xs fa fa-check"></button>
                                                  <button class="btn btn-primary btn-xs fa fa-pencil"></button>
                                                  <button class="btn btn-danger btn-xs fa fa-trash-o"></button>
                                              </div>
                                          </div>
                                      </li>
                                      <li class="list-success">
                                          <i class=" fa fa-ellipsis-v"></i>
                                          <div class="task-checkbox">
                                              <input type="checkbox" class="list-child" value="">
                                          </div>
                                          <div class="task-title">
                                              <span class="task-title-sp">Free updates always, no extra fees.</span>
                                              <span class="badge bg-success">2 Days</span>
                                              <div class="pull-right hidden-phone">
                                                  <button class="btn btn-success btn-xs fa fa-check"></button>
                                                  <button class="btn btn-primary btn-xs fa fa-pencil"></button>
                                                  <button class="btn btn-danger btn-xs fa fa-trash-o"></button>
                                              </div>
                                          </div>
                                      </li>
                                      <li class="list-warning">
                                          <i class=" fa fa-ellipsis-v"></i>
                                          <div class="task-checkbox">
                                              <input type="checkbox" class="list-child" value="">
                                          </div>
                                          <div class="task-title">
                                              <span class="task-title-sp">More features coming soon</span>
                                              <span class="badge bg-info">Tomorrow</span>
                                              <div class="pull-right hidden-phone">
                                                  <button class="btn btn-success btn-xs fa fa-check"></button>
                                                  <button class="btn btn-primary btn-xs fa fa-pencil"></button>
                                                  <button class="btn btn-danger btn-xs fa fa-trash-o"></button>
                                              </div>
                                          </div>
                                      </li>
                                      <li class="list-info">
                                          <i class=" fa fa-ellipsis-v"></i>
                                          <div class="task-checkbox">
                                              <input type="checkbox" class="list-child" value="">
                                          </div>
                                          <div class="task-title">
                                              <span class="task-title-sp">Hey, seriously, you should buy this Dashboard</span>
                                              <span class="badge bg-important">Now</span>
                                              <div class="pull-right hidden-phone">
                                                  <button class="btn btn-success btn-xs fa fa-check"></button>
                                                  <button class="btn btn-primary btn-xs fa fa-pencil"></button>
                                                  <button class="btn btn-danger btn-xs fa fa-trash-o"></button>
                                              </div>
                                          </div>
                                      </li>
                                  </ul>
                              </div>                             
                          </div> -->
                      		</section>
                      		</div>                              			
					   </div>
          		</div> 
                  
          <!-- 오른쪽 사이드 바 -->
          <div class="col-lg-3 ds" id="test">
                    <!--COMPLETED ACTIONS DONUTS CHART-->
						<h3>세부업무 설정</h3>            
	                       <div class="form-panel" >
	                  	   <div class="btn-group">
							  <div class="btn-group btn-group-justified">
							  <div class="btn-group">
							    <button type="button" class="btn btn-theme">속성</button>
							  </div>
							  <div class="btn-group">
							    <button type="button" class="btn btn-theme02">파일</button>
							  </div>
							</div>
					  	   </div>
	                      <form class="form-horizontal style-form" method="get">
	                          <div class="form-group">
	                              <label class="col-sm-3 col-sm-3 control-label">업무배정</label>
	                              <button type="button" class="btn btn-theme02"><i class="fa fa-plus"></i></button>
	                          </div>
	                                                  
	                          <div class="form-group">
	                          	  <div class="form-group">
	                              		<label class="col-sm-3 col-sm-3 control-label">&nbsp;&nbsp;&nbsp;<i class="fa fa-calendar"></i>&nbsp;&nbsp;&nbsp;기간</label>
	                              		
	                              </div>
	                              <div class="form-group">                             		
	                              		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;시작일: <input type="text" id="datepicker"></p>                  		
	                              </div>
	                              <div class="form-group">
	                              		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;마감일: <input type="text" id="datepicker"></p>
	                              </div>                                                          
	                          </div>
	                         
	                          <button type="button" class="btn btn-theme03">수정완료</button>
	                          <button type="button" class="btn btn-theme04">업무삭제</button>
	                          
	                      </form>
                  		</div>                   
           
                  </div><!-- /col-lg-3 -->
                  
                  	<!-- 파일 업로드 -->
         			<div class="col-lg-3 ds" id="test">
                    <!--COMPLETED ACTIONS DONUTS CHART-->
						<h3>세부업무 설정</h3>            
	                       <div class="form-panel" >
	                  	   <div class="btn-group">
							  <div class="btn-group btn-group-justified">
							  <div class="btn-group">
							    <button type="button" class="btn btn-theme">속성</button>
							  </div>
							  <div class="btn-group">
							    <button type="button" class="btn btn-theme02">파일</button>
							  </div>
							</div>
					  	   </div>
	                      <form class="form-horizontal style-form" action="file.htm" method="post" enctype="multipart/form-data">
	                          <div class="form-group">
	                              <label class="col-sm-3 col-sm-3 control-label">파일업로드</label>
	                              <input type="hidden" name="specifictask_no" value="3">
	                              <input type="file" name="file">
	                          </div>                
	                          <button type="submit" class="btn btn-theme03">수정완료</button>
	                          <button type="reset" class="btn btn-theme04">업무삭제</button>
	                      </form>
                  		</div>                   
           
                  </div><!-- /col-lg-3 -->
                  
		  </section>
</section>