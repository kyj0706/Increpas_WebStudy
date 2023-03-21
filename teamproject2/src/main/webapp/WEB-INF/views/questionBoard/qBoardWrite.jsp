<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	location.href = "qnaBoardList";
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
						  <h1>문의하기</h1>
						  <hr style="  border: 2px solid gray;">
						  <form class="" action="qBoardWrite" method="post" enctype="multipart/form-data" id = "qForm">
						   <input type = "hidden" name = "member_id" value = "${session_id }">
							  <div  id="write_category" class="write_class">
							  <label for="input_title" class="write_label">문의목록</label><br>
								  <select name = "q_category" id = "fbs_category" style="padding-right: 1px;">
								  	<option value = "결제문의">결제문의</option>
								  	<option value = "예약문의">예약문의</option>
								  	<option value = "기타문의">기타문의</option>
								  </select>
							  </div>
							  <div  id="write_name" class="write_class">
							  <label for="input_title" class="write_label">문의제목</label><br>
							  <input type="text" id="input_title" class="input_class" name="q_title" value="" placeholder="제목을 입력해주세요">
							  </div>
							  <div class="write_class" id="content_div">
								<label for="fbs_content" class="write_label">문의내용</label><br>
								<textarea name="q_content" cols="80" id="input_content" placeholder="내용을 입력해주세요" ></textarea>
							  </div>
							</form>
						</div>
					</article>
				</div>
				
				<div id="footer_div_btn" style="margin-top: 20%;">
					<button type="button" class="btn btn-outline-secondary" id="btn_save" onclick = "qBoardWrite()" >문의</button>
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
