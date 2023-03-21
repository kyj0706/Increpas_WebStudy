<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script><link rel="stylesheet" 
      href="${ pageContext.request.contextPath }/resources/css/c_board.css">
<script type="text/javascript">
	function del(c_b_idx) {
		if(confirm("정말 삭제하시겠습니까?")==false)return;
		location.href="delete.do?c_b_idx=" + c_b_idx + "&page=${ param.page }";
	}
	function reply_form(c_b_idx) {
		if("${empty user}" == "true"){
			if(confirm("답글은 로그인 후 가능합니다.\n 로그인 하시겠습니까?")==false)return;
			location.href="../c_member/login_form.do?url=" + encodeURIComponent(location.href);
			return;
		}
		location.href = "reply_form.do?c_b_idx=" + c_b_idx + "&page=${ param.page }";
	}
	function modify(c_b_idx) {
		if(confirm("정말 수정하시겠습니까?")==false)return;
		location.href = "modify_form.do?c_b_idx=" + c_b_idx + "&page=${ param.page }";
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="box">
		<div class="panel panel-primary">
			<div class="panel-heading">
			   <h4>[${ vo.c_mem_name }]님이 작성하신 글</h4>
			</div>
			<div class="panel-body">
			    <div id="subject">제목 : ${ vo.c_b_subject }</div>
                <div id="content">
                    ${ vo.c_b_content }
                </div>			
                <div id="regdate_ip">
                    작성일자:${ vo.c_b_regdate } (${ vo.c_b_ip })
                </div>
                
                <div style="margin: 5px;">
                    <input class="btn btn-primary"  type="button" value="목록보기" 
                           onclick="location.href='list.do?page=${param.page}'">
                    
					<!-- 메인글인경우만 답글허용 -->
                    <c:if test="${ vo.c_b_depth eq 0 }">
                    <input class="btn btn-success"  type="button" value="답글쓰기"
                           onclick="reply_form('${ vo.c_b_idx }');">
                    </c:if>       
                    
                    <!-- 로그인유저 == 글쓴이 -->
                    <c:if test="${ user.c_mem_idx eq vo.c_mem_idx }">
	                    <input class="btn btn-info"     type="button" value="수정하기"
	                    	 onclick="modify('${ vo.c_b_idx}');">
	                    <input class="btn btn-danger"   type="button" value="삭제하기"
	                         onclick="del('${ vo.c_b_idx}');">
                    </c:if>
                    
                </div>
			</div>	
		</div>
		<%@include file="c_comment_input.jsp" %>
	</div>
</body>
</html>