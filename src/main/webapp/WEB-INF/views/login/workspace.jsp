<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- 
   @Project : NextDoor
   @File name : workspace.jsp
   @Author : 이재민
   @Data : 2017. 06. 21
   @Desc : 워크스페이스 화면
 -->
	  <div id="login-page">
	  	<div class="container">
		      <div class="form-login">
		        <h2 class="form-login-heading">Work Space</h2>
		        <div class="login-wrap">
 		        	<form action="projectList.htm" method="get">
 		        	<sec:authentication property="principal.username" var="loginuser"/>
 		        	<c:forEach items="${workspacelist}" var="list">
						<c:choose>
							<c:when test="${list.member_id==loginuser}">
								<div class="btn-group">
								  <button type="submit" class="btn btn-default" style="width:250px; height: 45px; font-size: 16px; margin-bottom: 10px;" name="workspace_no" value="${list.workspace_no}">${list.workspace_name}</button>
								  <button type="button" class="btn btn-default" style="width:40px; height: 45px;" onclick="location.href='workspaceDelete.htm?workspace_no=${list.workspace_no}'"><i class="fa fa-trash-o"></i></button>
								</div>							
							</c:when>
							<c:otherwise>
								<button type="submit" class="btn btn-default" style="width:290px; height: 45px; font-size: 16px; margin-bottom: 10px;" name="workspace_no" value="${list.workspace_no}">${list.workspace_name}</button>
							</c:otherwise>
						</c:choose>
		        	</c:forEach>
					</form>
		        	<a class="btn btn-theme btn-block" href="workspaceInsert.htm"><i class="fa fa-plus"></i> 새로운워크스페이스 만들기</a>
		        </div>
		      </div>
	  	</div>
	  </div>