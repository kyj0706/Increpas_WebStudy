<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<!-- 회원아이디 찾기 -->
        <c:if test="${find_check == 'success' }">
        <script type="text/javascript">
        	alert("일치하는 정보가 있습니다")
        	alert("${find_nick }"+"님의 아이디는 [ "+"${find_id}"+" ] 입니다")
        	location.href="login"
        </script>
        </c:if>
        <c:if test="${find_check == 'fail' }">
		<script type="text/javascript">
        	alert("일치하는 정보가 없습니다")
        	location.href="Find"
		</script>
        </c:if>

		<!-- 회원 비밀번호 찾기 -->
        <c:if test="${find_check_pw == 'success' }">
        <script type="text/javascript">
        	alert("일치하는 정보가 있습니다")
        	alert("${find_nick }"+"님의 비밀번호는 [ "+"${find_pw}"+" ] 입니다")
        	location.href="login"
        </script>
        </c:if>
        <c:if test="${find_check_pw == 'fail' }">
		<script type="text/javascript">
        	alert("일치하는 정보가 없습니다")
        	location.href="Find_PW"
		</script>
        </c:if>

</body>
</html>