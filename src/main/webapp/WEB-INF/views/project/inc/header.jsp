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
			  };
			
			  sock.onmessage = function(event){
					 var msg = JSON.parse(event.data);
					 var receiver = msg.receiver;
					 var user_id = msg.user_id;
					 var specifictask_cont = msg.specifictask_cont;
					 var user = '${loginUser}'
					 if(user!=user_id){
						  console.log("아이디 : "+msg.specifictask_cont +"  // 받는이 : "+ msg.receiver );
						$("#alarmarea").html("<li class='error'>"+user_id+"님이"+receiver+"님에게"+"<br>"+specifictask_cont+"업무를 배당 받으셨습니다</li>");
						
						var closebutton = $('.error');
						closebutton.on('click',function(){
							$(this).parent().hide();
						});
					 	} 
				 };
		 		  $('#btn-submit').click(function(){
		 			  var receiver = $("#sel").val();
		 			  var specifictask_cont = $('#specont').val();
		 			  var obj = {};
		 			  obj.receiver = receiver;
		 			  obj.specifictask_cont = specifictask_cont;
		 			  var str = JSON.stringify(obj);
		 			  
		   			 if($("#sel").val() != ""){  	 
		 				 sock.send(str);
		 				 
		 		
		 		  }
				  });	  
		 		 
 
		 	sock.onclose = function(){
		 		console.log("close");
		 	}
		 	
		 	sock.onerror = function() {
				console.log("Error")
			};
		});
			//알림리스트에서 한개 누르면 알림 갯수 감소
		 function updatealarm(alarm_no, alarm_receiver){
		      
		        $.ajax({
		          url : "alarm.htm",
		          type : "POST",
		          data : {alarm_no : alarm_no ,alarm_receiver : alarm_receiver},
		          dataType : "json",
		          success : function(data){
		            console.log(data);
					console.log(data.alarm_count);
					 $('#count').empty();
		           	 $("#count").append(data.alarm_count);
		           	 
		         
		          },
		          error : function(){
		            alert("error");
		          }
		       }); 
		   }
			
			
		function countalarm(member_id,specifictask_no, specifictask_cont){
			
	        $.ajax({
	          url : "updateSpecifictask.htm",
	          type : "POST",
	          data : {alarm_no : alarm_no ,alarm_receiver : alarm_receiver},
	          success : function(data){
	            console.log(data);
	            var alarm_count = data.alarm_count;
	           $("#count").append(alarm_count);
	           
	         
	          },
	          error : function(){
	            alert("error");
	          }
	       }); 
	   }
</script>
<style>
.error {
    width: 250px;
    height: 100px;
    position: fixed;
    right: 0;
    top:0;
    margin-top: 60px;
    margin-left:-125px;
    bottom: 100px;
    z-index: 9999;
    background-color: #ffffff;
    color: #291647;
    font-family: Calibri;
    font-size: 17px;
    font-weight :bold;
    padding: 10px;
    text-align:center;
    border-radius: 2px;
    
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
            <ul id="alarmarea"></ul>
                <!--  notification start -->
                <ul class="nav top-menu">

                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                       <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#"> 
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme" id="count">${alarmcount}</span>
                      </a>
                        <ul class="dropdown-menu extended inbox">
                            
                            
                            <div class="notify-ar bvrow notify-arrow-green" style="overflow-y:scroll; width: 450px; height: 450px" scrollbars=yes, resizable>
                            
                            <li style="width: 420px;" >
                                <p class="green">알림 내용</p>
                            </li>
                            
                            <c:forEach items="${alarmlist}" var="alarm">
                           
                            <li style="width: 420px; background-color: white;"  id="colorchange">
                            <a id="alarm_update" href="javascript:updatealarm('${alarm.alarm_no}','${alarm.alarm_receiver}')" >
                            <input type="hidden" id="alarm_no" value="${alarm.alarm_no}">
                            <input type="hidden" id="alarm_receiver" value="${alarm.alarm_receiver}">
                             	<span class="photo"><img alt="avatar" src='resources/main/assets/img/zz.png'></span>
                             	<span class="subject">
								<span class="from">${alarm.alarm_sender}</span>&nbsp;&nbsp;&nbsp;
								<span class="from">${alarm.alarm_date}</span>
								</span>	
								<span class="message">
								${alarm.alarm_cont}
								</span> 
								</a>                                   
                             </li>
                             </c:forEach>
                            </div>
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