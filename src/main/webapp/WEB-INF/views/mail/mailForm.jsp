<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>

 

 <section id="main-content">
          <section class="wrapper">
<div class="container">
  <h4>메일 보내기</h4>
  <form action="${pageContext.request.contextPath}/mail.htm" method="post">
    <div align="center"><!-- 받는 사람 이메일 -->
      <input type="text" name="member_id" size="120" style="width:100%" placeholder="상대의 이메일" class="form-control" >
      <input type="hidden" name="template" value="mailform.vm">
      <input type="hidden" name="subject" value="초대메일">
    </div>     
    <div align="center">
      <input type="submit" value="메일 보내기" class="btn btn-warning">
    </div>
  </form>
  </div>
  </section>
  </section>
