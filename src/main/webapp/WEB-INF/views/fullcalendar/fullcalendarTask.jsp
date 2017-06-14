<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- DatePicker(jQuery UI) -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>ㄴ
<title>Insert title here</title>
<script type="text/javascript">
   
</script>
<style>
   body {
      margin: 40px 10px;
      padding: 0;
      font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
      font-size: 14px;
        }
</style>

</head>
<body>
     <!--main content start-->
      <section id="main-content">
        <section class="wrapper">
             <h3><i class="fa fa-angle-right"></i> Calendar</h3>
              <!-- page start-->
              <div class="row mt">
                   <aside class="col-lg-3 mt"></aside>
                  <aside class="col-lg-6 mt">
                      <section class="panel">
                          <div class="panel-body">
                              <div id="calendar"></div>
                          </div>
                      </section>
                  </aside>
              </div>
              <!-- page end-->
         </section>
      </section>
      <!-- /MAIN CONTENT -->
      
						<!-- Modal -->
                      	  <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal2" class="modal fade">
                          <div class="modal-dialog">
                          <form action="insertProject.htm" method="post">
                              <div class="modal-content">
                                  <div class="modal-header">
                                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                      <h4 class="modal-title">새 프로젝트 생성</h4>
                                  </div>
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
                              </div>
                            </form>
                          </div>
                      </div>
                      <!-- modal -->

</body>
</html>