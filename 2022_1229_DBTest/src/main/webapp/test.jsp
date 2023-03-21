<%@page import="service.DBService"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Connection conn = DBService.getInstance().getConnection();
	System.out.println("--success connection--");
	
	//사용후에는 반환(닫기)
	conn.close();

%>
    
    
    