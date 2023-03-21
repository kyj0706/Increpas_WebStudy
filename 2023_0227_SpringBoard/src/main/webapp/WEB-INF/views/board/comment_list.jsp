<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x 사용설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- 삭제 -->
<script type="text/javascript">
	function comment_delete(cmt_idx){
		
		
		if(confirm("정말 삭제하시겠습니다?")==false) return;
		
	
		//ajax로 삭제 처리
		$.ajax({
			url			: "comment_delete.do",
			data		: {"cmt_idx" : cmt_idx},
			dataType	: "json",
			success		: function(result_data){
				
				if(result_data.result=='fail'){
					alert("삭제실패");
					return;
				}
				comment_list(1);
			},
			error		: function(err){
				alert(err.responseText);
			}
		});
	}
</script>



</head>
<body>
<!-- pageMenu -->
<c:if test="${not empty list }">
	   ${ pageMenu }
	   <hr>
</c:if>
   


   <!-- for(CommentVo vo: list) -->
   <c:forEach var="vo"  items="${ list }">
      
      <div>
           <span style="display: inline-block; width:80%; color: gray; font-size: 12px;">
	           ${ vo.mem_id }(${ vo.mem_name })&nbsp;&nbsp;
	           ${ fn:substring(vo.cmt_regdate,0,16) }
           </span>
           
           <!-- 본인이 작성한 댓글만 삭제 -->
           <c:if test="${ user.mem_idx eq vo.mem_idx }">
	           <span style="display: inline-block; width:15%; text-align: right; color: gray; font-size: 12px;">
	               <input type="button" value="x" onclick="comment_delete('${ vo.cmt_idx }');">
	           </span>
           </c:if>
           
      </div>
      <div style="color:black; font-size: 15px;">
         ${ vo.cmt_content }
      </div>
      <hr>
   </c:forEach>
</body>
</html>