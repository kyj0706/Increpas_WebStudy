<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	<h3>부서별 사원목록</h3>
<hr>

<ul>
	<c:forEach var="dept" items="${ dept_list }">
		<li>${dept.deptno } : ${dept.dname }</li>
		<ul>
			<c:forEach var="sawon" items="${dept.sa_list }" varStatus="stat">
				<li>${sawon.sabun } : ${sawon.saname }</li>
				<ul>
					<c:forEach var="gogek" items="${sawon.go_list }">
						<li>${gogek.goname }</li>
					</c:forEach>
				</ul>
			</c:forEach>		
		
		</ul>
			
	</c:forEach>

</ul>



</body>
</html>