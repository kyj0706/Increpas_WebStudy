<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키등록   		name(key)	value
	Cookie c = new Cookie("A" , "A.jsp");
	response.addCookie(c);	


%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="Popup.jsp" %>


여기는  A.jsp입니다.<br>

<a href="B.jsp">B.jsp로 이동</a>
</body>
</html>