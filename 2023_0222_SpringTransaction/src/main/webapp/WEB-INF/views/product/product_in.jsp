<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- x버튼 삭제 -->
<script type="text/javascript">
	
	function delete_in(idx){
		
		
		if(confirm('입고 "취소" 하시겠습니까?')==false) return;
		
		location.href = "delete_in.do?idx="+idx;
		
		
		
	}

</script>

<!-- 체크박스 삭제 -->
<script type="text/javascript">
	
	function delete_ck(idx){
		
		var checked_count = $("input:checkbox[name='in_name']")
		consol.log(checked_count);
	}
	

</script>



<!-- 체크박스 선택  -->
<script type="text/javascript">
$(document).ready(function() {
	$("#checkAll").click(function() {
		if($("#checkAll").is(":checked")) $("input[name=in_name]").prop("checked", true);
		else $("input[name=in_name]").prop("checked", false);
	});

	$("input[name=in_name]").click(function() {
		var total = $("input[name=in_name]").length;
		var checked = $("input[name=in_name]:checked").length;

		if(total != checked) $("#checkAll").prop("checked", false);
		else $("#checkAll").prop("checked", true); 
	});
	
});

</script>



</head>
<body>
<input type="button"onclick="delect_ck('');">

<table>
	<caption>::::입고목록::::</caption>
	<tr>
		<th width="30%">
			<input type="checkbox" id="checkAll">
			제품명
		</th>
		<th width="15%">수량</th>
		<th width="45%">입고일자</th>
	</tr>
	
	<c:if test="${ empty map.in_list }">
		<td colspan="3" align="center">
		   입고목록이 없습니다
		</td>
	</c:if>
	
	<c:forEach var="vo" items="${ map.in_list }">
		<tr>
			<td>
				<input type="checkbox" name="in_name" value="${vo.name }">
				${ vo.name }
			</td>
			<td>${ vo.cnt }</td>
			<td>
				${ fn:substring(vo.regdate,0,10) }
				<input type="button" value="X" onclick="delete_in('${vo.idx}');">
			</td>
		</tr>
	</c:forEach>
	
</table>


</body>
</html>