<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div id="header_div">
			<div id="header_img">
				<c:if test="${session_member == 'member' }">
				<h1 style="font-size: 50px; margin-left: 100px; padding: 30px;"><a href="main"><img src="img/logo.png" alt="" title="" /></a></h1>
				</c:if>
				<c:if test="${session_member == 'admin' }">
				<h1 style="font-size: 50px; margin-left: 100px; padding: 30px;"><a href="admin_main"><img src="img/logo.png" alt="" title="" /></a></h1>
				</c:if>
				<c:if test="${session_member == 'seller' }">
				<h1 style="font-size: 50px; margin-left: 100px; padding: 30px;"><a href="main"><img src="img/logo.png" alt="" title="" /></a></h1>
			</c:if>
			</div>
		</div>
