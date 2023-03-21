<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function delete_out(idx){
		
		
		if(confirm('출고 "취소" 하시겠습니까?')==false) return;
		
		location.href = "delete_out.do?idx="+idx;
		
		
		
	}



</script>

</head>
<body>

<table>
	<caption>::::출고목록::::</caption>
	<tr>
		<th width="30%">제품명</th>
		<th width="15%">수량</th>
		<th width="45%">출고일자</th>
	</tr>
	
	<c:if test="${ empty map.out_list }">
		<td colspan="3" align="center">
		   출고목록이 없습니다
		</td>
	</c:if>
	
	<c:forEach var="vo" items="${ map.out_list }">
		<tr>
			<td>${ vo.name }</td>
			<td>${ vo.cnt }</td>
			<td>
				${ fn:substring(vo.regdate,0,10) }
				<input type="button" value="X" onclick="delete_out('${vo.idx}');">
			</td>
		</tr>
	</c:forEach>
	
</table>


</body>
</html>