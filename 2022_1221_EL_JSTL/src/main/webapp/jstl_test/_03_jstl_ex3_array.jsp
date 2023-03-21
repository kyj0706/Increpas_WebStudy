<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
	//배열
	String [] sido_array = { "서울","경기","인천","강원","대전","충남","부산","대구" };
	
	//ArrayList
	List fruit_list = new ArrayList();
	
	fruit_list.add("사과");
	fruit_list.add("참외");
	fruit_list.add("수박");
	fruit_list.add("딸기");
	fruit_list.add("포도");
	fruit_list.add("오란지");
	fruit_list.add("메론");
	

	pageContext.setAttribute("sido_array", sido_array);
	
	pageContext.setAttribute("fruit_list", fruit_list);
	
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	시도 목록
<hr>
	<ul>
		<!-- varStatus는 객체 변수이다. -->
		<c:forEach var="sido" items="${ sido_array }" varStatus="i"> 
		<li>${i.index} : ${i.index+1} : ${i.count} : ${sido }</li>
		</c:forEach>
	</ul>
	

<!--                ↓처럼 띄어쓰면 안된다.  -->	
<!-- EL은 items=" ${ pageScope.sido_array }"  -->
<%-- 
	<ul>
		<c:forEach var="sido" items=" ${ pageScope.sido_array }">
			<li>${ sido }</li>
		</c:forEach>
	</ul> --%>

<hr>
	과일 목록
<hr>
	<ul>	
		<c:forEach var="fruit" items="${ fruit_list }">
		<li>${fruit}</li>
		</c:forEach>
	</ul>
	



</body>
</html>