<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="ValidationJS/jquery.validate.js"></script>
 
 
<script>
$(function(){
        
     $("#loginform").validate({
        rules: {
        	member_id: {
                required : true,
                minlength : 30
            },
            password: {
                required : true,
                minlength : 10
            },
            repassword: {
                required : true,
                minlength : 10,
                equalTo : password
            },
            name: {
                required : true,
                minlength : 2
            }
        },
        //규칙체크 실패시 출력될 메시지
        messages : {
        	member_id: {
                required : "필수로입력하세요",
                minlength : "최소 {0}글자이상이어야 합니다",
                //remote : "존재하는 아이디입니다"
            },
            password: {
                required : "필수로입력하세요",
                minlength : "최소 {0}글자이상이어야 합니다"
            },
            repassword: {
                required : "필수로입력하세요",
                minlength : "최소 {0}글자이상이어야 합니다",
                equalTo : "비밀번호가 일치하지 않습니다."
            },
            name: {
                required : "필수로입력하세요",
                minlength : "최소 {0}글자이상이어야 합니다"
            }
        }
    });
});
 
</script>

     <div id="login-page">
        <div class="container">
            <form name="loginform" id="loginform" class="form-login" action="join.htm" method="post">
              <h2 class="form-login-heading">join now</h2>
              <div class="login-wrap">
                  <input id="member_id" type="text" class="form-control" name="member_id" placeholder="User Email" autofocus>
                  <p id="vail_id" style="display:none; margin:0px">이메일을 입력하세요</p>
                  <br>
                  <input id="password" type="password" class="form-control" name="password" placeholder="Password">
                  <p id="vail_pwd" style="display:none; margin:0px">비밀번호를 입력하세요</p>
                  <br>
                  <input id="repassword" type="password" class="form-control" name="repassword" placeholder="Password check">
                  <p id="vail_repwd" style="display:none; margin:0px">비밀번호가 일치하지 않습니다.</p>
                  <br>
                  <input id="name" type="text" class="form-control" name="name" placeholder="User Name">
                  <p id="vail_name" style="display:none; margin:0px">이름을 입력하세요</p>
                  <br>               
                  <button id="submit" class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> JOIN</button>
                  <hr>
                  
                  <div class="login-social-link centered">
                  <p>or you can sign in via your social network</p>
                      <button class="btn btn-facebook" type="submit"><i class="fa fa-facebook"></i> Facebook</button>
                      <button class="btn btn-twitter" type="submit"><i class="fa fa-twitter"></i> Twitter</button>
                  </div>
              </div>
            </form>        
        </div>
     </div>