<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x 사용설명 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	#box{
		width: 1000px;
		margin: auto;
		margin-top: 20px;
	}
	
	#title{
		text-align: center;
		font-size: 28px;
		color: white;
		font-weight: bold;
		text-shadow: 3px 3px 5px black;
	}
	th, td{
		text-align: center;
	}
	
	.table>tbody>tr>td {
		vertical-align:middle;
	
	}

</style>

<script type="text/javascript">
function del(idx){
	 //alert("삭제할 idx : " + idx);
	 
	 //삭제확인
	 if(confirm("정말 삭제하시겠습니까?")==false) return;
	 
	 location.href="delete.do?idx=" + idx; //SungDeleteAction
	 
	 
 }




</script>
</head>
<body>
<div id="box">
	<h1 id="title">::::성적관리::::</h1>
	<hr>
	<div> <input type="text" placeholder="검색 내용 입력"> </div>
	<div><input class="btn btn-primary" type="button" 
				style="margin-bottom:10px; float: right;" 
				value="등록하기" onclick="location.href='insert_form.do'">
	</div>
	<div>
		<table class="table table-striped table-bordered table-hover">
			<tr class="info">
				<th>번호</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>등수</th>
				<th>편집</th>
			</tr>
			
			<!-- data -->
			<!-- 데이터가 없을경우 -->
			<c:if test="${ empty list }">
			<tr>
				<td colspan="9">
					<font color="red">데이터가 없습니다.</font>
				</td>
			</tr>
			
			<!-- 데이터가 있을경우 -->
			</c:if>
			<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.idx }</td>
				<td>${vo.name }</td>
				<td>${vo.kor }</td>
				<td>${vo.eng }</td>
				<td>${vo.mat }</td>
				<td>${vo.tot }</td>
				<td>${vo.avg }</td>
				<td>${vo.rank }</td>
				<td>
					<input class="btn  btn-info" type="button"  value="수정" onclick="location.href='modify_form.do?idx=${vo.idx}'" >
					<input class="btn btn-danger" type="button" value="삭제" onclick="del('${vo.idx }');">
				</td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
</div>

</body>
</html>