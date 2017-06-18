<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script src="${pageContext.request.contextPath}/resources/login/facebook.js" ></script>
	 
	<div id="login-page">
	  	<div class="container">
		      <form class="form-login" action="./login" method="post">
		        <h2 class="form-login-heading">sign in now</h2>
		        <div class="login-wrap">
		            <input type="text" class="form-control" name="member_id" placeholder="User Email" autofocus>
		            <br>
		            <input type="password" class="form-control" name="password" placeholder="Password">
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> Forgot Password?</a>
		                </span>
		            </label>
		            <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> SIGN IN</button>
		            <hr>
		            <div class="login-social-link centered">
		            <p>or you can sign in via your social network</p>
		                <button class="btn btn-facebook" name="loginBtn" type="submit" onclick="login()"><i class="fa fa-facebook"></i> Facebook</button>
		                <!-- <button class="btn btn-twitter" type="submit"><i class="fa fa-twitter"></i> Twitter</button> -->
		            </div>
		            <div class="registration">
		                Don't have an account yet?<br/>
		                <a class="" href="join.htm">
		                    Create an account
		                </a>
		            </div>
		        </div>
		      </form>

		       <!-- 비밀번호찾기 modal -->
		       <form action="password.htm" method="post">
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Forgot Password ?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>Enter your e-mail address below to reset your password.</p>
		                          <input type="text" name="member_id" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
								  <input type="hidden" name="template" value="SearchPassword.vm">	
								  <input type="hidden" name="subject" value="새로운 비밀번호">
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		                         <!--  <button class="btn btn-theme" type="button">Submit</button> -->
		                          <input type="submit" class="btn btn-theme" value="Submit">
		                      </div>
		                  </div>
		              </div>
		          </div>
		       </form> 
		       <!-- modal end -->

	  	</div>
	  </div>