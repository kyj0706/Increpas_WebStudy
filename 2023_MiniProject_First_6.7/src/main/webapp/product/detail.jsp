<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Eflyer</title>
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
<script src="../js/product/bootstrap.bundle.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="../js/product/big.js"></script>
</head>



<body>
	<!-- banner bg main start -->
	<div class="banner_bg_main2">
		<!-- header top section start -->


		<!-- logo section start -->
		<div class="logo_section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="logo">
							<a href="index.html"> <b>WoL galleria</b> <br>세상의 모든 명품.
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
						<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
						<a href="index.jsp">Home</a> <a href="fashion.jsp">Fashion</a> <a
							href="electronic.jsp">Electronic</a> <a href="jewellery.jsp">Jewellery</a>
					</div>
					<span class="toggle_icon" onclick="openNav()"><img
						src="../images/toggle-icon.png"></span>
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">All Category
						</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a> <a
								class="dropdown-item" href="#">Something else here</a>
						</div>
					</div>
					<div class="main">
						<!-- Another variation with a button -->
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search this blog">
							<div class="input-group-append">
								<button class="btn btn-secondary" type="button"
									style="background-color: #f26522; border-color: #f26522">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
					</div>
					<div class="header_box">
						<!-- <div class="lang_box ">
                     <a href="#" title="Language" class="nav-link" data-toggle="dropdown" aria-expanded="true">
                     <img src="images/flag-uk.png" alt="flag" class="mr-2 " title="United Kingdom"> English <i class="fa fa-angle-down ml-2" aria-hidden="true"></i>
                     </a>
                     <div class="dropdown-menu ">
                        <a href="#" class="dropdown-item">
                        <img src="images/flag-france.png" class="mr-2" alt="flag">
                        French
                        </a>
                     </div>
                  </div> -->
						<div class="login_menu">
							<ul>
								<li><a href="#"> <i class="fa fa-shopping-cart"
										aria-hidden="true"></i> <span class="padding_10">Cart</span></a></li>
								<li><a href="#"> <i class="fa fa-user"
										aria-hidden="true"></i> <span class="padding_10">Login</span></a>
								</li>
								<li><a href="#"> <i class="fa fa-tags"
										aria-hidden="true"></i> <span class="padding_10">경매 등록</span></a>
								</li>

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
						<div id="detail_s_table">
							<ul>
								<li><img
									src="../images/${ vo.product_image1 }"
									id="detail_s_img"></li>
								<li><img
									src="../images/${ vo.product_image2 }"
									id="detail_s_img"></li>
								<li><img
									src="../images/${ vo.product_image3 }"
									id="detail_s_img"></li>
								<li><img
									src="../images/${ vo.product_image4 }"
									id="detail_s_img"></li>
							</ul>
						</div>
						<!-- 큰 메인 이미지 -->
						<div id="detail_l_table" class="detail_big_img">
							<img id="img1" class="detail_l_img"
								src="../images/${ vo.product_image1 }">
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
									<td width="30%">제품분류</td>
									<td width="70%">${ vo.product_category }</td>
								</tr>

								<tr>
									<td width="30%">제품명</td>
									<td width="70%">${ vo.product_name }</td>
								</tr>

								<tr>
									<td width="30%">제조사</td>
									<td width="70%">${ vo.product_company }</td>
								</tr>

								<tr>
									<td width="30%">상세설명</td>
									<td width="70%" align="left">${ vo.product_content }</td>
								</tr>

								<tr>
									<td width="30%">원가</td>
									<td width="70%">${ vo.product_price }</td>
								</tr>

								<tr>
									<td width="30%">시작 입찰가</td>
									<td width="70%"></td>
								</tr>
							</table>
							<div id="start_btn">
                        <a href="auction.jsp"><input class="btn btn-success" type="button"
                           value="입찰 시작"></a>
                     </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- fashion section end -->

	<!-- 
   electronic section start
   <div class="fashion_section">
      <div id="electronic_main_slider" class="carousel slide" data-ride="carousel">
         <div class="carousel-inner">
            <div class="carousel-item active">
               <div class="container">
                  <h1 class="fashion_taital">Electronic</h1>
                  <div class="fashion_section_2">
                     <div class="row">
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Laptop</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="electronic_img"><img src="images/laptop-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Mobile</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="electronic_img"><img src="images/mobile-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Computers</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="electronic_img"><img src="images/computer-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div class="carousel-item">
               <div class="container">
                  <h1 class="fashion_taital">Electronic</h1>
                  <div class="fashion_section_2">
                     <div class="row">
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Laptop</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="electronic_img"><img src="images/laptop-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Mobile</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="electronic_img"><img src="images/mobile-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Computers</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="electronic_img"><img src="images/computer-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div class="carousel-item">
               <div class="container">
                  <h1 class="fashion_taital">Electronic</h1>
                  <div class="fashion_section_2">
                     <div class="row">
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Laptop</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="electronic_img"><img src="images/laptop-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Mobile</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="electronic_img"><img src="images/mobile-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Computers</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="electronic_img"><img src="images/computer-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <a class="carousel-control-prev" href="#electronic_main_slider" role="button" data-slide="prev">
         <i class="fa fa-angle-left"></i>
         </a>
         <a class="carousel-control-next" href="#electronic_main_slider" role="button" data-slide="next">
         <i class="fa fa-angle-right"></i>
         </a>
      </div>
   </div> -->
	<!-- 
   electronic section end
   jewellery  section start
   <div class="jewellery_section">
      <div id="jewellery_main_slider" class="carousel slide" data-ride="carousel">
         <div class="carousel-inner">
            <div class="carousel-item active">
               <div class="container">
                  <h1 class="fashion_taital">Jewellery Accessories</h1>
                  <div class="fashion_section_2">
                     <div class="row">
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Jumkas</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="jewellery_img"><img src="images/jhumka-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Necklaces</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="jewellery_img"><img src="images/neklesh-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Kangans</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="jewellery_img"><img src="images/kangan-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div class="carousel-item">
               <div class="container">
                  <h1 class="fashion_taital">Jewellery Accessories</h1>
                  <div class="fashion_section_2">
                     <div class="row">
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Jumkas</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="jewellery_img"><img src="images/jhumka-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Necklaces</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="jewellery_img"><img src="images/neklesh-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Kangans</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="jewellery_img"><img src="images/kangan-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div class="carousel-item">
               <div class="container">
                  <h1 class="fashion_taital">Jewellery Accessories</h1>
                  <div class="fashion_section_2">
                     <div class="row">
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Jumkas</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="jewellery_img"><img src="images/jhumka-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Necklaces</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="jewellery_img"><img src="images/neklesh-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-4 col-sm-4">
                           <div class="box_main">
                              <h4 class="shirt_text">Kangans</h4>
                              <p class="price_text">Start Price  <span style="color: #262626;">$ 100</span></p>
                              <div class="jewellery_img"><img src="images/kangan-img.png"></div>
                              <div class="btn_main">
                                 <div class="buy_bt"><a href="#">Buy Now</a></div>
                                 <div class="seemore_bt"><a href="#">See More</a></div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <a class="carousel-control-prev" href="#jewellery_main_slider" role="button" data-slide="prev">
         <i class="fa fa-angle-left"></i>
         </a>
         <a class="carousel-control-next" href="#jewellery_main_slider" role="button" data-slide="next">
         <i class="fa fa-angle-right"></i>
         </a>
         <div class="loader_main">
            <div class="loader"></div>
         </div>
      </div>
   </div>
   jewellery  section end
   footer section start
   <div class="footer_section layout_padding">
      <div class="container">
         <div class="footer_logo"><a href="index.html"><img src="images/footer-logo.png"></a></div>
         <div class="input_bt">
            <input type="text" class="mail_bt" placeholder="Your Email" name="Your Email">
            <span class="subscribe_bt" id="basic-addon2"><a href="#">Subscribe</a></span>
         </div>
         <div class="footer_menu">
            <ul>
               <li><a href="#">Best Sellers</a></li>
               <li><a href="#">Gift Ideas</a></li>
               <li><a href="#">New Releases</a></li>
               <li><a href="#">Today's Deals</a></li>
               <li><a href="#">Customer Service</a></li>
            </ul>
         </div>
         <div class="location_main">Help Line  Number : <a href="#">+1 1800 1200 1200</a></div>
      </div>
   </div>
   footer section end -->


	<!-- copyright section start -->
	<footer>
		<div class="copyright_section">
			<div class="container2">
				<div class="footer4"></div>
				<div class="footer1">
					㈜ 인크레파스 사업자등록번호:119-86-82595본관 : 서울특별시 관악구 시흥대로 552 석천빌딩 7F<br>
					개인정보책임자:이정빈 | 대표자:오경주<br> 고객센터 : 02-869-1080~1<br>
					인재추천/산학협력/직업능력훈련시설(직업전문학교, 학원 관련) : 02-869-1080<br>
				</div>

				<div class="footer2">
					인크레파스는 고용노동부 지정 직업능력개발 훈련시설로서, 그리고 최고의 개발자 배움터 학원(學院)으로서, 또한 직업훈련을
					하는 학교(學校)로서의 역할을 다하겠습니다.<br> - 인크레파스는 IT교육센터(IT학원)입니다. IT에
					포함되는 소프트웨어 개발, 사물인터넷 서비스 & 플랫폼 개발, 빅데이터 개발 교육을 제공합니다.<br> -
					프로그래밍교육센터(프로그래밍학원)입니다. 자바, JSP, 스프링 뿐만 아닌 프로그래밍 전반을 배우고 학습할 수 있습니다.<br>
					- 빅데이터교육센터(빅데이터학원)입니다. 빅데이터 뿐만 아니라 자바웹개발, 인공지능, 사물인터넷(IoT), 클라우딩컴퓨팅
					교육을 진행합니다.<br> - 국비지원 컴퓨터교육센터(국비지원 컴퓨터학원)입니다. 컴퓨터공학 중에서도
					소프트웨어공학 중심 교육을 제공합니다.<br> - 내일배움카드교육센터(내일배움카드학원)입니다. 내일배움카드를
					통해 국비교육을 받을 수 있습니다.<br> - 취업성공패키지교육센터(취업성공패키지학원)입니다. 취업성공패키지를
					참여하시고 국비지원 교육 받으시길 바랍니다<br> - 인크레파스는 취업교육센터(취업학원)입니다. 개발자로 취업을
					꿈꾸시는 분께서는 인크레파스에서 개발자 취업성공하세요!<br>
				</div>
				<div class="footer4"></div>
			</div>
			<div class="footer3">Copyright 2018 INCREPAS reserved.</div>
		</div>
		<!-- copyright section end -->
	</footer>

	<!-- Javascript files-->
	<script src="../js/product/jquery.min.js"></script>
	<!-- <script src="js/popper.min.js"></script> -->
	<script src="../js/product/bootstrap.bundle.min.js"></script>
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