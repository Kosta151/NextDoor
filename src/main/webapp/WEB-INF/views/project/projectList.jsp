<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script type="text/javascript">
$(function(){
	
	
	$("#btn").click(function(){
	   if($("#project_name").val()==""){
	      swal("프로젝트명을 입력해주세요");
	      $("#project_name").focus();
	      return false;
	   }else{
	      /* swal('프로젝트 생성!', 'You clicked the button!', 'success') */
	       swal({
	                 title: "프로젝트 생성 완료!",
	                 type: "success",
	                 showCancelButton: false,
	                 confirmButtonColor: "#194f89",
	                 confirmButtonText: "확인",
	                 closeOnConfirm: false
	                 
	               },
		        	 function(isConfirm){
		        		  if (isConfirm) {
		        			  location.href="insertProject.htm";
		        				$('#projectform').submit();
		        		  }
					 }
	       );
	     
	   }
	   
	   }); 
	
});

</script>
      <section id="main-content">
          <section class="wrapper site-min-height">
              <h2><i class="fa fa-angle-right"></i> Workspace : ${workspaceinfo}</h2>
              <div class="row mt">
                  <div class="col-lg-12">
				    <div class="row">
				    <sec:authentication property="principal.username" var="loginuser"/>
					<!-- PANEL -->
			<c:forEach items="${projectlist}" var="list">
				<div class="col-md-4 col-sm-4 mb">
					<div class="grey-panel pn donut-chart">
						<div class="grey-header">
							<h5>${list.project_name}
								<c:choose>
									<c:when test="${workspaceowner==loginuser}">
									  <div class="box-tools pull-right">
							                <div class="btn-group">
							                  <button type="button" class="close" data-toggle="dropdown" onclick="location.href='projectUpdate.htm?project_no=${list.project_no}'">
							                    <i class="fa fa-wrench" style="font-size:17px; margin-right: 10px;"></i></button>
							                </div>
						                <button type="button" class="close" data-widget="remove"><i class="fa fa-times" style="font-size:17px; margin-right: 10px;" onclick="location.href='projectDelete.htm?project_no=${list.project_no}'"></i></button>
						              </div>									
									</c:when>
								</c:choose>
             				 </h5>
						</div>
						<div onclick="location.href='task.htm?project_no=${list.project_no}'">
						<canvas id="${list.project_name}" height="120" width="120"></canvas>
						
						<script>
									var doughnutData = [
											{
												value: ${list.percent},
												color: "#424a5d" 
											},
											{
												value : 100-${list.percent},
												color : "#ffffff"
											}
										];
										var myDoughnut = new Chart(document.getElementById("${list.project_name}").getContext("2d")).Doughnut(doughnutData);
								</script>
						<div class="row">
							<div class="col-sm-6 col-xs-6 goleft">
								<p>업무<br />진행률</p>
							</div>
							<div class="col-sm-6 col-xs-6">
								<h2>${list.percent}%</h2>
						
							</div>
						</div>
					</div>
					</div>
				</div>
			</c:forEach>
			<c:choose>
				<c:when test="${workspaceowner==loginuser}">
					<div class="col-md-4 col-sm-4 mb">
						<!-- WHITE PANEL - TOP USER -->
						<div class="white-panel pn">
							<div class="white-header">
								<h5>새 프로젝트 추가</h5>
							</div>
							<div class="white-body">
							<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">
								<i style="margin-left: 5px;" class="fa fa-plus"></i>
							</button>
							</div>
							<h2><a data-toggle="modal" href="#myModal"></a></h2>
							<div class="row">
								<div class="col-md-6">
									<p class="small mt"></p>
								</div>
							</div>
						</div>
					</div>
				</c:when>
			</c:choose>	
				</div>

				<!-- Modal -->
                      <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                          <div class="modal-dialog modal-sm">
                              <div class="modal-content">
                                  <div class="modal-header">
                                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                      <h4 class="modal-title">새 프로젝트 생성</h4>
                                  </div>
                                  <form action="insertProject.htm" method="post"   id="projectform">
	                                  <div class="modal-body">
	                                      <p>프로젝트명</p>
	                              <input type="text" name="project_name"  id="project_name" placeholder="project명을 입력해주세요." autocomplete="off" class="form-control placeholder-no-fix">
	                              <br>
	                                  </div>
	                                  <div class="modal-footer centered">
	                                       <button type="button" class="btn btn-warning" id="btn">생성 </button>
	                                      <button data-dismiss="modal" class="btn btn-default" type="button">취소</button>
	                                  </div>
                                  </form>
                              </div>
                          </div>
                      </div><!-- modal -->
                </div>
             </div><!-- project update  -->

      </section>
      </section><!-- /MAIN CONTENT -->
      <!--main content end-->