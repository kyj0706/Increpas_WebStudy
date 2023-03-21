<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	//선언부 
	//전역변수
	int count = 0; // 단 1회 실행 
%>  


  
<%
	//Scriptlet
	//_Service() call 요청시 마다
	
	count++;

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= count %>번째 방문하셨습니다.

</body>
</html>