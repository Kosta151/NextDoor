<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <!--sidebar start-->
       <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="#" onClick="window.location.reload( true );"><img src="resources/main/assets/img/ui-sam.jpg" class="img-circle" width="90"></a></p>
              	  <h5 class="centered"><sec:authentication property="principal.username"/></h5>
                  <li class="mt">
                      <a class="active" href="#" onClick="window.location.reload( true );">
                          <i class="fa fa-desktop"></i>
                          <span>현재 프로젝트</span>
                      </a>
                  </li>
      	
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-tasks"></i>
                          <span>워크스페이스</span>
                      </a>
                      <ul class="sub">
                      	  <c:forEach items="${workspacelist}" var="list">
                      	   <form id="worklist" action="projectList" method="get">
                      		  <li><a href="projectList.htm?workspace_no=${list.workspace_no}">${list.workspace_name}</a></li>
                           </form>
                          </c:forEach>
                      </ul>
                  </li>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->