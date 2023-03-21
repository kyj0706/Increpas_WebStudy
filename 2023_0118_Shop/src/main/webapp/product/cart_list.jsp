<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- 수정 -->
<script type="text/javascript">

	function cart_modify(c_idx) {
		
		var c_cnt = document.getElementById("c_cnt_"+c_idx).value;
		console.log(c_cnt,c_idx);
		
		//수정 Action호출
		location.href ="cart_update.do?c_idx=" +c_idx +"&c_cnt=" +c_cnt;
		
	}



</script>
<!-- 삭제 -->
<script type="text/javascript">
	function cart_del(c_idx) {
		if(confirm("진짜 삭제 할거야 ?")==false) return;
		
		//삭제 Action호출
		location.href="cart_del.do?c_idx="+c_idx;
	}

</script>
<script type="text/javascript">

function delete_all(f){
	  
	  //선택된 갯수가 0이면 선택하라고 알림메시지 띄운다
	  // input:checkbox -> <input type="checkbox">
	  var checked_count = $("input:checkbox[name='c_idx']:checked").length;
	 
	  //alert(checked_count);
	  if(checked_count==0){
		  alert("삭제할 상품목록를 체크하세요!!");
		  return;
	  }
	  
	  if(confirm("정말 삭제하시겠습니까?")==false)return;
	  	  
	  
	  f.action = "cart_delete_all.do"; //CartDeleteAllAction
	  f.submit();
}

</script>

<!-- 체크박스 선택  -->
<script type="text/javascript">
$(document).ready(function() {
	$("#checkAll").click(function() {
		if($("#checkAll").is(":checked")) $("input[name=c_idx]").prop("checked", true);
		else $("input[name=c_idx]").prop("checked", false);
	});

	$("input[name=c_idx]").click(function() {
		var total = $("input[name=c_idx]").length;
		var checked = $("input[name=c_idx]:checked").length;

		if(total != checked) $("#checkAll").prop("checked", false);
		else $("#checkAll").prop("checked", true); 
	});
	
});

</script>

</head>
<%-- <jsp:include page="index.jsp"/> --%>
<%@include file="index.jsp"  %>
<body>
<form>
	<div style="width: 600px; margin:auto; ">
		<input type="checkbox" id="checkAll">전체선택
		<input type="button" value="삭제" onclick="delete_all(this.form);">
		<input type="button" value="결제">
	</div>

	<table align="center" width="600" border="1"
 style="border-collapse:collapse;font-size:8pt"
 bordercolor="navy" cellpadding="4" cellspacing="0">
		<tr>
			<td colspan="6">:: 장바구니 내용</td>
		</tr>
		<tr bgcolor="#dedede">
			<th>제품번호</th>
			<th width="25%">제품명</th>
			<th>단가</th>
			<th>수량</th>
			<th>금액</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var="c_vo" items="${list }">
		<tr align="center">
			<td>
			<input type="checkbox" name="c_idx" value="${c_vo.c_idx }">
			${c_vo.p_num }</td>
			<td>${c_vo.p_name }</td>
			<td>
				단가:<fmt:formatNumber value="${c_vo.p_price }"/>원 <br>
				<font color="red">
				세일가격:<b><fmt:formatNumber value="${c_vo.p_saleprice }"/>원</b>
				</font>
			</td>
			<td>
				<!-- 수량 조정 폼 -->
				<input id="c_cnt_${c_vo.c_idx }"  size="4"  align="center" value="${c_vo.c_cnt }">
				<input type="button" value="수정" onclick="cart_modify('${c_vo.c_idx}');">
			</td>
			<td><fmt:formatNumber value="${c_vo.amount }"/>원</td>
			<td>
				<input type="button" value="삭제" style="border:1 solid black;cursor:hand" 
				onclick="cart_del('${c_vo.c_idx}');">
			</td>
		</tr>
		</c:forEach>
		
		<c:if test="${empty list }">
		<tr>
			<td colspan="6" align="center">
				<b>장바구니가 비었습니다.</b>
			</td>
		</tr>
		</c:if>
		
		<tr>
			<td colspan="5" align="right">
				총 결재액 :
			</td>
			<td><fmt:formatNumber value="${total_amount }"/>원</td>
		</tr>
	</table>
</form>
</body>
</html>






