<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<table>
		<tr>
			<th>순번</th>
			<th>이름</th>
			<th>닉네임</th>
			<th>나이</th>
			<th>폰번호</th>
			<th>집번호</th>
		</tr>
		
		<c:forEach var="p" items="${p_list}" varStatus="vst">
		<tr>
			<td>${vst.count}</td>
			<td>${p.name }</td>
			<td>${p.nickname }</td>
			<td>${p.age }</td>
			<td>${p.tel }</td>
			<td>${p.hometel }</td>
		</tr>
		</c:forEach>
	
	</table>



</body>
</html>