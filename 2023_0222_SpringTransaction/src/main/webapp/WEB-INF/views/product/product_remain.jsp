<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<caption>::::재고목록::::</caption>
	<tr>
		<th width="40%">제품명</th>
		<th width="20%">수량</th>
		<th width="40%">재고일자</th>
	</tr>
	
	<c:if test="${ empty map.remain_list }">
		<td colspan="3" align="center">
		   재고목록이 없습니다
		</td>
	</c:if>
	
	<c:forEach var="vo" items="${ map.remain_list }">
		<tr>
			<td>${ vo.name }</td>
			<td>${ vo.cnt }</td>
			<td>${ fn:substring(vo.regdate,0,10) }</td>
		</tr>
	</c:forEach>
	
</table>


</body>
</html>