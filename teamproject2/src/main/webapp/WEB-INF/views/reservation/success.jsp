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
<h1>${pg_token }</h1>
<h1>${reser_no }</h1>
	<script type="text/javascript">
		alert("결제가 완료 되었습니다")
		location.href="payment?reser_no=${reser_no }";
	</script>
</body>
</html>