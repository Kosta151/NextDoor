<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <!--sidebar start-->
       <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="resources/main/assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">${plist.member_id}</h5>
              	  	
                  <li class="mt">
                      <a class="active" href="projectList.htm">
                          <i class="fa fa-desktop"></i>
                          <span>프로젝트</span>
                      </a>
                  </li>
      	
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-tasks"></i>
                          <span>전체업무</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="projectList.htm" >
                          <i class="fa fa-tasks"></i>
                          <span>내업무</span>
                      </a>
                  </li>
                  
                  <li class="sub-menu">
                      <a href="calendar.htm" >
                          <i class="fa fa-book"></i>
                          <span>캘린더</span>
                      </a>
                  </li>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->