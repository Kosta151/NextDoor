<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- DatePicker(jQuery UI) -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                          <div class="modal-dialog modal-sm">
                              <div class="modal-content">
                                  <div class="modal-header">
                                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                      <h4 class="modal-title">새 프로젝트 생성</h4>
                                  </div>
                                  <form action="insertProject.htm" method="post">
                                  <div class="modal-body">
                                      <p>프로젝트명</p>
                                      	<input type="hidden" name="workspace_no" value="${workspace_no}">
										<input type="text" name="project_name" placeholder="project명을 입력해주세요." autocomplete="off" class="form-control placeholder-no-fix">
										<br>
										<div class="btn-group" data-toggle="buttons">
											<label class="btn btn-default">
												<input type="radio" name="options" value="public" autocomplete="off" checked> 공개
											</label>
											<label class="btn btn-default">
												<input type="radio" name="options" value="private" autocomplete="off"> 비공개
											</label>
										</div>
                                  </div>
                                  <div class="modal-footer centered">
                                      <button class="btn btn-warning" type="submit">생성</button>
                                      <button data-dismiss="modal" class="btn btn-default" type="button">취소</button>
                                  </div>
                                  </form>
                              </div>
                          </div>
                      </div><!-- modal -->

</body>
</html>