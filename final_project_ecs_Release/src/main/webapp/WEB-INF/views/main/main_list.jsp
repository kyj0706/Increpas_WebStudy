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
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<!-- 헤더 -->
<header>
	<jsp:include page="/WEB-INF/views/layout/header/header.jsp"></jsp:include>
</header>
<!-- 메뉴 -->
<nav>
	<jsp:include page="/WEB-INF/views/layout/nav/nav.jsp"></jsp:include>
</nav>

	<!-- 메인화면 -->
		<div class="banner_section">
			<div class="logo2">
				<h1>전기자동차 충전소</h1>
				<br>
				<div class="banner_box2" style="text-align: center;">
					전기자동차의 작동원리 및 구조에 대한 내용과 충전시 주의사항에 관한 내용,<br> 전기자동차의 관리 방법 및
					운행 요령에 대한 자세한 내용을 확인 하실 수 있습니다.<br>
					<br>
				</div>
				<div >
					<img src="../resources/images/model_x.jpg" >
					
				</div>
			</div>
		</div>
		<hr>
		<hr>
		  <div id="evcar_qna" style="text-align: center;">
        	<div class="evcar_qna_cont">
            	<h2 style="color:black;">전기자동차, 무엇이 궁금하세요?</h2>
                <p>전기자동차의 작동원리 및 구조에 대한 내용과  충전시 주의사항에 관한 내용, <br />
                전기자동차의 관리 방법 및 운행 요령에 대한 자세한 내용을 확인 하실 수 있습니다. </p>
                <div class="btn_area"><a href="/portal/evcar">전기자동차 원리 및 구조</a></div>
            </div>
        </div>
		<div class="banner_box2" style="text-align: center; border: 1px solid black; ">
		<h1>공지사항</h1>
			이 들어갈 예정 
		</div>
		
		
		

<!-- 푸터 -->
<footer>
	<jsp:include page="/WEB-INF/views/layout/footer/footer.jsp"></jsp:include>
</footer>

</body>
</html>