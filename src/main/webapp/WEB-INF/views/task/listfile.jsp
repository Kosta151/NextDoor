<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="main-content">
	<section class="wrapper site-min-height">
		<div class="row mt">
			<div class="col-md-12">
		    	<div class="content-panel">
		        	<table class="table table-striped table-advance table-hover">
			        	<h4><i class="fa fa-angle-right"></i> File List </h4>
			            	<hr>
		                    <thead>
		                    	<tr>
		                        	<th><i class="fa fa-bullhorn"></i> 이름 </th>
		                            <th class="hidden-phone"><i class="fa fa-question-circle"></i> 크기 </th>
		                            <th><i class="fa fa-bookmark"></i> 공유한 날짜 </th>
		                            <th><i class=" fa fa-edit"></i> 공유한 사람 </th>
		                            <th>다운로드</th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                    <c:forEach items="${filelist}" var="list">
		                    	<tr>
		                        	<td>${list.original_name}</td>
		                            <td>${list.file_size} byte</td>
		                            <td>${list.file_date}</td>
		                            <td>${list.member_id}</td>
		                            <td><a href="download.htm?file_name=${list.file_name}"><button class="btn btn-default btn-xs"><i class="fa fa-arrow-circle-o-down">download</i></button></a></td>
		                        </tr>
		                    </c:forEach>
							</tbody>
		            </table>
				</div><!-- /content-panel -->
			</div><!-- /col-md-12 -->
		</div><!-- /row -->
	</section>
</section>