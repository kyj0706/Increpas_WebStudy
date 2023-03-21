<%@page import="vo.PersonVo"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Spring Container 정보를 얻어온다.
	//JSP의 내장객체 : ServletContext application
	WebApplicationContext wc = WebApplicationContextUtils.getRequiredWebApplicationContext(application); 

	//Spring Container에 저장된 bean정보 얻어온다.
	//방법1
	PersonVo p1 = (PersonVo)wc.getBean("p1");
	
	//방법2
	PersonVo p2 = wc.getBean("p2",PersonVo.class); //이러한 방법이 있따는 걸 알려주는 것이지 하지는 말아라
	
	//p3 ?
	PersonVo p3 = (PersonVo)wc.getBean("p3");
	
	PersonVo p4 = (PersonVo)wc.getBean("p4");
	
	String name;
	name = (String)wc.getBean("nameBean");
	
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
	pageContext.setAttribute("p3", p3);
	pageContext.setAttribute("p4", p4);
	pageContext.setAttribute("name", name);
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	ioc방식
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

<hr>
<h3>p3's info</h3>
이런 도트 방식을 써도 되고<br>
이름 : ${p3.name }<br>
나이 : ${p3.age }<br>

브라켓 방식을 써도 된다.<br>
전화 : ${p3['tel']}<br>

<hr>
<h3>p4's info</h3>
이런 도트 방식을 써도 되고<br>
이름 : ${p4.name }<br>
나이 : ${p4.age }<br>

브라켓 방식을 써도 된다.<br>
전화 : ${p4['tel']}<br>

<hr>
<h3>name's info</h3>
이름 : ${name }


</body>
</html>