<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
      <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> 내 프로젝트</h3>
          	
          	<div class="row mt">
          		<div class="col-lg-12">
          		
				
					<div class="row">
						<!-- TWITTER PANEL -->
						<c:forEach items="${projectlist}" var="plist">
						<div class="col-lg-2 col-md-2 col-sm-2 mb">
							<div class="grey-panel pn donut-chart">
							<div class="grey-header">
	
								<h5>${plist.project_name}<a href="projectUpdate.htm"><i class="fa fa-cog" aria-hidden="true"></i></a></h5>
								
							</div>
							<a href="projectUpdate.htm"><canvas id="serverstatus01" height="120" width="120" ></canvas></a>
							<script>
									var doughnutData = [
											{
												value: 55,
												color:"#FF6B6B"
											},
											{
												value : 45,
												color : "#fdfdfd"
											}
										];
										var myDoughnut = new Chart(document.getElementById("serverstatus01").getContext("2d")).Doughnut(doughnutData);
								</script>
							
							<p class="user">진행도 뿌려질거야</p>
							<a href="taskList.htm"><p>이거 클릭하면 업무로 가요</p></a>
							</div>
						</div><!-- /col-md-4 -->
						</c:forEach>
						

						
						<div class="col-lg-2 col-md-2 col-sm-2 mb">
							<!-- WHITE PANEL - TOP USER -->
							<div class="white-panel pn">
								<div class="white-header">
									<h5>새 프로젝트 추가</h5>
								</div>
								<p><!-- <img src="resources/main/assets/img/ui-zac.jpg" class="img-circle" width="50"> --></p>
								<p><b><!-- ㅌㅌ --></b></p>
								<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i></button>
								<h2><a data-toggle="modal" href="#myModal"></a></h2>
		  				
		  				
				          <!-- Modal -->
                      
                      <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                          <div class="modal-dialog">
                              <div class="modal-content">
                                  <div class="modal-header">
                                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                      <h4 class="modal-title">새 프로젝트 생성</h4>
                                  </div>
                                  <form action="insertProject.htm" method="post">
                                  <div class="modal-body">
                                      <p class="centered"><!-- <img class="img-circle" width="80" src="resources/main/assets/img/ui-sam.jpg"> --></p>
                                      <p>프로젝트명</p>
                                      <input type="text" name="project_name" placeholder="project명을 입력해주세요." autocomplete="off" class="form-control placeholder-no-fix">
                                      
                                <input type="radio" name="public" value="public" >공개<br>
                                <input type="radio" name="public" value="private">비공개<br>
                             
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
									<div class="row">
										<div class="col-md-6">
										
											<p class="small mt"><!-- MEMBER SINCE --></p>
											<p><!-- 2012 --></p>
										</div>
									
									</div>
							</div>
						</div><!-- /col-md-4 -->
						
						
					</div><!-- /END 6TH ROW OF PANELS -->

					
          		</div>
          	</div>
          	<!-- project update  -->

          	<!-- <div class="project-toggle-box">
		                  <div class="fa fa-bars tooltips" data-placement="top" data-original-title="Toggle Project"></div>
		    </div>
          	<div class="row mt" id="project">
	          	<div class="col-lg-12">
		          	<div class="form-panel">
		                  <form action="#" class="form-horizontal style-form">
		                      <div class="form-group">
		                          <label class="control-label col-md-3">시작일</label>
		                          <div class="col-md-3 col-xs-11">
		                              <input class="form-control form-control-inline input-medium default-date-picker" size="16" type="text" value="">
		                              <span class="input-group-btn add-on">
		                                        <button class="btn btn-theme" type="button"><i class="fa fa-calendar"></i></button>
		                              </span>
		                          </div>
		                      </div>
		                      <div class="form-group">
		                          <label class="control-label col-md-3">마감일</label>
		                          <div class="col-md-3 col-xs-11">
		                              <input class="form-control form-control-inline input-medium default-date-picker" size="16" type="text" value="">
		                              <span class="input-group-btn add-on">
		                                        <button class="btn btn-theme" type="button"><i class="fa fa-calendar"></i></button>
		                              </span>
		                          </div>
		                      </div>
		                      <div class="form-group">
		                          <label class="control-label col-md-3">멤버초대</label>
		                          <div class="col-md-3 col-xs-11">
		                              <button class="btn btn-theme" type="button" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i></button>
		                              Modal
							          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
							              <div class="modal-dialog">
							                  <div class="modal-content">
							                      <div class="modal-header">
							                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							                          <h4 class="modal-title">멤버초대</h4>
							                      </div>
							                      <div class="modal-body">
							                          <p class="centered"><img class="img-circle" width="80" src="resources/main/assets/img/ui-sam.jpg"></p>
							                          <p>이메일</p>
							                          <input type="text" name="member_id" placeholder="이메일을 입력해주세요." class="form-control placeholder-no-fix">
							                          <p>이름</p>
							                          <input type="text" name="member_name" placeholder="이름을 입력해주세요." class="form-control placeholder-no-fix">
							                          <br>
													  <center><p> workspace에 가입할 수 있는 초대 메일이 발송됩니다. </p>
													  <p> 또 해당 사용자는 프로젝트에 자동으로 초대됩니다.</p></center>
												  
							                      </div>
							                      <div class="modal-footer centered">
							                          <button class="btn btn-theme03" type="button">초대 메일 보내기</button>
							                          <button data-dismiss="modal" class="btn btn-theme04" type="button">취소</button>
							                      </div>
							                  </div>
							              </div>
							          </div>
				          modal
		                          </div>
		                      </div>
		                      <div class="form-group">
		                          <label class="control-label col-md-3">공개여부</label>
		                          <div class="col-md-4">
		                              <form>
										  <input type="radio" name="choose" value="public" checked>공개
										  <input type="radio" name="choose" value="private">비공개<br>
									  </form> 
		                              
		                              <span class="help-block">* 공개는 워크스페이스 인원 / 비공개는 프로젝트 인원만 공개</span>
		                              
		                          </div>
		                      </div>
		                  </form>
		            </div>/form-panel
	          	</div>/col-lg-12
          	</div>/row -->
			
		</section>
		
		
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->

</body>
</html>