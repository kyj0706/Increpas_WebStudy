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
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
			<script type="text/javascript">
				$(function(){
					//지역선택
					$("#searchArea").val("전체").prop("selected",true);
					$.ajax({
			             url: "/searchSportList",
			             type: "post",
			             data:{
			             	"searchArea":$("#searchArea").val()
			             	},
			             success: function(data){
			            	 var html = '';
			            	 html += '<option value="종목">종목('+data.sportNo+'개)</option>'
			            	 for(var i=0; i<data.sportNo; i++){
			            	 	html += '<option value="'+data.sportList[i]+'">'+data.sportList[i]+'</option>'
			            		 
			            	 }
										$("#event").html(html);
			             },
			             error: function(){
			                alert("삭제 실패");
			             }
			         }); 
					//지역 change 이벤트
					$("#searchArea").change(function(){
						$.ajax({
				             url: "/searchSportList",
				             type: "post",
				             data:{
				             	"searchArea":$("#searchArea").val()
				             	},
				             success: function(data){
			            	 if($("#searchArea").val() == "선택" ){
												var html = '';
												html += '<option value="선택">선택</option>'							
												$("#event").html(html);
												$("#selectGround").html(html);
											}else if($("#selectGround").val() != "선택" || $("#selectGround").val() == "선택" ){
												var html = '';
												html += '<option value="선택">선택</option>'							
												$("#selectGround").html(html);
												
											}
				            	 var html = '';
				            	 html += '<option value="종목" selected = "selected">종목('+data.sportNo+'개)</option>'
				            	 for(var i=0; i<data.sportNo; i++){
				            	 	html += '<option value="'+data.sportList[i]+'">'+data.sportList[i]+'</option>'
				            		 
				            	 }
											$("#event").html(html);
				             },
				             error: function(){
				                alert("삭제 실패");
				             }
				         }); 
						/* if($("#searchArea").val() == "선택" ){
							alert("select"+$("#searchArea").val());
							var html = '';
							html += '<option value="선택">선택</option>'							
							$("#event").html(html);
							$("#selectGround").html(html);
						}else if($("#selectGround").val() != "선택"  ){
							alert("ground"+$("#selectGround").val())
							var html = '';
							html += '<option value="선택">선택</option>'							
							$("#selectGround").html(html);
							
						}else{
							alert("test");
						} */
					});
					//event change
				$("#event").change(function(){
					if($("#event").val() == "종목" || $("#event").val()== "선택"){
						var html = '';
						html += '<option value="선택">선택</option>'							
						$("#selectGround").html(html);
						
					}else{
						$.ajax({
				             url: "/searchFinfoName",
				             type: "post",
				             data:{
				             	"searchArea":$("#searchArea").val(),
				             	"sportCategory":$("#event").val()
				             	},
				             success: function(data){
				            	 var html = '';
				            	 html += '<option value="선택">선택('+data.finfoNo+'개)</option>'
				            	 for(var i=0; i<data.finfoNo; i++){
				            	 	html += '<option value="'+data.finfoList[i].finfo_no+'">'+data.finfoList[i].finfo_name+'</option>'
				            		 
				            	 }
				            	 $("#selectGround").html(html);
				             },
				             error: function(){
				                alert("삭제 실패");
				             }
				         }); 
						
					}
				});
					
			});
				function moveBooking(){
					if($("#searchArea").val() == "선택"){
						alert("지역을 선택해 주세요");
						return false;
					}else if($("#event").val() == "종목"){
						alert("종목을 선택해 주세요");
						return false;
					}else if($("#selectGround").val() == "선택"){
						alert("경기장을 선택해 주세요");
						return false;
					}
					location.href = "booking?finfo_no="+$("#selectGround").val();
				}
				function moveMyReser(){
					location.href = "member_reserve";
				}
				$(function(){
					
					var date = new Date();
					var month = date.getMonth() +1;
					
					var day= (new Date()).getDate();

					var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();
					var useDay = "";
					if(month >10){
						useDay = month +"-" + day +"~" + month +"-" + lastDay;
					}else{
						useDay = "0"+month+"-"+day+"~"+"0"+month+"-"+lastDay;
					}
					$(".use_day").text(useDay);
				});
			</script>
<style type="text/css">
.event_status {
	background-color: skyblue;
	border-radius: 10px;
	padding: 5px;
	font-size: 15px;
	color: white;
	font-weight: bold;
}
.price-btn{
background: #81BEF7;
    color: #222;
    font-weight: 600;
    padding: 5px 20px;
}
.eb_content_p{
	margin-top:15px;
}
</style>
		</head>
		<body>	
			<!-- 상단 바 헤더 부분 시작 -->
			<jsp:include page="../include/mainHeader.jsp"></jsp:include>			
			<!-- 상단 바 헤더 부분 끝 -->
			
			<!-- 메인 사진 부분 시작 -->
			<section class="banner-area relative">
				<div class="overlay overlay-bg"></div>				
				<div class="container">
					<div class="row fullscreen align-items-center justify-content-between">
						<div class="col-lg-6 col-md-6 banner-left">
							<!-- <h6 class="text-white">Away from monotonous life</h6> -->
							<h2 class="text-white">운동인과 함께하는 노리 한마당:)</h2>
							<p class="text-white">
								Make a Reservation Now!
							</p>
							<div class="area">
								<select id = "searchArea">
									<option value="선택">선택</option>
									<option value="전체">전체</option>
									<option value="서울">서울</option>
									<option value="경기">경기</option>
									<option value="인천">인천</option>
								</select>
								<select id = "event">
									
								</select>
								<select id = "selectGround">
									
								</select>
							<a onclick = "moveBooking()" class="primary-btn text-uppercase">예약하기</a>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- 메인 사진 부분 시작 -->

			<!-- 최근 시설 페이지 시작 -->
			<section class="recent-blog-area section-gap">
				<div class="container">
					<div class="row d-flex justify-content-center">
						<div class="menu-content pb-60 col-lg-9">
							<div class="title text-center">
								<h1 class="mb-10">최근에 등록된 시설들!</h1>
								<p>New Area!!!</p>
							</div>
						</div>
					</div>							
					<div class="row">
						<div class="active-recent-blog-carusel">
						<c:forEach items="${map.finfoList }" var = "finfoVo">
							<div class="single-recent-blog-post item">
								<div class="thumb">
									<img class="thumb_img" src="finfo/${finfoVo.finfo_pic1 }" alt="">
								</div>
								<div class="details">
									<h4 class="d-flex justify-content-between">
										<span>${finfoVo.finfo_name }</span>                              	
									</h4>
									<p>
									</p>
									<ul class="package-list">
										<li class="d-flex justify-content-between align-items-center">
											<span>장소명</span>
											<span>${finfoVo.finfo_add1 }</span>
										</li>
										<li class="d-flex justify-content-between align-items-center">
											<span>이용대상</span>
											<span>제한없음</span>
										</li>
										<li class="d-flex justify-content-between align-items-center">
											<span>접수기간</span>
											<span class = "use_day"></span>
										</li>
										<li class="d-flex justify-content-between align-items-center">
											<span>이용기간</span>
											<span class = "use_day"></span>
										</li>
										<li class="d-flex justify-content-between align-items-center">
											<span>접수가능</span>
											<a href="booking?finfo_no=${finfoVo.finfo_no }" class="price-btn">상세보기</a>
										</li>													
									</ul>
								</div>
							</div>
						</c:forEach>
																	

						</div>
					</div>
				</div>	
			</section>
			<!-- 이벤트 페이지 시작 -->
			<section class="recent-blog-area section-gap">
				<div class="container">
					<div class="row d-flex justify-content-center">
						<div class="menu-content pb-60 col-lg-9">
							<div class="title text-center">
								<h1 class="mb-10">현재 진행중인 이벤트!</h1>
								<p>The event that's going on right now!!!</p>
							</div>
						</div>
					</div>							
					<div class="row">
						<div class="active-recent-blog-carusel">
						<c:forEach items="${map.eventList }" var = "eventVo">
							<div class="single-recent-blog-post item">
								<div class="thumb">
									<img class="thumb_img" src="event/${eventVo.img_name }" alt="">
								</div>
								<div class="details">
									<div class="tags">
									</div>
									<a href="eventBoardView?eb_num=${eventVo.eb_num }"><h4 class="title">${eventVo.eb_title }</h4>
										<span class = "event_status">이벤트 진행중</span>
									</a>
									<p class = "eb_content_p">
										${eventVo.eb_content }
									</p>
									<h6 class="date">이벤트 기간 [${eventVo.eb_start_date }~${eventVo.eb_end_date }]</h6>
								</div>	
							</div>
						</c:forEach>
																	

						</div>
					</div>
				</div>	
			</section>
			<!-- 이벤트 페이지 끝 -->	
					
			<!-- 체육시설 서비스 안내 시작 -->
			<section class="price-area section-gap">
				<div class="container">
		            <div class="row d-flex justify-content-center">
		                <div class="menu-content pb-70 col-lg-8">
		                    <div class="title text-center">
		                        <h1 class="mb-10">체육시설 서비스 안내</h1>
		                        <p>Service Announcement!!</p>
		                    </div>
		                </div>
		            </div>						
					<div class="row">
						<div class="col-lg-4-1">
							<div class="single-price">
								<h4>공지사항</h4>
								<ul class="price-list">
									<c:forEach items="${map.noticeList }" var = "noticeVo">
										<li class="d-flex justify-content-between align-items-center">
											<span><a href = "noticeBoardView?n_num=${noticeVo.n_num }">${noticeVo.n_title }</a></span>
											<span>${noticeVo.n_date }</span>
										</li>
									</c:forEach>	
								
																
								</ul>
							</div>
						</div>
						<div class="col-lg-4-1" id = "book_list" onclick = "moveMyReser()">
							<div class="single-price">
								<h4>나의 예약내역</h4>
								<h3></h3>
								<ul class="price-list">
									<li class="d-flex justify-content-between align-items-center">
										<span>예약을 신청하셨나요?? <br>편리하게 예약내역을 확인해보세요,,</span>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- 서비스 안내 끝 -->	
			
			<!-- 광고 시작 -->
		    <section>
		        <div class="container">
		            <div class="row">
		                <div class="active-testimonial">
		                    <div class="single-testimonial item d-flex flex-row">
	                           <img class="img-fluid-1" src="img/ad/001.png" alt="">
		                    </div>
		                    <div class="single-testimonial item d-flex flex-row">
	                           <img class="img-fluid-1" src="img/ad/002.png" alt="">
		                    </div>
		                </div>
		            </div>
		        </div>
		    </section>
		    <!-- 광고 끝 -->
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