<%--
   @Project : NextDoor
   @File name : projectUpdate.jsp
   @Author : 송지은
   @Data : 2017. 06. 13
   @Desc : 프로젝트 수정/멤버 초대
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
  $( function() {
	//멤버 초대할 때 자동검색
    $( "#autocomplete" ).autocomplete({
      source: function(request , response ){
         $.ajax({
            url: "auto.htm",
            type : "post",
            dataType: "json",
            data: {
            	term: request.term,
                member_id : $("#autocomplete").val()
                   },
            success : function(data){
               response(data);
            }

         });
      }
    });
  } );
  </script>
   <!--main content start-->
        
      <section id="main-content">
          <section class="wrapper">
             <h3><i class="fa fa-angle-right"></i> Project : ${projectlist.project_name}</h3>
             <div id="project">
             <div id="container">
             <div class="row mt">
                <div class="col-lg-12">
                   <div class="form-panel">
                        <form action="projectUpdate.htm" method = "POST" class="form-horizontal style-form">        
                             <div class="form-group"> 
                            <input type="hidden" name="project_no" value="${project_no}">
                            
                                <label class="control-label col-md-2">시작일</label>
                                <div class="col-md-3 col-xs-11">
                                    <input class="form-control form-control-inline input-medium default-date-picker" size="16" type="text" value="${projectmodilist.project_start}" id="project_start" name="project_start">
                                    <span class="input-group-btn add-on">
                                              <button class="btn btn-theme" type="button"><i class="fa fa-calendar"></i></button>
                                    </span>
                                </div>
                              
                           </div> 
                    
                             <div class="form-group"> 
                              
                                <label class="control-label col-md-2">마감일</label>
                                <div class="col-md-3 col-xs-11">
                                    <input class="form-control form-control-inline input-medium default-date-picker" size="16" type="text" value="${projectmodilist.project_end}" id="project_end" name="project_end">
                                    <span class="input-group-btn add-on">
                                              <button class="btn btn-theme" type="button"><i class="fa fa-calendar"></i></button>
                                    </span>
                                </div>
                             </div> 
                            <div class="form-group">
                                <label class="control-label col-md-2">멤버초대</label>
                                <div class="col-md-3 col-xs-11">
                                    <button class="btn btn-theme" type="button" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i></button>
                                </div>
                            </div>
                     <button type="submit" class="btn btn-primary">수정하기</button>
                            </form> 
                      </div>
                  </div>
                        
                  </div><!-- /form-panel -->
                </div><!-- /col-lg-12 -->
             </div><!-- /row -->
             <!-- Modal -->
             <form action="inviteMail.htm" method="post">
              <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                              <h4 class="modal-title">멤버초대</h4>
                          </div>
                          <div class="modal-body">
  
                              <p>이메일</p>
                              <input type="text" id="autocomplete" name="member_id" placeholder="이메일을 입력해주세요." class="form-control placeholder-no-fix">
                              <p>이름</p>
                              <input type="text" name="name" placeholder="이름을 입력해주세요." class="form-control placeholder-no-fix">
                              <br>
	                          <p align="center"> workspace에 가입할 수 있는 초대 메일이 발송됩니다. <br>
	                          또 해당 사용자는 프로젝트에 자동으로 초대됩니다.</p>
                     
                          </div>
                          <div class="modal-footer centered">
                              <input type="submit" class="btn btn-theme03" value="초대 메일 보내기">
                          </div>
                          
                      </div>
                  </div>
              </div>
              </form>
    <!-- modal -->
      </section>
      </section>


