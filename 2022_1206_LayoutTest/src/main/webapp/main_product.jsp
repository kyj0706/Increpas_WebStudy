<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="./css/main.css">
<link rel="stylesheet"  href="./css/main_menu.css">
<link rel="stylesheet"  href="./css/sub_menu.css">

</head>
<body>
 <div id="main_box">
     <div id="header">
     	<%@ include file="header/header.jsp" %>
     </div> 
     <div id="aside">
     	<%@ include file="menu/submenu_product.jsp" %>
     
     </div> 
     <div id="content">
     	<c:if test="${ (empty param.menu) || (param.menu == 'java') }">
     		<%@ include file="content/product/java.jsp" %>
     	</c:if>
     	<c:if test="${param.menu == 'oracle' }">
     		<%@ include file="content/product/oracle.jsp" %>
     	</c:if>
     	<c:if test="${param.menu == 'html' }">
     		<%@ include file="content/product/html.jsp" %>
     	</c:if>
     	
     </div> 
     
     <div id="footer">
     	<%@ include file="footer/footer.jsp" %>
     
     </div> 
  </div>
</body>
</html>