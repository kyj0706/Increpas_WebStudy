<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html>
	<html lang="ko" class="no-js">
	<head>
		<!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Favicon-->
		<link rel="shortcut icon" href="img/fav.png">
		<!-- Author Meta -->
		<meta name="author" content="colorlib">
		<!-- Meta Description -->
		<meta name="description" content="">
		<!-- Meta Keyword -->
		<meta name="keywords" content="">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>Noriter</title>
		
		<style type="text/css">
		.finfo_img{
			height: 285px;
			border-radius: 5px;
		}
</style>
		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
			<!--
			CSS
			============================================= -->
			<link rel="stylesheet" href="css/linearicons.css">
			<link rel="stylesheet" href="css/font-awesome.min.css">
			<link rel="stylesheet" href="css/bootstrap.css">
			<link rel="stylesheet" href="css/magnific-popup.css">
			<link rel="stylesheet" href="css/jquery-ui.css">				
			<link rel="stylesheet" href="css/nice-select.css">							
			<link rel="stylesheet" href="css/animate.min.css">
			<link rel="stylesheet" href="css/owl.carousel.css">				
			<link rel="stylesheet" href="css/main.css">
			<script type="text/javascript">
			function cancelReservation(){
				if(confirm("예약을 취소하시겠습니까?") == true){
					$.ajax({
			             url: "/cancelReservaiton",
			             type: "post",
			             data:{
			             	"reser_no":${map.rVo.reser_no}
			             	},
			             success: function(data){
			             	location.href = "payment?reser_no="+data;
			             },
			             error: function(){
			                alert("삭제 실패");
			             }
			         }); 
					
				}
			}
			function reservationList(){
				if(${session_member == 'member'}){
				location.href = "member_reserve";
					
				}else if(${session_member == 'seller'}){
					location.href = "fac_reserve";
				}
			}
			function reservationView(){
				location.href = "booking?finfo_no=${map.rVo.finfo_no}"
			}
			</script>
			<style type="text/css">
				.cancel_outline{
					display: inline-block;
					width: 955px;
				}
				.cancel_div{
					text-align: center;
				}
				#cancel_btn{
					display: inline-block;
					float: right;
				}
				.refund_span{
					color: #f10e11;
					font-weight: bold;
				}
				
			</style>
		</head>
		<body>
		<c:if test="${session_member != 'seller' }">
			<!-- 상단 바 헤더 부분 시작 -->
			<jsp:include page="../include/mainHeader.jsp"></jsp:include>
			<!-- 상단 바 헤더 부분 끝 -->
		</c:if>	
			  
			<!-- 메인 사진 부분 시작 -->
			<section class="about-banner relative">
				<div class="overlay overlay-bg"></div>
				<div class="container">				
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								예약 정보				
							</h1>	
							<p class="text-white link-nav">Your Reservation is Complete!</p>
						</div>	
					</div>
				</div>
			</section>
			<!-- 메인 사진 부분 끝 -->	

			<!-- 예약 확인페이지 시작 -->
			<section class="insurence-one-area section-gap">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-lg-6 insurence-left">
							<h6 class="text-uppercase">★ Check your reserved</h6>
							<h1>${map.mVo.m_name }님의 예약정보</h1>
							<img class="finfo_img" src="/finfo/${map.img_name }" alt="">
						</div>
						<div class="col-lg-6 insurence-right">
							<div class="list-wrap">
								<ul>
									<div class="single-sidebar-widget post-category-widget">
										<ul class="cat-list">
											<li>
												<a  class="d-flex justify-content-between">
													<p>예약번호</p>
													<p>${map.rVo.reser_no }</p>
												</a>
											</li>
											<li>
												<a class="d-flex justify-content-between">
													<p>시설명</p>
													<p>${map.rVo.finfo_name }</p>
												</a>
											</li>
											<li>
												<a class="d-flex justify-content-between">
													<p>이용일자</p>
													<p>${map.rVo.reser_date }</p>
												</a>
											</li>
											<li>
												<a class="d-flex justify-content-between">
													<p>이용시간</p>
													<p>${map.rVo.reser_time }</p>
												</a>
											</li>
											<li>
												<a class="d-flex justify-content-between">
													<p>결제 금액</p>
													<p>${map.rVo.finfo_price }원</p>
												</a>
											</li>
											<li>
												<a class="d-flex justify-content-between">
													<p>예약상태</p>
													<c:if test="${map.rVo.reser_status == '0' }"><p><span class = "reser_status">예약 완료</span></p></c:if>
													<c:if test="${map.rVo.reser_status == '1' }"><p><span class = "reser_status">예약 취소</span></p></c:if>
												</a>
											</li>															
										</ul>
									</div>
								</ul>
							</div>
						</div>
						
					</div>
				</div>
				<div class = "info_box">
					<div class = "info_outline">
						<div class = "info_title_box">
							<h2>이용자 정보</h2>
						</div>
						<div class = "info_table">
							<table >
							<colgroup width="20%">
							<colgroup width="80%">
								<tr>
									<td class = "info_td">이용자 명</td>
									<td class = "info_text_td">${map.mVo.m_name }</td>
								</tr>
								<tr>
									<td class = "info_td">연락처</td>
									<td class = "info_text_td">${map.mVo.m_phone }</td>
								</tr>
								<tr>
									<td class = "info_td">이메일</td>
									<td class = "info_text_td">${map.mVo.m_email }</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div class = "info_box">
					<div class = "info_outline">
						<div class = "info_title_box">
							<h2>결제정보</h2>
						</div>
						<div class = "info_table">
							<table >
							<colgroup width="20%">
							<colgroup width="80%">
								<tr>
									<td class = "info_td">결제 상태</td>
									<c:if test="${map.pVo.pay_status == '0' }">
									<td class = "info_text_td">완료</td>
									</c:if>
									<c:if test="${map.pVo.pay_status == '1' }">
									<td class = "info_text_td"><span class = "refund_span">취소</span></td>
									</c:if>
								</tr>
								<tr>
									<td class = "info_td">결제일</td>
									<td class = "info_text_td">${map.pVo.pay_date }</td>
								</tr>
								<tr>
									<td class = "info_td">결제 금액</td>
									<td class = "info_text_td">${map.pVo.pay_price }원</td>
								</tr>
								<c:if test="${map.pVo.pay_status == '1' }">
									<tr>
										<td class = "info_td">환불일</td>
										<td class = "info_text_td">${map.refundVo.refund_date }</td>
									</tr>
									<tr>
										<td class = "info_td">환불 금액</td>
										<td class = "info_text_td"><span class = "refund_span">-${map.refundVo.refund_price }원</span></td>
									</tr>
								</c:if>
							</table>
						</div>
					</div>
				</div>
			
				<div class="cancel_div">
							<div class="cancel_outline" style="text-align: left;">
								<div id = "cancel_btn">
									<c:if test="${(session_id == map.mVo.m_id) && (map.pVo.pay_status != '1') }">
										<button class="genric-btn primary"onclick = "cancelReservation()">예약취소 및 환불</button>
									</c:if>
										<button class="genric-btn primary"onclick = "reservationList()">예약목록</button>
										<button class="genric-btn primary"onclick = "reservationView()">해당시설예약페이지</button>
								</div>
							</div>
						</div>
			</section>
			<!-- 예약 확인페이지 끝 -->

			<!-- 풋터 시작 -->		
			<footer class="footer-area section-gap">
				<div class="container">
					<div class="row footer-bottom d-flex justify-content-between align-items-center">
						<p class="col-lg-8 col-sm-12 footer-text m-0">
							Copyright &copy;<script>document.write(new Date().getFullYear());</script> 놀이터 | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by 
							<a href="https://colorlib.com" target="_blank">Colorlib</a></p>
					</div>
				</div>
			</footer>
			<!-- 풋터 끝 -->	

			<script src="js/vendor/jquery-2.2.4.min.js"></script>
			<script src="js/popper.min.js"></script>
			<script src="js/vendor/bootstrap.min.js"></script>			
			<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>		
 			<script src="js/jquery-ui.js"></script>					
  			<script src="js/easing.min.js"></script>			
			<script src="js/hoverIntent.js"></script>
			<script src="js/superfish.min.js"></script>	
			<script src="js/jquery.ajaxchimp.min.js"></script>
			<script src="js/jquery.magnific-popup.min.js"></script>						
			<script src="js/jquery.nice-select.min.js"></script>					
			<script src="js/owl.carousel.min.js"></script>							
			<script src="js/mail-script.js"></script>	
			<script src="js/main.js"></script>	
		</body>
	</html>