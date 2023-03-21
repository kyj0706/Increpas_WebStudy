<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	function add_cart() {
		
		//로그인 여부 확인
		if("${ empty user }"=="true"){
			
			if(confirm("장바구니 담기는 로그인 후 가능\n 로그인 할꺼야?")==false) return;
			
			//alert("현재주소" +location.href);
			
			location.href ="../member/login_form.do?url="+encodeURIComponent(location.href);
			
			return;
		}
		
		var p_idx = '${vo.p_idx}'
		var mem_idx = '${user.mem_idx}'
		
		$.ajax({
			url			:"cart_insert.do",
			data		:{"p_idx":p_idx, "mem_idx":mem_idx},
			dataType	:"json",
			success		: function(result_data){
				if(result_data.result == "exist"){
			    	alert("상품이 장바구니에 이미 담겨져있습니다");
			    	return;
			    }
			    
			    alert("장바구니에 담았습니다");
			    
				
			},
			error		: function(err){
				alert(err.responseText);
			}
			
			
			
		});
		
	}


</script>


</head>
<body>

	<%-- <jsp:include page="index.jsp"/> --%>
	<%@include file="index.jsp"%>

	<table align="center" width="600" border="1"
		style="border-collapse: collapse; font-size: 8pt" bordercolor="navy"
		cellpadding="4" cellspacing="0">
		<tr>
			<td width="40%">제품분류</td>
			<td width="60%">${vo.category }</td>
		</tr>
		<tr>
			<td width="40%">제품번호</td>
			<td width="60%">${vo.p_num }</td>
		</tr>
		<tr>
			<td width="40%">제품명</td>
			<td width="60%">${vo.p_name }</td>
		</tr>
		<tr>
			<td width="40%">제조사</td>
			<td width="60%">${vo.p_company }</td>
		</tr>
		<tr>
			<td width="40%">제품가격</td>
			<td width="60%"><fmt:formatNumber value="${vo.p_price }" />원
				(할인가:<fmt:parseNumber value="${vo. p_saleprice}" />원)</td>
		</tr>
		<tr>
			<td colspan="2">제품설명</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><img
				src="../images/${vo.p_image_l }"></td>
		</tr>
		<tr>
			<td colspan="2">${vo.p_content }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="장바구니에 담기" onclick="add_cart();" />
				<c:if test="${not empty user }">
				<input type="button" value="장바구니 보기" onclick="location.href='cart_list.do'" />
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>