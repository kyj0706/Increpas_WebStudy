<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>

<!-- Bootstrap 3.x 사용설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	#box {
		width: 800px;
		margin: auto;
		margin-top: 20px;
	}
	
	#subject,#regdate_ip{
	
	   padding: 3px;
	   border: 1px solid gray;
	   margin: 5px;
	   
	   box-shadow: 1px 1px 1px black;
	   
	}
	
	#content{
	
	   padding: 3px;
	   border: 1px solid gray;
	   margin: 5px;
	   min-height: 150px;
	   box-shadow: 1px 1px 1px black;
	}

</style>

<!-- 삭제 -->
<script type="text/javascript">
	
	function del(b_idx){
		
		if(confirm("정말 삭제하시겠습니다?")==false) return;
		
		location.href = "delete.do?b_idx=" + b_idx +"&page=${param.page}&search=${param.search}&search_text="
		 + encodeURIComponent('${ param.search_text }');	  
		
		
	}


</script>

<!-- 답글 -->
<script type="text/javascript">
	
	function reply_form(b_idx){
		
		if("${ empty user}" == "true"){
			
			if(confirm("답글쓰기는 로그인후 가능합니다 \n 로그인 하시겠습니까?")==false) return;
			
			location.href ="../member/login_form.do?url=" + encodeURIComponent(location.href);
			
			
			return;
		}
		
		//답글폼 띄우기
		
		location.href = "reply_form.do?b_idx=" + b_idx+"&page=${param.page}";
		
		
	}
	
	
</script>

<!-- 수정폼 230303_강ver이면 없어도 된다. -->
<!-- 
<script type="text/javascript">

	function update_form(b_idx){
		
		
		
		location.href = "update_form.do?b_idx="+ b_idx;
	}

</script> 
-->


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="box">
		로그인 : ${user.mem_name }
		<div class="panel panel-primary">
			<div class="panel-heading">
			   <h4>[${ vo.mem_name }]님이 작성하신 글</h4>
			</div>
			<div class="panel-body">
			    <div id="subject">제목 : ${ vo.b_subject }</div>
                <div id="content">
                    ${ vo.b_content }
                </div>			
                <div id="regdate_ip">
                    작성일자:${ vo.b_regdate } (${ vo.b_ip })
                </div>
                
                <div style="margin: 5px;">
                    <input class="btn btn-primary"  type="button" value="목록보기" 
                           onclick="location.href='list.do?page=${param.page}&search=${param.search }&search_text=${param.search_text }'">
                           
                <!-- 메인글일경우만 나오게 -->
               		<c:if test="${vo.b_depth eq 0 }">
                    	<input class="btn btn-success"  type="button" value="답글쓰기" onclick="reply_form('${vo.b_idx}');">
                    </c:if>
                    
                    <!-- 로그인유저 == 글쓴이 -->
                    <c:if test="${ user.mem_idx eq vo.mem_idx }">
	                   <%--  <input class="btn btn-info"     type="button" value="수정하기" onclick="update_form('${vo.b_idx}');"> --%>
	                   <!-- 20230303_강ver -->
	                    <input class="btn btn-info"     type="button" value="수정하기" onclick="location.href='update_form.do?b_idx=${vo.b_idx}&page=${param.page }&search=${param.search }&search_text=${param.search_text }'">
	                    <input class="btn btn-danger"   type="button" value="삭제하기" onclick="del('${vo.b_idx}');">
                    </c:if>
                    
                </div>
			</div>
		</div><!-- panel_end -->
		<!-- 댓글정보 출력 -->
		
		<%@include file="comment_input.jsp" %>
		
		
	</div><!-- box_end -->
</body>
</html>