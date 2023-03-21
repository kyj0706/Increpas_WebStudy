<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<%
	List<PersonVo> p_list = new ArrayList<PersonVo>();

	p_list.add(new PersonVo("일길동",20,"010-111-1234"));
	p_list.add(new PersonVo("이길동",30,"010-222-1234"));
	p_list.add(new PersonVo("삼길동",40,"010-333-1234"));
	p_list.add(new PersonVo("사길동",50,"010-444-1234"));
	p_list.add(new PersonVo("오길동",60,"010-555-1234"));
	
	/* JSTL의 <c:forEach>를 사용 (이해)하려면 
	
		for(PersonVo p : p_list){} 개선된 for문을 안다는 전제이다.
		
	*/ 
	
	
	//JSTL + EL사용하기 위해서
	pageContext.setAttribute("p_list", p_list);
			
	
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#box{
		width: 600px;
		margin: auto;
		margin-top: 50px;
	}
	table th {
		text-align: center;
	}
	td{
		text-align: center;
	}
	
	
	
</style>

<!-- Bootstrap 3.x 사용설명 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="box">
		<table class="table">
			<!-- title -->
			<tr class="info" >
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>번호</th>
			</tr>
			<!--                   여기서의 items="${p_list } 는 
												    ↓를 사용하는거다.
						pageContext.setAttribute("p_list", p_list);
			-->
			<c:forEach var="p" items="${p_list }" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${p.name }</td>
					<td>${p.age }</td>
					<td>${p.tel }</td>
				</tr>
			</c:forEach>
		
		</table>
	
	
	
	</div>









</body>
</html>