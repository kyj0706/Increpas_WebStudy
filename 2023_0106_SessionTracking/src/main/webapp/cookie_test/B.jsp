<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키등록   		name(key)	value
	Cookie c = new Cookie("B" , "B.jsp");
	
	//Persistant cookie
	c.setMaxAge(60);
	
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


여기는  B.jsp입니다.<br>

<a href="C.jsp">C.jsp로 이동</a>
</body>
</html>