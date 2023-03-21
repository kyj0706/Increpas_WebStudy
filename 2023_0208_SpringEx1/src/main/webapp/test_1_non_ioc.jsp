<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1. Overload 생성자 이용 (누가 만든거 ? 내가 만든거지)
	PersonVo p1 = new PersonVo("일길동",10,"010-1111-1111");

	//2. 기본생성자 + get/set을 통해서
	PersonVo p2 = new PersonVo();
	p2.setName("이길동");
	p2.setAge(20);
	p2.setTel("010-2222-2222");
	
	
	
	
	
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	Non_ioc방식
<hr>
<h3>p1's info</h3>
이런 도트 방식을 써도 되고<br>
이름 : ${p1.name }<br>
나이 : ${p1.age }<br>

브라켓 방식을 써도 된다.<br>
전화 : ${p1['tel']}<br>

<hr>
<h3>p2's info</h3>
이런 도트 방식을 써도 되고<br>
이름 : ${p2.name }<br>
나이 : ${p2.age }<br>

브라켓 방식을 써도 된다.<br>
전화 : ${p2['tel']}<br>



</body>
</html>