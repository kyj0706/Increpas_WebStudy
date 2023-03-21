<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	 table {
    width: 400px;
    border: 1px solid black;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid black;
  }
  
  td {
	text-align: center;
	
}
	
</style>

</head>
<body>
<form action="jumin.do"  method="get">
	<table>
		<tr>
			<th>이름</th>
			<td >${map.name }</td>
		</tr>
		<tr>
			<th>주민번호</th>
			<td>${map.jumin_no }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${map.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${map['pwd'] }</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${map.gender }</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>${map.hobby_list}</td>
		</tr>
		<tr>
			<th>친구</th>
			<td>${map.friend_list }</td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td>${map.blood }</td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td>${map.profile }</td>
		</tr>
		<tr>
			<th>결과</th>
			<td>
			<a href="javascript:history.back()"><button type="button" name="jumin_no">뒤로가기</button></a>
			<button name="jumin_no" value="${map.jumin_no }">정보상세보기</button>
			</td>
			
		</tr>
		
		
	</table>
	
	</form>




</body>
</html>