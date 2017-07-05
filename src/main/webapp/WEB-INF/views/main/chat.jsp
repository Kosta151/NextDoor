<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authentication property="name" var="loginUser" />
    <script src="resources/main/assets/js/jquery-1.8.3.min.js"></script>
<script src="resources/sockjs-0.3.js"></script>
<link href="resources/main/assets/css/style2.css" rel="stylesheet">
<!-- 
   @Project : NextDoor
   @File name : chat.jsp
   @Author : 이재민
   @Data : 2017. 06. 21
   @Desc : 채팅화면
 -->
<script>
//소켓 변수
var sock;

$(function() {
	//소켓 url을 chat-sock으로 설정 후 소켓 생성
	sock = new SockJS("http://" +document.domain + ":8090/nextdoor/chat-ws");
	
	//접속 이벤트 발생 시 메시지 전송
	sock.onopen = function() {
		sock.send("${loginUser}님이 접속하셨습니다.");
		
	};
	//메시지 수신 이벤트 발생 시 리스트 태그처리 후 chatarea에 append
	sock.onmessage = function(event) {
		var msg = JSON.parse(event.data);
		var user_id = "${loginUser}";
		var message = msg.message;
		if (msg.user_id != user_id) {
			$("#chatarea").append("<div class='group-rom'>" +"<div class='first-part'>"+ msg.user_id+"</div>"+"<div class='second-part'>" + msg.message +"</div>"+"<div class='third-part'>" + msg.date +"</div>"+"</div>");
		} else {
			$("#chatarea").append("<div class='group-rom'>" +"<div class='first-part odd'>"+ msg.user_id+"</div>"+"<div class='second-part'>" + msg.message +"</div>"+"<div class='third-part'>" + msg.date +"</div>"+"</div>");
		}
		$("#chatpanel").scrollTop($('#chatpanel').height());	
		
	};
	
	//접속 종료 이벤트 발생 시 메시지 전송
	sock.onclose = function() {
		sock.send("${loginUser}님이 로그아웃하셨습니다.");
	};
	sock.onerror = function() {};
	//메시지 전송 버튼 클릭 했을 시 소켓 메시지전송
	$("#btn-chat").click(function() {
		if ($("#btn-input").val() != "") {
			sock.send($("#btn-input").val());
			$("#btn-input").val("");
		}
	});
	
	//엔터키 이벤트 발생 시 소켓 메시지 전송
	$('#btn-input').keyup(function(e) {
		/* 13 == enter key@ascii */
		if (e.which == 13) {
			if ($("#btn-input").val() != "") {
				sock.send($("#btn-input").val());
				$("#btn-input").val("");
			}
		}
	});
	$('#btn-end').click(function(){
		sock.onclose();
	});

});



</script>

     <section id="main-content">
          <section class="wrapper site-min-height">
            <div id="userList" >
            	<aside class="mid-side">
              		<div class="chat-room-head" style="width: 80%; margin-left: 125px; margin-top: 10px; background-color: #424a5d; ">
               			<h3>Project Chat Room</h3>
                    </div>
                <div id = "chatpanel" class="panel-body chat-panel-body" style="background-color: white;width: 80%;height: 400px; margin-left: 125px; overflow: scroll;" >
					<ul class="chat" id="chatarea"></ul>
				</div>
            <div class="chat-txt" style="width: 80%;">
				<input type="text" class="form-control" id="btn-input" name="chatInput" style="width: 90%; margin-left: 130px">
			</div>
				<span>
					<button class="btn btn-theme" id="btn-chat" style="background-color: #797979; border-color: #797979;">Send</button>
                </span>
                	<button class="btn btn-theme" id="btn-end" style="background-color: #797979; border-color: #797979;">종료</button>
                      
                 </aside>               
                  <input type="hidden" id="nickname" value="${loginUser}">   
             </div>
             	 <!-- page end-->			
        </section>
     </section><!-- /MAIN CONTENT -->
