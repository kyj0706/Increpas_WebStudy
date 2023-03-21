<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
   과목 리스트
<hr>
 <ul>
    <c:forEach var="book" items="${ list }">
        <li>${ book }</li> 
    </c:forEach>
 </ul>


</body>
</html>