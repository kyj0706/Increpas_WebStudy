<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

function returnQnaBoardList(){
	location.href = "qnaBoardList?page=${param.page }&category=${param.category}";
}
function qnaBoardModify(){
	 $.ajax({
         url: "/qnaBoardModify",
         type: "post",
         data:{
         	"qb_num":${param.qb_num},
         	"qb_title":$("#input_title").val(),
         	"qb_content":$("#input_content").val(),
         	"qb_category":$("#qb_category").val()
         	},
         success: function(data){
         	location.href = "qnaBoardList?page=${param.page }&category=${param.category}";
         },
         error: function(){
            alert("수정 실패");
         }
     }); 
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
						  <h1>자주묻는 질문 수정</h1>
						  <hr style="  border: 2px solid gray;">
						  <form class="" action="qnaBoardWrite" method="post" enctype="multipart/form-data" id = "sellerForm">
							  <div  id="write_category" class="write_class">
							  
							  <label for="input_title" class="write_label">목록</label><br>
								  <select name = "qb_category" id = "qb_category">
								  	<option value = "결제" <c:if test="${qnaBoardVo.qb_category == '결제'}">selected</c:if>>결제</option>
								  	<option value = "예약"<c:if test="${qnaBoardVo.qb_category == '예약'}">selected</c:if>>예약</option>
								  	<option value = "기타"<c:if test="${qnaBoardVo.qb_category == '기타'}">selected</c:if>>기타</option>
								  </select>
							  </div>
							  <div  id="write_name" class="write_class">
							  <label for="input_title" class="write_label">제목</label><br>
							  <input type="text" id="input_title" class="input_class" name="qb_title" value="${qnaBoardVo.qb_title }" placeholder="제목을 입력해주세요">
							  </div>
							  <div class="write_class" id="content_div">
								<label for="fbs_content" class="write_label">내용</label><br>
								<textarea name="qb_content" cols="80" id="input_content" placeholder="내용을 입력해주세요" >${qnaBoardVo.qb_content }</textarea>
							  </div>
							  
							</form>
						</div>
	
					</article>
				</div>
				<div id="footer_div_btn">
					<button type="button" class="btn btn-outline-secondary" id="btn_save" onclick = "qnaBoardModify()" >저장</button>
					<button type="button" class="btn btn-outline-secondary" id="btn_cancle" onclick = "returnQnaBoardList()">취소</button>
				</div>
		</div>
		<div id="footer_div">
			<!-- 하단 푸터 부분 시작 -->
			<jsp:include page="../include/boardFooter.jsp"></jsp:include>			
			<!-- 하단 푸터 부분 끝 -->
		</div>
</body>
</html>
