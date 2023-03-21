<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 
	1.EL내에 표현할 수 있는 변수(객체)
		1) 각 Scope에 저장된 변수(객체) 
			크기순서 
			작다===============================================크다
			(pageScope, requestScope, sessionScope, applicationScope)
		2) parameter변수/header/쿠키....

 -->    
 
 <%
 	/* 
 		JSP내장객체 (Servlet형태가 숨겨져 있는 걸 사용하는것 )
 		PageContext 			pageContext:
 		HttpServletRequest		request:
 		HttpSession				session:
 		ServletContext			application:
 	
 	
 	*/
 	
 	//						 key   value
 	pageContext.setAttribute("msg", "pageContext내의 값" );
 	request.setAttribute	("msg", "request내의 값" );
 	session.setAttribute	("msg", "session내의 값");
 	application.setAttribute("msg", "application내의 값");
 
 
 
 %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 사용방법 --%>
<%-- ${ 영역이름.변수명 } --%>
pageContext : ${ pageScope.msg }<br>
request 	: ${ requestScope.msg }<br>
session		: ${ sessionScope.msg }<br>
application : ${ applicationScope.msg }<br>

<%-- EL Scope영역을 생략하면 아래 순서대로 참조 
	pageScope -> requestScope -> sessionScope -> applicationScope
--%>
이번에는 뭐가 출력 될까 ????? : ${ msg } <br>







</body>
</html>