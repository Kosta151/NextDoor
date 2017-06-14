<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<link href="resources/main/assets/css/style.css" rel="stylesheet">
	
<!--header start-->
      <header class="header black-bg">
               <!-- <div class="sidebar-toggle-box">
                  <div class="fa fa-cog tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
               </div> --> 
            <!--logo start-->
            <a href="index.html" class="logo"><b>Next Door</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
            
                <!--  헤드 아이콘 -->
                <ul class="nav top-menu">
                    
                    <!-- settings start -->
                    <li class="dropdown">
                        <a  href="index.html#">
                            <i class="fa fa-tasks"></i>                        
                        </a>
                    </li> 
                    
                    <li class="dropdown">
                        <a  href="index.html#">
                            <i class="fa fa-tasks"></i>                        
                        </a>
                    </li>
                    
                    <li class="dropdown">
                        <a  href="index.html#">
                            <i class="fa fa-tasks"></i>                        
                        </a>
                    </li>
                    
                    <li class="dropdown">
                        <a  href="index.html#">
                            <i class="fa fa-tasks"></i>                        
                        </a>
                    </li>
                    
                     <li id="header_inbox_bar" class="dropdown"> 
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                        </a>                    
                    </li>
                </ul>
               </div>
               <!-- 헤드 아이콘 끝 -->
                
                <!--  notification end -->
                
                <!-- <div class="btn-group open">
						  <button type="button" class="btn btn-theme dropdown-toggle" data-toggle="dropdown">
						    Action <span class="caret"></span>
						  </button>
						  <ul class="dropdown-menu" role="menu">
						    <li><a href="#">Action</a></li>
						    <li><a href="#">Another action</a></li>
						    <li><a href="#">Something else here</a></li>
						    <li class="divider"></li>
						    <li><a href="#">Separated link</a></li>
						  </ul>
						</div> -->
						
			<!-- <div class="top-menu">
				<ul class="dropdown-menu" role="menu">
						    <li><a href="#">Action</a></li>
						    <li><a href="#">Another action</a></li>
						    <li><a href="#">Something else here</a></li>
						    <li class="divider"></li>
						    <li><a href="#">Separated link</a></li>
				</ul>
            	 <ul class="nav pull-right top-menu">
                    <li><a class="logout" href="login.html">Logout</a></li>
            	</ul>
            </div> -->
                
            
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
	            	
                    <li><a class="logout" href="login.html">Logout</a></li> 
                    
                    <button type="button" class="btn btn-theme dropdown-toggle" data-toggle="dropdown">
							    WorkSpace <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
							    <!-- foreach문 돌리기 -->						   
							    <li><a href="#">워크스페이스명</a></li>					    
					</ul>
				               
            	</ul>
            </div>
        </header>
        <!--header end-->