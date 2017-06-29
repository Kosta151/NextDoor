<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authentication property="name" var="loginUser"/>
<script src="resources/main/assets/js/jquery-1.8.3.min.js"></script>
<script src="resources/sockjs-0.3.js"></script>
	<script>
		var sock;
		$(function() {
			
			console.log("opening websocket");
 			sock = new SockJS("http://" +document.domain + ":8090/nextdoor/alarm");
 			 
			sock.onopen = function(){
				  console.log("opened websocket");
				  sock.send("");
			  };
			
			  sock.onmessage = function(event){
					 var msg = JSON.parse(event.data);
					 var receiver = msg.receiver;
					 var user_id = msg.user_id;
					 var specifictask_cont = msg.specifictask_cont;
					 var user = '${loginUser}'
					 if(user!=user_id){
						  console.log("아이디 : "+msg.specifictask_cont +"  // 받는이 : "+ msg.receiver );
						$("#alarmarea").html("<li class='error'>"+user_id+"님이"+receiver+"님에게"+specifictask_cont+"배당 받으셨습니다</li>");
						$('.error').fadeIn(1000).delay(1000).fadeOut(1000);
					 	} 
				 };
		 		  $('#btn-submit').click(function(){
		 			 var receiver = $("#select").val();
		 			  var specifictask_cont = $('#task').val();
		 			  var obj = {};
		 			  obj.receiver = receiver;
		 			  obj.specifictask_cont = specifictask_cont;
		 			  var str = JSON.stringify(obj);
		 			 if($("#select").val() != ""){  	 
		 				 sock.send(str);
		 				
		 		
		 		  }
				  });	  
		 		 
 
		 	
		});
	

</script>
<style>
.error {
    width: 250px;
    height: 20px;
    height:auto;
    position: fixed;
    left: 50%;
    margin-left:-125px;
    bottom: 100px;
    z-index: 9999;
    background-color: #383838;
    color: #F0F0F0;
    font-family: Calibri;
    font-size: 15px;
    padding: 10px;
    text-align:center;
    border-radius: 2px;
    -webkit-box-shadow: 0px 0px 24px -1px rgba(56, 56, 56, 1);
    -moz-box-shadow: 0px 0px 24px -1px rgba(56, 56, 56, 1);
    box-shadow: 0px 0px 24px -1px rgba(56, 56, 56, 1);
}

</style>
	
	
	
<!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a class="logo" href="#" onClick="window.location.reload( true );"><b>Next Door</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">

                <!--  notification start -->
                <ul class="nav top-menu" >
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                       <a data-toggle="dropdown" class="dropdown-toggle" onclick="location.href='URL'=alarmlist.htm" >  <!--  -->
                            <i class="fa fa-envelope-o">
                            <span class="badge bg-theme" id="count">${alarmcount}</span> <!--컨트롤러에서 담아서 쏴줌  -->
                      	</i>
                      </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-ar bvrow notify-arrow-green"></div>
                            <li>
                                <p class="green">알림 내용</p>
                            </li>
                            
                            <c:forEach items="${alarmlist}" var="alarm">	
                            <li>
                              <a href="index.html#">
								<span class="from">${alarm.alarm_sender}</span>
								<span class="time">${alarm.alarm_date}</span>	
								<span class="message">${alarm.alarm_cont}</span>                                     
                          	</a>
                            </li>   
                            	</c:forEach>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="resources/main/assets/img/ui-sherman.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dj Sherman</span>
                                    <span class="time">4 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Please, answer asap.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">See all messages</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="lockscreen.htm">LockScreen</a></li>
                    <li><a class="logout" href="/nextdoor/logout">Logout</a></li>
            	</ul>
            </div>
        </header>
        <!--header end-->