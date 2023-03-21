<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
function freeBoardModify(){
	$("#modifyForm").submit();
	
}
function returnFreeBoardView(){
	location.href = "eventBoardView?eb_num=${param.eb_num}&page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
}

</script>
<script type="text/javascript">
	$(function(){
	 <c:forEach items="${map.imgList }" var = "file">
		$("#${file.img_no}").change(function(){
			$(this).show();
			$("#span${file.img_no}").hide();
			$("#label${file.img_no}").hide();
		});
	</c:forEach> 
	
		
	});
</script>
<style type="text/css">
.file_class{
		margin-top: 250px;
	}
	.fileModify{
		border: 3px solid #ff8595;
    color: #ff8595;
    border-radius: 10px;
    margin-top: 10px;
	}
	.fileModify:hover {
		cursor: pointer;
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
						  <h1>이벤트게시판 글수정</h1>
						  <hr style="  border: 2px solid gray;">
						  <form class="" action="eventBoardModify" method="post" id = "modifyForm" enctype="multipart/form-data">
						  <input type = "hidden" name = "eb_num" value = "${param.eb_num }">
							  <div  id="write_name" class="write_class">
							  <label for="input_title" class="write_label">제목</label><br>
							  <input type="text" id="input_title" class="input_class" name="eb_title" value="${map.eventBoardrVo.eb_title}" >
							  </div>
							  <div  id="write_name" class="write_class">
							  <label for="input_date" class="write_label">이벤트 기간</label><br>
							  <input type="date" id="input_date" name="eb_start_date" value="${map.eventBoardrVo.eb_start_date }" placeholder="제목을 입력해주세요">~
  						  <input type="date" id="input_date" name="eb_end_date" value="${map.eventBoardrVo.eb_end_date }" placeholder="제목을 입력해주세요">
							  </div>
				  
							  <div class="write_class">
								<label for="input_name" class="write_label">작성자</label><br>
								<input type="text" id="input_name" class="input_class" name="a_id" value="${map.eventBoardrVo.fm_id}">
							  </div>
				  
							  <div class="write_class" id="content_div">
								<label for="fbm_content" class="write_label">내용</label><br>
								<textarea name="eb_content" cols="80" id="input_content" placeholder="" >${map.eventBoardrVo.eb_content }</textarea>
							  </div>
							  <div class="file_class" id = "file_block">
								<label for="f_content" class="write_label">파일</label><br>
								<c:if test="${fn:length(map.imgList) != 0 }">
									<c:forEach items="${map.imgList }" var = "file">
										<input type = "file" name = "files" id = "${file.img_no}" style="display: none"><label for = "${file.img_no }" class = "fileModify" id = "label${file.img_no }">파일수정</label><span id = "span${file.img_no}">${file.img_name }</span><br>
									</c:forEach>
							</c:if>
							  </div>
							</form>
						</div>
	
					</article>
				</div>
				<div id="footer_div_btn">
					<button type="button" class="btn btn-outline-secondary" id="btn_save" onclick = "freeBoardModify()">수정</button>
					<button type="button" class="btn btn-outline-secondary" id="btn_cancle" onclick = "returnFreeBoardView()">취소</button>
				</div>
		</div>
		<div id="footer_div">
			<!-- 하단 푸터 부분 시작 -->
			<jsp:include page="../include/boardFooter.jsp"></jsp:include>			
			<!-- 하단 푸터 부분 끝 -->
		</div>
</body>
</html>
