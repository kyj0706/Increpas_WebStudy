<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	#table_box{
		width: 600px;
		margin: auto;
		margin-top: 50px;
	
	}
	
	#input_box {
		width: 600px;
		margin: auto;
		margin-top: 50px;
	}
	input[type="text"] {
		text-align: center;
	
	}

</style>



</head>
<body>
<div id="input_box">
	이름입력 ▶<input id="s_where" name="s_where" placeholder="검색할 이름을 입력하세요">
				<input type="button" id="one_search" name="one_search" value="검색">
				<input type="button" id="all_search" name="all_search" value="전체보기">
	<hr>
		<input type="button" value="수정">
		<input type="button" value="추가">
		<input type="button" value="삭제">
	<hr>
</div>
<div id="table_box">
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th>NO</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등수</th>
		</tr>
		<tr>
			<td>순번</td>
			<td>감자냐</td>
			<td>1000</td>
			<td>20</td>
			<td>40</td>
			<td>1060</td>
			<td>700</td>
			<td>1</td>
		</tr>
		
	</table>


</div>





</body>
</html>