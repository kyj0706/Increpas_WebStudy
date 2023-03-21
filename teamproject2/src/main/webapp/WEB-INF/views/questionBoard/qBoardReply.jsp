<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="css/write.css" rel="stylesheet">
<script src="./js/list.js"></script>
<script type="text/javascript">

function returnFreeBoardList(){
	location.href = "freeBoardSellerList?page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
}
function qBoardWrite(){
	$("#qForm").submit();
}
</script>
<style type="text/css">
	.file_class{
		margin-top: 250px;
	}
	.file_btn{
		background-color: white;
		border-radius: 10px;
		border: 2px solid #ff8595;
		color: #ff8595;
		
	}
	.category{
		background-color: skyblue;
		color: white;
		border-radius: 5px;
		font-size:20px;
		border:none;
		font-weight: bold;
		padding:5px;
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
		<!-- <div id="body_div">
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
		 -->		<div id="body_list">
					<article >
						<div id="write_div">
						  <h1>답변달기</h1>
						  <hr style="  border: 2px solid gray;">
						  <form class="" action="qBoardReply" method="post" enctype="multipart/form-data" id = "qForm">
						  <input type = "hidden" name = "q_num" value = "${qVo.q_num }">
						  <input type = "hidden">
							  <div  id="write_category" class="write_class">
							  <label for="input_title" class="write_label">문의종류</label><br>
								  <span class = "category">${qVo.q_category }</span>
							  </div>
							  <div  id="write_name" class="write_class">
							  <label for="input_title" class="write_label">답변제목</label><br>
							  <input type="text" id="input_title" class="input_class" name="r_title" value="${qVo.q_title }" placeholder="제목을 입력해주세요" readonly>
							  </div>
							  <div class="write_class" id="content_div">
								<label for="fbs_content" class="write_label">답변내용</label><br>
								<textarea name="r_content" cols="80" id="input_content" placeholder="내용을 입력해주세요" ></textarea>
							  </div>
							  
							  
							</form>
						</div>
	
					</article>
				</div>
				<div id="footer_div_btn" style="margin-top: 20%;">
					<button type="button" class="btn btn-outline-secondary" id="btn_save" onclick = "qBoardWrite()" >저장</button>
					<button type="button" class="btn btn-outline-secondary" id="btn_cancle" onclick = "returnFreeBoardList()">취소</button>
				</div>
		</div>
		<div id="footer_div">
			<!-- 하단 푸터 부분 시작 -->
			<jsp:include page="../include/boardFooter.jsp"></jsp:include>			
			<!-- 하단 푸터 부분 끝 -->
		</div>
</body>
</html>
