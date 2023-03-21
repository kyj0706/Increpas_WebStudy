<%@page import="java.util.List"%>
<%@page import="util.MyList"%>
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
    MyList myList = wc.getBean("myListBean",MyList.class);
    List list     = myList.getList();
    
    //pageContext.setAttribute("myList", myList);
    pageContext.setAttribute("list", list);
%>

<hr>
   <h3>과일목록</h3>
<hr>    
	<ul>
	   <!-- for(String fruit : list) -->
	   <c:forEach var="fruit"  items="${ list }">
	      <li>${ fruit }</li>
	   </c:forEach>
	</ul>







    
    
