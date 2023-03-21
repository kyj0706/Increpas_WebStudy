<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link href="css/view1.css" rel="stylesheet">

</head>
<body>
	<div id="div">
		<div id="header_div">
			<div id="header_img">
				<h1 style="color: white; font-size: 50px; margin-left: 100px; padding-top: 10px;">노리</h1>
			</div>
		</div>
		<div id="body_div">
			<!--  게시판 뷰 버튼 부분   -->
			<div id="body_view_header_btn">
				<button type="button" class="btn btn-outline-secondary" id="btn_next">다음글</button>
				<button type="button" class="btn btn-outline-secondary" id="btn_pre">이전글</button>
				<button type="button" class="btn btn-outline-secondary" id="btn_list">목록</button>
	
			</div>
			<!--  게시판 뷰 버튼 부분   -->
			<!--  게시판 뷰 부분   -->
			<div id="body_view_div">
		<!--  게시판 뷰 타이틀 부분   -->
				<div id="body_view_header">
					<div id="body_view_header1">
						<div>
							<div id="body_view_title">
								<span>게시판 이름</span>
								<h3>글의 제목이 들어갈자리</h3>
							</div>
							<div id="body_view_inform">
								<div id="body_view_inform_div1">
									<div id="body_view_inform_nickname">
										<span>닉네임자리</span>
									</div>
									<div id="body_view_inform_date">
										<span>2021.09.02</span>
										<span>조회수0</span>
									</div>
								</div>
								<div id="body_view_inform_comment">
									<span>댓글</span><span>0</span>
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
							It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
						</div>
						<div id="body_view_comment">
							<div id="body_view_comment1">

								<span>닉네임</span><span>님의 게시글 더보기</span>
								<br><br>
								<span>댓글</span><span>&nbsp0</span>
							</div>
						</div>
					</div>
				</div>
		<!--  게시판 뷰 몸통 부분   -->
		<!--  게시판 뷰 다리 부분   -->
				<div id="body_view_footer">
					<div id="body_view_footer1">
						<!-- 댓글 view-->
						<div id="body_footer_comment">
							<div>
								<h5>댓글</h5>
							</div>
							<div>
								<div id="body_footer_inform_div1">
									<div id="body_footer_inform_nickname">
										<span>닉네임자리(작성자)</span>
									</div>
									<div id="body_footer_inform_comment">
										<span>댓글내용들어갈자리</span>
									</div>
									<div id="body_footer_inform_date">
										<span>2021.09.02</span>
										<span>조회수0</span>
									</div>
									
									
								</div>
							</div>
						</div>
						<!-- 댓글 view-->
						<!-- 댓글 write-->
						<div id="body_footer_comment_write">
							<div id="body_footer_comment_nickname">
								<div id="body_footer_comment_nickname1">
									<span>닉네임자리(본인)</span><br>
									<input type="text" placeholder="댓글을 남겨보세요">
								</div>
								<div id="body_footer_comment_btn">
									<button type="button" class="btn btn-outline-secondary" id="body_footer_comment_click">검색</button>
								</div>
							</div>
						</div>
						<!-- 댓글 write-->
					</div>
				</div>
		<!--  게시판 뷰 다리 부분   -->
			</div>	
		
		<!--  게시판 뷰 버튼 부분   -->
		<div id="body_view_bottom_btn">
			<div id="body_view_bottom_btn1">
				<div id="body_view_bottom_btn_left">
					<button type="button" class="btn btn-outline-secondary" id="btn_write">글쓰기</button>
				</div>
				<div id="body_view_bottom_btn_right">
					<button type="button" class="btn btn-outline-secondary" id="btn_list1">목록</button>
					<button type="button" class="btn btn-outline-secondary" id="btn_up">TOP</button>
	
				</div>
			</div>
			
		</div>
		
		<!--  게시판 뷰 버튼 부분   -->
		</div>
		<div id="footer_div">

		</div>
	</div>
</body>
</html>
