<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <jsp:include page="index.jsp"/> --%>
<%@include file="index.jsp"  %>

<table align="center" width="600" border="1"
 style="border-collapse:collapse;font-size:8pt"
 bordercolor="navy" cellpadding="4" cellspacing="0">
	<tr bgcolor="#dedede">
		<th width="10%">제품번호</th>
		<th width="10%">이미지</th>
		<th width="35%">제품명</th>
		<th width="20%">제품가격</th>
		<th width="25%">비고</th>
	</tr>
	<!-- 등록생 된상품이 없는경우 -->
	<c:if test="${ empty list  }">
	<tr>
		<td colspan="5" align="center">
			<font color="red">상품이 없습니다.</font>
		</td>
	</tr>
	</c:if>
	
	<c:forEach var="pvo" items="${list }">
	<tr align="center">
		<td>${pvo.p_num }</td>
		<td><img src="../images/${pvo.p_image_s }" 
			width="100" height="90"></td>
		<td>
		  <a href="view.do?p_idx=${pvo.p_idx }">${pvo.p_name }</a>
		</td>
		<td>
			할인가:<fmt:formatNumber value="${pvo.p_saleprice }"/>원<br>
			<font color="red">
				(DC ${pvo.discount_rate }%)
			</font>
		</td>
		<td>
			단가:<fmt:formatNumber value="${pvo.p_price }"/>원
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>









