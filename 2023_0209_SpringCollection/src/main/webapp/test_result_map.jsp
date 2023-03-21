<%@page import="java.util.Map"%>
<%@page import="util.MyMap"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
    WebApplicationContext wc 
       = WebApplicationContextUtils.getWebApplicationContext(application);
    // Spring Containter객체정보 얻어온다
    //                            bean_id     Type  
    MyMap myMap= wc.getBean("myMapBean",MyMap.class);
    Map map = myMap.getMap();
    
    
    pageContext.setAttribute("map", map);
%>

<hr>
   <h3>숫자목록</h3>
<hr>    
	<ul>
	   <!-- for(String su : set) -->
	   <c:forEach var="map"  items="${ map }">
	      <li>${ map.key } -> ${map.value } 입니다.</li>
	   </c:forEach>
	</ul>







    
    
