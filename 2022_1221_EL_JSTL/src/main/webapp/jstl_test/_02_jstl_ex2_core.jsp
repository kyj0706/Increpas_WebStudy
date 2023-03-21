<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL을 시용하려면 -->    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>        
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
	foEach + if
</h3>


	<!-- 		 변수	 시작	  끝      증감					 -->
	<c:forEach var="i" begin="1" end="5" step="1">
		
		<c:if test="${ (i%2) == 1 }">
			<font color="red">	${ pageScope.i} : 안녕</font><br>	
		</c:if>
		<c:if test="${ (i%2) == 0 }">
			<font color="blue">	${ pageScope.i} : 안녕</font><br>
		</c:if>
	</c:forEach>
<hr>
<h3>
	foEach + choose
</h3>
	<!-- 		 변수	 시작	  끝      증감					 -->
	<c:forEach var="i" begin="1" end="5" step="1">
		<c:choose>
			<c:when test="${ i%2 ==0 }">
			<font color="red">	${ pageScope.i} : 안녕</font><br>
			</c:when>
			<c:when test="${ i%2 ==1 }">
			<font color="blue">	${ pageScope.i} : 안녕</font><br>
			</c:when>
			
		</c:choose>	
	</c:forEach>


</body>
</html>