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
         /* swal('프로젝트 생성!', 'You clicked the button!', 'success') */
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
   
    // 무한 스크롤링 실행 이벤트
    var bool_sw = true;
    var start_idx = 0;
    var cont = "";
    var taskno = "";
    var speicficcont="";
    var projectno="";
    var cidx=0;
    var end_idx=0;
   $(window).scroll(function() {

      if ($(window).scrollTop() == $(document).height() - $(window).height()){
                
             if(bool_sw){
            
                infinite();
                }
             
                      
           }
        });
   
   infinite();      
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
         
         console.log("end_idx" + end_idx);
         console.log("cidx" + cidx);
         
         if(end_idx!=cidx){
            bool_sw=false;
         }
         cidx = cidx+3;
         console.log(bool_sw);
         
         $(".ajaxtest").append("<div id='"+start_idx+"containtask' style='float:left; width : 100%; height : 500px;' margin:'20px;'>");
         $.each(data.data , function(index,obj){   
            
            end_idx++;
            
            if(data.owner==data.user){
               taskcont = "<div class='taskcont' id='"+obj.task_no+"tasktitle'>"
                     + "<input type='text' class='taskinput ' value='"+obj.task_cont+"'>"                
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
                                         
             $("#"+start_idx+"containtask").append("<div id='"+obj.task_no+"task' style='margin:10px; height:100%;' class='taskbox'>");
             $("#"+obj.task_no+"task").append(taskcont);
             $("#"+start_idx+"containtask").append("</div>");
             $("#"+obj.task_no+"task").append(taskcomp);
             
             
            
             cont = $("#"+obj.task_cont+"cont").val();
             
             
             
            //insert event 
            $("#"+obj.task_no+"plus").click(function(){
               
                if ($("#"+obj.task_no+"plusdrop").is(":visible") == true){
                   $("#"+obj.task_no+"plusdrop").hide();
                }else{
                   $("#"+obj.task_no+"plusdrop").show();
                }
               
            });
            
              $("#"+obj.task_no+"submit").click(function(){

                taskno = obj.task_no;
                cont = $("#"+obj.task_cont+"cont").val();
                 
                console.log("cont : " + cont);
                console.log("taskno : " + taskno);
                
                 insertspecific(cont,taskno);
                 $("#"+index+"plusdrop").hide();
             });  
            
            //delete event
              $("#"+obj.task_no+"delete").click(function(){
              
               projectno = obj.project_no;
                taskno = obj.task_no;
               console.log("projectno : " + projectno);
               console.log("taskno : " + taskno);
               deletespecific(projectno, taskno);
            }); 
               

             //세부 리스트 뿌리는 부분
             $.ajax({
                url : "specifictask.htm",
                type : "post",
                data : {task_no : obj.task_no},
                dataType : "json",
                success : function(data){
                  console.log(data.data);
                  
                   
                   
                   var comp="";
                                                                             
                   $.each(data.data, function(spindex, spobj){
                     
                      if(obj.task_no=spobj.task_no){
                         
                         if(owner==user){
                            
                             var specificno = spobj.specifictask_no
                        console.log(owner);
                        console.log(user);
                         speicficcont="<div class='specifictaskbox'  id='"+spobj.specifictask_no+"specific'>"
                                  + spobj.specifictask_cont                                                                 
                                 + "<button class='specifictaskbutton' id='"+specificno+"specificbutton' style='background-color: window; border: none;' value='"+spobj.specifictask_no+"'>" 
                                 + "<i class='fa fa-pencil'>"                                   
                                 + "</i></button>"  
                                 + "<input type='checkbox' class='sp-checkbox' id='"+spobj.specifictask_no+"sp-checkbox' value='"+spobj.specifictask_no+"'>"
                                 + "</div>";
                         }else{
                            speicficcont="<div class='specifictaskbox' style='background-color : none;' id='"+spobj.specifictask_no+"specific'>"
                              + spobj.specifictask_cont                                                                   
                              + "<input type='checkbox' class='sp-checkbox' id='"+spobj.specifictask_no+"sp-checkbox' value='"+spobj.specifictask_no+"'>"
                               + "</div>";
                         }
    
                             comp = spobj.specifictask_comp;                                
                        if(comp==0){
                            $("#"+obj.task_no+"tasktitle").append(speicficcont);
                         }else if(comp==1){
                            $("#"+obj.task_no+"comp").append(speicficcont);
                         }                      
                         var spcont =speicficcont;      
                         

                         
                         
                         //작업 확인 버튼
                         $("#"+spobj.specifictask_no+"sp-checkbox").click(function(){
                           
                           var specifictaskno=spobj.specifictask_no;
                           var taskno = obj.task_no;
                           checkspecifictask(specifictaskno,taskno,spcont);
                         }); 
                      } 
                      
                      
                       $("#"+specificno+"specificbutton").click(function () {
                         
                           if ($('#toggletest_jjh').is(":visible") == true) {
                              $('#main-content').css({
                                  'margin-left': '210px'
                              });
                              $('#toggletest_jjh').css({
                                  'margin-right': '-210px'
                              });
                              $('#toggletest_jjh').hide(50); 
                              
                         } else {
                                 $('#main-content').css({
                                     'margin-right': '0px'
                                 });
                                  $('#toggletest_jjh').slideToggle();   
                                 $('#toggletest_jjh').css({
                                     'margin-right': '0'
                                 }); 
                                  
                                 
                              }  
                          var specifictaskno=spobj.specifictask_no;
                          detailSpecifictask(specifictaskno);
                      }); 
                   
                         
                   
                   });
                   
                  
                },
                   error : function(){
                     alert("error");
                   }
                });               
            });
             $(".ajaxtest").append("</div>");
         },
         error : function(){
            alert("error");
         }
      });
      
     }
   
   });
   
   //작업완료 버튼 클리시  실행
   function checkspecifictask(specifictaskno,taskno,spcont){
      
        $.ajax({
          url : "checkspecifictask.htm",
          type : "post",
          data : {specifictask_no :  $("#"+specifictaskno+"sp-checkbox").val()},
          success : function(data){
            console.log(data);
             
            
            $("#"+specifictaskno + "specific").hide();
            $("#" +taskno+"task").append(spcont);
            
         
          },
          error : function(){
            alert("error");
          }
       }); 
   }
   
   
   //insert
    function insertspecific(cont,taskno){
      
      console.log("taskno : "+taskno);
      console.log("cont: "+cont);
     
         $.ajax({
             url : "insertspecifictask.htm",
             type : "post",
             data : {specifictask_cont : cont, task_no : taskno},
             dataType : "json",
             success : function(data){
            var specificno = taskno;   
            alert("specifictask_no : " + data.specifictask_no);
            
            var insertspecific = "<div class='specifictaskbox' style='background-color : none;' id='"+taskno.cont+"specific'>"
                           + cont 
                           + "<button class='specifictaskbutton' id='"+specificno+"specificbutton' style='background-color: window; border: none;' >"                   
                           + "<i class='fa fa-pencil'>"                                   
                           + "</i></button>"  
                           + "<input type='checkbox' class='sp-checkbox' id='"+taskno+1+"sp-checkbox' value='"+taskno+1+"'>"
                           + "</div>"; 
                                                                                                                                                              
                $("#"+taskno+"tasktitle").append(insertspecific);
                
                $("#"+specificno+"specificbutton").click(function () {
                    
                    if ($('#toggletest_jjh').is(":visible") == true) {
                       $('#main-content').css({
                           'margin-left': '210px'
                       });
                       $('#toggletest_jjh').css({
                           'margin-right': '-210px'
                       });
                       $('#toggletest_jjh').hide(50); 
                       
                  } else {
                          $('#main-content').css({
                              'margin-right': '0px'
                          });
                           $('#toggletest_jjh').slideToggle();   
                          $('#toggletest_jjh').css({
                              'margin-right': '0'
                          }); 
                           
                          
                       }  
                   var specifictaskno=data.specifictask_no;
                   detailSpecifictask(specifictaskno);
               });
             },
             error : function(){
                alert("error");
                }
             });
   }  
            

   function detailSpecifictask(specifictaskno,specifictaskcont){
   console.log(specifictaskno);  
      $.ajax({
          url : "detailSpecifictaskajax.htm",
          type : "post",
          data : {specifictask_no : specifictaskno},          
          dataType : "json",
          success : function(data){
                
                console.log(data.data);
                         
             if(data.data!=null){
                $("#specifictask_start").val(data.data.specifictask_start);
                $("#specifictask_end").val(data.data.specifictask_end);
                $("#taskmember_id").val(data.data.member_id); 
                $("#specifictask_no").val(specifictaskno);
                $(".specifictask_no").val(specifictaskno);
                
             }else{          
                $("#specifictask_start").val("");
                $("#specifictask_end").val("");
                $("#taskmember_id").val(""); 
                $("#specifictask_no").val(specifictaskno);
                $(".specifictask_no").val(specifictaskno);
             }                   

          },
          error : function(){
            alert("error");
          }
       }); 

    } 

    //delete
    function deletespecific(projectno, taskno){
      
      console.log("taskno : "+taskno);
      console.log("projectno: "+projectno);
      
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


</script>

   <section class="wrapper site-min-height">
      <div>
         <div>
            <h3 style="padding-top: 17px;">
               <i class="fa fa-angle-right"></i> ${project_name}
            </h3>
            <sec:authentication property="principal.username" var="user" />
            <c:if test="${owner==user}">
               <button type="button" class="btn btn-theme02" data-toggle="modal"
                  data-target="#myModal">
                  <i class="fa fa-plus"></i> 업무 리스트 추가
               </button>
            </c:if>

            <!-- 업무리스트 추가 Modal -->
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
               <button class="tablinks btn btn-primary"
                  onclick="openCity(event, 'London')" id="defaultOpen"
                  style="margin-left: 20px; width: 40%; background-color: #fafafa; color: black;">속성</button>
               <button class="tablinks btn btn-danger"
                  onclick="openCity(event, 'Paris')"
                  style="width: 40%; background-color: #fafafa; color: black;">파일</button>
               <hr>
            </div>

            <div id="London" class="tabcontent">
               <form action="updateSpecifictask.htm" method="post">

                  <div class="form-group">
                     <p>
                        세부업무명 : <input id="specont" type="text" name="specifictask_cont"
                           value="${specifictask_cont}" readonly="readonly">
                     </p>
                  </div>
                  <hr>
                  <div class="form-group">
                     <label>업무배정 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> 
                     <select name="member_id" id="sel" value="">
                        <option value="${modidto.member_id}">${modidto.member_id}</option>
                        <c:forEach items="${memberlist}" var="mlist">
                           <option value="${mlist.member_id}">${mlist.member_id}</option>
                        </c:forEach>
                     </select>
                     <p>
                        배정된 인원 : <input type="text" readonly="readonly"
                           id="taskmember_id" name="memberid" value="${modidto.member_id}">
                     </p>
                  </div>
                  <hr>

                  <div class="form-group">
                     <label> <i></i>기간설정
                     </label>

                     <div class="form-group">
                        <p>
                           시작일:<input
                              class="form-control form-control-inline input-medium default-date-picker"
                              width="50%" type="text" value="${modidto.specifictask_start}"
                              id="specifictask_start" name="specifictask_start">

                        </p>
                        <%-- <input type="text" id="specifictask_start" name="specifictask_start" value="${modidto.specifictask_start}"></p> --%>
                     </div>
                     <div class="form-group">
                        <p>
                           마감일:<input
                              class="form-control form-control-inline input-medium default-date-picker"
                              size="8" type="text" value="${modidto.specifictask_end}"
                              id="specifictask_end" name="specifictask_end">
                        </p>
                        <%-- <input type="text" id="specifictask_start" name="specifictask_start" value="${modidto.specifictask_start}"></p> --%>
                     </div>

                     <input type="hidden" id="specifictask_no" name="specifictask_no"
                        value="">
                     <button type="submit" class="btn btn-primary" id="btn-submit"
                        style="float: left; margin-left: 30px; width: 30%; background-color: #ffd777; color: navy;">수정</button>
                     <%-- <button type="button"><a href="deleteSpecifictask.htm?specifictask_no=${specifictaskno}">업무삭제</a></button> --%>
               </form>

               <form action="deleteSpecifictask.htm">
                  <input type="hidden" class="specifictask_no"
                     name="specifictask_no" value="">
                  <button type="submit" class="btn btn-danger"
                     style="float: left; margin-left: 10px; width: 30%; background-color: #ffd777; color: navy;">삭제</button>
               </form>
            </div>
         </div>

         <div id="Paris" class="tabcontent">

            <form class="form-horizontal style-form" action="uploadfile.htm"
               method="post" enctype="multipart/form-data">
               <div>
                  <label>파일업로드</label> <input type="hidden" name="specifictask_no"
                     value="${specifictask_no}"> <input type="file"
                     name="file">
               </div>
               <br>
               <button type="submit" class="btn btn-primary"
                  style="background-color: #ffd777; color: navy;">파일올리기</button>

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