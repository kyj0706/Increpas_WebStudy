<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

function comment_delete(c_cmt_idx){
  
	if(confirm("정말 삭제하시겠습니까?")==false)return; //삭제확인
    //Ajax통해서 삭제수행
   	//  /boaord/comment_delete.do?cmt_idx=1
	$.ajax({
		url      : "comment_delete.do",
		data     : { 
					 "c_cmt_idx"       : c_cmt_idx
				   },
		dataType : "json",		  
		success  : function(result_data){
			if(result_data.result=='fail'){
				alert('댓글삭제 실패');
				return;
			}
			c_comment_list(1);
		},
		error	 : function(err){
			       alert(err.responseText);
		}
	});  
}
</script>

<link rel="stylesheet" 
      href="${ pageContext.request.contextPath }/resources/css/c_board.css">
<body>
   <!-- for(CommentVo vo: list) -->
   <c:forEach var="vo"  items="${ list }">
      <div id="comment">
           <span style="display: inline-block; width:80%; color: gray; font-size: 12px;">
	           ${ vo.c_mem_id }(${ vo.c_mem_name })&nbsp;&nbsp;
	           ${ fn:substring(vo.c_cmt_regdate,0,16) }
           </span>
           
           <!-- 본인이 작성한 댓글만 삭제 -->
           <c:if test="${ user.c_mem_idx eq vo.c_mem_idx }">
	           <span style="display: inline-block; width:15%; text-align: right; color: gray; font-size: 12px;">
	               <input type="button" value="x" onclick="comment_delete('${ vo.c_cmt_idx }');">
	           </span>
           </c:if>
           
      
      <div>${ vo.c_cmt_content }</div>
      </div>  
      <br>
      <hr>
   </c:forEach>
</body>
</html>