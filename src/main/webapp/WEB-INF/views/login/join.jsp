<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <script src="${pageContext.request.contextPath}/resources/login/facebook.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/login/joinCheck.js"></script>
     <div id="login-page">
        <div class="container">
            <form name="loginform" id="loginform" class="form-login" action="join.htm" method="post">
              <h2 class="form-login-heading">join now</h2>
              <div class="login-wrap">
                  <input id="member_id" type="text" class="form-control" name="member_id" placeholder="User Email" onblur="idCheck()" autofocus>
                  <div class="email-msg" id="email-msg"></div>
                  <br>
                  <input id="password" type="password" class="form-control" name="password" placeholder="Password">
                  <br>
                  <input id="repassword" type="password" class="form-control" name="repassword" placeholder="Password check">
                  <br>
                  <input id="name" type="text" class="form-control" name="name" placeholder="User Name">
                  <br>               
                  <button id="submit" class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> JOIN</button>
                  <hr>
                  <div class="login-social-link centered">
                  <p>or you can sign in via your social network</p>
                      <button class="btn btn-facebook" type="button" onclick="login()"><i class="fa fa-facebook"></i> Facebook</button>
                      <button class="btn btn-twitter" type="button"><i class="fa fa-twitter"></i> Twitter</button>
                  </div>
              </div>
            </form>    
            
                
        </div>
     </div>