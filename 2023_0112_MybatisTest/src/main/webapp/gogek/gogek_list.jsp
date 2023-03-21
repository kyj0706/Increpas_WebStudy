<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x 사용설명 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">

	#table_box{
		width: 800px;
		margin: auto;
		margin-top: 50px;
	 }
	 
	 caption {
		text-align: center;
		font-size: 30px;
		font-weight: bold;
	}
	th,td{
	 	text-align: center;
	}
	
	.table>tbody>tr>td {
		vertical-align:middle;
	
	}
</style>

</head>
<body>
	<div id="table_box">
		<table class="table table-striped table-bordered table-hover">
			<caption>:::고객정보:::</caption>
			<tr class="success">
				<th>고객번호</th>
				<th>이름</th>
				<th>지역</th>
				<th>주민번호</th>
				<th>담당자</th>
			</tr>
			
			<c:forEach var="vo" items="${list }" varStatus="i">
			<tr>
				<td>${vo.gobun }</td>				
				<td>${vo.goname }</td>				
				<td>${vo.goaddr }</td>				
				<td>${vo.gojumin }</td>				
				<td>${vo.godam }</td>				
			</tr>
			</c:forEach>
			
		</table>
	
	</div>

</body>
</html>