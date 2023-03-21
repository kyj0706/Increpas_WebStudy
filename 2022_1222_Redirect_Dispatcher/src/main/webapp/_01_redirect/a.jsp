<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("a.jsp로 왔었다");
	//클라이언트에게 b.jsp로 재요청 하라고 응답!
	response.sendRedirect("b.jsp");



%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	a.jsp다 !!!! 난 안나올꺼야 ~ 
</body>
</html>