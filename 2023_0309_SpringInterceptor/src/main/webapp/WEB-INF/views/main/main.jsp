<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	//초기화 함수
	window.onload = function(){
		
		setTimeout(showMessage,100);
		
		
	};

	function showMessage(){
		
		if("${param.reason eq 'not_login'}" == "true"){
			alert("로그인이 필요합니다.");
		}
		
		if("${param.reason eq 'not_admin'}" == "true"){
			alert("관리자가 아닙니다..");
		}
		
		if("${param.reason eq 'not_adult'}" == "true"){
			alert("어린애는 가라..");
		}
		
	};
	
</script>

</head>
<body>
	<hr>
	<!-- 로그인이 안된경우 -->
	<c:if test="${empty user }">
		<input type="button" value="일반로그인" onclick="location.href='login.do'">
		<input type="button" value="므후로그인" onclick="location.href='login_adult.do'">
		<input type="button" value="관리로그인" onclick="location.href='login_admin.do'">
	</c:if>
	<!-- 로그인이 된경우 -->
	<c:if test="${not empty user }">
		${user.name }님 환영합니다.(${user.grade })(나이:${user.age })
		<input type="button" value="로그아웃" onclick="location.href='logout.do'">
	</c:if>

<hr>

<a href="../admin/main.do">관리자페이지</a>
<a href="../adult/main.do">므후후</a>

</body>
</html>