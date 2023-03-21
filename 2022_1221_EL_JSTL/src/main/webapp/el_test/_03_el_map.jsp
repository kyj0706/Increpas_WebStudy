<%@page import="java.util.Properties"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%
	Map map = new HashMap();
	//			key     value
	map.put("driver", "oracle.jdbc.driver.OravleDriver");
	map.put("url"	, "jdbc:oralce:thin:@localhost:1521:xe");
	map.put("user"	, "scott");
	map.put("pwd"	, "tiger");
	
	
	Properties prop = new Properties();
	prop.put("driver", "oracle.jdbc.driver.OravleDriver");
	prop.put("url"	, "jdbc:oralce:thin:@localhost:1521:xe");
	prop.put("user"	, "scott");
	prop.put("pwd"	, "tiger");
	
	
	
	
	
	//EL로 표현하려면 -> Scope영역에 넣어야 한다.
	//					 Scope내에는 자바의 모든 객체를 저장할 수 있다.
	//						   K     V
	pageContext.setAttribute("map", map);
	pageContext.setAttribute("prop", prop);

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	<h5>Oracle Database Connection Option(MAP)</h5>
<hr>

<!-- .(dot) 표기법 -->
Driver 	 : ${ pageScope.map.driver }<br>
URL	   	 : ${ map.url }<br>

<!-- square braket 표가법 :[] -->
User   	 : ${ map["user"] }<br>
Password : ${ map["pwd"] }<br>

<hr>
	<h5>Oracle Database Connection Option(MAP)</h5>
<hr>
	<c:forEach var="entry" items="${prop }">
		${entry.key} ㄴㄴ<br>
	
	
	</c:forEach>



</body>
</html>