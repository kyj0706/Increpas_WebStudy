<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link href="css/write.css" rel="stylesheet">
<script src="./js/list.js"></script>
</head>
<body>
	<div id="div">
		<div id="header_div">
			<div id="header_img">
				<h1 style="color: white; font-size: 50px; margin-left: 100px; padding-top: 10px;">노리</h1>
			</div>
		</div>
		<div id="body_div">
				<div id="body_nav">
					<div id="div_nav">
						<ul id="ul_nav">
							<li><a href="">자유 게시판</a></li>
							<li><a href="">노리 게시판</a></li>
							<li><a href="">공지사항</a></li>
							<li><a href="">문의사항</a></li>
						</ul>
					</div>
				</div>
				<div id="body_list">
					<article >
						<div id="write_div">
						  <h1>자유게시판 글쓰기</h1>
						  <hr style="  border: 2px solid gray";>
						  <form class="" action="index.html" method="post">
							  <div  id="write_name" class="write_class">
							  <label for="input_title" class="write_label">제목</label><br>
							  <input type="text" id="input_title" class="input_class" name="" value="" placeholder="제목을 입력해주세요">
							  </div>
				  
							  <div class="write_class">
								<label for="input_name" class="write_label">작성자</label><br>
								<input type="text" id="input_name" class="input_class" name="" value="" placeholder="이름을 입력해주세요">
							  </div>
				  
							  <div class="write_class" id="content_div">
								<label for="input_content" class="write_label">내용</label><br>
								<textarea name="name" cols="80" id="input_content" placeholder="내용을 입력해주세요"></textarea>
							  </div>
							  
							</form>
						</div>
	
					</article>
				</div>
				<div id="footer_div_btn">
					<button type="button" class="btn btn-outline-secondary" id="btn_list">목록</button>
					<button type="button" class="btn btn-outline-secondary" id="btn_save">저장</button>
					<button type="button" class="btn btn-outline-secondary" id="btn_cancle">취소</button>
				</div>
		</div>
		<div id="footer_div">

		</div>
	</div>
</body>
</html>
