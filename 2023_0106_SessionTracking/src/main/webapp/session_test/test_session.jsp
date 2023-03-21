<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//발급된 세션ID 얻어오기
	String session_id = session.getId();
	System.out.println(session_id);
	
	HttpSession session2 = request.getSession();
	String session_id2 = session.getId();
	System.out.println(session_id2);
	
	//세션 시간 얻어오기
	session.setMaxInactiveInterval(30);
	System.out.println("----------여기가지가 session이다----------");
	

	
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>