<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x 사용설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#box{
		width: 1200px;
		margin:auto;
		margin-top: 100px;
		padding:100px;
		border: 1px solid black;
		box-shadow: 0px 0px 20px black;
		border: none;
	}
	.table>tbody>tr>td {
		vertical-align:middle;
	
	}
	
	th,td{
		text-align: center;
	}
	
	
	#title{
		text-align: center;
		font-size: 50px;
		color: white;
		font-weight: bold;
		text-shadow: 3px 3px 5px black;
	
	}
</style>
</head>
<body>
	<!-- 로그인 메뉴 -->
	<div id="box">
		<h1 id="title">회원목록(test)</h1>
		<div style="text-align: right; margin-top: 5px; margin-bottom: 5px;">
			<div style="text-align: right; margin-bottom: 5px;">
				<!-- 로그인이 안되었을 경우 -->
				<c:if test="${empty sessionScope.user }">
					<input class="btn btn-defulat" type="button" value="로그인" onclick="location.href='login_form.do'">
				</c:if>
				<!-- 로그인이 되었을경우  -->
				<c:if test="${not empty sessionScope.user }">
					관리자 : <b> ${user.user_name }</b>
					<input class="btn btn-warning" type="button" value="로그아웃" onclick="location.href='logout.do'">
				</c:if>
			</div>
		</div>
		<table class="table">
			<!-- table header -->
			<tr class="active">
				<th>회원번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이메일</th>
				<th>주소1</th>
				<th>주소2</th>
				<th>우편번호</th>
				<th>등급</th>
				<th>가입일자</th>
				<th>수정일자</th>
				<th>편집</th>
			</tr>
			<!--회원목록이 비어있는경우 -->
			<c:if test="${ empty list }">
				<tr>
					<td colspan="9" align="center"><font color="red">가입된 회원정보가 없습니다</font></td>
				</tr>
			</c:if>
			<!-- 회원목록 출력 -->
			<!--  for(UserVo vo : list){}  -->
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${ vo.user_idx }</td>
					<td>${ vo.user_name }</td>
					<td>${ vo.user_id }</td>
					<td>${ vo.user_pw }</td>
					<td>${ vo.user_email }</td>
					<td>${ vo.user_address1 }</td>
					<td>${ vo.user_address2 }</td>
					<td>${ vo.user_post }</td>
					<td>${ vo.user_grade }</td>
					<td>${ fn:substring(vo.user_regdate,0,10) }</td>
					<td>${ fn:substring(vo.user_modifydate,0,10) }</td>
					<td>
						<!-- 편집메뉴의 활성화는 관리자 또는 본인 --> 
						<c:if test="${user.user_grade eq '관리'}">
							<input class="btn btn-info" type="button" value="수정" onclick="location.href='modify_form.do?user_idx=${ vo.user_idx }'">
							<input class="btn btn-danger" type="button" value="삭제" onclick="del('${ vo.user_idx }');">
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>