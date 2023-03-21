<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		width: 600px;
		border: 1px solid black;
		
	}

</style> 
</head>
<body>
	
	<c:forEach var="vo" items="${list }">
		<div>
			${vo.content }		
		</div>
	</c:forEach>


</body>
</html>