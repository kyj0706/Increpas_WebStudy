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

	  location.href="eventBoardWrite?page=${param.page }&category=${param.category}";
	}
	
function returnEventBoardList(){
	location.href="eventBoardList?category=${param.category}";
}
function nextView(){
	location.href = "eventBoardView?eb_num=${map.nextView.eb_num}&category=${param.category}";
}
function preView(){
	location.href = "eventBoardView?eb_num=${map.preView.eb_num}&category=${param.category}";
	
}
function deleteView(){
	if(confirm("정말로 삭제하시겠습니까?")==true){
		 $.ajax({
             url: "/eventBoardDelete",
             type: "post",
             data:{
             	"eb_num":${param.eb_num}
             	},
             success: function(data){
             	location.href = "eventBoardList?category=${param.category}";
             },
             error: function(){
                alert("삭제 실패");
             }
         }); 
	
	}
}
function modifyView(){
		location.href = "eventBoardModifyView?eb_num=${param.eb_num}&category=${param.category}";
	
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
	#img_style{
		width: 1280px;
		height: 960px;
	}
	.event_status{
background-color:  skyblue;
	border-radius: 10px;
	padding:5px;
	font-size: 15px;
	color: white;
	font-weight: bold;
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
			<c:if test="${map.nextView.eb_num != null }">
				<button type="button" class="btn btn-outline-secondary" id="btn_next" onclick = "nextView()">다음글</button>
			</c:if>
			<c:if test="${map.preView.eb_num != null }">
				<button type="button" class="btn btn-outline-secondary" id="btn_pre" onclick = "preView()">이전글</button>
			</c:if>
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
								<span>이벤트게시판</span>
								<h3>[${map.eventBoardVo.finfo_name }]${map.eventBoardVo.eb_title }
								</h3>
							</div>
							<div id="body_view_inform">
								<div id="body_view_inform_div1">
									<div id="body_view_inform_nickname">
										<span>${map.eventBoardVo.fm_name}</span>
									</div>
									<div id="body_view_inform_date">
										<span>기간[${map.eventBoardVo.eb_start_date}~${map.eventBoardVo.eb_end_date }]</span>
										<span>조회${map.eventBoardVo.eb_hit }</span>
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
							${map.eventBoardVo.eb_content}
							<c:if test="${fn:length(map.imgList) != 0 }">
								<c:forEach items="${map.imgList }" var = "file">
									<div class = "view_img">
										<div class = "img">
											<img id="img_style" src="/event/${file.img_name }">
										</div>
									</div>
								</c:forEach>
							</c:if>
						</div>
						<div id="body_view_comment">
							<div id="body_view_comment1">
							</div>
						</div>
					</div>
				</div>
		<!--  게시판 뷰 몸통 부분   -->
		<!--  게시판 뷰 다리 부분   -->
				
		<!--  게시판 뷰 다리 부분   -->
			</div>	
		
		<!--  게시판 뷰 버튼 부분   -->
		<div id="body_view_bottom_btn">
			<div id="body_view_bottom_btn1">
				<c:if test="${session_id == map.eventBoardVo.fm_id}">
				<div id="body_view_bottom_btn_left">
					<button type="button" class="btn btn-outline-secondary" id="btn_write" onclick = "write_btn()">글쓰기</button>
				</div>
					<div id="body_view_bottom_btn_right">
						<button type="button" class="btn btn-outline-secondary" id="btn_modify" onclick = "modifyView()">수정</button>
						<button type="button" class="btn btn-outline-secondary" id="btn_delete" onclick = "deleteView()">삭제</button>
					</div>
				</c:if>
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
