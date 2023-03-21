<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap 3.x 사용설정 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
#box {
	width: 1000px;
	margin: auto;
	margin-top: 20px;
}

#title {
	text-align: center;
	font-size: 28px; /* px(가변) vs pt(고정) */
	font-weight: bold;
	color: #6688cc;
	text-shadow: 1px 1px 3px black;
}
</style>

<script type="text/javascript">
	function del(mem_idx) {

		//삭제확인(confirm)
		if (confirm("정말 삭제하시겠습니까?") == false)
			return;

		//삭제요청
		location.href = "delete.do?mem_idx=" + mem_idx;

	}
</script>




</head>
<body>
	<div id="box">
		<h1 id="title">::::회원목록::::</h1>

		<!-- 로그인 메뉴 -->
		<div>
			<!-- 로그인이 안되었을경우 -->
			<c:if test="${ empty sessionScope.user }">
				<input class="btn btn-primary" type="button" value="로그인"
					onclick="location.href='login_form.do'">
			</c:if>

			<!-- 로그인이 되었을경우 -->
			<c:if test="${ not empty sessionScope.user }">
				<b>${ user.mem_name }</b>님 환영합니다
                <input class="btn btn-primary" type="button"
					value="로그아웃" onclick="location.href='logout.do'">
				<input class="btn" type="button" value="포토리스트" onclick="location.href='../photo/list.do'">
			</c:if>
			

		</div>


		<div style="text-align: right; margin-top: 5px; margin-bottom: 5px;">
			<input class="btn btn-primary" type="button" value="회원가입"
				onclick="location.href='insert_form.do'">
		</div>


		<table class="table">
			<!-- table header -->
			<tr class="info">
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>등급</th>
				<th>가입일자</th>
				<th>편집</th>
			</tr>

			<!--회원목록이 비어있는경우 -->
			<c:if test="${ empty list }">
				<tr>
					<td colspan="9" align="center"><font color="red">가입된 회원정보가 없습니다</font></td>
				</tr>
			</c:if>

			<!-- 회원목록 출력 -->
			<!--  for(MemberVo vo : list){}  -->
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${ vo.mem_idx }</td>
					<td>${ vo.mem_name }</td>
					<td>${ vo.mem_id }</td>
					<td>${ vo.mem_pwd_hide }</td>
					<td>${ vo.mem_zipcode }</td>
					<td>${ vo.mem_address }</td>
					<td>${ vo.mem_grade }</td>
					<td>${ fn:substring(vo.mem_regdate,0,10) }</td>
					<td>
						<!-- 편집메뉴의 활성화는 관리자 또는 본인 --> 
						<c:if test="${ (user.mem_grade eq '관리자') or (user.mem_id eq vo.mem_id)  }">
							<input class="btn btn-info" type="button" value="수정" onclick="location.href='modify_form.do?mem_idx=${ vo.mem_idx }'">

							<c:if test="${user.mem_grade eq '관리자' }">
      							<input class="btn btn-danger" type="button" value="삭제"  onclick="del('${vo.mem_idx}')">
      						</c:if>
      						<c:if test="${user.mem_grade eq '일반' }">
      							<input class="btn btn-danger" type="button" value="탈퇴"  onclick="del('${vo.mem_idx}')">
      						</c:if>
						</c:if>
					</td>
				</tr>
			</c:forEach>



		</table>

	</div>
</body>
</html>










