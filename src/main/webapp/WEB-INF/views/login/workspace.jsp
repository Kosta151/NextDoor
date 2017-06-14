<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	  <div id="login-page">
	  	<div class="container">
		      <form class="form-login">
		        <h2 class="form-login-heading">Work Space</h2>
		        <div class="login-wrap">
 		        	<c:forEach items="${workspacelist}" var="list">
		        		<a href="projectList.htm?workspace_no=${list.workspace_no}" class="btn btn-default btn-lg btn-block">
		        			${list.workspace_name}
		        			<i class="fa fa-chevron-right"></i>
		        			<a href="workspaceDelete.htm?workspace_no=${list.workspace_no}"><i class="fa fa-times-circle" aria-hidden="true"></i></a>
		        		</a>
		        	</c:forEach>
		        	<a class="btn btn-theme btn-block" href="workspaceInsert.htm"><i class="fa fa-plus"></i> 새로운워크스페이스 만들기</a>
		        </div>
		      </form>
	  	</div>
	  </div>