<%@page import="util.MyProp"%>
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
    MyProp myProp= wc.getBean("myPropBean",MyProp.class);
    //Map map = myMap.getMap();
    
    
    pageContext.setAttribute("myProp", myProp);
%>

<hr>
   <h3>prop목록</h3>
<hr>    
	<ul>
	   <!-- for(String su : set) -->
	   <c:forEach var="prop"  items="${ myProp.prop  }">
	      <li>${ prop.key } -> ${prop.value } 입니다.</li>
	   </c:forEach>
	</ul>







    
    
