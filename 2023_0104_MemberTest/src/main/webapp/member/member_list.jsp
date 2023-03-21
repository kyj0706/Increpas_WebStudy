<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<style type="text/css">
#box {
	width: 1200px;
	margin: auto;
	margin-top: 100px;
	padding: 100px;
	border: 1px solid black;
	box-shadow: 0px 0px 20px black;
	border: none;
}

.table>tbody>tr>td {
	vertical-align: middle;
}

th, td {
	text-align: center;
}

#mem_sign_up {
	margin-bottom: 5px;
}

#title {
	text-align: center;
	font-size: 50px;
	color: white;
	font-weight: bold;
	text-shadow: 3px 3px 5px black;
}
</style>
<script type="text/javascript">
function del(mem_idx){
	 //alert("삭제할 idx : " + idx);
	 
	 //삭제확인
	 //if(confirm("정말 삭제하시겠습니까?")==false) return;
	 Swal.fire({
			  title: '정말 지울꺼야 ??',
			  html: "<h4>돌이킬수 없다?</h4>",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '예스!!!삭제한다.',
			  cancelButtonText: '생각 좀 해볼께'
			}).then((result) => {
			  if (result.isConfirmed) {
	 			location.href="delete.do?mem_idx=" + mem_idx; 
			    
			  }
		});	
	 
	 
	 
	 
	 
}



</script>

</head>
<body>
	<form>
		<div id="box">

			<h2 id="title">::::회원정보::::</h2>

			<!-- 로그인 메뉴 -->
			<div style="text-align: right; margin-bottom: 5px;">
				<!-- 로그인이 안되었을 경우 -->
				<c:if test="${empty sessionScope.user }">
					<input class="btn btn-defulat" type="button" value="로그인"
						onclick="location.href='login_form.do'">
				</c:if>


				<!-- 로그인이 되었을경우  -->
				<c:if test="${not empty sessionScope.user }">
					<b>${user.mem_name }</b> 님 환영합니다.
	  		<input class="btn btn-warning" type="button" value="로그아웃"
						onclick="location.href='logout.do'">


				</c:if>



			</div>



			<c:if test="${empty user }">
				<div style="text-align: right;">
					<input class="btn btn-success" type="button" id="mem_sign_up"
						value="회원가입" onclick="location.href='insert_form.do'">
				</div>
			</c:if>

			<div class="panel">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-th-list"> 회원리스트</span>
				</div>
				<div class="panel-body">



					<table class="table table-striped table-bordered table-hover"
						border="1">
						<tr class="info">
							<th>번호</th>
							<th>이름</th>
							<th>아이디</th>
							<th>비밀번호</th>
							<th>우편번호</th>
							<th>주소</th>
							<th>회원등급</th>
							<th>가입날짜</th>
							<th>편집</th>
						</tr>
						<c:if test="${ empty list }">
							<tr>
								<td colspan="9">가입정보가 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach var="vo" items="${list }" varStatus="i">

							<tr>
								<td>${vo.mem_idx }</td>
								<td>${vo.mem_name }</td>
								<td>${vo.mem_id }</td>
								<td>${vo.mem_pwd_hide }</td>
								<td>${vo.mem_zipcode }</td>
								<td>${vo.mem_address }</td>
								<td>${vo.mem_grade }</td>
								<td>${fn:substring(vo.mem_regdate,0,10) }</td>
								<td><c:if
										test="${(user.mem_grade eq '관리자') or (user.mem_id eq vo.mem_id) }">
										<input class="btn btn-info" type="button" value="수정"
											onclick="location.href = 'modify_form.do?mem_idx=${vo.mem_idx}'">

										<c:if test="${user.mem_grade eq '관리자' }">
											<input class="btn btn-danger" type="button" value="삭제"
												onclick="del('${vo.mem_idx}')">
										</c:if>
										<c:if test="${user.mem_grade eq '일반' }">
											<input class="btn btn-danger" type="button" value="탈퇴"
												onclick="del('${vo.mem_idx}')">
										</c:if>
									</c:if></td>

							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>