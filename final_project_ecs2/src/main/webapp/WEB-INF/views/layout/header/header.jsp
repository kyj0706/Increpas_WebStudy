<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>일론머스크</title>
<!-- style css -->
<link rel="stylesheet" href="../resources/css/style.css">
<!-- Bootstrap 3.x 사용설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>
<body>
 <!-- banner bg main start -->
	<div class="main_back">
		<!-- header top section start -->


		<!-- logo section start -->
		<div class="logo_section">
			<div class="logo">
				<ul>
					<li>
						
						<h1 style="font-weight: bold; text-align: center;">
						<img src="../resources/images/logo.jpg" style="width: 100px; height: 100px;'" >
						
						전기자동차 충전소
						<img src="../resources/images/ev_car.jpg" style="width: 100px; height: 100px;'" >
						</h1>
					</li>
				</ul>
				
				 <br>
				<div class="login_menu">
					<ul>
						<!-- 로그인전 보여질것 -->
						<c:if test="${empty user }">
						<li>
							<a href="../c_member/login_form.do"> 
								 <span class="padding_10">Login</span>
							</a>
						</li>
						
						<li>
							<a href="../c_member/insert_form.do"> 
								 <span class="padding_10">회원가입</span>
							</a>
						</li>
						</c:if>
					
						<!-- 로그인 후 보여질것 -->
						<c:if test="${ not empty user }">
						<li>
			            	<span> ${ user.c_mem_name }님 환영합니다</span>
			            	<input type="button"  value="로그아웃" 
			                     onclick="location.href='../c_member/logout.do'">
						</li>
						<li>
							<a href="#"> 
								<span class="padding_10">마이페이지</span><br>
							</a>
						</li>
						</c:if> 
						
						<!-- 관리자만 -->
						<c:if test="${empty user eq 'admin' }">
						<li>
							<a href="../admin/list.do"> 
								<span class="padding_10">관리자페이지</span><br>
							</a>
						</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>