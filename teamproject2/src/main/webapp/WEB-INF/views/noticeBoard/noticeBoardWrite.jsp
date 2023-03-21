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

function returnEventBoardList(){
	location.href = "noticeBoardList?page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
}
function addFileInput(){
	var fileLength = $("input[name=files]").length;
	++fileLength;
	var fileHtml = '';
	fileHtml += '<input type = "file" name = "files" id = "files'+fileLength+'">';
	
	$("#file_block").append(fileHtml);
}
function removeFileInput(){
	var fileLength = $("input[name=files]").length;
	$("#files"+fileLength).remove();
}
function writeEventBoard(){
	$("#eventForm").submit();
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
	#footer_div_btn {
    width: 90%;
    height: auto;
    margin: auto;
    margin-top: 300px;
    text-align: right;
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
						  <h1>공지사항 쓰기</h1>
						  <hr style="  border: 2px solid gray;">
						  <form class="" action="noticeBoardWrite" method="post" enctype="multipart/form-data" id = "eventForm">
							  <div  id="write_name" class="write_class">
							  <label for="input_title" class="write_label">제목</label><br>
							  <input type="text" id="input_title" class="input_class" name="n_title" value="" placeholder="제목을 입력해주세요">
							  </div>
				  
							  <div class="write_class">
								<label for="input_name" class="write_label">작성자</label><br>
								<input type="text" id="a_id" class="input_class" name="a_id" value="${session_id }" readonly="readonly">
							  </div>
				  
							  <div class="write_class" id="content_div">
								<label for="n_content" class="write_label">내용</label><br>
								<textarea name="n_content" cols="80" id="input_content" placeholder="내용을 입력해주세요" ></textarea>
							  </div>
							  
							  <div class="file_class" id = "file_block">
								<label for="f_content" class="write_label">파일</label><br>
									<button class = "file_btn" type = "button" onclick = "addFileInput()">파일추가</button>
									<button class = "file_btn" type = "button" onclick = "removeFileInput()">파일삭제</button><br><br>
							  </div>
							  
							</form>
						</div>
	
					</article>
				</div>
				<div id="footer_div_btn">
					<button type="button" class="btn btn-outline-secondary" id="btn_save" onclick = "writeEventBoard()" >저장</button>
					<button type="button" class="btn btn-outline-secondary" id="btn_cancle" onclick = "returnEventBoardList()">취소</button>
				</div>
		</div>
		<div id="footer_div">
			<!-- 하단 푸터 부분 시작 -->
			<jsp:include page="../include/boardFooter.jsp"></jsp:include>			
			<!-- 하단 푸터 부분 끝 -->
		</div>
</body>
</html>
