<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	  <div id="login-page">
	  	<div class="container">
		      <div class="form-login">
		        <h2 class="form-login-heading">Work Space</h2>
		        <div class="login-wrap">
 		        	<c:forEach items="${workspacelist}" var="list">
 		        	<form action="projectList.htm" method="post">
						<input type="hidden" name="workspace_no" value="${list.workspace_no}">
						<button class="btn btn-default btn-lg btn-block" type="submit">${list.workspace_name}</button>
 		        		<a href="workspaceDelete.htm?workspace_no=${list.workspace_no}"><i class="fa fa-times-circle" aria-hidden="true"></i></a>
		        	</form>
		        	</c:forEach>
		        	<a class="btn btn-theme btn-block" href="workspaceInsert.htm"><i class="fa fa-plus"></i> 새로운워크스페이스 만들기</a>
		        </div>
		      </div>
	  	</div>
	  </div>