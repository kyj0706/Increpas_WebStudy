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
						
						<a href="../main/list.do" style="font-size: 60px; color: white;"> 전기자동차 충전소 </a>
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
								 <span class="padding_10" style="color: black; font-size: 18px; font-weight: bold;">Login</span>
							</a>
						</li>
						
						<li>
							<a href="../c_member/insert_form.do"> 
								 <span class="padding_10" style="color: black; font-size: 18px; font-weight: bold;">회원가입</span>
							</a>
						</li>
						</c:if>
					
						<!-- 로그인 후 보여질것 -->
						<c:if test="${ not empty user }">
						<li>
			            	<span style="color: black; font-size: 18px; font-weight: bold;">등급: [${user.c_mem_grade }] => ${ user.c_mem_name }님 환영합니다</span>
			            	<span style="color: black; font-size: 18px; font-weight: bold;"><input type="button"  value="로그아웃" 
			                     onclick="location.href='../c_member/logout.do'"></span>
						</li>
						</c:if> 
						
						<!-- 일반회원만  -->
						<c:if test="${user.c_mem_grade eq '일반' }">
						<li>
							<a href="#"> 
								<span class="padding_10" style="color: black; font-size: 18px; font-weight: bold;">마이페이지</span>
							</a>
						</li>
						</c:if>
						
						<!-- 관리자만 -->
						<c:if test="${(user.c_mem_grade eq '관리자') or (user.c_mem_id eq 'admin') }">
						<li>
							<a href="../admin/list.do"> 
								<span class="padding_10" style="color: black; font-size: 18px; font-weight: bold;">관리자페이지</span>
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