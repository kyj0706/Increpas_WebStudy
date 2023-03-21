<%@page import="java.util.Set"%>
<%@page import="util.MySet"%>
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
    MySet mySet= wc.getBean("mySetBean",MySet.class);
    Set set = mySet.getSet();
    
    pageContext.setAttribute("set", set);
%>

<hr>
   <h3>숫자목록</h3>
<hr>    
	<ul>
	   <!-- for(String su : set) -->
	   <c:forEach var="su"  items="${ set }">
	      <li>${ su }</li>
	   </c:forEach>
	</ul>







    
    
