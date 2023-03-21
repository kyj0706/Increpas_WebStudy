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
			<caption>:::사원정보:::</caption>
			<tr class="success">
				<th>NO</th>
				<th>사번</th>
				<th>이름</th>
				<th>성별</th>
				<th>부서번호</th>
				<th>직급</th>
				<th>입사일</th>
				<th>상사</th>
				<th>연봉</th>
			</tr>
			
			<c:forEach var="vo" items="${list }" varStatus="i">
			<tr>
				<td>${i.count }번</td>				
				<td>${vo.sabun }</td>				
				<td>${vo.saname }</td>				
				<td>${vo.sasex }</td>				
				<td>${vo.deptno }</td>				
				<td>${vo.sajob }</td>				
				<td>${fn:substring(vo.sahire,0,10) }</td>				
				<c:if test="${vo.samgr eq 0}">
					<td>상사없음</td>
				</c:if>				
				<c:if test="${vo.samgr ne 0}">
					<td>${vo.samgr}</td>
				</c:if> 
			<%-- 	<c:if test="${vo.samgr eq vo.sabun }">
					<td>${vo.saname}</td>
				</c:if> --%>
				
				<td>
				<fmt:setLocale value="ko_kr"/>
				연봉 :
				<fmt:formatNumber type="currency" value="${vo.sapay*10000 }"/>원
				<hr>
				월급 : 
				<fmt:formatNumber type="currency" value="${(vo.sapay*10000)/12 }"/>원
				</td>				
			</tr>
			</c:forEach>
			
		</table>
	
	</div>

</body>
</html>