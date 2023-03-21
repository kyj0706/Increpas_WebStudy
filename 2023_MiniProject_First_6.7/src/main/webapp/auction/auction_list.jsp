<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>사혼의 구슬조각</title>
<!-- bootstrap -->
<link rel="stylesheet" type="text/css" href="../css/product/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/product/style.css">
<!-- 리스트 슬라이더 -->
<script src="../js/product/bootstrap.bundle.min.js"></script>
<!-- font awesome,화살표 -->
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../js/product/jquery.min.js"></script>
<!-- 폰트 -->
<link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext" rel="stylesheet">
<link rel="stylesheet" href="../css/product/owl.carousel.min.css">
<link rel="stylesoeet" href="../css/product/owl.theme.default.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@800&display=swap" rel="stylesheet">
<script type="text/javascript" src="../js/product/timer.js"></script>
<script type="text/javascript" src="../js/product/timer2.js"></script>
</head>
<body>
	<!-- banner bg main start -->
	<div class="banner_bg_main2">
		<!-- logo section start -->
		<div class="logo_section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="logo">
							<a href="index.html"> <b>----Bring It----</b> <br>세상의 모든 Bring It
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container1">
			<div class="header_section_top">
				<div class="row">
					<div class="col-sm-12">
						<div class="custom_menu">
							<ul>
								<li><a href="#">인덱스1</a></li>
								<li><a href="#">인덱스2</a></li>
								<li><a href="#">인덱스3</a></li>
								<li><a href="#">인덱스4</a></li>
								<li><a href="#">인덱스5</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- logo section end -->
		<!-- header section start -->
		<div class="header_section">
			<div class="container">
				<div class="containt_main">
					<div id="mySidenav" class="sidenav">
						<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a> <a href="index.jsp">Home</a> <a href="fashion.jsp">Fashion</a> <a href="electronic.jsp">Electronic</a> <a href="jewellery.jsp">Jewellery</a>
					</div>
					<span class="toggle_icon" onclick="openNav()"><img src="../images/toggle-icon.png"></span>
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">All Category</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
						</div>
					</div>
					<div class="main">
						<!-- Another variation with a button -->
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search this blog">
							<div class="input-group-append">
								<button class="btn btn-secondary" type="button" style="background-color: #f26522; border-color: #f26522">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
					</div>
					<div class="header_box">
						<div class="login_menu">
							<ul>
								<li><a href="#"> <i class="fa fa-shopping-cart" aria-hidden="true"></i> <span class="padding_10">Cart</span></a></li>
								<li><a href="#"> <i class="fa fa-user" aria-hidden="true"></i> <span class="padding_10">Login</span></a></li>
								<li><a href="#"> <i class="fa fa-tags" aria-hidden="true"></i> <span class="padding_10">경매 등록</span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- header section end -->
		<!-- banner section start -->
		<div class="banner_section layout_padding">
			<div class="container">
				<div id="my_slider" class="carousel slide" data-ride="carousel">
					<div class="containt_main">
						<!-- 이미지 미리보기 -->
						<!-- 큰 메인 이미지 -->
						<div id="detail_l_table" class="detail_big_img">
							<img id="img1" class="detail_l_img" src="../images/bc235ee11461d2c05bfd17b5a60105f18e5223b3.png">
						</div>
						<!-- 제품 상세정보 -->
						<div>
							<table border="1" class="banner_taital2" id="detail_table">
								<tr>
									<td colspan="2">
										<!-- 남은 시간 --> <a id="countdown"></a> <span id="_second"><br></span>
									</td>
								</tr>
								<tr>
									<td width="50%">경매입찰횟수</td>
									<td width="50%">진행낙찰여부</td>
								</tr>
								<tr>
									<td width="50%">auction_times</td>
									<td width="50%">auction_status</td>
								</tr>
								<tr>
									<td width="50%">시작 입찰가</td>
									<td width="50%">최고 등록가</td>
								</tr>
								<tr>
									<td width="50%">auction_startprice</td>
									<td width="50%">auction_high</td>
								</tr>
								<tr>
									<td colspan="2">구매 희망가</td>
								</tr>
								<tr>
									<td colspan="2"><input type="number" class="form-control" placeholder="시작 입찰가부터 천원 단위로 입력하세요"></td>
								</tr>
								<tr>
									<td width="30%">상품일련번호</td>
									<td width="70%">product_idx</td>
								</tr>
								<tr>
									<td width="30%">경매일련번호</td>
									<td width="70%">auction_idx</td>
								</tr>
							</table>
							<table border="1" class="banner_taital3" id="detail_table2">
							</table>
							<div id="start_btn">
								<a href="auction_progress.jsp"><input class="btn btn-success" type="button" value="구매입찰 계속"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- copyright section start -->
	<footer>
		<div class="copyright_section">
			<div class="container2">
				<div class="footer4"></div>
				<div class="footer1">
					㈜ 인크레파스 사업자등록번호:119-86-82595본관 : 서울특별시 관악구 시흥대로 552 석천빌딩 7F<br> 개인정보책임자:이정빈 | 대표자:오경주<br> 고객센터 : 02-869-1080~1<br> 인재추천/산학협력/직업능력훈련시설(직업전문학교, 학원 관련) : 02-869-1080<br>
				</div>
				<div class="footer2">
					인크레파스는 고용노동부 지정 직업능력개발 훈련시설로서, 그리고 최고의 개발자 배움터 학원(學院)으로서, 또한 직업훈련을 하는 학교(學校)로서의 역할을 다하겠습니다.<br> - 인크레파스는 IT교육센터(IT학원)입니다. IT에 포함되는 소프트웨어 개발, 사물인터넷 서비스 & 플랫폼 개발, 빅데이터 개발 교육을 제공합니다.<br> - 프로그래밍교육센터(프로그래밍학원)입니다. 자바, JSP, 스프링 뿐만 아닌 프로그래밍 전반을 배우고 학습할 수 있습니다.<br> - 빅데이터교육센터(빅데이터학원)입니다. 빅데이터 뿐만 아니라 자바웹개발, 인공지능, 사물인터넷(IoT), 클라우딩컴퓨팅 교육을 진행합니다.<br> - 국비지원 컴퓨터교육센터(국비지원 컴퓨터학원)입니다. 컴퓨터공학 중에서도 소프트웨어공학 중심 교육을 제공합니다.<br> - 내일배움카드교육센터(내일배움카드학원)입니다. 내일배움카드를 통해 국비교육을 받을 수 있습니다.<br> - 취업성공패키지교육센터(취업성공패키지학원)입니다. 취업성공패키지를 참여하시고 국비지원 교육 받으시길 바랍니다<br> - 인크레파스는 취업교육센터(취업학원)입니다. 개발자로 취업을 꿈꾸시는 분께서는 인크레파스에서 개발자 취업성공하세요!<br>
				</div>
				<div class="footer4"></div>
			</div>
			<div class="footer3">Copyright 2018 INCREPAS reserved.</div>
		</div>
		<!-- copyright section end -->
	</footer>
	<!-- Javascript files-->
	<script src="../js/jquery.min.js"></script>
	<!-- <script src="js/popper.min.js"></script> -->
	<script src="../js/bootstrap.bundle.min.js"></script>
	<!--  <script src="js/jquery-3.0.0.min.js"></script> -->
	<!-- <script src="js/plugin.js"></script> -->
	<!-- sidebar -->
	<!-- <script src="../js/jquery.mCustomScrollbar.concat.min.js"></script> -->
	<!-- <script src="../js/custom.js"></script> -->
	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
		}
	</script>
</body>
</html>