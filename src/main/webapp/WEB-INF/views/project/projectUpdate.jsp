<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!--main content start-->
        
      <section id="main-content">
          <section class="wrapper">
          <!-- <div class="sidebar-toggle-box">
                  <div class="fa fa-heart tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
          </div> -->
             <h3><i class="fa fa-angle-right"></i> 프로젝트 명 : ${projectlist.project_name}</h3>
             <div id="project">
             <div id="container">
             <div class="row mt">
                <div class="col-lg-12">
                   <div class="form-panel">
                        <form action="projectUpdate.htm" method = "POST" class="form-horizontal style-form">        
                            <div class="form-group">
                            <input type="hidden" name="project_no" value="${project_no}">
                                <label class="control-label col-md-3">시작일</label>
                                <div class="col-md-3 col-xs-11">
                                    <input class="form-control form-control-inline input-medium default-date-picker" size="16" type="text" value="${projectmodilist.project_start}" id="start" name="project_start">
                                    <span class="input-group-btn add-on">
                                              <button class="btn btn-theme" type="button"><i class="fa fa-calendar"></i></button>
                                    </span>
                                </div>
                            </div>
                    
                            <div class="form-group">
                                <label class="control-label col-md-3">마감일</label>
                                <div class="col-md-3 col-xs-11">
                                    <input class="form-control form-control-inline input-medium default-date-picker" size="16" type="text" value="${projectmodilist.project_end}" id="end" name="project_end">
                                    <span class="input-group-btn add-on">
                                              <button class="btn btn-theme" type="button"><i class="fa fa-calendar"></i></button>
                                    </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">멤버초대</label>
                                <div class="col-md-3 col-xs-11">
                                    <button class="btn btn-theme" type="button" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i></button>
                                    <!-- Modal -->
                               <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                                   <div class="modal-dialog">
                                       <div class="modal-content">
                                           <div class="modal-header">
                                               <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                               <h4 class="modal-title">멤버초대</h4>
                                           </div>
                                           <div class="modal-body">
                                               <!-- <p class="centered"><img class="img-circle" width="80" src="resources/main/assets/img/ui-sam.jpg"></p> -->
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
                     <!-- modal -->
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3">공개여부</label>
                                <div class="col-md-4">
                                <input type="radio" name="choose" value="public" checked>공개
                                <input type="radio" name="choose" value="private">비공개<br> 
                                 <span class="help-block">* 공개는 워크스페이스 인원 / 비공개는 프로젝트 인원만 공개</span> 
                                
                                  
							    </div>
							</div>
							<button type="submit" class="btn btn-primary">수정하기</button>
                            </form> 
                      </div>
                  </div>
                        
                  </div><!-- /form-panel -->
                </div><!-- /col-lg-12 -->
             </div><!-- /row -->
      </section>
      </section>



