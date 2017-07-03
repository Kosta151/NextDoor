<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery-ajax-form-submit/</title>
<!-- jQuery import -->
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<!-- jQuery Form Plugin import -->
<script src="<%=request.getContextPath() %>/resources/task/jquery.form.min.js"></script>
<!-- jQuery MultiFile Plugin import -->
<script src="<%=request.getContextPath() %>/resources/task/jQuery.MultiFile.min.js"></script>
<script src="resources/main/assets/js/sweetalert.min.js"></script>



<script>
$(document).ready(function(){
    
	//use jQuery MultiFile Plugin
    $('#multiform input[name=file]').MultiFile({
        max: 5, //업로드 최대 파일 갯수 (지정하지 않으면 무한대)
       
        STRING: { //Multi-lingual support : 메시지 수정 가능
            remove : "제거", //추가한 파일 제거 문구, 이미태그를 사용하면 이미지사용가능
            duplicate : "$file 은 이미 선택된 파일입니다.", 
            denied : "$ext 는(은) 업로드 할수 없는 파일확장자입니다.",
            selected:'$file 을 선택했습니다.', 
            toomuch: "업로드할 수 있는 최대크기를 초과하였습니다.($size)", 
            toomany: "업로드할 수 있는 최대 갯수는 $max개 입니다.",
            toobig: "$file 은 크기가 매우 큽니다. (max $size)"
        },
        list:"#afile3-list" //파일목록을 출력할 요소 지정가능
    });
});
</script>

</head>
<body>

<div class="multiform_body" style="text-align: center; align:center;">
<form name="multiform" id="multiform" action="uploadfile.htm"
                                      method="POST" enctype="multipart/form-data">
	<!-- 다중 파일업로드  -->
	
	<br>
 	<div id="afile3-list" style="border:1px solid #c9c9c9; min-weight:50px; min-height:100px;margin:10px;"></div>
 	
 	<input type="file" name="file" style="align:center;" />
	<input type="submit" id="btnSubmit" style="width:50%; align:center;" value="전송" class="btn btn-warning"/><br/>
</form>
</div>
<script>
/*jQuery form 플러그인을 사용하여 폼데이터를 ajax로 전송*/
var downGroupCnt =0; //다운로드그룹 개수카운트

$(function(){
		
	//폼전송 : 해당폼의 submit 이벤트가 발생했을경우 실행  
    $('#multiform').ajaxForm({
       cache: false,
       dataType:"json",
       type:'POST',
       //보내기전 validation check가 필요할경우
       beforeSubmit: function (data, frm, opt) {
           return true;
       },
       //submit이후의 처리
       success: 
    	function(data, statusText){
    	   swal({
               title: "파일 업로드 완료!",
               type: "success",
               showCancelButton: false,
               confirmButtonColor: "#194f89",
               confirmButtonText: "확인",
               closeOnConfirm: false
               
             })
       },
       //ajax error
       error: function(e){
           
       }                               
	});
});
</script>

</body>
</html>
