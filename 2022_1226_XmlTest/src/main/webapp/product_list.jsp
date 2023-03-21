<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	
	#box{
		width: 800px;
		margin: auto;
		margin-top: 50px;
	}
	
	#input_box{
		width: 600px;
		margin: auto;
		margin-top: 50px;
	}
	
	#num_box{
		text-align: center;
		margin: auto;
	}
	
	img{
		width: 80px;
		height: auto;
	}

	th {
	width:auto; 
	text-align: center;
}
	
</style>

<script type="text/javascript">

	window.onload = function () {
		
		//javascript
		//document.getElementById("page").value = '${(empty param.page) ? 1: param.page}'
		//document.getElementById("display").value = '${(empty param.display) ? 10: param.display}'
		
		
		//jQuery
		$("#page").val('${(empty param.page) ? 1 : param.page}'); 
		$("#diplay").val('${empty param.display ? 1: param.display}');
		
	}




	function send(f) {
		
	    var p_name = f.p_name.value.trim();
		
		if(p_name ==''){
			alert("상품을 입력하세요");
			f.p_name.value='';
			f.p_name.focus();
			return;
		}	
		
		f.action = "product_search.do";
		f.submit();
		
	}


</script>



</head>
<body>
상품목록 출력



<div id="box_all">
	<div id="input_box" class="input-group">
		<form>
			<div>
			 	<input type="text" class="form-control" name="p_name" value="${param.p_name }" placeholder="상품명 입력">
				<input type="button" class="btn btn-info" value="검색" onclick="send(this.form)">
			</div>
			<label>페이지
				<select name="page" id="page">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select>
			</label>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label>페이지당 목록수</label>
				<select name="display" id="display">
					<option value="10">10</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
			
		</form>
	</div>
	<div id="box">
	<table class="table table-striped">
		<tr class="success">
			<th>순번</th>
			<th>상품이미지</th>
			<th>상품명</th>
			<th>최저가</th>
			<th>최대가</th>
			<th>판매처</th>
		</tr>
		<c:if test="${empty list }">
			<tr>
				<td colspan="6">
					<font color="red">검색된 상품이 없습니다.</font>
				</td>
				
			</tr>
					
			
		
		
		</c:if>
		
		
		
		<c:forEach var="n" items="${list }" varStatus="i" >
		<tr>
			<td>${ start+ i.index }</td>
			<td><img src="${n.image }"></td>
			<td><a href="${n.link }">${n.title }</a></td>
			<td><fmt:formatNumber type="currency" value="${n.lprice}"/> </td>
			<td><fmt:formatNumber type="currency" value="${n.hprice }"/> </td>
			<td>${n.mallName }</td>
		
		</tr>
		</c:forEach>
	
	
	</table>
	</div>
	
	
	<!-- <div id="num_box">
		<a href="#">◀이전</a>
		<a href="#">1</a>
		<a href="#">2</a>
		<a href="#">3</a>
		<a href="#">다음▶</a>
	</div>
	 -->
	
	
</div>
</body>
</html>