<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link href="css/view1.css" rel="stylesheet">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function write_btn(){

	  location.href="noticeBoardWrite?page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
	}
	
function returnEventBoardList(){
	if(${session_member == 'member'}){
		location.href="member_qua";
		
	}else if(${session_member == 'admin'}){
		location.href = "askboard_list";
	}else if(${session_member == 'seller'}){
		location.href = "fac_qna";
	}
}
function replyView(){
		location.href = "qBoardReply?q_num=${param.q_num}"
}
</script>
<style type="text/css">
	.comment_fix{
		color: black;
		text-decoration: none;
	}
	.comment_fix:hover{
		cursor: pointer;
	}
	.commentCount{
		font-weight: bold;
	}
	.view_img{
		text-align: center;
	}
	.img{
		display: inline-block;
	}
	.q_span{
		color:skyblue;
		font-size:55px;
	}
	#body_view_content {
    width: 90%;
    height: 70%;
    min-height: 350px;
    font-size: 25px;
}
#body_view_body {
    width: 90%;
    height: 42%;
    min-height: 400px;
    border-bottom: 2px solid #eeeeee;
    border-top:none;
    margin: auto;
}
#logo{
		padding: 30px;
	}
	
</style>
</head>
<body>
	<div id="div">
		<div id="header_div">
			<div id="header_img">
				<div id="logo">
					<a href="main"><img src="img/logo.png" alt="" title="" /></a>
				</div>
			</div>
		</div>
		<div id="body_div">
			<!--  게시판 뷰 버튼 부분   -->
			<div id="body_view_header_btn">
				<button type="button" class="btn btn-outline-secondary" id="btn_list" onclick = "returnEventBoardList()">목록</button>
			</div>
			<!--  게시판 뷰 버튼 부분   -->
			<!--  게시판 뷰 부분   -->
			<div id="body_view_div">
		<!--  게시판 뷰 타이틀 부분   -->
				<div id="body_view_header">
					<div id="body_view_header1">
						<div>
							<div id="body_view_title">
								<h1><span class = "q_span">Q.</span>${map.qBoardVo.q_title }</h1>
							</div>
							<div id="body_view_inform">
								<div id="body_view_inform_div1">
									<div id="body_view_inform_nickname">
									</div>
									<div id="body_view_inform_date">
									</div>
								</div>
								<div id="body_view_inform_comment">
								</div>
							</div>
						</div>
					</div>
				</div>
		<!--  게시판 뷰 타이틀 부분   -->
		<!--  게시판 뷰 몸통 부분   -->
				<div id="body_view_body">	
					<div id="body_view_body1">
						<div id="body_view_content">
							${map.qBoardVo.q_content}
						</div>
						<div id="body_view_comment">
							<div id="body_view_comment1">
							</div>
						</div>
					</div>
				</div>
		<c:if test="${map.replyVo != null }">
				<div id="body_view_header">
					<div id="body_view_header1">
						<div>
							<div id="body_view_title">
								<h1><span class = "q_span">A.</span>${map.replyVo.r_title }</h1>
							</div>
							<div id="body_view_inform">
								<div id="body_view_inform_div1">
									<div id="body_view_inform_nickname">
									</div>
									<div id="body_view_inform_date">
									</div>
								</div>
								<div id="body_view_inform_comment">
								</div>
							</div>
						</div>
					</div>
				</div>
		<!--  게시판 뷰 타이틀 부분   -->
		<!--  게시판 뷰 몸통 부분   -->
				<div id="body_view_body">	
					<div id="body_view_body1">
						<div id="body_view_content">
							${map.replyVo.r_content}
						</div>
						<div id="body_view_comment">
							<div id="body_view_comment1">
							</div>
						</div>
					</div>
				</div>
		</c:if>
		<!--  게시판 뷰 몸통 부분   -->
		<!--  게시판 뷰 다리 부분   -->
				
		<!--  게시판 뷰 다리 부분   -->
			</div>	
		
		<!--  게시판 뷰 버튼 부분   -->
		<div id="body_view_bottom_btn">
			<div id="body_view_bottom_btn1">
				<div id="body_view_bottom_btn_left">
				</div>
					<div id="body_view_bottom_btn_right">
					<c:if test="${(session_member == 'admin') && (map.qBoardVo.q_status == '0') }">
						<button type="button" class="btn btn-outline-secondary" id="btn_modify" onclick = "replyView()">답변달기</button>
					</c:if>
					</div>
			</div>
			
		</div>
		
		<!--  게시판 뷰 버튼 부분   -->
		</div>
		<div id="footer_div">
			<!-- 하단 푸터 부분 시작 -->
			<jsp:include page="../include/boardFooter.jsp"></jsp:include>			
			<!-- 하단 푸터 부분 끝 -->
		</div>
	</div>
</body>
</html>
