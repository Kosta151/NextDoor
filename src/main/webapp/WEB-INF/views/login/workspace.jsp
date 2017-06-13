<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	  <div id="login-page">
	  	<div class="container">
		      <form class="form-login">
		        <h2 class="form-login-heading">Work Space</h2>
		        <div class="login-wrap">
		        
		        	<c:forEach items="${workspacelist }" var="list">
		        		 <a href="main.htm?workspace=${list.workspace_name}" class="btn btn-default btn-lg btn-block">
		        			${list.workspace_name}
		        			<i class="fa fa-chevron-right"></i>
		        		</a>
		        	</c:forEach>
		         
	        		<a href="main.htm" class="btn btn-default btn-lg btn-block">
	        			<i class="fa fa-file"></i>
	        			KOSTA 프로젝트
	        			<i class="fa fa-chevron-right"></i>
	        		</a>

	        		<a href="main.htm" class="btn btn-default btn-lg btn-block">
	        			<i class="fa fa-file"></i>
	        			FINAL 프로젝트
	        			<i class="fa fa-chevron-right"></i>
	        		</a>

		        	<a class="btn btn-theme btn-block" href="workspaceInsert.htm"><i class="fa fa-plus"></i> 새로운워크스페이스 만들기</a>
		        </div>
		      </form>
	  	</div>
	  </div>