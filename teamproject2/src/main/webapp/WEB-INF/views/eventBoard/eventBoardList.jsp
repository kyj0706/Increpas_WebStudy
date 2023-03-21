<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link href="css/list.css" rel="stylesheet">

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
			
<script src="./js/list.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function write_btn(){

	  location.href="eventBoardWrite?category=${param.category}";
	}
</script>
<style type="text/css">
.list_title_a{
	color:black;

}
.table_category{
	border: 4px solid #ff8595;
	border-radius: 10px;
	color: #ff8595;
	font-weight: bold;
	font-size:20px;
}
#event{
	background-color: #f3f0ff;
}
#ul_nav li:first-of-type {
  background-color: white;
}
.event_status{
	background-color:  skyblue;
	border-radius: 10px;
	padding:5px;
	font-size: 15px;
	color: white;
	font-weight: bold;
}
.event_date{
	font-size: 15px;
	color: #e55c79;
}

#event_list {
	text-align: center;
	list-style: none;
}

#event_list>li {
	display: inline-block;
	padding: 2px;
}
#event_nav #li_on {
	z-index: 2;
    background: #242424;
    color: #fff;
    font-weight: bold;
    font-size: 20px;
    padding: 10px;
}

/* 선택 베너 */
#event_nav {
	background: #fbfbfb;
	padding: 10px;
	margin: 10px 0;
	border: 1px solid #f8f8f8;
}

#event_nav a {
	display: block;
	line-height: 30px;
	padding: 0 15px;
	font-size: 14px;
	border-radius: 3px;
	border: 1px solid transparent;
	font-weight: bold;
	color: black;
}

#event_nav a:hover, #event_cate a:active {
	text-decoration: none;
	border: 1px solid #999;
}

/* 이벤트 베너 */

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
	<div id="div">
		<jsp:include page="../include/header.jsp"></jsp:include>
		<div id="body_div">
				<div id="body_nav">
					<div id="div_nav">
					<jsp:include page="../include/nav.jsp"/>
						
						
					</div>
				</div>
				
				<div id = "event_nav">
					<ul id = "event_list">
						<li class = "eventList"><a href = "eventBoardList?category=1" <c:if test="${(param.category == '1') || (param.category == null) || (param.category == '')}">id = "li_on"</c:if>>진행중인 이벤트</a></li>
						<li class = "eventList"><a href = "eventBoardList?category=2" <c:if test="${param.category == '2'}">id = "li_on"</c:if>>종료된 이벤트</a></li>
					</ul>
				</div>

<!-- 이벤트 페이지 시작 -->
			<section class="recent-blog-area section-gap">
				<div class="container">
					<div class="row d-flex justify-content-center">
						<div class="menu-content pb-60 col-lg-9">
							<div class="title text-center">
							</div>
						</div>
					</div>							
					<div class="row">
						<div class="active-recent-blog-carusel">
						<c:forEach items="${map.list }" var = "eventBoardVo">
							<div class="single-recent-blog-post item">
								<div class="thumb">
									<img class="thumb_img" src="event/${eventBoardVo.img_name }" alt="">
								</div>
								<div class="details">
									<div class="tags">
									</div>
									<a href="eventBoardView?eb_num=${eventBoardVo.eb_num }&category=${param.category}"><h4 class="title">[${eventBoardVo.finfo_name}]${eventBoardVo.eb_title }</h4>
									</a>
									<h6 class="date">이벤트 기간 [${eventBoardVo.eb_start_date }~${eventBoardVo.eb_end_date }]</h6>
									<p class = "eb_content_p">
									<c:if test="${(param.category == '1') || (param.category == null) || (param.category == '')}">
										<span class = "event_status">이벤트 진행중</span>
									</c:if>
									<c:if test="${param.category == 2 }">
										<span class = "event_status">이벤트 종료</span>
									</c:if>
									</p>
								</div>	
							</div>
						</c:forEach>
																	

						</div>
					</div>
				</div>	
			</section>
			<!-- 이벤트 페이지 끝 -->	
						
				<%-- <div id="body_list">
					<table id="list_table">

						<colgroup>
							<col width="10%">
							<col width="50%">
							<col width="10%">
							<col width="15%">
							<col width="15%">
						  </colgroup>

						<!-- 제목부분 -->
							<tr class="list_tr_td" id="list_tr">
							  <td>No</td>
							  <td>제목</td>
							  <td>작성자</td>
							  <td>이벤트 기간</td>
							  <td>조회수</td>
							</tr>
						<!-- 내용부분 -->
						<c:forEach items="${map.list }" var = "eventBoardVo">
							<tr class="list_tr_td">
							  <td><span class="table-notice">${eventBoardVo.eb_num }</span></td>
							  <td class="table-title" style="text-align: left;">
							  <a class = "list_title_a"href="eventBoardView?eb_num=${eventBoardVo.eb_num }&page=${map.page }&searchCategory=${map.searchCategory}&sportsCategory=${map.sportsCategory }&searchWord=${map.searchWord}">
							  ${eventBoardVo.eb_title }
									<c:if test="${eventBoardVo.eb_status == 0 }">
										<span class = "event_status">이벤트 예정</span>
									</c:if>
									<c:if test="${eventBoardVo.eb_status == 1 }">
										<span class = "event_status">이벤트 진행중</span>
									</c:if>
									<c:if test="${eventBoardVo.eb_status == 2 }">
										<span class = "event_status">이벤트 종료</span>
									</c:if>
							  </a>
							  </td>
							  <td>관리자</td>
							  <td>${eventBoardVo.eb_start_date}~${eventBoardVo.eb_end_date }</td>
							  <td>${eventBoardVo.eb_hit }</td>
							</tr>
						</c:forEach>

					  </table>
				</div> --%>
		</div>
		<div id="footer_div">
			<!-- 하단 푸터 부분 시작 -->
			<jsp:include page="../include/boardFooter.jsp"></jsp:include>			
			<!-- 하단 푸터 부분 끝 -->
		</div>
	</div>
	
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
