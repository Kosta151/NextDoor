<%--
	@Project : NextDoor
	@File name : task.jsp
	@Author : 문창균
	@Data : 2017. 06. 13
	@Desc : 업무 및 상세업무 추가/삭제/수정/리스트
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
   uri="http://www.springframework.org/security/tags"%>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="resources/main/assets/js/sweetalert.min.js"></script>
<link href="resources/main/assets/css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
   href="resources/main/assets/css/sweetalert.css">
<section id="main-content" style="width: auto; overflow: hidden;">
   <script type="text/javascript">
$(function(){   
   $("#taskbtn").click(function(){
      if($("#task_cont").val()==""){
         swal("업무명을 입력해주세요");
         $("#task_cont").focus();
         return false;
     }else{       
          swal({
                    title: "업무 생성 완료!",
                    type: "success",
                    showCancelButton: false,
                    confirmButtonColor: "#194f89",
                    confirmButtonText: "확인",
                    closeOnConfirm: false
                    
                  },
                   function(isConfirm){
                      if (isConfirm) {
                          location.href="insertTask.htm";
                          $('#taskform').submit();
                      }
                } 
          );
        
      }
      
      }); 
   
   $("#modibutton").click(function(){
         if($("#member_id").val()==""){
            swal("업무배정인원을 선택해주세요"); 
            $("#member_id").focus();
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
                       title: "업무 수정 완료!",
                       type: "success",
                       showCancelButton: false,
                       confirmButtonColor: "#194f89",
                       confirmButtonText: "확인",
                       closeOnConfirm: false
                       
                     },
                     function(isConfirm){
                         if (isConfirm) {
                            location.href="updateSpecifictask.htm";
                             $('#modiform').submit();
                         }
                   }
             );
           }
       }); 
   
    var bool_sw = true;
    var start_idx = 0;
    var cont = "";
    var taskno = "";
    var speicficcont="";
    var projectno="";
    var cidx=0;
    var end_idx=0;
    
    <%----------------------------------------------------
    무한 스크롤 
    ----------------------------------------------------%>
   $(window).scroll(function() {
      if ($(window).scrollTop() == $(document).height() - $(window).height()){               
             if(bool_sw){           
                infinite();
                }                                 
           }
        });
   infinite();    
   
   <%----------------------------------------------------
   업무 및 상세 업무 리스트  
   ----------------------------------------------------%>
   function infinite(){        
      $.ajax({
      url : "tasklist.htm",
      type : "post",
      data : {idx:start_idx},
      dataType : "json",
      success : function(data){
         var taskcont = "";
         var taskcomp = "";
         var owner = data.owner;
         var user = data.user;       
         start_idx = start_idx+3;
         if(end_idx!=cidx){
            bool_sw=false;
         }
         cidx = cidx+3;               
         $(".ajaxtask").append("<div id='"+start_idx+"containtask' style='float:left; width : 100%; height : auto;' margin:'20px;'>");
         $.each(data.data , function(index,obj){           
            end_idx++;          
            if(data.owner==data.user){
               taskcont = "<div class='taskcont' id='"+obj.task_no+"tasktitle'>"
                     + "<input type='text' id='"+obj.task_no+"change' class='taskinput ' value='"+obj.task_cont+"'>"                
                     + "<div class='taskbutton' style='margin-top: 3px'; id='"+obj.task_no+"plus'>"
                     + "<i class='fa fa-plus' ></i>"
                     + "</div>"
                     + "<div class='taskbutton' style='margin-top: 2px' id='"+obj.task_no+"delete'>"
                     + "<i class='fa fa-trash-o' >"      
                     + "</i></div>"
                     + "<div id='"+obj.task_no+"plusdrop' style='display:none;'>"
                     + "<form onsubmit='return false;'><div class='modal-header taskcont'>"
                     + "<p>세부업무명</p>"
                     + "<input type='text' id='"+obj.task_cont+"cont' name='specifictask_cont' placeholder='세부업무명을 입력해주세요.' autocomplete='off' class='form-control placeholder-no-fix'>"
                     + "<input type='hidden' id='"+obj.task_no+"task_no' name='task_no' value='"+obj.task_no+"'>"
                     + "<div class='modal-footer centered'>" 
                     + "<button class='btn btn-theme03' id='"+obj.task_no+"submit'>생성</button>"
                     + "<button data-dismiss='modal' class='btn btn-theme04' type='button'>취소</button>"
                     + "</div></form></div></div>"            
                     + "</div>";
            }else{
               taskcont = "<div class='taskcont' id='"+obj.task_no+"tasktitle'>"
               + "<input type='text' class='taskinput ' value='"+obj.task_cont+"'>"
               + "</i></div>"
               + "</div>";
            }                                                    
           
                taskcomp = "<div id='"+obj.task_no+"comp'>"
                    + "<div class='taskcomp'>완료된 업무</div>"
                   + "</div>"
                                         
             $("#"+start_idx+"containtask").append("<div id='"+obj.task_no+"task' style='margin:10px; height:100%; width:30%;' class='taskbox'>");
             $("#"+obj.task_no+"task").append(taskcont);
             $("#"+start_idx+"containtask").append("</div>");
             $("#"+obj.task_no+"task").append(taskcomp);
                                     
             cont = $("#"+obj.task_cont+"cont").val();
             
             <%----------------------------------------------------
             업무내용 변경시 마다 DB에 적용 change이벤트
             업무 이름 변경 기능
             ----------------------------------------------------%>
             $("#"+obj.task_no+"change").change(function(e){
                changetasktitle(obj.task_no, $("#"+obj.task_no+"change").val());               
             });
                                       
             <%----------------------------------------------------
             플러스 버튼 클릭시 toggle실행
             ----------------------------------------------------%> 
            $("#"+obj.task_no+"plus").click(function(){          
                if ($("#"+obj.task_no+"plusdrop").is(":visible") == true){
                   $("#"+obj.task_no+"plusdrop").hide();
                }else{
                   $("#"+obj.task_no+"plusdrop").show();
                }               
            });
            
            <%----------------------------------------------------
            생성버튼 클릭시 insertspecific()로 이동
            업무 생성 기능
            ----------------------------------------------------%>
             $("#"+obj.task_no+"submit").click(function(){

                taskno = obj.task_no;
                cont = $("#"+obj.task_cont+"cont").val();
                                            
                 insertspecific(cont,taskno);
                 $("#"+obj.task_no+"plusdrop").hide();
             }); 
            
             <%----------------------------------------------------
             삭제버튼 클릭시 deletetask()로 이동
             업무 삭제 기능
             ----------------------------------------------------%> 
              $("#"+obj.task_no+"delete").click(function(){             
               projectno = obj.project_no;
               taskno = obj.task_no;
               
               deletetask(projectno, taskno);
            }); 
                                                            
              <%----------------------------------------------------
              세부업무 리스트 
              ----------------------------------------------------%>
             $.ajax({
                url : "specifictask.htm",
                type : "post",
                data : {task_no : obj.task_no},
                dataType : "json",
                success : function(data){                                                                   
                   var comp="";                                                                                               
                   $.each(data.data, function(spindex, spobj){                
                      if(obj.task_no=spobj.task_no){                        
                        if(owner==user){                      
                        var specificno = spobj.specifictask_no;                        
                         speicficcont="<div class='specifictaskbox'  id='"+specificno+"specific'>"
                                 + spobj.specifictask_cont                                                                 
                                 + "<button class='specifictaskbutton' id='"+specificno+"specificbutton' style='background-color: window; border: none;' value='"+spobj.specifictask_no+"'>" 
                                 + "<i class='fa fa-pencil'>"                                   
                                 + "</i></button>"  
                                 + "<input type='checkbox' class='sp-checkbox' id='"+specificno+"sp-checkbox' value='"+specificno+"'>"
                                 + "</div>";
                         }else{
                            speicficcont="<div class='specifictaskbox' style='background-color : none;' id='"+specificno+"specific'>"
                              + spobj.specifictask_cont                                                                   
                              + "<input type='checkbox' class='sp-checkbox' id='"+specificno+"sp-checkbox' value='"+specificno+"'>"
                               + "</div>";
                         }
                                                                                                                           
                        comp = spobj.specifictask_comp;                                
                        if(comp==0){
                            $("#"+obj.task_no+"tasktitle").append(speicficcont);
                        }else if(comp==1){                          
                           $("#"+obj.task_no+"comp").append(speicficcont);
                        }                      
                        var spcont =speicficcont;     
                                                                                                                                                                                              
                        <%----------------------------------------------------
                        채크박스 버튼 클릭시  checkspecifictask()로 이동 
                        업무 확인 기능
                        ----------------------------------------------------%>
                         $("#"+specificno+"sp-checkbox").click(function(){                                                  
                           var comp = spobj.specifictask_comp;
                           var specifictaskno=spobj.specifictask_no;
                           var taskno = obj.task_no;
                           checkspecifictask(specifictaskno,taskno,spcont,comp);
                         }); 
                      } 
                      
                      <%----------------------------------------------------
                      수정버튼 클릭시 상세업무 수정을 위한 토글 
                      ----------------------------------------------------%>
                      $("#"+specificno+"specificbutton").click(function () {                         
                          if ($('#moditoggle').is(":visible") == true) {
                             $('#main-content').css({
                                 'margin-left': '210px'
                             });
                             $('#moditoggle').css({
                                 'margin-right': '-210px'
                             });
                             $('#moditoggle').hide(50);                             
                        } else {
                                $('#main-content').css({
                                    'margin-right': '0px'
                                });
                                 $('#moditoggle').slideToggle();   
                                $('#moditoggle').css({
                                    'margin-right': '0'
                                });                                                             
                        }  
                         var specifictaskno=spobj.specifictask_no;
                         var specifictaskcont=spobj.specifictask_cont;
                         detailSpecifictask(specifictaskno,specifictaskcont);
                     });
                                                                                                                                                                               
                   });
                                                                                                        
                },
                   error : function(){
                     alert("error");
                   }
                });               
            });
             $(".ajaxtask").append("</div>");
         },
         error : function(){
            alert("error");
         }
      });     
     }
   });
 
<%----------------------------------------------------
체크박스 버튼 클릭시 실행되는 함수
작업 확인 기능
----------------------------------------------------%>
   function checkspecifictask(specifictaskno,taskno,spcont,comp){       
        $.ajax({
          url : "checkspecifictask.htm",
          type : "post",
          data : {specifictask_no :  specifictaskno},
          success : function(data){
             if(comp==0){                
                $("#"+specifictaskno + "specific").hide();
                 $("#" +taskno+"task").append(spcont); 
             }else{  
                
                 $("#"+specifictaskno + "specific").remove();
                 $("#" +taskno+"tasktitle").append(spcont); 
             }                
          },
          error : function(){
            alert("error");
          }
       }); 
   }
   
   <%----------------------------------------------------
   생성 버튼 클릭시 실행되는 함수
   작업 생성 기능
   ----------------------------------------------------%>
   function insertspecific(cont,taskno){   
      var specificno = taskno; 
         $.ajax({
             url : "insertspecifictask.htm",
             type : "post",
             data : {specifictask_cont : cont, task_no : taskno},
             dataType : "json",
             success : function(data){
            var specifictaskno = data.specifictask_no;
                                                                                                                       
             var insertspecific = "<div class='specifictaskbox' style='background-color : none;' id='"+specifictaskno+"specific'>"
                           + cont 
                           + "<button class='specifictaskbutton' id='"+specifictaskno+"specificbutton' style='background-color: window; border: none;' value='"+specificno+"' >"                   
                           + "<i class='fa fa-pencil'>"                                   
                           + "</i></button>"  
                           + "<input type='checkbox' class='sp-checkbox' id='"+specifictaskno+"sp-checkbox' value='"+specifictaskno+"'>"
                           + "</div>";                                                                                                                                                          
                $("#"+taskno+"tasktitle").append(insertspecific);
                <%----------------------------------------------------
                수정버튼 클릭시 상세업무 수정을 위한 토글 
                ----------------------------------------------------%>      
                $("#"+specifictaskno+"specificbutton").click(function () {                    
                    if ($('#moditoggle').is(":visible") == true) {
                       $('#main-content').css({
                           'margin-left': '210px'
                       });
                       $('#moditoggle').css({
                           'margin-right': '-210px'
                       });
                       $('#moditoggle').hide(50);                       
                  } else {
                          $('#main-content').css({
                              'margin-right': '0px'
                          });
                           $('#moditoggle').slideToggle();   
                          $('#moditoggle').css({
                              'margin-right': '0'
                          });                                                      
                  }  
                    
                   var specifictaskno=data.specifictask_no;
                   var specifictaskcont=cont; 
                   detailSpecifictask(specifictaskno,specifictaskcont);
               }); 
               
                <%----------------------------------------------------
                체크박스 버튼 클릭시 checkspecifictask()로 이동 
                업무 확인 기능
                ----------------------------------------------------%>
                $("#"+specifictaskno+"sp-checkbox").click(function(){                                     
                    var spcont = insertspecific;
                    var comp=0;
                    checkspecifictask(specifictaskno,taskno,spcont,comp);
                  });                              
             },
             error : function(){
                alert("error");
                }                                              
             });                        
   }
     
   <%----------------------------------------------------
   수정 버튼 클릭시 실행되는 함수 
   상세업무 확인 기능
   ----------------------------------------------------%>
   function detailSpecifictask(specifictaskno,specifictaskcont){   
      $.ajax({
          url : "detailSpecifictaskajax.htm",
          type : "post",
          data : {specifictask_no : specifictaskno},          
          dataType : "json",
          success : function(data){

             if(data.data!=null){
               $("#specifictask_cont").val(specifictaskcont); 
                $("#specifictask_start").val(data.data.specifictask_start);
                $("#specifictask_end").val(data.data.specifictask_end);
                $("#taskmember_id").val(data.data.member_id); 
                $("#specifictask_no").val(specifictaskno);
                $(".specifictask_no").val(specifictaskno);
                $("#member_id").val(data.data.member_id); 
                $("#deletespecific").val(specifictaskno);                                                   
             }else{                  
               $("#specifictask_cont").val(specifictaskcont); 
                $("#specifictask_start").val("");
                $("#specifictask_end").val("");
                $("#taskmember_id").val(""); 
                $("#specifictask_no").val(specifictaskno);
                $(".specifictask_no").val(specifictaskno);
                $("#member_id").val(""); 
                $("#deletespecific").val(specifictaskno);
             }                   
          },
          error : function(){
            alert("error");
          }
       }); 
    } 

   <%----------------------------------------------------
   삭제 버튼 클릭시 실행되는 함수 
   업무 삭제 기능
   ----------------------------------------------------%>
    function deletetask(projectno, taskno){
         $.ajax({
             url : "deletetask.htm",
             type : "post",
             data : {project_no : projectno, task_no : taskno},
             success : function(data){
               
               $("#"+taskno+"task").remove();
               
             },
             error : function(){
               alert("error");
             }
          }); 
    }
                   
    <%----------------------------------------------------
    상세업무 삭제 버튼 클릭시 실행되는 함수 
    상세업무 삭제 기능
    ----------------------------------------------------%>
    function deletespecific(specifictaskno){
          $.ajax({
             url : "deleteSpecifictask.htm",
             type : "post",
             data : {specifictask_no : $("#deletespecific").val()},
             success : function(data){
               
               $("#"+specifictaskno+"specific").remove();
               
             },
             error : function(){
               alert("error");
             }
          });  
    }
  
    <%----------------------------------------------------
    업무 이름 변경시 실행되는 함수 
    업무이름 변경  기능
    ----------------------------------------------------%>
    function changetasktitle(task_no, changecont){
       
        $.ajax({
              url : "changetasktitle.htm",
              type : "post",
              data : {task_no : task_no, task_cont : changecont},
              success : function(data){                              
              },
              error : function(){
                alert("error");
              }
           });  
       
    }
</script>

   <section class="wrapper site-min-height">
      <div>
         <div>
            <h2 style="padding-top: 22px;">
               <i class="fa fa-angle-right"></i> Project : ${project_name} 
            </h2>
            <sec:authentication property="principal.username" var="user" />
            <c:if test="${owner==user}">
               <button type="button" class="btn btn-theme02" data-toggle="modal"
                  data-target="#myModal">
                  <i class="fa fa-plus"></i> 업무 리스트 추가
               </button>
            </c:if>

            
		    <!------------------------------
		    업무리스트 추가 Modal
		    -------------------------------->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
               tabindex="-1" id="myModal" class="modal fade">
               <div class="modal-dialog">
                  <div class="modal-content">
                     <form action="insertTask.htm" id="taskform">
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
                           <button class="btn btn-theme03" type="button" id="taskbtn">생성</button>
                           <button data-dismiss="modal" class="btn btn-theme04"
                              type="button">취소</button>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
         
        
       <!------------------------------
	   업무, 세부업무 작성부분
	   -------------------------------->
         <div class="col-lg-9">
            <div class="ajaxtask"></div>
            <div id="ajaxspecific"></div>
         </div>
      </div>
      
      <!------------------------------
	   세부업무 수정Form부분
	   -------------------------------->
      <div class="col-lg-3" id="moditoggle" style="background-color:#424a5d; padding-top: 15px; padding-bottom: 15px;">
         <div class="form-panel" style="height: 550px;">          
            <div id="London" class="tabcontent">
              <form action="updateSpecifictask.htm" method="post" id="modiform"> 
                  <div class="form-group">
                     <p>
                        세부업무명 : <input class="form-control" id="specifictask_cont" type="text" name="specifictask_cont"
                           value="">
                     </p>
                  </div>
                  <hr>
                  <div class="form-group">
                     <p>업무배정 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p> 
	                     <select class="form-control" name="member_id" id="member_id">
	                       <option value="">업무 배정할 인원을 선택해주세요</option>
	                        <c:forEach items="${memberlist}" var="mlist">
	                           <option value="${mlist.member_id}">${mlist.member_id}</option>
	                        </c:forEach>
	                     </select>
                     <p>
                        배정된 인원 : <input class="form-control" type="text" readonly="readonly"
                        id="taskmember_id" name="taskmember_id" value="${modidto.member_id}">
                     </p>
                  </div>
                  <hr>                
                     <label> <i></i>기간설정</label>                                   
                     <div class="form-group">
                        <p>
                           업무시작일:<input
                              class="form-control form-control-inline input-medium default-date-picker"
                              width="50%" type="text" value="${modidto.specifictask_start}"
                              id="specifictask_start" name="specifictask_start">
                        </p>                      
                     </div>
          
                     <div class="form-group">
                        <p>
                           업무마감일:<input
                              class="form-control form-control-inline input-medium default-date-picker"
                              size="8" type="text" value="${modidto.specifictask_end}"
                              id="specifictask_end" name="specifictask_end">
                        </p>                       
                     </div>         
                     <input type="hidden" id="specifictask_no" name="specifictask_no"
                     value="">

                       <button type="submit" id="modibutton" class="btn btn-primary modibutton"
                       style="margin-left: 15px;">수정</button>                     
               </form> 

               <form action="deleteSpecifictask.htm"> 
               <input type="hidden" class="specifictask_no"
                  name="specifictask_no" value="">
               <button class="btn btn-danger modibutton" id="deletespecific" value=""
                  style="margin-left: 10px;">삭제</button>
              </form>    
            </div>
         </div>            
      </div>                 
   </section>
</section>